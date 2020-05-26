import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import acm.program.ConsoleProgram;

public class GelToUsd {

	public double gelToUSD(double gel) {
		try {
			
			URL url  = new URL("http://www.nbg.ge/rss.php");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
			
			con.setConnectTimeout(20000);
			con.setReadTimeout(20000);
			con.setRequestMethod("GET");
			
			InputStream inputStream = con.getInputStream();
			byte[] res = new byte[2048];
			int k = 0;
			StringBuilder response = new StringBuilder();
			while ((k = inputStream.read(res)) != -1) {
				response.append(new String(res, 0, k));
			}
			inputStream.close();
			
			String XMLString = response.toString();
			double rate =	findRate(XMLString);
			
			double USD = gel * rate;
			return USD;
					
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}		
		return 0;
	}

	private double findRate(String XMLString){
		int index = XMLString.indexOf("USD");
		XMLString = XMLString.substring(index);
		
		int n = 0;
		int ind = 0;
		for(int i = 0; i < XMLString.length(); i++) {
			if(XMLString.charAt(i) == '>') {
				n++;
				if(n == 4){
					ind = i;
					break;
				}
			}
		}
		String courseStr = XMLString.substring(ind + 1, ind + 7);
		
		double course = Double.parseDouble(courseStr);
		return course;
	}

}