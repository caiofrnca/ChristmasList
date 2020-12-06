package christmaslist;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Caio
 * 
 * TEST 
 */
public class RemoveLine {
    
    
    public void teste(){

    String filePath = "teste.txt";
    
    try {
    BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
    String lineText = null;
    
    Random r = new Random();
        int num = r.nextInt(4);
        int quant = 0;

        if (num != 0) {
            quant = num;
        } else {
            quant = quant + 1;
        }
    
        String conteudo;
 
    while ((lineText = lineReader.readLine()) != Integer.toString(quant)) {
        System.out.println(lineText);
        System.out.println(quant);
        conteudo = lineReader.readLine();
        System.out.println(conteudo);
    }
 
    lineReader.close();
    } catch (IOException ex) {
        System.err.println(ex);
    }
    
        

    }
}
