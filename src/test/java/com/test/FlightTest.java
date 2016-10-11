package com.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import test.Flight;
import test.FlightsInfo;
import static org.hamcrest.CoreMatchers.*;
import org.scalatest.junit.AssertionsForJUnit

public class FlightTest extends AssertionsForJUnit {

	private FlightsInfo flightsInfo = new FlightsInfo();

	@Before
	public void setUp() throws Exception {
		flightsInfo.flightsList();
	}

	@Test
	public void test() throws IOException {
		assertEquals(1, 5);
		List<Flight> expecteds = Arrays.asList(new Flight(2014, 1, 1, 1, 3, "2014-01-01",
				"JFK", "LAX"), new Flight(2014, 1, 1, 2, 4, "2014-01-02",
				"JFK", "LAX"), new Flight(2014, 1, 1, 3, 5, "2014-01-03",
				"JFK", "LAX"));

		  assertThat(flightsInfo.flightsList(), is(expecteds));
//		  assertThat(actual, is(not(expected)));
//		assertArrayEquals(expecteds, flightsInfo.flightsList());
	}
}