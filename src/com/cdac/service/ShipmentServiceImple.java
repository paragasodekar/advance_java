package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.ShipmentDao;
import com.cdac.dto.Shipment;

@Service
public class ShipmentServiceImple implements ShipmentService {
	
	@Autowired
	private ShipmentDao shipmentDao;

	
	
	@Override
	public void addShipment(Shipment shipment) {
		shipmentDao.insertshipment(shipment);
		
	}


	@Override
	public void selectFare(Shipment shipment) {
		shipmentDao.choosefare(shipment);
		
	}


	@Override
	public List<Shipment> selectAll(int userId) {
		return shipmentDao.selectAll(userId);
	}

	@Override
	public void removeShipment(int shipmentId) {
		shipmentDao.deleteShipment(shipmentId);
	}


	@Override
	public Shipment findShipment(int shipmentId) {
		return shipmentDao.selectShipment(shipmentId);
	}


	@Override
	public void modifyShipment(Shipment shipment) {
		shipmentDao.updateShipment(shipment);
		
	}

	

	

}
