package com.cysd.bocai;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.cysd.bocai.dao.SqlDao;
import com.cysd.bocai.pojo.QiShu;
import com.cysd.bocai.pojo.Touzhu;


public class View extends ViewPart {
	public static final String ID = "com.cysd.bocai.view";

	Text[][] table;
	Label[][] label;
	
	Label[][] labelhj;
	
	
	Text text_dspl;
	Text text_kjhm;
	Text text_szpl;
	
	Text text_qs;
	
	boolean isCleaned = true;

	/**
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */
	

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		
		int wzw = 20;
		int szw = 50;
		int szh = 20;
		int wjw = 70;
		int wjh = 20;
		
		
		parent.setLayout(null);
		
		table = new Text[20][17];
		label = new Label[20][2];
		labelhj = new Label[3][14];
		
		Color textColor = new Color(null,255,0,0);
		Color bgColor = new Color(null,255,100,100);
		Color bgColor2 = new Color(null,0,206,209);
		
		String[] arr_co = new String[]{"大", "小", "单", "双", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(int i=0; i < 16; i ++)
		{
			
			Label l1 = new Label(parent, SWT.BORDER);
			l1.setForeground(textColor);
//			l1.setText("a");
//			l1.setBounds(10 + i*65, 10, 30, 20);
			
			
			Text t1 = new Text(parent, SWT.BORDER);
			t1.setEnabled(false);
//			t1.setText("b");
//			t1.setBounds(10 + i*65 + 30, 10, 30, 20);
			
			if(i > 0 && i < 15)
			{
				
				l1.setText(arr_co[i-1]);
				l1.setBounds(10+wjw+i*(wjw+5), 10, wzw, 20);
				t1.setBounds(10+wjw+i*(wjw+5) + wzw, 10, szw, 20);
			}
			
			
			if(i == 0)
			{
				l1.setText("玩家");
				t1.setText("账户余额");
				t1.setForeground(textColor);
				l1.setBounds(10, 10, wjw, 20);
				t1.setBounds(10 + wjw, 10, wjw, 20);
			}else if(i == 15)
			{
				l1.setText("下注金额");
				t1.setText("中奖金额");
				t1.setForeground(textColor);
				l1.setBounds(10+wjw + i*(wjw+5), 10, wjw, 20);
				t1.setBounds(10+(wjw*2) + i*(wjw+5), 10, wjw, 20);
			}
		}
		
		for(int l=1; l < 21; l ++)
		{
			for(int i=0; i < 16; i ++)
			{
				
				Label l1 = new Label(parent, SWT.BORDER);
				l1.setForeground(textColor);
//				l1.setText("a");
//				l1.setBounds(10 + i*65, 10 + l*30, 30, 20);
				
				final Text t1 = new Text(parent, SWT.BORDER);
//				t1.setText("b");
//				t1.setBounds(10 + i*65 + 30, 10 + l*30, 30, 20);
				if(i > 0 && i < 15)
				{
					
					l1.setText(arr_co[i-1]);
					l1.setBounds(10+wjw + i*(wjw+5), 10 + l*szh, wzw, 20);
					t1.setBounds(10+wjw + i*(wjw+5) + wzw, 10 + l*szh, szw, 20);
					t1.setData("r",Integer.valueOf(l));
					t1.setData("c",Integer.valueOf(i));
					if(l>15){
						t1.setEnabled(false);
					}
					t1.addModifyListener(new ModifyListener(){

						public void modifyText(ModifyEvent e) {
							// TODO Auto-generated method stub
							int r = ((Integer)t1.getData("r")).intValue();
							int c = ((Integer)t1.getData("c")).intValue();
							
							String[] str=new String[14];
							for(int i=2;i<16;i++){
								Text text=table[r-1][i];
								str[i-2]=text.getText();
							}
							double xzje=tools.sumOneUsermoney(str);
							Double ye=0.00;
							try {
								ye=(Double) table[r-1][1].getData();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							if(ye==null||ye==0){
								ye=tools.String_to_double(table[r-1][1].getText());
								table[r-1][1].setData(ye);
							}
							table[r-1][1].setText(ye-xzje+"");
							Label la=label[r-1][0];
							la.setText(xzje+"");
							
							String[] str1=new String[20];
							for(int i=1;i<21;i++){
								Text text=table[i-1][c+1];
								str1[i-1]=text.getText();
							}
							
							Label tt = labelhj[0][c-1];
							tt.setText(tools.sumAllUserTypemoney(str1)+"");
							
							String da = labelhj[0][0].getText();
							String x = labelhj[0][1].getText();
							double dad = tools.String_to_double(da);
							double xd = tools.String_to_double(x);
							labelhj[1][0].setText("");
							labelhj[1][1].setText("");
							if(dad != xd)
							{
								if(dad > xd)
								{
									labelhj[1][0].setText(dad - xd + "");
								}else
								{
									labelhj[1][1].setText(xd - dad + "");
								}
							}
							
							
							
							String dan = labelhj[0][2].getText();
							String s = labelhj[0][3].getText();
							double dand = tools.String_to_double(dan);
							double sd = tools.String_to_double(s);
							labelhj[1][2].setText("");
							labelhj[1][3].setText("");
							if(dand != sd)
							{
								if(dand > sd)
								{
									labelhj[1][2].setText(dand - sd + "");
								}else
								{
									labelhj[1][3].setText(sd - dand + "");
								}
							}
							
						}
						
					});
				}
				
				if(i == 0)
				{
					Text t2 = new Text(parent, SWT.BORDER);
					t2.setForeground(textColor);
					t2.setBounds(10, 10 + l*szh, wjw, 20);
					l1.dispose();
					t1.setBounds(10 + wjw, 10 + l*szh, wjw, 20);
					
					table[l-1][i] = t2;
					
				}else if(i == 15)
				{
					l1.setBounds(10+wjw + i*(wjw+5), 10 + l*szh, wjw, 20);
					t1.setBounds(10+(wjw*2) + i*(wjw+5), 10 + l*szh, wjw, 20);
					t1.setEnabled(false);
					label[l-1][0]=l1;
				}
				
				table[l-1][i+1] = t1;
			}
		}
		
		
		Label label_cxqs = new Label(parent, SWT.BORDER);
		label_cxqs.setBounds(10, 600, 60, 25);
		label_cxqs.setText("查询期数");
		
		Text text_cxqs = new Text(parent, SWT.BORDER);
		text_cxqs.setBounds(75, 600, 100, 25);
		
		Label label_cxwj = new Label(parent, SWT.BORDER);
		label_cxwj.setBounds(10, 630, 60, 25);
		label_cxwj.setText("查询玩家");
		
		Text text_cxwj = new Text(parent, SWT.BORDER);
		text_cxwj.setBounds(75, 630, 100, 25);
		
		Button b_cxjg = new Button(parent, SWT.NONE);
		b_cxjg.setBounds(185, 610, 100, 30);
		b_cxjg.setText("查询结果");
		
		b_cxjg.addSelectionListener(new SelectionListener(){

			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				WqkjListDlg dlg = new WqkjListDlg(Display.getCurrent().getActiveShell());
				dlg.open();
				
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Label label_dspl = new Label(parent, SWT.BORDER);
		label_dspl.setBounds(300, 600, 90, 25);
		label_dspl.setText("大小单双赔率");
		
		text_dspl = new Text(parent, SWT.BORDER);
		text_dspl.setBounds(395, 600, 100, 25);
		text_dspl.setText(tools.da_xiao_dan_shuang_pl + "");
		
		Label label_szpl = new Label(parent, SWT.BORDER);
		label_szpl.setBounds(300, 630, 90, 25);
		label_szpl.setText("0-9数字赔率");
		
		text_szpl = new Text(parent, SWT.BORDER);
		text_szpl.setBounds(395, 630, 100, 25);
		text_szpl.setText(tools.shu_zi_pl+"");
		
		Label label_qs = new Label(parent, SWT.BORDER);
		label_qs.setBounds(505, 600, 60, 25);
		label_qs.setText("期数");
		
		
		text_qs = new Text(parent, SWT.BORDER);
		text_qs.setBounds(570, 600, 100, 25);
		
		
		Label label_kjhm = new Label(parent, SWT.BORDER);
		label_kjhm.setBounds(505, 630, 60, 25);
		label_kjhm.setText("开奖号码");
		
		
		text_kjhm = new Text(parent, SWT.BORDER);
		text_kjhm.setBounds(570, 630, 100, 25);
		
		
		Button b_ksjs = new Button(parent, SWT.NONE);
		b_ksjs.setBounds(680, 615, 100, 30);
		b_ksjs.setText("开始计算");
		b_ksjs.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				if(!isCleaned)
					return;
				isCleaned = false;
				// TODO Auto-generated method stub
				for(int i=0; i < 20; i ++)
				{
					String[] arr = new String[14];
					for(int j=0; j<14;j++)
					{
						String cost = table[i][j+2].getText();
						arr[j] = cost;
					}
					if(!tools.iswinnumber(text_kjhm.getText()))
						return;
					double d1 = tools.getLargeandSmallWinning(arr[0], arr[1], text_dspl.getText(), text_kjhm.getText());
					double d2 = tools.getdouandsigelWinning(arr[3], arr[2], text_dspl.getText(), text_kjhm.getText());
					double d3 = tools.calculateDigitWinning(arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10], arr[11], arr[12], arr[13], text_kjhm.getText(), tools.String_to_double(text_szpl.getText()));
					double d4 =tools.String_to_double(label[i][0].getText());
					if(!"".equals(label[i][0].getText().trim()))
					{
						table[i][16].setText(tools.formatDouble(d1+d2+d3)+"");
					}
				
					
					double yue = tools.formatDouble(tools.String_to_double(table[i][1].getText())+d1+d2+d3+d4);
					table[i][1].setText(yue+"");
					table[i][1].setData(yue);
					
//					if("".equals(table[i][1].getText().trim()))
//					{
//						table[i][1].setText("");
//					}
					
				}
				
				if(tools.isLargeandSmall(text_kjhm.getText()))
				{
					labelhj[2][0].setText(tools.getChoushui(labelhj[0][0].getText())+"");
				}else {
					labelhj[2][1].setText(tools.getChoushui(labelhj[0][1].getText())+"");
				}
				
				
				if(tools.isdouandsigel(text_kjhm.getText()))
				{
					labelhj[2][3].setText(tools.getChoushui(labelhj[0][3].getText())+"");
				}else {
					labelhj[2][2].setText(tools.getChoushui(labelhj[0][2].getText())+"");
				}
				
				int num = tools.String_to_Int(text_kjhm.getText());
				
				labelhj[2][num+4].setText(tools.getChoushui(labelhj[0][num+4].getText())+"");
				
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		Button b_bcjg = new Button(parent, SWT.NONE);
		b_bcjg.setBounds(790, 615, 100, 30);
		b_bcjg.setText("保存结果");
		b_bcjg.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				SqlDao dao = new SqlDao();
				QiShu qs = new QiShu();
				qs.setQs_num(text_qs.getText());
				qs.setDaxiao_danshuang_peilv(tools.String_to_double(text_dspl.getText()));
				qs.setNum_peilv(tools.String_to_double(text_szpl.getText()));
				qs.setKaijiang_num(tools.String_to_Int(text_kjhm.getText()));
				qs.setTotal_da(tools.String_to_double(labelhj[0][0].getText()));
				qs.setTotal_xiao(tools.String_to_double(labelhj[0][1].getText()));
				qs.setTotal_dan(tools.String_to_double(labelhj[0][2].getText()));
				qs.setTotal_shuang(tools.String_to_double(labelhj[0][3].getText()));
				qs.setTotal_0(tools.String_to_double(labelhj[0][4].getText()));
				qs.setTotal_1(tools.String_to_double(labelhj[0][5].getText()));
				qs.setTotal_2(tools.String_to_double(labelhj[0][6].getText()));
				qs.setTotal_3(tools.String_to_double(labelhj[0][7].getText()));
				qs.setTotal_4(tools.String_to_double(labelhj[0][8].getText()));
				qs.setTotal_5(tools.String_to_double(labelhj[0][9].getText()));
				qs.setTotal_6(tools.String_to_double(labelhj[0][10].getText()));
				qs.setTotal_7(tools.String_to_double(labelhj[0][11].getText()));
				qs.setTotal_8(tools.String_to_double(labelhj[0][12].getText()));
				qs.setTotal_9(tools.String_to_double(labelhj[0][13].getText()));
				
				if(tools.isLargeandSmall(text_kjhm.getText()))
				{
					qs.setDaxiao_choushui(tools.String_to_double(labelhj[2][0].getText()));
				}else {
					qs.setDaxiao_choushui(tools.String_to_double(labelhj[2][1].getText()));
				}
				
				if(tools.isdouandsigel(text_kjhm.getText()))
				{
					qs.setDanshuang_choushui(tools.String_to_double(labelhj[2][2].getText()));
				}else {
					qs.setDanshuang_choushui(tools.String_to_double(labelhj[2][3].getText()));
				}
				
				int num = tools.String_to_Int(text_kjhm.getText());
				
				qs.setNum_choushui(tools.String_to_double(labelhj[2][num+4].getText()));
				dao.addDbObject(qs);
				
				for(int i=0;i<20;i++)
				{
					Touzhu tz = new Touzhu();
					tz.setQs_id(qs.getQs_id());
					tz.setU_name(table[i][0].getText());
					tz.setU_total_jine(tools.String_to_double(label[i][0].getText()));
					tz.setU_shengyu_jine(tools.String_to_double(table[i][1].getText()));
					tz.setU_zhongjiang_jine(tools.String_to_double(table[i][16].getText()));
					tz.setTz_da_jine(tools.String_to_double(table[i][2].getText()));
					tz.setTz_xiao_jine(tools.String_to_double(table[i][3].getText()));
					tz.setTz_dan_jine(tools.String_to_double(table[i][4].getText()));
					tz.setTz_shuang_jine(tools.String_to_double(table[i][5].getText()));
					tz.setTz_0_jine(tools.String_to_double(table[i][6].getText()));
					tz.setTz_1_jine(tools.String_to_double(table[i][7].getText()));
					tz.setTz_2_jine(tools.String_to_double(table[i][8].getText()));
					tz.setTz_3_jine(tools.String_to_double(table[i][9].getText()));
					tz.setTz_4_jine(tools.String_to_double(table[i][10].getText()));
					tz.setTz_5_jine(tools.String_to_double(table[i][11].getText()));
					tz.setTz_6_jine(tools.String_to_double(table[i][12].getText()));
					tz.setTz_7_jine(tools.String_to_double(table[i][13].getText()));
					tz.setTz_8_jine(tools.String_to_double(table[i][14].getText()));
					tz.setTz_9_jine(tools.String_to_double(table[i][15].getText()));
					
					dao.addDbObject(tz);
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button b_jmql = new Button(parent, SWT.NONE);
		b_jmql.setBounds(900, 615, 100, 30);
		b_jmql.setText("界面清零");
		
		b_jmql.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				isCleaned = true;
				// TODO Auto-generated method stub
				for(int j=0;j<20;j++)
				{
					for(int i=2;i<17;i++)
					{
						table[j][i].setText("");
					}
					label[j][0].setText("");
					
				}
				
				for(int j=0;j<3;j++)
				{
					for(int i=0;i<14;i++)
					{
						labelhj[j][i].setText("");
					}
				}
				
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		int y = 10;
		
		for(int i=0; i < 16; i ++)
		{
			Label l1 = new Label(parent, SWT.BORDER);
			l1.setForeground(textColor);
			l1.setBackground(bgColor);
			Label t1 = new Label(parent, SWT.BORDER);
			t1.setBackground(bgColor);
			if(i > 0 && i < 15)
			{
				l1.setBounds(10+wjw+i*(wjw+5), 500, wzw, 20);
				if(i<15){
					l1.setText(arr_co[i-1]);
				}
				
				t1.setBounds(10+wjw+i*(wjw+5) + wzw, 500, szw, 20);
				labelhj[0][i-1] = t1;
			}
			
			if(i == 0)
			{
				l1.setText("下注合计");
				t1.setForeground(textColor);
				l1.setBounds(10, 500, wjw, 20);
				t1.setBounds(10 + wjw, 500, wjw, 20);
				
			}else if(i == 15)
			{
				t1.setForeground(textColor);
				l1.setBounds(10+wjw + i*(wjw+5), 500, wjw, 20);
				t1.setBounds(10+(wjw*2) + i*(wjw+5), 500, wjw, 20);
				
			}
		}
		
		for(int i=0; i < 16; i ++)
		{
			Label l1 = new Label(parent, SWT.BORDER);
			l1.setForeground(textColor);
			l1.setBackground(bgColor2);
			
			Label t1 = new Label(parent, SWT.BORDER);
			t1.setBackground(bgColor2);
			if(i > 0 && i < 15)
			{
				l1.setBounds(10+wjw+i*(wjw+5), 525, wzw, 20);
				t1.setBounds(10+wjw+i*(wjw+5) + wzw, 525, szw, 20);
				labelhj[1][i-1] = t1;
			}
			
			if(i == 0)
			{
				t1.setForeground(textColor);
				l1.setBounds(10, 525, wjw, 20);
				t1.setBounds(10 + wjw, 525, wjw, 20);
			}else if(i == 15)
			{
				t1.setForeground(textColor);
				l1.setBounds(10+wjw + i*(wjw+5), 525, wjw, 20);
				t1.setBounds(10+(wjw*2) + i*(wjw+5), 525, wjw, 20);
			}
		}
		
		
		for(int i=0; i < 16; i ++)
		{
			Label l1 = new Label(parent, SWT.BORDER);
			l1.setForeground(textColor);
			l1.setBackground(bgColor2);
			
			Label t1 = new Label(parent, SWT.BORDER);
			t1.setBackground(bgColor2);
			
			if(i > 0 && i < 15)
			{
				l1.setBounds(10+wjw+i*(wjw+5), 550, wzw, 20);
				t1.setBounds(10+wjw+i*(wjw+5) + wzw, 550, szw, 20);
				labelhj[2][i-1] = t1;
			}
			
			if(i == 0)
			{
				l1.setText("0-9抽水");
				t1.setForeground(textColor);
				l1.setBounds(10, 550, wjw, 20);
				t1.setBounds(10 + wjw, 550, wjw, 20);
			}else if(i == 15)
			{
				t1.setForeground(textColor);
				l1.setBounds(10+wjw + i*(wjw+5), 550, wjw, 20);
				t1.setBounds(10+(wjw*2) + i*(wjw+5), 550, wjw, 20);
			}
		}
		
		
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
//		viewer.getControl().setFocus();
	}
}