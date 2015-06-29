package statics;

import util.Local;

public class label {
	static Local local = Local.getInstance();
	
	public static String title = local.getLocalString("title");
	public static String forname = local.getLocalString("forname");
	public static String lastname = local.getLocalString("lastname");
	public static String street = local.getLocalString("street");
	public static String zip = local.getLocalString("zip");
	public static String city = local.getLocalString("city");
	public static String birthdate = local.getLocalString("birthdate");
	public static String[] alluserlabels = local.getUserLabels();
	
	public static String lastvisit = local.getLocalString("lastvisit");
	public static String firstvisit = local.getLocalString("firstvisit");
	public static String deletenonefound = local.getLocalString("deletenonefound");
	public static String deleteconfirmtitle = local.getLocalString("deleteconfirmtitle");
	public static String deleteconfirmtext = local.getLocalString("deleteconfirmtext");
	public static String createvalidationfailed = local.getLocalString("createvalidationfailed");
	public static String updatenonefound = local.getLocalString("updatenonefound");
	public static String searchnonefound = local.getLocalString("searchnonefound");
	public static String searchplaceholder = local.getLocalString("searchplaceholder");
	public static String searchdescription = local.getLocalString("searchdescription");
	public static String ok = local.getLocalString("ok");
	public static String clients = local.getLocalString("clients");
	public static String lastmessages = local.getLocalString("lastmessages");
	public static String createnewclient = local.getLocalString("createnewclient");
	public static String searchclient = local.getLocalString("searchclient");
	public static String quit = local.getLocalString("quit");
	public static String edit = local.getLocalString("edit");
	public static String editclient = local.getLocalString("editclient");
	public static String delete = local.getLocalString("delete");
	public static String deleteclient = local.getLocalString("deleteclient");
	public static String cancel = local.getLocalString("cancel");
	public static String showclient = local.getLocalString("showclient");
	public static String language = local.getLocalString("language");
	public static String german = local.getLocalString("german");
	public static String english = local.getLocalString("english");
	public static String turkish = local.getLocalString("turkish");
	public static String yes = local.getLocalString("yes");
	public static String no = local.getLocalString("no");
	
	public void update() {
		Local local = Local.getInstance();
		
		title = local.getLocalString("title");
		forname = local.getLocalString("forname");
		lastname = local.getLocalString("lastname");
		street = local.getLocalString("street");
		zip = local.getLocalString("zip");
		city = local.getLocalString("city");
		birthdate = local.getLocalString("birthdate");
		alluserlabels = local.getUserLabels();
		
		lastvisit = local.getLocalString("lastvisit");
		firstvisit = local.getLocalString("firstvisit");
		deletenonefound = local.getLocalString("deletenonefound");
		deleteconfirmtitle = local.getLocalString("deleteconfirmtitle");
		deleteconfirmtext = local.getLocalString("deleteconfirmtext");
		createvalidationfailed = local.getLocalString("createvalidationfailed");
		updatenonefound = local.getLocalString("updatenonefound");
		searchnonefound = local.getLocalString("searchnonefound");
		searchplaceholder = local.getLocalString("searchplaceholder");
		searchdescription = local.getLocalString("searchdescription");
		ok = local.getLocalString("ok");
		clients = local.getLocalString("clients");
		lastmessages = local.getLocalString("lastmessages");
		createnewclient = local.getLocalString("createnewclient");
		searchclient = local.getLocalString("searchclient");
		quit = local.getLocalString("quit");
		edit = local.getLocalString("edit");
		editclient = local.getLocalString("editclient");
		delete = local.getLocalString("delete");
		deleteclient = local.getLocalString("deleteclient");
		cancel = local.getLocalString("cancel");
		showclient = local.getLocalString("showclient");
		language = local.getLocalString("language");
		german = local.getLocalString("german");
		english = local.getLocalString("english");
		turkish = local.getLocalString("turkish");
		yes = local.getLocalString("yes");
		no = local.getLocalString("no");
	}
}
