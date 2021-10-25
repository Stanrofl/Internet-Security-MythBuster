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
    private String petName;
    private String movie;
    private String character;
    private String city;
    private String team;

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
     * All-arg constructor
     * @param name
     * @param DoB
     * @param petName
     * @param movie
     * @param character
     * @param city
     * @param team
     */
    public TestSubject(String name, String DoB, String petName, String movie, String character, String city, String team) {
        this.name = name;
        this.DoB = DoB;
        this.petName = petName;
        this.movie = movie;
        this.character = character;
        this.city = city;
        this.team = team;
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
     * Setter method for character
     * @param character
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * Setter method for city
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Setter method for movie
     * @param movie
     */
    public void setMovie(String movie) {
        this.movie = movie;
    }

    /**
     * Setter method for pet name
     * @param petName
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * Setter method for team
     * @param team
     */
    public void setTeam(String team) {
        this.team = team;
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
     * Getter method for character
     * @return character
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Getter method for city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter method for movie
     * @return movie
     */
    public String getMovie() {
        return movie;
    }

    /**
     * Getter method for pet name
     * @return pet name
     */
    public String getPetName() {
        return petName;
    }

    /**
     * Getter method for team
     * @return team
     */
    public String getTeam() {
        return team;
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
