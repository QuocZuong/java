import java.util.Scanner;

public class experience extends candidate {
    private int ExpInYear;
    private String ProSkill;

    public experience() {

    }

    public experience(String candidateId, String firstName, String lastName, String birthDate, String address,
            String number,
            String email, int candidatetype, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, number, email, candidatetype);
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public void nhapTT() {
        super.nhapTT();
        Scanner sc = new Scanner(System.in);
        String ExpInYear = "";
        String ProSkill;

        boolean ExpInYearWrong = true;
        do {
            ExpInYearWrong = false;
            System.out.print("Year of experience: ");
            try {

                ExpInYear = sc.nextLine();

                if (!ExpInYear.matches("^[0-9]+$") || Integer.parseInt(ExpInYear) < 0
                        || Integer.parseInt(ExpInYear) > 100) {
                    ExpInYearWrong = true;
                }

                if (ExpInYearWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: Year of experience khong hop le");
                ExpInYearWrong = true;

            }
        } while (ExpInYearWrong);

        System.out.print("Pro Skill: ");
        ProSkill = sc.nextLine();
        setExpInYear(Integer.parseInt(ExpInYear));
        setProSkill(ProSkill);
    }
}
