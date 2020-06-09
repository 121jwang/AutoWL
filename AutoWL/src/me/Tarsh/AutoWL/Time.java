package me.Tarsh.AutoWL;

import java.time.Instant;

public class Time {
	// Gets the UTC time in XX:XX format
	public static String getTime() {
		/*
		 * try { URL url = new URL("http://worldtimeapi.org/api/timezone/Etc/UTC.txt");
		 * HttpURLConnection con = (HttpURLConnection) url.openConnection();
		 * con.setRequestMethod("GET");
		 * 
		 * BufferedReader in = new BufferedReader(new
		 * InputStreamReader(con.getInputStream())); String inputLine;
		 * 
		 * StringBuffer content = new StringBuffer(); while ((inputLine = in.readLine())
		 * != null) { content.append(inputLine + "\n"); } in.close();
		 * 
		 * // Parses the return data into a hashmap Map<String, String> vals = new
		 * HashMap<String, String>(); String[] pairs = content.toString().split("\n");
		 * 
		 * for (int i = 0;i < pairs.length; i++) { String pair = pairs[i]; try{ String[]
		 * keyValue = pair.split(": "); vals.put(keyValue[0], keyValue[1]); } catch
		 * (ArrayIndexOutOfBoundsException e){ continue; } }
		 * 
		 * String[] time = vals.get("datetime").split("T")[1].split(":"); return time[0]
		 * + ":" + time[1]; } catch (IOException e) { return "error"; }
		 * 
		 */

		String timeVal = Instant.now().toString();
		String[] time = timeVal.split("T")[1].split(":");
		return time[0] + ":" + time[1];
	}
}
