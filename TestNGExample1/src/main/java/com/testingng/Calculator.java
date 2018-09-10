/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testingng;

import java.util.function.ToDoubleBiFunction;

/**
 *
 * @author Mensur Owary
 */
public class Calculator {
    
    
    public static double calculate(ToDoubleBiFunction<Double, Double> func, double a, double b){
        double x = func.applyAsDouble(a, b);
        if(Double.isInfinite(x)){
            System.out.println("Failed at : ["+a+", "+b+"]");
            throw new ArithmeticException();
        }
        return x;
    }
    
}
