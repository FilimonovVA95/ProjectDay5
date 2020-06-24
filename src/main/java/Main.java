import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

        if (driver.findElement((By.id("header-lk-button"))).isDisplayed())
            driver.findElement((By.id("header-lk-button"))).click();
        else
            driver.findElement((By.id("mobileAvatar"))).click();

        new WebDriverWait(driver, timeWait).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//div[@class='modal-body newprice-modal ng-scope']")));

        driver.findElement(By.name("login")).sendKeys(loginName);
        driver.findElement(By.name("password")).sendKeys(loginPassword);
        driver.findElement((By.xpath("//form[@id='form_auth']//button[@class='lk-enter-btn']"))).click();

        new WebDriverWait(driver, timeWait).withMessage("Log in exception")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("logout")));

        driver.findElement((By.id("logout"))).click();

        driver.quit();
    }
}
