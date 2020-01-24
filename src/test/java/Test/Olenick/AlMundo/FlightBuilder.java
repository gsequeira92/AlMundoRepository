package Test.Olenick.AlMundo;

public class FlightBuilder {

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

	public FlightBuilder() {

	}

	public FlightBuilder flightOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public FlightBuilder flightDestination(String destination) {
		this.destination = destination;
		return this;
	}

	public FlightBuilder flightTypeFrom(String type) {
		this.typeFrom = type;
		return this;
	}

	public FlightBuilder flightMonthFrom(String month) {
		this.monthFrom = month;
		return this;
	}

	public FlightBuilder flightDateFrom(String date) {
		this.dateFrom = date;
		return this;
	}

	public FlightBuilder flightTypeTo(String type) {
		this.typeTo = type;
		return this;
	}

	public FlightBuilder flightMonthTo(String month) {
		this.monthTo = month;
		return this;

	}

	public FlightBuilder flightDateTo(String date) {
		this.dateTo = date;
		return this;
	}

	public FlightBuilder flightAdultNumber(int adultNumber) {
		this.adultNumber = adultNumber;
		return this;
	}

	public FlightBuilder flightChildrenNumber(int children) {
		this.childrenNumber = children;
		return this;
	}

	public FlightBuilder flightAgeIndex(int index) {
		this.childIndex = index;
		return this;
	}

	public FlightBuilder flightClass(String flightClass) {
		this.flightClass = flightClass;
		return this;
	}

	public Flight build() {
		return new Flight(this.origin, this.destination, this.typeFrom, this.monthFrom, this.dateFrom, this.typeTo,
				this.monthTo, this.dateTo, this.adultNumber, this.childrenNumber, this.childIndex, this.flightClass);
	}

}
