import manipulation_handler.DictionaryFactory;
import manipulation_handler.TranslationPOJO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import swift_string_parser.StringFileBuilder;
import xml_parser.XmlFileBuilder;

import java.io.IOException;


public class TranslateConverterLauncher {
    public static final String xmlFilePath = "C:\\Users\\laurentiu.pirvan\\IdeaProjects\\TranslateConverter\\strings.xml";

    public static void main(String[] args){
        ParsingExcel excel = new ParsingExcel();
        String XLSX_FILE_PATH = "./localized_new.xlsx";

        try {
            excel.setWorkbook(XLSX_FILE_PATH);

            TranslationPOJO translation = new TranslationPOJO();

            Keys keys = new Keys(ExcelReader.readAllKeysInFile(excel.getWorkbook()));
            DictionaryFactory.populateTranslationObject(translation, keys.getKeys(), ExcelReader.readAllValuesInFile(excel.getWorkbook(), 2));

            System.out.println(translation.getAllLanguages().get(1).get("\"market_price\""));

            XmlFileBuilder.buildXml(translation, keys.getKeys());
            StringFileBuilder.buildString(translation, keys.getKeys());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }
}
