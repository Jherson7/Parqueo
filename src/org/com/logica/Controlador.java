package org.com.logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.com.Serial.EscritorSerial;
import org.com.Serial.impresion_de_ticket;
import org.com.Serial.last;
import org.com.bens.parqueo;
import org.com.bens.ticket;
import org.com.bens.turno;
import org.com.bens.usuario;
import org.com.db.cobro_db;

public class Controlador {
    
    private static usuario usuario;
    private static parqueo parqueo;
    private static int turno;
    private static turno turno_actual =null;
    private static last serial ;
    private static Thread hora_fecha;    
    private static Thread scanner;
    public static boolean puerto;
    private static String cod_puerto;
    //public static  SerialPort serialPort;
    static LinkedList<ticket> pendientes = new LinkedList<>();
    
    public static void iniciar_serial() {
        serial = new last();
        serial.initialize();
        Thread t = new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them
                //(printing incoming messages to console).
                try {

                    Thread.sleep(1000000000);

                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        };
        t.start();
        
        System.out.println("Started");
    }
    
    public static void detener_puerto_escuchando(){
        try {
            serial.close();
        } catch (Exception e) {
            System.out.println("Error al detener el puerto"+e.getMessage());
        }
    }
    
    public static  void iniciar_programa(){
        get_codigo_com();//metodo que obtiene el puerto com establecido
        iniciar_serial();
        iniciar_hilo_hora_fecha();   
        
        impresion_de_ticket.obtener_parametros_del_parqueo();
        
        scanner = new Thread(){/// hilo que esta verificando que este bien el puerto serial
            public void run(){
                while(true){
                    try {
                        Thread.sleep(10000);
                        if(!hora_fecha.isAlive()){
                            iniciar_hilo_hora_fecha();
                        }
                        if(!puerto){
                          System.out.println("No se ha detectado se;al de puerto");
                          iniciar_serial();
                        }
                          
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        };
        
        scanner.start();
    }
    
    private static void iniciar_hilo_hora_fecha(){
          hora_fecha = new Thread(){
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(29550);
                        Controlador.enviar_hora_fecha();
                    }
                } catch (InterruptedException ie) {
                    System.out.println("ERROR EN EL HILO DE FECHA hora: "+ie.getMessage());
                }
            }
        };
        hora_fecha.start();
        System.out.println("Se inicio el hilo para enviar la hora y la fecha");
    }
    
    private static void enviar_hora_fecha(){
        String fecha=get_fecha_actual();
        //EscritorSerial.escribir_en_serial(fecha);
        escribir_en_serial(fecha);
        System.out.println(fecha);
        
    }
    
    public static String get_fecha_actual(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timestamp);
        
    }
    
    public static void setUsuario(usuario usu)
    {
     usuario = usu;   
    }
    
    public static usuario getUsuarioActual(){
        return usuario;
    }

    public static parqueo getParqueo() {
        return parqueo;
    }

    public static void setParqueo(parqueo parqueo) {
        Controlador.parqueo = parqueo;
    }

    public static int getTurno() {
        return turno;
    }

    public static void setTurno(int turno) {
        Controlador.turno = turno;
    }

    public static turno getTurno_actual() {
        return turno_actual;
    }

    public static void setTurno_actual(turno turno_actual) {
        Controlador.turno_actual = turno_actual;
    }
    
    private static void get_codigo_com(){
        InputStream input = null;
        try {
            Properties prop = new Properties();
            input = new FileInputStream("src/db_properties.properties");
            prop.load(input);
            
            cod_puerto = prop.getProperty("com").trim();
            System.out.println("Codigo Recibido:>"+cod_puerto+"<");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void agregarTicketPendiente(String codigo){
        Timestamp actual = new Timestamp(System.currentTimeMillis());
        ticket nuevo = new ticket();
        nuevo.setCodigo(codigo);
        nuevo.setHora_ingreso(actual);
        pendientes.add(nuevo);
    }
    
    public static void insertar_tickets_pendientes(){
        cobro_db cobro = new cobro_db();
        for(ticket tick : pendientes){
            tick.setTurno(Controlador.getTurno_actual().getId_turno());
            cobro.insertar_ticket(tick);
        }
        pendientes.clear();//se limpian todos los tickets pendientes
    }
    
    
    public static void escribir_en_serial(String men){
        if(puerto)
            serial.escribir_en_serial(men);
        else
            JOptionPane.showMessageDialog(null, "Aun no se ha detectado señal del puerto serial","ERROR",0);
        
    }
    
    public static void escribir_en_serial(int men){
        if(puerto)
            serial.escribir_en_serial(men);
        else
            JOptionPane.showMessageDialog(null, "Aun no se ha detectado señal del puerto serial","ERROR",0);
        
    }
    
    public static String retornar_cod_puerto(){
        return cod_puerto;
    }
    
}
