import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by svetlana on 14.05.16
 */
public class PlayGame {
    WebDriver driver;
    Game playGame;

    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://gabrielecirulli.github.io/2048/");
        playGame = new Game(driver);
    }

    public void startPlay() throws InterruptedException {
        playGame.startButton.click();
    }

    public void playGameWithArrows() {
        while (true) {
            playGame.gameContainer.sendKeys(Keys.ARROW_DOWN);
            printGameContainer();
            playGame.gameContainer.sendKeys(Keys.ARROW_LEFT);
            printGameContainer();
            playGame.gameContainer.sendKeys(Keys.ARROW_RIGHT);
            printGameContainer();
            playGame.gameContainer.sendKeys(Keys.ARROW_UP);
            printGameContainer();
            if (playGame.retryButton.isDisplayed()) {
                break;
            }
        }

        System.out.print(playGame.scoreContainer.getText() + " ");
        System.out.println(playGame.bestContainer.getText());
    }

    public void printGameContainer() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> list = new ArrayList<>();
        list.add(playGame.tilePosition11);
        list.add(playGame.tilePosition21);
        list.add(playGame.tilePosition31);
        list.add(playGame.tilePosition41);

        list.add(playGame.tilePosition12);
        list.add(playGame.tilePosition22);
        list.add(playGame.tilePosition32);
        list.add(playGame.tilePosition42);

        list.add(playGame.tilePosition13);
        list.add(playGame.tilePosition23);
        list.add(playGame.tilePosition33);
        list.add(playGame.tilePosition43);

        list.add(playGame.tilePosition14);
        list.add(playGame.tilePosition24);
        list.add(playGame.tilePosition34);
        list.add(playGame.tilePosition44);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {

            if (!playGame.elementExist(list.get(i))) {
                System.out.print("0" + "|");
           } else {
                System.out.print(list.get(i).getText() + "|");
           }
            count++;
            if (count % 4 == 0) {
                System.out.println();
            }
            if (i == 15) {
                System.out.println();
            }
        }
    }

    public void closeWindow() {
        driver.quit();
    }
}
