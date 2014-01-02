package pjsp.shopmall.beans;
import java.util.*;
import java.io.*;
public class RotatorBean {
	private int idx_curImage, num_images;
	private String [] imageNames = {""};
	private String [] imageURLs = {""};
	private String imagePath = "/images/img.properties";
	private Properties props = new Properties();
	public RotatorBean() {
		setInit(null);
		idx_curImage = 0;
	}
	public String getImageName() {
		return imageNames[idx_curImage];
	}
	public String getImageURL() {
		idx_curImage = getRandomImageIndex();
		return imageURLs[idx_curImage];
	}
	private  int getRandomImageIndex() {
		if(num_images <= 1) return 0;
		int idx_image = (int)(Math.random() * num_images);
		return (idx_image == idx_curImage)?  getRandomImageIndex(): idx_image;
	}
	public  void setInit(String path) {
		if(path != null) imagePath = path; 
		try {
			System.out.println(imagePath);
			FileInputStream fis = new FileInputStream(imagePath);
			props.load(fis);
			fis.close();
		} catch(IOException e) {
			System.err.println("Couldn't load properties for images");
			System.out.println("You should set Paht for img.properites again in .jsp ...");
		}
			
		Enumeration enum2 = props.propertyNames();
		int num = props.size();
		this.num_images = num;
		imageNames = new String[num];
		imageURLs = new String[num];
		for (int i = 0; enum2.hasMoreElements(); i++) {
			imageNames[i] = (String) enum2.nextElement();
			imageURLs[i] = props.getProperty(imageNames[i]);
		}
	}	
}

		
