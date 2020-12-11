package com.dsr.java.java8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void createEmptyOptionalTest() {
		// create empty optional and check if values is present or not using isPresent()
		Optional<String> emptyOptional = Optional.empty();
		assertFalse(emptyOptional.isPresent());
	}

	@Test
	public void createOptionalFromString() {
		Optional<String> nonEmptyOptional = Optional.of("name");
		assertTrue(nonEmptyOptional.isPresent());

		// NullPointerException will be thrown.
		// Optional<String> emptyOptional1 = Optional.of(null);

	}

	@Test
	public void createOptionalFromStringOrNullValue() {
		Optional<String> nonEmptyOptional = Optional.ofNullable(null);
		assertFalse(nonEmptyOptional.isPresent());
	}

	@Test
	public void ifPresentOptionalcheck() {
		Optional<String> nonEmptyOptional = Optional.of("name");
		nonEmptyOptional.ifPresent(x -> {
			System.out.println(x.length());
		});
	}

	@Test
	public void orElseOptionalCheck() {
		// orElse getting used as Optional has null value.
		Optional<String> emptyOptional = Optional.ofNullable(null);
		String value = emptyOptional.orElse("default Value");
		assertEquals("default Value", value);

		// orElse not getting used as Optional has non null value.
		Optional<String> nonEmptyOptional = Optional.ofNullable("orginal");
		String value1 = nonEmptyOptional.orElse("default Value");
		assertEquals("orginal", value1);
	}

	@Test
	public void orElseGetOptionalCheck() {
		// orElse getting used as Optional has null value.
		Optional<String> emptyOptional = Optional.ofNullable(null);
		String value = emptyOptional.orElseGet(()->"default value");
		assertEquals("default value", value);

		// orElse not getting used as Optional has non null value.
		Optional<String> nonEmptyOptional = Optional.ofNullable("orginal");
		String value1 = nonEmptyOptional.orElseGet(()->"default value");
		assertEquals("orginal", value1);
	}

	@Test(expected = NullPointerException.class)
	public void OrElseThrowCheck() {
	    String nullName = null;
	    String value = Optional.ofNullable(nullName).orElseThrow(
	      NullPointerException::new);
	}
	
	@Test
	public void getMethodCheck() {
		Optional<String> nonEmptyOptional = Optional.ofNullable("orginal");
	    String value = nonEmptyOptional.get();
	    assertEquals("orginal", value);
	}
}
