package com.cysd.bocai;


public class tools {

	public static java.text.DecimalFormat df = new java.text.DecimalFormat(
			"#.00");

	/**
	 * 默认的大小单双赔率
	 */
	public static final double da_xiao_dan_shuang_pl = 0.92;
	
	/**
	 * 抽水比率
	 */
	public static final double choushui_shuang_pl = 0.91;
	
	/**
	 * 默认的数字赔率
	 */
	public static final double shu_zi_pl = 8;

	public static void main(String[] main) {
		System.out.println(getdouandsigelWinning("100", "80", "", "7"));

	}

	/**
	 * 计算大小中奖金额
	 */
	public static double getLargeandSmallWinning(String large, String samll,
			String bili, String winnnumber) {

		double zmoney = 0.00;

		double lar = String_to_double(large);
		double sma = String_to_double(samll);
		double bi = String_to_double(bili);
		if (bi == 0) {
			bi = da_xiao_dan_shuang_pl;
		}
		int win = String_to_Int(winnnumber);
		if (win == -1) {
			return -1;
		}
		if (lar > 0) {
			if (win > 4) {
				zmoney += lar * bi;
			} else {
				zmoney -= lar;
			}
		}
		if (sma > 0) {
			if (win < 5) {
				zmoney += sma * bi;
			} else {
				zmoney -= sma;
			}
		}

		return String_to_double(df.format(zmoney));
	}

	/**
	 * 计算单双中奖金额
	 */
	public static double getdouandsigelWinning(String large, String samll,
			String bili, String winnnumber) {

		double zmoney = 0.00;

		double dou = String_to_double(large);
		double sig = String_to_double(samll);
		double bi = String_to_double(bili);
		if (bi == 0) {
			bi = da_xiao_dan_shuang_pl;
		}
		int win = String_to_Int(winnnumber);
		if (win == -1) {
			return -1;
		}
		int ds = win % 2;

		if (dou > 0) {
			if (ds == 0) {
				zmoney += dou * bi;
			} else {
				zmoney -= dou;
			}
		}
		if (sig > 0) {
			if (ds != 0) {
				zmoney += sig * bi;
			} else {
				zmoney -= sig;
			}
		}
		return String_to_double(df.format(zmoney));
	}

	
	public static double formatDouble(double dou)
	{
		
		return String_to_double(df.format(dou));
		
	}
	

	/**
	 * 计算抽水
	 */
	public static double getChoushui(String summoney) {

		double zmoney = 0.00;
		double sum = String_to_double(summoney);
		zmoney=choushui_shuang_pl*sum;
		return String_to_double(df.format(zmoney));
	}

	
	/**
	 * 计算大小  true=大  ; false=小
	 */
	public static boolean isLargeandSmall(String winnnumber){
		int win = String_to_Int(winnnumber);
		if(win>4){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 计算大小  true=双 ; false=单
	 */
	public static boolean isdouandsigel(String winnnumber){
		int win = String_to_Int(winnnumber);
		int ds = win % 2;
		if(ds==0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * 一个用户的 投入的下注金额
	 **/
	public static double sumOneUsermoney(String[] moneys) {

		double summoney = 0;
		if(moneys == null)
			return summoney;
		for(int i=0;i<moneys.length;i++){
			summoney += String_to_double(moneys[i]);
		}
		return summoney;
	}

	/**
	 * 所有用户的 投入的单项下注金额的
	 **/
	public static double sumAllUserTypemoney(String[] moneys) {
		double summoney = 0;
		if(moneys == null)
			return summoney;
		for(int i=0;i<moneys.length;i++){
			summoney += String_to_double(moneys[i]);
		}
		return summoney;
	}

	/**
	 * 中奖本金
	 * @return
	 */
	public static double zhongqiangbengjing(String[] moneys,String winnumber){
		double win = 0.0;
		int d_winnumber = String_to_Int(winnumber);
		
		if(isLargeandSmall(winnumber)){
			win+=String_to_double(moneys[0]);
		}else{
			win+=String_to_double(moneys[1]);
		}
		
		if(isdouandsigel(winnumber)){
			win+=String_to_double(moneys[3]);
		}else{
			win+=String_to_double(moneys[2]);
		}
		
		if(String_to_double(moneys[d_winnumber+4])!=0){
			win+=String_to_double(moneys[d_winnumber+4]);
		}
		
		return win;
		
	}
	
	
	/**
	 * 数字中奖金额计算
	 */
	public static double calculateDigitWinning(String zero, String one,
			String two, String three, String four, String five, String six,
			String seven, String eight, String nine, String winnumber,
			double da_xiao_dan_shuang_pl) {

		double win = 0.0;
		int d_winnumber = String_to_Int(winnumber);

		double d_zero = String_to_double(zero);
		double d_one = String_to_double(one);
		double d_two = String_to_double(two);
		double d_three = String_to_double(three);
		double d_four = String_to_double(four);
		double d_five = String_to_double(five);
		double d_six = String_to_double(six);
		double d_seven = String_to_double(seven);
		double d_eight = String_to_double(eight);
		double d_nine = String_to_double(nine);

		// 本金
		double ben_jin = d_zero + d_one + d_two + d_three + d_four + d_five
				+ d_six + d_seven + d_eight + d_nine;

		switch (d_winnumber) {
		case 0:
			win += d_zero * (1 + da_xiao_dan_shuang_pl);
			break;
		case 1:
			win += d_one * (1 + da_xiao_dan_shuang_pl);
			break;
		case 2:
			win += d_two * (1 + da_xiao_dan_shuang_pl);
			break;
		case 3:
			win += d_three * (1 + da_xiao_dan_shuang_pl);
			break;
		case 4:
			win += d_four * (1 + da_xiao_dan_shuang_pl);
			break;
		case 5:
			win += d_five * (1 + da_xiao_dan_shuang_pl);
			break;
		case 6:
			win += d_six * (1 + da_xiao_dan_shuang_pl);
			break;
		case 7:
			win += d_seven * (1 + da_xiao_dan_shuang_pl);
			break;
		case 8:
			win += d_eight * (1 + da_xiao_dan_shuang_pl);
			break;
		case 9:
			win += d_nine * (1 + da_xiao_dan_shuang_pl);
			break;
		}

		return win - ben_jin;

	}


	/**
	 * 字符串 转 double
	 **/
	public static double String_to_double(String str) {
		double dou = 0.00;
		try {
			dou = Double.parseDouble(str);
		} catch (Exception e) {
		}
		return dou;
	}

	/**
	 * 中奖号码是否正确
	 * 
	 * @param win
	 * @return
	 */
	public static boolean iswinnumber(String win) {
		int w = String_to_Int(win);
		if (w >= 0 && w <= 9) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串 转 int
	 **/

	public static int String_to_Int(String str) {
		int dou = -1;
		try {
			dou = Integer.parseInt(str);
		} catch (Exception e) {
		}
		return dou;
	}

}
