package logic;

import java.util.Collections;

import java.util.ArrayList;
import java.util.Comparator;

public class ManagementPerson {

    private ArrayList<People> persons;

    public ManagementPerson() {
        persons = new ArrayList<>();
    }

    public ArrayList<People> sortPeople(Comparator<People> comparator){
        ArrayList<People> clonPeoples= (ArrayList<People>) persons.clone();
        Collections.sort(clonPeoples,comparator);
        return clonPeoples;
    }

    public ArrayList<People> getPersons() {
        return (ArrayList<People>) persons.clone();
    }
}
