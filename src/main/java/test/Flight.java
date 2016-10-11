package test;

public class Flight {

	private int year;
	private int quarter;
	private int month;
	private int dayOfMonth;
	private int dayOfWeek;
	private String flDate;
	private String origin;
	private String dest;

	public Flight() {
	}

	public Flight(int year, int quarter, int month, int dayOfMonth,
			int dayOfWeek, String flDate, String origin, String dest) {
		this.year = year;
		this.quarter = quarter;
		this.month = month;
		this.dayOfMonth = dayOfMonth;
		this.dayOfWeek = dayOfWeek;
		this.flDate = flDate;
		this.origin = origin;
		this.dest = dest;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getFlDate() {
		return flDate;
	}

	public void setFlDate(String flDate) {
		this.flDate = flDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dayOfMonth;
		result = prime * result + dayOfWeek;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((flDate == null) ? 0 : flDate.hashCode());
		result = prime * result + month;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + quarter;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (dayOfMonth != other.dayOfMonth)
			return false;
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (flDate == null) {
			if (other.flDate != null)
				return false;
		} else if (!flDate.equals(other.flDate))
			return false;
		if (month != other.month)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (quarter != other.quarter)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return year + ";" + quarter + ";" + month + ";" + dayOfMonth + ";"
				+ dayOfWeek + ";" + flDate + ";" + origin + ";" + dest;
	}

}