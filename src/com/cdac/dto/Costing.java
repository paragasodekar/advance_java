package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "costing")
public class Costing {
	@Id
	@GeneratedValue
	@Column(name = "costing_id")
	private int costingId;
		@Column(name = "f_city")
		private String fCity;
		@Column(name = "t_city")
		private String tCity;
		@Column(name = "t_fare")
		private int t_Fare;
		
		public Costing() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getfCity() {
			return fCity;
		}

		public void setfCity(String fCity) {
			this.fCity = fCity;
		}

		public String gettCity() {
			return tCity;
		}

		public void settCity(String tCity) {
			this.tCity = tCity;
		}

		public int getT_Fare() {
			return t_Fare;
		}

		public void setT_Fare(int t_Fare) {
			this.t_Fare = t_Fare;
		}
		
		
		
		
		
}
