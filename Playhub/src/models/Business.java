package models;

public class Business {
	
    private int id;
    private String name;
    private String description;
    private String location;
    private double pricePerHour;
    private int avaliablesPitchs;
    private int sportId;
    private int ownerId;

   
    public Business() {
    	
    }

    public Business(String name, String description, String location, double pricePerHour, int avaliablesPitchs, int sportId, int ownerId) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.pricePerHour = pricePerHour;
        this.avaliablesPitchs = avaliablesPitchs;
        this.sportId = sportId;
        this.ownerId = ownerId;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public int getAvaliablesPitchs() {
		return avaliablesPitchs;
	}

	public void setAvaliablesPitchs(int avaliablesPitchs) {
		this.avaliablesPitchs = avaliablesPitchs;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Business [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", pricePerHour=" + pricePerHour + ", avaliablesPitchs=" + avaliablesPitchs + ", sportId=" + sportId
				+ ", ownerId=" + ownerId + "]";
	}
    
    
}

