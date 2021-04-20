package runner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import logic.ManagementPerson;
import logic.People;

import java.util.ArrayList;

public class Runner {


    private ManagementPerson mngId;
    private ArrayList<People> peoples;

    public Runner(){
        mngId = new ManagementPerson(People.sortId);
    }

    public static void main(String... args) {

        ManagementPerson mng = new ManagementPerson(People.sortId);


       System.out.println(mng.getPersons().toString());

    }

    private void begin() {

        Gson pretty = new GsonBuilder().setPrettyPrinting().create();


    }
}
