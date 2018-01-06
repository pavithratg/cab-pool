package com.synex.pool.app;

import java.util.List;
import java.util.Scanner;

import com.synex.pool.beans.Cab;
import com.synex.pool.dao.CabDao;
import com.synex.pool.dao.CabPoolCreatorUtil;
import com.synex.pool.dao.InMemoryCabDao;

public class CabPoolApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("locations: " + CabPoolCreatorUtil.getLocations());
		System.out.println("Please enter the location:");
		String location = scan.nextLine();
		
		CabDao cabDao = new InMemoryCabDao();
		
		List<Cab> cabs = cabDao.getAvailableCabs(location);

		System.out.println("Available Cabs: " + cabs);
		
		System.out.println("Please select a cab, enter the index: ");
		
		int index = scan.nextInt();
		
		Cab cab = cabs.get(index);
		
		
		
		//cab = new CabPoolApp().checkCapacity(cab, cabs, scan);
		
		//cab.setCapacity(cab.getCapacity() + 1);
		
		//System.out.println(cabs);
		

	}
	
	public Cab checkCapacity(Cab cab, List<Cab> cabs, Scanner scan){
		if(cab.getCapacity().intValue() == cab.getMaxCapacity()){
			System.out.println("Cab capacity exceeded! Please select another cab");
			cabs.remove(cab);
			System.out.println(cabs);
			
			int index = scan.nextInt();
			
			cab = cabs.get(index);
			
			checkCapacity(cab, cabs, scan);
			
		}
		
		return cab;
		
	}

}
