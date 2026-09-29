package org.example.clean_code_test.functions.descriptive_name;

public class DescriptiveNameTest {
    // Bad Code
    public static void copy(char a1[], char a2[]) {
        for (int i = 0; i < a1.length; i++) {
            a2[i] = a1[i];
        }
    }

    // Clean Code
    public static void copyChars(char source[], char destination[]) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    // Bad Code
    render(true); // Confusing boolean flag passed into a method


    // Clean Code
    renderForSuite();
    renderForSingleTest();



}
