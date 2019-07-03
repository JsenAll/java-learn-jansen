import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class HelloJava {
    private static Logger logger = Logger.getLogger(String.valueOf(HelloJava.class));

    public static void main(String[] args) {
        String pd = "asdasd";
        Map<String, Object> param1 = new HashMap<>();
        param1.put("pd", (Object) pd);
        pd = "asdasd11";
        param1.put("pd", (Object) pd);
        logger.info("大是大非");
        System.out.println(param1);
    }
}
