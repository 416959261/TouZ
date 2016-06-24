package com.cysd.bocai.pojo;

import java.util.UUID;

public class Touzhu {
	
	private String tz_id;
	private String qs_id;
	private String u_name;
	private double u_total_jine;
	private double u_shengyu_jine;
	private double u_zhongjiang_jine;
	private double tz_da_jine;
	private double tz_xiao_jine;
	private double tz_dan_jine;
	private double tz_shuang_jine;
	private double tz_0_jine;
	private double tz_1_jine;
	private double tz_2_jine;
	private double tz_3_jine;
	private double tz_4_jine;
	private double tz_5_jine;
	private double tz_6_jine;
	private double tz_7_jine;
	private double tz_8_jine; 
	private double tz_9_jine;
	
	public Touzhu(){
		this.tz_id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	public Touzhu(String tz_id, String qs_id, String u_name,
			double u_total_jine, double u_shengyu_jine,
			double u_zhongjiang_jine, double tz_da_jine, double tz_xiao_jine,
			double tz_dan_jine, double tz_shuang_jine, double tz_0_jine,
			double tz_1_jine, double tz_2_jine, double tz_3_jine,
			double tz_4_jine, double tz_5_jine, double tz_6_jine,
			double tz_7_jine, double tz_8_jine, double tz_9_jine) {
		this.tz_id = tz_id;
		this.qs_id = qs_id;
		this.u_name = u_name;
		this.u_total_jine = u_total_jine;
		this.u_shengyu_jine = u_shengyu_jine;
		this.u_zhongjiang_jine = u_zhongjiang_jine;
		this.tz_da_jine = tz_da_jine;
		this.tz_xiao_jine = tz_xiao_jine;
		this.tz_dan_jine = tz_dan_jine;
		this.tz_shuang_jine = tz_shuang_jine;
		this.tz_0_jine = tz_0_jine;
		this.tz_1_jine = tz_1_jine;
		this.tz_2_jine = tz_2_jine;
		this.tz_3_jine = tz_3_jine;
		this.tz_4_jine = tz_4_jine;
		this.tz_5_jine = tz_5_jine;
		this.tz_6_jine = tz_6_jine;
		this.tz_7_jine = tz_7_jine;
		this.tz_8_jine = tz_8_jine;
		this.tz_9_jine = tz_9_jine;
	}
	
	public String getTz_id() {
		return tz_id;
	}
	public void setTz_id(String tz_id) {
		this.tz_id = tz_id;
	}
	public String getQs_id() {
		return qs_id;
	}
	public void setQs_id(String qs_id) {
		this.qs_id = qs_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public double getU_total_jine() {
		return u_total_jine;
	}
	public void setU_total_jine(double u_total_jine) {
		this.u_total_jine = u_total_jine;
	}
	public double getU_shengyu_jine() {
		return u_shengyu_jine;
	}
	public void setU_shengyu_jine(double u_shengyu_jine) {
		this.u_shengyu_jine = u_shengyu_jine;
	}
	public double getU_zhongjiang_jine() {
		return u_zhongjiang_jine;
	}
	public void setU_zhongjiang_jine(double u_zhongjiang_jine) {
		this.u_zhongjiang_jine = u_zhongjiang_jine;
	}
	public double getTz_da_jine() {
		return tz_da_jine;
	}
	public void setTz_da_jine(double tz_da_jine) {
		this.tz_da_jine = tz_da_jine;
	}
	public double getTz_xiao_jine() {
		return tz_xiao_jine;
	}
	public void setTz_xiao_jine(double tz_xiao_jine) {
		this.tz_xiao_jine = tz_xiao_jine;
	}
	public double getTz_dan_jine() {
		return tz_dan_jine;
	}
	public void setTz_dan_jine(double tz_dan_jine) {
		this.tz_dan_jine = tz_dan_jine;
	}
	public double getTz_shuang_jine() {
		return tz_shuang_jine;
	}
	public void setTz_shuang_jine(double tz_shuang_jine) {
		this.tz_shuang_jine = tz_shuang_jine;
	}
	public double getTz_0_jine() {
		return tz_0_jine;
	}
	public void setTz_0_jine(double tz_0_jine) {
		this.tz_0_jine = tz_0_jine;
	}
	public double getTz_1_jine() {
		return tz_1_jine;
	}
	public void setTz_1_jine(double tz_1_jine) {
		this.tz_1_jine = tz_1_jine;
	}
	public double getTz_2_jine() {
		return tz_2_jine;
	}
	public void setTz_2_jine(double tz_2_jine) {
		this.tz_2_jine = tz_2_jine;
	}
	public double getTz_3_jine() {
		return tz_3_jine;
	}
	public void setTz_3_jine(double tz_3_jine) {
		this.tz_3_jine = tz_3_jine;
	}
	public double getTz_4_jine() {
		return tz_4_jine;
	}
	public void setTz_4_jine(double tz_4_jine) {
		this.tz_4_jine = tz_4_jine;
	}
	public double getTz_5_jine() {
		return tz_5_jine;
	}
	public void setTz_5_jine(double tz_5_jine) {
		this.tz_5_jine = tz_5_jine;
	}
	public double getTz_6_jine() {
		return tz_6_jine;
	}
	public void setTz_6_jine(double tz_6_jine) {
		this.tz_6_jine = tz_6_jine;
	}
	public double getTz_7_jine() {
		return tz_7_jine;
	}
	public void setTz_7_jine(double tz_7_jine) {
		this.tz_7_jine = tz_7_jine;
	}
	public double getTz_8_jine() {
		return tz_8_jine;
	}
	public void setTz_8_jine(double tz_8_jine) {
		this.tz_8_jine = tz_8_jine;
	}
	public double getTz_9_jine() {
		return tz_9_jine;
	}
	public void setTz_9_jine(double tz_9_jine) {
		this.tz_9_jine = tz_9_jine;
	}
}
