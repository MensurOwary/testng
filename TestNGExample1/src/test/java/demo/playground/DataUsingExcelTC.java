/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.playground;

import com.testingng.Calculator;
import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static utils.ExcelUtils.getDataArrayByCol;

/**
 *
 * @author Mensur Owary
 */
public class DataUsingExcelTC {
    
    ToDoubleBiFunction<Double, Double> add;
    ToDoubleBiFunction<Double, Double> mult;
    ToDoubleBiFunction<Double, Double> sub;
    ToDoubleBiFunction<Double, Double> div;
    
    @BeforeSuite
    public void setup(){
        System.out.println("Setting pre-conditions...");
        add = (a, b) -> a+b;
        mult = (a, b) -> a*b;
        sub = (a, b) -> a-b;
        div = (a, b) -> a/b;
        System.out.println("Setting up finished...");
    }
    
    @BeforeTest
    public void before(){
        System.out.println("before test ran");
    }
    
    @DataProvider(name="dataProvider")
    public static Object[][] provideData(){
        Object[][] arr = getDataArrayByCol("C:\\Users\\MansurGulami\\Desktop\\Data\\data.xlsx", "data", 0);
        
        for (int i=0;i<arr.length;i++) {
            arr[i] = Arrays.copyOfRange(arr[i], 0, 2);
        }
        
        System.out.println(Arrays.deepToString(arr));
        return arr;
    }
    
    @Test(dataProvider="dataProvider")
    public void add(double a, double b){
        Calculator.calculate(add, a, b);
    }
    
    @Test(dataProvider="dataProvider")
    public void mult(double a, double b){
        Calculator.calculate(mult, a, b);
    }
    
    @Test(dataProvider="dataProvider")
    public void sub(double a, double b){
        Calculator.calculate(sub, a, b);
    }
    
    @Test(dataProvider="dataProvider")
    public void div(double a, double b){
        Calculator.calculate(div, a, b);
    }
    
    @AfterTest
    public void after(){
        System.out.println("after test ran");
    }
    
    @AfterSuite
    public void cleanup(){
        System.out.println("Suite Finished");
    }
    
}
