//package pendataanvaksinasi;
//import Controller.AdminController;
//import Controller.PendudukController;
//import Entity.PendudukEntity;
//import java.util.Scanner;
//
//public class PendataanVaksinasi {
//    public static Scanner input = new Scanner (System.in);
//public static PendudukController pendudukController = new PendudukController();
//public static AdminController adminController = new AdminController();
//    public static void main(String[] args) {
//       int pil;
//       do{
//        System.out.println("SELAMAT DATANG DI PROGRAM PENDATAAN VAKSINASI");
//        System.out.println("1.Login");
//        System.out.println("2.registrasi");
//        System.out.println("3.Keluar");
//        pil = input.nextInt();
//        input.nextLine();
//        switch(pil){
//            case 1:
//                loginAdmin();
//                break;
//            case 2:
//                regisData();
//                break;
//            case 3:
//                System.out.println("Berhasil keluar");
//        }
//        }while(pil<=2);
//    }
//
//    static void loginAdmin() {
//        int pil;
//        String nip, password;
//
//        System.out.println("Masukkan NIP: ");
//        nip = input.nextLine();
//        System.out.println("Masukkan Password: ");
//        password = input.next();
//        int cek = adminController.login(nip, password);
//        if (cek != 0) {
//            System.out.println("Berhasil Login");
//            menu();
//        } else {
//            System.out.println("Gagal Login");
//        }
//    }
//
//    static void menu() {
//        int pil;
//        do {
//            System.out.println("1. ADMIN");
//            System.out.println("2. PENDUDUK");
//            System.out.println("Masukkan Inputan: ");
//            pil = input.nextInt();
//
//            switch (pil) {
//                case 1:
//                    menuAdmin();
//                    break;
//                case 2:
//                    menuPenduduk();
//                    break;
//            }
//        } while (pil != 0);
//    }
//
//    static void menuAdmin() {
//        int pil;
//        do {
//            System.out.println("1. Update Passwordd");
//            System.out.println("2. Update NoTelp");
//            System.out.println("3. Hapus Data");
//            System.out.println("0. Log Out");
//            System.out.print("Pilih: ");
//            pil = input.nextInt();
//            input.nextLine();
//            switch (pil) {
//                case 1:
//                    updatepassword();
//                    break;
//                case 2:
//                    updatenotelp();
//                    break;
//                case 3:
//                    deleteData();
//                    break;
//            }
//        } while (pil != 0);
//    }
//
//    static void regisData() {
//        int id;
//        String nip, nama, alamat, password, noTelp;
//
//        System.out.println("Masukkan id: ");
//        id = input.nextInt();
//        input.nextLine();
//        System.out.println("Masukkan NIP: ");
//        nip = input.nextLine();
//        System.out.println("Masukkan Nama: ");
//        nama = input.nextLine();
//        System.out.println("Masukkan Alamat: ");
//        alamat = input.nextLine();
//        System.out.println("Masukkan Password: ");
//        password = input.nextLine();
//        System.out.println("Masukkan No Telp: ");
//        noTelp = input.nextLine();
//
//        adminController.insertData(nip, nama, alamat, password, noTelp);
//    }
//
//    static void updatepassword() {
//        String password;
//        int id;
//        System.out.println("Masukkan id: ");
//        id = input.nextInt();
//        input.nextLine();
//        System.out.println("Masukkan password baru: ");
//        password = input.nextLine();
//        adminController.updatePassword(password, id);
//    }
//
//    static void updatenotelp() {
//        String noTelp;
//        int id;
//        System.out.println("Masukkan id: ");
//        id = input.nextInt();
//        input.nextLine();
//        System.out.println("Masukkan No Telp baru: ");
//        noTelp = input.nextLine();
//        adminController.updateNoTelp(noTelp, id);
//    }
//
//    static void deleteData() {
//        System.out.print("Masukkan id yang ingin dihapus: ");
//        int id = input.nextInt();
//        adminController.deleteData(id);
//    }
//
//    static void menuPenduduk() {
//        int pil;
//        do {
//            System.out.println("1. Insert Data penduduk");
//            System.out.println("2. Update Dosis");
//            System.out.println("3. Update NoTelp");
//            System.out.println("4. Lihat Data");
//            System.out.println("5. Lihat Data Berdasarkan id");
//            System.out.println("6. Cek Data");
//            System.out.println("0. Log Out");
//            System.out.print("Pilih: ");
//            pil = input.nextInt();
//            input.nextLine();
//            switch (pil) {
//                case 1:
//                    insertPenduduk();
//                    break;
//                case 2:
//                    updateDosis();
//                    break;
//                case 3:
//                    updatenotelpPenduduk();
//                    break;
//                case 4:
//                    showData();
//                    break;
//                case 5:
//                    System.out.println("Masukkan ID: ");
//                    int id = input.nextInt();
//                    showData(id);
//                    break;
//                case 6:
//                    CekData();
//                    break;
//            }
//        } while (pil != 0);
//    }
//
//    static void insertPenduduk() {
//        System.out.println("Masukkan NIK: ");
//        String nik = input.nextLine();
//        System.out.println("Masukkan Nama: ");
//        String nama = input.nextLine();
//        System.out.println("Masukkan Alamat: ");
//        String alamat = input.nextLine();
//        System.out.println("Masukkan No Telp: ");
//        String noTelp = input.nextLine();
//        System.out.print("Masukkan dosis: ");
//        String dosis = input.nextLine();
//        System.out.print("Masukkan Jenis Vaksin: ");
//        String vaksin = input.next();
//
//        pendudukController.insertData(nik, nama, alamat, noTelp, dosis, vaksin);
//    }
//
//    static void updateDosis() {
//        System.out.print("Masukkan id: ");
//        int id = input.nextInt();
//        System.out.print("Masukkan Dosis baru: ");
//        String dosis = input.next();
//        pendudukController.updateDosis(dosis, id);
//    }
//
//    static void updatenotelpPenduduk() {
//        String noTelp;
//        int id;
//        System.out.println("Masukkan id: ");
//        id = input.nextInt();
//        input.nextLine();
//        System.out.println("Masukkan No Telp baru: ");
//        noTelp = input.nextLine();
//        pendudukController.updatenoTelp(noTelp, id);
//    }
//
//    static void showData() {
//        for (PendudukEntity pendudukEntity : pendudukController.getDataPenduduk()) {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Id : " + pendudukEntity.getId());
//            System.out.println("Nama : " + pendudukEntity.getNama());
//            System.out.println("Alamat : " + pendudukEntity.getAlamat());
//            System.out.println("No Telp : " + pendudukEntity.getNoTelp());
//            System.out.println("NIK : " + pendudukEntity.getNik());
//            System.out.println("Dosis: " + pendudukEntity.getdosis());
//            System.out.println("Jenis Vaksin :  " + pendudukEntity.getjenisvaksin());
//            System.out.println("--------------------------------------------------");
//        }
//
//    }
//
//    static void showData(int id){
//        for (PendudukEntity pendudukEntity : pendudukController.getDataPenduduk()) {
//            System.out.println("--------------------------------------------------");
//            System.out.println("Id : " + pendudukEntity.getId());
//            System.out.println("Nama : " + pendudukEntity.getNama());
//            System.out.println("Alamat : " + pendudukEntity.getAlamat());
//            System.out.println("No Telp : " + pendudukEntity.getNoTelp());
//            System.out.println("NIK : " + pendudukEntity.getNik());
//            System.out.println("Dosis: " + pendudukEntity.getdosis());
//            System.out.println("Jenis Vaksin :  " + pendudukEntity.getjenisvaksin());
//            System.out.println("--------------------------------------------------");
//        }
//    }
//
//
//    static void CekData(){
//        System.out.print("Masukkan nik yang ingin di cek: ");
//        String nik = input.nextLine();
//        int cek = pendudukController.CekData(nik);
//
//        if(cek > 0){
//            System.out.println("Data Tersedia");
//            showData(cek);
//        }else{
//            System.out.println("Data Tidak Tersedia");
//        }
//
//    }
//}
