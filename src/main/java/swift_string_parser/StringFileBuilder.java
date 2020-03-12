package swift_string_parser;

import manipulation_handler.TranslationPOJO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class StringFileBuilder {
    public static void buildString(TranslationPOJO translationPOJO, List<String> keys) {
        try {


            List<HashMap<String, String>> allLanguages = translationPOJO.getAllLanguages();

            for (int iterator = 0; iterator < 2; iterator++) {

                File myObj = new File("Localizable" + iterator + ".strings");
                FileWriter writer = new FileWriter(myObj);

                for (String key : keys) {
                    if(!key.equals(""))
                        writer.write(key + " = " + allLanguages.get(iterator).get(key) + ";\n");
                    else
                        writer.write("\n");
                }
                writer.close();
            }


        } catch (
                IOException e) {
            System.out.println("An error occurred at string builder.");
            e.printStackTrace();
        }

    }
}
