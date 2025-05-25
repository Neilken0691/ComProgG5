/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphemployeeapp;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author marqu
 */
public class Employee extends JFrame{
    
    Employee(){
        
    }
    private int employeeID;
    private String name;
    private int age;
    private String position;
    private float salary; // per day

    public Employee(int employeeID, String name, int age, String position, float salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}
