package logic;

import org.w3c.dom.ls.LSInput;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ManagementPerson implements Runnable {

    private ArrayList<People> persons;
    private Comparator<People> comparator;
    private String name;
    private FilePerson file;
    private int pos = 0;
    private int end = 0;

    public ManagementPerson() {
    }

    public ManagementPerson(String name, Comparator<People> comparator, int pos, int end) {
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
        ArrayList<People> clonPeoples = sortPeople(comparator);
        //.out.println("posición " + pos);
        //System.out.println("final " + end);
        int cont=0;
        System.out.println("Ordenando hilo "+this.name);
        for (int i = pos; i < end; i++) {
            Thread.sleep(new Random().nextInt(501) + 500);
            System.out.println("Ejecución del hilo " + this.name + " --> " + sortPeople(comparator).get(i).toString());
            cont++;
        }
        System.out.println("Fin de ejecucion del hilo " + this.name);
        System.out.println("iteraciones "+cont);
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
