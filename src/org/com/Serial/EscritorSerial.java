package org.com.Serial;
import java.io.*;
import java.util.*;
import gnu.io.*;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.com.logica.Controlador;


/**
 *
 * @author Jherson
 */
public class EscritorSerial extends Thread{
   private static Enumeration ports;
   private static CommPortIdentifier pID;
   private static OutputStream outStream;
   private static SerialPort serPort;
    
    private static  void iniciar_escritor () throws Exception{
        serPort = (SerialPort)pID.open("PortWriter",2000);
        outStream = serPort.getOutputStream();
        serPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
        SerialPort.STOPBITS_1,
        SerialPort.PARITY_NONE);
    }  
    
    
    public static void escribir_en_serial(String men){
        try {
            
            Controlador.detener_puerto_escuchando();
            
            ports = CommPortIdentifier.getPortIdentifiers();
            
            while (ports.hasMoreElements()) {
                pID = (CommPortIdentifier) ports.nextElement();
                if (pID.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    //if (pID.getName().equals(Controlador.cod_puerto)) {
                   if (pID.getName().equals("COM8")) {
                        
                        try {
                            //aqui es el puerto que se reconocio
                            //if (portId.getName().equals("/dev/term/a")) {
                            iniciar_escritor();
                            break;
                        } catch (Exception ex) {
                            Logger.getLogger(EscritorSerial.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            outStream.write(men.getBytes());
            try {
                serPort.close();
                //sleep(500);
                //Controlador.iniciar_serial();
            } catch (Exception e) {
                System.out.println("Eror al cerrar le puerto: "+e.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void escribir_en_serial(int men){
        try {
            
            Controlador.detener_puerto_escuchando();
            
            ports = CommPortIdentifier.getPortIdentifiers();
            
            while (ports.hasMoreElements()) {
                pID = (CommPortIdentifier) ports.nextElement();
                if (pID.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    //if (pID.getName().equals(Controlador.cod_puerto)) {
                   if (pID.getName().equals("COM8")) {
                        
                        try {
                            //aqui es el puerto que se reconocio
                            //if (portId.getName().equals("/dev/term/a")) {
                            iniciar_escritor();
                            break;
                        } catch (Exception ex) {
                            Logger.getLogger(EscritorSerial.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            outStream.write(men);
            try {
                serPort.close();
                //sleep(500);
                //Controlador.iniciar_serial();
            } catch (Exception e) {
                System.out.println("Eror al cerrar le puerto: "+e.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
