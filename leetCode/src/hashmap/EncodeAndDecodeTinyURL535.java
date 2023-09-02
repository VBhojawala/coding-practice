package hashmap;

import arrays.EncodeAndDecodeStrings271;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL535 {

    private Map<String, String> data = new HashMap<>();
    private long id = 0;
    private final String baseUrl = "http://tinyurl.com/";
    public String encode(String longUrl) {
        data.put(String.valueOf(id), longUrl);
        return  baseUrl+ id++;
    }
    public String decode(String shortUrl) {
        return data.get(shortUrl.substring(19));
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL535 prog =new EncodeAndDecodeTinyURL535();
        System.out.println(prog.decode(prog.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
