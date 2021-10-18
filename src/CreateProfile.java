import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class CreateProfile {

    public static ArrayList<String> readFirstName(String file) throws IOException {
        ArrayList<String> firstNames = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while (line != null) {
            firstNames.add(line);
            line = bufferedReader.readLine();
        }
        return firstNames;
    }

    public static ArrayList<String> readLastName(String file) throws IOException {
        ArrayList<String> lastNames = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while (line != null) {
            lastNames.add(line);
            line = bufferedReader.readLine();
        }
        return lastNames;
    }

    public static ArrayList<String> createName(ArrayList<String> firstNames, ArrayList<String> lastNames) {
        ArrayList<String> names = new ArrayList<>();
        Random random = new Random();
        int size1 = firstNames.size();
        int size2 = lastNames.size();
        for (int i = 0; i < 100; i++) {
            int index1 = random.nextInt(size1);
            int index2 = random.nextInt(size2);
            String firstName = firstNames.get(index1);
            String lastName = lastNames.get(index2);
            String fullName = firstName + " " + lastName;
            names.add(fullName);
        }
        return names;
    }

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

    public static ArrayList<TestSubject> createProfile(ArrayList<String> names) {
        ArrayList<TestSubject> list = new ArrayList<>();
        ArrayList<String> dates = createDoB(names.size());
        for (int i = 0; i < names.size(); i++) {
            list.add(new TestSubject(names.get(i), dates.get(i)));
        }
        return list;
    }

    public static void write(ArrayList<TestSubject> list) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("TestSubjects.bin"));
        for (TestSubject testSubject : list) {
            outputStream.writeObject(testSubject);
            System.out.println(testSubject);
        }
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<TestSubject> list = createProfile(createName(readFirstName("fnames.txt"),readLastName("lnames.txt")));
        write(list);
    }
}
