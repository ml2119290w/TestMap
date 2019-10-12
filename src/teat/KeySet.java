package teat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySet {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("PS4","战神");
        map.put("Switch","萨尔达");
        map.put("Xbox","光环");
        map.put("PC","嘿嘿");
        Set<String> keySet = map.keySet();
        for (String key:keySet) {
            System.out.println("KEY:"+key);
        }
    }
}
