package com.cysd.bocai.pojo;

import java.util.Date;
import java.util.UUID;

public class QiShu {
	
	private String qs_id;
	private String qs_num; 
	private double daxiao_danshuang_peilv; 
	private double num_peilv;
	private int kaijiang_num;
	private double total_da; 
	private double total_xiao;
	private double total_dan; 
	private double total_shuang; 
	private double total_0; 
	private double total_1;
	private double total_2; 
	private double total_3; 
	private double total_4; 
	private double total_5;
	private double total_6; 
	private double total_7;
	private double total_8;
	private double total_9;
	private double daxiao_choushui;
	private double danshuang_choushui; 
	private double num_choushui;
	private Date createdatetime;
	
	public QiShu(){
		this.qs_id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		this.createdatetime = new Date();
	}
	
	public QiShu(String qs_id, String qs_num, double daxiao_danshuang_peilv,
			double num_peilv, int kaijiang_num, int total_da, int total_xiao,
			int total_dan, int total_shuang, int total_0, int total_1,
			int total_2, int total_3, int total_4, int total_5, int total_6,
			int total_7, int total_8, int total_9, double daxiao_choushui,
			double danshuang_choushui, double num_choushui, Date createdatetime) {
		super();
		this.qs_id = qs_id;
		this.qs_num = qs_num;
		this.daxiao_danshuang_peilv = daxiao_danshuang_peilv;
		this.num_peilv = num_peilv;
		this.kaijiang_num = kaijiang_num;
		this.total_da = total_da;
		this.total_xiao = total_xiao;
		this.total_dan = total_dan;
		this.total_shuang = total_shuang;
		this.total_0 = total_0;
		this.total_1 = total_1;
		this.total_2 = total_2;
		this.total_3 = total_3;
		this.total_4 = total_4;
		this.total_5 = total_5;
		this.total_6 = total_6;
		this.total_7 = total_7;
		this.total_8 = total_8;
		this.total_9 = total_9;
		this.daxiao_choushui = daxiao_choushui;
		this.danshuang_choushui = danshuang_choushui;
		this.num_choushui = num_choushui;
		this.createdatetime = createdatetime;
	}
	public String getQs_id() {
		return qs_id;
	}
	public void setQs_id(String qs_id) {
		this.qs_id = qs_id;
	}
	public String getQs_num() {
		return qs_num;
	}
	public void setQs_num(String qs_num) {
		this.qs_num = qs_num;
	}
	public double getDaxiao_danshuang_peilv() {
		return daxiao_danshuang_peilv;
	}
	public void setDaxiao_danshuang_peilv(double daxiao_danshuang_peilv) {
		this.daxiao_danshuang_peilv = daxiao_danshuang_peilv;
	}
	public double getNum_peilv() {
		return num_peilv;
	}
	public void setNum_peilv(double num_peilv) {
		this.num_peilv = num_peilv;
	}
	public int getKaijiang_num() {
		return kaijiang_num;
	}
	public void setKaijiang_num(int kaijiang_num) {
		this.kaijiang_num = kaijiang_num;
	}
	public double getTotal_da() {
		return total_da;
	}
	public void setTotal_da(double total_da) {
		this.total_da = total_da;
	}
	public double getTotal_xiao() {
		return total_xiao;
	}
	public void setTotal_xiao(double total_xiao) {
		this.total_xiao = total_xiao;
	}
	public double getTotal_dan() {
		return total_dan;
	}
	public void setTotal_dan(double total_dan) {
		this.total_dan = total_dan;
	}
	public double getTotal_shuang() {
		return total_shuang;
	}
	public void setTotal_shuang(double total_shuang) {
		this.total_shuang = total_shuang;
	}
	public double getTotal_0() {
		return total_0;
	}
	public void setTotal_0(double total_0) {
		this.total_0 = total_0;
	}
	public double getTotal_1() {
		return total_1;
	}
	public void setTotal_1(double total_1) {
		this.total_1 = total_1;
	}
	public double getTotal_2() {
		return total_2;
	}
	public void setTotal_2(double total_2) {
		this.total_2 = total_2;
	}
	public double getTotal_3() {
		return total_3;
	}
	public void setTotal_3(double total_3) {
		this.total_3 = total_3;
	}
	public double getTotal_4() {
		return total_4;
	}
	public void setTotal_4(double total_4) {
		this.total_4 = total_4;
	}
	public double getTotal_5() {
		return total_5;
	}
	public void setTotal_5(double total_5) {
		this.total_5 = total_5;
	}
	public double getTotal_6() {
		return total_6;
	}
	public void setTotal_6(double total_6) {
		this.total_6 = total_6;
	}
	public double getTotal_7() {
		return total_7;
	}
	public void setTotal_7(double total_7) {
		this.total_7 = total_7;
	}
	public double getTotal_8() {
		return total_8;
	}
	public void setTotal_8(double total_8) {
		this.total_8 = total_8;
	}
	public double getTotal_9() {
		return total_9;
	}
	public void setTotal_9(double total_9) {
		this.total_9 = total_9;
	}
	public double getDaxiao_choushui() {
		return daxiao_choushui;
	}
	public void setDaxiao_choushui(double daxiao_choushui) {
		this.daxiao_choushui = daxiao_choushui;
	}
	public double getDanshuang_choushui() {
		return danshuang_choushui;
	}
	public void setDanshuang_choushui(double danshuang_choushui) {
		this.danshuang_choushui = danshuang_choushui;
	}
	public double getNum_choushui() {
		return num_choushui;
	}
	public void setNum_choushui(double num_choushui) {
		this.num_choushui = num_choushui;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
}
