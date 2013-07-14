
public class SampleTest {
	public static void main(String[] args) throws Exception {
		String name = "Sample";
		
		//옛날에는 new해서 객체 만들었잖아요,
		Class clz = Class.forName(name);
		Object obj = clz.newInstance();
		
		// 장점은 name맘대로 바꿀수있잖아요
		System.out.println(obj);
		
		// 스프링은 유연하게 이 작업들을 xml 설정으로 할수있다. 리플렉셔으로 new안하고 
	}
}
