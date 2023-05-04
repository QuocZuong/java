import java.util.Scanner;

public class intern extends candidate {
    private String Majors;
    private String Semester;
    private String Universityname;

    public intern() {
    }

    public intern(String candidateId, String firstName, String lastName, String birthDate, String address,
            String number,
            String email, int candidatetype, String Majors, String Semester, String Universityname) {
        super(candidateId, firstName, lastName, birthDate, address, number, email, candidatetype);
        this.Majors = Majors;
        this.Semester = Semester;
        this.Universityname = Universityname;
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversityname() {
        return Universityname;
    }

    public void setUniversityname(String universityname) {
        Universityname = universityname;
    }

    @Override
    public void nhapTT() {
        Scanner sc = new Scanner(System.in);
        super.nhapTT();
        String Majors;
        String Semester;
        String Universityname;

        System.out.print("Majors: ");
        Majors = sc.nextLine();

        System.out.print("Semester: ");
        Semester = sc.nextLine();

        System.out.print("University Name: ");
        Universityname = sc.nextLine();

        setMajors(Majors);
        setSemester(Semester);
        setUniversityname(Universityname);
    }
}
