package object;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

//定时器，结合test来看
public class ObjectE implements ActionListener {

	//符合条件了执行该方法
	public void actionPerformed(ActionEvent e) {
		Date date = new Date();
		System.out.println(date);
	}
	
}
