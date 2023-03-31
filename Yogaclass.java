import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateYogaClass {
	public static void main(String[] args) throws InterruptedException {

	       // Set the system property for ChromeDriver
	       System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

	       // Create a new instance of ChromeDriver
	       WebDriver driver = new ChromeDriver();

	       // Navigate to the website
	       driver.get("your_URL");

	       // Login as admin user
	       driver.findElement(By.id("username")).sendKeys("admin");
	       driver.findElement(By.id("password")).sendKeys("password");
	       driver.findElement(By.id("login")).click();

	       // Create a new Yoga class
	       driver.findElement(By.id("createYogaClass")).click();

	       // Enter Yoga class details
	       driver.findElement(By.id("title")).sendKeys("Yoga class with Omnify");
	       driver.findElement(By.id("description")).sendKeys("A relaxing Yoga class with certified instructors.");
	       WebElement classColor = driver.findElement(By.id("classColor"));
	       Select selectClassColor = new Select(classColor);
	       selectClassColor.selectByVisibleText("Blue");
	       driver.findElement(By.id("image")).sendKeys("C:/yoga.jpg");
	       driver.findElement(By.id("classDetails")).sendKeys("This class is suitable for beginners and intermediate practitioners.");
	       driver.findElement(By.id("location")).sendKeys("Bangalore");
	       WebElement online = driver.findElement(By.id("online"));
	       online.click();
	       WebElement offline = driver.findElement(By.id("offline"));
	       offline.click();
	       WebElement trainer = driver.findElement(By.id("trainer"));
	       Select selectTrainer = new Select(trainer);
	       selectTrainer.selectByVisibleText("John Doe");
	       WebElement serviceType = driver.findElement(By.id("serviceType"));
	       Select selectServiceType = new Select(serviceType);
	       selectServiceType.selectByVisibleText("Paid");
	       WebElement free = driver.findElement(By.id("free"));
	       free.click();
	       WebElement paid = driver.findElement(By.id("paid"));
	       paid.click();

	       // Add Class Schedule
	       driver.findElement(By.id("addClassSchedule")).click();
	       WebElement dayOfWeek = driver.findElement(By.id("dayOfWeek"));
	       Select selectDayOfWeek = new Select(dayOfWeek);
	       selectDayOfWeek.selectByVisibleText("Monday");
	       driver.findElement(By.id("startDate")).sendKeys("2023-04-03");
	       driver.findElement(By.id("endDate")).sendKeys("2023-05-01");
	       driver.findElement(By.id("startTime")).sendKeys("10:00 AM");
	       driver.findElement(By.id("endTime")).sendKeys("11:00 AM");
	       
	       // Add booking window restrictions
	        WebElement booking_window_open = driver.findElement(By.id("booking_window_open"));
	        booking_window_open.sendKeys("2");
	        WebElement booking_window_closed = driver.findElement(By.id("booking_window_open"));
	        booking_window_closed.sendKeys("1");
	        
	        // Submit the form
	         WebElement submit_button = driver.findElement(By.xpath("//button[@type='submit']"));
	         submit_button.click();
	        
	        // Verify that the class has been created
	        WebElement class_title = driver.findElement(By.xpath("//h2[contains(text(),'Yoga class with Omnify')]"));
	        String title=class_title.getText();
	        
	        String realTitle="Yoga class with Omnify";
	        
	        if (title.equalsIgnoreCase(realTitle)) {
				System.out.println("The class is created successfully");
			}else{
				System.out.println("The class not created successfully");
			}
	}
}
