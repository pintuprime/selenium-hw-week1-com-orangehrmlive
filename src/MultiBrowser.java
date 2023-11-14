import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*
Project-2 - ProjectName : com-orangehrmlive
BaseUrl = https://opensource-demo.orangehrmlive.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Forgot your password?’ link.
7. Print the current url.
8. Navigate back to the login page.
9. Refresh the page.
10. Enter the email to email field.
11. Enter the password to password field.
12. Click on Login Button.
13. Close the browser.
 */
public class MultiBrowser {
    //base Url
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {
        //1.set up multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //2.open url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        //3.print title of page
        String title = driver.getTitle();
        System.out.println("Title of page:" + title);

        //4.print current url
        System.out.println("Current Yrl: " + driver.getCurrentUrl());

        //5print source page
        System.out.println(driver.getPageSource());
        Thread.sleep(4000);

        //6.click forgot your password
        WebElement clickLink = driver.findElement(By.className("orangehrm-login-forgot"));
        clickLink.click();
        Thread.sleep(3000);

        //7.print current url
        System.out.println("Current Url :" + driver.getCurrentUrl());

        //8.navigate back to loginpage
        driver.navigate().back();
        Thread.sleep(3000);

        //9.Refresh the page
        driver.navigate().refresh();

        //10.enter email to email field
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        //11.enter password to password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(3000);

        //12.click on login button
        WebElement loginClick = driver.findElement(By.xpath("(//button[@type='submit'])"));
        loginClick.click();
        Thread.sleep(4000);

        //13.close browser
        driver.quit();

//        System.out.println("The current Url" + driver.getCurrentUrl());
//
//        System.out.println(driver.getPageSource());
//
//        WebElement forgotPassword = driver.findElement(By.className("oxd-text oxd-text--p orangehrm-login-forgot-header"));
//        forgotPassword.click();
//
//        System.out.println("Current Url " + driver.getCurrentUrl());
//
//        driver.navigate(


    }
}
