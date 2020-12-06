
package christmaslist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Caio
 */
public class ReadRandom {
    
  /**
   * 
   * @param f
   * @return random lines from the file until the end of its reading
   * @throws FileNotFoundException 
   */
  public static String choose(File f) throws FileNotFoundException
  {
     String result = null;
     Random rand = new Random();
     int n= 0;
     
        /*
     
        **** test
        Random r = new Random();
        int num = r.nextInt(4);
        int quant = 0;

        if (num != 0) {
            quant = num;
        } else {
            quant = quant + 1;
        }
        
        
     int[] userNumbers = new int[quant];
     for(int i = 0; i<userNumbers.length; i++ )
     {
         
     }
     */


     for(Scanner sc = new Scanner(f); sc.hasNext(); )
     {
        ++n;
        String line = sc.nextLine();
        if(rand.nextInt(n) == 0)
            
           result = line;         
     }
     

     return result;   
      
  }
    
}