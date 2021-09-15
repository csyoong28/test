package com.soonyoong.mockito;
import static org.junit.Assert.*;   

import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.powermock.api.mockito.PowerMockito;  
import org.powermock.core.classloader.annotations.PrepareForTest;  
import org.powermock.modules.junit4.PowerMockRunner;  
  
@RunWith(PowerMockRunner.class)  
@PrepareForTest( Abstract_Class2.class)  
public class AbstractTestClass2 {
    @Test  
    public void test_AbstractClassesusing_PowerMock() throws Exception {  
        // given   
        Abstract_Class2 ac = PowerMockito.mock(Abstract_Class2.class);  
        PowerMockito.doCallRealMethod().when(ac).sayMock();  
        PowerMockito.doReturn("Sharma").when(ac , "getName");  
        //when  
        String newstring = ac.sayMock();  
        //then  
        assertEquals("Sharma13", newstring);  //success
        System.out.println(newstring);  
    }  
}
