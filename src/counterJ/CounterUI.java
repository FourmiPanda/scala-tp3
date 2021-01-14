package counterJ;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class CounterUI extends JFrame implements Observer {
    JLabel label;
    JButton buttonPlus;
    JButton buttonMinus;
    Counter counter;

    public CounterUI(final Counter counter) {
        super(counter.name);
        this.counter = counter;
        label = new JLabel(Integer.toString(counter.getCount()));

        buttonPlus = new JButton("+");
        buttonPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter.increment();
            }
        });
        buttonMinus = new JButton("-");
        buttonMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter.decrement();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        label.setText(arg.toString());
    }

    public void addComponentsToPane() {
        Container pane = getContentPane();
        pane.add(buttonPlus, BorderLayout.NORTH);
        pane.add(label, BorderLayout.CENTER);
        pane.add(buttonMinus, BorderLayout.SOUTH);
    }
    private static void createAndShowUI(Counter counter) {
        CounterUI frame = new CounterUI(counter);
        counter.addObserver(frame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addComponentsToPane();
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI(new Counter("Like", 0));
            }
        });
    }
}
