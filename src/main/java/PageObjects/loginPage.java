package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage extends BasePage {
    public loginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //WebElements

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement email;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//span[normalize-space()='Vehicle Purchase']")
    WebElement vPurchase;
    @FindBy(xpath = "//button[normalize-space()='New']")
    WebElement newButton;
    @FindBy(xpath = "//input[@id='partner_id_0']")
    WebElement vendor;
    @FindBy(xpath = "//a[@id='partner_id_0_0_0']")
    WebElement selectVendor;
    @FindBy(xpath = "//input[@id='partner_ref_0']")
    WebElement vReference;

    @FindBy(xpath = "//input[@id='date_planned_0']")
    WebElement arrival;
    @FindBy(xpath = "//span[normalize-space()='22']")
    WebElement selectDate;
    @FindBy(xpath = "//div[@class='o-checkbox form-check d-inline-block']")
    WebElement confirmation;
    @FindBy(xpath = "//a[normalize-space()='Add a product']")
    WebElement addProduct;
    @FindBy(xpath = "//input[@placeholder='Search a product']")
    WebElement searchProduct;
    @FindBy(xpath = "//a[@id='autocomplete_0_1']")
    WebElement selectProduct;
    @FindBy(xpath ="//span[normalize-space()='Confirm Order']")
    WebElement confirmOrder;
    @FindBy(xpath = "//button[@invisible='incoming_picking_count == 0']")
    WebElement shipmentBtn;
    @FindBy(xpath = "//button[@name='Open Move']")
    WebElement openMoveBtn;
    @FindBy(xpath = "//td[@name='lot_name']")
    WebElement chassisCell;
    @FindBy(xpath = "//input[contains(@name,'lot_name')]")
    WebElement chassisInput;
    @FindBy(xpath = "//td[@name='motor_number']")
    WebElement motorCell;
    @FindBy(xpath = "//input[contains(@name,'motor_number')]")
    WebElement motorInput;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;
    @FindBy(xpath = "//button[@name='button_validate']")
    WebElement validateBtn;
    /*@FindBy(xpath = "//a[@class='fw-bold text-truncate'][normalize-space()='P00422']")
    WebElement backPO;*/
    @FindBy(xpath = "//span[normalize-space()='Create Bill']")
    WebElement createBill;
    @FindBy(xpath = "//input[@id='invoice_date_1']")
    WebElement invoiceDate;
    @FindBy(xpath = "//span[normalize-space()='15']")
    WebElement selectInvioceDate;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement confirmInvoice;
    @FindBy(xpath = "//span[normalize-space()='Vendor Bills']")
    WebElement vendorBills;
    @FindBy(xpath = "//button[@name='action_reverse']")
    WebElement creditNote;
    @FindBy(xpath = "//input[@id='reason_0']")
    WebElement reason;
    @FindBy(xpath = "//button[@name='refund_moves']")
    WebElement reverseBtn;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    WebElement confirmReverse;
    @FindBy(xpath = "//span[normalize-space()='Receipt']")
    WebElement receiptBtn;
    @FindBy(xpath = "//span[normalize-space()='Return']")
    WebElement returnBtn;
    @FindBy(xpath = "//td[@name='quantity']")
    WebElement quantityCell;
    @FindBy(xpath = "//button[@name='action_create_returns']")
    WebElement doneReturn;
    @FindBy(xpath = "//span[normalize-space()='Validate']")
    WebElement validateReturn;


    //Methods
    public void setEmail(String text) {
        sendKeys(email, text);
        pause(1000);
    }
    public void setPassword(String text) {
        sendKeys(password, text);
        pause(1000);
    }
    public void clickSubmit() {
        click(submit);
        pause(1000);

    }
    public void clickPurchase() {
        click(vPurchase);
        pause(1000);

    }
    public void clickNewButton() {
        click(newButton);
        pause(1000);

    }
    public void clickVendor() {
        click(vendor);
        pause(1000);

    }
    public void clickSelectVendor() {
        click(selectVendor);
        pause(1000);

    }
    public void setVReference(String text) {
        sendKeys(vReference, text);
        pause(1000);

    }
    public void clickArrival() {
        click(arrival);
        pause(1000);

    }
    public void setSelectDate() {
        click(selectDate);
        pause(1000);

    }
    public void clickConfirmation() {
        click(confirmation);
        pause(1000);

    }
    public void clickAddProduct() {
        click(addProduct);
        pause(1000);

    }
    public void clickSearchProduct() {
        click(searchProduct);
        pause(1000);

    }
    public void clickSelectProduct() {
        click(selectProduct);
        pause(1000);

    }
    public void clickConfirmOrder() {
        click(confirmOrder);
        pause(1000);

    }
    public void clickShipmentBtn() {
        click(shipmentBtn);
        pause(1000);

    }
    public void clickOpenMoveBtn() {
        click(openMoveBtn);
        pause(1000);

    }

    //Input the chassis number
    public void enterChassisNumber(String number) {
       // wait.until(ExpectedConditions.elementToBeClickable(chassisCell)).click();
        Actions act = new Actions(driver);
        act.doubleClick(chassisCell).perform();

        WebElement chassisInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//td[@name='lot_name']//input[contains(@class,'o_input')]")
                )
        );
        chassisInput.clear();
        chassisInput.sendKeys(number);
        chassisInput.sendKeys(Keys.TAB);
    }
     //Input the Motor number
    public void enterMotorNumber(String number) {
        //wait.until(ExpectedConditions.elementToBeClickable(motorCell)).click();
        Actions act = new Actions(driver);
        act.doubleClick(motorCell).perform();
        WebElement motorInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[@name='motor_number']//input[contains(@class,'o_input')]")

                )
        );
        motorInput.sendKeys(number);
        motorInput.sendKeys(Keys.TAB);
    }
    public void clickSaveBtn() {
        click(saveBtn);
        pause(1000);

    }

    public void clickValidateBtn() {
        click(validateBtn);
        pause(1000);

    }
    /*public void clickBackPO() {
        click(backPO);
    }*/
    public void clickCreateBill() {
        click(createBill);
        pause(1000);

    }
    public void clickInvoiceDate() {
        click(invoiceDate);
        pause(1000);

    }
    public void clickSelectInvioceDate() {
        click(selectInvioceDate);
        pause(1000);

    }
    public void clickConfirmInvoice() {
        click(confirmInvoice);
        pause(1000);
    }
    public void clickVendorbills(){
        click(vendorBills);
        pause(1000);
    }
    public void clickCreditNote() {
        safeClick(creditNote);
        pause(1000);
    }
    public void enterReason(String text){
        sendKeys(reason,text);
        pause(1000);
    }
    public void clickReverseBtn() {
        click(reverseBtn);
        pause(1000);
    }
    public void clickconfirmReverse(){
        click(confirmReverse);
        pause(1000);
    }
    public void clickreceiptBtn(){
        click(receiptBtn);
        pause(1000);
    }
    public void clickreturnBtn(){
        click(returnBtn);
        pause(1000);
    }
    public void closeChassisPopupIfVisible() {
        try {
            By chassisPopupCloseBtn = By.xpath("//button[normalize-space()='Close']");
            WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(chassisPopupCloseBtn));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);

            wait.until(ExpectedConditions.invisibilityOf(closeBtn));
            System.out.println("Chassis popup closed successfully");
        } catch (TimeoutException e) {
            System.out.println("No chassis popup visible. Continue...");
        }
    }

    public void enterQuantityandReturn(String qty){
        closeChassisPopupIfVisible();

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

    public void clickreturValidate(){
        click(validateReturn);
        pause(1000);
    }
}
