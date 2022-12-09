import java.util.UUID;

public class Gpt_Conversion {
    String id="";
    String conversion_id="";
    String parent_id="";
    Gpt_Conversion(){
        id= UUID.randomUUID().toString();
        parent_id=UUID.randomUUID().toString();
    }

}
