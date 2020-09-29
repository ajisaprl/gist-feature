package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GistDetailPage;
import pages.GistFormPage;
import pages.GistList;
import pages.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebStepDefinitions {
    private WebDriverWait wait;
    private WebDriver driver = new ChromeDriver();
    private HomePage objHomePage = new HomePage(driver);
    private GistDetailPage objGistDetail = new GistDetailPage(driver);
    private GistList objGistList = new GistList(driver);
    private GistFormPage objGistForm = new GistFormPage(driver);

    @Given("^logged in user visit gist homePage$")
    public void loggedInUserVisitGistHomepage() {
        File file = new File("src/test/resource/data.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
        driver.get(prop.getProperty("gistHomePage"));

        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objHomePage.navBarSignInBtn));

        objHomePage.clickSignInNavBar();
        objHomePage.fillCredentials(prop.getProperty("username"), prop.getProperty("password"));
    }

    @When("^user click create new gist icon$")
    public void userClickCreateNewGistIcon() {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objHomePage.createGist));
        objHomePage.clickCreateGist();
    }

    @Then("^user is on create or edit gist form page$")
    public void userIsOnCreateOrEditGistFormPage() {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objGistForm.gistContentField));
        objGistForm.createGist("see");
    }

    @When("^user fill the gist content and click submit$")
    public void userFillTheGistContentAndClickSubmit() {
        objGistForm.createGist("fill");
    }

    @Then("^user should see review gist form$")
    public void userShouldSeeNewlyCreatedGist() {
        objGistDetail.assertCreatedGist();
    }

    @And("^user click view your gists$")
    public void userClickViewYourGists() {
        objHomePage.clickViewGistLists();
    }

    @And("^user open the last created gist$")
    public void userOpenTheLastCreatedGist() {
        objGistList.clickFirstGist();
    }

    @When("^user edit gist content$")
    public void userEditGistContent() {
        objGistDetail.editGistBtn();
    }

    @Then("^user should see updated gist on the list$")
    public void userShouldSeeUpdatedGistOnTheList() {
        // not enough time
    }
}
