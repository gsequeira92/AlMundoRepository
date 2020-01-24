package Test.Olenick.AlMundo;

public class HotelBuilder {

	private String hotelLocation;
	private String dateFrom;
	private String dateTo;
	private String monthFrom;
	private String monthTo;
	private String typeFrom;
	private String typeTo;
	private int rooms;
	private int adultNumber;
	private int childrenNumber;
	private int childIndex;

	public HotelBuilder() {

	}

	public HotelBuilder hotelMonthFrom(String month) {
		this.monthFrom = month;
		return this;
	}

	public HotelBuilder hotelMonthTo(String month) {
		this.monthTo = month;
		return this;
	}

	public HotelBuilder hotelTypeFrom(String type) {
		this.typeFrom = type;
		return this;
	}

	public HotelBuilder hotelTypeTo(String type) {
		this.typeTo = type;
		return this;
	}

	public HotelBuilder hotelLocation(String location) {
		this.hotelLocation = location;
		return this;
	}

	public HotelBuilder dateFrom(String date) {
		this.dateFrom = date;
		return this;
	}

	public HotelBuilder dateTo(String date) {
		this.dateTo = date;
		return this;
	}

	public HotelBuilder numberOfRooms(int rooms) {
		this.rooms = rooms;
		return this;
	}

	public HotelBuilder adultNumber(int adults) {
		this.adultNumber = adults;
		return this;
	}

	public HotelBuilder childNumber(int childs) {
		this.childrenNumber = childs;
		return this;
	}

	public HotelBuilder childAgeOption(int option) {
		this.childIndex = option;
		return this;
	}

	public Hotel build() {
		return new Hotel(this.hotelLocation, this.dateFrom, this.dateTo, this.monthFrom, this.monthTo, this.typeFrom,
				this.typeTo, this.rooms, this.adultNumber, this.childrenNumber, this.childIndex);

	}

}
