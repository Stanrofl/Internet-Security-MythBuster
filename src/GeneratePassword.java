import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class: GeneratePassword
 * @author Nan Zhou
 * @version 1.0
 * Description: this program reads in a binary file of TestSubject objects and use their attributes to generate passwords
 */

public class GeneratePassword {

    private static ArrayList<String> passwords = new ArrayList<>();
    private static ArrayList<TestSubject> list = new ArrayList<>();

    /**
     * Reads in a binary file containing TestSubject objects
     * @param file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readTestSubjects(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        try {
            TestSubject testSubject = (TestSubject) inputStream.readObject();
            while (testSubject != null) {
                list.add(testSubject);
                testSubject = (TestSubject) inputStream.readObject();
            }
        } catch (EOFException ignored) {
        }
        inputStream.close();
    }

    /**
     * Generate passwords based on rule input
     */
    public static void createPasswords(int rule) {
        switch (rule) {
            case 1 -> initialsDoBRule();
            case 2 -> cityRule();
            case 3 -> petRule();
            case 4 -> teamRule();
            case 5 -> movieRule();
            case 6 -> characterRule();
        }
    }

    /**
     * Generate passwords by combining initials of names and date of birth
     */
    public static void initialsDoBRule() {
        for (TestSubject testSubject : list) {
            String name = testSubject.getName();
            String[] split = name.split(" ");
            String firstName = split[0];
            String lastName = split[1];
            String initials = "" + firstName.charAt(0) + lastName.charAt(0);
            String doB = testSubject.getDoB();
            String date = doB.replaceAll("/","");
            String password = initials + date;
            passwords.add(password);
        }
    }

    /**
     * Generate passwords by combining city with a random number
     */
    public static void cityRule() {
        Random random = new Random();
        for (TestSubject testSubject : list) {
            String city = testSubject.getCity();
            String number = String.valueOf(random.nextInt(10000));
            String password = city + number;
            passwords.add(password);
        }
    }

    /**
     * Generate passwords by combining pet name with a random number
     */
    public static void petRule() {
        Random random = new Random();
        for (TestSubject testSubject : list) {
            String pet = testSubject.getPetName();
            String number = String.valueOf(random.nextInt(10000));
            String password = pet + number;
            passwords.add(password);
        }
    }

    /**
     * Generate passwords by combining team name with a random number
     */
    public static void teamRule() {
        Random random = new Random();
        for (TestSubject testSubject : list) {
            String team = testSubject.getTeam();
            String number = String.valueOf(random.nextInt(10000));
            String password = team + number;
            passwords.add(password);
        }
    }

    /**
     * Generate passwords by combining movie name with a random number
     */
    public static void movieRule() {
        Random random = new Random();
        for (TestSubject testSubject : list) {
            String movie = testSubject.getMovie();
            String number = String.valueOf(random.nextInt(10000));
            String password = movie + number;
            passwords.add(password);
        }
    }

    /**
     * Generate passwords by combining character name with a random number
     */
    public static void characterRule() {
        Random random = new Random();
        for (TestSubject testSubject : list) {
            String character = testSubject.getCharacter();
            String number = String.valueOf(random.nextInt(10000));
            String password = character + number;
            passwords.add(password);
        }
    }

    /**
     * Takes in an ArrayList of passwords and write to a text file
     * @throws IOException
     */
    public static void write() throws IOException {
        PrintWriter printWriter = new PrintWriter("TestSubjectPasswords.txt");
        for (String password : passwords) {
            printWriter.println(password);
        }
        printWriter.close();
    }

    /**
     * Main method - starting point of program
     * @param args
     */
    public static void main(String[] args) {
        try {
            readTestSubjects("TestSubjects.bin");
            createPasswords(1);
            createPasswords(2);
            createPasswords(3);
            createPasswords(4);
            createPasswords(5);
            createPasswords(6);
            write();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
