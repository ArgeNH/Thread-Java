package runner;

import logic.Person;
import logic.People;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Runner {

    public static void main(String... args) throws IOException {

        Instant begin = Instant.now();

        //varios hilos
       /*Person psOne = new Person("Uno",People.sortName,0,4);
        Person psTwo = new Person("Dos",People.sortName,5,9);
        Person psThree = new Person("Tres",People.sortName,10,14);
        Person psFour = new Person("Cuatro",People.sortName,15,19);
        Person psFive = new Person("Cinco",People.sortName,20,24);
        Person psSix = new Person("Seis",People.sortName,25,29);
        Person psSeven = new Person("Siete",People.sortName,30,34);
        Person psEight = new Person("Ocho",People.sortName,35,39);
        Person psNine = new Person("Nueve",People.sortName,40,44);
        Person psTen = new Person("Diez",People.sortName,45,49);
        Person psEleven = new Person("Once",People.sortName,50,55);

        Person psOne1 = new Person("Uno1",People.sortLastName,0,4);
        Person psTwo1 = new Person("Dos1",People.sortLastName,5,9);
        Person psThree1 = new Person("Tres1",People.sortLastName,10,14);
        Person psFour1 = new Person("Cuatro1",People.sortLastName,15,19);
        Person psFive1 = new Person("Cinco1",People.sortLastName,20,24);
        Person psSix1 = new Person("Seis1",People.sortLastName,25,29);
        Person psSeven1 = new Person("Siete1",People.sortLastName,30,34);
        Person psEight1 = new Person("Ocho1",People.sortLastName,35,39);
        Person psNine1 = new Person("Nueve1",People.sortLastName,40,44);
        Person psTen1 = new Person("Diez1",People.sortLastName,45,49);
        Person psEleven1 = new Person("Once1",People.sortLastName,50,55);

        psOne.pullJson();
        psTwo.pullJson();
        psThree.pullJson();
        psFour.pullJson();
        psFive.pullJson();
        psSix.pullJson();
        psSeven.pullJson();
        psEight.pullJson();
        psNine.pullJson();
        psTen.pullJson();
        psEleven.pullJson();

        psOne1.pullJson();
        psTwo1.pullJson();
        psThree1.pullJson();
        psFour1.pullJson();
        psFive1.pullJson();
        psSix1.pullJson();
        psSeven1.pullJson();
        psEight1.pullJson();
        psNine1.pullJson();
        psTen1.pullJson();
        psEleven1.pullJson();

        Thread thOne = new Thread(psOne);
        Thread thTwo = new Thread(psTwo);
        Thread thThree = new Thread(psThree);
        Thread thFour = new Thread(psFour);
        Thread thFive = new Thread(psFive);
        Thread thSix = new Thread(psSix);
        Thread thSeven = new Thread(psSeven);
        Thread thEight = new Thread(psEight);
        Thread thNine = new Thread(psNine);
        Thread thTen = new Thread(psTen);
        Thread thEleven = new Thread(psTen);

        Thread thOne1 = new Thread(psOne1);
        Thread thTwo1 = new Thread(psTwo1);
        Thread thThree1 = new Thread(psThree1);
        Thread thFour1 = new Thread(psFour1);
        Thread thFive1 = new Thread(psFive1);
        Thread thSix1 = new Thread(psSix1);
        Thread thSeven1 = new Thread(psSeven1);
        Thread thEight1 = new Thread(psEight1);
        Thread thNine1 = new Thread(psNine1);
        Thread thTen1 = new Thread(psTen1);
        Thread thEleven1 = new Thread(psTen1);

        thOne.start();
        thTwo.start();
        thThree.start();
        thFour.start();
        thFive.start();
        thSix.start();
        thSeven.start();
        thEight.start();
        thNine.start();
        thTen.start();
        thEleven.start();

        thOne1.start();
        thTwo1.start();
        thThree1.start();
        thFour1.start();
        thFive1.start();
        thSix1.start();
        thSeven1.start();
        thEight1.start();
        thNine1.start();
        thTen1.start();
        thEleven1.start();

        try {
            thOne.join();
            thTwo.join();
            thThree.join();
            thFour.join();
            thFive.join();
            thSix.join();
            thSeven.join();
            thEight.join();
            thNine.join();
            thTen.join();
            thEleven.join();

            thOne1.join();
            thTwo1.join();
            thThree1.join();
            thFour1.join();
            thFive1.join();
            thSix1.join();
            thSeven1.join();
            thEight1.join();
            thNine1.join();
            thTen1.join();
            thEleven1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        //version 1 solo hilo
        Person psOne = new Person("Uno", People.sortName,0,55);

        psOne.pullJson();

        Thread thOne = new Thread(psOne);

        thOne.start();

        try {
            thOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Paralelismo de tareas
       /* Person psOne = new Person("Ordenamiendo por Id", People.sortId,0,55);
        Person psTwo = new Person("Ordenamiendo por Name", People.sortName,0,55);
        Person psThree = new Person("Ordenamiendo por Lastname", People.sortLastName,0,55);
        Person psFour = new Person("Ordenamiendo por Age", People.sortAge,0,55);

        psOne.pullJson();
        psTwo.pullJson();
        psThree.pullJson();
        psFour.pullJson();

        Thread thOne = new Thread(psOne);
        Thread thTwo = new Thread(psTwo);
        Thread thThree = new Thread(psThree);
        Thread thFour = new Thread(psFour);

        thOne.start();
        thTwo.start();
        thThree.start();
        thFour.start();

        try {
            thOne.join();
            thTwo.join();
            thThree.join();
            thFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        //Paralelismo de datos
      /*Person psOne = new Person("Uno",People.sortName,0,11);
        Person psTwo = new Person("Dos",People.sortName,12,22);
        Person psThree = new Person("Tres",People.sortName,23,33);
        Person psFour = new Person("Cuatro",People.sortName,34,44);
        Person psFive = new Person("Cinco",People.sortName,45,55);

        psOne.pullJson();
        psTwo.pullJson();
        psThree.pullJson();
        psFour.pullJson();
        psFive.pullJson();

        Thread thOne = new Thread(psOne);
        Thread thTwo = new Thread(psTwo);
        Thread thThree = new Thread(psThree);
        Thread thFour = new Thread(psFour);
        Thread thFive = new Thread(psFive);

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
        }*/

        Instant end = Instant.now();

        Duration duration = Duration.between(begin, end);
        System.out.println("");
        System.out.println("| Tiempo final de ejecución --> " + duration.getSeconds()+"s |");


      /*  Opción para dividir con un list

        int pos = 0;
        int end1 = 0;

         ArrayList<People> peoples = psOne.getPersons();

        List<People> primer = peoples.subList(0, peoples.size()/3);
        List<People> segundo = peoples.subList((peoples.size()/3),peoples.size()/2);
        List<People> tercer = peoples.subList(peoples.size()/2,peoples.size()-1);

        pos =primer.size();
        end1 = segundo.size();*/
    }
}
