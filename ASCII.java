
import java.util.Scanner;
public class ASCII{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name);

        for( int i=0 ; i <name.length(); i++){
            char charachter = name.charAt(i);
            int ASCII = (int) charachter;
            System.out.println(charachter+":"+ASCII);
        }
       
    
    }
    
}
