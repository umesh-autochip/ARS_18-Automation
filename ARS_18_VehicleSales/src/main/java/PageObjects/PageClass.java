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
    @FindBy(xpath = "//a[@id='autocomplete_0_3']")
    WebElement Selectproduct;
    //@FindBy(xpath = "//span[normalize-space()='Sky Blue']")
    @FindBy(xpath = "//span[normalize-space()='Sky Blue']")
    WebElement CosmosBlack;
    @FindBy(xpath = "//button[@name='sale_product_configurator_confirm_button']")
    WebElement ConfirmProduct;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement Confirm;

   // @FindBy(xpath = "//button[@class='btn oe_stat_button btn-outline-secondary flex-grow-1 flex-lg-grow-0']")
    @FindBy(xpath = "//span[@class='o_stat_text']")
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

    //New Requirements
    @FindBy(xpath = "//label[normalize-space()='Without Down Payment']")
    WebElement downPayment;

    @FindBy(xpath = "//label[normalize-space()='Showroom Delivery']")
    WebElement homeDelivery;

    @FindBy(xpath = "//input[@id='expected_delivery_date_0']")
    WebElement expectedDeliveryDate;

    @FindBy(xpath = "//span[normalize-space()='27']")
    WebElement deliveryDate;

    @FindBy(xpath = "//button[@name='action_confirm_create_invoice']//span[contains(text(),'Confirm')]")
    WebElement deliverConfirm;

    //@FindBy(xpath = "//td[@name='product_id']")
    @FindBy(xpath = "//button[@name='Open Move']")
    WebElement lineProduct;

    @FindBy(xpath = "//div[@name='quant_id']")
    WebElement quant;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]")
    WebElement AddLine;

    @FindBy(xpath = "//td[normalize-space()='CHSN1773809194076']")
    WebElement Chassis;

    @FindBy(xpath = "//td[contains(text(),'0.00')]")
    WebElement DoneQuantity;

    //@FindBy(xpath = "//span[contains(text(),'WH/Stock - CH4K7M2P9R5T8X3L6')]")
    @FindBy(xpath = "(//span[contains(text(),'WH/Stock')])[last()]")
     WebElement ChassisFeild;

    //@FindBy(xpath = "//input[@id='warehouse_id_0']")
    @FindBy(xpath = "//label[normalize-space()='Warehouse']")
    WebElement Warehouse;

    @FindBy(xpath = "//a[@id='warehouse_id_0_0_4']")
    WebElement KIAWH;


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
        By suggestionBy = By.xpath("//ul[contains(@class,'ui-autocomplete')]//li[4]");
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
        click(CosmosBlack);
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
    public void clickDownPayment(){
        click(downPayment);
        pause(1000);
    }
    public void clickHomeDelivery(){
        click(homeDelivery);
        pause(1000);
    }
    public void clickExpectedDelivery(){
        click(expectedDeliveryDate);
        pause(1000);
    }
    public void clickDeliveryDate(){
        click(deliveryDate);
        pause(1000);
    }
    public void clickDeliveryConfirm(){
        click(deliverConfirm);
        pause(1000);
    }
    public void clickDelivery(){
        click(deliverBtn);
        pause(1000);
    }

    public void clickLineProduct(){
        click(lineProduct);
        pause(1000);
    }
    public void clickQuant(){

        Actions action = new Actions(driver);
        action.click(quant);
        pause(1000);
        action.sendKeys(Keys.DELETE);
        action.sendKeys("CHSN1770179095511");
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }
  /*  public void clickOpenMove(){
        click(openMoveBtn);
        pause(1000);
    }*/

    public void clickSave(){
        click(saveBtn);
        pause(1000);
    }
    public void clickValidateDelivery(){
        //click(validateDelivery);
        //pause(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Click Validate button
        WebElement validateBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Validate']"))
        );
        validateBtn.click();

        try {
            // Wait for validation error popup
            WebElement errorMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-prewrap']"))
            );

            // If found → stop execution
            if (errorMessage.isDisplayed()) {
                String message = errorMessage.getText();
                System.out.println("Validation Error Found: " + message);

                throw new RuntimeException("Stopping execution due to validation error.");
            }

        } catch (TimeoutException e) {
            // No validation error popup → Continue execution
            System.out.println("No validation error popup. Continuing...");
        }

        // Other methods will execute only if no validation error
       // performNextSteps(driver);



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
    public void clickValidateReturn(){
        click(validateReturn);
        pause(1000);
    }

    public void clickAddLine(){
        click(AddLine);
        pause(1000);
    }
    public void selectChassis(){
        /*click(Chassis);
        pause(1000);*/

        Actions action = new Actions(driver);
        action.click(Chassis);
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }
    public void EnterDoneQuantity() {

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement doneCell = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//td[@name='quantity']")
                )
        );
        doneCell.click();

        WebElement inputField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//td[@name='quantity']//input")
                )
        );

        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);
        inputField.sendKeys("1");
        inputField.sendKeys(Keys.ENTER);

    }*/
        ChassisFeild.sendKeys(Keys.TAB);
        pause(500);
        ChassisFeild.sendKeys(Keys.TAB);

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.CONTROL + "a")
                .sendKeys(Keys.DELETE)
                .sendKeys("1")
                .sendKeys(Keys.ENTER)   // commit value
                .perform();

    }

    public void clickWareHouse(){
        Warehouse.click();
        pause(1000);
    }
    public void selectWarehouse(){
        KIAWH.click();
        pause(1000);
    }


}