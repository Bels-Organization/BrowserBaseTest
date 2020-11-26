package jsonUtils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    /**
     * Reads a Json file and returns its contents as JSONObject
     * @param filePathAndName Path and name of the Json file we want to read and parse
     * @return Returns the JSONObject with the data of the read file
     * @throws IOException
     * @throws ParseException
     */
    public static JSONObject readJsonDataset (String filePathAndName) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filePathAndName));
        return (JSONObject) obj;
    }
}
