package system.library;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Dwiki
 */
public class Json {
    
    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }
    
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }
    
    public static JsonNode toJson(Object a) {
        return objectMapper.valueToTree(a);
    }
    
    public static String stingify(JsonNode node) throws JsonProcessingException {
        return generateString(node, false);
    }
    
    public static String prettyPrint(JsonNode node) throws JsonProcessingException {
        return generateString(node, false);
    }
    
    public static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        
        if (pretty) {
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        
        return objectWriter.writeValueAsString(node);
    }
    
    public static String convertFileIntoString(String file) throws Exception {
        String result; 
        
        result = new String(Files.readAllBytes(Paths.get(file)));
        
        return result;
    }
    
    private static ObjectMapper objectMapper = getDefaultObjectMapper();
    
    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
       
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        return objectMapper;
    }
}
