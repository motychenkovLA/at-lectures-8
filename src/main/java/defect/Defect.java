package defect;

public class Defect {
    private static int initialId = 1000000;
    private long id = initialId++;
    private String resume;
    private String strict;
    private int days;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getResume(){
        return resume;
    }

    public void setResume(String resume){
        this.resume = resume;
    }


    public String getStrict(){
        return strict;
    }

    public void setStrict(String strict){
        this.strict = strict;
    }

    public int getDays(){
        return days;
    }

    public void setDays(int days){
        this.days = days;
    }


    public Defect() {}

    public Defect(String resume, String strict, int days){
        this.setResume(resume);
        this.setStrict(strict);
        this.setDays(days);
    }

    public void getInfo(){
        System.out.println("id: " + this.getId());
        System.out.println("resume: " + this.getResume());
        System.out.println("strict: " + this.getStrict());
        System.out.println("days: " + this.getDays());
        System.out.println("---------------------");
    }

}
