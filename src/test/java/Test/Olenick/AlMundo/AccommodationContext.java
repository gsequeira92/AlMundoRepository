package Test.Olenick.AlMundo;

public class AccommodationContext implements TestContext {
	private AlMundoAccommodationPage accommodationPage;
	private AlMundoHotelResultsPage resultsPage;
	private HotelBuilder builder;

	public AlMundoAccommodationPage getAccommodationPage() {
		return this.accommodationPage;
	}

	public void setAccommodationPage(AlMundoAccommodationPage accommodationPage) {
		this.accommodationPage = accommodationPage;
	}

	public AlMundoHotelResultsPage getResultsPage() {
		return this.resultsPage;
	}

	public void getResultsPage(AlMundoHotelResultsPage resultsPage) {
		this.resultsPage = resultsPage;
	}

	public HotelBuilder getBuilder() {
		return this.builder;
	}

	public void setBuilder(HotelBuilder builder) {
		this.builder = builder;
	}

	public void setDateFrom() {
		// TODO Auto-generated method stub
		
	}

	public void setDateTo() {
		// TODO Auto-generated method stub
		
	}
}
