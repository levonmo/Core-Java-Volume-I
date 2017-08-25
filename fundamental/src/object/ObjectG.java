package object;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

import object.ObjectF.TimePrinter;

//这是一个内部类的例子
public class ObjectG  {
	
	private int time;
	private boolean beep;
	
	public ObjectG(int time,boolean beep) {
		this.time = time;
		this.beep = beep;
	}
	
	public void start( final boolean beep){//这里被修改为final，局部变量，内部类是可以访问到的，但是要被声明为final
		final String name = "ha";
		//这是一个内部类
		class TimePrinter implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 在这里要想使用局部变量就必须把变量声明为final
				 */
				System.out.println(name);
				System.out.println(beep);
				/*
				 * 	声明为final的变量是不能被修改的，只能是赋值一次就不能在改变了。例如这行代码是会被报错的:beep = false;
				 * 		那为什么内部类访问的局部变量一定要被声明为final?
				 * 			注意这个方法start(),当这个方法结束之后beep变量就会不存在，但是定时器还要工作的啊，定时器里面还是要用到beep变量啊
				 * 			为了能让actionPerformed()方法工作，在方法start()结束值之前，
				 * 			把局部变量beep释放之前进行备份，为了保持一致性，就需要将局部变量声明为final，不允许修改了。
				 * 
				 * 		在这里看一下这个类的反射出来的:
				 * 			class ObjectG&TimePrinter{
				 * 				ObjectG&TimePrinter(ObjectG,boolean);//这是它的构造器,这是编译器自动构造的
				 * 				public void actionPerformed(java.awt.event.ActionEvent);
				 * 				final boolean val$beep;
				 * 				final ObjectG this$0;
				 * 			}
				 * 		当创建这个对象的时候，beep就会被传递给构造器，保持在val$beep域中。
				 * 		编译器必须检测对局部变量的访问，为每一个变量建立相应的数据域，并将局部变量拷贝到构造器中，以便将这些数据域初始化为局部变量的副本。
				 */
				Date date = new Date();
				System.out.println("now is" + date);
			}
		}
		
		ActionListener timePrinter = new TimePrinter();
		Timer timer = new Timer(1000,timePrinter);
		timer.start();
		
	}
	
	
}
