package org.hotel;
import java.io.IOException;
import org.helper.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class AdactinPage_3 extends BaseClass {
	@BeforeClass
	private void homePage() {
		browserLaunch(1);
		launchUrl("https://adactinhotelapp.com/");
		maxWin();
		waitTime();
	}
	@Test(groups = "Smoke")
	private void hotelSearch() throws IOException {
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
		DetailsPage d=new DetailsPage();
		passValue(d.getFirstName(), readFile("WorkSheet", "Employee Details", 1, 1, "dd/MM/yyyy"));
		passValue(d.getLastName(), readFile("WorkSheet", "Employee Details", 1, 2, "dd/MM/yyyy"));
		passValue(d.getAddress(), readFile("WorkSheet", "Employee Details", 1, 6, "dd/MM/yyyy"));
		passValue(d.getCcNum(), "9788347286462846");
		dropDown("VISA", d.getCcType());
		dropDown(d.getExpMonth(), "6");
		dropDown("2027", d.getExpYear());
		passValue(d.getCvv(), "8273");
		clickbtn(d.getBook());
	}
}
