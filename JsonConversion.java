package com.myself.mytests;

import com.google.gson.Gson;

public class JsonConversion {
    String userName="userName";
    String password="passWord";
    
	public static void main(String[] args) {
		JsonConversion jsonMaker = new JsonConversion();
		Gson gson = new Gson();
		String strJson = gson.toJson(jsonMaker);
		System.out.println(strJson);
	}

}
