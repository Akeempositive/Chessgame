package chessgame;

import java.util.*;

public class Lesson1{
    public static void main(String[] args){
        int a= new Scanner(System.in).nextInt();
        if(a<12){
            System.out.println("Good Morning");
        } else if (a<16){
            System.out.println("Good Afternoon");
        } else {
            System.out.println("Good Evening");
        }
        
        List<String> you=new LinkedList<String>();
        Set<String> set= new HashSet<String>(you);
    }//End of Methof main    
}//End of Class Lesson1