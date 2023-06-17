package com.flyaway.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="flightdetails")
public class Flight {
	
	@Column(name="flightno")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String flightno;

	@Column(name="CarrierName")
	String carrierName;
	
	@Column(name="Origin")
	String origin;
	
	@Column(name="Destination")
	String destination;
	
	@Column(name="departure")
	String departure;
	
	@Column(name="arrival")
	String arrival;
	
	@Column(name="Duration")
	String duration;
	
	@Column(name="Bag_Checkin")
	String chkin_BgLimit;
	
	@Column(name="Bag_Cabin")
	String cabin_BgLimit;
	
	@Column(name="BaseFare")
	Double baseFare;
	
	@Column(name="Surcharge")
	Double surcharge;

	public Flight() {
		super();
	}
	
	public Flight(String flightno, String carrierName, String origin,
			String destination, String departure, String arrival,
			String duration, String chkin_BgLimit, String cabin_BgLimit,
			Double baseFare, Double surcharge) {
		super();
		this.flightno = flightno;
		this.carrierName = carrierName;
		this.origin = origin;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
		this.chkin_BgLimit = chkin_BgLimit;
		this.cabin_BgLimit = cabin_BgLimit;
		this.baseFare = baseFare;
		this.surcharge = surcharge;
	}
	
	
	public Flight(String origin, String destination, String departure, String arrival) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getChkin_BgLimit() {
		return chkin_BgLimit;
	}

	public void setChkin_BgLimit(String chkin_BgLimit) {
		this.chkin_BgLimit = chkin_BgLimit;
	}

	public String getCabin_BgLimit() {
		return cabin_BgLimit;
	}

	public void setCabin_BgLimit(String cabin_BgLimit) {
		this.cabin_BgLimit = cabin_BgLimit;
	}

	public Double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(Double baseFare) {
		this.baseFare = baseFare;
	}

	public Double getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(Double surcharge) {
		this.surcharge = surcharge;
	}
	
}
