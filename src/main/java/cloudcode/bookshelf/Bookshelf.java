package cloudcode.bookshelf;
import java.io.BufferedWriter;
import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.GenerationConfig;
import com.google.cloud.vertexai.generativeai.preview.GenerativeModel;
import com.google.cloud.vertexai.generativeai.preview.ResponseHandler;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class Bookshelf implements HttpFunction {
  private static final Gson gson = new Gson();

 @Override
  public void service(HttpRequest request, HttpResponse response) throws Exception {
    BufferedWriter writer = response.getWriter();

 // Get the request body as a JSON object.
 JsonObject requestJson = new Gson().fromJson(request.getReader(), JsonObject.class);
 JsonArray calls_array = requestJson.getAsJsonArray("calls");
 JsonArray calls = (JsonArray) calls_array.get(0);
 String context = calls.get(0).toString().replace("\"", "");

 //Invoke Gemini model
  String raw_result = callGemini(context);
  raw_result = raw_result.replace("\n","");
  String trimmed = raw_result.trim();
  List<String> result_list = Arrays.asList(trimmed);
  Map<String, List<String>> stringMap = new LinkedHashMap<>();
  stringMap.put("replies", result_list);
 
  // Serialization
  String return_value = gson.toJson(stringMap);
  writer.write(return_value);
    }
  public String callGemini(String context) throws IOException{
      String res = "";
        try (VertexAI vertexAi = new VertexAI("duet-ai-414814", "us-central1"); ) {
          GenerationConfig generationConfig =
              GenerationConfig.newBuilder()
                  .setMaxOutputTokens(2048)
                  .setTemperature(0.4F)
                  .setTopK(32)
                  .setTopP(1)
                  .build();  
        GenerativeModel model = new GenerativeModel("gemini-pro", generationConfig, vertexAi);
        GenerateContentResponse response = model.generateContent(context);
        res = ResponseHandler.getText(response);
      }catch(Exception e){
        System.out.println(e);
        }
        return res;
    }
}