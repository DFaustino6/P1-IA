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

        this.stacks = new ArrayList<Stack<Character>>(dim);
        
        for (int i = 0; i < dim; i++) 
            this.stacks.add(new Stack<Character>());
        
        int nStack=0;
        for (int i = 0; i < str.length(); i++)
            if(str.charAt(i)!=' ') stacks.get(nStack).push(str.charAt(i));
            else nStack++;
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
                for (Character character : stack)
                    s += character;
                stackFormat += "["+ s +"]\r\n";
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
