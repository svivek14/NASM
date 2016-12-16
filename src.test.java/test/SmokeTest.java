package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;







import pageobject.*;
import utils.DateTimeMethods;
import common.CommonMethods;
import common.DriverFactory;


public class SmokeTest {
	static WebDriver driver;
	public static CommonMethods com;
	HomePage homePage;
	LoginPage loginPage; 
	UserResterationPage userResterationPage;
	ELearningCenterPage eLearningCenterPage;
	ProductsListPage productsListPage;
	ProductDetailsPage productDetailsPage;
	ShoppingCartPage shoppingCartPage;
	CheckOutPage checkOutPage;
	EnrollmentKeyPage enrollmentKeyPage;
	CoursesPage coursesPage;
	CertificatesPage certificatesPage;
	OrderConfirmationPage orderConfirmationPage;
	HistoryPage historyPage;
	AccountsPage accountsPage;
	MoodleHomePage moodleHomePage;
	SiteCalendarPage siteCalendarPage;
	ViewProfilePage viewProfilePage;
	DateTimeMethods dateTimeMethods;
	ReCertificationPage reCertificationPage;



	Properties prop = CommonMethods.prop;
	String userName = prop.getProperty("userName");
	String password = prop.getProperty("password");

	String strResult=null;
	String strUsername=null;
	String strPassword=null;
	String strEmail=null;
	boolean flag=false;


	@BeforeClass
	public void setUp(){
		driver = DriverFactory.setUpDriver();
		homePage = new HomePage(driver);
		dateTimeMethods=new DateTimeMethods();

	}

	@Test(priority=1)
	public void Register_New_User_NASM13() throws Exception{
		homePage = new HomePage(driver);
		
		strResult=DateTimeMethods.getCurrentDate("ddMMyyyyhhmmss");
		strUsername=prop.getProperty("username")+strResult;
		strEmail=strUsername+prop.getProperty("emaildomain");
		System.out.println(strUsername);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		
		userResterationPage=homePage.clickOnRegisterButton();

		flag= userResterationPage.isRegisterationPageDisplayed(prop.getProperty("pagetitle"));
		Assert.assertTrue(flag);

		eLearningCenterPage=userResterationPage.registeraUserWithShipAddSameAsBillingAdd(prop.getProperty("firstname"), prop.getProperty("lastname"), strUsername,
				strEmail, prop.getProperty("passowrd"), prop.getProperty("passowrd"), prop.getProperty("pwdrecovquestion"),
				prop.getProperty("pwdrecovanswer"), prop.getProperty("phonenumber"), prop.getProperty("billingaddress_address1"), 
				prop.getProperty("billingaddress_address2"), prop.getProperty("billingaddress_city"), prop.getProperty("billingaddress_locality"), 
				prop.getProperty("billingaddress_state"),prop.getProperty("billingaddress_zipcode"), prop.getProperty("billingaddress_country"));
		eLearningCenterPage.clickOnLogoffTab();
	}


	//@Test(priority=2)
	public void Student_Portal_NASM139() throws Exception{
		homePage = new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		loginPage=(LoginPage)homePage.clickOnMyAccountLink();
		eLearningCenterPage= loginPage.doLogin( userName, password);

		Assert.assertTrue(eLearningCenterPage.isNASMLogoPresent());
		Assert.assertTrue(eLearningCenterPage.isNASMLogoPresent());

		Assert.assertEquals(eLearningCenterPage.getUserName(),"Hello, "+prop.getProperty("firstname")+" "+prop.getProperty("lastname")+"!");

		coursesPage=eLearningCenterPage.clickOnCourseTab();
		Assert.assertTrue(coursesPage.isCoursesPageDisplayed(prop.getProperty("coursespage_title")));

		historyPage= coursesPage.clickOnHistoryTab();
		Assert.assertEquals(historyPage.getPageHeader(), prop.getProperty("historypage_pageheader"));

		certificatesPage=historyPage.clickOnCertificatesTab();
		Assert.assertEquals(certificatesPage.getPageHeader(), prop.getProperty("certificatespage_header"));

		accountsPage=certificatesPage.clickOnAccountTab();
		Assert.assertEquals(accountsPage.getPageHeader(), prop.getProperty("accountpage_header"));
		Assert.assertTrue(accountsPage.isLabelDisplayed(prop.getProperty("accountpage_Username")));
		Assert.assertTrue(accountsPage.isLabelDisplayed(prop.getProperty("accountpage_Firstname")));
		Assert.assertTrue(accountsPage.isLabelDisplayed(prop.getProperty("accountpage_Lastname")));
		Assert.assertTrue(accountsPage.isLabelDisplayed(prop.getProperty("accountpage_Email")));
		Assert.assertTrue(accountsPage.isLabelDisplayed(prop.getProperty("accountpage_Suspended")));
		Assert.assertTrue(accountsPage.isLabelDisplayed(prop.getProperty("accountpage_Supendedreason")));
		Assert.assertTrue(accountsPage.isChangeButtonDisplayed());

		enrollmentKeyPage=accountsPage.clickOnEnrollmentKeyTab();
		Assert.assertEquals(enrollmentKeyPage.getPageHeader(), prop.getProperty("enrollmentkeypage_header"));

		reCertificationPage=enrollmentKeyPage.clickOnReCertificationTab();

		Assert.assertEquals(reCertificationPage.getMessage(), prop.getProperty("recertificationpage_message"));

		enrollmentKeyPage.clickOnLogoffTab();

	}	


