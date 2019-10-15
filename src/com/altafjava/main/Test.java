package com.altafjava.main;

import java.util.HashMap;
import com.altafjava.util.AltafHashMap;

public class Test {
	public static void main(String[] args) {
		AltafHashMap altafHashMap = new AltafHashMap();
//		HashMap altafHashMap = new HashMap();
		altafHashMap.put("111", "Altaf");
		altafHashMap.put(555, "Sam");
		altafHashMap.put("ajay", "Gandhi");
		System.out.println(altafHashMap);
		altafHashMap.put("ajay", "Rahul");
		System.out.println(altafHashMap);
		altafHashMap.put("salary", 15000);
		System.out.println(altafHashMap);
		System.out.println(altafHashMap.get(555));
		System.out.println(altafHashMap.get("111"));
	}
}
