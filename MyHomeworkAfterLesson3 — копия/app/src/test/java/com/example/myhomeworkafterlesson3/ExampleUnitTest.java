package com.example.myhomeworkafterlesson3;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.mockito.Mockito;

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

    //Дополнительный тест
    @Parameters({"param_4"})
    @Test
    public void testingMock(String param_4){
        String name = param_4;
        MockClass mockObject = Mockito.mock(MockClass.class);
        Mockito.when(mockObject.yourName(name)).thenReturn(name);
        assertEquals("Hello, " + name, "Hello, " + name);
    }
}