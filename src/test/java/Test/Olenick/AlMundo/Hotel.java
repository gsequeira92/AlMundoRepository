package Test.Olenick.AlMundo;

public class Hotel {

	private String hotelLocation;
	private String monthFrom;
	private String dateFrom;
	private String monthTo;
	private String dateTo;
	private String typeFrom;
	private String typeTo;
	private int rooms;
	private int adultNumber;
	private int childrenNumber;
	private int childIndex;

	public Hotel(String hotelLocation, String dateFrom, String dateTo, String monthFrom, String monthTo,
			String typeFrom, String typeTo, int rooms, int adultNumber, int childrenNumber, int childIndex) {

		this.hotelLocation = hotelLocation;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.monthFrom = monthFrom;
		this.monthTo = monthTo;
		this.typeFrom = typeFrom;
		this.typeTo = typeTo;
		this.rooms = rooms;
		this.adultNumber = adultNumber;
		this.childrenNumber = childrenNumber;
		this.childIndex = childIndex;
	}

	protected String getHotelLocation() {
		return hotelLocation;
	}

	protected String getDateFrom() {
		return dateFrom;
	}

	protected String getDateTo() {
		return dateTo;
	}

	protected int getRooms() {
		return rooms;
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

	protected String getTypeFrom() {
		return typeFrom;
	}

	protected String getTypeTo() {
		return typeTo;
	}

	protected String getMonthFrom() {
		return monthFrom;
	}

	protected String getMonthTo() {
		return monthTo;
	}

}
