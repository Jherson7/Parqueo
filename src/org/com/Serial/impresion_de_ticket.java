package org.com.Serial;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.com.db.cobro_db;
import org.com.logica.Cobro;
import org.com.logica.Controlador;

/**
 *
 * @author Jherson
 */
public class impresion_de_ticket {
    private static String encabezado;
    private static String footer;
    private static String direccion;
    private static String parqueo_nombre;
    private static String init_text;
    private static String fin_text;
    private static String init_code_bar;
    private static String fin_code_bar;
    private static String printer_cut;
    
    private static cobro_db cobro;
    private static int id_parqueo;
    
    private static int[] PrintCm = {0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01};
    private static int[] PirntEnd = {0x0a, 0x0a};
    private static int[] CodeBar = {0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x1b, 0x40, 0x1b, 0x32, 0x1d};
    private static int[] CodeBar2 = {0x68, 0x50, 0x1d, 0x48, 0x02, 0x0a, 0x0a, 0x1d, 0x6b, 0x06};
    private static int[] CodeBarEnd = {0x00, 0x0a, 0x0a, 0x0a};
    private static int[] PrintCut = {0x1b, 0x40, 0x0d, 0x0a, 0x0a, 0x0a, 0x1b, 0x6d};

    static int inicio_impresion = 225;
    static int fin_impresion = 231;
    static int numero_chars = 48;
            
    
    public static void obtener_parametros_del_parqueo(){
        encabezado      = Controlador.getParqueo().encabezado;
        footer          = Controlador.getParqueo().pie;
        direccion       = Controlador.getParqueo().getDireccion();
        parqueo_nombre  = Controlador.getParqueo().getNombre_parqueo();
        id_parqueo      = Controlador.getParqueo().getId_parqueo();
        
        init_text       = InitText();
        fin_text        = EndText();
        init_code_bar   = InitCodebar();
        fin_code_bar    = EndCodebar();
        printer_cut     = PrinterCut();
        
        cobro=new cobro_db();
    }
    
    private static void imprimir(String codigo){
        String mensaje = "TICKET DE CONTROL\n"
                   + ""+parqueo_nombre+"\n"
                   + ""+direccion+"\n"
                   + ""+get_fecha()+"  "+get_hora()+"\n\n"
                   + "Correlativo: "+codigo+"\n"
                   + ""+encabezado+"\n"
                   + "";
        
        
         try {
            
            String toSerial = init_text+
            centrar_texto(mensaje)+
            fin_text+
            init_code_bar+
            parsear_codigo(codigo,get_fecha_ticket())+
            fin_code_bar+
            init_text+
            centrar_texto(footer)+"\n"+
            fin_text+
            printer_cut;
            
            
            Controlador.escribir_en_serial(inicio_impresion);
            Controlador.escribir_en_serial(toSerial);
            Controlador.escribir_en_serial(fin_impresion);//para que se salga del modo impresion
        } catch (Exception e) {
        }
    }
    
    private static String parsear_codigo(String cod,String fecha){
        String codigo ="A";
        codigo += fecha.substring(0,fecha.lastIndexOf("/"))+"+";
        
        for (int i = cod.length(); i < 8; i++) {
            codigo+="0";
        }
        codigo+=cod+"A";
        
        return codigo;
    }
    
    public static String get_fecha() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(timestamp);

        return "FECHA:" + fecha;

    }
    
    public static String get_fecha_ticket() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(timestamp);

        return fecha;

    }
    private static String get_hora() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String hora = new SimpleDateFormat("HH:mm:ss").format(timestamp);

        return " HORA:" + hora;

    }
    private static String InitText() {
        String txt = "";
        for (int i = 0; i <= 14; i++) {
            
            txt += (char)PrintCm[i];
        }
        return txt;
    }

    private static String EndText() {
        String txt = ""+(char)0x0a+(char)0x0a;        
        return txt;
    }

    private static String InitCodebar() {
        String txt = "";
        for (int i = 0; i <= 19; i++) {
            txt += (char)CodeBar[i];
        }
        for (int i = 0; i <= 9; i++) {
            txt += (char)CodeBar2[i];
        }
        return txt;
    }

    private static String EndCodebar() {
        String txt = "";
        for (int i = 0; i <= 3; i++) {
            txt += (char)CodeBarEnd[i];
        }
        return txt;
    }

    private static String PrinterCut() {
        String txt = "";
        for (int i = 0; i <= 7; i++) {
            txt += (char)PrintCut[i];
        }
        return txt;
    }
    
    
    
    public static void insertar_y_obtener_codigo(){
        int id = cobro.insertar_y_obtener_ticket(id_parqueo);
        String cod = String.valueOf(id);
        Cobro.insertar_ticket(cod);
        imprimir(cod);
    }

    private static String centrar_texto(String mensaje) {
        String arreglo[]=mensaje.split("\n");
        String res="";
        for(String r:arreglo){
            int tam=r.length();
            int espacios = (48-tam)/2;
            String no_espacios="";
            for(;espacios>0;espacios--){
                no_espacios+=" ";
            }
            res+=no_espacios+r+"\n";
        }
        
        return res;
    }
}
