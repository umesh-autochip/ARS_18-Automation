package Test;

import Base.BrowserSetup;
import PageObjects.PageClass;
import org.testng.annotations.Test;

public class TestClass extends BrowserSetup {

    @Test(priority = 1)
    public void verifyLogin(){
        PageClass pc = new PageClass(driver);
        pc.setEmail("ishita.verma@autochip.in");
        pc.setPassword("1234");
        pc.clickLogin();
    }
    @Test(priority = 2)
    public void verifySales(){
        PageClass pc = new PageClass(driver);
        pc.clickVehicleSales();
        pc.clickOperations();
        pc.clickQuotation();
        pc.clickNewButton();
    }
    @Test(priority = 3)
    public void creatSO(){
        PageClass pc = new PageClass(driver);
       pc.selectCustomer("Autochip");
       pc.selectPaymentTerm("15 Days");
       pc.clickAddButton();
       pc.setSearchProduct();
       pc.setSelectproduct();
       pc.setSkyBlue();
       pc.clickConfirmproduct();
       pc.cickConfirm();
    }
    @Test(priority = 4)
    public void verifyShipment(){
        PageClass pc = new PageClass(driver);
        pc.clickDelivery();
        pc.clickOpenMove();
        pc.clickSave();
        driver.navigate().refresh();
        pc.clickValidateDelivery();
        driver.navigate().back();
        pc.clickCreateInvoice();
        pc.clickCreateDraft();
        pc.clickConfirmDraft();
        driver.navigate().back();
    }
    @Test(priority = 5)
    public void verifyCreditNoteandReturn(){
        PageClass pc = new PageClass(driver);
        pc.clickviewInvoice();
        pc.clickcreditNote();
        pc.enterReason("Invalid data");
        pc.clickReverse();
        pc.clickconfirmCreditNote();
        driver.navigate().back();
        driver.navigate().back();
        pc.clickDeliveryBtn();
        pc.clickreturnBtn();
        pc.enterQuantityandReturn("1");
        //driver.navigate().refresh();
        //driver.navigate().refresh();
        pc.clickvalidateReturn();
        driver.navigate().back();
        driver.navigate().back();
    }
}
