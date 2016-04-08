import java.util.Map;


public class Convert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = "SYS_C000000";
		Map<String,Object> map = delSysData(o);
		System.out.println(map);
	}
	
	public static Map<String, Object> delSysData(Object obj){
		  if(!obj.toString().startsWith("SYS_C")){
			  return (Map<String, Object>) obj;
		  }
		  return null;
	  }

}
