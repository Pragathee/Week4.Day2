package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		WebElement findElement = driver.findElement(By.id("dropdown1"));
		Select Dropdown1 = new Select(findElement);
		Dropdown1.selectByIndex(1);
		WebElement findElement2 = driver.findElement(By.name("dropdown2"));
		Select dropdown2 = new Select(findElement2);
		dropdown2.selectByVisibleText("Appium");
		WebElement findElement3 = driver.findElement(By.id("dropdown3"));
		Select dropdown3 = new Select(findElement3);
		dropdown3.selectByValue("3");
		WebElement findElement4 = driver.findElement(By.id("dropdown4"));
		Select dropdown4 = new Select(findElement4);
		List<WebElement> Dropdown4options = dropdown4.getOptions();
		System.out.println("The Number of options in the dropdown are" + Dropdown4options.size());
		for (WebElement dropdownoptionval : Dropdown4options) {
			System.out.println(dropdownoptionval.getText());

		}
		System.out.println("--------------------------");
		driver.findElement(By.xpath("//select)[5]")).sendKeys("UFT/QTP");
		WebElement findElement5 = driver.findElement(By.xpath("//select)[6]"));
		Select Dropdown5 = new Select(findElement5);
		Dropdown5.selectByIndex(2);
		Dropdown5.selectByIndex(3);
		List<WebElement> allSelectedOptions = Dropdown5.getAllSelectedOptions();
		for (WebElement selectedvalues : allSelectedOptions) {
			System.out.println(selectedvalues.getText());
		}
		driver.close();
	}

}
