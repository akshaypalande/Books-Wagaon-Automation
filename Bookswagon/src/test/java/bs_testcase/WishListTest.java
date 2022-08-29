package bs_testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import bs_baseclass.BaseClass;
import bs_pages.WishList;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import bs_pages.Login_Page;

import org.apache.log4j.Logger;
import org.testng.Assert;


public class WishListTest extends BaseClass {
	
	Login_Page loginPage;
	WishList wishlist;
	Logger log = Logger.getLogger(WishListTest.class);

	public WishListTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new Login_Page();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		wishlist = new WishList();
	}

	@Test(priority = 1)
	public void feature_authTest() throws InterruptedException {
		log.info("Feature Author Method Runing...");
		wishlist.feature_auth();
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title, "Buy Best Selling William Wordsworth Books Online at Bookswagon");
		System.out.println("title:"+title);
	}

	@Test(priority = 2)
	public void search_BookNameTest() throws InterruptedException {
		log.info("Search by book name Method Runing...");
		wishlist.search_BookName(prop.getProperty("addwishlistByBookname"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"power of subconscious mind - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 3)
	public void addWishlist_AuthorNameTest() throws InterruptedException {
		log.info("Search by Author name Method Runing...");
		wishlist.addWishlist_AuthorName(prop.getProperty("addwishlistByAuthor"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"arundhati roy - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 4)
	public void addWishlist_PublisherTest() throws InterruptedException {
		log.info("Search by Publisher Method Runing...");
		wishlist.addWishlist_Publisher(prop.getProperty("addwishlistByPublisher"));
		String title = wishlist.validateWishListPageTitle();
		Assert.assertEquals(title,"manjul publishing house pvt ltd - Books - 24x7 online bookstore Bookswagon.com");
		System.out.println("title:"+title);
	}

	@Test(priority = 5)
	public void wishlist_Test() throws InterruptedException {
		log.info("Wishlist Method Runing...");
		wishlist.wish_list();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("browser is closed");

	}

}