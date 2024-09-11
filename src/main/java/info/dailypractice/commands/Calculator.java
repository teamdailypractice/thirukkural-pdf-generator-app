package info.dailypractice.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Calculator {

    @ShellMethod("Adds two numbers")
    public int add(int a, int b) {
        return a + b;
    }
}
