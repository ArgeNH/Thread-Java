package logic;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ManagementPerson implements Runnable {

    private ArrayList<People> persons;
    private String name;
    private FilePerson file;
    private int opt = 0;

    public ManagementPerson (){

    }

    public ManagementPerson(String name, int opt) {
        this.name=name;
        persons = new ArrayList<>();
        file = new FilePerson();
        this.opt = opt;
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

    public ArrayList<People> options(int opt) throws InterruptedException {
        ArrayList<People> clonPeoples = (ArrayList<People>) persons.clone();
        switch (opt) {
            case 1:
                for (int i = 0; i < clonPeoples.size(); i++) {
                    Thread.sleep(new Random().nextInt(501) + 500);
                    System.out.println(this.name+" "+sortPeople(People.sortName).get(i).getName());
                    System.out.println(this.name+" Terminó");
                }
                break;
            case 2:
                for (int i = 0; i < clonPeoples.size(); i++) {
                    Thread.sleep(new Random().nextInt(501) + 500);
                    System.out.println(this.name+" "+sortPeople(People.sortLastName).get(i).getLastName());
                    System.out.println(this.name+" Terminó");
                }
                break;
            case 3:
                for (int i = 0; i < clonPeoples.size(); i++) {
                    Thread.sleep(new Random().nextInt(501) + 500);
                    System.out.println(this.name+" "+sortPeople(People.sortId).get(i).getId());
                    System.out.println(this.name+" Terminó");
                }
                break;
            case 4:
                for (int i = 0; i < clonPeoples.size(); i++) {
                    Thread.sleep(new Random().nextInt(501) + 500);
                    System.out.println(this.name+" "+sortPeople(People.sortAge).get(i).getAge());
                }
                System.out.println(this.name+" Terminó");
                break;
            default:
        }
        return clonPeoples;
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
            options(opt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
