import java.io.*;
/**
* The Vaccine class with Fields country, date, vaccinations and key ( concatination of country and date ) 
* It contains constructors and one method 
* @author Rea
* @version 1.0 23/03/2022
*/
public class Vaccine implements Comparable<Vaccine>{
String country;
String date;
String vaccinations;
String key;

/** 
* @ return Nothing
* @ exception NullPointerException 
* @parm line Takes in a String line and converts it into a vaccine object by spliting it and assigning each index to an attribute
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
* This contructor takes in two strings and creates a vaccine object
* @parm c The vaccines country attribute
* @parm d The vaccines date attribute
* @return Nothing
*/
public Vaccine(String c , String d){
    country = c;
    date =d;
    key = c+d;
}// VAccine constructor that takes in country and date
/**
* CompareTo method compares two object and returns an integer 
* @returns an integer representing comparison between two countries 
* @parm other  
*/
public int compareTo ( Vaccine other ){
    return key.compareTo(other.key);
}// compare method

}
