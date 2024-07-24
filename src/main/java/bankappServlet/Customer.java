package bankappServlet;

public class Customer {
    private String fullname;    // Corresponds to 'fullname'
    private String address;     // Corresponds to 'address'
    private String phono;       // Corresponds to 'phono'
    private String emailid;     // Corresponds to 'Emailid'
    private String dob;         // Corresponds to 'DOB'
    private String accountno;   // Corresponds to 'Accountno'
    private String accounttype; // Corresponds to 'Accounttype'
    private String password;    // Corresponds to 'Password'
    private double balance;     // Corresponds to 'Balance'
    private String idProof;     // Corresponds to 'IdProof'

    // Getters and setters
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhono() {
        return phono;
    }

    public void setPhono(String phono) {
        this.phono = phono;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }
}
