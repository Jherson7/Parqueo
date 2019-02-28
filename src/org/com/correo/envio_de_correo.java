package org.com.correo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.com.bens.reporte_hora_fecha_beans;
import org.com.db.reportes_db;
import org.com.logica.Controlador;

/**
 *
 * @author Jherson
 */
public class envio_de_correo  extends TimerTask{

   
    public void enviar_reporte() {
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Controlador.usuario_email, Controlador.contraseña);
            }
        });

        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Controlador.usuario_email)); // same email id
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(Controlador.destinatario));//Destinatario del correo
            message.setSubject("REPORTE");
            message.setText(get_reporte_html());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    private String get_reporte_html(){
        reportes_db  reportedb =new reportes_db();
        List<reporte_hora_fecha_beans> lista =  reportedb.retornar_reporte_email();
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = format.format( new Date()   );

        String reporte ="<html><body><H1>REPORTE DE INGRESO DIARIO</H1>"
                + "<H2>FECHA: "+dateString+"</H2>"
                + "<table border=\"1\"><tr><th>Hora</th><th>Monto</th></tr>";
        
        for(reporte_hora_fecha_beans rep: lista){
            reporte+= "<tr><td>"+rep.getHora()+"</td><td>"+rep.getTotal()+"</td></tr>";
        }
        reporte+="</table></body></html>";
        return reporte;
    }

    @Override
    public void run() {
        enviar_reporte();
    }
}
