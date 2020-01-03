package com.pbaumgarten.makeagui;

import javax.swing.*;

public class Screen extends JFrame {
    private JPanel panelTop;
    private JButton saveNewButton;
    private JButton saveExistingButton;
    private JPanel Name;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel MainPanel;
    private JList Customers;

    Screen(){
        //supper("This is a works");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    /*
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    */
    public static void main(String[] args) {
        Screen objPadme=new Screen();
        objPadme.setVisible(true);
    }
}
