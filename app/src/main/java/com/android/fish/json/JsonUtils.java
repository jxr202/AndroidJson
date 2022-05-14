package com.android.fish.json;

import android.util.JsonReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class JsonUtils 
{
	/**
	 * 解析JSON对象
	 * @param jsonData
	 */
	public static void parseJson(String jsonData)
	{
		try {
			//有解析JSON数据前，需要一个JsonReader对象
			JsonReader reader = new JsonReader(new StringReader(jsonData));
			//开始解析数组
			reader.beginArray();
			while(reader.hasNext())
			{
				//开始解析对象
				reader.beginObject();
				while (reader.hasNext()) 
				{
					String key = reader.nextName();
					String val = reader.nextString();
					System.out.println("key & val -> " + key + "|" + val);
				}
				reader.endObject();
			}
			reader.endArray();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将JSON转换成JavaBean对象，
	 * 注意，这里只能将单一的JSON对象转换成Bean对象; like {"key":"value"}
	 * @param jsonData 
	 * @param clazz
	 * @return
	 */
	public static Object parseJsonToObject(String jsonData, Class<?> clazz)
	{
		//创建一个gson对象
		Gson gson = new Gson();
		Object object = gson.fromJson(jsonData, clazz);
		return object;
	}
	
	public static LinkedList<?> parseJsonToList(String jsonData, Class<?> clazz)
	{
		Type type = new TypeToken<LinkedList<?>>(){}.getType();
		Gson gson = new Gson();
		LinkedList<?> list = gson.fromJson(jsonData, type);
		for (Object obj : list)
		{
			System.out.println("---------" + obj);
		}
		return list;
	}
	

}
