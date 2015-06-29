package util;

import java.util.Locale;
import java.util.MissingResourceException;
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
	
	/**
	 * Initilisiert die angegebene Sprache. Wird automatisch bei getLocalString aufgerufen,
	 * falls noch keine Sprache initiliasiert wurde;
	 *
	 * @param  lang Sprache Falls null default "en"
	 * @param  country Land Falls null default "US"
	 * @see  getLocalString()
	 */	
	public void init(String lang, String country) {
		  if(lang == null || country == null) {
			  lang = "en";
			  country = "US";
			  // Fallback Sprache
		  }
			  
		  Locale locale = new Locale(lang, country);
	      bundle = ResourceBundle.getBundle("res.lang",locale);
	}
	
	/**
	 * Holt sich die userLabels in der gewählten Sprache.
	 * @see CreateUserFrame
	 */	
	public String[] getUserLabels() {
		String[] userlabels = {getInstance().getLocalString("forname"),getInstance().getLocalString("lastname"),getInstance().getLocalString("street"),getInstance().getLocalString("zip"),getInstance().getLocalString("city"),getInstance().getLocalString("birthdate")};
		return userlabels;
	}
	
	/**
	 * Holt sich den übersetzten String in der gewählten Sprache.
	 * 
	 * @return String In übersetzter Sprache
	 */	
	public String getLocalString(String label) {
		try {
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
		} catch (MissingResourceException e) {
			statics.debug.errorMessage("Local", e.getMessage());
			return null;
		}
	}
}
