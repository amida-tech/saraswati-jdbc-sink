package com.amida.saraswati.jdbcsink.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

	public static String[] convertListToArray(List<String> input) {

		String[] output = input.stream().toArray(String[]::new);

		return output;
	}
	public static Set<String> convertListToSet(List<String> input) {
		
		Set<String> output = new HashSet<String>();

		for (String entry : input) {
			output.add(entry);
		}
		return output;
	}
}
