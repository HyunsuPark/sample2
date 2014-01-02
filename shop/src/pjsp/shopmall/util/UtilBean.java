package pjsp.shopmall.util;
public class UtilBean {
	private  String serverInfo;
	public void setServerInfo(String serverInfo) {
		this.serverInfo = serverInfo;
	}
	public String asc2ksc(String asc) {
		if(!needsEncoding() || asc == null) return asc;
		System.out.println("encoded");//for testing use!
		String encodedStr = null;
		try {
			encodedStr = new String(asc.getBytes("ISO-8859-1"), "KSC5601");
		} catch(java.io.UnsupportedEncodingException e) {
		}
		return encodedStr;
	}
	public String makeSQL(String str) {
		return "'" + str + "'";//if str is null? doen't matter
	}
	private boolean needsEncoding() {
		if(serverInfo != null && serverInfo.startsWith("Tomcat Web Server")) { //short circuiting usage
			java.util.StringTokenizer st = new java.util.StringTokenizer(serverInfo, "(");
			String server = (st.nextToken()).trim();
			if(server.compareTo("Tomcat Web Server/3.1") <= 0) {
				return true;
			}
		}
		return false;
	}
}
		