	//@Test(priority=3)
	public void Redeem_Enrollment_Key_NASM121() throws Exception{
		homePage = new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		loginPage=(LoginPage)homePage.clickOnMyAccountLink();

		eLearningCenterPage= loginPage.doLogin( strUsername, prop.getProperty("passowrd"));
		eLearningCenterPage.iseLearningCenterPageDisplayed(prop.getProperty("elearningcenterPage_title"));

		enrollmentKeyPage=eLearningCenterPage.clickOnEnrollmentKeyTab();

		Assert.assertTrue(enrollmentKeyPage.isEnrollmentKeyPageDisplayed(prop.getProperty("enrollmentkeypage_title")));

		enrollmentKeyPage.enterEnrollmentkey(prop.getProperty("enrollmentkeypage_redeemAll_enrollmentkey"));
		enrollmentKeyPage.clickOnNextButton();
		enrollmentKeyPage.clickOnRedeemAllCoursesButton();


		coursesPage=enrollmentKeyPage.clickOnCourseTab();
		Assert.assertTrue(coursesPage.isCourseDisplayed(prop.getProperty("coursename_afaaceucorner")));
		coursesPage.clickOnLogoffTab();

	}


	//@Test(priority=4)
	public void Verify_User_Can_View_Certificate_NASM122() throws Exception{

		homePage = new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		loginPage=(LoginPage)homePage.clickOnMyAccountLink();

		eLearningCenterPage= loginPage.doLogin( strUsername, strPassword);
		Assert.assertTrue(eLearningCenterPage.iseLearningCenterPageDisplayed(prop.getProperty("elearningcenterPageTitle")));

		certificatesPage=eLearningCenterPage.clickOnCertificatesTab();
		Assert.assertTrue(certificatesPage.isCertificatesPageDisplayed(prop.getProperty("certificatespage.pagetitle")));
		Assert.assertTrue(certificatesPage.isCertificateDisplayed(prop.getProperty("certificatespage.workshop")));

		// certificatesPage.clickOnViewCertificateButton(prop.getProperty("certificatespage.workshop"));
		certificatesPage.download();
		// Assert.assertTrue(certificatesPage.isCertificateHasCourseName(prop.getProperty("certificatespage.workshop")));

	}


	//@Test(priority=5)
	public void Purchase_product_NASM122() throws Exception{

		homePage=new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		loginPage=homePage.clickOnLoginuBtton();
		loginPage.doLogin(strUsername,  prop.getProperty("passowrd"));
		homePage.clickOnContinuingEducation();
		productsListPage=homePage.clickOnAllCoursesLink();
		productDetailsPage=productsListPage.selectProduct(prop.getProperty("productName_cptguidedstudyprogram"));
		shoppingCartPage=productDetailsPage.clickOnAddToCartButton();
		Assert.assertTrue(shoppingCartPage.isShoppingCartPageDisplayed());
		Assert.assertTrue(shoppingCartPage.isproductPresentInCart(prop.getProperty("productName_cptguidedstudyprogram")));
		Assert.assertTrue(shoppingCartPage.isChekOutButtonDisplayed());

		checkOutPage=shoppingCartPage.clickOnChekOutButton();

		Assert.assertTrue(checkOutPage.isShippingOptionsDisplayed());
		checkOutPage.selectShippingOPtions(prop.getProperty("shippingoptions_ground_shipping"));
		checkOutPage.clickOnShippingOptNextButton();

		checkOutPage.enterCardHolderName(prop.getProperty("braintree_cardholdername"));
		checkOutPage.enterCardNumber(prop.getProperty("braintree_visa_cardnumber"));
		checkOutPage.enterCVV(prop.getProperty("braintree_cvv"));
		checkOutPage.enterExpirationMonth(prop.getProperty("braintree_expiration_month"));
		checkOutPage.enterExpirationYear(prop.getProperty("braintree_expiration_year"));
		checkOutPage.checkTermsAndConditionsCheckbox();
		orderConfirmationPage=checkOutPage.clickOnPlaceThisOrderButton();
		Assert.assertTrue(orderConfirmationPage.isOrderConfirmationPageDisplayed());

		eLearningCenterPage=(ELearningCenterPage)orderConfirmationPage.clickOnMyAccountLink();
		Assert.assertTrue(eLearningCenterPage.iseLearningCenterPageDisplayed(prop.getProperty("elearningcenterPage_title")));
		coursesPage=eLearningCenterPage.clickOnCourseTab();
		Assert.assertTrue(coursesPage.isCourseDisplayed(prop.getProperty("coursename_certifiedpersonaltrainerguidedstudy")));
		coursesPage.clickOnLogoffTab();

	}	


