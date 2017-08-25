package object;

import java.io.IOException;

/*
 * 自定义一个异常类
 * 		需要做的是定义一个派生于Exception的类，或者是派生于Exception子类的类(例如IOException)
 * 		   习惯上定义的类应该包含两个构造器，一个是默认的构造器，一个是带有详细信息的构造器(超类的toString方法会打印这些详细的信息，这在调试中是非常有用的)
 * 	
 */
public class ObjectJ extends IOException  {

	public ObjectJ(){}
	
	public ObjectJ(String gripe){
		super(gripe);
	}
	
	
}
