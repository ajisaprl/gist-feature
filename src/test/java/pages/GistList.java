package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GistList {
    private WebDriver driver;
    private By firstListGist = By.xpath("//*[contains(@class, 'file-box')]");

    public GistList(WebDriver driver){
        this.driver = driver;
    }

    public void clickFirstGist() {
        driver.findElement(firstListGist).click();
    }
}
