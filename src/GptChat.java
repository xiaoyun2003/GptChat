import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class GptChat {
    String BASE_URL="https://chat.openai.com";

    HashMap<String,String> BASE_HEADER=new HashMap<String,String>();

    GptChat(){
        this.BASE_HEADER.put("referer", "https://chat.openai.com/chat");
        this.BASE_HEADER.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        this.BASE_HEADER.put("origin", "https://chat.openai.com");
        this.BASE_HEADER.put("accept", "text/event-stream");
        this.BASE_HEADER.put("content-type", "application/json");
        this.BASE_HEADER.put("Connection", "Keep-Alive");
    }

    //登录协议，你必须使用一个vpn节点或者系统代理来进行此函数，由于gpt限制中国登录，你不得不这样做，但是我们底层http暂时不支持提供代理访问，所以你不得不依靠外界手段和设备来实现vpn
    //这里暂时没有研究
    public User_Gpt_Chat login(String user,String pwd){
        User_Gpt_Chat u=new User_Gpt_Chat();
        u.user=user;
        u.pwd=pwd;
        return u;
    }
    
    //获取会话用的cookies,refresh session,该方法也会根据token覆盖修正User_Gpt_Chat的信息
    public String getRefreshCookie(User_Gpt_Chat u){
        try {
            HTTP http = new HTTP(this.BASE_URL + "/api/auth/session");
            HashMap<String,String> h=new HashMap<>();
            h.put("authorization", u.token);
            h.putAll(BASE_HEADER);
            h.put("cookie", u.cookies);
            http.setHeader(h);
            String res = http.get();
            if(res.isEmpty()){
                System.out.println("[error]getRefreshCookie:the res from http is empty");
                return "";
            }
            JSONObject JS= JSON.parseObject(res);
            u.user=JS.getJSONObject("user").getString("name");
            u.token="Bearer "+JS.getString("accessToken");
            u.cookies=http.getCookie();
            return u.cookies;
        }catch (Exception e){
            System.out.println("[error]getRefreshCookie:"+e.getLocalizedMessage());
            return "";
        }
    }

    public String chat(User_Gpt_Chat u,Gpt_Conversion cc,String text){
        try {
            String id = cc.id;
            String conversion_id = cc.parent_id;
            String parent_id = cc.parent_id;

            String data="";
            if(!cc.conversion_id.isEmpty()){
                data = "{\"action\":\"next\",\"messages\":[{\"id\":\"" + id + "\",\"role\":\"user\",\"content\":{\"content_type\":\"text\",\"parts\":[\"" + text + "\"]}}],\"conversation_id\":\"" + conversion_id + "\",\"parent_message_id\":\"" + parent_id + "\",\"model\":\"text-davinci-002-render\"}";
            }else {
                data="{\"action\":\"next\",\"messages\":[{\"id\":\""+id+"\",\"role\":\"user\",\"content\":{\"content_type\":\"text\",\"parts\":[\""+text+"\"]}}],\"parent_message_id\":\""+parent_id+"\",\"model\":\"text-davinci-002-render\"}";
            }

            HTTP http = new HTTP("https://chat.openai.com/backend-api/conversation");
            HashMap<String, String> h = new HashMap<>();

            h.put("authorization", u.token);
            h.put("cooki", u.cookies);
            h.putAll(BASE_HEADER);
            http.setHeader(h);
            String res = http.post(data);
            if (res.isEmpty() || http.getCode()!=200) {
                System.out.println("[error]chat:the res from http is empty or response is error");
                System.out.println(res);
                return "";
            }
            String sarray[]=res.split("data:");

            JSONObject JS=JSON.parseObject(sarray[sarray.length-2]);
            cc.conversion_id=JS.getString("conversation_id");
            JSONObject MSG=JS.getJSONObject("message");
            cc.parent_id=MSG.getString("id");
            JSONObject CONTENT=MSG.getJSONObject("content");
            JSONArray r=CONTENT.getJSONArray("parts");
            String res1="";
            for(int i=0;i<r.size();i++){
                res1+=r.getString(i)+"\n";
            }
            return res1;
        }catch (Exception e){
            System.out.println("[error]chat:"+e.getLocalizedMessage());

            return "";
        }


    }





}
