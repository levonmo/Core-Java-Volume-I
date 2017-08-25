package object;

import java.io.Serializable;

//泛型代码和虚拟机
public class ObjectK<T extends Comparable & Serializable>  implements Serializable {
	
	private T lower;
	private T upper;
	
	/*
	 * 原始的类型是:
	 * 		类型变量 T 会被替换成限定列表的第一个类型。
	 * 		如下
	 * 		
	 * 		public class ObjectK implements Serializable{
	 * 			private Comparable lower;
	 * 			private Comparable upper;
	 * 		}
	 * 		
	 * 		就是类里面所有有T的地方都被替换了，类的声明也被该了。因为在虚拟机里面是没有泛型类型的。
	 */
}
