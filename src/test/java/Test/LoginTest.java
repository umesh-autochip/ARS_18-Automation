package Test;

import Base.Browser;
import PageObjects.loginPage;
import org.testng.annotations.Test;

public class LoginTest extends Browser {

    @Test(priority = 1)
    public void verifyLogin() {
        loginPage lp = new loginPage(driver);
        lp.setEmail("ishita.verma@autochip.in");
        lp.setPassword("1234");
        lp.clickSubmit();
    }

    @Test(priority = 2)
    public void verifyPurchase() {
        loginPage lp = new loginPage(driver);
        lp.clickPurchase();
        lp.clickNewButton();
    }

    @Test(priority = 3)
    public void createPO() {
        loginPage lp = new loginPage(driver);
        lp.clickVendor();
        lp.clickSelectVendor();
        lp.setVReference("BYD-001");
        lp.clickArrival();
        lp.setSelectDate();
        lp.clickConfirmation();
        lp.clickAddProduct();
        lp.clickSearchProduct();
        lp.clickSelectProduct();
        lp.clickConfirmOrder();
    }

    @Test(priority = 4)
    public void verifyShipment() throws InterruptedException {
        loginPage lp = new loginPage(driver);
        lp.clickShipmentBtn();
        lp.clickOpenMoveBtn();
        String chsNum = "CHSN" + System.currentTimeMillis();
        lp.enterChassisNumber(chsNum);
        //lp.waitForModalToClose();
        lp.enterMotorNumber("4321");
        lp.clickSaveBtn();
        lp.clickValidateBtn();
        driver.navigate().back();
       // lp.clickBackPO();
    }
    @Test(priority = 5)
    public void verifyInvoice(){
        loginPage lp = new loginPage(driver);
        lp.clickCreateBill();
        lp.clickInvoiceDate();
        lp.clickSelectInvioceDate();
        lp.clickConfirmInvoice();
        driver.navigate().back();
    }
    @Test(priority = 6)
    public void verifyCreditnote(){
        loginPage lp = new loginPage(driver);
        lp.clickVendorbills();
        lp.clickCreditNote();
        lp.enterReason("Invalid Data");
        lp.clickReverseBtn();
        lp.clickconfirmReverse();
        driver.navigate().back();
        driver.navigate().back();
        lp.clickreceiptBtn();
        lp.clickreturnBtn();
        lp.enterQuantityandReturn("1");
        lp.clickreturValidate();
        driver.navigate().back();
        driver.navigate().back();

    }
}