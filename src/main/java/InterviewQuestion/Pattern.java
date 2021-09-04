package InterviewQuestion;

/*
200
400 600
300
600 900 1200
400
800 1200 1600 2000
*/

public class Pattern {
    public static void main(String[] args) {
        pattern1(); //asked in digitek Software for salesforces
    }

    private static void pattern1(){
        int initialnumber=200;
        int flag =1;
        int k=0;
        for(int i=1;i<=6;i++){
            if(i%2==0){  //only even go
                int evenline=initialnumber*2;
                int temp=++flag;  //2
                for(int j=evenline;flag>0;j=j+200+k ){
                    System.out.print(j +" ");
                    flag--;
                }
                flag=temp;
                k=k+100;
                initialnumber+=100;
            }else{  //only odd go

                System.out.println("\n"+initialnumber);

            }
        }
    }
}
