package com.mycompany.convertertemperaturegui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ConverterTemperatureGUI {
    
    //Declaring main frame at the class level so it can be accessed by all methods 
    static JFrame mainFrame = new JFrame("Temperature Converter");
    
    static void FahrenheitToCelsius() {
        JFrame converterGUI = new JFrame("Fahrenheit to Celsius");
        JTextField Fahrenheit = new JTextField();
        JButton convertButton = new JButton("Convert");
        JLabel result = new JLabel("Result");
        JButton backButton = new JButton("Back");
       
        
        //fahrenheit axis
        Fahrenheit.setBounds(50, 50, 100, 40); 
        
        //convertButton axis
        convertButton.setBounds(50, 100, 100, 40); 
        
        //result axis
        result.setBounds(50, 150, 200, 40); 
        
        //backButton axis 
        backButton.setBounds(50, 200, 100, 40);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double n = Double.parseDouble(Fahrenheit.getText());
                    double formula = (5.0/9) * (n - 32);
                    result.setText(String.format("%.2f Celsius", formula));
                } catch (NumberFormatException ex) {
                    result.setText("Invalid input");
                }
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterGUI.setVisible(false);
                mainFrame.setVisible(true); // Show the main frame again
            }
        });

        converterGUI.add(Fahrenheit);
        converterGUI.add(convertButton);
        converterGUI.add(result);
        converterGUI.add(backButton);
        
        converterGUI.setSize(300, 300);
        converterGUI.setLayout(null);
        converterGUI.setVisible(true);
    }

    static void CelsiusToFahrenheit() {
        JFrame converterGUI = new JFrame("Celsius to Fahrenheit");
        JTextField Celsius = new JTextField();
        JButton backButton = new JButton("Back");
        JButton convertButton = new JButton("Convert");
        JLabel result = new JLabel("Result");

        //convertButton axis
        convertButton.setBounds(50, 100, 100, 40); 
        
        //backButton axis
        backButton.setBounds(50, 200, 100, 40);
        
        //celsius axis
        Celsius.setBounds(50, 50, 100, 40); 
        
        //result axis
        result.setBounds(50, 150, 200, 40); 

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double n = Double.parseDouble(Celsius.getText());
                    double formula = (n * 9/5) + 32;
                    result.setText(String.format("%.2f Fahrenheit", formula));
                } catch (NumberFormatException ex) {
                    result.setText("Invalid input");
                }
            }
        });

        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterGUI.setVisible(false);
                mainFrame.setVisible(true); // Show the main frame again
            }
        });

        converterGUI.add(backButton);
        converterGUI.add(Celsius);
        converterGUI.add(convertButton);
        converterGUI.add(result);
        converterGUI.setSize(300, 300);
        converterGUI.setLayout(null);
        converterGUI.setVisible(true);
    }

    static void initWelcomeGUI() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton firstChoice = new JButton("Fahrenheit to Celsius");
        JButton secondChoice = new JButton("Celsius to Fahrenheit");
        JButton exitButton = new JButton("Exit");

        // firstChoice axis
        firstChoice.setBounds(130, 100, 180, 40);

        // secondChoice axis
        secondChoice.setBounds(320, 100, 180, 40); 
        
        //close button axis
        exitButton.setBounds(245, 150, 140, 40);

        // action listener for firstChoice
        firstChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                FahrenheitToCelsius();
            }
        });

        // action listener for secondChoice
        secondChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                CelsiusToFahrenheit();
            }
        });
       
        //action listener for exitButton
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });

        mainFrame.add(firstChoice);
        mainFrame.add(secondChoice);
        mainFrame.add(exitButton);
        mainFrame.setSize(600, 300);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        initWelcomeGUI();
    }
}
