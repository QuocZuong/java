public class OTeacher extends teacher {
    private String donViCongTac;

    public String getDonViCongTac() {
        return donViCongTac;
    }

    public void setDonViCongTac(String donViCongTac) {
        this.donViCongTac = donViCongTac;
    }

    OTeacher() {

    }

    public OTeacher(int tempid, String tempname, String tempemail, String tempphoneNumber, String donViCongTac) {
        super(tempid, tempname, tempemail, tempphoneNumber);
        this.donViCongTac = donViCongTac;
    }

    public String toTring() {
        return " --" + donViCongTac + "\n";
    }

}
