
import java.io.Serializable;
import java.lang.reflect.Method;

public class BaseBean implements Serializable {

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BaseBean) {
			Method[] methods = this.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				String method = methods[i].getName();
				if(method.startsWith("get")) {
					method = method.substring("get".length());
					Object o = null;
					Object o1 = null;
					try {
						o = methods[i].invoke(this);
						o1 = methods[i].invoke(obj);
						if(!o.equals(o1)) {
							return false;
						}
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Method[] methods = this.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			String methodName = methods[i].getName();
			if (methodName.startsWith("get")) {
				sb.append(methodName.replaceFirst("get", ""));
				sb.append("->");
				Object o = null;
				try {
					o = methods[i].invoke(this);
					sb.append(o.toString());
				} catch (Exception e) {
					sb.append("invoke error!");
				}
				sb.append(";");
			}
		}
		return sb.toString();
	}

}
