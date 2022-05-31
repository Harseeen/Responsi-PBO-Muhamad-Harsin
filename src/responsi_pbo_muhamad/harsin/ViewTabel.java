/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_pbo_muhamad.harsin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class ViewTabel extends JFrame implements ActionListener{
    JLabel lnama = new JLabel("Nama");
    JLabel lportofolio = new JLabel("Portofolio");
    JLabel lmicroteaching = new JLabel("icroteaching");
    JLabel lwawancara = new JLabel("Wawancara");
    
    public JTextField tfNama = new JTextField();
    public JTextField tfportofolio = new JTextField();
    public JTextField tfmicroteaching = new JTextField();
    public JTextField tfwawancara = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nama", "Nilai Portofolio", "Nilai icroteaching", "Wawancara", "Nilai Akhir"};

    public ViewTabel() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Aslab");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lnama);
        lnama.setBounds(510, 20, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 40, 120, 20);
        
        add(lportofolio);
        lportofolio.setBounds(510, 60, 90, 20);
        add(tfportofolio);
        tfportofolio.setBounds(510, 80, 120, 20);
        
        add(lmicroteaching);
        lmicroteaching.setBounds(510, 100, 90, 20);
        add(tfmicroteaching);
        tfmicroteaching.setBounds(510, 120, 120, 20);
        
        add(lwawancara);
        lwawancara.setBounds(510, 140, 90, 20);
        add(tfwawancara);
        tfwawancara.setBounds(510, 160, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
        btnReset.addActionListener(this);
    }
    
     public void actionPerformed(ActionEvent e) {
     if(e.getSource() == btnReset){
            tfNama.setText("");
            tfportofolio.setText("");
            tfmicroteaching.setText("");
            tfwawancara.setText("");
                
        }
     }
    
    
    
    public String getNama(){
        return tfNama.getText();
    }
    
    public String getportofolio(){
        return tfportofolio.getText();
    }
    
    public String getmicroteaching(){
        return tfmicroteaching.getText();
    }
    
    public String getwawancara(){
        return tfwawancara.getText();
    }
}
