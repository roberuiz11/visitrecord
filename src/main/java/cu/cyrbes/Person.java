package cu.cyrbes;

public class Person{

    private String id;

    private String name;

    private String city;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            return ((Person) obj).getId().equals(id);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
