package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testComponents.BaseClass;
import testComponents.RetryClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LoginTest extends BaseClass {

    @Test
    public void testCase1(){
        List<WebElement> example = driver.findElements(By.xpath("example"));
        List<String> exampleNames = example.stream().map(s -> s.getText()).collect(Collectors.toList());
        WebElement example2 =example.stream().filter(s -> s.getText().equalsIgnoreCase("example")).findFirst().orElse(null);
    }

    @Test(dataProvider = "getData")
    public void testCase2(HashMap<String, String> input){
        System.out.println(input.get("email"));
        System.out.println(input.get("password"));
    }

    @Test(retryAnalyzer = RetryClass.class)
    public void testCase3(){

    }

    @DataProvider
    public Object[][] getData() throws IOException {
//        HashMap<Object, Object> map1 = new HashMap<Object, Object>();
//        map1.put("email", "test123@mail.com");
//        map1.put("password", "Test@123");

        List<HashMap<String, String>> data = getDataToMap("src/test/resources/LoginData.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }

}
