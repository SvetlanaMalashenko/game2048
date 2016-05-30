import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by svetlana on 14.05.16
 */
public class Game {

    WebDriver driver;

    public Game(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "restart-button")
    WebElement startButton;

    @FindBy(className = "game-container")
    WebElement gameContainer;

    @FindBy(className = "retry-button")
    WebElement retryButton;

    @FindBy(className = "score-container")
    WebElement scoreContainer;

    @FindBy(className = "best-container")
    WebElement bestContainer;

    @FindBy(className = "tile-position-1-1")
    WebElement tilePosition11;

    @FindBy(className = "tile-position-1-2")
    WebElement tilePosition12;

    @FindBy(className = "tile-position-1-3")
    WebElement tilePosition13;

    @FindBy(className = "tile-position-1-4")
    WebElement tilePosition14;

    @FindBy(className = "tile-position-2-1")
    WebElement tilePosition21;

    @FindBy(className = "tile-position-2-2")
    WebElement tilePosition22;

    @FindBy(className = "tile-position-2-3")
    WebElement tilePosition23;

    @FindBy(className = "tile-position-2-4")
    WebElement tilePosition24;

    @FindBy(className = "tile-position-3-1")
    WebElement tilePosition31;

    @FindBy(className = "tile-position-3-2")
    WebElement tilePosition32;

    @FindBy(className = "tile-position-3-3")
    WebElement tilePosition33;

    @FindBy(className = "tile-position-3-4")
    WebElement tilePosition34;

    @FindBy(className = "tile-position-4-1")
    WebElement tilePosition41;

    @FindBy(className = "tile-position-4-2")
    WebElement tilePosition42;

    @FindBy(className = "tile-position-4-3")
    WebElement tilePosition43;

    @FindBy(className = "tile-position-4-4")
    WebElement tilePosition44;

    public Boolean elementExist(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            element.isDisplayed();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException e ) {
            return false;
        } catch (StaleElementReferenceException elementReferenceException) {
            return false;
        }
    }

    public void refreshGameContainer() {
        gameContainer = driver.findElement(By.className("game-container"));
    }

    public void closeAppNotice() {
        driver.findElement(By.className("notice-close-button")).click();
    }
}
