package util;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author matsuda
 *
 * @param <T>
 */
public class SerializableArrayList<T> extends ArrayList<T> implements Serializable {
	
    public final Class<?> genericClass;

    public SerializableArrayList(@SuppressWarnings("unchecked") T... dummy) {
        if (dummy.length > 0)
            throw new IllegalArgumentException(
                "引数は指定できません");
        genericClass = dummy.getClass().getComponentType();
    }

    @SuppressWarnings("unchecked")
	public Class<T> getGenericClass() {
        return (Class<T>) genericClass;
    }
    
    public String getGenericClassName() {
    	return getGenericClass().getName();
    }
	
	@Override
	public String toString() {
		String s = "ジェネリクス型=" + getGenericClassName() + ":";
		for (Object obj : this) {
			s += "{" + obj.toString() + "}";
		}
		return s;
	}
}
