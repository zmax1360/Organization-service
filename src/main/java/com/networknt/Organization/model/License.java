
package com.networknt.Organization.model;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class License {


	private String licenseId;
	
	private String organizationId;
    
    private String organizationName;
    
    private String contactEmail;
    
    private String contactName;
    
    private String license_type;
    
    private Integer license_max;
    
    private String comment;
            
    private String contactPhone;
    
    private String productName;
    
    private Integer license_allocated;
    

    public License () {
    }
	public License(String organizationId, String productName, String organizationName, String contactEmail,
			String contactName, String license_type, Integer license_max, String comment, String licenseId,
			String contactPhone, Integer license_allocated) {
		super();
		this.organizationId = organizationId;
		this.productName = productName;
		this.organizationName = organizationName;
		this.contactEmail = contactEmail;
		this.contactName = contactName;
		this.license_type = license_type;
		this.license_max = license_max;
		this.comment = comment;
		this.licenseId = licenseId;
		this.contactPhone = contactPhone;
		this.license_allocated = license_allocated;
	}

	public License(Map<String, Object> map) {
		super();
		this.organizationId = this.productName = (String) map.get("productName");
		this.organizationName = (String) map.get("organizationName");
		this.contactEmail = (String) map.get("contactEmail");
		this.contactName = (String) map.get("contactName");
		this.license_type = (String) map.get("license_type");
		this.license_max = (Integer) map.get("license_max");
		this.comment = (String) map.get("comment");
		this.licenseId = (String) map.get("licenseId");
		this.contactPhone = (String) map.get("contactPhone");
		this.license_allocated = (Integer) map.get("license_allocated");
	}

    
    
    @JsonProperty("organizationId")
    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
    
    
    
    @JsonProperty("organizationName")
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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
    
    
    
    @JsonProperty("license_type")
    public String getLicense_type() {
        return license_type;
    }

    public void setLicense_type(String license_type) {
        this.license_type = license_type;
    }
    
    
    
    @JsonProperty("license_max")
    public Integer getLicense_max() {
        return license_max;
    }

    public void setLicense_max(Integer license_max) {
        this.license_max = license_max;
    }
    
    
    
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
    @JsonProperty("licenseId")
    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }
    
    
    
    @JsonProperty("contactPhone")
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    
    
    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
    
    @JsonProperty("license_allocated")
    public Integer getLicense_allocated() {
        return license_allocated;
    }

    public void setLicense_allocated(Integer license_allocated) {
        this.license_allocated = license_allocated;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        License license = (License) o;

        return Objects.equals(organizationId, license.organizationId) &&
        Objects.equals(organizationName, license.organizationName) &&
        Objects.equals(contactEmail, license.contactEmail) &&
        Objects.equals(contactName, license.contactName) &&
        Objects.equals(license_type, license.license_type) &&
        Objects.equals(license_max, license.license_max) &&
        Objects.equals(comment, license.comment) &&
        Objects.equals(licenseId, license.licenseId) &&
        Objects.equals(contactPhone, license.contactPhone) &&
        Objects.equals(productName, license.productName) &&
        
        Objects.equals(license_allocated, license.license_allocated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, organizationName, contactEmail, contactName, license_type, license_max, comment, licenseId, contactPhone, productName,  license_allocated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class License {\n");
        
        sb.append("    organizationId: ").append(toIndentedString(organizationId)).append("\n");
        sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
        sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
        sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
        sb.append("    license_type: ").append(toIndentedString(license_type)).append("\n");
        sb.append("    license_max: ").append(toIndentedString(license_max)).append("\n");
        sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
        sb.append("    licenseId: ").append(toIndentedString(licenseId)).append("\n");
        sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
        sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
        sb.append("    license_allocated: ").append(toIndentedString(license_allocated)).append("\n");
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
