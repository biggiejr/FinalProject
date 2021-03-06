package entities;

/**
 * Created by Mato on 10.5.17.
 */
public class City {

    String name;
    Double longitude, latitude;

    public City() {
    }

    public City(String name, Double longitude, Double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

	@Override
	public String toString() {
		return "City [name=" + name + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
    
    
}
