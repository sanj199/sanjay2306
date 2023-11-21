package Amazonshoping;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;



public class amazonshopingtest {
	
	 WebDriver driver =new ChromeDriver();

	    @BeforeClass
	    public void setUp() {
	        // Set the path to the ChromeDriver executable
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Initialize ChromeDriver
	      
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    @Test(priority = 1)
	    public void loginToAmazon() {
	        driver.get("https://www.amazon.in/");

	        // Find the Sign In link and click
	        WebElement signInLink = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	        signInLink.click();

	        //  login
	        WebElement emailField = driver.findElement(By.id("ap_email"));
	        emailField.sendKeys("snjchauhan6@gmail.com");

	        WebElement passwordField = driver.findElement(By.id("ap_password"));
	        passwordField.sendKeys("sanjaychauhansan");

	        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
	        signInButton.click();
	    }

	    @Test(priority = 2)
	    public void searchAndAddToCart() {
	        // Search for a product
	        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	        searchBox.sendKeys("laptop");

	        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
	        searchButton.click();

	        // Click on a  product
	        WebElement productLink = driver.findElement(By.xpath("//span[text()='Some Product Name']"));
	        productLink.click();

	        // Add the product to the cart
	        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
	        addToCartButton.click();
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser after tests
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
