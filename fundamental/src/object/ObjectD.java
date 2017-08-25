package object;

import java.util.Date;

public class ObjectD implements Cloneable  {
	
	private Integer a;
	private Date date;

	public Integer getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	@Override
	public ObjectD clone() throws CloneNotSupportedException {
		ObjectD objectD = (ObjectD)super.clone();
		objectD.date = (Date)date.clone();
		/*因为Date是可变的实例域，进行深拷贝就一样要进行拷贝，不能是两个对象引用同一可变得实例域
		 * Date也实现了Cloneable该接口，只有实现该接口的类才可以实现克隆
		 */
		return objectD;
	}

	@Override
	public String toString() {
		return "ObjectD [a=" + a + "]";
	}
	
	
	
}
