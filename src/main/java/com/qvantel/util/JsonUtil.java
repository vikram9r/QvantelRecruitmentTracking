package com.qvantel.util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.qvantel.dto.JQGridDTO;
import com.qvantel.model.Candidate;
import com.qvantel.model.Job;
  
/** 
 * This class is used as a Json utility. The base functionality comes from the Gson 
 
 * package from Google. It is made generic due to the fact that many clients may use 
 
 * this class at any given moment. 
 *  
 * @author Dinuka Arseculeratne 
 * @param <T> 
 */  
public class JsonUtil {  
  
    /** 
     * Null serialize is used because else Gson will ignore all null fields. 
     */  
    private static Gson gson = new GsonBuilder().serializeNulls().create();  
  
    /** 
     * Made private because all methods are static and hence do not need 
     * object instantiation 
     */  
    private JsonUtil() {}  
    /** 
     * To Json Converter using Goolge's Gson Package 
 
     * this method converts a simple object to a json string 
     * @param <t>
     * @param <T>
 
     *  
     * @param obj 
     * @return a json string 
     */  
    public static   String toJsonObj(JQGridDTO<?> jQGridDTO) {  
    	GsonBuilder gsonBuilder = new GsonBuilder();
    	Gson gson = new GsonBuilder().serializeNulls().create();  ;
    	if(jQGridDTO.getRows().get(0) instanceof Candidate){
    		gson = gsonBuilder.registerTypeAdapter(Candidate.class, 
    		new JsonSerializer<Candidate>(){
    			@Override
    			public JsonElement serialize(Candidate candidate, Type type,
    					JsonSerializationContext jsc) {
    				JsonObject jsonObject = new JsonObject();
    				jsonObject.addProperty("id", candidate.getId());
    				jsonObject.addProperty("name", candidate.getFirstName()+" "+candidate.getLastName());
    				jsonObject.addProperty("email", candidate.getEmail());
    				jsonObject.addProperty("mobile", candidate.getMobile());
    				jsonObject.addProperty("status", candidate.getStatus());
    				return jsonObject;
    			}

    		}).create();
    	}else if(jQGridDTO.getRows().get(0) instanceof Job){
    		gson = gsonBuilder.registerTypeAdapter(Candidate.class, 
    	    		new JsonSerializer<Job>(){
    	    			@Override
    	    			public JsonElement serialize(Job job, Type type,
    	    					JsonSerializationContext jsc) {
    	    				JsonObject jsonObject = new JsonObject();
    	    				jsonObject.addProperty("id", job.getId());
    	    				jsonObject.addProperty("name", job.getJobTitle());
    	    				jsonObject.addProperty("designation", job.getDesignation());
    	    				jsonObject.addProperty("minExperience", job.getMinimumExperience());
    	    				jsonObject.addProperty("status", job.getState());
    	    				return jsonObject;
    	    			}

    	    		}).create();
    	}
        return gson.toJson(jQGridDTO);  
    }  
  
    /** 
     * Converts a collection of objects using Google's Gson Package 
     *  
     * @param objCol 
     * @return a json string array 
     */  
    public static <T> String toJsonList(List<T> objCol) {  
        return gson.toJson(objCol);  
    }  
  
    /** 
     * Returns the specific object given the Json String 
     * @param <T> 
     * @param jsonString 
     * @param obj 
     * @return a specific object as defined by the user calling the method 
     */  
    public static <T> T fromJsonToObj(String jsonString,Class<T>obj) {  
        return gson.fromJson(jsonString, obj);  
    }  
      
    /** 
     * Returns a list of specified object from the given json array 
     * @param <T> 
     * @param jsonString 
     * @param t the type defined by the user 
     * @return a list of specified objects as given in the json array 
     */  
    public static <T> List<T> fromJsonToList(String jsonString,Type t){   
        return gson.fromJson(jsonString, t);  
    }  
  
}  