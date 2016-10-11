package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class FlightsInfo {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static File csvData = new File(
			"src/test/resources/FlightsCodes.txt");
	private static CSVParser parser;

	List<Flight> flightsList;

	public static void main(String[] args) throws IOException, ParseException {
		FlightsInfo flightsInfo = new FlightsInfo();
		flightsInfo.flightsList();
		Map<String, Integer> airoportsList = flightsInfo
				.getListOfAllAirportsWithTotalNumberOfPlanes("2013-01-01",
						"2014-10-10");
		for (String key : airoportsList.keySet()) {
			System.out.println("Airport: " + key + " NumberOfPlanes:"
					+ airoportsList.get(key));
		}
		System.out.println("Task 2:");
		Map<String, Integer> airoportsListTask2 = flightsInfo
				.getDifferenceArrivedAndLeftTotalNumberOfPlanes("LAX", "JFK");
		for (String key : airoportsListTask2.keySet()) {
			System.out.println("Airport: " + key + " NumberOfPlanes:"
					+ airoportsListTask2.get(key));
		}

		System.out.println("Task 3:");
		Map<String, HashMap<String, Integer>> airoportsListTask3 = flightsInfo
				.getDifferenceArrivedAndLeftTotalNumberOfPlanesSumOfPlanesPerEachWeek(
						"2013-01-01", "2014-10-10");
		for (String key : airoportsListTask3.keySet()) {
			for (String key2 : airoportsListTask3.get(key).keySet()) {
				System.out.println("Airport: " + key + " Name:" + key2
						+ " NumberOfPlanes:"
						+ airoportsListTask3.get(key).get(key2));
			}
		}

		System.out.println("Done");
	}

	private static boolean checkPeriod(String from, String to, String in)
			throws ParseException {
		if (dateFormat.parse(from).getTime() <= dateFormat.parse(in).getTime()
				&& dateFormat.parse(to).getTime() >= dateFormat.parse(in)
						.getTime()) {
			return true;
		}
		return false;
	}

	private static String getWeekNumber(String date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(dateFormat.parse(date).getTime()));
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		return "Week" + week;
	}

	public List<Flight> flightsList() throws IOException, ParseException {
		List<Flight> flightsList = new LinkedList<>();
		parser = CSVParser.parse(csvData, Charset.defaultCharset(),
				CSVFormat.EXCEL.withHeader());
		for (CSVRecord csvRecord : parser) {
			Flight flight = new Flight();
			flight.setYear(Integer.parseInt(csvRecord.get("YEAR")));
			flight.setQuarter(Integer.parseInt(csvRecord.get("QUARTER")));
			flight.setMonth(Integer.parseInt(csvRecord.get("MONTH")));
			flight.setDayOfMonth(Integer.parseInt(csvRecord.get("DAY_OF_MONTH")));
			flight.setDayOfWeek(Integer.parseInt(csvRecord.get("DAY_OF_WEEK")));
			flight.setFlDate(csvRecord.get("FL_DATE"));
			flight.setOrigin(csvRecord.get("ORIGIN"));
			flight.setDest(csvRecord.get("DEST"));
			// System.out.println(flight);
			flightsList.add(flight);
		}
		this.flightsList = flightsList;
		return flightsList;
	}

	public Map<String, Integer> getListOfAllAirportsWithTotalNumberOfPlanes(
			String periodFrom, String periodTo) throws ParseException {
		HashMap<String, Integer> airoportsList = new HashMap<String, Integer>();
		for (Flight flight : flightsList) {
			if (checkPeriod(periodFrom, periodTo, flight.getFlDate())) {
				if (airoportsList.containsKey(flight.getDest())) {
					int fligtsCount = airoportsList.get(flight.getDest());
					fligtsCount++;
					airoportsList.put(flight.getDest(), fligtsCount);
				} else {
					airoportsList.put(flight.getDest(), 1);
				}
			}
		}
		return airoportsList;
	}

	public Map<String, Integer> getDifferenceArrivedAndLeftTotalNumberOfPlanes(
			String arrivedAirport, String leftAirport) {
		HashMap<String, Integer> airoportsList = new HashMap<String, Integer>();
		for (Flight flight : flightsList) {
			if (flight.getDest().equals(arrivedAirport)) {
				if (airoportsList.containsKey(arrivedAirport)) {
					int fligtsCount = airoportsList.get(arrivedAirport);
					fligtsCount++;
					airoportsList.put(arrivedAirport, fligtsCount);
				} else {
					airoportsList.put(arrivedAirport, 1);
				}
			}
			if (flight.getOrigin().equals(leftAirport)) {
				if (airoportsList.containsKey(leftAirport)) {
					int fligtsCount = airoportsList.get(leftAirport);
					fligtsCount--;
					airoportsList.put(leftAirport, fligtsCount);
				} else {
					airoportsList.put(leftAirport, -1);
				}
			}
		}
		return airoportsList;
	}

	public Map<String, HashMap<String, Integer>> getDifferenceArrivedAndLeftTotalNumberOfPlanesSumOfPlanesPerEachWeek(
			String periodFrom, String periodTo) throws ParseException {
		HashMap<String, HashMap<String, Integer>> weeksList = new HashMap<String, HashMap<String, Integer>>();
		for (Flight flight : flightsList) {
			if (checkPeriod(periodFrom, periodTo, flight.getFlDate())) {
				if (weeksList.containsKey(getWeekNumber(flight.getFlDate()))) {
					HashMap<String, Integer> airoport = weeksList
							.get(getWeekNumber(flight.getFlDate()));
					if (airoport != null && flight != null) {
						Integer fligtsCount = airoport.get(flight.getDest());
						if (fligtsCount == null) {
							fligtsCount = 0;
						}
						fligtsCount++;
						airoport.put(flight.getDest(), fligtsCount);
						weeksList.put(getWeekNumber(flight.getFlDate()),
								airoport);
					}
				} else {
					HashMap<String, Integer> airoportList = new HashMap<String, Integer>();
					airoportList.put(flight.getDest(), 1);
					weeksList.put(getWeekNumber(flight.getFlDate()),
							airoportList);
				}
			}
		}
		return weeksList;
	}
}