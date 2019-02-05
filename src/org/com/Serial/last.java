package org.com.Serial;

import  java.util.*;

/*public class test {

	public static void  main(String[] args) {
	Enumeration<CommPortIdentifier> ports 
	= CommPortIdentifier.getPortIdentifiers();
	while(ports.hasMoreElements()){
		CommPortIdentifier info = ports.nextElement();
		System.out.println("hi this answer  "+info.getName());
	}

	}

}*/
//import gnu.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.io.IOException;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import org.com.logica.Controlador;


public class last extends javax.swing.JFrame implements SerialPortEventListener  {
	SerialPort serialPort;
        int comando=230;
        /** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { 
			"COM3","COM6","COM8","COM9",Controlador.retornar_cod_puerto(),// Windows
	};
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results codepage independent
	*/
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	public void initialize() {
                // the next line is for Raspberry Pi and 
                // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
                
                CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
                        
                        Controlador.puerto=true;
                        
		} catch (Exception e) {
			System.err.println("Error iniciando"+e.toString());
                        Controlador.puerto=false;
		}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

        
	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		String codigo="";
                if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				codigo=input.readLine();
                                leer_del_puerto(codigo);
                                //String res = getRandomHexa();
				
                                System.out.println("Recibido: "+codigo);
			} catch (Exception e) {
				System.err.println("Hay error recibiendo: "+codigo+","+e.toString());
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}			}

        
        
        private void leer_del_puerto(String codigo) {
        if ("listo".equals(codigo)) {
            if (Controlador.getTurno_actual() != null) {
                impresion_de_ticket.insertar_y_obtener_codigo();
                escribir_en_serial(comando);//para que abra la puerta
            } else {
                JOptionPane.showMessageDialog(null, "No se ha aperturado turno, por favor aperture su turno para abrir paso", "ERROR", 0);
            }
        }
    }
        
        public void escribir_en_serial(String men){
            try {
                output.write(men.getBytes());
            } catch (IOException ex) {
                System.out.println("Erro al escribir el mensaje: "+men+", "+ex.getMessage());
            }
        }
        
        public void escribir_en_serial(int men){
            try {
                output.write(men);
            } catch (IOException ex) {
                System.out.println("Erro al escribir el mensaje: "+men+", "+ex.getMessage());
            }
        }

	/*public static void main(String[] args) throws Exception {
		last main = new last();
		main.initialize();
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
	}*/
        
    private String getRandomHexa(){
        String res="";
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int low = 0;
            int high = 15;
            int result = r.nextInt(high-low) + low; 
            switch (result) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    res+=String.valueOf(result);
                    break;
                case 10:
                    res+="A";
                    break;
                    case 11:
                    res+="B";
                    break;
                    case 12:
                    res+="C";
                    break;
                    case 13:
                    res+="D";
                    break;
                    case 14:
                    res+="E";
                    break;
                    case 15:
                    res+="F";
                    break;
            }
        }
        return res;
    }
    
}