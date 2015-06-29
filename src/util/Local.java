package util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Local {

	private ResourceBundle bundle = null;
	private static Local self = null;

	private Local() {
		
	}
	
	public static Local getInstance() {
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
	
	public String[] getUserLabels() {
		String[] userlabels = {getInstance().getLocalString("forname"),getInstance().getLocalString("lastname"),getInstance().getLocalString("street"),getInstance().getLocalString("zip"),getInstance().getLocalString("city"),getInstance().getLocalString("birthdate")};
		return userlabels;
	}
	
	public String getLocalString(String label) {
		if(bundle == null) {
			init(System.getProperty("user.country"), System.getProperty("user.language"));
		}
		
		String ls = bundle.getString(label);
		if(ls == null) {
			return "{"+label+"}";
		}
		else
		{
			if(ls == "")
				return "{"+label+"}";
			else
				return ls;
		}
	}

}
