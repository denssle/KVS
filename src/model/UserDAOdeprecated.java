package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("serial")
public class UserDAOdeprecated implements Serializable {
	private String path;
	private File userFile;
	private Map<UUID, User> allUsersMap;
	
	public UserDAOdeprecated() {
		path = statics.label.path;
		userFile = new File(path);
		allUsersMap = readUserOutFromSaveFile();
		checkSaveFile();
	}

	@SuppressWarnings("unchecked")
	private Map<UUID, User> readUserOutFromSaveFile() {
		checkSaveFile();
		
		Map<UUID, User> readOutMap= new HashMap<UUID, User>();
		FileInputStream fs;
		ObjectInputStream is;
		
		try {
			statics.debug.debugMessage("DB", "Beginne Lesevorgang. ");
			fs = new FileInputStream(path);
			is = new ObjectInputStream(fs);
			statics.debug.debugMessage("DB", "FileInput und ObjectInput melden Bereitschaft. ");
			readOutMap = (Map<UUID, User>) is.readObject();
			statics.debug.debugMessage("DB", "Lesevorgang abgeschlossen. \nBenutzerdaten wurden geladen. \nFileInput und ObjectInput werden geschlossen. \nLesevorgang beendet.\n");
			is.close();
			fs.close();
		} catch(EOFException e) {
			e.toString();
			readOutMap = new HashMap<UUID, User>();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		statics.debug.debugMessage("DB", readOutMap.size()+" User wurden geladen. ");
		return readOutMap;
	}
	
	public boolean saveUser(User newUser) {
		checkSaveFile();
		allUsersMap.put(newUser.getId(), newUser);
		saveFile();
		return true;
	}
	
	private boolean saveFile() {
		try {
			statics.debug.debugMessage("DB", "Beginne Speichervorgang. \nEverything not saved will be lost.");
			FileOutputStream fs = new FileOutputStream(path);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			statics.debug.debugMessage("DB", "Datei wird beschrieben.");
			os.writeObject(allUsersMap);
			statics.debug.debugMessage("DB", "os wird geschlossen!");
			os.close();
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private void checkSaveFile() {
		statics.debug.debugMessage("DB", "Benutzerspeichervalidierung gestartet!");
		
		if(!userFile.exists()) {
			statics.debug.debugMessage("DB", "Datei nicht vorhanden.");
			createNewFile();
        }
		else {
			statics.debug.debugMessage("DB", "Datei gefunden.");
		}
		checkDataRights();
		statics.debug.debugMessage("DB", "Benutzerspeichervalidierung abgeschlossen!\n");
	}
	private void checkDataRights() {
		if(userFile.canRead()) {
			statics.debug.debugMessage("DB", "Leserechte vorhanden. ");
		}
		else {
			statics.debug.debugMessage("DB", "Leserechte nicht vorhanden. .");
		}
		
		if(userFile.canWrite()) {
			statics.debug.debugMessage("DB", "Schreibrechte gegeben. ");
		}
		else {
			statics.debug.debugMessage("DB", "Schreibrechte nicht gegeben. ");
		}
		
		if(userFile.canExecute()) {
			statics.debug.debugMessage("DB", "Datei exekutierbar.");
		} else {
			statics.debug.debugMessage("DB", "Datei nicht exekutierbar.");
		}
	}

	private void createNewFile() {
		try {
            if(userFile.createNewFile()) {
            	statics.debug.debugMessage("DB", "Neue Datei erstellt.");
            } else {
            	statics.debug.debugMessage("DB", "Datei konnte nicht erstellt werden!");
            }
        } catch (IOException ex) {
        	statics.debug.debugMessage("DB", "Fehler beim erstellen von neuer Datei. ");
            ex.printStackTrace();
        }
	}
	
	public Map<UUID, User> getAllUsers() {
		return allUsersMap;
	}

	public void deleteUser(User user) {
		if(allUsersMap.containsValue(user)){
			allUsersMap.remove(user.getId());
			saveFile();
		}
	}
}

