import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {

        String folderDrivers = "drivers\\chromedriver.exe";
        int timeWait = 5;

        String testURL = "https://uxcrowd.ru/";
        String loginName = "";
        String loginPassword = "";

        System.setProperty("webdriver.chrome.driver", folderDrivers);
        WebDriver driver = new ChromeDriver();

        driver.get(testURL);

        if (driver.findElement((By.xpath("//a[@id='header-lk-button']"))).isDisplayed())
            driver.findElement((By.xpath("//a[@id='header-lk-button']"))).click();
        else
            driver.findElement((By.xpath("//img[@id='mobileAvatar']"))).click();

        new WebDriverWait(driver, timeWait).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='modal-body newprice-modal ng-scope']")));

        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(loginName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(loginPassword);
        driver.findElement((By.xpath("//form[@id='form_auth']//button[@class='lk-enter-btn']"))).click();

        new WebDriverWait(driver, timeWait).withMessage("Log in exception")
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='logout']")));

        driver.findElement((By.xpath("//a[@id='logout']"))).click();

        driver.quit();
    }
}
