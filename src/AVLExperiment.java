import java.util.Random;
import java.io.*;

public class AVLExperiment{

public void randomization(String [] array, int randNum){
   int random1 = 0;
   int random2 = 0;
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
