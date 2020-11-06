package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Shipment;

public interface ShipmentDao {
	
	void deleteShipment(int shipmentId);
	
	void updateShipment(Shipment shipment);
	List<Shipment> selectAll(int userId);
	void insertshipment(Shipment shipment);
	void choosefare(Shipment shipment);
	Shipment selectShipment(int shipmentId);
}
