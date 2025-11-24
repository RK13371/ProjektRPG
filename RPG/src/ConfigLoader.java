import java.io.FileReader;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConfigLoader {

    public static Map<String, ClassStats> loadClassStats() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("class_config.json");

            Map<String, ClassStats> map =
                    gson.fromJson(reader, new TypeToken<Map<String, ClassStats>>(){}.getType());

            reader.close();
            return map;
        } catch (Exception e) {
            System.out.println("Błąd wczytywania pliku");
            return null;
        }
    }

}
