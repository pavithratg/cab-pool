package com.synex.pool.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.synex.pool.beans.Cab;

public class InMemoryCabDao implements CabDao {

	@Override
	public List<Cab> getAvailableCabs(String location) {
		List<Cab> cabList = new ArrayList<Cab>();

		CabObjectPool cabObjectPool = new CabObjecPoolImpl();
		Map<Cab, AtomicInteger> cabMap = cabObjectPool.getUnlocked();

		if (!cabMap.keySet().isEmpty()) {
			for (Cab cab : cabMap.keySet()) {

				if (cab.getLocation().equals(location)) {
					cabList.add(cab);
				}

			}

			if (cabList.isEmpty()) {
				cabList = getCabsList(location);
				
				for (Cab cab : cabList) {
					cabMap.put(cab, cab.getCapacity());
				}
			}
		} else {
			cabList = getCabsList(location);
			
			for (Cab cab : cabList) {
				cabMap.put(cab, cab.getCapacity());
			}
		}

		return cabList;
	}

	public List<Cab> getCabsList(String location) {
		
		List<Cab> cabList = CabPoolCreatorUtil.getCabPoolMap().get(location);
		return cabList;

	}

}
