package travel.model.vo;

public class Travel {
	private String travel_code;
	private String location;
	private String travel_title;
	private String departure_date;
	private String return_date;
	private String price;
	private String airline;
	
	public Travel() {
		// TODO Auto-generated constructor stub
	}

	public Travel(String travel_code, String location, String travel_title,
			String departure_date, String return_date, String price,
			String airline) {
		super();
		this.travel_code = travel_code;
		this.location = location;
		this.travel_title = travel_title;
		this.departure_date = departure_date;
		this.return_date = return_date;
		this.price = price;
		this.airline = airline;
	}

	public String getTravel_code() {
		return travel_code;
	}

	public void setTravel_code(String travel_code) {
		this.travel_code = travel_code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTravel_title() {
		return travel_title;
	}

	public void setTravel_title(String travel_title) {
		this.travel_title = travel_title;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	
	
}
