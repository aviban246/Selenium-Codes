import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Tables_Exercise 
{
 public static void main(String[] args) throws Exception 
 {
  try
  {
   // TODO Auto-generated method stub
   DesiredCapabilities ch = DesiredCapabilities.chrome();
   ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
   ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
   ChromeOptions options = new ChromeOptions();
   options.merge(ch);
   options.addArguments("disable-infobars");
   options.addArguments("--disable-popup-blocking");
   System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
   WebDriver driver = new ChromeDriver(options);
   driver.manage().window().maximize();
   driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");
   WebElement table;
   List<WebElement> rows=null;
   List<WebElement> columns= null;
   int count = driver.findElements(By.xpath("//*[@id=\"example_paginate\"]/span/a[@aria-controls='example']")).size();
   Tables_Exercise tb = new Tables_Exercise();
   System.out.println("Number of buttons are: "+count);
   for(int x=1;x<=count;x++)
   {
    table = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody"));
    tb.table_data_Extract(rows, columns, driver, table);
    Thread.sleep(2000);
    if(x!=count)
    {	   
     driver.findElements(By.xpath("//*[@id=\"example_paginate\"]/span/a")).get(x).click();
    }
   }
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
 } 
 public void table_data_Extract(List<WebElement> rows, List<WebElement> columns, WebDriver driver, WebElement table)
 {
  List<WebElement> rows1 = table.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr"));
  List<WebElement> columns1= null;
  for(int j=0;j<rows1.size();j++)
  {
   columns1 = rows1.get(j).findElements(By.tagName("td"));
   for(int i=0;i<columns1.size();i++)
   {
	System.out.print(columns1.get(i).getText());
	System.out.println();
   }
  }
 }
}
