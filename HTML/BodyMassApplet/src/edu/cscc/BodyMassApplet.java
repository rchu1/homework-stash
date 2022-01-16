package edu.cscc;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Name, Date
 * Calculate body mass index
 */
public class BodyMassApplet extends Applet implements ActionListener {
    // declare variables
    int inches, pounds;
    double meters, kilograms, index;

    //construct components
    Label companyLabel = new Label("THE SUN FITNESS CENTER BODY MASS INDEX CALCULATOR");
    Label heightLabel = new Label("Enter your height to the nearest inch: ");
    TextField heightField = new TextField(10);
    Label weightLabel = new Label("Enter your weight to the nearest pound: ");
    TextField weightField = new TextField(10);
    Button calcButton = new Button("Calculate");
    Label outputLabel = new Label("Click the Calculate button to see your body mass index.");

    // Called automatically when applet starts
    public void init() {
        setForeground(Color.red);
        add(companyLabel);
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(calcButton);
        calcButton.addActionListener(this);
        add(outputLabel);
    }

    // Called when a user performs an action
    @Override
    public void actionPerformed(ActionEvent e) {
        inches = Integer.parseInt(heightField.getText());
        pounds = Integer.parseInt(weightField.getText());
        meters = inches / 39.36;
        kilograms = pounds / 2.2;
        index = kilograms / Math.pow(meters, 2);
        outputLabel.setText("YOUR BODY MASS INDEX IS " + Math.round(index) + ".");
    }
}
