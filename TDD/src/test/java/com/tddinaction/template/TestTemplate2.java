package com.tddinaction.template;

import org.junit.*;

import com.tddinaction.template.MissingValueException;
import com.tddinaction.template.Template;
import static org.junit.Assert.*;

public class TestTemplate2 {

    @Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }
}
