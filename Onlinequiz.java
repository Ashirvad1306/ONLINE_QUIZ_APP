package com.begjava.ashirvad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class Onlinequiz extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnPrevious, btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    // create jFrame with radioButton and JButton
    Onlinequiz(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnPrevious = new JButton("Previous");
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");
        btnPrevious.addActionListener(this);
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnPrevious);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        //radioButton[0].setBounds(50, 80, 200, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnPrevious.setBounds(50, 240, 100, 30);
        btnNext.setBounds(180, 240, 80, 30);
        btnBookmark.setBounds(300, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    // handle all actions based on event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct answers= " + count);
            System.exit(0);
        }
    }

    // SET Questions with options
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Que1:  Who invented Java Programming?");
            radioButton[0].setText("James Gosling");
            radioButton[1].setText("Dennis Ritchie");
            radioButton[2].setText("Bjarne Stroustrup");
            radioButton[3].setText("None of these");
        }
        if (current == 1) {
            label.setText("Que2:   Which one of the following is not a Java feature?");
            radioButton[0].setText("Object-oriented");
            radioButton[1].setText("Robust");
            radioButton[2].setText("Dynamic and Extensible");
            radioButton[3].setText("Use of Pointers");
        }
        if (current == 2) {
            label.setText("Que3: Number of primitive data types in Java are?");
            radioButton[0].setText("6");
            radioButton[1].setText("7");
            radioButton[2].setText("8");
            radioButton[3].setText("9");
        }
        if (current == 3) {
            label.setText("Que4: Which of the following is not an OOPS concept in Java?");
            radioButton[0].setText("Polymorphism");
            radioButton[1].setText("Inheritace");
            radioButton[2].setText("Compilation");
            radioButton[3].setText("Encapsulation");
        }
        if (current == 4) {
            label.setText("Que5:  Which of the following is a type of polymorphism in Java Programming?");
            radioButton[0].setText(" Multiple polymorphism");
            radioButton[1].setText("Compile time polymorphism");
            radioButton[2].setText("Multilevel polymorphism");
            radioButton[3].setText("Execution time polymorphism");
        }
        if (current == 5) {
            label.setText("Que6: Which keyword is used for accessing the features of a package?");
            radioButton[0].setText("package");
            radioButton[1].setText("import");
            radioButton[2].setText("extends");
            radioButton[3].setText("export");
        }
        if (current == 6) {
            label.setText("Que7:  Which of the following is a reserved keyword in Java?");
            radioButton[0].setText("object");
            radioButton[1].setText("strictfp");
            radioButton[2].setText("main");
            radioButton[3].setText("system");
        }
        if (current == 7) {
            label.setText("Que8:  What is the return type of the hashCode() method in the Object class?");
            radioButton[0].setText("Object");
            radioButton[1].setText("int");
            radioButton[2].setText("long");
            radioButton[3].setText("void");
        }
        if (current == 8) {
            label.setText("Que9: Which exception is thrown when java is out of memory?");
            radioButton[0].setText("MemoryError");
            radioButton[1].setText("OutOfMemoryError");
            radioButton[2].setText("MemoryOutOfBoundsException");
            radioButton[3].setText("MemoryFullException");
        }
        if (current == 9) {
            label.setText("Que10: Which one of the following is not an access modifier?");
            radioButton[0].setText("Protected");
            radioButton[1].setText("Private");
            radioButton[2].setText("Public");
            radioButton[3].setText("void");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    // declare right answers.
    boolean check() {
        if (current == 0)
            return (radioButton[0].isSelected());
        if (current == 1)
            return (radioButton[3].isSelected());
        if (current == 2)
            return (radioButton[2].isSelected());
        if (current == 3)
            return (radioButton[2].isSelected());
        if (current == 4)
            return (radioButton[1].isSelected());
        if (current == 5)
            return (radioButton[1].isSelected());
        if (current == 6)
            return (radioButton[1].isSelected());
        if (current == 7)
            return (radioButton[1].isSelected());
        if (current == 8)
            return (radioButton[1].isSelected());
        if (current == 9)
            return (radioButton[3].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new Onlinequiz("Online Quiz App");
    }

}
