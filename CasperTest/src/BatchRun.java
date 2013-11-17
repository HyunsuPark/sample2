import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BatchRun{
	
	public BatchRun() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param batchFileSrc .\\casperjs\\bin\\test.bat
	 */
	public void execute(String batchFileSrc) {
		try {
		    Process p = Runtime.getRuntime().exec(batchFileSrc);
		    
		    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String line = null;
		    
		    while ((line = br.readLine()) != null) {
		      System.out.println(line);
		    }
		  } catch (Exception e) {
		    System.err.println(e);
		  }
	}
}