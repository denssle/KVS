package statics;

import util.Local;

public class label {
	static Local local = Local.getInstance();
	/* Menu Labels */
	public static String ok = local.getLocalString("ok");
	public static String clients = "Klienten";
	public static String messages = local.getLocalString("lastmessages");
	public static String newClient = local.getLocalString("createnewclient");
	public static String searchClient = local.getLocalString("searchclient");
	public static String quit = local.getLocalString("quit");
	public static String update = local.getLocalString("edit");
	public static String updateClient = local.getLocalString("editclient");
	public static String delete = local.getLocalString("delete");
	public static String deleteClient = local.getLocalString("deleteclient");
	public static String cancel = local.getLocalString("cancel");
	public static String titel = "KVS";
	public static String showClient = local.getLocalString("showclient");
	public static String language = local.getLocalString("language");
	public static String german = local.getLocalString("german");
	public static String english = local.getLocalString("english");
}

