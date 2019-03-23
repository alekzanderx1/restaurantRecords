package com.worldrestaurants.project.model;

import com.worldrestaurants.project.util.StringListConverter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

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

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Set<String> getCuisines() {
		return cuisines;
	}

	public void setCuisines(Set<String> cuisines) {
		this.cuisines = cuisines;
	}

	public Long getCostForTwo() {
		return costForTwo;
	}

	public void setCostForTwo(Long costForTwo) {
		this.costForTwo = costForTwo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boolean getHasTable() {
		return hasTable;
	}

	public void setHasTable(Boolean hasTable) {
		this.hasTable = hasTable;
	}

	public Boolean getOnlineDelivery() {
		return onlineDelivery;
	}

	public void setOnlineDelivery(Boolean onlineDelivery) {
		this.onlineDelivery = onlineDelivery;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getRatingColor() {
		return ratingColor;
	}

	public void setRatingColor(String ratingColor) {
		this.ratingColor = ratingColor;
	}

	public String getRatingText() {
		return ratingText;
	}

	public void setRatingText(String ratingText) {
		this.ratingText = ratingText;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "uniqueid", nullable = false)
	private String uniqueId;

	@Column(name = "cuisines")
	@Convert(converter = StringListConverter.class)
	private Set<String> cuisines;

	@Column(name = "costfortwo")
	private Long costForTwo;

	@Column(name = "currency")
	private String currency;

	@Column(name = "hastable")
	private Boolean hasTable;

	@Column(name = "onlinedelivery")
	private Boolean onlineDelivery;

	@Column(name = "rating")
	private BigDecimal rating;

	@Column(name = "ratingColor")
	private String ratingColor;

	@Column(name = "ratingtext")
	private String ratingText;

	@Column(name = "votes")
	private Long votes;
}
