package com.synex.pool.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.synex.pool.beans.Cab;

public class CabPoolCreatorUtil {

	private static Map<String, List<Cab>> poolMap = new HashMap<>();
	private static List<Cab> cabPool1 = new ArrayList<>();
	private static List<Cab> cabPool2 = new ArrayList<>();
	private static List<Cab> cabPool3 = new ArrayList<>();
	private static List<Cab> cabPool4 = new ArrayList<>();
	private static List<String> locations = new ArrayList<>();

	static {
		createPool();
		createLocationList();
	}

	private static void createLocationList() {
		locations.add("Fremont");
		locations.add("San Francisco");
		locations.add("San Jose");
		locations.add("Sunnyvale");
	}

	private static void createPool() {
		Cab cab1 = new Cab("5trsd", "San Jose", 3);
		Cab cab2 = new Cab("8uytr", "San Jose", 4);
		Cab cab3 = new Cab("9jhfd", "Fremont", 3);
		Cab cab4 = new Cab("3drgf", "Fremont", 4);
		Cab cab5 = new Cab("6hyts", "San Fransisco", 3);
		Cab cab6 = new Cab("2drgt", "San Fransisco", 4);
		Cab cab7 = new Cab("1fgtr", "Sunnyvale", 3);
		Cab cab8 = new Cab("4gjuj", "Sunnyvale", 4);

		cabPool1.add(cab1);
		cabPool1.add(cab2);
		cabPool2.add(cab3);
		cabPool2.add(cab4);
		cabPool3.add(cab5);
		cabPool3.add(cab6);
		cabPool4.add(cab7);
		cabPool4.add(cab8);

		poolMap.put("San Jose", cabPool1);
		poolMap.put("Fremont", cabPool2);
		poolMap.put("Sunnyvale", cabPool4);
		poolMap.put("San Francisco", cabPool3);

	}

	public static Map<String, List<Cab>> getCabPoolMap() {
		return poolMap;
	}

	public static List<String> getLocations() {
		return locations;
	}

}
