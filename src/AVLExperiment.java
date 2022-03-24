import java.util.Random;
import java.io.*;
/**
* AVLExperiment  
* @author Reabetsoe
* @version 1.0
* This class is used to randomize data and create an array of vaccine objects that will be inserted into the AVL treee
*/
public class AVLExperiment{
/**
* This method takes in an array of strings and an integer representing the amount of randomization to be done (number of swaps to be done)
* @parm randNum Amount of randomisation to be done
* @parm array Array to be randomized
*/
public void randomization(String [] array, int randNum){
   int random1 = 0;
   int random2  = 0;
   for(int i = 0; i < randNum ; i++){
      Random rand = new Random();
      random1 = rand.nextInt(9918);
      random2 = rand.nextInt(9918);
      
      while (random1==random2){
         random2 = rand.nextInt(9918);
      }
    String temp = "";
    temp = array[random1];
    array[random1] = array[random2];
    array[random2] = temp;
   
   }
   
}

/**
*Main method to read in file count amount of insertion operations and find operations
*The main method makes use of the randomization method and creates an AVLExperiment and AVLTree of vaccine type
*The randomized data is read, inserted into an AVL tree and each object in the AVL is searched for in the AVL, The number of comparison operations for inserting and searching are stored in different text files
* @ return Nothing
*@ exception ArrayIndexOutOfBoundsException, FileNotFoundException
*/

public static void main (String [] args){

AVLExperiment obj = new AVLExperiment();
AVLTree<Vaccine> avl = new AVLTree<Vaccine>();

String[] array = new String[9919];
String[] original = new String[9919];
int count = 0;
String argue = "";
int rand = 0;
try{
   argue = args[0];   
   rand = Integer.parseInt(argue);
   
BufferedReader read = new BufferedReader(new FileReader("/home/reabetsoe/CSCA2/vaccinations.csv"));
   String line = "";
   while((line = read.readLine())!=null)
   {
      array[count] = line;
      //System.out.println(read.readLine());
      original[count]  = line;
      count++;
   }
}
catch(ArrayIndexOutOfBoundsException e)
{
   e.printStackTrace();
}
catch(FileNotFoundException e)
{
   System.out.println("The file was not found!");  
}
catch(IOException e)
{
   e.printStackTrace();
}
obj.randomization(array,rand);
   try{
   	File insert = new File("/home/reabetsoe/CSCA2/insertion_"+rand);
      	insert.createNewFile();
      	FileWriter wrt = new FileWriter("/home/reabetsoe/CSCA2/insertion_"+rand);
   
   File search = new File("/home/reabetsoe/CSCA2/search_"+rand);  
   search.createNewFile();
   FileWriter wrts = new FileWriter("/home/reabetsoe/CSCA2/search_"+rand);   	
      	
   	for(int i = 0; i<9919;i++){
      		avl.insert(new Vaccine(array[i]));
      		wrt.write(avl.insertCount+"\n");
      		avl.insertCount = 0;}
      wrt.close();
      
   
    
   for(int i = 0; i<9919;i++)
   {
      avl.find(new Vaccine(original[i]));
      wrts.write(avl.count + "\n");
      avl.count = 0;
   }
   wrts.close();
   
      }
      catch(IOException e)
      {
      		e.printStackTrace();
      }
}




}
