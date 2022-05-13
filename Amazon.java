package week4.day2;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		Thread.sleep(2000);
		String price=driver.findElement(By.xpath("(//div[@class='a-section'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println("The price of the first listed product is " +price);
		System.out.println("--------------------------------------");
		System.out.println(driver.findElement(By.xpath("//div//span[text()='RESULTS']//following::span [contains(text(),'stars')[1]")).getText());
		System.out.println("--------------------------------------");
		driver.findElement(By.xpath("//div//span[text()='RESULTS']//following::h2[1]//a")).click();
		List<String>windowHandleslist2 =new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandleslist2.get(1));
		File srcfile =driver.getScreenshotAs(OutputType.FILE);
		File destinationfile =new File(".snaps/sample2.png");
		FileUtils.copyFile(srcfile, destinationfile);
		if(FileUtils.getFile(destinationfile).exists()) {
			System.out.println("The Screenshot is placed in the given path");
			System.out.println("-------------------------------");

		}
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		String cartvalue=driver.findElement(By.xpath("span//b[contains(text(),'Cart subtotal')]//following::span//span")).getText();
		if(cartvalue.replaceAll("\\D","").contains(price.replaceAll("\\D","")));
		System.out.println("The cart price matches with the phone price");
		System.out.println("-----------------------");
		driver.quit();

	}
}
