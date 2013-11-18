import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Mail {
	public void sendMail(String imgFileName) {
		// TODO Auto-generated method stub
		String host = "smtp.gmail.com";// smtp 서버
		String subject = "안녕";
		String from = "ekrnfkdi@gmail.com"; // 보내는 메일
		String fromName = "dfsdf";
		String to = "ekrnfkdi@naver.com";
		String content = "aaaaaaaaaaaaaaaa";
		try {
			// 프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
			Properties props = new Properties();

			// G-Mail SMTP 사용시
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.auth", "true");

			Authenticator auth = new MyAuthenticator();

			Session mailSession = Session.getDefaultInstance(props, auth);

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(
					fromName, "UTF-8", "B")));// 보내는 사람 설정
			InternetAddress[] address = { new InternetAddress(to) };

			msg.setRecipients(Message.RecipientType.TO, address);// 받는 사람설정

			msg.setSubject(subject);// 제목 설정
			msg.setSentDate(new java.util.Date());// 보내는 날짜 설정

			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H1>Hello</H1><img src=\"cid:image\">"; //내용
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(imgFileName);
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			msg.setContent(multipart);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, null, null);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

			System.out.println("메일 발송을 완료하였습니다.");
		} catch (MessagingException ex) {
			System.out.println("mail send error : " + ex.getMessage());
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}

	}
}
