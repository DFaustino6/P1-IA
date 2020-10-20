package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stacks implements Ilayout, Cloneable {
    int dim =3;
    List<Stack<Character>> stacks;
    String stackFormat="";

    public Stacks(String str) {
        if(str.length() <dim) throw new IllegalStateException("Invalid arg in Board constructor");

        List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if(str.charAt(i)==' '){
                i++;
                stacks.add(stack);
                stack = new Stack<Character>();
            }
        }
        System.out.println(stacks.size());

    }

    @Override
    public List<Ilayout> children() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isGoal(Ilayout I) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getG() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        if(stackFormat.equals("")){
            for (Stack<Character> stack : stacks) {
                String s="";
                for (Character character : stack) {
                    s += character;
                }
                stackFormat += "["+ s +"]";
            }
        }
        return stackFormat;
    }

    @Override
    public boolean equals(Ilayout I) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
