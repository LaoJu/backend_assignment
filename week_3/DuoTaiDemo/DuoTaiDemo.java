class A
{
	public void fun()
	{
		System.out.println("A---");
	}
}

class B extends A            //B类继承A类
{
	public void fun()          //覆写A类方法
	{
		System.out.println("B---");
	}
	
}

class DuoTaiDemo
{
	public static void main(String[] args)
	{
		A a = new B(); 		//向上转型，实例化的是子类
		
		a.fun();		//打印：B---
		
		B b = (B)a;           //强制向下转型 
		
		b.fun();           //打印：B---
		
		
	}
}