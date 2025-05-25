/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motorphemployeeapp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author marqu
 */
public class MotorPHEmployeeApp {

    public static void main(String[] args) {
        

        // JFrame = a GUI window to add components to
        JFrame frame = new JFrame("MotorPH Employee App"); //creates a frame
        
        // JLabel = a GUI display area for a string of text, an image, or both      
        JLabel labelEmployeeID = new JLabel("Employee ID :"); //create a label
        labelEmployeeID.setBounds(20,20,100,25);
        labelEmployeeID.setForeground(Color.WHITE); //set color of text
        
        JLabel labelPayCoverage = new JLabel("Pay Coverage :"); //create a label
        labelPayCoverage.setBounds(20,60,100,25);
        labelPayCoverage.setForeground(Color.WHITE); //set color of text
        
        JLabel label = new JLabel();
        label.setBackground(Color.BLUE); //set background color
        label.setOpaque(true); //display background color

        //JTextField = a GUI input area for JLabel
        JTextField textEmployeeID = new JTextField();
        textEmployeeID.setBounds(130, 20, 150, 25);
        
        JTextField textPayCoverage = new JTextField();
        textPayCoverage.setBounds(130, 60, 150, 25);
               
        //JButton = a GUI Button to obey command from TextField
        JButton btnGenerate = new JButton("GENERATE PAYSLIP");
        btnGenerate.setBounds(150, 100, 200, 50);
        
        
        //JTextArea = a GUI text area where you can check the results of the command from JButton
        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(20, 170, 450, 380);
        outputArea.setEditable(false);
        
        //ActionListener
        
        btnGenerate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                
            try {
                    int empId = Integer.parseInt(textEmployeeID.getText().trim());
                    int payDays = Integer.parseInt(textPayCoverage.getText().trim());

                    if (payDays <= 0) {
                        throw new IllegalArgumentException("Pay coverage must be greater than 0.");
                    }
                    // Mock employee (replace with real logic if needed)
                    Employee emp = new Employee(empId, "Neil Marquez", 25, "Developer", 500.0f); // salary is per day
                    float basicSalary = emp.getSalary() * payDays;

                    Tax tax = new Tax(101, empId, 0.12f);
                    tax.calculateTax(basicSalary);

                    Payroll payroll = new Payroll(1001, empId, basicSalary, 2000f, tax.getTaxAmount());
                    payroll.calculateSalary();

                    // Output
                    outputArea.setText(
                            "Employee ID: " + empId
                            + "\nPosition: " + emp.getPosition()
                            + "\nPay Days: " + payDays
                            + "\nGross Salary: ₱" + basicSalary
                            + "\nTax: ₱" + tax.getTaxAmount()
                            + "\nNet Salary: ₱" + payroll.getNetSalary()
                    );
            
                }catch (NumberFormatException ex) {
                    outputArea.setText("Please enter valid numbers.");
                } catch (IllegalArgumentException ex) {
                    outputArea.setText(ex.getMessage());
                } catch (Exception ex) {
                    outputArea.setText("Unexpected error: " + ex.getMessage());
                }
            }
        });
        
        //Add Components in JLabel
        frame.add(labelEmployeeID);
        frame.add(textEmployeeID);
        frame.add(labelPayCoverage);
        frame.add(textPayCoverage);
        frame.add(btnGenerate);
        frame.add(outputArea);
        
        //JFrame Set Up
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(Employee.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x123897)); //change color of background
        
        
        
        
    }
}
