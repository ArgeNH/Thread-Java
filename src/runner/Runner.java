package runner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import logic.FilePerson;
import logic.ManagementPerson;
import logic.People;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String... args) throws IOException {

        Instant begin = Instant.now();

        ManagementPerson mng = new ManagementPerson("Nombres", 1);
        mng.pullJson();
        ArrayList<People> peoples = mng.getPersons();

        List<People> primer = peoples.subList(0, peoples.size()/3);
        List<People> segundo = peoples.subList((peoples.size()/3),peoples.size()/2);
        List<People> tercer = peoples.subList(peoples.size()/2,peoples.size()-1);
        System.out.println(primer+"\n"+segundo+"\n"+tercer);



       /* mng.pullJson();
        try {
            mng.options(1);
            mng.options(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*ManagementPerson mng = new ManagementPerson("Hilo uno",1);
        ManagementPerson mngTwo = new ManagementPerson("Hilo dos",4);
        Thread thOne = new Thread(mng);
        Thread thTwo = new Thread(mngTwo);

        mng.pullJson();
        mngTwo.pullJson();

       thOne.start();
       thTwo.start();

        try {
            thOne.join();
            thTwo.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Instant end = Instant.now();

        Duration duration = Duration.between(begin, end);
        System.out.println("Tiempo -->" + duration.getSeconds());

    }
}
