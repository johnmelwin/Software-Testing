package seleniumTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

class TigerCenterClassTest {
	
	private WebDriver driver;
	private String baseUrl;

    @BeforeEach
    void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/ProgrammingFiles/chromedriver_win32/chromedriver.exe"); // can be replaced with Firefox driver
		driver = new ChromeDriver(); // can be replaced with Firefox
		baseUrl = "https://"; // TARGET URL
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterEach
    void tearDown() {
    	driver.quit();
    }
    
    @Test
    public void testClassSearchButtonSwen352() throws Exception {
        driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
        WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
        assertEquals("Class Search", classButton.getText());
        classButton.click();
        Select drpTermSelector = new Select(driver.findElement(By.xpath("//*[@id=\"hideTerm\"]/div/select")));
        drpTermSelector.selectByVisibleText("2023-24 Fall (2231)");
        
   
        WebElement searchTextField = driver.findElement(By.xpath("//*[@id=\"ng2Completer\"]/div/input"));
        searchTextField.sendKeys("SWEN-352");
        
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/form/div/button"));
        searchButton.click();
                
        driver.findElement(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/div[4]/div[5]/app-class-search-row[1]")).click();
        WebElement classDetails = driver.findElement(By.id("detailsContainer"));
        
        List<WebElement> detailElements = classDetails.findElements(By.xpath(".//*"));
        
        for (WebElement element : detailElements) {
            if (element.getTagName().equals("span")) {
                System.out.println(element.getText());
            }
        }
        Thread.sleep(3000);
        assertTrue(true);
    } 

    @Test
    public void testClassSearchSwen563() throws Exception {
    	driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
    	WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
    	classButton.click();
    	WebElement submitField = driver.findElement(By.xpath("//*[@id=\"ng2Completer\"]/div/input"));
    	submitField.clear();
    	submitField.sendKeys("SWEN-563");
    	Select drpTermSelector = new Select(driver.findElement(By.xpath("//*[@id=\"hideTerm\"]/div/select")));
        drpTermSelector.selectByVisibleText("2023-24 Fall (2231)");
    	new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/form/div/button")));
    	WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/form/div/button"));
    	submitButton.click();
    	
    	driver.findElement(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/div[4]/div[5]/app-class-search-row[1]")).click();
        WebElement classDetails = driver.findElement(By.id("detailsContainer"));
        
        List<WebElement> detailElements = classDetails.findElements(By.xpath(".//*"));
        
        for (WebElement element : detailElements) {
            if (element.getTagName().equals("span")) {
                System.out.println(element.getText());
            }
        }
        Thread.sleep(3000);
        assert(true);
    	
    } 

    @Test
    public void testClassSearchSwen340() throws Exception {
    	driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
    	WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
    	classButton.click();
    	WebElement submitField = driver.findElement(By.xpath("//*[@id=\"ng2Completer\"]/div/input"));
    	submitField.clear();
    	submitField.sendKeys("SWEN-340");
    	Select drpTermSelector = new Select(driver.findElement(By.xpath("//*[@id=\"hideTerm\"]/div/select")));
        drpTermSelector.selectByVisibleText("2023-24 Fall (2231)");
    	new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/form/div/button")));
    	WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/form/div/button"));
    	submitButton.click();
    	
    	driver.findElement(By.xpath("//*[@id=\"classSearchContainer\"]/div[2]/div[4]/div[5]/app-class-search-row[1]")).click();
        WebElement classDetails = driver.findElement(By.id("detailsContainer"));
        
        List<WebElement> detailElements = classDetails.findElements(By.xpath(".//*"));
        
        for (WebElement element : detailElements) {
            if (element.getTagName().equals("span")) {
                System.out.println(element.getText());
            }
        }
        Thread.sleep(3000);
        assert(true);
    	
    } 

}
