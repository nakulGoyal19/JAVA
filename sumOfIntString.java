import java.util.*;
public class sumOfIntString {

	public static void main(String ar[])
	{
	Scanner sc=new Scanner(System.in);	
	String s=new String();
	s=sc.nextLine();
	int l=s.length();
	int sum=0;
	StringTokenizer st=new StringTokenizer(s);
	while(st.hasMoreTokens())
	{
		sum=sum+Integer.parseInt(st.nextToken());
		
	}
	System.out.print(sum);
	}
}
