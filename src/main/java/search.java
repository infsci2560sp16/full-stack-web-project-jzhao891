import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import org.json.JSONObject;

public class search {
	Gson gson=new Gson();
	public search(){
		letgo();
	}
	public void letgo(){

		get("/letgo",(req,res)->{


			Map<String,Object> destination=new HashMap<>();
			destination.put("destination",req.queryParams("destination"));
			destination.put("contry", "China");
			destination.put("province", "Beijing");
			destination.put("population", "2500w");
			destination.put("coordination-x","12");
			destination.put("coordination-y","85");
			destination.put("area","120m^2");
			destination.put("others","Capital");
			destination.put("neighbour","Tianjin");
			destination.put("scenicspot","Tiananmen");
			destination.put("famouspeople","Jingping Xi");
			String xml =    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<destination>" +
                        "<contry>China</contry>" +
                        "<province>Beijing</province>" +
                        "<population>2500w</population>" +
                        "<coordination-x>12</coordination-x>" +
                        "<coordination-y>85</coordination-y>" +
                        "<area>120m^2</area>" +
                        "<others>Capital</others>" +
                        "<neighbour>Tianjin</neighbour>" +
                        "<scenicspot>Tiananmen</scenicspot>" +
                        "<famouspeople>Jingping Xi</famouspeople>" +
                    "</destination>";
			res.type("text/xml");
			System.out.println("search well");
			return xml;
		});

	}
}
