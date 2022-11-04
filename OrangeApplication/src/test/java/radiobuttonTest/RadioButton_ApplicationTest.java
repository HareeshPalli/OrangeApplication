package radiobuttonTest;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import radiobutton.BaseTest1;

public class RadioButton_ApplicationTest extends BaseTest1 {
	
	
	@Test
	public void RadioBtnOperation() throws InterruptedException
	{
	
		
		WebElement	RadioBtnblock=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
		List<WebElement> RadioBtnsGroup1=RadioBtnblock.findElements(By.name("group1"));
	     int	RadioBtnsSize=RadioBtnsGroup1.size();
	    System.out.println("No of Radio gr1 btns:"+RadioBtnsSize);
	    
	     logger.info("Display the RadioBtnsize");
	     
	     for(int i=0;i<RadioBtnsSize;i++)
	     {
	    	RadioBtnsGroup1.get(i).click();
	    	 Thread.sleep(3000);
	     }
	     for(int j=0;j<RadioBtnsSize; j++)
	     {
	    	System.out.println( RadioBtnsGroup1.get(j).getAttribute("value")+""+RadioBtnsGroup1.get(j).getAttribute("checked"));
	    	
	    	List<WebElement> RadioBtnsGroup2=RadioBtnblock.findElements(By.name("group2"));
	         int	RadioBtnsSize1=RadioBtnsGroup2.size();
	     	System.out.println( RadioBtnsGroup2.get(j).getAttribute("value")+""+RadioBtnsGroup2.get(j).getAttribute("checked"));

	         RadioBtnsGroup2.get(j).click();

	         Thread.sleep(3000);
	     }
	     
	     

		
	}

}
