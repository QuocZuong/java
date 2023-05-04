import java.util.Scanner;

public class student implements PersonAction {
    private String id;
    private String name;
    private String email;
    private float GPA;

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float gPA) {
        GPA = gPA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void NhapTT() {
        Scanner sc = new Scanner(System.in);
        String tempid = "";
        String tempname = "";
        String tempemail = "";
        float tempGPA = 0;
        boolean idWrong = true;
        boolean nameWrong = true;
        int countSpaceForName = 0;
        boolean GPAWrong = true;

        studentManagement management = new studentManagement();

        System.out.println("--Nhap TT Nhan vien--");

        do {

            try {
                idWrong = false;
                System.out.print("Ma: ");
                tempid = sc.nextLine();

                for (student student : management.storageEmployee) {
                    if (student.getId().equals(tempid)) {
                        idWrong = true;
                    }
                }

                if (!tempid.matches("[a-zA-Z]{2}[0-9]+")) {
                    idWrong = true;
                }

                if (idWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: ma sinh vien khong hop le. Vui long nhap lai");
                idWrong = true;

            }
        } while (idWrong);

        do {

            try {
                nameWrong = false;
                System.out.print("Ho ten: ");

                tempname = sc.nextLine();
                char chars[] = String.valueOf(tempname).toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (!((chars[i] >= 'A' && chars[i] <= 'Z')
                            || (chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] == ' '))) {
                        nameWrong = true;
                    }
                    if (chars[i] == ' ' && ((chars[i + 1] >= 'A' && chars[i + 1] <= 'Z')
                            || (chars[i + 1] >= 'a' && chars[i + 1] <= 'z'))) {
                        countSpaceForName++;
                    }
                }
                if (countSpaceForName == 0) {
                    nameWrong = true;
                }
                if (nameWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: ho ten khong hop le. Vui long nhap lai");
                nameWrong = true;

            }
        } while (nameWrong);

        System.out.print("Email: ");
        tempemail = sc.nextLine();

        do {

            try {
                GPAWrong = false;
                System.out.print("GPA: ");
                tempGPA = Float.parseFloat(sc.nextLine());

                if (GPAWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: GPA khong hop le. Vui long nhap lai");
                GPAWrong = true;

            }
        } while (GPAWrong);

        setId(tempid);
        setName(tempname);
        setEmail(tempemail);
        setGPA(tempGPA);

        System.out.println("---------------------------------");
    }

    @Override
    public void InTT() {
        System.out.printf("%s -- %s -- %s -- %s\n", getId(), getName(), getEmail(),
                getGPA());
    }

}
