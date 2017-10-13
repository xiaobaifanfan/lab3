package text1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.List;
public class ruangong {

	//�����ַ�������
		public static int appearNumber(String srcText, String findText) {
		    int count = 0;
		    Pattern p = Pattern.compile(findText);
		    Matcher m = p.matcher(srcText);
		    while (m.find()) {
		        count++;
		    }
		    return count;
		}
		
			
		//lab-3
		public static ArrayList<String> findbridge(String strr1,String strr2, String[] str1){

			ArrayList<String> sList= new ArrayList<String>(); 
			
			
			for(int i=0;i<str1.length-2;i++){
				
				if(strr1.equals(str1[i])&&strr2.equals(str1[i+2])){
					if(!sList.contains(str1[i+1]))
					sList.add(str1[i+1]);	}
			 }
			
			if(sList.size()==0)
			{
				System.out.println(" no bridge words from'"+strr1+"'\tto'"+strr2+"'\n");
			}else{
				System.out.print(" the birdgewords of '"+strr1+"'  and '"+strr2+"'\tis\t");
				 for(String ss:sList){
			            System.out.print("'"+ss+"'"+"\t ");  
			            }
				 System.out.print("\n");
			}
			 
		   return sList;     
		}
		
			 
			//Lab-4 
		public static void task4(String[] strtemp){
			System.out.println("��������files�ǣ�");
			 Scanner sc =new Scanner(System.in);
			 System.out.println("��������������ǣ�"+sc.nextLine());
			 String str=sc.nextLine();
			 String[] temp=deal(str);
			 ArrayList<String> results= new ArrayList<String>(); 
			 for(int i=0;i<temp.length-1;i++){
				String strr1=temp[i];
				String strr2=temp[i+1];
				results.add(temp[i]);
				ArrayList<String> sList= new ArrayList<String>(); 
				sList=findbridge(strr1,strr2,strtemp);
				if(sList.size()!=0){
					for(String item:sList){
						results.add(item);
					}
				}
			 }
			 int len=temp.length;
			 results.add(temp[len-1]);
			 for(String item:results){
				 System.out.print(item+" ");
			 }
			 
			 
		}
		
		//�����ַ���
		public static String[]  deal(String str)
		{
			int num=str.length();
			char[] temp=str.toCharArray();
			for(int i=0;i<num;i++)
			{
				if((int)temp[i]<65||((int)temp[i]>90&&(int)temp[i]<97)||(int)temp[i]>122)
				{
					temp[i]=(char)32;
					
				}
			}
			String str1=new String(temp);
			str1=str1.toLowerCase();//�����е���ĸת��ΪСд��ĸ
			String[] tempstr=str1.split(" ");
			List<String> tmp = new ArrayList<String>();  
	        for(String str2:tempstr){  
	            if(str2!=null && str2.length()!=0){  
	                tmp.add(str2);  
	            }  
	        }  //ȥ��string�����еĶ���Ŀ�Ԫ��
	        tempstr = tmp.toArray(new String[0]); 
			return tempstr;
		}
	   //lab-1
		public static int task_1(String str,String[] temp){
	    	for(int i=0;i<temp.length;i++){
	    		if(str.equals(temp[i]))
	    			{return i;}
	    	}
	    	return 0;
	    }
		
