package logic;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Comparator;

public class ManagementPerson {

    private ArrayList<People> persons;
    private Comparator<People> comparator;
    private FilePerson file;

    public ManagementPerson(Comparator<People> comp) {
        comparator = comp;
        persons = new ArrayList<>();
        file = new FilePerson();
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

    public ArrayList<People> sortPeople(Comparator<People> comparator) {
        ArrayList<People> clonPeoples = (ArrayList<People>) persons.clone();
        Collections.sort(clonPeoples, comparator);
        return clonPeoples;
    }

    public ArrayList<People> getPersons() {
        return (ArrayList<People>) persons.clone();
    }
}
