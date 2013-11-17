public class Test {
	static BatchRun br = new BatchRun();
	static Mail m = new Mail();
	
	public static void main(String[] args) {
		String fileSrc = ".\\casperjs\\bin\\test.bat";
		
		br.execute(fileSrc);
		m.sendMail();
	}
}
