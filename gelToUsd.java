import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import acm.program.ConsoleProgram;
public class GelToUsd extends ConsoleProgram{
	
	public void run() {
		while(true) {
		double gel = readDouble();
		double result = gelToUSD(gel);
		println(result);
		
		}
	}
	
		
	private double gelToUSD(double gel) {
		try {
			//Create connection
			String request = "<Employee><Name>Sunil</Name></<Employee>";
			URL url  = new URL("http://www.nbg.ge/rss.php");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setConnectTimeout(20000);
			con.setReadTimeout(20000);
			
			con.setDoOutput(true);
			con.setRequestMethod("GET");
			
			// write XML
			OutputStream outputStream = con.getOutputStream();
			byte[] b = request.getBytes("UTF-8");
			outputStream.write(b);
			outputStream.flush();
			outputStream.close();
			
			
			// Read XML
			InputStream inputStream = con.getInputStream();
			byte[] res = new byte[2048];
			int k = 0;
			StringBuilder response = new StringBuilder();
			while ((k = inputStream.read(res)) != -1) {
				response.append(new String(res, 0, k));
			}
			
			inputStream.close();
			
			//Find exchange rate
			String XMLString = response.toString();
			
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
			
			String courseStr = XMLString.substring(ind + 1, ind+6);
			
			double course = Double.parseDouble(courseStr);
			
			double USD = gel * course;
			return USD;
					
		} catch (IOException e) {
			println("Something went wrong");
		}
		
		return 0;
		
	}
}
;