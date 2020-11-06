package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipment")
public class Shipment {

		@Id
		@Column(name = "shipment_id")
		@GeneratedValue
		private int shipmentId;
		@Column(name = "shipment_date")
		private String shipmentDate;
		@Column(name = "from_city")
		private String fromCity;
		@Column(name = "from_addrs")
		private String fromAddrs;
		@Column(name = "to_city")
		private String toCity;
		@Column(name = "to_addrs")
		private String toAddrs;
		@Column(name = "pkg_req")
		private String pkgReq;
		@Column(name = "Shipment_size")
		private int shipmentSize;
		@Column(name = "total_charges")
		private int totalCharges;
		private int userId;
		public Shipment() {
			
		}
		public Shipment(int shipmentId) {
			super();
			this.shipmentId = shipmentId;
		}
		
		public int getShipmentId() {
			return shipmentId;
		}
		public void setShipmentId(int shipmentId) {
			this.shipmentId = shipmentId;
		}
		public String getShipmentDate() {
			return shipmentDate;
		}
		public void setShipmentDate(String shipmentDate) {
			this.shipmentDate = shipmentDate;
		}
		public String getFromCity() {
			return fromCity;
		}
		public void setFromCity(String fromCity) {
			this.fromCity = fromCity;
		}
		public String getFromAddrs() {
			return fromAddrs;
		}
		public void setFromAddrs(String fromAddrs) {
			this.fromAddrs = fromAddrs;
		}
		public String getToAddrs() {
			return toAddrs;
		}
		public void setToAddrs(String toAddrs) {
			this.toAddrs = toAddrs;
		}
		public String getPkgReq() {
			return pkgReq;
		}
		public void setPkgReq(String pkgReq) {
			this.pkgReq = pkgReq;
		}
		public int getTotalCharges() {
			return totalCharges;
		}
		public void setTotalCharges(int totalCharges) {
			this.totalCharges = totalCharges;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getShipmentSize() {
			return shipmentSize;
		}
		public void setShipmentSize(int shipmentSize) {
			this.shipmentSize = shipmentSize;
		}
		public String getToCity() {
			return toCity;
		}
		public void setToCity(String toCity) {
			this.toCity = toCity;
		}
		
		
		
		
}
