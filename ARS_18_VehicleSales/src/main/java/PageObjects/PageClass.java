package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageClass extends BasePage      {
    public PageClass(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='login']")
    WebElement Email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement Login;
    @FindBy(xpath = "//span[normalize-space()='Vehicle Sales']")
    WebElement VehicleSales;
    @FindBy(xpath = "//span[normalize-space()='Operations']")
    WebElement Operations;
    @FindBy(xpath = "//a[normalize-space()='Quotation']")
    WebElement Quotation;
    @FindBy(xpath = "//button[normalize-space()='New']")
    WebElement newButton;

    @FindBy(xpath = "//a[normalize-space()='Add a product']")
    WebElement AddProduct;
    @FindBy(xpath = "//input[@placeholder='Search a product']")
    WebElement SearchProduct;
    @FindBy(xpath = "//a[@id='autocomplete_0_0']")
    WebElement Selectproduct;
    @FindBy(xpath = "//span[normalize-space()='Sky Blue']")
    WebElement SkyBlue;
    @FindBy(xpath = "//button[@name='sale_product_configurator_confirm_button']")
    WebElement ConfirmProduct;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement Confirm;
    @FindBy(xpath = "//button[@class='btn oe_stat_button btn-outline-secondary flex-grow-1 flex-lg-grow-0']")
    WebElement deliverBtn;
    @FindBy(xpath = "//button[@name='Open Move']")
    WebElement openMoveBtn;
   // @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]")
    //WebElement addLine;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//span[normalize-space()='Validate']")
    WebElement validateDelivery;
    @FindBy(xpath = "//button[@id='create_invoice']")
    WebElement createInvoice;
    @FindBy(xpath = "//span[normalize-space()='Create Draft']")
    WebElement createDraft;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement confirmDraft;

    //Credit Note and Return product
    @FindBy(xpath = "//button[@name='action_view_invoice']")
    WebElement viewInvoice;
    @FindBy(xpath = "//span[normalize-space()='Credit Note']")
    WebElement creditNote;
    @FindBy(xpath = "//input[@id='reason_0']")
    WebElement Reason;
    @FindBy(xpath = "//span[normalize-space()='Reverse']")
    WebElement Reverse;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement confirmCreditNote;
    @FindBy(xpath = "//button[@name='vehicle_sale_action_view_delivery']")
    WebElement deliveryBtn;
    @FindBy(xpath = "//span[normalize-space()='Return']")
    WebElement returnBtn;
    @FindBy(xpath = "//span[normalize-space()='Validate']")
    WebElement validateReturn;


    public void setEmail(String text) {
        sendKeys(Email,text);
        pause(1000);
    }
    public void setPassword(String text) {
        sendKeys(Password,text);
        pause(1000);

    }
    public void clickLogin() {
        click(Login);
        pause(1000);

    }
    public void clickVehicleSales() {
        click(VehicleSales);
        pause(1000);

    }
    public void clickOperations() {
        click(Operations);
        pause(1000);

    }
    public void clickQuotation() {
        click(Quotation);
        pause(1000);

    }
    public void clickNewButton() {
        click(newButton);
        pause(1000);

    }
    public void selectCustomer(String customerName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // 1️⃣ Wait for form to fully load
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div.o_form_sheet_bg")
        ));

        // 2️⃣ Locate customer input freshly
        By customerInputBy = By.xpath("//input[@id='partner_id_0']");
        WebElement customerInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(customerInputBy)
        );

        // 3️⃣ Scroll + focus using JS (important for Odoo)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});" +
                        "arguments[0].focus();" +
                        "arguments[0].value='';",
                customerInput
        );

        // 4️⃣ Type customer name
        Actions actions = new Actions(driver);
        actions.moveToElement(customerInput)
                .click()
                .pause(Duration.ofMillis(300))
                .sendKeys(customerName)
                .perform();

        // 5️⃣ Wait for autocomplete dropdown
        By suggestionBy = By.xpath("//ul[contains(@class,'ui-autocomplete')]//li[1]");
        WebElement firstSuggestion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(suggestionBy)
        );

        // 6️⃣ Click suggestion
        firstSuggestion.click();

        // 7️⃣ Ensure value is locked (field loses focus)
        customerInput.sendKeys(Keys.TAB);
    }

    public void selectPaymentTerm(String paymentTerm) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 1️⃣ Locate Payment Term input
        By paymentInputBy = By.xpath("//input[contains(@id,'payment_term_id')]");
        WebElement paymentInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(paymentInputBy)
        );

        // 2️⃣ Scroll & focus (important in Odoo)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});" +
                        "arguments[0].focus();" +
                        "arguments[0].value='';",
                paymentInput
        );

        // 3️⃣ Type payment term
        Actions actions = new Actions(driver);
        actions.moveToElement(paymentInput)
                .click()
                .pause(Duration.ofMillis(300))
                .sendKeys(paymentTerm)
                .perform();

        // 4️⃣ Wait for dropdown suggestions
        By suggestionBy = By.xpath("//ul[contains(@class,'ui-autocomplete')]//li[1]");
        WebElement firstSuggestion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(suggestionBy)
        );

        // 5️⃣ Select first matching option
        firstSuggestion.click();

        // 6️⃣ Commit selection
        paymentInput.sendKeys(Keys.TAB);
    }

    public void clickAddButton() {
        click(AddProduct);
        pause(1000);
    }
    public void setSearchProduct(){
        click(SearchProduct);
        pause(1000);
    }
    public void setSelectproduct(){
        click(Selectproduct);
        pause(1000);
    }
    public void setSkyBlue(){
        click(SkyBlue);
        pause(1000);
    }

    public void clickConfirmproduct(){
        click(ConfirmProduct);
        pause(1000);
    }
    public void cickConfirm(){
        click(Confirm);
        pause(1000);
    }
    public void clickDelivery(){
        click(deliverBtn);
        pause(100);
    }
    public void clickOpenMove(){
        click(openMoveBtn);
        pause(1000);
    }

    public void clickSave(){
        click(saveBtn);
        pause(1000);
    }
    public void clickValidateDelivery(){
        click(validateDelivery);
        pause(1000);
    }
    public void clickCreateInvoice(){
        click(createInvoice);
        pause(1000);
    }
    public void clickCreateDraft(){
        click(createDraft);
        pause(1000);
    }
    public void clickConfirmDraft(){
        click(confirmDraft);
        pause(1000);
    }
    public void clickviewInvoice(){
        click(viewInvoice);
        pause(1000);
    }
    public void clickcreditNote(){
        click(creditNote);
        pause(1000);
    }
    public void enterReason(String text){
        sendKeys(Reason, text);
        pause(1000);
    }
    public void clickReverse(){
        click(Reverse);
        pause(1000);
    }
    public void clickconfirmCreditNote(){
        click(confirmCreditNote);
        pause(1000);
    }
    public void clickDeliveryBtn(){
        click(deliveryBtn);
        pause(1000);
    }
    public void clickreturnBtn(){
        click(returnBtn);
        pause(1000);
    }


    public void enterQuantityandReturn(String qty){

        By qtyCell = By.xpath("//td[normalize-space()='0.00']");
        By qtyInput = By.xpath("//input[@class='o_input']");
        By returnBtn = By.xpath("//button[@name='action_create_returns']//span[contains(text(),'Return')]");

        // Click quantity cell
        WebElement cell = wait.until(ExpectedConditions.elementToBeClickable(qtyCell));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", cell);

        // Enter quantity
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(qtyInput));
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(qty);

        // Click Return button (forces exit of edit mode)
        WebElement ret = wait.until(ExpectedConditions.elementToBeClickable(returnBtn));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", ret);
    }
    public void clickvalidateReturn(){
        click(validateReturn);
        pause(1000);
    }

}