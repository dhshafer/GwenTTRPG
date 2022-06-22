package com.valterius.dao;

import java.util.List;

import com.valterius.model.Mechanic;

public interface MechanicDao {
	/*
	 * get all (list)
	 * get by id
	 * add
	 * edit
	 * delete
	 */
	List<Mechanic> getAllMechanics();
	Mechanic getMechanicById(Mechanic mechanic);
	Mechanic addMechanic(Mechanic mechanic);
	Mechanic editMechanic(Mechanic mechanic);
	void deleteMechanic(Mechanic mechanic);
}
