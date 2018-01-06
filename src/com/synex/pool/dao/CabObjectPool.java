package com.synex.pool.dao;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.synex.pool.beans.Cab;

public abstract class CabObjectPool {

	private ConcurrentHashMap<Cab, AtomicInteger> locked, unlocked;

	public CabObjectPool() {

		locked = new ConcurrentHashMap<>();
		unlocked = new ConcurrentHashMap<>();
	}

	public abstract Cab create(String input);

	public Cab checkout(String input) {
		Cab c = null;

		if (unlocked.size() > 0) {
			Iterator<Cab> itr = unlocked.keySet().iterator();

			while (itr.hasNext()) {
				c = itr.next();
				if (c.getLocation().equals(input) && c.getCapacity().intValue() < c.getMaxCapacity()) {
					c.setCapacity(new AtomicInteger(c.getCapacity().incrementAndGet()));

					if (c.getCapacity().intValue() == c.getMaxCapacity()) {
						locked.put(c, c.getCapacity());
					}
					unlocked.put(c, c.getCapacity());

				}
			}
		} else {
			c = create(input);
			locked.put(c, c.getCapacity());
		}
		return c;
	}

	public ConcurrentHashMap<Cab, AtomicInteger> getLocked() {

		return locked;
	}

	public ConcurrentHashMap<Cab, AtomicInteger> getUnlocked() {
		return unlocked;
	}

}
