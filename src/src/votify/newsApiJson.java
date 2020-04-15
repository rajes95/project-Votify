package votify;

/*
 * @author Rajesh Sakhamuru
 * @version 4/14/2020
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class newsApiJson
{
	
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private String apiURL = "";
	private JSONObject jsonObj = null;
	private JSONArray jsonArr = null;

	private String[] urlArray = null;
	private String[] imgURLArray = null;
	private String[] titleArray = null;
	private String[] descriptionArray = null;
	private String[] authorArray = null;

	public String getURL(int index)
	{
		return urlArray[index];
	}

	public String getImgURL(int index)
	{
		return imgURLArray[index];
	}

	public String getTitle(int index)
	{
		return titleArray[index];
	}

	public String getDescription(int index)
	{
		return descriptionArray[index];
	}

	public String getAuthor(int index)
	{
		return authorArray[index];
	}

	public newsApiJson(String searchTerm) throws IOException, JSONException
	{
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		c.add(Calendar.DATE, -1);

		Date yesterdayDate = c.getTime();

		String yesterday = dateFormat.format(yesterdayDate);

		apiURL = "http://newsapi.org/v2/everything?"
				+ "q="+searchTerm+"&"
				+ "from="+yesterday+"&"
				+ "sortBy=popularity&"
				+ "apiKey=9a1b6ef13dee41a58ec7ef35b52829ba";

		jsonObj = readJsonFromUrl(apiURL);
		jsonArr = (JSONArray) jsonObj.get("articles");

		imgURLArray = new String[jsonArr.length()];
		urlArray = new String[jsonArr.length()];
		titleArray = new String[jsonArr.length()];
		descriptionArray = new String[jsonArr.length()];
		authorArray = new String[jsonArr.length()];

		for(int i = 0; i < jsonArr.length(); i++)
		{
			JSONObject article = (JSONObject) jsonArr.get(i);

			if(article.get("url") != org.json.JSONObject.NULL)
			{
				urlArray[i] = (String) article.get("url");
			}

			if(article.get("urlToImage") != org.json.JSONObject.NULL)
			{
				imgURLArray[i] = (String) article.get("urlToImage");
			}

			if(article.get("title") != org.json.JSONObject.NULL)
			{
				titleArray[i] = (String) article.get("title");
			}

			if(article.get("description") != org.json.JSONObject.NULL)
			{
				descriptionArray[i] = (String) article.get("description");
			}

			if(article.get("author") != org.json.JSONObject.NULL)
			{
				authorArray[i] = (String) article.get("author");
			}
		}
	}


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
}
