package com.app.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cars")
	public class Cars extends BaseEntity {
		@Column(name = "brand_name", length = 50)
	    private String brandName;
		@Column(name = "model_name", length = 50)
	    private String modelName;
	    private int year;
	    private double price;
	    private double mileage;
	    @Column(name = "fuel_type", length = 50)
	    private String fuelType;
	    @Column(name = "transmission_type", length = 50)
	    private String transmissionType;
	    @Column(length = 150)
	    private String description;
	    
	    @Lob
	    private String image;

	    @JsonIgnore
	    @LazyCollection(LazyCollectionOption.FALSE)
	    @JsonIgnoreProperties("car")
	    @OneToMany(mappedBy = "car" ,orphanRemoval = false)
	    private List<CarBooking> booking = new ArrayList<CarBooking>();
	    

	    @OneToOne( mappedBy = "car" , orphanRemoval = true, fetch = FetchType.EAGER)
	    private CarsSpecification carSpecification;
	    
        @JsonIgnore
	    @OneToMany(mappedBy = "cars" ,orphanRemoval = false)
	    private List<TestDrive> test =  new ArrayList<TestDrive>();
	    
	   
	  	@LazyCollection(LazyCollectionOption.FALSE)
	  	@JsonIgnore
	    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE, orphanRemoval = true)
	    private List<CarServices> service = new ArrayList<CarServices>();
	     
	    
	    public void addBooking(CarBooking book) {
	    	booking.add(book);
	    	book.setCar(this);
	    }
	    
	   
	    
		public String getBrandName() {
			return brandName;
		}



		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}



		public String getModelName() {
			return modelName;
		}



		public void setModelName(String modelName) {
			this.modelName = modelName;
		}



		public int getYear() {
			return year;
		}



		public void setYear(int year) {
			this.year = year;
		}



		public double getPrice() {
			return price;
		}



		public void setPrice(double price) {
			this.price = price;
		}



		public double getMileage() {
			return mileage;
		}



		public void setMileage(double mileage) {
			this.mileage = mileage;
		}



		public String getFuelType() {
			return fuelType;
		}



		public void setFuelType(String fuelType) {
			this.fuelType = fuelType;
		}



		public String getTransmissionType() {
			return transmissionType;
		}



		public void setTransmissionType(String transmissionType) {
			this.transmissionType = transmissionType;
		}



		public String getDescription() {
			return description;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public String getImage() {
			return image;
		}



		public void setImage(String image) {
			this.image = image;
		}



		public List<CarBooking> getBooking() {
			return booking;
		}



		public void setBooking(List<CarBooking> booking) {
			this.booking = booking;
		}



		public CarsSpecification getCarSpecification() {
			return carSpecification;
		}



		public void setCarSpecification(CarsSpecification carSpecification) {
			this.carSpecification = carSpecification;
		}



		public List<TestDrive> getTest() {
			return test;
		}



		public void setTest(List<TestDrive> test) {
			this.test = test;
		}



		public List<CarServices> getService() {
			return service;
		}



		public void setService(List<CarServices> service) {
			this.service = service;
		}



		@Override
		public String toString() {
			return "Cars [ id()=" + getId() + ", brandName= " + brandName + ", modelName=" + modelName + ", year=" + year + ", price=" + price
					+ ", mileage=" + mileage + ", fuelType=" + fuelType + ", transmissionType=" + transmissionType
					+ ", description=" + description +  "]";
		}



		
	    
    
}
	

