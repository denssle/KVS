package statics;

import util.Local;

public class label {
	Local local = Local.getInstance();
	
	public String title = local.getLocalString("title");
	public String forname = local.getLocalString("forname");
	public String lastname = local.getLocalString("lastname");
	public String street = local.getLocalString("street");
	public String zip = local.getLocalString("zip");
	public String city = local.getLocalString("city");
	public String birthdate = local.getLocalString("birthdate");
	public String[] alluserlabels = {title, forname, lastname, street, zip, city, birthdate};
	
	public String lastvisit = local.getLocalString("lastvisit");
	public String firstvisit = local.getLocalString("firstvisit");
	public String deletenonefound = local.getLocalString("deletenonefound");
	public String deleteconfirmtitle = local.getLocalString("deleteconfirmtitle");
	public String deleteconfirmtext = local.getLocalString("deleteconfirmtext");
	public String createvalidationfailed = local.getLocalString("createvalidationfailed");
	public String updatenonefound = local.getLocalString("updatenonefound");
	public String searchnonefound = local.getLocalString("searchnonefound");
	public String searchplaceholder = local.getLocalString("searchplaceholder");
	public String searchdescription = local.getLocalString("searchdescription");
	public String ok = local.getLocalString("ok");
	public String clients = local.getLocalString("clients");
	public String lastmessages = local.getLocalString("lastmessages");
	public String createnewclient = local.getLocalString("createnewclient");
	public String searchclient = local.getLocalString("searchclient");
	public String quit = local.getLocalString("quit");
	public String edit = local.getLocalString("edit");
	public String editclient = local.getLocalString("editclient");
	public String delete = local.getLocalString("delete");
	public String deleteclient = local.getLocalString("deleteclient");
	public String cancel = local.getLocalString("cancel");
	public String showclient = local.getLocalString("showclient");
	public String language = local.getLocalString("language");
	public String german = local.getLocalString("german");
	public String english = local.getLocalString("english");
	public String turkish = local.getLocalString("turkish");
}
