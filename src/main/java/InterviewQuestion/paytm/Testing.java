package InterviewQuestion.paytm;

public interface Testing {

    default void Sex() {}
    void sex1();
    static void Sex2(){

    }
    private void Sex3(){

    }
}
interface Bank{
    float rateOfInterest();
}
class SBI implements Bank{
    public float rateOfInterest(){return 9.15f;}
}
class PNB implements Bank{
    public float rateOfInterest(){return 9.7f;}
}
class TestInterface2{


    public static void main(String[] args){
        Bank b=new PNB();
        System.out.println("ROI: "+b.rateOfInterest());

    }
}
