/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.playground;

import com.testingng.Calculator;

/**
 *
 * @author Mensur Owary
 */
public class NewClass {
    
    public static void main(String[] args) {
        System.out.println(Calculator.calculate((a, b)->a/b, 1, 0));
    }
    
}
