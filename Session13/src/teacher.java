
public class teacher {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String donViCongTac;

    public String getDonViCongTac() {
        return donViCongTac;
    }

    public void setDonViCongTac(String donViCongTac) {
        this.donViCongTac = donViCongTac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    teacher() {

    }

    teacher(int tempid, String tempname, String tempemail, String tempphoneNumber) {
        this.id = tempid;
        this.name = tempname;
        this.email = tempemail;
        this.phoneNumber = tempphoneNumber;
    }

}