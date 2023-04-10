package readexcel;

import org.testng.annotations.DataProvider;

public class DataProviderLogic {
    @DataProvider(name = "testData")
    public Object[][] getData(){
        ReadExcelData readExcelData = new ReadExcelData("C:\\CQADataDrivenFramework\\src\\main\\resources\\Book1.xlsx");
        int rows = readExcelData.getRowCount(0);

        Object[][] credentials = new Object[rows][2];
        for (int i=0;i<rows;++i){
            for (int j=0;j<2 ; j++){
                credentials[i][0] = readExcelData.getData(0,i,0);
                credentials[i][1] = readExcelData.getData(0,i,1);
            }
        }
        return credentials;
    }
}

