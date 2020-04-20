

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String url;
    private String description;
    private String location;

    public Photo() {
    }

    public Photo(String url, String description, String location) {
        this.url = url;
        this.description = description;
        this.location = location;
    }

    public Photo(Photo Photo) {
        if (Photo.id != null) this.id = Photo.id;
        this.url = Photo.url;
        this.description = Photo.description;
        this.location = Photo.location;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
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

}
