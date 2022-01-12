package GUI;

import Controller.AdminController;
import Controller.PendudukController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DataPendGui extends JFrame {

    DataPendGui(int id){
        init(id);
    }

    public void init(int id){
        
        String pathicon = "./src/Gambar/Admin png.png";
         
        JButton btnKembali = new JButton("KEMBALI");
        btnKembali.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnKembali.setBounds(42, 25, 111, 35);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdminGui(id).setVisible(true);
                dispose();
            }
        });
        

        getContentPane().add(btnKembali);


        
        JTextField fieldNik = new JTextField();
        setBounds(100, 100, 886, 763);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        PendudukController penduduk = new PendudukController();
        JTable TablePenduduk = new JTable();
        JScrollPane spPenduduk = new JScrollPane(TablePenduduk);
        JTextField textpilih = new JTextField();


        AdminController admin = new AdminController();

        spPenduduk.setBounds(42, 70, 788, 420);
        TablePenduduk.setModel(penduduk.daftarpenduduk());
        add(spPenduduk);

        TablePenduduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = TablePenduduk.getSelectedRow();
                textpilih.setText(penduduk.daftarpenduduk().getValueAt(i, 0).toString());
            }
        });

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBackground(Color.red);
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnDelete.setBounds(42, 591, 200, 80);
        getContentPane().add(btnDelete);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textpilih.getText());
                admin.deleteData(id);
                TablePenduduk.setModel(penduduk.daftarpenduduk());
                JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");
            }
        });

        JLabel lblNewLabel = new JLabel("CEK DATA");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.BOLD, 24));
        lblNewLabel.setBounds(512, 542, 172, 37);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("MASUKKAN NIK");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1.setBounds(512, 596, 172, 37);
        getContentPane().add(lblNewLabel_1);
        
        fieldNik.setBounds(512, 645, 172, 31);
        getContentPane().add(fieldNik);
        fieldNik.setColumns(10);

        JButton btnCek = new JButton("CEK");
        btnCek.setBackground(Color.green);
        btnCek.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnCek.setBounds(724, 645, 85, 31);
        getContentPane().add(btnCek);

        btnCek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nik = fieldNik.getText();
                int cek = penduduk.CekData(nik);

                if(cek > 0){
                    new DataPeroranganGui(nik,id).setVisible(true);
                    dispose();

                }
            }
        });

        setVisible(true);
    }
}
