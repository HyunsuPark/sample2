public class Test {
	static BatchRun br = new BatchRun();
	static Mail m = new Mail();
	
	public static void main(String[] args) {
		String fileSrc = ".\\casperjs\\batchbin\\yslow_test.bat"; //bat파일 실행경로
		String imgFileName = "capture.jpg";	//발송할 이미지경로
		
		br.execute(fileSrc);
//		m.sendMail(imgFileName);
	}
}