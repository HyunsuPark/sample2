import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	private String id;
	private String pw;

	public MyAuthenticator() {
		this.id = "ekrnfkdi@gmail.com";
		this.pw = "qlalfqjsgh1";
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(id, pw);
	}
}
