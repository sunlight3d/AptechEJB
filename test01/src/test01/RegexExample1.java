/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test01;

/**
 *
 * @author Nguyen Duc Hoang
 */
import java.util.*;
import java.util.regex.*;

public class RegexExample1 {
    public static void main(String args[]) {
        String patternString = "([a-z0-9]+@[a-z0-9]+\\.[a-z]{2,6})";
        Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Email:   hoang123@gmail.com");
        final List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            //String x0 = matcher.group(0);
            //String x1 = matcher.group(1);
            // x2 = matcher.group(2);
            //String x3 = matcher.group(3);
            matches.add(matcher.group());
            System.out.println("aa");
        }
        System.out.println("matches = "+matches);
    }
}
