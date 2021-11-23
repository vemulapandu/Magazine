/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author malli
 */
public class fileop {
    
    public static void main(String args[]){
//        File fi = new File("C:\\Users\\malli\\Documents\\NetBeansProjects\\Magazine\\src\\main\\java\\login\\user.txt");
        user u = new user();
        u.setName("Mallik");
        u.setUsername("vemulapandu");
        u.setPassword("indigoleague");
        u.setEmail("mallik.prabhanjan@gmail.com");
        
        try{
            FileOutputStream f1 = new FileOutputStream(new File("C:\\Users\\malli\\Documents\\NetBeansProjects\\Magazine\\src\\main\\java\\login\\user.txt"));
            ObjectOutputStream o1 = new ObjectOutputStream(f1);
            
            o1.writeObject(u);
            
            f1.close();
            o1.close();
            
            FileInputStream f2 = new FileInputStream(new File("C:\\Users\\malli\\Documents\\NetBeansProjects\\Magazine\\src\\main\\java\\login\\user.txt"));
            ObjectInputStream o2 = new ObjectInputStream(f2);
            
            System.out.println(o2.available());
            
            user u1 = (user)o2.readObject();
//            user u2 = (user)o2.readObject();
            System.out.println(u1.toString());
//            System.out.println(u2.toString());
            System.out.println(u1.getName());
            
            System.out.println(o2.available());
            
            f2.close();
            o2.close();
            
        } catch (FileNotFoundException e) {
		System.out.println("File not found");
	} catch (IOException e) {
		System.out.println("Error initializing stream");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}     
    }
    
}
