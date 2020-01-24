package Test.Olenick.AlMundo;

public class Flight {

	private String origin;
	private String destination;
	private String typeFrom;
	private String monthFrom;
	private String dateFrom;
	private String typeTo;
	private String monthTo;
	private String dateTo;
	private int adultNumber;
	private int childrenNumber;
	private int childIndex;
	private String flightClass;

	public Flight(String origin, String destination, String typeFrom, String monthFrom, String dateFrom, String typeTo,
			String monthTo, String dateTo, int adultNumber, int childrenNumber, int childIndex, String flightClass) {
		this.origin = origin;
		this.destination = destination;
		this.typeFrom = typeFrom;
		this.monthFrom = monthFrom;
		this.dateFrom = dateFrom;
		this.typeTo = typeTo;
		this.monthTo = monthTo;
		this.dateTo = dateTo;
		this.adultNumber = adultNumber;
		this.childrenNumber = childrenNumber;
		this.childIndex = childIndex;
		this.flightClass = flightClass;
	}

	protected String getOrigin() {
		return origin;
	}

	protected String getDestination() {
		return destination;
	}

	protected String getTypeFrom() {
		return typeFrom;
	}

	protected String getMonthFrom() {
		return monthFrom;
	}

	protected String getDateFrom() {
		return dateFrom;
	}

	protected String getTypeTo() {
		return typeTo;
	}

	protected String getMonthTo() {
		return monthTo;
	}

	protected String getDateTo() {
		return dateTo;
	}

	protected int getAdultNumber() {
		return adultNumber;
	}

	protected int getChildrenNumber() {
		return childrenNumber;
	}

	protected int getChildIndex() {
		return childIndex;
	}

	protected String getFlightClass() {
		return flightClass;
	}

}
