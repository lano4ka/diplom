package com.sveta.diplom.api;

import android.util.Base64;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;



public class AndroidHttpClient {

	/*public static void main(String[] args) throws ClientProtocolException, IOException {

		String login = "sveta";
		String password = "sveta";
		String jsonBody = executeGet("https://diplom-sveta.rhcloud.com/api/auth", "",login, password);
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(jsonBody, User.class);
		System.out.println(user.getLogin());
		String jsonHistory = executeGet("https://diplom-sveta.rhcloud.com/api/getCurrentHistory", "", login, password);
		HistoryOfSick history = mapper.readValue(jsonHistory, HistoryOfSick.class);
		System.out.println(history.getIndicators().get(0).getName());
		executeGet("https://diplom-sveta.rhcloud.com/api/sendMeasurement", "?id_indicator=" + history.getIndicators().get(0).getId_indicator() + "&value=36.6", login, password);
	}*/
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	   private static OkHttpClient client = new OkHttpClient();

	   public static String executeGet(String targetURL, String urlParameters, String login, String password) throws IOException {

		   String base = Base64.encodeToString((login + ":" + password).getBytes("UTF-8"), Base64.NO_WRAP).toString();
		   String header = "Basic " + base;
		   Request request = new Request.Builder()
				.url(targetURL + urlParameters).addHeader("Authorization", header)
				.build();
		   Response response = client.newCall(request).execute();
		   String str = response.body().string();
		   return str;
		}

}
