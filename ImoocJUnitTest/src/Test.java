import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Test {

	public static void main(String[] args) throws Exception{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
	    map.put("apple", "新鲜的苹果");
	    map.put("computer", "配置优良的计算机");
	    map.put("book", "堆积成山的图书");
	    map.put("time", "123");
	    int size=map.size();
	    System.out.println(map.hashCode());
	    System.out.println(map);
	    System.out.println("Map集合的大小为："+size);
	}
}
