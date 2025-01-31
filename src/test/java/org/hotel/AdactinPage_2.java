package org.hotel;
import org.helper.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class AdactinPage_2 extends BaseClass {
	@BeforeClass
	private void homePage() {
		browserLaunch(1);
		launchUrl("https://adactinhotelapp.com/");
		maxWin();
		waitTime();
	}
	@Test(groups = "Sanity")
	private void hotelSearch() {
		LoginPage l = new LoginPage();
		clickbtn(l.getBuild());
		passValue(l.getUserName(), "username1515");
		passValue(l.getPass(), "Manivel1515");
		clickbtn(l.getLogin());
		HotelSearch h = new HotelSearch();
		dropDown("London", h.getLocation());
		dropDown(h.getHotelName(), "Hotel Sunshine");
		dropDown(h.getRoomType(), "Double");
		h.getCheckIn().clear();
		passValue(h.getCheckIn(), "24/01/2025");
		h.getCheckOut().clear();
		passValue(h.getCheckOut(), "25/01/2025");
		dropDown("1 - One", h.getRoomCount());
		dropDown("2 - Two", h.getAdultCount());
		dropDown(h.getChildCount(), 1);
		clickbtn(h.getSubmit());
		clickbtn(h.getRadio());
		clickbtn(h.getCon());
	}	
}
