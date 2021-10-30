import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class: GeneratePassword
 * @author Nan Zhou
 * @version 1.0
 * Description: this program reads in a binary file of TestSubject objects and use their attributes to generate passwords
 */

public class GeneratePassword {

    /**
     * Reads in a binary file containing TestSubject objects
     * @param file
     * @return ArrayList of TestSubjects
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<TestSubject> readTestSubjects(String file) throws IOException, ClassNotFoundException {
        ArrayList<TestSubject> list = new ArrayList<>();
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
        return list;
    }

    /**
     * Takes an ArrayList of TestSubjects and use their attributes to create passwords
     * @param list
     * @return ArrayList of passwords
     */
    public static ArrayList<String> createPasswords(ArrayList<TestSubject> list) {
        ArrayList<String> passwords = new ArrayList<>();
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
        return passwords;
    }

    /**
     * Takes in an ArrayList of passwords and write to a text file
     * @param passwords
     * @throws IOException
     */
    public static void write(ArrayList<String> passwords) throws IOException {
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
            ArrayList<String> pwd = createPasswords(readTestSubjects("TestSubjects.bin"));
            write(pwd);
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
