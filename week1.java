/**
需求：运算符&流程控制操作练习
（1）运算符：
1.赋值运算符
2.位运算符

（2）流程控制
1.分支选择：if语句；if...else语句；switch语句
2.循环语句：for语句；while语句；do...while语句
3.中断流程控制语句

*/
class Demo
{
		/*
		主函数，程序的入口，保证程序独立运行
		*/
		public static void main(String[] args)
		{
			//1-1赋值运算符
			int a = 5;
			a+=5;
			System.out.println("a="+a);
			System.out.println("----------");
			
			//1-2位运算符  
			int b = 5; 
			b = b << 2; //左移 --> b = 5*2*2 
			System.out.println("b="+b);
			
			int c = 5;
			c = c & 3;
			System.out.println("c="+c); //与运算 --> 5 & 3 = 1
			
			int d = 5;
			d = d | 3;
			System.out.println("d="+d);//或运算 --> 5 | 3 = 7
			
			int e = 5;
			e = e ^ 3;
			System.out.println("e="+e);//异或运算 --> 5 ^ 3 = 6
			System.out.println("----------");
			
			//2-1分支选择
			int f = 5;  
			if(f==5)  //if / if...else 语句
			{
				System.out.println("f="+f); 
			}
			else 
			{
				System.out.println("nono");
			}
			
			System.out.println("----------");
			
			//需求：根据指定月份输出指定季节
			int g = 5;
			switch(g)  // switch 语句
			{
				case 3:
				case 4:
				case 5:
					System.out.println("spring");
					break;
				case 6:
				case 7:
				case 8:
					System.out.println("summer");
					break;
				case 9:
				case 10:
				case 11:
					System.out.println("autumn");
					break;
				case 12:
				case 1:
				case 2:
					System.out.println("winter");
					break;
				default:System.out.println("wrong");
				
					
			}
			
		System.out.println("----------");
		
		
			//2-2循环语句
			int h = 5;
			while(h<10) //while语句
			{
				System.out.println("h="+h);
				h++;
			}
			System.out.println("----------");
			
			h = 5;
			do   //do...while 语句
			{
				System.out.println("h="+h);
				h++;
			}while(h<10);
		    System.out.println("----------");
			
			
			//需求：输出九九乘法表
			
			for(int i=1;i<=9;i++)  //for循环嵌套 
			{
				for(int j=1;j<=i;j++)
				{
					System.out.print(j+"*"+i+"="+i*j+"\t");
				}
				System.out.println();
			}
			
			//2-3中断流程控制
			for(int k=0;k<10;k++)
			{
				if(k==2)
					break;    //跳出当前for循环
				System.out.println("k="+k);
			}
			
			System.out.println("----------");
			
			for(int k=0;k<10;k++)
			{
				if(k%2==1)
					continue;   //continue 跳至k++
				System.out.println("k="+k);
			}
			
			System.out.println("----------");
			
			
			
			
			
		
			
			
		}
}
