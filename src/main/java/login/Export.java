/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author malli
 */
public class Export extends javax.swing.JFrame {
    
    void setImage(JLabel lab)
    {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("4 Extensions Supported","jpg","png","jpeg","gif");
        fileChooser.setFileFilter(filter);
        int selected = fileChooser.showOpenDialog(this);
        if(selected== JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            String getselectedImage= file.getAbsolutePath();
            JOptionPane.showMessageDialog(null, getselectedImage);
            ImageIcon imIco = new ImageIcon(getselectedImage );
            Image imFit= imIco.getImage();
            Image imgFit = imFit.getScaledInstance(lab.getWidth(), lab.getHeight(),Image.SCALE_SMOOTH );
            lab.setIcon(new ImageIcon(imgFit));
        }
    }
    
    void print(JPanel panel,String s) {
        try
        {
            if(s.isEmpty())
            {
                throw new Exception("Please Enter Title");
            }
        
      PrinterJob job= PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            if(pageNum>0){
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2=(Graphics2D)pg;
            g2.translate(pf.getImageableX(),pf.getImageableY());
            g2.scale(0.55,1);
            panel.paint(g2);
            return Printable.PAGE_EXISTS;
        });
        boolean ok=job.printDialog();
        if(ok){
            try{
                job.print();
            }
            catch(PrinterException ex){}
        }
    }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
