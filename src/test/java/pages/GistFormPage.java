package pages;

import data.GistData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GistFormPage {
    private WebDriver driver;
    private GistData gistData = new GistData();
    private By gistDescField = By.name("gist[description]");
    private By submitGistBtn = By.xpath("//*[@class='BtnGroup']//button[@type='submit']");
    public By gistContentField = By.className("CodeMirror-code");

    public GistFormPage(WebDriver driver){
        this.driver = driver;
    }

    public void createGist(String action) {
        String gistDesc = "Gist Description Test";
        String gistContent = "Gist Content Test";
        if (action.equals("see")) {
            Assert.assertTrue(driver.findElement(gistDescField).isDisplayed());
            Assert.assertTrue(driver.findElement(gistContentField).isDisplayed());
        } else {
            driver.findElement(gistDescField).sendKeys(gistDesc);
            driver.findElement(gistContentField).sendKeys(gistContent);
            gistData.setGistDesc(gistDesc);
            gistData.setGistContent(gistContent);
            driver.findElement(submitGistBtn).click();
        }
    }
}
