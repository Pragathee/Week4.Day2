package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String windowHandle = driver.getWindowHandle();
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//div[@id='label']//a")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif'][1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windowHandleslist = new ArrayList<String>(windowHandles);
		String secondwindow =  windowHandleslist.get(1);
		driver.switchTo().window(secondwindow);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='x grid3-row-table'])[2]//tr[1]//td[1]//a")).click();
		driver.switchTo().window(windowHandle);
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("View Contact")) {
			System.out.println("Two Contacts merged successfully");
		}
		driver.quit();

	}

}
