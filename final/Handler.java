import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Handler {

    public int amountPass(String[] arr) {
        if(arr.length < 6) {
            return -1;
        } else if (arr.length > 6) {
            return -2;
        }
        else { 
            return 0;
        }
    }
    
    public String entryData() {
        String user = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные пользователя по типу: Фамилия Имя Отчество датарождения номертелефона пол(m/f) ");
        String console = sc.nextLine();
        String[] s = console.split(" ");
        int ans = amountPass(s);
        switch (ans) {
            case -1:
                System.out.println("Вы ввели меньшее количество запрашиваемых данных");
                break;
            case -2:
                System.out.println("Вы ввели больше данных");
                break;
            default:
                System.out.println("check succeeded");
        }
        String a = s[0];
        if(a.length() > 3) {
                if(a.matches("^[a-zA-Z]*$")) {
                    user += "<"+ a+">";  
                }
                else {
                    System.out.println("В фамилии не только буквы");
                }
            } else {
                System.out.println("В поле 'фамилия' мало символов");
            }
            String b = s[1];
            if(b.length() > 3) {
                if(b.matches("^[a-zA-Z]*$")) {
                     user += " <"+b +">";
                }
                else {
                    System.out.println("В имени не только буквы");
                }
            }
             else {
                 System.out.println("В поле 'имя' не хватает символов");
            }
            String c = s[2];
            if(c.length() > 3) {
                if(c.matches("^[a-zA-Z]*$")) {
                     user += " <"+ c+">";
                }
                else {
                    System.out.println("В отчестве не только буквы");
                }
            }
             else {
                System.out.println("В поле 'отчество' не хватает символов");
            }
            
            String d = s[3];
            if(d.length()==10 & d.indexOf(".")==2 & d.indexOf(".", 3)==5) {
                 user += " <" +d +">";
            }
            else {
                System.out.println("Введена неверная дата не в формате дд.мм.ггг");
            }

            int e = Integer.parseInt(s[4]);
            if(e/10000000 > 1 & e/100000000 < 1 ) {
                user += " <" +e +">";
            }
            else {
                System.out.println("номер телефона должен быть только из 8-ми цифр");
            }
            
            String f = s[5];
            if(f.equals("m") | f.equals("f")) {
                user += " <" +f +">";
            }
            else {
                System.out.println("Пожалуйста, введите пол только через m/f");
            }
            sc.close();
            int z = user.split(" ").length;
            if(z < 6) {
                return null;
            } else {
                return user;
            } 
        }


    public void writeFile(String data) {
        String[] arr = data.split(" ");
        String path = arr[0].substring(1, arr[0].length() - 1) + ".txt";
        System.out.println(path);
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(data);
            fw.close();
        }
         catch (IOException ex) {
            System.out.println(ex.getMessage());
            }
     }

}