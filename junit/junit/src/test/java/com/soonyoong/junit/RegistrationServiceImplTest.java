package com.soonyoong.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class RegistrationServiceImplTest {

    private RegistrationServiceImpl registrationServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        registrationServiceImplUnderTest = new RegistrationServiceImpl();
    }

    @Test
    void testRegister() throws Exception {
        // Setup
        String name = null;
        assertThrows(Exception.class, () -> registrationServiceImplUnderTest.register(name, "phone"));
        try {
            registrationServiceImplUnderTest.register(name, "phone");
            fail("reach here is wrong");
        } catch (Exception e) {
            // Verify the results
            assertTrue(e instanceof Exception);
        }

        MockedStatic<FindUtils> findUtilsMockedStatic = Mockito.mockStatic(FindUtils.class);
        findUtilsMockedStatic.when(() -> FindUtils.getAreaCode(anyString())).thenReturn("a");
        findUtilsMockedStatic.when(() -> FindUtils.getOperatorCode(anyString())).thenReturn("a");
        User user = registrationServiceImplUnderTest.register("name", "phone");
        System.out.println(user.toString());

        Mockito.when(FindUtils.getAreaCode(anyString())).thenReturn("a");
        // Run the test
        //final User result = registrationServiceImplUnderTest.register("name", "phone");

        // Verify the results
    }

    //@Test
    void testRegister_ThrowsException() {
        // Setup
        // Run the test
        assertThrows(Exception.class, () -> registrationServiceImplUnderTest.register("name", "phone"));
    }
}
