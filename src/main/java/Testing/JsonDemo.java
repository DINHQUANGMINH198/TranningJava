package Testing;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class JsonDemo {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("C:/Users/NC PC/IdeaProjects/Project_training/src/main/java/Test2/files/config.json")) {
            //Read JSON file
            Object obj = JSONValue.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            String input = (String) jsonObject.get("input");
            String output = (String) jsonObject.get("output");
            long lengthArray = (Long) jsonObject.get("lengthArray");
            long threads = (Long) jsonObject.get("threads");
            boolean random = (Boolean) jsonObject.get("random");
            //printing the values

            System.out.println(lengthArray);
            System.out.println(random);
            System.out.println(threads);
            System.out.println(input);
            System.out.println(output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

