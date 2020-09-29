package pages;

import data.GistData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GistDetailPage {
    private WebDriver driver;
    private GistData gistData = new GistData();
    private By descriptionView = By.xpath("//*[@itemprop='about']");
    private By contentView = By.xpath("//*[@itemprop='text']//*[contains(@class, 'blob-code')]");
    private By editGistBtn = By.xpath("//*[@aria-label='Edit this Gist']");

    public GistDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public void assertCreatedGist() {
        Assert.assertEquals(driver.findElement(descriptionView).getText(), gistData.getGistDesc());
        Assert.assertEquals(driver.findElement(contentView).getText(), gistData.getGistContent());
    }

    public void editGistBtn() {
        driver.findElement(editGistBtn).click();
    }
}
