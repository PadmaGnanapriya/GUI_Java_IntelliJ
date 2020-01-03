package com.pbaumgarten.makeagui;

import javafx.scene.Scene;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Screen extends JFrame {   /* We have to type "extends JFrame" */
    private JPanel panelTop;
    private JButton saveNewButton;
    private JButton saveExistingButton;
    private JPanel Name;
    private JTextField textName;
    private JTextField textEmail;
    private JTextField textPhoneNumber;
    private JTextField textAddress;
    private JTextField textDateOfBirth;
    private JPanel MainPanel;
    private JList Customers;
    private JLabel labelAge;
    private ArrayList<Person> people;
    private DefaultListModel listpeopleModel;

    /* Constructor to auto call Screen GUI code.
    I think Intellij hide all code line using abstration technology" */
    Screen(){
        this.setContentPane(this.MainPanel);   /* MainPanel is my first JPanel. I named it as "MainPanel" */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        people = new ArrayList<Person>();
        listpeopleModel=new DefaultListModel();
        Customers.setModel(listpeopleModel);
        saveExistingButton.setEnabled(false);

        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int personnumber=Customers.getSelectedIndex();
                if(personnumber>=0)
                {
                    Person p=people.get(personnumber);
                    p.setName(textName.getText());
                    p.setEmail(textEmail.getText());
                    p.setdOB(textDateOfBirth.getText());
                    p.setPhoneNumber(textPhoneNumber.getText());
                    refreshPeopleList();

                }

            }
        });
        saveExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Person p=new Person(
                        textName.getText(),
                        textAddress.getText(),
                        textPhoneNumber.getText(),
                        textDateOfBirth.getText()
                );
                people.add(p);
                refreshPeopleList();
            }
        });
        Customers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                int personnmber=Customers.getSelectedIndex();
                if(personnmber>=0)
                {
                    Person p=people.get(personnmber);
                    textName.setText(p.getName());
                    textEmail.setText(p.getEmail());
                    //textAddress.setText(p.);
                    textPhoneNumber.setText(p.getPhoneNumber());
                    textDateOfBirth.setText(p.getdOB().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    labelAge.setText(Integer.toString(p.getAge())+" years");
                    saveExistingButton.setEnabled(true);
                }
               else{
                   saveExistingButton.setEnabled(false);
                }
            }
        });
    }

    public void refreshPeopleList(){
        listpeopleModel.removeAllElements();
        System.out.println("Remove all people");
        for(Person p:people){
            System.out.println("Adding person to list "+p.getName());
            listpeopleModel.addElement(p.getName());
        }
    }
    public void addPerson(Person p){
        people.add(p);
        refreshPeopleList();
    }

    /* The start point to exicute the code as here is
    "public static void main(String[] args) { } */
    public static void main(String[] args) {
        Screen objPadme=new Screen();
        objPadme.setVisible(true);

        Person sunanda=new Person("Sunanda Karunaageewa","skarunaageewa.com","84324242","26/02/1996");
        Person padme=new Person("Padma gnanapriya","padmaisuru@gmail.com","0766328189","25/02/1997");
        Person pasindu= new Person("Pasindu Chinthana","edpchinthana@outlook.com","4234242","21/09/1998");
        Person githmi= new Person("Githmi Anjanaa","wgavithanawasam@gmail.com","12323231","12/07/1998");
        Person chamo= new Person("Chamodi Jayodya","jayodyachamodi@yahoo.com","0702323222","23/02/1996");

        objPadme.addPerson(sunanda);
        objPadme.addPerson(padme);
        objPadme.addPerson(pasindu);
        objPadme.addPerson(githmi);
        objPadme.addPerson(chamo);
    }
}
