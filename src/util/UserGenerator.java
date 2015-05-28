package util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import model.User;
import dao.UserDAO;


public class UserGenerator {

	private static String[] GIVEN_NAMES = {"Inge", "Rolf", "Martina", "Wolfgang", "Walter", "Frank", "Hans", "J�rg", "Andreas", "Wilhelm", "Horst", "Josef", "G�nter", "Marianne", "Sabine", "Christine", "Marion", "Thomas", "Willi", "Gertrud", "Matthias", "Joachim", "Ute", "Anna", "Norbert", "Barbara", "Brigitte", "Edith", "Ingeborg", "Sandra", "Ulrike", "Irmgard", "Hermann", "Birgit", "Christa", "Stefan", "Claudia", "Bernhard", "Gisela", "Kerstin", "Markus", "Gabriele", "Ingrid", "Petra", "Susanne", "Heinrich", "Bernd", "Heinz", "Elke", "Klaus", "Erich", "Heike", "Anja", "Elfriede", "Waltraud", "Johann", "Hildegard", "Renate", "Andrea", "Georg", "Rainer", "Monika", "Martin", "Ursula", "Uwe", "Manfred", "Rudolf", "Herbert", "Anneliese", "Christian", "Dieter", "Hannelore", "Doris", "Helmut", "Ulrich", "Karl", "Peter", "Siegfried", "Gerhard", "Alexander", "Beate", "J�rgen", "Michael", "Erika", "Karl-Heinz", "Maria", "Ruth", "Margarete", "Ilse", "Ralf", "Gerda", "Kurt", "Elisabeth", "Franz", "Helga", "Angelika", "Jutta", "Werner", "Alfred", "Karin"};
	private static String[] FAMILY_NAMES = {"M�ller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Schulz", "Hoffmann", "Sch�fer", "Bauer", "Koch", "Richter", "Klein", "Wolf", "Schr�der", "Neumann", "Schwarz", "Braun", "Hofmann", "Zimmermann", "Schmitt", "Hartmann", "Kr�ger", "Schmid", "Werner", "Lange", "Schmitz", "Meier", "Krause", "Maier", "Lehmann", "Huber", "Mayer", "Herrmann", "K�hler", "Walter", "K�nig", "Schulze", "Fuchs", "Kaiser", "Lang", "Wei�", "Peters", "Scholz", "Jung", "M�ller", "Hahn", "Keller"};
	private static String[] STREET_NAMES = {"Hauptstra�e", "Dorfstra�e", "Schulstra�e", "Bahnhofstra�e", "Gartenstra�e", "Bergstra�e", "Lindenstra�e", "Birkenweg", "Waldstra�e", "Kirchstra�e", "Ringstra�e", "Wiesenweg", "Schillerstra�e", "Goethestra�e", "M�hlenweg", "Amselweg", "Feldstra�e", "Wiesenstra�e", "Jahnstra�e", "Am Sportplatz", "Buchenweg", "Friedhofstra�e", "Eichenweg", "Finkenweg", "Ahornweg", "M�hlenstra�e", "Rosenstra�e", "Talstra�e", "Erlenweg", "Blumenstra�e", "Brunnenstra�e", "Kirchweg", "Lindenweg", "Raiffeisenstra�e", "Bachstra�e", "Industriestra�e", "Tannenweg", "Mittelstra�e", "Gartenweg", "Rosenweg", "Mozartstra�e", "Am Bahnhof", "Lerchenweg", "Waldweg", "Drosselweg", "Poststra�e", "Schlossstra�e", "Neue Stra�e", "M�hlweg", "Kirchplatz"};
	private static String[] CITY_NAMES = {"Berlin", "Hamburg", "M�nchen", "K�ln", "Frankfurt(Main)", "Stuttgart", "D�sseldorf", "Dortmund", "Essen", "Bremen", "Dresden", "Leipzig", "Hannover", "N�rnberg", "Duisburg", "Bochum", "Wuppertal", "Bonn", "Bielefeld", "Mannheim", "Karlsruhe", "M�nster", "Wiesbaden", "Augsburg", "Aachen", "M�nchengladbach", "Gelsenkirchen", "Braunschweig", "Chemnitz", "Kiel", "Krefeld", "Halle(Saale)", "Magdeburg", "Freiburg im Breisgau", "Oberhausen", "L�beck", "Erfurt", "Rostock", "Mainz", "Kassel", "Hagen", "Hamm", "Saarbr�cken", "M�lheim an der Ruhr", "Herne", "Ludwigshafen am Rhein", "Osnabr�ck", "Oldenburg", "Leverkusen", "Solingen"};
	
	
	private static Random rnd = new Random();
	
	public static void main(String[] args){
		for(User u: getRandomLocalUsers(40)) {
			UserDAO.getInstance().addUser(u);
		}
	}

	private static String getRandom(String[] names) {
		return names[rnd.nextInt(names.length)];
	}
	
	private static Date getRandomBirthdate() {
		GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1946, 1996);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return gc.getTime();
	}
	
    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    
    public static List<User> getRandomLocalUsers(int count) {
    	List<User> users = new ArrayList<User>();
		for(int i = 0; i < count; i++) {
			User user = new User(UUID.randomUUID(),getRandom(GIVEN_NAMES),getRandom(FAMILY_NAMES),getRandomBirthdate(),getRandom(STREET_NAMES)+" "+randBetween(1,199),String.format("%05d", randBetween(100,99999)),getRandom(CITY_NAMES));
			statics.debug.debugMessage("CreateTestUser", user.toString());
			users.add(user);
		}
		return users;
    }
}
