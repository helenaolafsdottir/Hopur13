package project.persistence.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

public class RecipeGroup {

	public String groupName;
	public String image;
	
	public RecipeGroup() {
	    }    

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
	    this.groupName = groupName;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
	    this.image = image;
	}
}
