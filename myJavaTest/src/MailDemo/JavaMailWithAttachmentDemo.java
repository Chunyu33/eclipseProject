package MailDemo;
//目前运行有问题！
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

public class JavaMailWithAttachmentDemo {
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
		MimeMessage message = createMimeMessage(session,"1378813463@qq.com","370690030@qq.com");
		Transport transport = session.getTransport();
		transport.connect("1378813463@qq.com", "ubgbkriwovfrijdi");  //发送人账户、密码（授权码）
		transport.sendMessage(message, message.getAllRecipients());	//所有的收件人
		transport.close();
	}
	
	//MimeMessage:带图片、带附件的邮件
	public static MimeMessage createMimeMessage(Session session,String send,String receive) throws Exception{
		MimeMessage message = new MimeMessage(session);
		//邮件：标题、正文、收件人、发件人（附件、图片）
		Address address = new InternetAddress(send,"发件人","utf-8");	//发件人
		message.setFrom(address);		//增加发件人
		message.setSubject("Java邮件(带附件和图片)","utf-8");
		
		//创建图片节点
		MimeBodyPart imagePart = new MimeBodyPart();
		DataHandler imageDataHanlder = new DataHandler(new FileDataSource("src/lye.png"));//图片地址
		imagePart.setDataHandler(imageDataHanlder);
		imagePart.setContentID("MyLyeImage");	//设置图片id
		
		//创建文本节点:目的是为了加载图片节点
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("正文....image:<img src='cid:MyLyeImage'/>", "text/html;charset=utf-8");
		
		//将图片节点、文本节点封装成一个复合节点
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(imagePart);
		mm.addBodyPart(textPart);
		mm.setSubType("related");		//关联关系
		
		//注意：正文只能出现(普通节点)MimeBodyPart，不能出现(复杂节点)MimeMultipart
		//MimeMultipart  -->   MimeBodyPart
		MimeBodyPart finals = new MimeBodyPart();
		finals.setContent(mm);
		
		//添加附件
		MimeBodyPart txtFile = new MimeBodyPart();
		DataHandler FileDataHanlder = new DataHandler(new FileDataSource("src/a.txt"));//图片地址
		txtFile.setDataHandler(FileDataHanlder);
		//给附件设置文件名
		txtFile.setFileName(MimeUtility.decodeText(FileDataHanlder.getName()));	//同时解决乱码
		
		//将处理好的"文本+图片"节点 与 附件节点 设置成一个新的复合节点
		mm.addBodyPart(finals);
		mm.addBodyPart(txtFile);
		mm.setSubType("mixed");	//混合关系
		
		//text/html;charset=utf-8
		message.setContent(mm, "text/html;charset=utf-8");
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receive,"收件人","utf-8"));
		
		message.setSentDate(new Date());//设置发送时间
		message.saveChanges(); //保存邮件
		
		return message;
	}
}
