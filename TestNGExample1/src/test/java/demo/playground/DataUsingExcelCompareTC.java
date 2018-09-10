/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.playground;

import com.testingng.Calculator;
import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static utils.ExcelUtils.getDataArray;
import static utils.ExcelUtils.getDataArrayByCol;

/**
 *
 * @author Mensur Owary
 */
public class DataUsingExcelCompareTC {
    
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
    
    @DataProvider(name="dataProviderAdd")
    public static Object[][] provideDataForAdd(){
        return getDataArrayByCol("C:\\Users\\MansurGulami\\Desktop\\Data\\data.xlsx", "data", 2);
    }
    
    @DataProvider(name="dataProviderMult")
    public static Object[][] provideDataForMult(){
        return getDataArrayByCol("C:\\Users\\MansurGulami\\Desktop\\Data\\data.xlsx", "data", 4);
    }
    
    @DataProvider(name="dataProviderSub")
    public static Object[][] dataProviderForSub(){
        return getDataArrayByCol("C:\\Users\\MansurGulami\\Desktop\\Data\\data.xlsx", "data", 3);
    }
    
    @DataProvider(name="dataProviderDiv")
    public static Object[][] dataProviderForDiv(){
        return getDataArrayByCol("C:\\Users\\MansurGulami\\Desktop\\Data\\data.xlsx", "data", 5);
    }
    
    @Test(dataProvider="dataProviderAdd")
    public void add(double a, double b, double c){
        assertEquals(c, Calculator.calculate(add, a, b));
    }
    
    @Test(dataProvider="dataProviderMult")
    public void mult(double a, double b, double c){
        assertEquals(c, Calculator.calculate(mult, a, b));
    }
    
    @Test(dataProvider="dataProviderSub")
    public void sub(double a, double b, double c){
        assertEquals(c, Calculator.calculate(sub, a, b));
    }
    
    @Test(dataProvider="dataProviderDiv")
    public void div(double a, double b, double c){
        assertEquals(c, Calculator.calculate(div, a, b));
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
