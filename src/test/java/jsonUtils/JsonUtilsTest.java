package jsonUtils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static jsonUtils.JsonUtils.readJson;
import static jsonUtils.JsonUtils.readJsonDataset;

public class JsonUtilsTest {

    @Test
    public void readJsonTest() throws IOException, ParseException {
        String json = "{\n" +
                "  \"case\": \"jsonUtilsTest\",\n" +
                "  \"description\": \"Json to test the readJsonDataset function\"\n" +
                "}";
        JSONParser jsonParser = new JSONParser();
        Object expectedObj = jsonParser.parse(json);
        JSONObject expectedJsonObject = (JSONObject) expectedObj;
        JSONObject jsonObject = readJson("src/test/resources/ReadJsonTest.json");
        Assert.assertEquals(jsonObject, expectedJsonObject);
    }

    @Test
    public void readJsonDatasetTest() throws IOException, ParseException {
        Object[][] objectList = readJsonDataset("src/test/resources/ReadJsonDatasetTest.json");
        Assert.assertEquals(objectList[0][0].toString(), "1");
        Assert.assertEquals(objectList[0][1].toString(), "First case test");
        Assert.assertEquals(objectList[1][0].toString(), "2");
        Assert.assertEquals(objectList[1][1].toString(), "Second case test");
    }
}
