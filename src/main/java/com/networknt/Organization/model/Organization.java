
package com.networknt.Organization.model;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {

    
  

	private String name;
    
    private String id;
    
    private String contactPhone;
    
    private String contactEmail;
    
    private String contactName;
    

    public Organization () {
    }
    public Organization( String id,String name, String contactPhone, String contactEmail, String contactName) {
  		super();
  		this.name = name;
  		this.id = id;
  		this.contactPhone = contactPhone;
  		this.contactEmail = contactEmail;
  		this.contactName = contactName;
  	}
    public Organization(Map<String, Object> map) {
		super();
		setId((String) map.get("id"));
		setName( (String) map.get("Name"));
		setContactEmail((String) map.get("contactEmail"));
		setContactName ((String) map.get("contactName"));
		setContactPhone ((String) map.get("contactPhone"));
	}
    
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    @JsonProperty("contactPhone")
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    
    
    @JsonProperty("contactEmail")
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    
    
    
    @JsonProperty("contactName")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Organization organization = (Organization) o;

        return Objects.equals(name, organization.name) &&
        Objects.equals(id, organization.id) &&
        Objects.equals(contactPhone, organization.contactPhone) &&
        Objects.equals(contactEmail, organization.contactEmail) &&
        
        Objects.equals(contactName, organization.contactName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, contactPhone, contactEmail,  contactName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Organization {\n");
        
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
        sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
        sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
