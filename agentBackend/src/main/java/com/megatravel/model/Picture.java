package com.megatravel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "picture", propOrder = {
    "id",
    "name",
    "type",
    "pic",
    "accommodation"
})
public class Picture {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @XmlElement(required = true)
	    protected long id;
	 	
	 	@Column(name = "name")
	    @XmlElement(required = true)
		protected String name;
	    
	    @Column(name = "type")
	    @XmlElement(required = true)
		protected String type;
		
		@Lob
	    @Column(name="pic")
	    @XmlElement(required = true)
	    protected byte[] pic;
		
		@ManyToOne
		@JoinColumn(name = "accommodation_id", foreignKey = @ForeignKey(name = "IMAGE_ACCOMMODATION_ID_FK"))
		@XmlElement(required = true)
		protected Accommodation accommodation;
		
		public Picture() {
		}

		public Picture(long id, String name, String type, byte[] pic) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.pic = pic;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public byte[] getPic() {
			return pic;
		}

		public void setPic(byte[] pic) {
			this.pic = pic;
		}

		public Accommodation getAccomodationUnit() {
			return accommodation;
		}

		public void setAccommodation(Accommodation accomodationUnit) {
			this.accommodation = accomodationUnit;
		}				
}
