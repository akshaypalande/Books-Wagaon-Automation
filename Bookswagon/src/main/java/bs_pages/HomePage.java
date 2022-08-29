package bs_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bs_baseclass.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//span[@class='usernametext']")

	WebElement userNameLabel;

	@FindBy(xpath = "//input[@id = 'ctl00$TopSearch1$txtSearch']")
	WebElement search;
	
	@FindBy(xpath = "//li[@class='active']//a[normalize-space()='Personal Settings']")
	WebElement personalSettings;

	@FindBy( linkText = "My Account" )
	WebElement myAccount;

	@FindBy(linkText = "My Orders")
	WebElement myOrders;

	@FindBy(linkText = "My Wishlist")
	WebElement myWishlist;

	@FindBy(linkText = "My Gift Certificates")
	WebElement myGiftCertificates;
	
	@FindBy(linkText = "My Addresses")
	WebElement myAddresses;
	
	@FindBy(linkText = "Change Password")
	WebElement changePassword;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	}
