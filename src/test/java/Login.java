import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void scenarioOne() {
        login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        menuButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test
    public void scenarioTwo() {
        login("locked_out_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
        Assert.assertEquals(errorMessageContainer.getText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    private void login(String usernameStr, String passwordStr) {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
    }
}
