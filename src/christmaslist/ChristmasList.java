package christmaslist;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Caio
 */
public class ChristmasList {

    public static void main(String[] args) throws IOException {
        //INPUT DATA FILES
        File childinput = new File("Christmas.txt");
        File fgifts = new File("Fgifts.txt");
        File mgifts = new File("Mgifts.txt");

        int cont = 0;//ERROR CONTROL

        try {
            //OPEN NEW READING ARCHIVE
            Scanner cInput = new Scanner(new FileReader(childinput));
            //OPEN NEW WRITING ARCHIVE
            FileWriter writer = new FileWriter("temp.txt");

            do {
                //STRINGS DECLARATION FOR HANDLING INSIDE THE FILE.
                String full = cInput.nextLine();
                String name = full.substring(0, full.indexOf(','));
                String gender = full.substring(full.lastIndexOf(',') + 1).trim();
                //GENERATE NUMBER BETWEEN 1 AND 3
                Random r = new Random();
                int num = r.nextInt(4);
                int quant = 0;

                if (num != 0) {
                    quant = num;
                } else {
                    quant = quant + 1;
                }
                //GENDER CHECK
                //THE SOLUTION TO CAPTURE THE GIFTS WITHIN THE PRESENT FILE BELOW IS NOT THE DESIRED ONE, BUT IT HAS NOT BEEN able TO DEVELOP THE METHOD TO SEEK RANDOM LINES AVOIDING REPEAT. INSUFFICIENT TIME TO FINISH.
                if ((gender.equals("M")) && (quant ==1)){
                    writer.write(name + " , (" +ReadRandom.choose(mgifts)+")" + System.lineSeparator());
                } else if ((gender.equals("M")) && (quant ==2)){
                    writer.write(name + " , (" +ReadRandom.choose(mgifts)+","+ReadRandom.choose(mgifts)+")" + System.lineSeparator());
                } else if ((gender.equals("M")) && (quant ==3)){
                    writer.write(name + " , (" +ReadRandom.choose(mgifts)+","+ReadRandom.choose(mgifts)+","+ReadRandom.choose(mgifts)+")" + System.lineSeparator());
                } else if ((gender.equals("F")) && (quant ==1)){
                    writer.write(name + " , (" +ReadRandom.choose(fgifts)+ ")" + System.lineSeparator());
                } else if ((gender.equals("F")) && (quant ==2)){
                    writer.write(name + " , (" +ReadRandom.choose(fgifts)+","+ReadRandom.choose(fgifts)+")" + System.lineSeparator());
                } else if ((gender.equals("F")) && (quant ==3)){
                    writer.write(name + " , (" +ReadRandom.choose(fgifts)+","+ReadRandom.choose(fgifts)+","+ReadRandom.choose(fgifts)+")" + System.lineSeparator());
                } else {
                    cont++;
                }

            } while (cInput.hasNext());
            writer.close();
        } catch (Exception e) {
            System.out.println("Try/catch1 - There is nothing on the file, please check it again!");
        }
        
        //SECOND TRY / CATCH TO FILTER INPUT OF NAMES AND COPY TO A NEW FILE ONLY THE CORRECT NAMES.
        try {
            
            Scanner cInput2 = new Scanner(new FileReader("temp.txt"));
            FileWriter writer2 = new FileWriter("Deliveries.txt");
            
            do{
                String full = cInput2.nextLine();
                String name = full.substring(0, full.indexOf(','));
                
                
                if (!name.matches("^[a-zA-Z_ ]*$")){
                   cont++;
                }else{
                   writer2.write(full+ System.lineSeparator());
                }

            }while(cInput2.hasNext());
            writer2.close();
            System.out.println("List ready for Santa");
            System.out.println("There were "+cont+" invalid names in the list");
        }catch (Exception e) {
            System.out.println("Try/catch1 - There is nothing on the file, please check it again!");
        }
        

    }

}
