package manipulation_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DictionaryFactory {


    public static void populateTranslationObject(TranslationPOJO translation, List<String> keys, List<List<String>> values){
        translation.setAllLanguages(populateAllLanguages(keys, values));
    }
    private static List<HashMap<String,String>> populateAllLanguages(List<String> keys, List<List<String>> values){
        List<HashMap<String, String>> allLanguages = new ArrayList<HashMap<String, String>>();

        for(List<String> language : values){
            allLanguages.add(populateLanguage(keys, language));
        }

        return allLanguages;
    }

    private static HashMap<String, String> populateLanguage (List<String> keys, List<String> values){
        HashMap<String, String> language = new HashMap<String, String>();

        for(int iterator = 0 ; iterator < keys.size() ; iterator++){
            language.put(keys.get(iterator), values.get(iterator));
        }

        return language;
    }
}
