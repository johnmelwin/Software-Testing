package seleniumTest;

// Import necessary libraries
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SoftwareEngineeringContactTest {

    private WebDriver driver;
    private String baseUrl;

    // Setup method to initialize the WebDriver and set the base URL
    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/ProgrammingFiles/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.rit.edu/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Clean up method to close the WebDriver
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    // Test method to find contact information for various departments
    @Test
    public void testSoftwareEngineeringContactInfo() throws InterruptedException {
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Click the search icon
        WebElement searchIcon = driver.findElement(By.xpath("/html/body/div[3]/header[2]/section[4]/div/div/div/a"));
        searchIcon.click();

        // Wait for search modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ritSearch")));

        // Type "Computing and Information Sciences" into the search bar and submit
        WebElement searchField = driver.findElement(By.id("ritSearch"));
        searchField.sendKeys("Golisano College of Computing and Information Sciences");
        searchField.submit();
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"site-search\"]/div/div[1]/div[2]/button"));
        submitButton.click();
        Thread.sleep(1000);
        WebElement computingResult = driver.findElement(By.xpath(
                "/html/body/div[3]/div/div/div/div[2]/div[3]/div[1]/div[1]/div/div/div[3]/div/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a"));
        computingResult.click();

        // Switch to the new tab that opens
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Wait for the "Support" tab to become visible and click it
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("/html/body/div[3]/header[2]/section[3]/nav/div/ul/li[7]/a")));
        WebElement supportTab = driver.findElement(By.xpath("/html/body/div[3]/header[2]/section[3]/nav/div/ul/li[7]"));
        supportTab.click();

        // Find the address of the college
        WebElement address = driver.findElement(
                By.xpath("//*[@id=\"progress-navigation--sidebar--sidebar\"]/div/div/div/div/div/div/p[1]"));
        String deptAddress = address.getText();
        Thread.sleep(1000);

        // Click the Software Engineering tab
        WebElement softwareEngineeringTab = driver.findElement(By.xpath(
                "//*[@id=\"card-header-4291\"]/p/a"));
        softwareEngineeringTab.click();
        Thread.sleep(1000);

        // Find the Software Engineering contact information
        WebElement softwareEngineeringContact = driver.findElement(By.xpath(
                "/html/body/div[3]/main/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div[1]/div/div[7]/div[2]/div"));

        // Print Software Engineering contact information
        printContactInformation(softwareEngineeringContact, deptAddress);

        // Click the Information Sciences and Technologies tab
        WebElement InformationTab = driver.findElement(By.xpath(
                "//*[@id=\"card-header-4315\"]"));
        Thread.sleep(1000);
        InformationTab.click();
        Thread.sleep(1000);

        // Find the Information Sciences and Technologies contact information
        WebElement InformationContact = driver.findElement(By.xpath(
                "//*[@id=\"card-collapse-4315\"]/div/div[1]/article/div"));
        
        // Print Information Sciences and Technologies contact information
        printContactInformation(InformationContact, deptAddress);
        
        Thread.sleep(1000);

        // Click the Computer Science tab
        WebElement computerScienceTab = driver.findElement(By.xpath(
                "//*[@id=\"card-header-4303\"]/p/a"));
        computerScienceTab.click();
        Thread.sleep(1000);
        
        // Find the Computer Science contact information
        WebElement computerScienceContact = driver.findElement(By.xpath(
                "//*[@id=\"card-collapse-4303\"]/div/div[1]/article/div"));

        // Print Computer Science contact information
        printContactInformation(computerScienceContact, deptAddress);
        Thread.sleep(3000);
    }

    // Method to print contact information for a specific department
    private void printContactInformation(WebElement deptChair, String address) {
        WebElement name = deptChair.findElement(By.xpath(".//div[contains(@class, 'person--info')]//a"));
        WebElement email = deptChair.findElement(By.xpath(".//div[contains(@class, 'person--extra-text')]//a"));
        WebElement title = deptChair.findElement(By.xpath(".//div[contains(@class, 'person--info')]//div[2]"));
        WebElement department = deptChair.findElement(By.xpath(".//div[contains(@class, 'person--info')]//div[3]"));
        WebElement college = deptChair.findElement(By.xpath(".//div[contains(@class, 'person--info')]//div[4]"));

        // Assert that all contact information elements are not null
        assertNotNull(name, "Contact information not found");
        assertNotNull(email, "Contact information not found");
        assertNotNull(title, "Contact information not found");
        assertNotNull(department, "Contact information not found");
        assertNotNull(college, "Contact information not found");
        assertNotNull(address, "Contact information not found");

        // Print the contact information
        System.out.println("Name: " + name.getText());
        System.out.println("Email: " + email.getText());
        System.out.println("Title: " + title.getText());
        System.out.println("Department: " + department.getText());
        System.out.println("College: " + college.getText());
        System.out.println("Address: " + address);
        System.out.println();
    }
}