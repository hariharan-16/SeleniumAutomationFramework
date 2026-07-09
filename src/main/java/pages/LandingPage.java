package pages;

import utilities.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "submitButton")
    private WebElement submitButton;

    public void goTo(String url){
        driver.get(url);
    }

    public HomePage login(){
        HomePage hp = new HomePage(driver);
        submitButton.click();
        return hp;
    }

}
