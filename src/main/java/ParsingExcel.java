import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ParsingExcel {

    private Workbook workbook;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(String workbook) throws IOException, InvalidFormatException {
        this.workbook = WorkbookFactory.create(new File(workbook));

    }
}
