import java.util.Scanner;

public class fresher extends candidate {
    private String Graduation_date;
    private String Graduation_rank;
    private String Education;

    public fresher() {

    }

    public fresher(String candidateId, String firstName, String lastName, String birthDate, String address,
            String number,
            String email, int candidatetype, String graduation_date, String graduation_rank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, number, email, candidatetype);
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Education = education;
    }

    public void setGraduation_date(String graduation_date) {
        Graduation_date = graduation_date;
    }

    public String getGraduation_date() {
        return Graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public void nhapTT() {
        Scanner sc = new Scanner(System.in);
        String Graduation_date;
        String Graduation_rank = "";
        String Education;

        boolean Graduation_rankWrong = true;
        super.nhapTT();

        System.out.print("Graduation date: ");
        Graduation_date = sc.nextLine();

        do {
            Graduation_rankWrong = false;
            System.out.print("Candidate Type: ");
            try {

                Graduation_rank = sc.nextLine();

                if (!Graduation_rank.equalsIgnoreCase("excellence") && !Graduation_rank.equalsIgnoreCase("good")
                        && !Graduation_rank.equalsIgnoreCase("fair") && !Graduation_rank.equalsIgnoreCase("poor")) {
                    Graduation_rankWrong = true;
                }

                if (Graduation_rankWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: Graduation rank khong hop le");
                Graduation_rankWrong = true;

            }
        } while (Graduation_rankWrong);
        System.out.print("University where graduated: ");
        Education = sc.nextLine();
        setGraduation_date(Graduation_date);
        setGraduation_rank(Graduation_rank);
        setEducation(Education);
    }
}
