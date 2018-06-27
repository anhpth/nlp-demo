/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonlp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author admin
 */
public class DatabaseHandles {
    
    private Connection conn;

    private String strAccount;  //get user account to display in NLPDemoFrm.
    public String getStrAccount() {
        return strAccount;
    }

    public void setStrAccount(String strAccount) {
        this.strAccount = strAccount;
    }
    
    
    // to connect database "englishdictionary"
    public DatabaseHandles() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/englishdictionary";
        this.conn = (Connection) DriverManager.getConnection(url,"root", "");
    }

    //to get data from DB
     public ResultSet getData(String tblName) throws SQLException{
        ResultSet rs;
        Statement stm = (Statement) conn.createStatement(); //tao doi tuong truy van
        String sqlShowTable = "SELECT * FROM "+tblName;
        rs = stm.executeQuery(sqlShowTable); //thuc hien lenh sql
        return rs;
    }
     
     //check if an element is in field
     public boolean isEmptyField(String tblName , String fieldName, String strCompare) throws SQLException{
        ResultSet rs;
        boolean isEmpty = false;
        
        Statement stm = (Statement) conn.createStatement(); //create statement
        String sqlCheckEmpty = "SELECT * FROM "+tblName+" WHERE "+fieldName+" = '"+strCompare+"'";
        rs = stm.executeQuery(sqlCheckEmpty); //excute sql statement.
        
        // is field existed?
        if(!rs.next()){
            isEmpty = true;
        } else{
            isEmpty = false;
        }
        return isEmpty;
     }
     
     //check is password right
     public boolean isCorrectPassword(String strEmail, String strPwd) throws SQLException{
        ResultSet rs;
        boolean isCorect = false;
        
        Statement stm = (Statement) conn.createStatement(); //create statement
        String sqlCheckEmpty = "SELECT * FROM member WHERE email = '"+strEmail+"' and password = '"+strPwd+"'";
        rs = stm.executeQuery(sqlCheckEmpty); //excute sql statement.
        
        // is field existed?
        if(!rs.next()){
            isCorect = true;
        } else{
            isCorect = false;
        }
        return isCorect;
     }
     
     //to search word from DB
     public ResultSet searchData(String tblName,String key)throws SQLException{
        ResultSet rs = null;
        
        //just to upper the first character of key.
        //String standardKey = key.substring(0,1).toUpperCase()+key.substring(1);
        //String standardKey = key.toLowerCase();
        Statement stm = (Statement) conn.createStatement();    //create query object
        String sqlSearchWord = "SELECT * FROM "+tblName+" WHERE word LIKE '"+key+"%'";
        rs = stm.executeQuery(sqlSearchWord);
        
        return rs;
     }
     
     //to get type of word from db
     public HashSet<String> getWordTypeOf(String tblName,String wordCompare) throws SQLException{
        ResultSet rs;
        String wordType = null;
        HashSet<String> listWordType = new HashSet<>(); //luu loai tu
        
        Statement stm = (Statement) conn.createStatement(); //tao doi tuong truy van
        String sqlSearchWordType = "SELECT * FROM "+tblName+" WHERE word = '"+wordCompare+"'";
        rs = stm.executeQuery(sqlSearchWordType); //thuc hien lenh sql
        while(rs.next()){
            wordType = rs.getString("wordtype");
            wordType.toLowerCase(); // standard String
            wordType.split(" ");    // cut white space
            
                    //check if type word is VERB
                if(wordType.contains("v")){
                     wordType = CommonDefine.VERB;
                     listWordType.add(wordType);
                }   
                    //check if type word is ADJECTIVE
                else if(wordType.contains("adj") || wordType.contains("superl")){
                     wordType = CommonDefine.ADJECTIVE;
                     listWordType.add(wordType);
                }   
                    //check if type word is ADJECTIVE
                else if(wordType.contains("adv")){
                     wordType = CommonDefine.ADJECTIVE;
                     listWordType.add(wordType);
                }   
                    //check if type word is CONJUNCTION
                else if(wordType.contains("conj")){
                     wordType = CommonDefine.CONJUNCTION;
                     listWordType.add(wordType);
                }   
                    //check if type word is INTERJECTION
                else if(wordType.contains("interj")){
                     wordType = CommonDefine.INTERJECTION;
                     listWordType.add(wordType);
                }   
                    //check if type word is PREPOSITION
                else if(wordType.contains("prep")){
                     wordType = CommonDefine.PREPOSITION;
                     listWordType.add(wordType);
                }   
                    //check if type word is PRONOUN
                else if(wordType.contains("pron")){
                     wordType = CommonDefine.PRONOUN;
                     listWordType.add(wordType);
                }   
                    //check if type word is NOUN
                else if(wordType.contains("n")){
                     wordType = CommonDefine.NOUN;
                     listWordType.add(wordType);
                }
        }
        return listWordType;
    }
     
     //used in RegisterFrm. Used to create an account for user.
     public String insertValuesToMember(String username, String email, String pwd) throws SQLException{
        String account = "";
        ResultSet rs;
        Statement stm = (Statement) conn.createStatement(); //tao doi tuong truy van
        String insertMember = "INSERT INTO member VALUES ('"+username+"','"+email+"','"+pwd+"')";
        stm.executeUpdate(insertMember); //thuc hien lenh sql
        
        String strSelectAccount = "select user_name from member where email = "+email;
        rs = stm.executeQuery(strSelectAccount);
        while(rs.next()){
            account = rs.getString("user_name");
        }
        this.strAccount = account;
        conn.close();
        return account;
     }
    
     //Used in LoginFrm. Used to get name of user to display in Demo screen
     public String getAccountFromLogin(String email) throws SQLException, ClassNotFoundException{
        ResultSet rs;
        String account = "";
        Statement stm = (Statement) conn.createStatement();
        String sqlGetAccount = "SELECT * FROM member WHERE email = '"+email+"'";
        rs = stm.executeQuery(sqlGetAccount); //thuc hien lenh sql
        while(rs.next()){
            account = rs.getString("user_name");
        }
        return account;
     }
     
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DatabaseHandles db1 = new DatabaseHandles();
        //ResultSet rs = db1.getData("entries");
        
      
        String rsAccount = db1.getAccountFromLogin("anhpham123@gmail.com");
        System.out.println(rsAccount);
        
//        String keyword;
//        System.out.println("Enter key: ");
//        Scanner sc = new Scanner(System.in);
//        keyword = sc.nextLine();
//        ResultSet rs = db1.searchData("entries", keyword);
//        
//        //display data from DB
//        while(rs.next()){
//             System.out.print(rs.getString("word"));//or getString(1) 
//             System.out.print("    ");
//             System.out.print(rs.getString("wordtype"));//or getString(2)
//             System.out.print("    ");
//             System.out.print(rs.getString("definition"));//or getString(3)
//             System.out.println("    ");
//             }
//            rs.close();
            
    }
}
