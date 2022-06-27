package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaPage {
    public CarvanaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[data-cv-test = 'headerCarFinderLink']")
    public WebElement carFinder;

    @FindBy(css = ".leftSide h1")
    public WebElement whatCarHeading;

    @FindBy(css = ".leftSide h3")
    public WebElement paragraphHeading;

    @FindBy(css = ".leftSide a")
    public WebElement tryCarFinderButton;

    @FindBy(className = "jXLVsd")
    public WebElement carFinderQuestion;

    @FindBy(className = "esZOxN")
    public WebElement selectionPrompt;

    @FindBy(css = "a[data-cv-test='headerTradesLink']")
    public WebElement sellTradeButton;

    @FindBy(className = "kjhwtS")
    public WebElement offerHeading;

    @FindBy(className = "lnhlkr")
    public WebElement offerParagraph;

    @FindBy(className = "dkObNV")
    public WebElement vinButton;

    @FindBy(className = "jLejJf")
    public WebElement vinInputBox;

    @FindBy(className = "withVin")
    public WebElement getMyOffer;

    @FindBy(className = "kjoUgV")
    public WebElement errorVINMessage;

    @FindBy(css = "div[data-cv-test='headerFinanceDropdown']>a")
    public WebElement financingButton;

    @FindBy(css = "a[data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoanButton;

    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement costOfCarInputBox;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInputBox;

    @FindBy(id = "creditBlock")
    public WebElement creditScoreDropDown;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTermDropDown;

    @FindBy(className = "loan-calculator-display-value")
    public WebElement monthlyPayment;
}
