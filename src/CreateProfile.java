import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class: CreateProfile
 * @author Nan Zhou
 * @version 1.0
 * Description: this program reads in a number of text files that contain personal information and creates TestSubject objects
 * that are then stored in an ArrayList. The output of this program is a binary file that contains the ArrayList with TestSubject objects.
 */

public class CreateProfile {

    private static final int NUMBER_OF_PROFILES = 100;

    /**
     * Reads a text file containing attributes and store them in an ArrayList of strings
     * @param file
     * @return an ArrayList of first names
     * @throws IOException
     */
    public static ArrayList<String> readFile(String file) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while (line != null) {
            arrayList.add(line);
            line = bufferedReader.readLine();
        }
        return arrayList;
    }

    /**
     * Reads in two ArrayLists, one containing first names and one containing last names,
     * one element is pulled randomly from each ArrayList and put together to create a full name
     * @param firstNames
     * @param lastNames
     * @return an ArrayList of full names
     */
    public static ArrayList<String> createName(ArrayList<String> firstNames, ArrayList<String> lastNames) {
        ArrayList<String> names = new ArrayList<>();
        Random random = new Random();
        int size1 = firstNames.size();
        int size2 = lastNames.size();
        for (int i = 0; i < NUMBER_OF_PROFILES; i++) {
            int index1 = random.nextInt(size1);
            int index2 = random.nextInt(size2);
            String firstName = firstNames.get(index1);
            String lastName = lastNames.get(index2);
            String fullName = firstName + " " + lastName;
            names.add(fullName);
        }
        return names;
    }

    /**
     * Randomly generates dates between 1970/01/01 and 2000/12/31
     * @param n
     * @return an ArrayList of dates
     */
    public static ArrayList<String> createDoB(int n) {
        ArrayList<String> dates = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int year = random.nextInt(31) + 1970;
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(28) + 1;
            String date = year + "/" + month + "/" + day;
            dates.add(date);
        }
        return dates;
    }

    /**
     * Create TestSubject objects using full names and DoB
     * @param names
     * @return an ArrayList of TestSubjects
     */
    public static ArrayList<TestSubject> createProfile(ArrayList<String> names) {
        ArrayList<TestSubject> list = new ArrayList<>();
        ArrayList<String> dates = createDoB(names.size());
        for (int i = 0; i < names.size(); i++) {
            list.add(new TestSubject(names.get(i), dates.get(i)));
        }
        return list;
    }

    /**
     * Add attributes to test subjects in an ArrayList by specifying the attribute
     * @param testSubjects
     * @param attribute
     * @param attributes
     */
    public static void addAttribute(ArrayList<TestSubject> testSubjects,String attribute,ArrayList<String> attributes) {
        Random random = new Random();
        switch (attribute) {
            case "city":
                for (TestSubject testSubject : testSubjects) {
                    int index = random.nextInt(attributes.size());
                    testSubject.setCity(attributes.get(index));
                }
                break;
            case "movie":
                for (TestSubject testSubject : testSubjects) {
                    int index = random.nextInt(testSubjects.size());
                    testSubject.setMovie(attributes.get(index));
                }
                break;
            case "fictional_name":
                for (TestSubject testSubject : testSubjects) {
                    int index = random.nextInt(testSubjects.size());
                    testSubject.setCharacter(attributes.get(index));
                }
                break;
            case "pet_name":
                for (TestSubject testSubject : testSubjects) {
                    int index = random.nextInt(testSubjects.size());
                    testSubject.setPetName(attributes.get(index));
                }
                break;
            case "sports_team":
                for (TestSubject testSubject : testSubjects) {
                    int index = random.nextInt(testSubjects.size());
                    testSubject.setTeam(attributes.get(index));
                }
                break;
        }
    }

    /**
     * Reads in an ArrayList of TestSubjects and write to a binary file
     * @param list
     * @throws IOException
     */
    public static void write(ArrayList<TestSubject> list) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("TestSubjects.bin"));
        for (TestSubject testSubject : list) {
            outputStream.writeObject(testSubject);
            System.out.println(testSubject);
        }
        outputStream.close();
    }

    /**
     * Main method - starting point of program
     * @param args
     */
    public static void main(String[] args) {
        try {
            ArrayList<String> firstNames = readFile("first_name.txt");
            ArrayList<String> lastNames = readFile("last_name.txt");
            ArrayList<String> movies = readFile("movie.txt");
            ArrayList<String> fictionalNames = readFile("fictional_name.txt");
            ArrayList<String> sportsTeams = readFile("sports_team.txt");
            ArrayList<String> petNames = readFile("pet_name.txt");
            ArrayList<String> cities = readFile("city.txt");
            ArrayList<TestSubject> list = createProfile(createName(firstNames,lastNames));
            addAttribute(list,"city",cities);
            write(list);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
