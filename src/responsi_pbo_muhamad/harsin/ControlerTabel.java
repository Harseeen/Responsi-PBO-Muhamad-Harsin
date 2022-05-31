/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_pbo_muhamad.harsin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Lenovo
 */
public class ControlerTabel {
     ModelTabel  modelTabel;
     ViewTabel ViewTabel;
     
     public String dataterpilih;
     
    public ControlerTabel(ModelTabel modelTabel, ViewTabel ViewTabel) {
        this.modelTabel = modelTabel;
        this.ViewTabel = ViewTabel;
    
        
        if (modelTabel.getBanyakData()!=0) {
            String dataTabel[][] = modelTabel.TabelList();
            ViewTabel.tabel.setModel((new JTable(dataTabel, ViewTabel.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
         ViewTabel.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = ViewTabel.getNama();
                String portofolio = ViewTabel.getportofolio();
                String microteaching = ViewTabel.getmicroteaching();
                String wawancara = ViewTabel.getwawancara();
                modelTabel.insertmovie(nama, portofolio, microteaching, wawancara);
         
            String dataTabel[][] = modelTabel.TabelList();
            ViewTabel.tabel.setModel((new JTable(dataTabel, ViewTabel.namaKolom)).getModel());
            }
        });
    
          ViewTabel.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 String nama = ViewTabel.getNama();
                String portofolio = ViewTabel.getportofolio();
                String microteaching = ViewTabel.getmicroteaching();
                String wawancara = ViewTabel.getwawancara();
                modelTabel.updateTabel(nama, portofolio, microteaching, wawancara);
                
                String dataTabel[][] = modelTabel.TabelList();
            ViewTabel.tabel.setModel((new JTable(dataTabel, ViewTabel.namaKolom)).getModel());
            }
        });
    
    
    ViewTabel.tabel.addMouseListener(new MouseAdapter(){    
        public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = ViewTabel.tabel.getSelectedRow();

                dataterpilih = ViewTabel.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
    }
            
 });
    
    ViewTabel.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Film " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelTabel.deleteTabel(dataterpilih);
                    String dataTabel[][] = modelTabel.TabelList();
                    ViewTabel.tabel.setModel((new JTable(dataTabel, ViewTabel.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
    
    
}
}
