package com.produce.hibernate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Dhananjay
 *
 */

	public class HttpClientDemo {

		public static List<User> getALLUsers() throws ClientProtocolException, IOException, JSONException {
			DefaultHttpClient http = new DefaultHttpClient();
			HttpGet Getreq = new HttpGet("http://jsonplaceholder.typicode.com/users");
			Getreq.addHeader("accept", "application/json");

			HttpResponse response = http.execute(Getreq);

			HttpEntity entity = response.getEntity();
			String country = EntityUtils.toString(entity);
			List<User> l = new ArrayList<User>();
			ObjectMapper mapper = new ObjectMapper();
			JSONArray jsonarray = new JSONArray(country);

			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject object = jsonarray.getJSONObject(i);
				String Sobject = object.toString();
				User c = mapper.readValue(Sobject, User.class);
				l.add(c);
				}
			
			return l;
		}

		public static User getUser(int i) throws ClientProtocolException, IOException {
			DefaultHttpClient http = new DefaultHttpClient();
			HttpGet Getreq = new HttpGet("http://jsonplaceholder.typicode.com/users/" + i);
			Getreq.addHeader("accept", "application/json");
			HttpResponse response = http.execute(Getreq);

			HttpEntity entity = response.getEntity();
			String country = EntityUtils.toString(entity);
			User c = new ObjectMapper().readValue(country, User.class);
			return c;
		}

		public static boolean DeleteUser(int i) throws ClientProtocolException, IOException {
			DefaultHttpClient http = new DefaultHttpClient();
			HttpDelete Delreq = new HttpDelete("http://jsonplaceholder.typicodSe.com/users/" + i);
			Delreq.addHeader("accept", "application/json");
			HttpResponse response = http.execute(Delreq);

			return true;
		}
		
		public static void main(String[] args) throws ClientProtocolException, JSONException, IOException {
			
			System.out.println(HttpClientDemo.getALLUsers());
			
		}
}
