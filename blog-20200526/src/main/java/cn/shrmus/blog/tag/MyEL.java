package cn.shrmus.blog.tag;

import cn.shrmus.blog.pojo.BlogPrivilege;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 自定义el表达式，判断集合是否包含一个元素
 * <p>Title:MyEL</p>
 * <p>Description:</p>
 * @author Shr
 * @date 2018年3月6日下午12:22:55
 * @version
 */
public class MyEL{

	public static boolean contains(List<Object> objects,Object element) {
		for(Object obj:objects) {
			BlogPrivilege temp = (BlogPrivilege)obj; 
			BlogPrivilege elementPrivilege = (BlogPrivilege)element;
			if(temp.getId() == elementPrivilege.getId()) {
				return true;
			}
		}
		return false;
	}
}