	//�������·��
		public static void shortpath(String[] arr,int[][]edge){
		       int MAXV=arr.length;
			   int[][] A= new int[MAXV][MAXV];
			   int[][] path=new int[MAXV][MAXV];
			   List<String> tmp = new ArrayList<String>();  
			   int i,j,k;
			   for(i=0;i<MAXV;i++)
			    for(j=0;j<MAXV;j++)
			    {
			        A[i][j]=edge[i][j];
			        path[i][j]=-1;
			    }
			 for(k=0;k<MAXV;k++)
			   { 
				 
			      for(i=0;i<MAXV;i++)
			         for(j=0;j<MAXV;j++){
			        	 
			            if(A[i][j]>(A[i][k]+A[k][j]))
			            {A[i][j] = A[i][k]+A[k][j];
			                  path[i][j] = k;
			                 } 
			    } 
			
			 }
			 for(i=0;i<arr.length;i++){
				 System.out.print("��"+i+"��"+arr[i]+"\t");
			 }
			 System.out.println("");
			 for (i=0;i<arr.length;i++){
				 for(j=0;j<arr.length;j++){
					 System.out.print(A[i][j]+"["+path[i][j]+"]\t");
				 }
				 System.out.println("");
			 }
			 System.out.println("���������word1�ǣ�");
			 Scanner sc1 =new Scanner(System.in);
			 System.out.println("��������������ǣ�"+sc1.next());
			 System.out.println("���������word2�ǣ�");
			 Scanner sc2 =new Scanner(System.in);
			 System.out.println("��������������ǣ�"+sc2.next());
			 
			 String strr1=sc1.next();
			 String strr2=sc2.next();
			 int a=task_1(strr1,arr);
			 int b=task_1(strr2,arr);
			 System.out.println(a);
			 System.out.println(b);
			 System.out.println("the shortest length of the two words is "+A[a][b]);
			 List<Integer> c = new ArrayList<Integer>(); 
			 c.add(b);
			 while(path[a][b]!=-1){
				 c.add(0,path[a][b]);
				 b=path[a][b];
				}
			 c.add(0,a);
			 System.out.print("the detailed path is:\t");
			 for(int itemj:c){
				 
				 System.out.print(arr[itemj]+"��");
				 
			 }
		}
		//lab-4-2
		public static void shortpathword1(String[] arr,int[][]edge){
		       int MAXV=arr.length;
			   int[][] A= new int[MAXV][MAXV];
			   int[][] path=new int[MAXV][MAXV];
			   List<String> tmp = new ArrayList<String>();  
			   int i,j,k;
			   for(i=0;i<MAXV;i++)
			    for(j=0;j<MAXV;j++)
			    {
			        A[i][j]=edge[i][j];
			        path[i][j]=-1;
			    }
			 for(k=0;k<MAXV;k++)
			   { 
				 
			      for(i=0;i<MAXV;i++)
			         for(j=0;j<MAXV;j++){
			        	 
			            if(A[i][j]>(A[i][k]+A[k][j]))
			            {A[i][j] = A[i][k]+A[k][j];
			                  path[i][j] = k;
			                 } 
			    } 
			
			 }
			 for(i=0;i<arr.length;i++){
				 System.out.print("��"+i+"��"+arr[i]+"\t");
			 }
			 System.out.println("");
			 for (i=0;i<arr.length;i++){
				 for(j=0;j<arr.length;j++){
					 System.out.print(A[i][j]+"["+path[i][j]+"]\t");
				 }
				 System.out.println("");
			 }
			 System.out.println("���������word1�ǣ�");
			 Scanner sc1 =new Scanner(System.in);
			 System.out.println("��������������ǣ�"+sc1.next());
			 String strr1=sc1.next();
			int a=task_1(strr1,arr);
			 System.out.println(a);
			for(i=0;i<arr.length;i++)
			{		int b=i;
				 System.out.println("the shortest length of the two words is "+A[a][b]);
				 List<Integer> c = new ArrayList<Integer>(); 
				 c.add(b);
				 while(path[a][b]!=-1){
					 c.add(0,path[a][b]);
					 b=path[a][b];
					}
				 c.add(0,a);
				 System.out.print("the detailed path is:\t");
				 for(int itemj:c){
					 System.out.print(arr[itemj]+"��");
					 }
				 System.out.println("");
			}
			
		}
		//lab-6
		public static void travelrandom(String[] str,int[][] edge){
			for(int i=0;i<str.length;i++){
				for(int j=0;j<str.length;j++){
					if(edge[i][j]==1000)
						edge[i][j]=0;
					System.out.print(edge[i][j]+"\t");
				}
				System.out.println("");
			}
			int[][] ceshiedge=edge;
			 System.out.println("���������word1�ǣ�");
			 Scanner sc1 =new Scanner(System.in);
			 System.out.println("��������������ǣ�"+sc1.next());
			 String strr1=sc1.next();
			int a=task_1(strr1,str);
			 System.out.println(a);
			 List<Integer> c = new ArrayList<Integer>(); 
			 c.add(a);
			 
			 int dd=xiabiao(a,str.length,ceshiedge);
			 
				 while(dd!=-1){
					 if(c.contains(dd))
					 { 
						 c.add(dd);
						 a=dd;
						 dd=xiabiao(a,str.length,ceshiedge); 
						 int b=c.indexOf(dd);
						 
						// System.out.println("�ظ�·��");
						 //for(int item:c){
							// System.out.print(str[item]+"��");
						 //}
						 //System.out.println("");
						 //dd=-1;
						// return;
					 }else{
						 c.add(dd);
						 edge[a][dd]=0;
						 a=dd;
						 dd=xiabiao(a,str.length,ceshiedge); 
					 }
					
				 }
				 if(c.size()!=str.length){
					 System.out.println("��·����");
				 }else{
					 System.out.println("���������нڵ�");
				 }
				
				 for(int item:c){
					 System.out.print(str[item]+"��");
				 }
				 System.out.println("");
			return;
			 
		}
		//����ĳ��Ԫ�ص��±�
		public static int xiabiao(int j,int len,int[][] a){
			for(int h=0;h<len;h++){
				if(a[j][h]!=0)
				{
					return h;
				}
			}
			return -1;
		}
		
