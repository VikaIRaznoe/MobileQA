package com.example.myhomeworkafterlesson3;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ExampleUnitTest {

    //Проверка, то что условие соблюдено (значение одной переменной совпадает с другой)
    @Parameters({"param_1","param_2"})
    @Test()
    public void testParameterEquals(String param_1,String param_2){
        //Вывод на экран
        //System.out.println("Parameter is: " + param_1 + " " + param_2);
        //Проверка типа переменной
        //System.out.println(param_1.getClass().getName());
        assertEquals(param_1,param_2);
    }

    //Проверка, что условие не соблюдено
    @Parameters({"param_1","param_3"})
    @Test()
    public void testParameterNotEquals(String param_1,String param_3){
        //assertEquals(param_1,param_2);
        assertNotEquals(param_1,param_3);
    }
}