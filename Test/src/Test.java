import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test {
	
	public static void main(String[] args) {
		demo();
	}
	
    /** 
     * ��google�����ٶ� 
     *  
     * @param queryStr 
     */  
    public static void demo() {  
        String url = "http://www.tianyancha.com/search/%E6%B8%B8%E9%BE%99%E5%B7%A5%E4%BD%9C%E5%AE%A4/1";  
      
        WebDriver webDriver = new FirefoxDriver();  
        // ��google  
        webDriver.get(url);  
      
        // ʹ��Selenium��domģ�ͻ�ȡform  
        WebElement webElement = webDriver.findElement(By.name("q"));  
        webElement.sendKeys("baidu");  
        webElement.submit();  
      
        // ͨ���ж� title ���ݵȴ�����ҳ�������ϣ�Timeout ����10��  
      
        (new WebDriverWait(webDriver, 100)).until(new ExpectedCondition<Boolean>() {  
            public Boolean apply(WebDriver d) {  
                return d.getTitle().toLowerCase().indexOf("baidu") != -1;  
            }  
        });  
      
        String responseBody = webDriver.getPageSource();  
        System.out.println("Response : " + responseBody);  
      
        // �ر������  
        webDriver.close();  
    }  
    
    /** 
     * ��ò����� css��ͼƬ��flash������� 
     * @return 
     */  
    public WebDriver getNoResouceWebDriver(){  
        FirefoxProfile firefoxProfile = new FirefoxProfile();  
        // ȥ��css  
        firefoxProfile.setPreference("permissions.default.stylesheet", 2);  
        // ȥ��ͼƬ  
        firefoxProfile.setPreference("permissions.default.image", 2);  
        // ȥ��flash  
        firefoxProfile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", false);  
        return new FirefoxDriver(firefoxProfile);  
    }
    
    public void setCookies(WebDriver webDriver,Map<String, String> cookies) {  
        if (cookies != null && cookies.size() > 0) {  
            for (Entry<String, String> c : cookies.entrySet()) {  
                Cookie cookie = new Cookie(c.getKey(), c.getValue());  
                webDriver.manage().addCookie(cookie);  
      
                System.out.println("Set Cookies : " + c.getKey() + " | " + c.getValue());  
            }  
        }  
    } 
    
    public Map<String,String> getCookies(WebDriver webDriver){  
        Set<Cookie> cookies = webDriver.manage().getCookies();  
        Map<String, String> responseCookies = new HashMap<String,String>();  
        for (Cookie c : cookies) {  
            responseCookies.put(c.getName(), c.getValue());  
        }  
          
        return responseCookies;  
    }  
    
    /** 
     * �������cookie 
     */  
    public void clearCookies(WebDriver webDriver) {  
        webDriver.manage().deleteAllCookies();  
    }  
    
    public void doWeb(WebDriver webDriver) {  
    	
    }  

}
