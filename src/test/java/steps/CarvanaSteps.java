package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.CarvanaPage;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaPage carvanaPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaPage = new CarvanaPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String buttonText) {
        switch (buttonText){
            case "CAR FINDER": carvanaPage.carFinder.click();
                break;
            case "SELL/TRADE":
                Waiter.pause(5);
                carvanaPage.sellTradeButton.click();
                break;
            case "AUTO LOAN CALCULATOR":
                carvanaPage.autoLoanButton.click();
                break;
            default:
                throw new NotFoundException("The menu item text is not defined properly in the feature file!!!");
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertEquals(text, carvanaPage.whatCarHeading.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertEquals(text, carvanaPage.paragraphHeading.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertEquals(text, carvanaPage.carFinderQuestion.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertEquals(text, carvanaPage.selectionPrompt.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertEquals(text, carvanaPage.offerHeading.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertEquals(text, carvanaPage.offerParagraph.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.waitUntilTextToBePresentInElement(driver, 30, carvanaPage.errorVINMessage, text);
                Assert.assertEquals(text, carvanaPage.errorVINMessage.getText());
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String links) {
         Assert.assertTrue(carvanaPage.tryCarFinderButton.isDisplayed());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        carvanaPage.tryCarFinderButton.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button){
            case "VIN": carvanaPage.vinButton.click();
                break;
            case "GET MY OFFER": carvanaPage.getMyOffer.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String number) {
        carvanaPage.vinInputBox.sendKeys(number);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String buttonText) {
        Waiter.pause(5);
        ActionsUtil.moveToElement(carvanaPage.financingButton);
        Waiter.pause(5);
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String promptQuestion, String text) {
        switch (promptQuestion){
            case "What’s Your credit Score?":
                DropdownHandler.selectOptionByValue(carvanaPage.creditScoreDropDown, "3");
                break;
            case "Choose Your Loan Terms":
                DropdownHandler.selectOptionByValue(carvanaPage.loanTermDropDown, "60");
                break;
            default:
                throw new NotFoundException("The prompt text is not defined properly in the feature file!!!");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String text) {
        Assert.assertEquals(text, carvanaPage.monthlyPayment.getText());
    }

    @And("user clicks on AUTO LOAN CALCULATOR menu item")
    public void userClicksOnAUTOLOANCALCULATORMenuItem() {
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String promptQuestion, String text) {
        switch (promptQuestion){
            case "Cost of Car I want": carvanaPage.costOfCarInputBox.sendKeys(text);
                break;
            case "What is Your Down Payment?": carvanaPage.downPaymentInputBox.sendKeys(text);
                break;
            default:
                throw new NotFoundException("The prompt text is not defined properly in the feature file!!!");
        }
    }
}
