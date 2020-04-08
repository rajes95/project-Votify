/*
 * @author Rajesh Sakhamuru
 * @version 4/7/2020
 * 
 * As is, the code prints the JSON data of the top 20 news articles from the last 2 days
 * relating to the "USA Presidential Primary 2020" keyword.
 * 
 * Some starter code borrowed from:
 *     https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
 * in post by:
 *     Roland Illig
 */
		
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
//import org.json.JSONArray;

public class newsApiJson
{
	
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private static String readAll(Reader rd) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1)
		{
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException
	{
		InputStream is = new URL(url).openStream();
		try
		{
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		}
		finally
		{
			is.close();
		}
	}

	public static void main(String[] args) throws IOException, JSONException
	{
		
		
		Date currentDate = new Date();		
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		
		c.add(Calendar.DATE, -1);
		
		Date yesterdayDate = c.getTime();
		
		String yesterday = dateFormat.format(yesterdayDate);
		
		String apiURL = "http://newsapi.org/v2/everything?"
				+ "q=USA+Presidential+Primary+2020&"
				+ "from="+yesterday+"&"
				+ "sortBy=popularity&"
				+ "apiKey=9a1b6ef13dee41a58ec7ef35b52829ba";
		
		JSONObject json = readJsonFromUrl(apiURL);
//		pretty print the JSON
		System.out.println(json.toString(2));
		
//		JSONArray jsonArr = json.getJSONArray("articles");

		
		
		
		
		
	}
}