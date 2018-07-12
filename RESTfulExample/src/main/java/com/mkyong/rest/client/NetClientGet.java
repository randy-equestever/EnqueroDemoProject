package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

		try {

			URL url = new URL(
					"http://localhost:8080/RESTfulExample/json/product/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			
			long sumNumbers = 0;
			long totalSumNumbers = 0;
			long totalNumbersExecuted = 0;
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(output);
				JSONArray outputArray = (JSONArray) obj;
				Iterator<JSONObject> iterator = outputArray.iterator();
				 while (iterator.hasNext()) {
				//Object innerObj = parser.parse(iterator.next());
				JSONObject jsonObject = iterator.next();
				
				String name = (String) jsonObject.get("name");
				System.out.println(name);
				 JSONArray numbers = (JSONArray) jsonObject.get("numbers");
				 System.out.println(numbers);
				 Iterator<Long> numbersIterator = numbers.iterator();
		            while (numbersIterator.hasNext()) {
		                sumNumbers = sumNumbers + numbersIterator.next();
		                totalNumbersExecuted++;
		            }
		            System.out.println("sumNumbers: " + sumNumbers);
		            totalSumNumbers = totalSumNumbers + sumNumbers;
				}
			System.out.println("totalNumbersExecuted: " + totalNumbersExecuted);
			System.out.println("totalSumNumbers: " + totalSumNumbers);
			}
			conn.disconnect();

		} catch (Exception e) {

			e.printStackTrace();
		}  

	}

}