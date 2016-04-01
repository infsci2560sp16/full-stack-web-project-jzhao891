
import freemarker.core.Configurable;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.halt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GetDate {
	public GetDate(){
		/*Configuration conf=new Configuration();
		try {
			conf.setDirectoryForTemplateLoading(new File(Path.templatedir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			show(conf);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			show();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void show() throws TemplateException, IOException{
		/*FileWriter writer = null;
		try {
			writer = new FileWriter(Path.htmldir+"Index.html");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
        Template temp = null;
		try {
			temp = conf.getTemplate("form.ftl");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       temp.process(maps, writer);*/
		get("/Index",(req,res)->{
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
			return new ModelAndView(maps,"form.ftl");
		},new FreeMarkerEngine());
        
	}
	
}
