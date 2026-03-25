package entity;

public class Student extends Person{

//    id, firstName, lastName, email, batch, active
    private String batch;
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch, boolean active){
        super(id,firstName, lastName, email);
        this.batch=batch;
        this.active=active;
    }
    public Student(int id, String firstName,String lastName, String batch,boolean active){
        super(id, firstName, lastName);
        this.batch=batch;
        this.active=active;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void getDisplayName(){
        System.out.println("Student Id:"+getId());
        System.out.println("Student Name:"+getFirstName()+getLastName());
    }
}
