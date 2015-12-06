package classdemo.betech.nyc;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Betech
 *
 */
public class KW2 {

	public static int getRowNumTC, getColNum, getRowNumTS;
	public static String[][] getDataTC, getDataTS;
//	public static WebDriver driver;
	/**
	 * @param argsc
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String... args) throws IOException, InterruptedException {
		// Get File

		ProjectUtils.readExcelTestCase("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestCaseSheet");
		getRowNumTC = ProjectUtils.getRowNumTestCase;
        getDataTC = ProjectUtils.xlData;
        
		ProjectUtils.readExcelTestStep("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestStepSheet");
		getRowNumTS = ProjectUtils.getRowNumTestStep;
        getDataTS = ProjectUtils.xlData;
    
    ///      Loop TC Sheet How many rows in the sheet
    for (int i = 0; i < getRowNumTC; i++) {
    	
    	// If Execution write = Run
    	
    	if (getDataTC[i][1].equalsIgnoreCase("Run")) {
    		
    		
    		for (int j = 0; j < getRowNumTS; j++) {
    			
    			if (getDataTC[i][0].equalsIgnoreCase(getDataTS[j][0])) {
					
//    				System.out.println("testCaseData TestCaseName: " + testCaseData[i][0]);
    				String keywordName = getDataTS[j][1];
    				String inputData1 = getDataTS[j][2];
    				System.out.println(keywordName);
    				System.out.println(inputData1);
    				
				}
				
			}
    		
    		
    		
			
		}

	}

	}

} 

