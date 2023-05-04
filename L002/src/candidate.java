import java.util.Scanner;

public class candidate {

    private String CandidateId;
    private String FirstName;
    private String LastName;
    private String BirthDate;
    private String Address;
    private String phone;
    private String Email;
    private int Candidatetype;

    public candidate() {

    }

    public candidate(String candidateId, String firstName, String lastName, String birthDate, String address,
            String phone,
            String email, int candidatetype) {
        this.CandidateId = candidateId;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.BirthDate = birthDate;
        this.Address = address;
        this.phone = phone;
        this.Email = email;
        this.Candidatetype = candidatetype;
    }

    public String getCandidateId() {
        return CandidateId;
    }

    public void setCandidateId(String candidateId) {
        CandidateId = candidateId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getCandidatetype() {
        return Candidatetype;
    }

    public void setCandidatetype(int candidatetype) {
        Candidatetype = candidatetype;
    }

    public void nhapTT() {
        Scanner sc = new Scanner(System.in);
        String CandidateId;
        String FirstName;
        String LastName;
        String BirthDate = "";
        String Address;
        String phone = "";
        String Email = "";
        int Candidatetype = -1;

        boolean BirthDateWrong = true;
        boolean phoneWrong = true;
        boolean mailWrong = true;
        boolean CandidatetypeWrong = true;

        System.out.print("Candidate ID: ");
        CandidateId = sc.nextLine();

        System.out.print("First Name: ");
        FirstName = sc.nextLine();

        System.out.print("Last Name: ");
        LastName = sc.nextLine();

        do {

            try {
                BirthDateWrong = false;
                System.out.print("Ngay sinh: ");
                BirthDate = sc.nextLine();

                if ((!(BirthDate.matches("^(0[1-9]|[1-2][0-9]|3[0-1])[/-](0[1-9]|1[0-2])[/-](19|20)[0-9]{2}$")))) {
                    BirthDateWrong = true;
                }

                if (BirthDateWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: ngay sinh khong hop le");
                BirthDateWrong = true;

            }
        } while (BirthDateWrong);

        System.out.print("Address: ");
        Address = sc.nextLine();

        do {
            phoneWrong = false;
            System.out.print("Phone: ");
            try {

                phone = sc.nextLine();

                if (phone.matches("/^[0-9]{10}")) {
                    phoneWrong = true;
                }

                if (phoneWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: so dien thoai khong hop le");
                phoneWrong = true;

            }
        } while (phoneWrong);

        do {
            mailWrong = false;
            System.out.print("Email: ");
            try {

                Email = sc.nextLine();

                if (!Email.matches("^[0-9a-zA-Z]+@+[a-zA-Z]+.+[a-zA-Z]$")) {
                    mailWrong = true;
                }

                if (mailWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: email khong hop le");
                mailWrong = true;

            }
        } while (mailWrong);

        do {
            CandidatetypeWrong = false;
            System.out.print("Candidate Type: ");
            try {

                Candidatetype = Integer.parseInt(sc.nextLine());

                if (Candidatetype < 0 || Candidatetype > 2) {
                    CandidatetypeWrong = true;
                }

                if (CandidatetypeWrong) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: candidate type khong hop le");
                CandidatetypeWrong = true;

            }
        } while (CandidatetypeWrong);

        setCandidateId(CandidateId);
        setFirstName(FirstName);
        setLastName(LastName);
        setBirthDate(BirthDate);
        setAddress(Address);
        setPhone(phone);
        setEmail(Email);
        setCandidatetype(Candidatetype);
    }

}
