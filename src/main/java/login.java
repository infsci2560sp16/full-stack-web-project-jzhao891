import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import static spark.Spark.get;
import static spark.Spark.post;

public class login {
	Gson gson=new Gson();
	public login(){
		userSignup();
	}
	public void userSignup(){
		
		post("/signup",(req,res)->{

			
			Map<String,Object> user=new HashMap<>();
			user.put("name","Zexin Zhao");
			//user.put("name",)
			System.out.println("sign up yes");
			return user;
		},gson::toJson);
		
		get("/signin",(req,res)->{
			Map<String,Object> user=new HashMap<>();
			String email=req.queryParams("email");
			user.put("email", email);
			System.out.println("sign in yes");
			return user;
		},gson::toJson);
	}
}
