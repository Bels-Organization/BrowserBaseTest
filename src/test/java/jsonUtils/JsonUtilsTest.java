package jsonUtils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static jsonUtils.JsonUtils.readJsonDataset;

public class JsonUtilsTest {

    @Test
    public void readJsonDatasetTest() throws IOException, ParseException {
        String json = "{\n" +
                "  \"case\": \"jsonUtilsTest\",\n" +
                "  \"description\": \"Json to test the readJsonDataset function\"\n" +
                "}";
        JSONParser jsonParser = new JSONParser();
        Object expectedObj = jsonParser.parse(json);
        JSONObject expectedJsonObject = (JSONObject) expectedObj;
        JsonUtils jsonUtils = new JsonUtils();
        JSONObject jsonObject = readJsonDataset("src/test/resources/JsonUtilsTest.json");
        Assert.assertEquals(jsonObject, expectedJsonObject);
    }
}
