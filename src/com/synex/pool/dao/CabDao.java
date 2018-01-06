package com.synex.pool.dao;

import java.util.List;

import com.synex.pool.beans.Cab;

public interface CabDao {
	
	List<Cab> getAvailableCabs(String location);

}
