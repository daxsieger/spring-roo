package org.springframework.roo.addon.displayname;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provides a method to display a pretty-print representation of a class for UIs.
 * 
 * @author Alan Stewart
 * @since 1.2.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface RooDisplayName {

	/**
	 * @return the name of the display name method to generate (defaults to "getDisplayName"; if empty, does not create)
	 */
	String methodName() default "getDisplayName";
	
	/**
	 * @return an array of fields to use in the display name method
	 */
	String[] fields() default "";
}