import java.io.Serializable;

/**
 * Class: TestSubject
 * @author Nan Zhou
 * @version 1.0
 * Description: this class holds all attributes of a test subject that will be used to create passwords
 */

public class TestSubject implements Serializable {

    private String name;
    private String DoB;

    /**
     * Default constructor
     * @param name
     * @param DoB
     */
    public TestSubject(String name, String DoB) {
        this.name = name;
        this.DoB = DoB;
    }

    /**
     * Setter method for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for date of birth
     * @param doB
     */
    public void setDoB(String doB) {
        DoB = doB;
    }

    /**
     * Getter method for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for date of birth
     * @return
     */
    public String getDoB() {
        return DoB;
    }

    /**
     * Custom toString method for test subjects
     * @return String of TestSubject
     */
    @Override
    public String toString() {
        return "TestSubject{" +
                "name='" + name + '\'' +
                ", DoB='" + DoB + '\'' +
                '}';
    }
}
