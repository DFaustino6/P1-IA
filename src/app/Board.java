package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Board implements Ilayout, Cloneable {
    int dim =3;
    List<Stack<Character>> stacks;
    String stackFormat="";

    public Board(String str) {
        if(str.length() <dim) throw new IllegalStateException("Invalid arg in Board constructor");

        this.stacks = new ArrayList<Stack<Character>>(dim);
        
        for (int i = 0; i < dim; i++) 
            this.stacks.add(new Stack<Character>());
        
        int nStack=0;
        for (int i = 0; i < str.length(); i++)
            if(str.charAt(i)!=' ') stacks.get(nStack).push(str.charAt(i));
            else nStack++;
    }

    public Board(List<Stack<Character>> stacks){
        this.stacks=stacks;
    }
    
    @Override
    public List<Ilayout> children() {
        List<Ilayout> children = new ArrayList<>();
        char c;
        for (Stack<Character> stack : stacks) {
            c=stack.pop();
            
        }
        
        return children;
    }

    @Override
    public boolean isGoal(Ilayout I) {
        return isGoal(I);
    }

    @Override
    public double getG() {
        return 1;
    }

    @Override
    public String toString() {
        if(stackFormat.equals("")){
            for (Stack<Character> stack : stacks) {
                String s="";
                for (Character character : stack)
                    if(stack.search(character)!=stack.size()) s += ", "+character;
                    else s +=character;

                if(s!="") stackFormat += "["+ s +"]\r\n";
            }
        }
        return stackFormat;
    }

    @Override
    public boolean equals(Ilayout I) {
        if(toString().equals(I.toString())) return true;
        else return false;
    }
    
}
