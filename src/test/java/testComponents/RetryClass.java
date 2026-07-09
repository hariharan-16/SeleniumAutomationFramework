package testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {

    int count = 0, maxTry = 1;

    // This one will be directly connected to the @Test annotation testcase file with @Test(retryAnalyzer = ClassName.class)

    @Override
    public boolean retry(ITestResult result) {
        if(count < maxTry){
            count++;
            return true;
        }else{
            return false;
        }
    }

}