	//@Test(priority=6)
	public void Verify_Register_Link_NASM128() throws Exception{
		System.out.println("details:"+prop.getProperty("username")+strPassword+strEmail);
		homePage=new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		Assert.assertTrue(homePage.isLoginWidgetDisplayed());
		userResterationPage=homePage.clickOnRegisterButton();
		Assert.assertTrue(userResterationPage.isRegisterationPageDisplayed(prop.getProperty("pagetitle")));
	}	


	//@Test(priority=7)
	public void Verify_Login_LogoutLink_NASM126_NASM127() throws Exception{

		homePage=new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		Assert.assertTrue(homePage.isLoginWidgetDisplayed());


		loginPage=homePage.clickOnLoginuBtton();
		loginPage.doLogin(prop.getProperty("loginpage.username"),prop.getProperty("loginpage.password"));


		strResult= homePage.getFirstName().toLowerCase();
		Assert.assertEquals(prop.getProperty("loginpage.firstname"), strResult.substring(strResult.indexOf(",")+1).trim());

		Assert.assertTrue(homePage.isLogoutButtontDisplayed());

		homePage.clickOnLogoutbutton();
		Assert.assertFalse(homePage.isLogoutButtontDisplayed());

	}


	//@Test(priority=7)
	public void Verify_MyAccountLink_NASM781() throws Exception{

		homePage=new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		Assert.assertTrue(homePage.isLoginWidgetDisplayed());


		loginPage=(LoginPage)homePage.clickOnMyAccountLink();
		Assert.assertTrue(loginPage.isLoginPageDisplayed());


		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		loginPage=homePage.clickOnLoginuBtton();
		loginPage.doLogin(prop.getProperty("loginpage.username"),prop.getProperty("loginpage.password"));

		strResult= homePage.getFirstName().toLowerCase();
		Assert.assertEquals(prop.getProperty("loginpage.firstname"), strResult.substring(strResult.indexOf(",")+1).trim());

		eLearningCenterPage=(ELearningCenterPage)homePage.clickOnMyAccountLink();
		Assert.assertTrue(eLearningCenterPage.iseLearningCenterPageDisplayed(prop.getProperty("elearningcenterPage_title")));

		eLearningCenterPage.clickOnLogoffTab();

	}



	//@Test(priority=9)
	public void Verify_Link_In_Moodle_NASM123() throws Exception{

		homePage=new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));

		loginPage=(LoginPage)homePage.clickOnMyAccountLink();
		// loginPage.doLogin(prop.getProperty("loginpage.username"),prop.getProperty("loginpage.password"));
		eLearningCenterPage= loginPage.doLogin("paloips3@mailinator.com","password1");

		coursesPage=eLearningCenterPage.clickOnCourseTab();
		moodleHomePage= coursesPage.clickOnActionButtonOfCourse(prop.getProperty("coursename_nasmcpt4internationalexam"));

		moodleHomePage.clickOnMyHome();
		Assert.assertTrue(moodleHomePage.getPageHeader().contains(prop.getProperty("moodle_myhome_header")));


		moodleHomePage.clickOnSitePages();
		moodleHomePage.clickOnSitebadges();
		Assert.assertEquals(prop.getProperty("moodle_sitepages_sitebadges_maincontentheader"), moodleHomePage.getMainContentHeader());

		moodleHomePage.clickOnTags();
		Assert.assertEquals(moodleHomePage.getMainContentHeader(),prop.getProperty("moodle_sitepages_sitetags_maincontentheader"));

		siteCalendarPage= moodleHomePage.clickOnCalendar();
		Assert.assertTrue(siteCalendarPage.isCalendarPageDisplayed());

		moodleHomePage.clickOnMyProfile();
		viewProfilePage= moodleHomePage.clickOnViewProfile();
		Assert.assertTrue(viewProfilePage.isViewProfilePageDisplayed());

		moodleHomePage.clickOnMessages();
		Assert.assertTrue(moodleHomePage.getPageHeader().contains(prop.getProperty("moodle_myprofile_messages_maincontentheader")));

		moodleHomePage.clickOnMyPrivateFiles();
		Assert.assertTrue(moodleHomePage.getPageHeader().contains(prop.getProperty("moodle_myprofile_myprivatefiles_maincontentheader")));

		moodleHomePage.clickOnMybadges();
		Assert.assertTrue(moodleHomePage.getPageHeader().contains(prop.getProperty("moodle_myprofile_mybadges_maincontentheader")));

		moodleHomePage.clickOnLogout();
	}



	//@Test(priority=9)
	public void Verify_ActOnForm__NASM706() throws Exception{

		homePage=new HomePage(driver);
		homePage.loadURL(prop.getProperty("stg.homepage.url"));
		strResult=DateTimeMethods.getCurrentDate("ddMMyyyyhhmm");
		strEmail=strUsername+prop.getProperty("emaildomain");
		homePage.submitStayConnectedForm(prop.getProperty("firstname"), prop.getProperty("lastname"), strEmail, prop.getProperty("phonenumber"));
	}

	@AfterClass
	public void tearDown(){
		DriverFactory.shutDownDriver();
	}

}
