package object;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

//这是一个闹钟，需要传人几秒闹一次，要不要铃声
public class ObjectF  {
	
	private int time;
	private boolean beep;
	
	public ObjectF(int time,boolean beep) {
		this.time = time;
		this.beep = beep;
	}
	
	/*	这是一个内部类
	 * 		内部类是如何获取外围类的数据的
	 * 	
	 * 	将该外围类通过反射可以等到一个方法
	 * 		public boolean access$0(ObjectF)
	 *	 		这个方法是返回一个外围类中的实例boolean beep，传人的参数是外围类对象
	 *
	 *		通过调用access$0方法就可以读取私有变量.
	 *		
	 *		当内部类需要外围类的boolean beep时，内部类就会调用这个方法，然后就会返回该值
	 */
	public class TimePrinter implements ActionListener{
		
		//定时器每到时间要执行的方法
		public void actionPerformed(ActionEvent e) {
			Date date = new Date();
			System.out.println(date);
			if(beep){//等价于if(outer.beep)---将外围类对象的引用称为outer
				//类TimePrinter没有beep的实例域，内部类可以访问外围类对象的数据域
				System.out.println("打印了beep");
			}
		}
	}
	
	public void start(){
		TimePrinter timePrinter = new TimePrinter();
//		TimePrinter timePrinter1 = this.new TimePrinter();//也可以这样实例化一个内部类this关键字
		Timer timer = new Timer(time,timePrinter);//第二个参数需要将一个实现了ActionListener接口的对象传进去
		timer.start();
	}
	
}
