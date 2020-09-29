package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private GistFormPage objGistForm = new GistFormPage(driver);
    private By usernameField = By.id("login_field");
    private By passwordField = By.id("password");
    private By SignInBtn = By.name("commit");
    private By viewGistList = By.xpath("//a[contains(@class, 'd-md-block') and text()='View your gists']");
    public By navBarSignInBtn = By.xpath("//a[contains(@class, 'HeaderMenu-link') and @data-ga-click='Header, sign in']");
    public By createGist = By.xpath("//a[@aria-label='Create new gist']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignInNavBar() {
        driver.findElement(navBarSignInBtn).click();
    }

    public void fillCredentials(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(SignInBtn).click();
    }

    public void clickCreateGist() {
        driver.findElement(createGist).click();
    }

    public void clickViewGistLists() {
        driver.findElement(viewGistList).click();
    }
}
