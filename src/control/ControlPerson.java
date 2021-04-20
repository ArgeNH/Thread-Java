package control;

import logic.ActionsPerson;
import logic.ManagementPerson;
import logic.People;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPerson implements ActionListener {

    private ActionsPerson view;
    private ManagementPerson mng;

    public ControlPerson (ActionsPerson view) throws IOException {
        this.view=view;
        mng = new ManagementPerson(People.sortId);
        mng.pullJson();
        persistence();
    }

    private void persistence() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        mng.PushJson();
                        System.out.println("Guardado en JS");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
