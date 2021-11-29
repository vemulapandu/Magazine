/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.magazine;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author malli
 */
public class export extends JFrame {
    
    public static boolean uploadImage(JLabel jl){
        
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter ff = new FileNameExtensionFilter("Choose a jpg/jpeg/png file","jpg","jpeg","png");
        jf.setFileFilter(ff);
        int a = jf.showOpenDialog(jf);
        if(a==JFileChooser.APPROVE_OPTION){
            File f = jf.getSelectedFile();
            String s = f.getAbsolutePath();
            ImageIcon ic = new ImageIcon(s);
            Image i = ic.getImage();
            i = i.getScaledInstance(jl.getWidth(), jl.getHeight(), Image.SCALE_SMOOTH);
            jl.setIcon(new ImageIcon(i));
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public static void redirect(String s){
        
        Desktop d = Desktop.getDesktop();
        try{
            d.browse(new URI(s));
        }catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void exportPanel(JPanel jp){
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName("Print Panel");
        pj.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            if(pageNum>0){
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2=(Graphics2D)pg;
            g2.translate(pf.getImageableX(),pf.getImageableY());
            g2.scale(0.9,1);
            jp.paint(g2);
            return Printable.PAGE_EXISTS;
        });
        if(pj.printDialog()){
            try{
                pj.print();
            }catch(PrinterException e){
                e.printStackTrace();
            }
        }
        
    }
    
}
