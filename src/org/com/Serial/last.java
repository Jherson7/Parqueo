package org.com.Serial;

import gnu.io.*;
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
import java.util.Enumeration;
import org.com.logica.Cobro;
import org.com.logica.Controlador;


public class last extends javax.swing.JFrame implements SerialPortEventListener  {
	SerialPort serialPort;
        /** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { 
			"COM3","COM5", // Windows
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
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String codigo=input.readLine();
                                String res = getRandomHexa();
                                Cobro.insertar_ticket(res);
				System.out.println("Recibido: "+codigo+","+res);
			} catch (Exception e) {
				System.err.println("Hay error recibiendo "+e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
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