package View;

import Controller.Controller_DanhBa;
import Controller.IO_File_DanhBa;
import Controller.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Person;

public class main_DanhBa {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Controller_DanhBa controller_danhBa = new Controller_DanhBa();
        IO_File_DanhBa io_file_danhBa = new IO_File_DanhBa();
        Model model = new Model();

        ArrayList listText = io_file_danhBa.readFile();

        ArrayList<Person> listDanhBa = controller_danhBa.addInClassDB(listText);

        menu( scanner, listDanhBa, model, controller_danhBa, listText, io_file_danhBa);

    }

    public static void menu(Scanner scanner, ArrayList<Person> listDanhBa, Model model, Controller_DanhBa controller_danhBa, ArrayList listText, IO_File_DanhBa io_file_danhBa) throws IOException {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số :");
        System.out.println("1 . Danh sách danh bạ");
        System.out.println("2 . Thêm mới danh bạ");
        System.out.println("3 . Cập nhật danh bạ");
        System.out.println("4 . Xóa danh bạ");
        System.out.println("5 . Tìm kiếm");
        System.out.println("6 . đọc từ File");
        System.out.println("7 . ghi vào File");
        System.out.println("8 . thoát");
        System.out.println("Chọn chức năng :");

        int key = scanner.nextInt();

        switch (key) {
            case 1:
                model.displayDanhBa(listDanhBa);
                break;
            case 2:
                scanner.nextLine();
                model.inputThongTin(scanner, controller_danhBa, listDanhBa);
                model.displayDanhBa(listDanhBa);
                break;
            case 3:
                scanner.nextLine();
                model.editThongTin(scanner, controller_danhBa, listDanhBa);
                model.displayDanhBa(listDanhBa);
                break;
            case 4:
                scanner.nextLine();
                model.delete_Danhsach(scanner, controller_danhBa, listDanhBa);
                model.displayDanhBa(listDanhBa);
                break;
            case 5:
                scanner.nextLine();
                model.seachPhone(scanner, controller_danhBa, listDanhBa);
                model.displayDanhBa(listDanhBa);
                break;
            case 6:
                listText = io_file_danhBa.readFile();
                break;
            case 7:
                io_file_danhBa.writeFile(listDanhBa);
                listDanhBa = controller_danhBa.addInClassDB(listText);
                break;
            case 8:
                System.exit(0);
                break;
        }
        menu(scanner, listDanhBa, model, controller_danhBa, listText, io_file_danhBa);
    }
}