		//������
		public static void main(String[] args){
			
			String str="To @ explore strange new worlds,To seek  out new life  and new civilizations?";
			String[] tempstr=deal(str);
			List<String> tmp = new ArrayList<String>();  
			for(int i=0;i<tempstr.length;i++){
				if(!tmp.contains(tempstr[i])){
					tmp.add(tempstr[i]);
				}
			}
			int size = tmp.size();  
			String[] arr = (String[])tmp.toArray(new String[size]);//�����еĵ���ȥ��
			int len=arr.length;
			int[][] edge=new int[len][len];
			for(int i=0;i<len;i++){
				for(int j=0;j<len;j++)
				{
					if(i==j)
					{
						edge[i][j]=0;
					}else{
						edge[i][j]=1000;
					}
				}
			}
			String[] newData1 = Arrays.copyOfRange(tempstr,0,tempstr.length-1);
			String[] newData2= Arrays.copyOfRange(tempstr,1,tempstr.length);
			String zifu=tempstr[0];
		
			for(int h=1;h<tempstr.length;h++){
				zifu=zifu+tempstr[h];
			}
		 
		
		
			 for(int h=0;h<newData1.length;h++){
				String tempstring=newData1[h]+newData2[h];
				edge[task_1(newData1[h],arr)][task_1(newData2[h],arr)]=appearNumber(zifu,tempstring);
			}
			
		  for(int h=0;h<len;h++){
			  for(int j=0;j<len;j++){
				  System.out.print(edge[h][j]+"\t");
			  }
			  System.out.println();
		  }
		  for(int i=0;i<10;i++){
			  System.out.println("\n****************��ӭ����lab-1********************\n 0.�˳�����\n1.��ѯ�ŽӴ�\n2.����bridge word�������ı�\n3.������������֮������·��\n4.����һ�����ʵ������������·��\n5.�������\n��ѡ��������Ĺ���ǰ�����ţ�");
		      Scanner scd = new Scanner(System.in);        
		      System.out.print("\n�������1������:");
		      int num = scd.nextInt();
		      System.out.print("����ĵ�1�����֣�\t"+num+"\n");
		      switch(num){
		      case 1:{
		    	 System.out.println("���������word1�ǣ�");
		 		 Scanner sc1 =new Scanner(System.in);
		 		 System.out.println("��������������ǣ�"+sc1.next());
		 		 System.out.println("���������word2�ǣ�");
		 		 Scanner sc2 =new Scanner(System.in);
		 		 System.out.println("��������������ǣ�"+sc2.next());
		 		 
		 		 String strr1=sc1.next();
		 		 String strr2=sc2.next();
		 		 findbridge(strr1,strr2,tempstr);
		    	  break;
		      }
		      case 2:{
		    	  task4(tempstr);
		    	  break;
		      }
		      case 3:{
		    	  shortpath(arr,edge);
		    	  break;
		      }
		      case 4:{
		    	  shortpathword1(arr,edge);
		    	  break;
		      }
		      case 5:{
		    	  travelrandom(arr,edge);
		    	  break;
		      }
		      case 0:{
		    	  return;
		      }
		       default:{
		    	   System.out.println("default"); 

		    	   break; 
		       }
		      } 
		  }
	      
	 
		 }
		private static String tmp(int i) {
			// TODO �Զ����ɵķ������
			return null;
		}

	
}
