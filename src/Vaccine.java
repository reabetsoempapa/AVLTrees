import java.io.*;
/**
* Vaccine object with attributes 
* 
* @author Rea
* @version 1.0 23/03/2022
*/
public class Vaccine implements Comparable<Vaccine>{
String country;
String date;
String vaccinations;
String key;

/** 
* 
* @parm line Takes in a String line and converts it into a vaccine object by spliting it
*/
public Vaccine (String line ){
    String [] parts = null;
    try{
    parts = line.split(",");
    if(parts.length>2){
    country = parts[0];
    date = parts[1];
    vaccinations = parts[2];
    key = country + date;
    }
    else{
	parts = line.split(",");
    country = parts[0];
    date = parts[1];
    key = country + date;
     vaccinations = "0";
}
    }
    catch(NullPointerException e){
    	e.printStackTrace();
     }
   
} // Vaccine constructor takes in line and splits it to make a vaccine obejct
/**
* @parm c The vaccines country attribute
* @parm d The vaccines date attribute
*/
public Vaccine(String c , String d){
    country = c;
    date =d;
    key = c+d;
}// VAccine constructor that takes in country and date
/**
* @returns an integer representing comparison between two countries 
* @parm other  
*/
public int compareTo ( Vaccine other ){
    return key.compareTo(other.key);
}// compare method

}
