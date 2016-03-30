
import freemarker.core.Configurable;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.halt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SayHi {

	public SayHi() throws IOException {
		// TODO Auto-generated method stub
		/*final Configuration configuration =new Configuration();
		configuration.setClassForTemplateLoading(SayMyName.class, "/");
		get("/", (request,response)->{
			FileWriter writer=new FileWriter("public/index.html");
			try{
				Map<String,Object> maps=new HashMap<String,Object>();
				maps.put("name", "Zexin Zhao");
                maps.put("email", "jzhao891@gmail.com");
				Template formTemplate=configuration.getTemplate("spark/template/freemarker/form.ftl");
				formTemplate.process(maps, writer);
			}catch(Exception e){
				halt(500);
			}
			return writer;
		});
		post("/sait", (request,response)->{
			StringWriter writer = new StringWriter();
			try{
				String name = request.queryParams("name")!=null?request.queryParams("name"):"anonymous";
				String email=request.queryParams("email")!=null?request.queryParams("email"):"unknow";
				Template resultTemplate = configuration.getTemplate("spark/template/freemarker/result.ftl");
				 
                Map<String, Object> map = new HashMap<>();
                map.put("name", name);
                map.put("email", email);
                resultTemplate.process(map, writer);
			}catch(Exception e){
				halt(500);
			}
			return writer;
		});*/
		
		Configuration conf=new Configuration();
		conf.setDirectoryForTemplateLoading(new File(Path.templatedir));
		FileWriter writer=new FileWriter(Path.htmldir+"Index.html");
		Map<String,String[]> maps=new HashMap<String,String[]>();
		//SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        String dayOfWeek = (new Date()).toString();
        String[] date=dayOfWeek.split(" ");
        String[] time=date[3].split(":");
        if(Integer.valueOf(time[0])>=6&&Integer.valueOf(time[0])<=12){
        	date[3]="morning";
        }
        else if(Integer.valueOf(time[0])>12&&Integer.valueOf(time[0])<=19){
        	date[3]="afternoon";
        }
        else{
        	date[3]="night";
        }
		maps.put("date", date);
        Template temp=conf.getTemplate("form.ftl");
        try{
        	temp.process(maps, writer);
        }catch(TemplateException e){
        	halt(500);
        }
        
	}

}
