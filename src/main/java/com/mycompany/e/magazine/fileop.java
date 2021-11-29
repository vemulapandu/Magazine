/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.magazine;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author malli
 */
public class fileop {
    
    private static String filepath = "C:\\Users\\malli\\Documents\\NetBeansProjects\\E-Magazine\\src\\main\\java\\com\\mycompany\\e\\magazine\\user.txt";
    private static String filepath1 = "C:\\Users\\malli\\Documents\\NetBeansProjects\\E-Magazine\\src\\main\\java\\com\\mycompany\\e\\magazine\\nfuser.txt";
    private static String path;
    
    public static int getUserCount(){
        
        int a;
        try{
            File f = new File(getFilepath1());
            Scanner sc = new Scanner(f);
            String s = sc.nextLine();
            a = Integer.parseInt(s);
            sc.close();
            return a;
        }catch (IOException e){
            System.out.println("IO Exception Occured");
            e.printStackTrace();
            return -1;
        }
        
    }
    
    public static void addUser(user u){
        
        try {
            int a = getUserCount();
            if(a!=0){
                FileInputStream fi = new FileInputStream(new File(getFilepath()));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            user []v = new user[a];
            for(int i=0;i<a;i++){
                v[i] = (user)oi.readObject();
            }
            fi.close();
            oi.close();
            
            FileOutputStream f = new FileOutputStream(new File(getFilepath()));
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            for(int i=0;i<a;i++){
                o.writeObject(v[i]);
            }
            o.writeObject(u);

            o.close();
            f.close();
            }
            else{
                 FileOutputStream f = new FileOutputStream(new File(getFilepath()));
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(u);

                o.close();
                f.close();
            }

            } catch (FileNotFoundException e) {
		System.out.println("File not found");
            } catch (IOException e) {
		System.out.println("Error initializing stream");
	} catch  (ClassNotFoundException e){
            e.printStackTrace();
        }
        increaseUserCount();
        
    }
    
    public static user getUser(String s) {
    	
    	user v = new user();
    	v.setName(" ");
    	int a = getUserCount();
        try{
            FileInputStream f = new FileInputStream(new File(getFilepath()));
            ObjectInputStream o = new ObjectInputStream(f);
            for(int i=0;i<a;i++){
                user u = (user)o.readObject();
                if(u.getUsername().equals(s)){
                    f.close();
                    o.close();
                    return u;
                }
            }
            f.close();
            o.close();
            return v;
        } catch (FileNotFoundException e) {
		System.out.println("File not found");
		return v;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
		return v;
	} catch  (ClassNotFoundException e){
            e.printStackTrace();
            return v;
        }
    	
    }
    
    public static void increaseUserCount(){
        
        try{
            int a = getUserCount();a=a+1;
            String s = Integer.toString(a);
            FileWriter fw = new FileWriter(getFilepath1());
            fw.write(s);
            fw.close();
        }catch (IOException e){
            System.out.println("IO Exception Occured");
            e.printStackTrace();
        }
        
    }
    
    public static boolean checkUsername(String s){
        
        int a = getUserCount();
        if(a==0)return true;
        try{
            FileInputStream f = new FileInputStream(new File(getFilepath()));
            ObjectInputStream o = new ObjectInputStream(f);
            for(int i=0;i<a;i++){
                user u = (user)o.readObject();
                if(u.getUsername().equals(s)){
                    f.close();
                    o.close();
                    return false;
                }
            }
            f.close();
            o.close();
            return true;
        } catch (FileNotFoundException e) {
		System.out.println("File not found");
                return false;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
                return false;
	} catch  (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public static boolean checkEmail(String s){
        
        int a = getUserCount();
        if(a==0)return true;
        try{
            FileInputStream f = new FileInputStream(new File(getFilepath()));
            ObjectInputStream o = new ObjectInputStream(f);
            for(int i=0;i<a;i++){
                user u = (user)o.readObject();
                if(u.getEmail().equals(s)){
                    f.close();
                    o.close();
                    return false;
                }
            }
            f.close();
            o.close();
            return true;
        } catch (FileNotFoundException e) {
		System.out.println("File not found");
                return false;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
                return false;
	} catch  (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public static boolean verify(String us, String p){
        
        int a = getUserCount();
        try{
            FileInputStream f = new FileInputStream(new File(getFilepath()));
            ObjectInputStream o = new ObjectInputStream(f);
            for(int i=0;i<a;i++){
                user u = (user)o.readObject();
                System.out.println(u.toString());
                if(u.getUsername().equals(us)&&u.getPassword().equals(p)){
                    f.close();
                    o.close();
                    return true;
                }
            }
            f.close();
            o.close();
            return false;
        } catch (FileNotFoundException e) {
		System.out.println("File not found");
                return false;
	} catch (IOException e) {
		System.out.println("Error initializing stream");
                return false;
	} catch  (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public static void changePasseord(String username, String password){
        
        try {
            int a = getUserCount();
            FileInputStream fi = new FileInputStream(new File(getFilepath()));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            user []v = new user[a];
            for(int i=0;i<a;i++){
                v[i] = (user)oi.readObject();
                if(v[i].getUsername().equals(username)){
                    v[i].setPassword(password);
                }
            }
            fi.close();
            oi.close();
            
            FileOutputStream f = new FileOutputStream(new File(getFilepath()));
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            for(int i=0;i<a;i++){
                o.writeObject(v[i]);
            }

            o.close();
            f.close();
            

            } catch (FileNotFoundException e) {
		System.out.println("File not found");
            } catch (IOException e) {
		System.out.println("Error initializing stream");
	} catch  (ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    public static String getPath(){
        
        File f =  new File("path.txt");
        String s = f.getAbsolutePath();
        path = s.substring(0,s.length()-8) + "src\\main\\java\\com\\mycompany\\e\\magazine\\";
        f.delete();
        return path;
        
    }
    
    private static String getFilepath(){
        return getPath()+"user.txt";
    }
    
    private static String getFilepath1(){
        return getPath()+"nfuser.txt";
    }
    
    public static void main(String args[]){
        
        
        
    }
    
}
