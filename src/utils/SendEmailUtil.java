/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Admin
 */
  import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailUtil {
   
	public static void Send(String userName,String password,String to,String title,String message,String ccEmail,String bccEmail,String uriFile) throws RuntimeException, MessagingException  {
		File file = new File(uriFile);
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setDataHandler(new DataHandler(new FileDataSource(file)));
		bodyPart.setFileName(file.getName());
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		String from = userName;
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
			try {
				Message mes = new MimeMessage(session);
				mes.setFrom(new InternetAddress(from));
				mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				if (ccEmail!=null&&ccEmail.length()>0) {
					mes.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail));
				}
				if (bccEmail!=null&&bccEmail.length()>0) {
					mes.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccEmail));
				}
				mes.setSubject(title);
				mes.setText(message);
				mes.setContent(multipart);
				Transport.send(mes);
			} catch (MessagingException e) {
				throw new MessagingException();
			}

	}
	public static void Send(String userName,String password,String to,String title,String message,String ccEmail,String bccEmail) throws RuntimeException, MessagingException  {
		String from = userName;
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
			try {
				Message mes = new MimeMessage(session);
				mes.setFrom(new InternetAddress(from));
				mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				if (ccEmail!=null&&ccEmail.length()>0) {
					mes.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail));
				}
				if (bccEmail!=null&&bccEmail.length()>0) {
					mes.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccEmail));
				}
				mes.setSubject(title);
				mes.setText(message);
				Transport.send(mes);
			} catch (MessagingException e) {
				throw new MessagingException();
			}

	}
	public static void Send(String userName,String password,String to,String title,String message,String ccEmail) throws RuntimeException, MessagingException  {
		String from = userName;
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
			try {
				Message mes = new MimeMessage(session);
				mes.setFrom(new InternetAddress(from));
				mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				if (ccEmail!=null&&ccEmail.length()>0) {
					mes.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail));
				}
				mes.setSubject(title);
				mes.setText(message);
				Transport.send(mes);
			} catch (MessagingException e) {
				throw new MessagingException();
			}

	}
	public static void Send(String userName,String password,String to,String title,String message) throws RuntimeException, MessagingException  {
		String from = userName;
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
			try {
				Message mes = new MimeMessage(session);
				mes.setFrom(new InternetAddress(from));
				mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				mes.setSubject(title);
				mes.setText(message);
				Transport.send(mes);
			} catch (MessagingException e) {
				throw new MessagingException();
			}

	}
	public static void Quese(String userName,String password,String to,String title,String message,String ccEmail,String bccEmail,String uriFile)  {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					SendEmailUtil.Send(userName, password, to, title, message, ccEmail,bccEmail,uriFile);
				} catch (RuntimeException | MessagingException e) {
					e.printStackTrace();
				}	
			}
		}).start();
		
	}
	public static void Quese(String userName,String password,String to,String title,String message,String ccEmail,String bccEmail)  {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					SendEmailUtil.Send(userName, password, to, title, message, ccEmail,bccEmail);
				} catch (RuntimeException | MessagingException e) {
					e.printStackTrace();
				}	
			}
		}).start();
		
	}
	public static void Quese(String userName,String password,String to,String title,String message,String ccEmail) throws RuntimeException, MessagingException  {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					SendEmailUtil.Send(userName, password, to, title, message,ccEmail);
				} catch (RuntimeException | MessagingException e) {
					e.printStackTrace();
				}	
			}
		}).start();
		
	}
	public static void Quese(String userName,String password,String to,String title,String message) throws RuntimeException, MessagingException  {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					SendEmailUtil.Send(userName, password, to, title, message);
				} catch (RuntimeException | MessagingException e) {
					e.printStackTrace();
				}	
			}
		}).start();	
	}
}
