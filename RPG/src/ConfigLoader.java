import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class ConfigLoader {

    public static Map<String, ClassStats> loadClassStats() {
        try {
            InputStream input = ConfigLoader.class.getResourceAsStream("/class_config.json");

            if(input == null) {
                System.out.println("Błąd wczytania pliku");
                return null;
            }

            Reader reader = new InputStreamReader(input);

            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, ClassStats>>(){}.getType();

            Map<String, ClassStats> stats = gson.fromJson(reader, type);
            reader.close();

            return stats;

        } catch (Exception e) {
            System.out.println("Błąd wczytywania pliku");
            return null;
        }
    }

}
