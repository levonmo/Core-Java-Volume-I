package test;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import javax.swing.Timer;
import object.ObjectA;
import object.ObjectD;
import object.ObjectE;
import object.ObjectF;
import object.ObjectG;
import object.ObjectH;
import object.ObjectJ;
import object.ObjectK;
import object.ObjectL;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void testB(){
		Integer a = 100;
		Integer b = 100;
		System.out.println("100等于100?");
		if (a == b) {
			System.out.println("成立");
		} else {
			System.out.println("不成立");
		}
		Integer c = 1000;
		Integer d = 1000;
		System.out.println("1000等于1000?");
		if (c == d) {
			System.out.println("成立");
		} else {
			System.out.println("不成立");
		}
		/*if (a.equals(b)) {
			System.out.println("成立");
		} else {
			System.out.println("不成立");
		}*/
		/*
		 * 就是对于在-128到127之间的数被包装到固定的对象中
		 */
	}
	
	@Test
	public void testC(){
		ArrayList<Integer> list = new ArrayList<Integer>();//在java7中不需要在右端写上数据的类型
		list.add(3);
		/*
		 * 有时候需要将int这样的基本类型转换为对象。所有的基本类型都有一个与之对应得类。
		 * 	例如Integer类对应的基本类型是int。通常这些类称为包装类
		 * 
		 * 3是一个基本类型，要把3转化为Integer对象才能放进数组中，但这里不是不用，而是java自动的将list.add(3);
		 * 	变成list.add(Integer.valueOf(3));这样就是将3转化成了Integer对象，只是不需要程序员自己动手转化。
		 * 	这种变换被称为自动装箱。
		 * 	
		 * 	相反地，当将要给Integer对象赋给一个int值时，将会自动地拆箱。
		 * 		也就是说编译器将下面的语句
		 * 			int n = list.get(1);
		 * 				翻译为
		 * 			int n = list.get(1).intValue();
		 */
		
		
		/*
		 * 	甚至在算术表达式中也能自动装箱和拆箱。例如，可以将自增操作符应用于一个包装器引用
		 * 		Integer n = 3;
		 * 		n++;
		 * 	编译器将自动地插进一条对象拆箱的指令，将 n.intValue()(就是将Integer对象类转化为int基本类型)
		 * 		然后进行自增计算，
		 * 	最后再将结果装箱
		 * 		Integer.valueOf(n)
		 */
	}
	
	@Test
	public void testD(){
		double max = max(3.1,40.4,-5);//这个方法在下面
		System.out.println(max);
		/*
		 * java允许将一个数组传递给可变参数方法的最后一个参数
		 */
	}
	
	public static double max(double... values){
		double largest = Double.MIN_VALUE;
		for (double v : values) {
			if (v > largest) {
				largest = v;
			}
		}
		return largest;
	}

	
	//枚举类
	public enum Size{
		SMALL,MEDIUM,LARGE,EXTRA_LARGE
	};
	/*
	 * 实际上，这个声明定义的类型是一个类，它刚好有4个实例变量，在此尽量不要构造新对象
	 * 	
	 */
	
	public enum SizeA{
		SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("E");
		private String abbreviation;
		private SizeA(String abbreviation){
			this.abbreviation = abbreviation;
		}
		public String getAbbreviation(){
			return abbreviation;
		}
	}
	

	/*
	 * 克隆技术，浅克隆和深克隆
	 * 	浅克隆就是只是克隆当前的对象，不会克隆该对象里面所引用的变量，那就是两个对象里面还有是引用同一实例域
	 * 		深克隆就是把里面的实例域也克隆，这个需要自己实现，
	 * 	要想实现克隆功能的类 必须是实现了Cloneable接口，并且重写了clone方法(修饰符为public)
	 * 
	 */
	@Test
	public void testH() throws CloneNotSupportedException{
		ObjectD objectD = new ObjectD();
		objectD.setA(5);
		System.out.println(objectD);
		ObjectD obj =  objectD.clone();
		obj.setA(6);
		System.out.println(obj);
	}

	/*
	 * 所有的数组类型都有一个clone方法，这个方法被设置为public，而不是protect。
	 * 	可以利用这一方法创建一个包含所有数据元素拷贝的一个新数组。
	 */
	@Test
	public void cloneArray(){
		int[] a = {2,3,4,5};
		int[] clone = a.clone();
	}
	
	
	/*
	 * 定时器:
	 * 	使用它在给定的时间间隔发出通知
	 * 		
	 */
	@Test
	public void timer() throws InterruptedException{
		ObjectE objectE = new ObjectE();
		Timer timer = new Timer(1000,objectE);//第二个参数一定要是ActionListener类型的
		//启动定时器
		timer.start();
		Thread.sleep(10000);
		/*
		 * 每一秒执行ObjectE中的actionPerformed方法一次
		 */
	}
	
	
	/*
	 * 内部类,具体的细节参考里面更多的类
	 * 	在内部类可以使用outer/OuterClass/来引用外部类
	 * 		在外部类可以使用OuterClass.InnerClass来引用内部类
	 */
	@Test
	public void inClass() throws InterruptedException{
		ObjectF objectF = new ObjectF(1000,true);
		objectF.start();
		Thread.sleep(10000);
	}
	
	
	
	/*
	 * 	局部内部类:在这里是放在方法里面
	 * 		局部内部类不能用public或private访问说明符进行声明。它的作用域被限定在声明这个局部类的块中。
	 * 			局部内部类有一个优势，即对外部世界可以完全地隐藏起来。即使是外围类中的其他代码也不能访问。
	 * 				(在这里除了start)之外，没有任何方法知道内部类TimePrinter的存在。
	 * 			局部内部类还有一个优点就是，它不仅可访问包含它们的外部类，还可以访问局部变量。但是这些局部变量要声明为final。
	 * 
	 * 	看ObjectG，有具体的说明为什么要内部类为什么只能访问被声明为final的局部变量。
	 * 
	 * 	前面曾经将final变量作为常量使用，例如:	
	 * 		public static final double SPEED_LIMIT = 55;
	 * 			final关键字可以应用在局部变量，实例变量，静态变量。
	 * 			在所有这些情况下，它们的含义都是:
	 * 				在创建这个变量之后，只能够为之赋值一次。此后，再也不能修改它的值了。这就是final
	 */
	@Test
	public void inClassA() throws InterruptedException{
		ObjectG objectG = new ObjectG(1000,true);
		objectG.start(true);
		Thread.sleep(10000);
	}
	/*
	 * 比如这种情况想要统计一下counter的次数(代码不准确)，但counter一定是要改变得，不能被声明为final
	 * 		但是又是内部类里面想要访问局部变量，这个局部变量就必须要被声明为final，这时候就很尴尬。
	 * 		
	 * 	解决的办法就是:
	 * 		使用一个长度为1的数组，数组变量可以被声明为final，但这仅仅是表示不可以让它引用另外一个数组，数组总的数据是可以自由更改的。
	 */
	@Test
	public void finalWord(){
//		int counter = 0;//错误的做法
		final int[] counter = new int[1];//正确的解决方法
		Date[] date = new Date[100];
		for (int i = 0; i < date.length; i++) {
			date[i] = new Date(){
				public void compar(Date other){
					//counter++;
					counter[0]++;
				}
			};//这是一个内部类，这里需要;结尾
		}
	}
	
	
	/*
	 * 匿名内部类:
	 * 		将局部内部类的使用再深入一步，只创建这个类的一个对象，而不命名，这个类称为匿名内部类
	 * 	
	 * 	通常的语法格式是:
	 * 		new SuperType(construction parameters){
	 *			inner class method and data 			
	 * 		}
	 * 		SuperType可以是ActionListener这样的接口，也可以是一个类，于是内部类就去扩展它
	 * 		由于构造器的名字必须与类名相同，而匿名类没有类名，所以i，匿名类不能有构造器。取而代之的是，将构造器参数传递给超类构造器。
	 * 		尤其是在内部类实现接口的时候，不能有任何的构造器参数。
	 * 	
	 */
	@Test
	public void anonymousInner(){
		/*
		 * 这里的意思是创建一个实现ActionListener接口的类，需要实现的方法actionPerformed定义在括号{}内
		 */
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("dosomething");
			}
		};
	}
	
	/*
	 *	下面的技巧称为"双括号初始化 ":利用 匿名内部类 创建一个匿名列表
	 */
	@Test
	public void doubleBraceInitialization(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		invite(list);//这三行代码与下面的代码是一样的
		invite(new ArrayList<String>(){
			{
				add("A");
				add("B");
			}
		});
		/*
		 * 注意这里的双括号。外层括号建立了ArrayList的一个匿名子类。内层括号是一个构造块
		 */
	}
	public void invite(ArrayList list){}
	
	
	/*
	 * 静态内部类:使用一个内部类，不需要引用外围类，将内部类声明为static。
	 * 		下面是一个例子计算数组中的最大值和最小值
	 * 	当内部类不需要访问外围类对象的时候，应该使用静态内部类。
	 * 		声明在接口中的内部类自动成为static和public类     
	 */
	@Test
	public void staticClass(){
		double[] array = new double[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random();
		}
		ObjectH.Pair p = ObjectH.Pair.minmax(array);
		System.out.println(p.getMint());
		System.out.println(p.getMax());
	}
	
	
	@Test
	public void proxy(){
		int[] a = new int[10];
		a[11] = 1;//这是RuntimeException数组越界，不需要抛出异常，需要做的是完善程序的完整性，在调用之前检查一次
	}
	
	
	//自定义一个异常
	@Test
	public void createException() throws ObjectJ{
		//ObjectJ是一个自定义好的异常
		throw new ObjectJ();
	} 
	
	
	/*
	 * 捕获异常
	 * 		抛出一个异常很简单，只要将其抛出就不用理会了，
	 * 			但是，有些代码必须进行捕获异常。如果某个异常发生的时候没有在任何地方进行捕获，那程序就会终止，并在控制台上打印异常信息。
	 * 
	 * 		要想捕获一个异常，就必须设置try/catch语句块
	 * 
	 * 			如果在try语句块中的任何代码抛出了一个catch子句中说明的异常类，那么
	 * 				1.程序将跳过try语句中的剩余代码
	 * 				2.程序将执行catch字句中的代码
	 * 
	 * 			如果try语句块中没有抛出任何的代码，那么程序将跳过catch子句
	 * 
	 * 			如果方法中的任何代码抛出一个在catch子句中没有声明的异常类型，那么这个方法就会立刻退出。(希望调用者为这种类型的异常设计了catch)
	 *			    
	 *		那选择抛出去还是cacth?
	 *			通常应该捕获那些知道怎么处理的异常，而将那些不知道怎么处理的异常继续进行传递()
	 *
	 *		注意:
	 *			如果编写一个覆盖超类的方法，而超类中的这个方法又没有抛出异常，那么子类中的这个方法就必须捕获所有的已检查异常。
	 *				不允许子类的throws说明符中出现超过超类方法所列出的异常类范围。
	 */
	@Test
	public void catchException(){
		try {
			//这里抛出一个异常，可以选择抛出去，也可以选择catch
			throw new ObjectJ();
		} catch (ObjectJ e) {
			//上一行代码中，ObjectJ是异常的类型
			e.printStackTrace();
		}
	}
	
	//捕获异常多个异常
	@Test
	public void catchManyException(){
		try {
			throw new ObjectJ();
			//这里面可以有很多代码，抛出各种各样的异常，下面就将可能抛出的异常类型全部catch，为每一个异常类型单独使用的catch子句
		} catch (ObjectJ e) {
			e.getMessage();
			/*
			 * 异常对象可能包含与异常本身有关的信息。要想获取对象更多的信息，可以试着使用e.getMessage()等到详细的错误信息(如果有的话)，
			 * 		或者使用e.getClass.getName()可以等到异常对象的详细类型
			 * 
			 * 	在java SE 7中，同一个catch子句中可以捕获多个异常的类型。例如，假设对应的缺少文件和未知主机异常是一样的，就可以合并catch子句
			 * 		try{
			 * 			...;
			 * 		} catch(FileNotFoundException | UnKnownHostException e){	
			 * 			...;
			 * 		}
			 * 	只有当捕获的异常彼此之间不存在子类关系时才需要这个特性
			 * 	捕获多个异常时 ，异常变量隐含为final变量，例如，不能在以下的子句中为e赋不同的值
			 * 	捕获多个异常不仅会让你的代码看起来更简单，还会更高效，生成的字节码只包含一个对应公共catch字句的代码块
			 * 
			 */
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	
	/*
	 * 	再次抛出异常与异常链:
	 * 		在catch子句中可以抛出一个异常，这样做的目的是改变异常的类型。用于表示子系统异常类型可能有多种解析。
	 * 			例如ServletException就是这样一个异常类型的例子，
	 * 				可能不想知道发生错误的具体细节原意，但希望明确的知道是不是有问题。
	 */
	@Test
	public void againThrows() throws Exception {
		try {
			throw new ObjectJ();
		} catch (ObjectJ e) {
			//throw new Exception();//catch块里面再抛出异常
			/*
			 * 下面还有以一种更好的方法，将原始异常设置为新异常的原因
			 * 		当捕获到异常时，就可以使用下面这条语句捕获异常了,又可以重新得到原始的异常
			 * 			Throwable = se.getCause();
			 * 		强烈建议使用这种包装技术。这样可以让用户抛出子系统中的高级异常，而不会丢失原始异常的细节 
			 * 
			 * 	如果在一个方法中发生一个已检查异常，而不允许抛出它，那么包装技术就十分有用了。我们可以捕获这个已检查异常，并将它包装成一个运行时的异常
			 * 		
			 */
			Exception se = new Exception();
			se.initCause(e);
			throw se;
		}
	}
	
	
	
	/*
	 * final子句
	 * 		1.try抛出异常，，执行catch，再执行final
	 * 		2.try没有抛出异常，try正常执行完，执行final
	 * 		3.try抛出异常为前提，catch中再抛出异常，一样执行final，异常将被抛回给方法的调用者
	 * 	
	 * 	注意：
	 * 		1.try可以只有final语句，没有catch语句
	 * 		2.如果try中有return，final中也有return，那么final中的return将会覆盖try中的return
	 * 		3.try抛出异常后，final也抛出了异常，try中的异常将会丢失，转而抛出final中的异常(一般下try中的异常更有意思)。
	 * 			比如在close方法中，关闭不了就会抛出异常信息。覆盖try中的异常信息。
	 * 			幸运的是，在se7中关闭资源的处理会容易得多(就是下一个test要说的带资源的try语句)。
	 */
	
	/*
	 * 带资源的try语句
	 * 		对于以下的代码模式
	 * 			open a resoure
	 * 			try{
	 * 			}final{
	 * 				close resoure
	 * 			}
	 * 		
	 * 		假设上面的resoure是实现了AutoCloseable接口的类，SE7为这种代码模式提供了一个很有用的快捷方式。
	 * 			这个接口有一个方法是 void close() throws Exception
	 * 		(另外还有一个Closeable接口，这是AutoCloseable的子接口，也包含一个close方法，抛出的是一个IOException)
	 * 		
	 * 		就可以用下面的方式来实现跟上面一样功能的代码了，就是带资源的try语句
	 * 			try(Resoure re = ...){
	 * 				work..
	 * 			}
	 * 		当try块退出的时候(不管是执行完还是抛出异常)，都会调用re.close()，就好象使用了final一样，不过这里主要是针对close()
	 * 
	 * 		在上一个test中可以看到，但try和final中的close都抛出异常，那么final中的异常就会覆盖try中的
	 * 			这种带资源的try就很好的解决了这个问题，原来的异常会抛出，而close方法中抛出的异常会被抑制。
	 * 				并有addSuppressed方法增加到原来的异常。如果你对这些异常感兴趣，可以调用getSuppressed方法，会得到close方法抛出的异常
	 */		

	
	
	/*
	 *	堆栈跟踪:
	 *		是一个方法调用过程的列表，它包含了程序执行过程中方法调用的特定位置。
	 *			对打印出调用方法的详细信息，包括那个类，那个方法的第几行
	 */
	@Test
	public void stackTrace(){
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		for (Thread t : map.keySet()) {
			StackTraceElement[] stackTraceElements = map.get(t);
			for (StackTraceElement stackTraceElement : stackTraceElements) {
				System.out.println(stackTraceElement.toString());
			}
		}
	}
	
	
	/*
	 * 	泛型:
	 * 		使用泛型机制编写的代码具有更好的安全性和可读性
	 */
	
	/*
	 * 	定义简单的泛型
	 * 		Pair类引入一个类型变量T，用<>括起来，放在类名的后面。
	 * 			泛型可以引入多个类型的变量，
	 * 				例如可以定义Pair类，其中第一个域和第二个域使用不同的类型
	 * 					public class Pair<T,U>{...}
	 * 		类定义的类型变量(就是<>里面定义的)，就是为了指定方法的返回类型以及域(指实例变量)和局部变量的类型
	 */
	class Pair<T> {
		private T first;
		private T second;
		public Pair(){first=null;second=null;}
		public Pair(T first,T second){this.first = first;this.second = second;}
		public void setFirst(T newValue){first = newValue;}
		public void setSecond(T newValue){second = newValue;}
	}

	/*
	 * 	用具体的类型替换类型变量就可以实例化泛型类型
	 * 		下面就实例化一个泛型类型pair
	 * 			这样就可以想象成把上面的 T 全部替换成  String 类型了
	 */
	public void genericClass(){
		Pair<String> pair = new Pair<String>();
	}

	/*
	 * 泛型方法 : <类型变量> + 返回值类型 (或者是void)
	 * 	这种方法可以在普通类中定义，也可以在泛型类中定义。
	 * 		在这里，类型变量是 T ，类型变量放在修饰符(这里是public static)的后面，返回类型 (这里是 T ) 的前面
	 * 			<T>可以确定传人参数要是 T 类型的,以及返回的数据类型也是 T
	 */
	public static <T> T getMethodA(T... a){//这里 T...表示一个数组
		return a[a.length/2];
	}
	/*
	 * 这里是没有返回值，但是<T>一定要写，因为只有这样写才是声明了这个方法是泛型方法，可以传人任意类型参数
	 * 		其中传人参数类型中 一定要在泛型方法头中进行声明
	 */
	public <T> void genericMethodB(T a){
	}
	/*
	 * 调用一个泛型方法，在方法名前的尖括号中放进具体的类型
	 * 		其实，方法中的  <String>  类型参数可以省略的
	 * 			因为编译器有足够的信息可以推断出所调用的方法的类型是什么。它用输入的参数类型与泛型类型进行匹配
	 */
	@Test
	public void genericMethodC(){
		String name = Test1.<String>getMethodA("A","B","C","D");
		String name2 = Test1.getMethodA("A","B","C","D");
		/*
		 * 这两种写法是一样的，但是一般是用下面的这种写法
		 * 		几乎在大多数的情况下，对于泛型方法的引用是没有问题的。
		 */
		Test1.getMethodA(3.14,1729,0);//这里有三个数，一个double对象和两个Integer对象
		/*
		 * 	对于这一行代码是这样的:
		 * 		编译器将会自动打包参数为一个double对象和两个Integer对象，然后寻找这些类的共同超类型。
		 * 			事实上找到两个这样的超类型:Number和Comparable接口，其本身也是一个泛型类型。
		 * 		
		 * 		在这种情况下采取补救就是将所有的参数写成double值
		 * 			Test1.getMethodA(3.14,1729.00,0.00)
		 */
	}
	
	  
	/*
	 *	类型变量限定:
	 *		对泛型类或者是泛型方法 加以约束。
	 *
	 *	就像下面的例子:
	 *		想要调用compareTo方法，但是调用该方法需要调用的对象实现Comparable接口，所以这样的代码是编译不了的，但又要这个方法才能实现功能怎么办。
	 *			所以就要限定传人的参数要都要实现Comparable接口
	 *		看下一个例子就是完美的解决方案了
	 */
	public static <T> T min(T... a){
		if(a == null || a.length == 0){
			return null;
		}
		T smallest = a[0];
		for (int i = 0; i < a.length; i++) {
//			if(smallest.compareTo(a[i])>0){
//				smallest = a[i];
//			}
		}
		return smallest;
	}
	
	/*
	 * 这里要求传人的参数都是实现Comparable接口的
	 * 	这里的extends并不是继承的意思。
	 * 		extends表示T应该绑定的类型的子类型。T 和 绑定类型 都可以是类(在这里的绑定类型是Comparable)，也可以是接口
	 * 			选择extends的原因是更接近子类的概念，并且java设计者也不打算在语言中再添加一个新的关键字
	 * 
	 * 	一个类型变量可以有多个限定，用 & 进行分隔
	 * 		<T extends Comparable & Serializable>
	 *	
	 *		这里要注意的是:
	 *			在java的继承中，可以实现多个接口，但只能继承一个类。
	 *			限定也是一样，可以限定多个接口，但只能限定要给类，并且这个类一定是要在限定列表的第一个(就像下面的ObjectJ是一个类，只能在第一的位置)
	 * 		
 	 */
	public static <T extends  ObjectJ &  Comparable & Serializable> T minA(T... a){
		if(a == null || a.length == 0){
			return null;
		}
		T smallest = a[0];
		for (int i = 0; i < a.length; i++) {
			if(smallest.compareTo(a[i])>0){
				smallest = a[i];
			}
		}
		return smallest;		
	}
	
	/*
	 * 泛型代码和虚拟机
	 * 		虚拟机没有泛型类型
	 * 
	 * 		定义一个泛型类型都自动提供一个相应的原始类型。
	 * 		擦除类型变量，并替换成限定类型(无限定的变量用Object)
	 * 		
	 * 		原始类型用  第一个限定的类型变量  来替换(就是 所有的 T 都用限定列表的第一个类型来替换)，如果没有就用Object。
	 * 		
	 * 		例如上面的Pair<T>中的没有限定类型变量，就用原始的类型Object替换。
	 * 	
	 * 		但有限定的类型的话
	 */
	public void objectK(){
		new ObjectK();//具体参考这个类
	}
	
	/*
	 *	 有关java泛型转换的事实:
	 * 		1.虚拟机中没有泛型，只有普通的类和方法
	 * 		2.所有的类型参数都用它们的限定类型替换
	 * 		3.桥方法被合成来保持多态
	 * 		4.为保持类型的安全性，必要时插入强制泪类型转换
	 */
	
	
	/*
	 * 	泛型的约束与局限性
	 * 		1.不能用基本类型实例化类型参数
	 * 			没有Pair<double>，只有Pair<Double>	
	 * 		2.运行时类型查询只适用于原始类型
	 * 			虚拟机中的对象都是非泛型类型的。所以类型查询只产生原始类型。
	 * 			例如:
	 * 				if(a instanceof Pair<String>)//ERROR
	 * 				if(a instanceof Pair<T>)//ERROR
	 *					上面这两个方法的作用是一样的，都是为了测试a是不是Pair的任意一个类型，而不是单单是不是Pair<String>类型的
	 * 				或者是强制类型转换：
	 * 					Pair<String> p = (Pair<String>)a;
	 * 				要记住这一个风险，无论何时使用instanceof或涉及泛型类型的强制类型转换表达式都会看到一个编译器的警告
	 * 			同样的道理:无论是哪个泛型的类型，返回的都是原始类型的
	 * 				if(stringPair.getClass() == employeePair.getClass())
	 * 					返回的结果总是true，因为泛型类型调用getClass()，返回的结果都是Pair.class
	 * 		3.不能创建参数化类型的数组
	 * 			不能实例化参数化类型的数组,例如:
	 * 				Pair<String>[] table = new Pair<String>[10];//ERROR
	 * 				擦除之后(就是编译器里面没有泛型类的)，table的类型是Pair[]。可以把它转换成Object[];
	 * 				Object[] objarray = table;
	 * 				数组会记住它的元素类型，如果尝试存其他类型的元素，就会抛出一个ArrayStoreException的异常
	 * 				objarray[0] = "Hello";//ERROR--component type is Pair
	 * 				
	 * 				不过对于泛型，擦除会使这种机制无效。
	 * 				objarray[0] = new Pair<Employee>()
	 * 				能够通过数组存储检查，不过仍然会导致一个类型的错误。出于这个原因，不允许创建参数化类型的数组。
	 * 
	 * 				需要说明一下，只是不能创建这些数组，但是声明类型为Pair<Sting>[] 的变量是可以的。
	 * 					不过不能用new Pair<String>[10]初始化这个变量
	 * 
	 * 		4.不能实例类型变量
	 * 			不能使用像new T(..),new T[..],或T.class这样的表达式。
	 * 				例如像下面的构造器就是不合法的
	 * 				public Pair(){ first = new T(); second = new T();}//ERROR
	 * 				类型擦除后(就是编译过后进行擦除)，将T改为Object。
	 * 
	 * 			但是可以通过反射调用Class.newInstance()方法来构造泛型对象
	 * 				first = T.class.newInstance();//这样的写法是不正确的，因为T.class是不合法的
	 * 
	 *			必须像以下这样设计API可以创建一个新的对象
	 *				public static <T> Pair<T> void makePair(Class<T> c1){
	 *					return new Pair<>(c1.newInstance);//这样就可以创建一个新的对象了
	 *				} 			
	 *			这个方法可以按照以下的方式调用，
	 *				Pair<String> p = Pair.makePair(String.class);
	 *
	 *		5.泛型类的静态上下文中类型变量无效
	 *			不能再静态域或静态方法中引用类型变量
	 *				例如,下面的高招将没法施展
	 *					public class Siingleton<T>{
	 *						private static T singleInstance;//ERROR
	 *						public static T getSingleIntance(){...}//ERROR
	 *					}
	 *				类型擦除后，只剩下Singleton类，它只包含一个singleInstance域。因此，禁止使用带有类型变量的静态域或方法。
	 *
	 *		6.不能抛出或捕获泛型类的实例
	 *			既不能抛出也不能捕获泛型类对象。实际上就是泛型类扩张Throwable都是不合法的
	 *				一下定义就不能通过编译了了
	 *					public class Problem<T> extends Exception {} //ERROR--can't extend Throwable
	 *			catch语句中不能使用泛型类型的变量
	 *				try{}catch(T e){}//ERROR
	 *
	 *		7.注意擦除后的冲突
	 *			当泛型类型被擦除时，
	 *			例如：
	 *				public class Pair<T>{
	 *					public boolean equals(T value){return first.equals(value) && second.equals(value);}
	 *					//Pair里面只有这两个实例变量，当比较这两个实例变量相等了，这两个对象就是相等了。
	 *				}
	 *			考虑一个Pair<String>。从概念上，它有两个equals方法，
	 *				boolean equals(String)
	 *				boolean equals(Object)
	 *				方法擦除后就是
	 *					boolean equals(T)
	 *					就是
	 *					boolean equals(Object)	
	 *				与Object.equals(Object)发生冲突，补救的办法就是重新命名引发错误的方法。
	 */	
	
	
	/*
	 * 	泛型类型的继承规则
	 * 		在使用泛型类时，需要了解一些有关继承和子类型的准则。
	 * 			例如:Employee 和 Manager。(Manager是继承了Employee)
	 * 				Pair<Manager>是Pair<Employee>的一个子类吗?答案是"不是",通常，它们之间没有什么联系。
	 * 					就是不允许将Pair<Manager>转换成Pair<Employee>
	 * 			这一限制看起来过于严格，但对于类型安全是非常必要的。
	 * 		
	 * 		注意:泛型跟java数组之间的重要区别。可以将一个Manager[]数组赋给一个类型为Employee[]的变量。
	 * 			Manager[] managerArray = {ceo,cfo};
	 * 			Employee[] employeeArray = managerArray;//IS OK
	 * 			然而，数组带有特别的保护。如果试图将一个低级别的雇员存储到employeeArray[0]中，虚拟机会抛出一个异常的。
	 * 				就是说虽然是用Employee引用，但是你却不能将一个Employee实例放进其中，因为它指向的是Manager对象数组。
	 * 
	 * 		永远可以将一个参数化类型转换为一个原始类型。例如，Pair<Employee>是原始类型Pair的一个子类型。
	 * 			
	 * 		还有，泛型类可以扩展或者是实现其他的泛型类
	 * 			例如:ArrayList<T>类实现List<T>接口。这就意味着，一个ArrayList<Manager>可以被转换为一个List<Manager>
	 * 				但，前面也说了，一个ArrayList<Manager>不是一个ArrayList<Employee>或者是List<Employee>,它们是没有任何的关系。
	 */
	
	
	/*
	 * 	通配符类型
	 * 		Pair<? extends Employee>
	 * 		表示任何的泛型Pair类型，它的参数是指只要是Employee的子类就可以，如Pair<Manager>，但不是Pair<String>,因为String不是Employee的子类
	 * 			
	 * 		看下面这个程序:
	 * 			public static void printBuddies(Pair<Employee> p){
	 * 				Employee first = p.getFirst();
	 * 				Employee second = p.getSecond();
	 * 				...;				
	 * 			}
	 * 		正如前面所说的，不能将Pair<Manager>传递给这个方法，因为Pair<Manager>与Pair<Employee>没有任何的关系。
	 * 			
	 * 		这一点很受限制，解决的方法很简单:使用通配符
	 * 			public static void printBuddies(Pair<? extends Employee> p)
	 * 			这样的话，Pair<Manager>类型就是Pair<Employee>的子类型了
	 * 				就像上面的ArrayList<Manager>可以被转换为一个List<Manager>一样，ArrayList<Manager>是List<Manager>子类型
	 */

	/*
	 * 	通配符的超类型限定
	 * 		通配符限定跟类型变量限定十分类似。但是还有一个附加的能力，即可以指定一个超类型。
	 * 		? super Manager
	 * 			这种通配符限制为Manager的所有超类型。(具体参考卷一549页)
	 */
	
	/*
	 * 	无限定通配符
	 * 		Pair<?>,好像与原始的Pair类型一样，但是实际上有很大的不同。
	 * 		方法
	 * 			? getFirst()
	 * 			void setFirst(?)
	 * 		getFirst只能赋值给一个Object。setFirst方法不能被调用，甚至不能被Objct调用。
	 * 		
	 * 		Pair<?>与原始的Pair类的区别:可以使用任意的Object对象调用原始类的setFirst()方法。
	 */
	
	
	/*
	 * 	反射和泛型
	 * 		现在Class类是泛型的。例如,String.class实际上是一个Class<String>类的对象(事实上是唯一的对象)
	 */
	@Test
	public void stringClass(){
		Class<String> s = String.class;
		Class<String> sa = String.class;
		System.out.println(s == sa);
	}
	
	
	/*
	 * 	集合
	 * 		在java类库中，集合类的基本接口是Collection接口。这个接口有两个基本方法
	 * 			public interface Colletion<E> {
	 * 				boolean add(E element);
	 * 				Iterator<E> iterator();
	 * 			}
	 * 			
	 * 			add方法用于向集合中添加元素。如果元素是改变了集合就返回true，否则返回false。
	 * 				例如如果试图向集合中添加一对象，而这个对象在集合中已经存在了，这个添加请求失败，返回false，以为集合中不允许有重复的元素。
	 * 			iterator方法用于返回一个实现Iterator接口的对象。可以使用这个迭代器对象依次访问集合中的元素。
	 * 				Iterator接口有三个方法
	 * 					public interface Iterator<E> {
	 * 						E next();
	 * 						boolean hasNext();
	 * 						void remove();
	 * 					}
	 * 					反复调用next方法可以逐个访问集合中的元素。但是，如果到达集合的末尾，next就会抛出一个异常NoSuchElementException.
	 * 					所以在调用next之前应该调用hasNext方法判断是否还有下一个元素。如果还有元素就返回true
	 * 					如果想要遍历集合，就请求一个迭代器，在hasNext返回true是反复调用next方法
	 * 						例如:
	 * 							Collection<String> c = ...;
	 * 							Iterator iter = c.iterator();
	 * 							while(iter.hasNext()){-----这里进行判断是否还有下一个元素，有的话返回true，就调用next遍历出下一个元素
	 *								String element = iter.next();							
	 * 							}
	 * 						
	 * 						在java SE 5.0起，这个循环可以采用一种更加优雅的缩写方式。用"for each"循环可以更加简练地表示同样的循环操作。
	 * 							for(String element : c ){ ---这里是 元素类型 + 单个元素变引用 + 集合引用 
	 *								do something with element 								
	 * 							}
	 * 						编译器简单地将"for each" 循环翻译为带有迭代器的循环。
	 * 
	 * 						"for each"循环可以与任何实现了Iterable接口的对象一起工作，这个接口只有一个方法：
	 * 							public interface Interable<E>{
	 * 								Iterator<E> iterator();		
	 * 							}
	 * 
	 * 						Collection接口扩展了Interable接口。因此，对于标准类库中的任何集合都可以使用"for each"循环。
	 * 
	 * 			元素被访问的顺序取决于集合的类型。如果对于ArrayList进行迭代，迭代器将从索引0开始，每迭代一次，索引值加1.
	 * 				然而，如果访问HashSet中的元素，每个元素将会按照某种随机的次序出现，可以被全部遍历出来，但是无法预知元素访问的次序。
	 * 			
	 * 					remove方法:(使用迭代器调用这个方法，不是用元素对象调用该方法)
	 * 						iterator接口中remove方法将会删除上次调用next方法时返回的元素。
	 * 							一般情况下，在删除元素之前应该看看这个元素的内部。
	 * 						如果想要删除指定位置上的元素，仍然要越过这个元素，因为你只有越过这个元素，才会返回一个元素，
	 * 							你才知道这个元素是否符合删除的条件，在用迭代器对象调用remove方法删除该元素。
	 * 						还有就是，next方法和remove方法的调用时有依赖性的。在调用remove之前一定要至少调用一次next，否则就会抛出IllegalStateException
	 * 							如果想删除两个相邻的元素，这样调用时不行的。
	 * 								it.next();//这里会返回一个元素
	 * 								it.remove();//这里已经将上面的元素从集合中删除了
	 * 								it.remove();//迭代器已经没有了返回读元素了，应该在调用一次next，再调用该方法
	 * 								
	 */
	
	/*
	 *	迭代器
	 *		:描述集合中的位置(就是描述元素的位置，它有一个指针指向两个相邻的元素之间的)
	 *		有三个方法：
	 *			public interface Iterator<E> {
	 *				E next();
	 *				boolean hasNext();
	 *				void remove();
	 *			}
	 *
	 *		java的迭代器 查找操作与位置变更是紧密相连的。查找一个元素的唯一方法就是调用next，而在执行查找操作的同时，迭代器的位置随之向前移动。
	 *			所以应该将java的迭代器认为是位于两个元素之间。当调用next时，迭代器就越过下一个元素，并返回刚刚越过的那个元素的引用。
	 *			反复调用next就可以读取集合中的所有元素。 
	 */
	
	
	
	/*
	 * 	泛型的使用方法
	 * 		由于Collection与Iterator都是泛型的接口，可以编写操作任何类型的使用方法。
	 * 			例如，下面是一个检测任意集合是否包含指定元素的泛型方法。
	 * 		
	 */
	public static <E> boolean contains(Collection<E> c,Object obj){//这里可以传人一个任意的集合，和一个要比较的对象
		for (E e : c) {
			if(e.equals(obj)) return true;
		}
		return false;
 	}
	
	
	/*
	 * 	链表	
	 * 		在使用数组和数组列表都有一个重大的缺陷。这就是从中间删除一个元素要付出很大的代价，其原因就是数组中处于被删元素之后的所有元素都要向数组的前端移动。
	 * 		
	 * 		链表就解决了这个问题，链表将每个对象存放在独立的结点中。每个结点还存放着序列中下一个结点的引用。
	 * 			在java程序中，所有链表实际上都是双向的，那就是每一个对象都有特别的两个引用，一个是指向的前一个对象是谁，另一个是指向的后一个对象是谁。
	 * 				
	 * 		链表是一个有序的集合(set类型其中的元素完全是无序的)，每个对象的位置非常重要。
	 * 		  	LinkedList.add()方法是将一个对象添加到链表的尾部。(这是集合的方法)
	 * 			还有一个add方法是迭代器提供的，它可以将元素添加到集合的任意位置。(这是迭代器提供的方法)
	 * 				
	 * 			但是只有对有序的集合使用迭代器添加元素才有实际的意义。(例如还有一些集合不是有序的，例如set集合完全无序的)
	 * 			所有为了接口的通用性，或者是高度的抽象，Iterator接口中就没有提供add方法(如果提供的话set实现这个接口就要是实现这个方法，
	 * 				但是这个方法对set集合没有作用)。但在ListIterator(Iterator的子接口)提供了该方法,ListIterator不仅提供了add方法，
	 * 				还提供了两个方法是用来反向遍历集合的。ListIterator类的listIterator方法返回一个实现了ListIterator接口的对象。
	 * 
	 * 		链表不支持快速地随机访问，如果要查看链表中的第n个元素的时候，就必须从头开始，越过n+1个元素，没有捷径可走。
	 * 			鉴于这个原因，在程序员需要采用整数索引访问元素时，通常不选用链表。
	 * 			尽管是这样，LinkedList还是提供了get()这个方法。但是很明显，这个方法的效率不高。
	 */
	@Test
	public void linkedList() {
		//新建一个链表
		List<String> staff = new LinkedList<String>();
		//向链表添加三个元素
		staff.add("A");
		staff.add("B");
		staff.add("C");
		/*
		 *  还有一个迭代器ListIterator是Iterator的子接口，ListIterator类的listIterator方法返回一个实现了ListIterator接口的对象
		 *  	这个ListIterator接口的功能比较多
		 *  	有add方法，previous和hasprevious，功能跟next跟hasNext差不多。
		 *  	add方法依赖只是依赖于迭代器的位置，而remove方法依赖于迭代器的状态
		 *  	set方法是用一个新元素覆盖调用next或previous方法返回的上一个元素。
		 */
		Iterator<String> iter = staff.iterator();
		//返回第一个元素
		String one = iter.next();
		System.out.println("第一个元素是" + one);
		//返回第二个元素
		String two = iter.next();
		System.out.println("第二个元素是" + two);
		System.out.println("集合还剩的元素有" + staff.size());
		//删除一个元素，就是上一个next返回的元素，元素B被删除
		iter.remove();
		System.out.println("集合还剩的元素有" + staff.size());
		//进行遍历，使用”foreach"循环遍历的集合要实现Iterable接口，Collection实现了该接口
		System.out.println("----foreach遍历的-----");
	 	for (String s : staff) {
			System.out.print(s);
		}
		System.out.println();
		System.out.println("----hasNext+next遍历的-----");
		/*
		 * 	在这里用迭代器进行遍历是没法没法遍历全部的，因为上面迭代器的指针已经是第一个和第二个之间了。(因为有一个被删了)
		 * 		所以在这里只能是遍历一个出来剩下的一个
		 * 		
		 * 		但是也可以试一下ListIterator这个接口，这个接口两个方法是向前遍历的，可以将元素全部遍历出来的。
		 */
		while(iter.hasNext()){
			System.out.print(iter.next());
		}
		System.out.println("---用for循环加下标来遍历数组，绝对不应该使用这种方式，效率极低-----");
		// 每次调用get()查找一个元素都要从列表的头部重新开始搜索。LinkedList对象根本没有不做任何的缓存。
		for (int i = 0; i < staff.size(); i++) {
			System.out.print(staff.get(i));
		}
	}
	
	
	
	/*
	 * 	如果一个集合在中出现多个迭代器，并且这些迭代器久都进行读写。
	 * 		就有可能会有异常:例如，一个迭代器指向另一个迭代器刚刚删除元素的前面。 这个迭代器就是无效的，并且不能被再次使用。
	 * 			如果一个迭代器发现它的集合被另一个迭代器修改了，或者是被集合自身的方法修改了，就会抛出一个ConcurrentModificationException
	 * 
	 * 	为了避免发生并发修改的异常，请符合下面的规则:
	 * 		可以根据需要给容器附加许多的迭代器，但是这些迭代器只能是读取列表。另外，在单独附加一个既能读又能写的迭代器。 
	 */
	@Test
	public void onlyOneWrite(){
		List<String> staff = new LinkedList<String>();
		staff.add("A");
		staff.add("B");
		staff.add("C");
		ListIterator<String> iter = staff.listIterator();
		ListIterator<String> iter2 = staff.listIterator();
		iter.next();//迭代器一进行读操作
		iter.remove();//迭代器一进行写操作(集合被修改，其他迭代器不能用了，用了就会报错)
		iter2.next();//迭代器二进行读操作
	}
	
	
	
	/*
	 *	散列集
	 *		链表和数组可以按照人们的意愿排列元素的次序。但是，如果想要查看某个指定的元素的时候，却又忘记了它的位置。那么就需要访问所有元素，知道找到为止。
	 *			如果集合中的元素个数很多，那就会花费很多的时间。但如果不在意元素的顺序，可以有几种快速查找元素的数据结构，其缺点就是无法控制元素出现的次序。
	 *
	 *		有一种数据结构可以快速地查找所需要的对象，这就是散列表。
	 *			散列表为每一个对象计算整数，称为散列码。散列码是由对象的实例域产生的一个整数。
	 *			更准确的说，具有不同数据域的对象将产生不用的散列码。
	 *
	 *		在java中，散列表用链表数组实现的。每个列表被称为一个桶，要想查找表中对象的位置，就要先计算它的散列码。
	 *			然后与桶的总数取余，结果就是保存这个元素的桶的索引。
	 *			例如:某个对象 的散列码为76268，有128个桶，那么对象就保存在第108号桶中(76268/128=108).
	 *				素，就直接插进桶中就行了(一个桶是一个列表)，有其他元素的就要将该对象与桶中的元素进行比较。
	 *		
	 *		散列表可以实现几个重要的数据结构。其中最简单的就是set类型，set是没有重复元素的元素集合。
	 *			set的add方法首先在集合中查找该对象是否已经存在，如果不存在，就将这个对象添加到集合中。
	 *
	 *		java集合类库提供了一个HashSet类，它实现了基于散列表的集。可以用add方法添加元素。
	 *			contains方法已经被重新定义了，用来快速查看某个元素是否出现在集合中。它在某个桶中查找元素，而不用查看集合中的所有元素。
	 *
	 *		散列集迭代器将依次访问所有的桶。由于散列将元素分散在表中的各个位置，所以访问它们的顺序几乎是随机的。
	 *			只有不关心集合元素的顺序是才使用HashSet
	 */
	@Test
	public void hashSet(){
		//新建一个HashSet
		HashSet<String> hashSet = new HashSet<String>();
		//利用add方法添加元素，添加进集合的元素是杂乱无章的。
		hashSet.add("A");
		hashSet.add("B");
		hashSet.add("C");
		for (String s : hashSet) {
			System.out.println(s);
		}
		//contains方法已经被重新定义了，用来快速查看某个元素是否出现在集合中。它在某个桶中查找元素，而不用查看集合中的所有元素。
		boolean contains = hashSet.contains("A");
		System.out.println(contains);
	}
	
	
	
	
	/*
	 * 	树集
	 * 		TreeSet类与散列集十分类似，不过，它比散列集有所改进。
	 * 		树集是一个有序集合。可以以任意的顺序插入集合中。对集合遍历时，每个值将按照自动排列后的顺序呈现出来(TreeSet内部自动排序,程序员无法控制)
	 * 			排列使用树结构来完成的，每次将一个元素添加到树中时，都被放置在正确的排序位置上。所有，迭代器总是以排列好的顺序访问每一个元素。
	 * 
	 * 		树集(TreeSet)与散列集(HashSet)与数组或数组列表(ArrayList)的区别:
	 * 			在树集中添加元素比在散列集中添加元素要慢，但是要比数组或数组列表快多了
	 * 			
	 * 			回头一看，你可能会有疑虑:是否应该用树集取代散列集，毕竟，添加一个元素所花费的时间并不是很长，而且元素是自动排列的。
	 * 				选择使用哪一种数据类型取决于 你要收集什么样的数据，如果不需要对数据进行排序，就没必须付出排序的开销。
	 * 				更重要的是，对于有一些数据对它进行排序很困难，对它进行散列却是很容易的。
	 * 					散列函数只是将对象适当地打乱存放，而比较却要精确地判断每个对象
	 */
	@Test
	public void treeSet(){
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("A");
		treeSet.add("B");
		treeSet.add("C");
		for (String s : treeSet) {
			System.out.println(s);
		}
	}
	
	
	
	
	/*
	 * 	优先级队列
	 * 		元素可以按照任意的顺序插进，却总是按照排序的顺序进行检索。
	 * 			也就是说，无论何时调用remove方法，总会获取到最小的元素。
	 * 		
	 * 		然而，优先级队列，并没有对所有的元素进行排列，它是使用了一个优雅且高效的数据结构，称为"堆"。
	 * 			"堆"是一个可以自我调整的二叉树，对树进行添加和删除操作，可以让最小的元素移动到根，而不必花费时间对元素进行排序。
	 * 
	 * 		与TreeSet一样，一个优先级队列既可以保存实现了Comparable接口的类对象，也可以保存在构造器中提供比较器的对象。
	 * 
	 *		使用优先级队列的典型就是任务调度。每一个任务有一个优先级，任务以随机顺序添加队列中。
	 *			每当启动一个新的任务是，都将优先级最高的任务从队列中删除(习惯1为最高，所以会将最小的元素删除) 	
	 */
	@Test
	public void priorityQueue(){
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
		pq.add(new GregorianCalendar(1906,Calendar.DST_OFFSET,9));
		pq.add(new GregorianCalendar(1815,Calendar.DST_OFFSET,10));
		pq.add(new GregorianCalendar(1903,Calendar.DST_OFFSET,3));
		pq.add(new GregorianCalendar(1910,Calendar.DST_OFFSET,22));
		System.out.println("这里进行迭代，但是迭代是随机的");
		for (GregorianCalendar date : pq) {
			System.out.println(date.get(Calendar.YEAR));
		}
		System.out.println("这里是调用remove方法,返回的总是最小的那一个，等到的结果也是有顺序的");
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
	}
	
	
	
	/*
	 * 	映射表：
	 * 		映射表是用来存放键值对这个数据结构的。
	 * 
	 * 		java类库为映射表提供了两个通用的方法:HashMap和TreeMap。这两个类都实现了Map接口。
	 * 		
	 * 		散列映射表(HashMap)对键进行散列；树映射表用键的整体顺序对元素进行排序，并将其组织成搜索树。
	 * 			散列或比较函数只能作用于键。与键关联的值不能进行散或比较。
	 * 		
	 * 		那应该使用散列表还是树映射表?与集一样，散列快点，如果不需要按照排列顺序访问键，就最好选择散列。
	 * 
	 * 		
	 * 
	 */
	@Test
	public void hashMap(){
		//新建一个散列映射表
		Map<String,String> staff = new HashMap<String,String>();
		/*
		 * 添加一个元素
		 * 		每次向映射表中添加(使用put()方法)一个 值 时，必须同时提供一个键。在这里键和值都是一个字符串
		 * 		键必须是唯一的，如果同一个键调用两个put，则第二个值会取代原来的值，put方法返回的是被覆盖的值。
		 */
		staff.put("A", "A的值");
		staff.put("B", "B的值");
		staff.put("C", "C的值");
		/*
		 * 要想检索一个值，必须提供一个键
		 * 	如果在映射表中没有与键对应的值，将返回一个null
		 */
		String key = "A";
		String value = staff.get(key);
		//remove方法删除给定键对应的元素
		staff.remove(key);
		//size()方法返回映射表中的元素个数
		int size = staff.size();
		/*
		 * 	映射表的视图有三个
		 * 		键集， 值集合(不是集)， 键/值对集。
		 * 		下面的三个方法将返回三个视图
		 * 		Set<K> keySet()
		 * 		Collection<K> values()
		 * 		Set<Map.Entry<K,V>> entrySet()
		 */
		//键集
		System.out.println("-----打印键集-----");
		Set<String> keySet = staff.keySet();
		for (String k : keySet) {
			System.out.println(k);
		}
		//值集合(不是集)
		System.out.println("-----打印值集合-----");
		Collection<String> values = staff.values();
		for (String v : values) {
			System.out.println(v);
		}
		//键/值对集
		System.out.println("-----打印值键/值对集-----");
		Set<Entry<String,String>> entrySet = staff.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() +  entry.getValue());
		}
	}
	
	
	
	/*
	 * 	集合框架
	 * 		集合有两个基本的接口:Collection和Map
	 * 		Collection有子接口List和Set
	 * 			List是一个有序集合。元素可以添加到特定的位置。将对象放置到某个位置上有两种方式:
	 * 					使用整数的索引或使用列表的迭代器(使用的是ListIterator，这个接口才有add方法，是Iterator的一个子接口)
	 * 
	 * 			List接口定义了几个用于随机访问(就是随便输入一个下标，然后要进行检索)的方法:
	 * 				void add(int index,E element)
	 *				void get(int index)	 						
	 *				void remove(int index)
	 *			List接口在提供这些方法的时候，并没有考虑效率，为了避免执行较高成本的随机访问，可以参考RandomAccess这个接口。
	 *
	 *			Set接口与Collection接口是一样的，只是其方法的行为有着更加严密的定义。
	 *				集的add方法不允许添加相同的元素(因为Set集合是乱码的)。
	 *			
	 *		集合的接口有大量的方法，这些方法可以通过更基本的例行方法加以是实现。也有很多抽象类提供了许多这样的例行实现。
	 *			AbstractCollection
	 *			AbstractList
	 *			.....
	 *			像ArrayList这些类都是从这些抽象类中实现的，自己也可以继承这些类，实现自己的需求。
	 */
	
	 /*
	  *	视图与包装器：
	  *		通过使用视图，可以获得其他的实现了集合接口和映射表接口的对象。
	  *			例如:
	  *				映射表类的keySet方法就是一个这样的示例。初看起来，好像这个方法创建了一个新集，并将映射表中的所有键都填进去，然后返回这个集。
	  *				但事实上不是这样的，keySet放过返回一个实现Set接口的类对象，这个类的方法对原映射表进行操作。这种集合称为 视图。
	  * 	1.轻量级集包装器
	  * 		Arrays类的静态方法asList将返回一个包装了普通java数组的List包装器。
	  * 			这个方法可以将一个数组转化为一个List集合。
	  */
	@Test
	public void arrayAsList(){
		String[] a = new String[50];
		List<String> asList = Arrays.asList(a);
		/*
		 * 返回的对象不是ArrayList，它是一个视图对象，带有访问底层数组的get和set方法。
		 * 		假如使用改变数组大小的所有方法(例如迭代器相关的add，remove方法)(但可以改变数组内容，使用上面的get和set方法)
		 * 			都会抛出一个异常UnsupportedOperationException
		 */
		asList.add("A");//这里改变了数组的大小，所有会抛出一个异常
		asList.set(0, "D");//这里改变数组的内容是可以的，只要不改变数组的大小就可以了
		/*
		 * 在SE 5.0 开始，asList方法还支持将各个元素传递给它
		 */
		List<String> asList2 = Arrays.asList("A","S","D");
	}
	/*
	 * Collections.nCopies()这个方法调用，将返回一个不可修改的对象，并将一个n元素传进去
	 * 		Collections接口很多使用的方法，这些方法的参数和返回值都是集合。不要于Collection搞混了。·
	 */
	@Test
	public void oCopies(){
		List<String> nCopies = Collections.nCopies(10, "A");
		// 由于每个字符串对象只存储一次，所以付出的代价很小。这是视图技术的一种巧妙的应用。
		for (String s : nCopies) {
			System.out.println(s);
		}
		/*
		 * singleton方法返回一个视图对象。这个对象实现了Set接口
		 * 	返回的对象实现了一个不可修改的单元素集，而不需要付出建立数据结构的开销。
		 */
		Set<String> singleton = Collections.singleton("A");
		
	}
		


	/*
	 * 批处理
	 * 	在一个情况下避免使用迭代器就可以进行批处理
	 * 		比如希望找出两个交集，即两个集合中相同的元素
	 */
	@Test
	public void retainnAll(){
		//找出a集合与b集合的交集
		HashSet<String> a = new HashSet<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		HashSet<String> b = new HashSet<String>();
		b.add("A");
		b.add("B");
		b.add("E");
		
		//新建一个集合，并将a或者是b传进去
		HashSet<String> result = new HashSet<String>(a);
		result.retainAll(b);
		//这时候result集合中就是包含了a与b的交集了，并且没有使用到循环
		for (String s : result) {
			System.out.println(s);
		}
	}
	/*
	 * 将该思想进一步推进，应用于视图。
	 * 	假如有一个映射表，将员工的ID映射到员工的对，建立一个将要结束聘用的ID集，然后终止这些ID(从总的员工集中删除)。
	 */
	@Test
	public void removeAll(){
		//这个包含所有元素的映射表
		Map<Integer,String> a = new HashMap<Integer,String>();
		//向表中填充元素
		a.put(1, "A");
		a.put(2, "B");
		a.put(3, "C");
		a.put(4, "D");
		
		//建立一个键表，包含了即将要删除员工的ID
		Set<Integer> b = new HashSet<Integer>();
		b.add(1);
		b.add(2);
		
		/*
		 * 建立删除关系，把键表中出现的ID都从映射表中对应的元素删除
		 * 	现在已经把map集合a中键为1和2的元素从集合中移除了
		 */
		a.keySet().removeAll(b);
		
		//遍历Map集合a
		for (Entry<Integer, String> entry : a.entrySet()) {
			System.out.println(entry.getKey() +  entry.getValue());
		}
	}
	
	
	/*
	 * 数组与集合之间的转换
	 * 	Arrays.asList的包装器可以实现这个功能
	 */
	@Test
	public void arrayChangeToCollection(){
		//新建一个数组
		String[] array = {"A","B","C"};
		//将一个数组转换为一个集合
		List<String> list = Arrays.asList(array);
		//还可以指定它转换为什么类型的数组
		HashSet<String> hashset = new HashSet<String>(Arrays.asList(array));
		//遍历数组
		for (String s : list) {
			System.out.println(s);
		}

		/*
		 * 反过来将一个集合转换为一个数组就有点难了
		 * 	产生的是一个对象数组。就算知道集合中包含一个特定类型的对象，也不能使用强制转换。
		 */
		
		Object[] array2 = hashset.toArray();
		
		/*
		 * 由toArray方法返回的数组是一个Object[]数组，是无法改变它的类型，
		 * 	相反，使用另外一种toArray方法，将其设计为所希望的元素类型且长度为0的数组，这样做的话，返回的数组与所创建的数组是一样的
		 */
		String[] array3 = hashset.toArray(new String[0]);
		//如果愿意的话，还可以构造一个指定大小的数组
		hashset.toArray(new String[hashset.size()]);
		//在这种情况下没有创建任何新的数组
	}
	

	/*
	 * 算法
	 */
	//找出数组中最大的元素
	@Test
	public void arrayMax(){
		int[] a = {9,7,6,1,3,13};
		Integer max = a[0];
		for (int i = 1; i < a.length; i++) {
			/*
			 * a.compareTo(b),如果a比b大返回正数，a比b小返回负数，a与b相等返回0
			 */
			if (max.compareTo(a[i]) < 0) {
				max = a[i];
			}
		}
		System.out.println(max);
	}
	//链表应该怎么做?对于链表，无法实施高效的随机访问(随机访问就是通过例如数组下标这种东西)，但是可以通过迭代器
	@Test
	public void collectionMax(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(6);
		list.add(7);
		list.add(3);
		list.add(9);
		list.add(5);
		
		
		Iterator<Integer> iterator = list.iterator();
		//先把集合中的第一个数作为最大的
		Integer max = iterator.next();
		//判断集合是否存在下一个
		while(iterator.hasNext()){
			//有下一个的话把它拿出来
			Integer next = iterator.next();
			//把拿出来的下一个与最大的元素相比
			if (max.compareTo(next) < 0) {
				max = next;
			}
		}
		System.out.println(max);
	}

	/*
	 * 对于这些每次实现都是非常麻烦，每次都要编写代码，又很容易出错
	 * 	可以将max方法实现为能够接收任何实现了Collection接口的对象。
	 * 		就是下面这个max方法可以计算链表，数组列表或数组中最大元素。
	 */
	public static <T extends Comparable> T max(Collection<T> c) {
		if(c.isEmpty()){
			throw new NoSuchElementException();
		}
		Iterator<T> iterator = c.iterator();
		T max = iterator.next();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (max.compareTo(next) < 0) {
				max = next;
			}
		}
		return max;
	}
	
	
	
	/*
	 * 排序与混排
	 */
	@Test
	public void sort(){
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(54);
		arrayList.add(12);
		arrayList.add(13);
		arrayList.add(10);

		Collections.sort(arrayList);//这样的话arrayList进已经按照从小到大排好序了，遍历出来就可以了
		for (Integer i : arrayList) {
			System.out.println(i);
		}
	}
	
	/*
	 * 遗留的集合
	 * 	java语言问世以来就存在的集合类:Hashtable类是和非常有用的子类Properties丶Vector的子类Stack以及BitSet
	 * 	
	 * 		Hashtable类与HashMap类的作用一样，实际上，它们拥有相同的接口。
	 * 			与Vector类的方法一样。Hashtable也是同步的。如果对同步性或遗留代码的兼容性没有任何要求。就应该使用HashMap
	 * 			
	 * 			属性映射表
	 *				属性映射表是一个类型非常特殊的映射表结构。它有下面三个特征
	 *					·键与值都是字符串
	 *					·表可以保存到一个文件中，也可以从文件中加载出来
	 *					·使用一个默认的附助表
	 *				实现映射表通常用于程序的特殊配置选项。 				
	 * 		
	 */
	
	
	/*
	 * 锁对象
	 *		synchronized关键字自动提供一个锁以及相关的条件。对于大多数的需要显式锁，这是很便利的。
	 *		并且在SE 5.0引入了ReentrantLock类，java.util.concurrent框架为这些基础机制提供了独立的类。
	 */
	public void syObject(){
		new ObjectL();//这里只要介绍这个类ReentrantLock
	}
	
	
	
	
	
	
	
	
	
	
	
}

