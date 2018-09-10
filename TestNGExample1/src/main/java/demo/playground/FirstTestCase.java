/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.playground;

import com.testingng.Calculator;
import java.util.function.ToDoubleBiFunction;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Mensur Owary
 */
public class FirstTestCase {
    
    static ToDoubleBiFunction<Double, Double> add;
    static ToDoubleBiFunction<Double, Double> mult;
    static ToDoubleBiFunction<Double, Double> sub;
    static ToDoubleBiFunction<Double, Double> div;
    
    static Double a;
    static Double b;
    
    @BeforeSuite
    public void setup(){
        System.out.println("Setting pre-conditions...");
        add = (a, b) -> a+b;
        mult = (a, b) -> a*b;
        sub = (a, b) -> a-b;
        div = (a, b) -> a/b;
        a = new Double(5);
        b = new Double(3);
        System.out.println("Setting up finished...");
    }
    
    @Test
    public void add(){
        Calculator.calculate(add, a, b);
    }
    
    @Test
    public void mult(){
        Calculator.calculate(mult, a, b);
    }
    
    @Test
    public void sub(){
        Calculator.calculate(sub, a, b);
    }
    
    @Test
    public void div(){
        Calculator.calculate(div, a, b);
    }
    
    @AfterSuite
    public void cleanup(){
        System.out.println("Suite Finished");
    }
    
}
