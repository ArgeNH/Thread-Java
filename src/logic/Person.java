package logic;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Person implements Runnable {

    private ArrayList<People> persons;
    private Comparator<People> comparator;
    private String name;
    private FilePerson file;
    private int pos = 0;
    private int end = 0;

    public Person() {
    }

    public Person(String name, Comparator<People> comparator, int pos, int end) {
        this.comparator = comparator;
        this.name = name;
        persons = new ArrayList<>();
        file = new FilePerson();
        this.pos = pos;
        this.end = end;
        file.setPathName("resources/files/");
        file.setNameFile("people.json");
        file.openFile();
    }

    public People findPerson(String id) {
        for (People people : persons) {
            if (people.getId().equals(people)) {
                return people;
            }
        }
        return null;
    }

    public boolean addPerson(String id, String name, String lastName, int age) {
        if (findPerson(id) == null) {
            persons.add(new People(id, name, lastName, age));
            return true;
        }
        return false;
    }

    public void PushJson() throws IOException {
        file = new FilePerson();
        file.setPathName("resources/files/");
        file.setNameFile("people.json");
        file.openFile();
        file.pushJson(persons);
    }

    public void pullJson() throws IOException {
        file = new FilePerson();
        file.setPathName("resources/files/");
        file.setNameFile("people.json");
        file.openFile();
        persons = file.pullJson();
    }

    public void options(Comparator<People> comparator, int pos, int end) throws InterruptedException {

        Instant begin = Instant.now();

        System.out.println("Ordenando hilo "+this.name);
        for (int i = pos; i < end; i++) {
            Thread.sleep(new Random().nextInt(501) + 500);
            System.out.println("Ejecución del hilo " + this.name + " --> " + sortPeople(comparator).get(i).toString());
        }
        System.out.println("Fin de ejecucion del hilo " + this.name);

        Instant ended = Instant.now();

        Duration duration = Duration.between(begin, ended);
        System.out.println("Tiempo hilo "+this.name+" --> " + duration.getSeconds());
    }

    public ArrayList<People> sortPeople(Comparator<People> comparator) {
        ArrayList<People> clonPeoples = (ArrayList<People>) persons.clone();
        Collections.sort(clonPeoples, comparator);
        return clonPeoples;
    }

    public ArrayList<People> getPersons() {
        return (ArrayList<People>) persons.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            options(comparator, pos, end);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
