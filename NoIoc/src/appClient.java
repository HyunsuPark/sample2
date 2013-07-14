public class appClient {
	public static void main(String[] args) {
		appFactory f = new appFactory();

		 myInter app = f.getApp("1");  
		 if(app != null) System.out.println(app.hello());
		 app = f.getApp("2");  
		 if(app != null) System.out.println(app.hello());
		
		 //만약 app3,app4.app5... 이라는 클래스가 추가될경우 appFactory 수정, appCleint
		 // 도 수정이 필요함.
	}
}
