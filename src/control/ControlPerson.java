package control;

import logic.ActionsPerson;
import logic.Person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPerson implements ActionListener {

    private ActionsPerson view;
    private Person mng;

    public ControlPerson(ActionsPerson view) throws IOException {
        this.view = view;

        mng.pullJson();
        mng.PushJson();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
