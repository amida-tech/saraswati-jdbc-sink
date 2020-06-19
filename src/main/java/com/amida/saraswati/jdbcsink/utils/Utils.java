package com.amida.saraswati.jdbcsink.utils;

import java.util.List;

public class Utils {

	public static String[] convertListToArray(List<String> input) {

		String[] output = input.stream().toArray(String[]::new);

		return output;
	}
}
