import java.io.*;
public class Vaccine implements Comparable<Vaccine>{
String country;
String date;
String vaccinations;
String key;

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
public Vaccine(String c , String d){
    country = c;
    date =d;
    key = c+d;
}// VAccine constructor that takes in country and date

public int compareTo ( Vaccine other ){
    return key.compareTo(other.key);
}// compare method

}
