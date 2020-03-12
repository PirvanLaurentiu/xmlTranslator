package manipulation_handler;

import java.util.HashMap;
import java.util.List;

public class TranslationPOJO {
    List<HashMap<String, String>> allLanguages;

    public List<HashMap<String, String>> getAllLanguages() {
        return allLanguages;
    }

    public void setAllLanguages(List<HashMap<String, String>> allLanguages) {
        this.allLanguages = allLanguages;
    }
}
