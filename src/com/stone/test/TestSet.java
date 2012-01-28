package com.stone.test;

import java.util.ArrayList;
import java.util.List;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List groupNames = new ArrayList();
//		groupNames.add("SadadAdmins");
		groupNames.add("sadadadmins");
		groupNames.add("wpsadmins");
		
		String groupsAllowed= "SadadAdmins|BanksAdmins|BillersAdmins";
		String[] groups = groupsAllowed.split("\\|");
		for(int i=0; i<groups.length; i++){
			if(groupNames.contains(groups[i])){
				System.out.println("matched!  group=" + groups[i]);
	
			}
		}
	}

}
