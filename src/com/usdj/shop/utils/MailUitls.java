/**
 * 
 */
package com.usdj.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author gerrydeng
 *
 */
public class MailUitls {
	//enter yourself mail account and password
	private static String mailAccount;
	private static String mailPassword;
	public static void sendMail(String to, String code) {
		Properties properties = new Properties();
		properties.put("mail.host", "smtp.163.com");
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", true);
		Session session= Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(mailAccount, mailPassword);
			}
			
		});
		Message message= new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(mailAccount));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject("test code");
			message.setContent("<h1>官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://localhost:8080/shop/user_active.action?code="+code+"'>http://localhost:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			Transport.send(message);
		} catch (AddressException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//test sendmail
	public static void main(String[] args) {
		sendMail("test@163.com", "hahha");
		
	}
}
