import java.io.Serializable;

public class TestSubject implements Serializable {

    private String name;
    private String DoB;

    public TestSubject(String name, String DoB) {
        this.name = name;
        this.DoB = DoB;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getName() {
        return name;
    }

    public String getDoB() {
        return DoB;
    }

    @Override
    public String toString() {
        return "TestSubject{" +
                "name='" + name + '\'' +
                ", DoB='" + DoB + '\'' +
                '}';
    }
}
