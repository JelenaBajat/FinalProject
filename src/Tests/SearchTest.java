package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.SearchResultPage;

public class SearchTest extends BasicTest {

	private SoftAssert sa = new SoftAssert();

	@Test
	public void searchResultsTest() throws IOException, InterruptedException {

		this.driver.navigate().to(this.baseUrl + "/meals");
		locationPopupPage.setLocation("City Center - Albany");

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");

		for (int i = 1; i < 7; i++) {
			XSSFRow row = sheet.getRow(i);
			String location = row.getCell(0).getStringCellValue();
			String url = row.getCell(1).getStringCellValue();
			double numberOfResults = row.getCell(2).getNumericCellValue();

			Thread.sleep(2000);	
			
			this.driver.navigate().to(url);
			locationPopupPage.PopUpSelectLocation();
			locationPopupPage.setLocation(location);

			Thread.sleep(2000);
			
			sa.assertEquals(searchResultPage.getNumberOfResults(), numberOfResults,
					"[ERROR] The number of product does not match");

			for (int a = 3; a < numberOfResults + 3; a++) {
				String meal = row.getCell(a).getStringCellValue();
				sa.assertTrue(searchResultPage.getListOfProductsText().get(a - 3).contains(meal),
						"[ERROR] The order of the results does not match.");
			}
		}
		
		sa.assertAll();
		fis.close();
		wb.close();
	}
}
