package test;

import java.util.HashMap;
import java.util.Map;

public class map {
    private final static HashMap<String,String> map = new HashMap<String,String>();

    public static void main(String[] args){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("test","test");
        hashMap.put("best","best");
        map.putAll(hashMap);
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
    }
}
class User{
    String name;
    String pwd;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
