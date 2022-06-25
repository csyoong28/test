package com.tddinaction.template;

import org.junit.*;

import com.tddinaction.template.MissingValueException;
import com.tddinaction.template.Template;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTemplate {

    private Template template;

    @Before
    public void setUp() {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multiplePlaceholders() {
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void unknownVariablesAreIgnored() {
        template.set("doesnotexist", "Hi");
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void settingValueMultipleTimes() {
        template.set("three", "4");
        assertTemplateEvaluatesTo("1, 2, 4");
    }

    @Test
    public void missingValueRaisesException() {
        try {
            new Template("${foo}").evaluate();
            fail("evaluate() should throw an exception if "
                    + "a placeholder was left without a value!");
        } catch (MissingValueException expected) {
            assertEquals("No value for ${foo}", expected.getMessage());
        }
    }

    @Test(expected = MissingValueException.class)
    public void missingValueRaisesException_withAnnotation() {
        new Template("${foo}").evaluate();
    }

    @Test
    public void placeholdersGetProcessedJustOnce() {
        template.set("one", "${one}");
        template.set("two", "${three}");
        template.set("three", "${two}");
        assertEquals("${one}, ${three}, ${two}", template.evaluate());
    }

    private void assertTemplateEvaluatesTo(String expected) {
        assertEquals(expected, template.evaluate());
    }
    

    @Test
    public void testHowGroupCountWorks() throws Exception {
    	 String haystack = "The needle shop sells needles";
    	    String regex = "(needle)";
    	    Matcher matcher = Pattern.compile(regex).matcher(haystack);
    	    assertTrue(matcher.find());
    	    assertEquals("Wrong start index of 1st match", 4, matcher.start());
    	    assertEquals("Wrong end index of 1st match", 10, matcher.end());
    }
    
    @Test
    public void testOnDev() 
    {
        System.setProperty("ENV", "PROD");
        assumeTrue("DEV".equals(System.getProperty("ENV")));
        System.out.println("will run testOnDev()");
        assertEquals(4, 4);
    }
    
}
