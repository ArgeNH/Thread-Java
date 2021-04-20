package logic;

import java.util.Comparator;

public class People {

    private String id;
    private String name;
    private String lastName;
    private int age;

   public static Comparator<People> sortId = new Comparator<People>() {
        @Override
        public int compare(People o1, People o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    public static Comparator<People> sortName = new Comparator<People>() {
        @Override
        public int compare(People o1, People o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<People> sortLastName = new Comparator<People>() {
        @Override
        public int compare(People o1, People o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    };

    public static Comparator<People> sortAge = new Comparator<People>() {
        @Override
        public int compare(People o1, People o2) {
            return o1.getAge() - o2.getAge();
        }
    };

    public People(){

    }


    public People(String id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
