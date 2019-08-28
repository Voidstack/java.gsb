package gsb.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ConfigManager {
	
	public ConfigManager() {
		
		
		
		
	}

	public static HashMap<String,String> getArg() {
		
		HashMap<String,String> res = new HashMap<String,String>();
		
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader("config");
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				
				String[] s = sCurrentLine.split(":");
				if(s.length > 1 && s.length < 3 ){
					
					res.put(s[0], s[1]);
					
				}
				
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return res;
		
	}

	
}
