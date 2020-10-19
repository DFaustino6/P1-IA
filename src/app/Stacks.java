package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stacks implements Ilayout, Cloneable {
    int dim =3;
    List<Stack<Character>> stacks;
    String stackFormat="";

    public Stacks(String str) {
        if(str.length() != dim) throw new IllegalStateException("Invalid arg in Board constructor");

        List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                stacks.add(stack);
                stack = new Stack<Character>();
            }  
        }

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
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(s.charAt(i) == '0')
                    stackFormat+=" ";
                else stackFormat+=c;
                if((i+1)%dim == 0)
                    stackFormat+="\r\n";
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
