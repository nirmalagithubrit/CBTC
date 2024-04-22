import java.util.*;
public class GuessTheNumber {

	public static void main(String[] args) {
		int max=100, min=1, score=0;
		do {
		Scanner in=new Scanner(System.in);
		System.out.println("There are only three attempts");
        for(int i=0;i<3;i++) {
		   if(score==3) {
			   System.out.println("one more round is added");
		   }
		int randomNumber=(int) Math.floor(Math.random()*(max-min+1)+min);
		System.out.println(randomNumber);
		System.out.println("Enter the number");
		int x=in.nextInt();
		if(randomNumber==x) {
			score+=1;
		}else if(randomNumber<x) {
            System.out.println("The entered Number is higher than the random Number");
		}else {
            System.out.println("The entered Number is lower than the random Number");
		}
        }
		System.out.println("The score is "+score);
		}while(score==3);
	}
}
