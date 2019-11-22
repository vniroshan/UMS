public class Student
{
    private int id;
    private String stdName;
    private int stdAge;
    private String userName;
    private String passowrd;
    private String cource;

    public Student() {
    }

    public Student(int id, String stdName, int stdAge, String userName, String passowrd, String cource) {
        this.id = id;
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.userName = userName;
        this.passowrd = passowrd;
        this.cource = cource;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }


}
