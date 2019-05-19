package MailDemo;
//Java发送简单邮件
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mailDemo {
	public static void main(String[] args) throws Exception{
		//QQ
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");		//使用smtp协议
		props.setProperty("mail.smtp.host", "smtp.qq.com");		//qq邮箱协议地址
		props.setProperty("mail.smtp.port", "465");			//qq邮箱协议端口号
		props.setProperty("mail.smtp.auth", "true");		//授权
		//QQ:SSL安全认证
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");	//只处理ssl认证(之外的默认不处理)
		props.setProperty("mail.smtp.socketFactory.port", "465");	//端口
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); //开启日志
		
		
		//创建邮件对象
		MimeMessage message = createMimeMessage(session,"1378813463@qq.com","601216726@qq.com");
		//Transport transport = session.getTransport("smtp");//建立连接对象（这里优先加载jar包而非容器）
		Transport transport = session.getTransport();
		transport.connect("1378813463@qq.com", "ubgbkriwovfrijdi");  //发送人账户、密码（授权码）
		transport.sendMessage(message, message.getAllRecipients());	//所有的收件人
		transport.close();
	}
	
	//Mime：邮箱类型
	public static MimeMessage createMimeMessage(Session session,String send,String receive) throws Exception{
		MimeMessage message = new MimeMessage(session);
		//邮件：标题、正文、收件人、发件人（附件、图片）
		Address address = new InternetAddress(send,"发件人","utf-8");	//发件人
		message.setFrom(address);		//增加发件人
		message.setSubject("这是一封Java邮件","utf-8");
		message.setContent("你猜猜是啥.", "text/html;charset=utf-8");	//(正文,编码)这里是某个html的编码格式
		
		//收件人类型：.TO普通收件人、.CC抄送、.BCC密送
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receive,"收件人","utf-8"));
//		message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(cReceive,"抄送人c","utf-8"));
//		message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(mReceive,"密送人m","utf-8"));
		
		message.setSentDate(new Date());//设置发送时间
		message.saveChanges(); //保存邮件
		
		return message;
	}
}
