package com.tddinaction.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template {

    private Map<String, String> variables;

    private String templateText;

    public Template(String templateText) {
        this.variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    public void set(String name, String value) {
        //this.variables.put(name, value);
    }

    public String evaluate() {
	    String result = replaceVariables();
	    checkForMissingValues(result);      
	    return result;
    	//return null;
//        TemplateParse p = new TemplateParse();
//        List<Segment> segments = p.parseSegments(templateText);
//        return concatenate(segments);
    }
    private void checkForMissingValues(String result) {
        Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(result);
        if (m.find()) {
            throw new MissingValueException("No value for " + m.group());
        }
    }
    
    private String replaceVariables() {                              
        String result = templateText;                                
        for (Entry<String, String> entry : variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";        
            result = result.replaceAll(regex, entry.getValue());     
        }                                                            
        return result;                                               
    }

    private String concatenate(List<Segment> segments) {
        StringBuffer result = new StringBuffer();
        for (Segment segment : segments) {
            result.append(segment.evaluate(variables));
        }
        return result.toString();
    }

}
