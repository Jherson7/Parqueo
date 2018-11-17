package org.com.logica;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.com.Serial.EscritorSerial;
import org.com.Serial.last;
import org.com.bens.parqueo;
import org.com.bens.turno;
import org.com.bens.usuario;

public class Controlador {
    
    private static usuario usuario;
    private static parqueo parqueo;
    private static int turno;
    private static turno turno_actual =null;
    private static last serial = new last();
    private static Thread hora_fecha;    
    private static Thread scanner;
    public static boolean puerto;
    //public static  SerialPort serialPort;
    
    public static void iniciar_serial() {
        
        serial.initialize();
        Thread t = new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them
                //(printing incoming messages to console).
                try {

                    Thread.sleep(10000000);

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
        iniciar_serial();
        iniciar_hilo_hora_fecha();
        /// hilo que esta verificando que este bien el puerto serial
        scanner = new Thread(){
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fecha =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timestamp);
        EscritorSerial.escribir_en_serial(fecha);
        System.out.println(fecha);
        
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
}
