package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefixs;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefixs = theCourseCode.value();
	}
	
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result = false;
		if(theCode != null) {
			for(String tempPrefix : coursePrefixs) {
				result = theCode.startsWith(tempPrefix);
				
				if(result)
					break;
			}
			
		}
		else {
			result = true;
		}
		return result;
	}
}
