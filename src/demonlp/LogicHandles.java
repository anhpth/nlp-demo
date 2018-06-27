/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonlp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class LogicHandles {
    public boolean checkSpecialTypeWord(String[] specialWordArray, String wordToCompare){
        boolean isSpecialWord = false;
        String strStandard = wordToCompare.substring(0, 1).toUpperCase()+wordToCompare.subSequence(1, wordToCompare.length());
        for(int j = 0; j < specialWordArray.length; j++){
            if(wordToCompare.equals(specialWordArray[j]) 
            || strStandard.equals(specialWordArray[j])){
                isSpecialWord = true;
                break;
            } else {
                isSpecialWord = false; 
            }
        }
        return isSpecialWord;
    }
    
    public String checkTailOfWord(String word){
            //check the word end with 's' or 'es'.
        String originalWord = "";
                try {
                    DatabaseHandles db = new DatabaseHandles();
                    if(!db.isEmptyField("entries","word",word)){
                         originalWord = word;
                    } else{
                        if(word.endsWith("es")){
                          originalWord = word.substring(0,word.length()-2);
                        } else if(word.endsWith("s")){
                          originalWord = word.substring(0,word.length()-1);
                         }
                    }
                } catch (ClassNotFoundException ex) {
                    System.out.println("Eror: "+ex);
                 }catch (SQLException ex) {
                    System.out.println("Eror: "+ex);
                }
                return originalWord;
    }
    
    public boolean isContainInList(String word, ArrayList<String> containList){
        boolean isContaining = false;
        for(int i = 0; i < containList.size(); i++){
            if(word.equals(containList.get(i))){
                isContaining = true;
            } else {
                isContaining = false;
            }
        }
        return isContaining;
    }
    
    
    public static void writeSentenceToFile() throws IOException{
    FileInputStream inputStream = null;
    FileOutputStream outputStream = null;
      try {
         inputStream = new FileInputStream("/Users/admin/Desktop/inStream.txt");
         outputStream = new FileOutputStream("/Users/admin/Desktop/outStream.txt");
          
         int c;
         while ((c = inputStream.read()) != -1) {
            outputStream.write(c);           
         }
      } finally {
         if (inputStream != null) {
            inputStream.close();
         }
         if (outputStream != null) {
            outputStream.close();
         }
      }         
    }
    
    public static void main(String[] args) {
    }
}
