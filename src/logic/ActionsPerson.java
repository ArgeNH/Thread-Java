package logic;

import control.ControlPerson;

public interface ActionsPerson {

    String SORT_ID = "Ordenar por id";
    String SORT_NAME = "Ordenar por nombre";
    String SORT_LAST_NAME= "Ordenar por Apellido";
    String SORT_AGE= "Ordenar por edad";

    void exit();
    void begin();
    String[] readInput(String option);
    void writeOutput(String option, String[] output, boolean state);
    void setControl(ControlPerson control);

}
