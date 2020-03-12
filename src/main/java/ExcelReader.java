import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;

import java.util.ArrayList;
import java.util.List;

class ExcelReader {
    static List<String> readAllKeysInFile(Workbook workbook) {

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        List<String> keys = new ArrayList<String>();

        for (Row row: sheet) {
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                //System.out.print(cellValue + "\t");
                keys.add(cellValue);
                break;
            }
            //System.out.println();
        }

        System.out.println(keys.toString());

        // Closing the workbook
        return keys;
    }

    static List<List<String>> readAllValuesInFile(Workbook workbook, int languagesNo){
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        List<List<String>> languages = new ArrayList<List<String>>();

        //System.out.println(sheet.getColumnWidth(1));

        for(int columnIndex = 1; columnIndex <= languagesNo ; columnIndex++) {
            List<String> values = new ArrayList<String>();

            for (int rowIndex = 0; rowIndex < sheet.getDefaultRowHeight(); rowIndex++) {
                Row row = CellUtil.getRow(rowIndex, sheet);
                Cell cell = CellUtil.getCell(row, columnIndex);
                String cellValue = dataFormatter.formatCellValue(cell);
                values.add(cellValue);
            }
            languages.add(values);
            System.out.println(values.toString());
        }

        return languages;
    }
}