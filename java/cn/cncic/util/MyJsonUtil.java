package cn.cncic.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyJsonUtil {

	public static void main(String[] args) {

	}

	public static <T> String object_to_json(T t) {

		Gson gson = new Gson();

		String json = gson.toJson(t);

		try {
			json = URLEncoder.encode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;

	}

	/**
	 * 字符串转集合
	 * 
	 * @param json
	 */
	public static <T> List<T> json_to_list(String json, Class<T> t) {

		try {
			json = URLDecoder.decode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray fromObject4 = JSONArray.fromObject(json);

		List<T> collection = (List<T>) JSONArray.toCollection(fromObject4, t);

		return collection;

	}


	/**
	 * 集合转字符串
	 * 
	 * @param list_car
	 * @return
	 */
	public static <T> String list_to_json(List<T> list_car) {
		// 将list_car换为json字符串
		Gson g = new Gson();
		String json = g.toJson(list_car);
		try {
			json = URLEncoder.encode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}

}
