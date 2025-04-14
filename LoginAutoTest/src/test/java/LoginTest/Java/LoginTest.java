package LoginTest.Java;

import Base.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Init {

    @Test
    public void TC01_LoginSuccess() throws Exception {
        driver.get("https://hrm.anhtester.com/erp/login");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
WebElement Logo = driver.findElement(By.xpath("//a[@class='b-brand']//img[@class='logo logo-lg']"));
Assert.assertTrue(Logo.isDisplayed(),"Thất bại");

    }

    @Test
    public void TC02_LoginFailUserName() throws Exception {
        driver.get("https://hrm.anhtester.com/erp/login");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example.com");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement ErrorMessage1 = driver.findElement(By.xpath("//div[@class='toast-message']"));
        Assert.assertTrue(ErrorMessage1.isDisplayed(),"Thành Công");
    }
    @Test
    public void TC03_LoginFailPassWord() throws Exception {
        driver.get("https://hrm.anhtester.com/erp/login");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("1234567");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement ErrorMessage2 = driver.findElement(By.xpath("//div[@class='toast-message']"));
        Assert.assertTrue(ErrorMessage2.isDisplayed(),"Thành Công");
    }
    @Test
    public void TC04_LoginFailUserNull() throws Exception {
        driver.get("https://hrm.anhtester.com/erp/login");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("1234567");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement ErrorMessage3 = driver.findElement(By.xpath("//div[@class='toast-message']"));
        Assert.assertTrue(ErrorMessage3.isDisplayed(),"Thành Công");
    }
    @Test
    public void TC05_LoginFailPassNull() throws Exception {
        driver.get("https://hrm.anhtester.com/erp/login");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement ErrorMessage4 = driver.findElement(By.xpath("//div[@class='toast-message']"));
        Assert.assertTrue(ErrorMessage4.isDisplayed(),"Thành Công");
    }
    @Test
    public void TC06_LoginFailBothNull() throws Exception {
        driver.get("https://hrm.anhtester.com/erp/login");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement ErrorMessage5 = driver.findElement(By.xpath("//div[@class='toast-message']"));
        Assert.assertTrue(ErrorMessage5.isDisplayed(),"Thành Công");
    }
    @Test
    public void TC07_ForGotPass() throws Exception {
        driver.get("https://hrm.anhtester.com/erp/login");
        driver.findElement(By.xpath("//span[normalize-space()='Forgot password?']")).click();
        Thread.sleep(2000);
        WebElement ResetPass = driver.findElement(By.xpath("//h4[normalize-space()='Reset your password']"));
        Assert.assertEquals(ResetPass.getText(),"Reset your password");
    }
    @Test
    public void TC_08PassField() {
        driver.get(("https://hrm.anhtester.com/erp/login"));
       WebElement passwordField = driver.findElement(By.xpath("//input[@id='ipassword']"));
       passwordField.sendKeys("123456");
        String inputType = passwordField.getAttribute("type");
        Assert.assertEquals(inputType, "password");
    }
}
