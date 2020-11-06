package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Shipment;
import com.cdac.dto.Costing;


@Repository
public class ShipmentDaoImple implements ShipmentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	

	@Override
	public void deleteShipment(int shipmentId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Shipment(shipmentId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	@Override
	public Shipment selectShipment(int shipmentId) {
		Shipment shipment = hibernateTemplate.execute(new HibernateCallback<Shipment>() {

			@Override
			public Shipment doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Shipment ex = (Shipment)session.get(Shipment.class, shipmentId);
				tr.commit();
				session.flush();
				session.close();
				return ex;
			}
			
		});
		return shipment;
	}

	@Override
	public void updateShipment(Shipment shipment) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				
//				Expense ex = (Expense)session.get(Expense.class, expense.getExpenseId());
//				ex.setItemName(expense.getItemName());
//				ex.setPrice(expense.getPrice());
//				ex.setPurchaseDate(expense.getPurchaseDate()); 
				
				session.update(shipment);
				
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public List<Shipment> selectAll(int userId) {
		List<Shipment> expList = hibernateTemplate.execute(new HibernateCallback<List<Shipment>>() {

			@Override
			public List<Shipment> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Shipment where userId = ?");
				q.setInteger(0, userId);
				@SuppressWarnings({ "unchecked" })
				List<Shipment> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return expList;
	}

	@Override
	public void choosefare(Shipment shipment) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Costing where fCity = ? and tCity = ?");
				q.setString(0, shipment.getFromCity());
				q.setString(1, shipment.getToCity());
				List<Costing> li = q.list();
				shipment.setTotalCharges(li.get(0).getT_Fare()); 
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public void insertshipment(Shipment shipment) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(shipment);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	

}
