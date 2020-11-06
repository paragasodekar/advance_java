package com.cdac.service;

import java.util.List;

import com.cdac.dto.Shipment;

public interface ShipmentService {
	
	

	void addShipment(Shipment shipment);

	void selectFare(Shipment shipment);

	List<Shipment> selectAll(int userId);
	
	void removeShipment(int shipmentId);

	Shipment findShipment(int shipmentId);

	void modifyShipment(Shipment shipment);
}
