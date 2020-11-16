package com.SkillexBackend.SkillexBackendDemo.utilidades;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class Email  {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviarContrasena(String from, String to, String subject, String password ,String nombre, String apellidos) throws MessagingException {
		
		String cuerpo = "<center><img src='https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTCDMyiLJmEOcz6ntQnTLUYHhQVRNeHrsxR4w&usqp=CAU' title='Banco Pedagogico'></center>"
                + "<h1> Recordatorio de contraseña: "
                + "</h1>"
                + "<h4>Datos de Ingreso: <h4>"
                + "<h4> Nombre Usuario : "
                + nombre + " " + apellidos
                + "</h4>"
                + "<h4> Correo electronico: "
                + to
                + "</h4>"
                + "<h4> Clave: "
                + password
                + "</h4>"
                + "<p> Esta es su contraseña, intente ingresar nuevamente<p>";
		
        MimeMessage mail = javaMailSender.createMimeMessage();
        
        //mail.setFrom(from);
        //mail.setTo(to);
        mail.setSubject(subject);
        //mail.setText(cuerpo);
        
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(mail, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setText(cuerpo, true);
        
        
        javaMailSender.send(mail);
    }
public void correoMasivo(String from, String to, String subject,String nombre, String apellidos,String mensaje) throws MessagingException {
		
		String cuerpo = "<center><img src='https://i.pinimg.com/originals/e0/52/43/e0524329926c57527d1bb1ed2a7555d0.png' title='Power Riff'></center>"
                + "<h1> Correo informativo: "
                + "</h1>"
                + "<h4>Datos de Ingreso: <h4>"
                + "<h4> Nombre Usuario : "
                + nombre + " " + apellidos
                + "</h4>"
                + "<h4> Correo electronico: "
                + to
                + "</h4>"
                + "<h3>Mensaje: </h3>"
                + "<p>"
                + mensaje
                + "</p>"
                ;
		
        MimeMessage mail = javaMailSender.createMimeMessage();
        
        mail.setSubject(subject);
        
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(mail, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setText(cuerpo, true);
        
        
        javaMailSender.send(mail);
    }
	
}
