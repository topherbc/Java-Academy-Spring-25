package com.pluralsight;

public class App {
    public static void main(String[] args) {
        String nonStringBuilderSkills = "";

        StringBuilder skills = new StringBuilder();



// append strings to the StringBuilder object
        skills.append("Git, ");
        skills.append("HTML, ");
        skills.append("CSS, ");
        skills.append("and Bootstrap\n");
        skills.append("JavaScript, ");
        skills.append("ES6, ");
        skills.append("jQuery, ");
        skills.append("REST APIs, ");
        skills.append("and Express\n");
        skills.append("Angular\n");
        skills.append("Java\n");




        nonStringBuilderSkills += "Git, ";
        nonStringBuilderSkills += "HTML, ";
        nonStringBuilderSkills += "CSS, ";
        nonStringBuilderSkills += "and Bootstrap\n";
        nonStringBuilderSkills += "JavaScript, ";
        nonStringBuilderSkills += "ES6, ";
        nonStringBuilderSkills += "jQuery, ";
        nonStringBuilderSkills += "REST APIs, ";
        nonStringBuilderSkills += "and Express\n";
        nonStringBuilderSkills += "Angular\n";
        nonStringBuilderSkills += "Java\n";
// retrieve the underlying characters from
// the StringBuilder
        String mySkills = skills.toString();
        System.out.println(mySkills);

        System.out.println(nonStringBuilderSkills);
    }
}
