package stepDefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	WebDriver driver;
	 String empid="";
	@Given("i launch  url {string} in a browser")
	public void i_launch_url_in_a_browser(String url) {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("i want to check login button displayed")
	public void i_want_to_check_login_button_displayed() {
	   if(driver.findElement(By.name("Submit")).isDisplayed())
	   {
		 //  System.out.println("Login button Displayed in Login page");
		   Reporter.log("Login button Displayed in Login page",true);
	   }
	}

	@When("i enter {string} in username")
	public void i_enter_in_username(String user) {
	    driver.findElement(By.name("txtUsername")).sendKeys(user);
	}

	@When("i enter {string} in password")
	public void i_enter_in_password(String pass) {
		driver.findElement(By.name("txtPassword")).sendKeys(pass);  
	}

	@When("i click login button")
	public void i_click_login_button() throws Throwable {
	    driver.findElement(By.name("Submit")).click();
	    Thread.sleep(4000);
	}

	@Then("i check admin is displayed")
	public void i_check_admin_is_displayed() {
	    if(driver.findElement(By.xpath("//b[normalize-space()='Admin']")).isDisplayed())
	    {
	    	//System.out.println("Admin Page is Displayed");
	    	Reporter.log("Admin Page is Displayed",true);
	    }
	}

	@When("i close browser")
	public void i_close_browser() {
		   driver.quit();
	}
	@Then("i verify url")
	public void i_verify_url() {
	    String Expected="dashboard";
	    String Actual= driver.getCurrentUrl();
	    if(Actual.contains(Expected))
	    {
	    	Reporter.log("Login Success",true);
	    }
	    else
	    {
	    	//capture error message
	    	String Error_mess = driver.findElement(By.id("spanMessage")).getText();
	    	Reporter.log(Error_mess,true);
	    }
	}
	@When("navigate to Add Employee")
	public void navigate_to_Add_Employee() {
	    driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
	    driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
	}

	@When("i enter {string} in first name")
	public void i_enter_in_first_name(String fname) {
	    driver.findElement(By.name("firstName")).sendKeys(fname);
	}

	@When("i enter {string} in middle name")
	public void i_enter_in_middle_name(String mname) {
		driver.findElement(By.name("middleName")).sendKeys(mname);
	}

	@When("i enter {string} in last name")
	public void i_enter_in_last_name(String lname) {
		driver.findElement(By.name("lastName")).sendKeys(lname);
	}

	@When("i capture employee id")
	public void i_capture_employee_id() {
	    empid = driver.findElement(By.name("employeeId")).getAttribute("value");
	}

	@When("i click save button")
	public void i_click_save_button() {
	    driver.findElement(By.id("btnSave")).click();
	}

	@Then("validate employee id in table")
	public void validate_employee_id_in_table() throws Throwable {
	    driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
	    driver.findElement(By.name("empsearch[id]")).sendKeys(empid);
	    driver.findElement(By.id("searchBtn")).click();
	    Thread.sleep(2000);
	    WebElement webtable = driver.findElement(By.id("resultTable"));
	    List<WebElement> rows = webtable.findElements(By.tagName("tr"));
	    for(int i=1;i<rows.size();i++)
	    {
	    	List<WebElement> cols =rows.get(i).findElements(By.tagName("td"));
	    	if(cols.get(i).getText().equals(empid))
	    	{
	    		Reporter.log("Employee id Found in table   "+empid,true);
	    	}
	    	else
	    	{
	    		Reporter.log("Employee id Not Found in table   "+empid,true);
	    	}
	    }
	}

}
