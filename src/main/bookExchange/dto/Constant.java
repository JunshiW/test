package main.bookExchange.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class Constant {
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map referenceData = new HashMap();
		Set<String> category = new HashSet();
		category.add("Architecture");
		category.add("Arts and Sciences");
		category.add("Agriculture, Food and Environmental Sciences");
		category.add("Business");
		category.add("Dentistry");
		category.add("Human Ecology");
		category.add("Engineering");
		category.add("Environment and Natural Resouces");
		category.add("Public Affairs");
		category.add("Law");
		category.add("Math and Physics");
		category.add("Medicine");
		category.add("Millitary Science");
		category.add("Nursing");
		category.add("Optometry");
		category.add("Pharmacy");
		category.add("Public Health");
		category.add("Social and Behaviroal Sciences");
		category.add("Veterinary Medicine");
		
		referenceData.put("categoryList", category);
		return referenceData;
	}

}
