package org.hotel;
import org.helper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HotelSearch extends BaseClass {
	public HotelSearch() {
		PageFactory.initElements(driver, this);
	}
	public @FindBy(xpath="//select[@id='location']") WebElement location;
	public @FindBy(xpath="//select[@id='hotels']") WebElement hotelName;
	public @FindBy(xpath="//select[@id='room_type']") WebElement roomType;  
	public @FindBy(xpath="//select[@id='room_nos']") WebElement roomCount;  
	public @FindBy(xpath="//input[@id='datepick_in']") WebElement checkIn; 
	public @FindBy(xpath="//input[@id='datepick_out']") WebElement checkOut;  
	public @FindBy(xpath="//select[@id='adult_room']") WebElement adultCount;  
	public @FindBy(xpath="//select[@id='child_room']") WebElement childCount;  
	public @FindBy(xpath="//input[@id='Submit']") WebElement submit;
	public @FindBy(xpath = "//input[@type='radio']") WebElement radio;
	public @FindBy(id = "continue") WebElement con;
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotelName() {
		return hotelName;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getRoomCount() {
		return roomCount;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getAdultCount() {
		return adultCount;
	}
	public WebElement getChildCount() {
		return childCount;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getRadio() {
		return radio;
	}
	public WebElement getCon() {
		return con;
	}
}
