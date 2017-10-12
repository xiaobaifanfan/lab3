package text1;

import java.util.HashMap;

public class quchong {
	
	public static void main(String[] args) {
        String s[] = {"abc","ABC","123","234","AbC","aBC","aaa"};
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String ss:s){
            hm.put(ss.toLowerCase(), 1);   //用hashmap除去重复的值
        }
        for(String ss:hm.keySet()){
            System.out.println(ss);  //这里直接输出了，如果要保存在这里做操作就可以了，
        }
        
        
    }
}
