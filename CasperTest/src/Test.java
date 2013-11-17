import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Test {
	public static void main(String[] args)  {
		try {
		    Process p = Runtime.getRuntime().exec("H:\\STSworkspace\\CasperTest\\casperjs\\bin\\test.bat");
		    
		    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String line = null;
		    
		    while ((line = br.readLine()) != null) {
		      System.out.println(line);
		    }
		  } catch (Exception e) {
		    System.err.println(e);
		  }
		
		 Mail m = new Mail();
		 m.sendMail();
	}
}
