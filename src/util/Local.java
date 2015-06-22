package util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Local {

	private ResourceBundle bundle = null;
	private static Local self = null;

	private Local() {
		
	}
	
	public Local getInstance() {
		if(self == null) self = new Local();
		
		return self;
	}
	
	public void init(String lang, String country) {
		  if(lang == null || country == null) {
			  lang = "en";
			  country = "US";
			  // Fallback
		  }
			  
		  Locale locale = new Locale(lang, country);
	      bundle = ResourceBundle.getBundle("res.lang",locale);
	}
	
	public String getLocalString(String label) {
		if(bundle == null) {
			init(System.getProperty("user.country"), System.getProperty("user.language"));
		}
		
		return bundle.getString(label);
	}

}
