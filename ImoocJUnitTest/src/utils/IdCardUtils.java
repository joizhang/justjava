package utils;

public class IdCardUtils {
	private int[] weight={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};    //十七位数字本体码权重
	private char[] validate={ '1','0','X','9','8','7','6','5','4','3','2'};    //mod11,对应校验码字符值
	/**
	 * 将15位的身份证转化为18位的
	 * */
	public String convert(String sfzh){
		int sum = 0;
		int mode = 0;
		String sfzh_17 = sfzh.substring(0,6)+"19"+sfzh.substring(6);		//见身份证号转化为17位
		
		for(int i = 0; i < sfzh_17.length(); i++){
			sum = sum + Integer.parseInt(String.valueOf(sfzh_17.charAt(i)))*weight[i];
		}
		
		mode = sum % 11;
		String sfzh_last = String.valueOf(validate[mode]);
		String sfzh_18 = sfzh_17 + sfzh_last;
		return sfzh_18;
	} 
	
	
	public String getCsrq(String sfzh){
		String csrq = "", sfzh_18 = "";
		if(sfzh.length() == 15){
			sfzh_18 = convert(sfzh);
		}
		csrq = sfzh_18.substring(6, 14);
		return csrq;
	}
	
	public String getXb(String sfzh){
		String xb = "", sfzh_18 = "";
		if(sfzh.length() == 15){
			sfzh_18 = convert(sfzh);
		}
		xb = sfzh_18.substring(16, 17);
		
		if(xb.equals("1")){
			return "男";
		} else {
			return "女";
		}
	}
	
	public String getMm(String sfzh){
		String mm = "";
		mm = sfzh.substring(9, 15);
		return mm;
	}
}
