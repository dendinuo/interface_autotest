package com.demo.Utils;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.demo.operation.logintest;

/**
 * 本类主要的是实现可以加载 Jquery库,便于前端对JS进行操作
 * @author Mr.luo
 * 
 */
/**
 * ((JavascriptExecutor)driver) 
 * .executeScript( "arguments[0].scrollIntoView(true);" ,driver.findElement( By.id("saveNewInfoBtn")) );
 * 
 * String s = LoadJQueryLib.getInstance().getJs_str(driver, "return $('#userDuty').attr('disabled')");
 * **/
public class LoadJQueryLib {
	
private static LoadJQueryLib jquery = null;
//private String strJqueryMin = "";

public LoadJQueryLib(){

}

public static LoadJQueryLib getInstance() throws IOException {
if (jquery == null) {
jquery = new LoadJQueryLib();
}
return jquery;
}

private String read4jQueryFile() {
String strJqueryMin = "";
File file = null;
InputStream inStream = null;
ByteArrayOutputStream swapStream = null;
try {
file = new File("https://code.jquery.com/jquery-3.1.1.min.js");//jqurey路径
inStream = new FileInputStream(file);
swapStream = new ByteArrayOutputStream();
byte[] buff = new byte[1024];
int rc = 0;
while ((rc = inStream.read(buff, 0, 10)) > 0) {
	swapStream.write(buff, 0, rc);
}
swapStream.flush();
strJqueryMin = new String(swapStream.toByteArray(), "UTF-8");
inStream.close();
swapStream.close();
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
return strJqueryMin;
}


private void initJQuery(JavascriptExecutor driver) {
if (!jQueryLoaded(driver)) {
System.out.println("jQuery类库没有加载过,loading...");
String strJqueryMin = this.read4jQueryFile();

driver.executeScript(strJqueryMin);
//driver.executeScript("window.jQuery=jQuery.noConflict();");
	System.out.println("jQuery类库success!...");
}else{
	System.out.println("jQuery类库loaded!...");
}
}


/**
* 判断当前页面是否加载了JQuery
* 
* @param driver
* @return
*/
public Boolean jQueryLoaded(JavascriptExecutor driver) {
	Boolean loaded=false;
try {
	loaded = (Boolean) driver.executeScript("if(typeof jQuery==\"undefined\"){return false;}else{return true;}");
} catch (WebDriverException e) {
	loaded = false;
}
	return loaded;
}


/**
* 执行JS脚本
* 
* @param driver
* @param script
* @param args
* @return
*/
public Object runJs(WebDriver driver, String jquery_script, Object... args) {
	JavascriptExecutor js = (JavascriptExecutor) driver; //创建webdriver执行js脚本的对象
	initJQuery(js);
	return js.executeScript(jquery_script, args); //执行JS脚本，默认返回值为null
}


/***执行JS脚本，返回值为String型，
 * ，用于获取属性
 * @param driver
 * @param jquery_script
 * @return
 */
public  String getJs_str(WebDriver driver, String jquery_script) {
	JavascriptExecutor js = (JavascriptExecutor) driver; //创建webdriver执行js脚本的对象
	initJQuery(js);
	String str = (String)js.executeScript(jquery_script);
	
	return str ;//执行JS脚本，返回值为String型
}

public String get_return(String jquery_script) {
	String str2 = getJs_str(logintest.driver,jquery_script);
	return str2 ;//返回值为String型，，用于获取属性
}

public static void main(String[] args) {
try {
/***	System.setProperty("webdriver.chrome.driver","D:\\webDriver\\chromedriver.exe");	//webdriver驱动路径
WebDriver driver = new ChromeDriver();
***/

//Main.driver.get("C:\\Users\\admin\\Desktop\\js\\index.html");
//LoadJQueryLib.getInstance().runJs(Main.driver, "jQuery('#username').val('测试');");

//String current = LoadJQueryLib.getInstance().getJs_str(Main.driver,"return $('#username').attr('data')");
//执行JS后获取返回值
//System.out.println(current);


//driver.quit();
} catch (Exception e) {
e.printStackTrace();
}
}


}


