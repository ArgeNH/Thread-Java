package runner;

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

        ManagementPerson mng = new ManagementPerson("Uno",People.sortName,0,11);
        ManagementPerson mngTwo = new ManagementPerson("Dos",People.sortName,12,22);
        ManagementPerson mngThree = new ManagementPerson("Tres",People.sortName,23,33);
        ManagementPerson mngFour = new ManagementPerson("Cuatro",People.sortName,34,44);
        ManagementPerson mngFive = new ManagementPerson("Cinco",People.sortName,45,55);
        mng.pullJson();
        mngTwo.pullJson();
        mngThree.pullJson();
        mngFour.pullJson();
        mngFive.pullJson();

        Thread thOne = new Thread(mng);
        Thread thTwo = new Thread(mngTwo);
        Thread thThree = new Thread(mngThree);
        Thread thFour = new Thread(mngFour);
        Thread thFive = new Thread(mngFive);

        thOne.start();
        thTwo.start();
        thThree.start();
        thFour.start();
        thFive.start();

        try {
            thOne.join();
            thTwo.join();
            thThree.join();
            thFour.join();
            thFive.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();

        Duration duration = Duration.between(begin, end);
        System.out.println("Tiempo -->" + duration.getSeconds());

      /*
        Opción para dividir con un list

        int pos = 0;
        int end1 = 0;

         ArrayList<People> peoples = mng.getPersons();

        List<People> primer = peoples.subList(0, peoples.size()/3);
        List<People> segundo = peoples.subList((peoples.size()/3),peoples.size()/2);
        List<People> tercer = peoples.subList(peoples.size()/2,peoples.size()-1);

        pos =primer.size();
        end1 = segundo.size();*/
    }
}
