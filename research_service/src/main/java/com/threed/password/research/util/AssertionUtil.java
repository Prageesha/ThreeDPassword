package com.threed.password.research.util;

import java.util.Collection;


public class AssertionUtil {

	public static void validateNotNull(Object object, String errorMessage) {

		if (object == null) {
			throw new NullPointerException(errorMessage);
		}
	}

	public static void validateNotEmpty(Object object, String errorMessage) {

		validateNotNull(object, errorMessage);

		if (object instanceof String && ((String) object).isEmpty()) {
			try {
				throw new Exception(errorMessage);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (object instanceof Collection && ((Collection) object).isEmpty()) {
			try {
				throw new Exception(errorMessage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
		
	}

