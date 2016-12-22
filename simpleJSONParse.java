import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;




public class simpleJSONParse {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws org.json.simple.parser.ParseException {  
		  
		  JSONParser parser = new JSONParser();  
		  
		  try {  

		   Object obj = parser.parse(new FileReader("/Users/Lokesh/Desktop/EclipseWS/SampleJSONParser/sampleJson.txt"));  
		  
		   JSONObject jsonObject = (JSONObject) obj;  
		   System.out.println("Json obj entry set" +jsonObject.entrySet());
		   
		   Set entrySet = jsonObject.entrySet();
		   for(Object entry:entrySet){
			   System.out.println("Inside entry set" +entry); //+"in "+entrySet);
			   String tableName = (String) jsonObject.get(entry);
			   System.out.println("Table name is: " +tableName);
		   }
		   
		   Set keySet = jsonObject.keySet();
		   for(Object key:keySet){
			   System.out.println("Keys are "+ key);
		   }
		   
		  //trying map implementation
		   //Map.Entry<String, Tab>
		   HashMap<String, String> hash = new HashMap<String,String>();
		   //to get all values from map
		   for(String s : hash.values()){
			   System.out.println("Value in s: " +s);
		   }
		   
		   //to get all values from map
		   for ( Map.Entry<String, String> entry : hash.entrySet()) {
			    String key = entry.getKey();
			    String value = entry.getValue();
			    // do something with key and/or tab
			    System.out.println("Inside map" +key+" "+value);
			}
		  
		   String nameOfCountry = (String) jsonObject.get("Name");  
		   System.out.println("Name Of Country: "+nameOfCountry);  
		  
		   long population = (Long) jsonObject.get("Population");  
		   System.out.println("Population: "+population);  
		  
		   System.out.println("States are :");  
		   JSONArray listOfStates = (JSONArray) jsonObject.get("States");  
		   @SuppressWarnings("unchecked")
		Iterator<String> iterator = listOfStates.iterator();  
		   while (iterator.hasNext()) {  
		    System.out.println(iterator.next());  
		   }  
		  
		  } catch (FileNotFoundException e) {  
		   e.printStackTrace();  
		  } catch (IOException e) {  
		   e.printStackTrace();  
		  }  
	}

}
