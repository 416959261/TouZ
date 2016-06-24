
=======================================期数表=================================
期数ID 期数 大小\单双赔率 0-9数字赔率 开奖号码 大（总）小（总） 单（总） 双（总）0-9（各个总）大小抽水 单双抽水 数字抽水

=======================================投注表=================================
期数ID 用户名 账户余额 大 小 单 双  0 1 2 3 4 5 6 7 8 9  总金额 中奖金额



create table qishu(
	qs_id varchar(32) not null,       -- 期数ID
	qs_num varchar(100),              -- 期数
	daxiao_danshuang_peilv dec(10,2), -- 大小\单双赔率
	num_peilv dec(10,2),    		  -- 0-9数字赔率
	kaijiang_num int,                 -- 开奖号码
	total_da dec(10,2),                     -- 大（总）
	total_xiao dec(10,2),                   -- 小（总）
	total_dan dec(10,2),                    -- 单（总） 
	total_shuang dec(10,2),                 -- 双（总） 
	total_0 dec(10,2),                      -- 数字 0 （总）
	total_1 dec(10,2),			          -- 数字 1 （总）
	total_2 dec(10,2),			          -- 数字 2 （总）
	total_3 dec(10,2),			          -- 数字 3 （总）
	total_4 dec(10,2),			          -- 数字 4 （总）
	total_5 dec(10,2),			          -- 数字 5 （总）
	total_6 dec(10,2),			          -- 数字 6 （总）
	total_7 dec(10,2),			          -- 数字 7 （总）
	total_8 dec(10,2),			          -- 数字 8 （总）
	total_9 dec(10,2),			          -- 数字 9 （总）
	daxiao_choushui dec(10,2),        -- 大小抽水
	danshuang_choushui dec(10,2),     -- 单双抽水
	num_choushui dec(10,2),           -- 数字抽水
	createdatetime datetime,
	PRIMARY KEY (qs_id)
);

create table touzhu(
	tz_id             varchar(32) not null,  -- 投注id
	qs_id             varchar(32) not null,  -- 期数id   
	u_name            varchar(50) not null,  -- 用户名称
	u_total_jine      dec(10,2),             -- 用户总金额
	u_shengyu_jine    dec(10,2),             -- 用户剩余金额 
	u_zhongjiang_jine dec(10,2),             -- 用户中奖金额 
	tz_da_jine        dec(10,2),             -- 投注 大 金额 
	tz_xiao_jine   	  dec(10,2),             -- 投注 小 金额
	tz_dan_jine       dec(10,2),             -- 投注 单 金额
	tz_shuang_jine    dec(10,2),             -- 投注 双 金额
	tz_0_jine         dec(10,2),             -- 投注 0  金额 
	tz_1_jine         dec(10,2),             -- 投注 1  金额 
	tz_2_jine         dec(10,2),             -- 投注 2  金额  
	tz_3_jine         dec(10,2),             -- 投注 3  金额   
	tz_4_jine         dec(10,2),             -- 投注 4  金额 
	tz_5_jine         dec(10,2),             -- 投注 5  金额 
	tz_6_jine         dec(10,2),             -- 投注 6  金额 
	tz_7_jine         dec(10,2),             -- 投注 7  金额 
	tz_8_jine         dec(10,2),             -- 投注 8  金额 
	tz_9_jine         dec(10,2),             -- 投注 9  金额 
	PRIMARY KEY (tz_id)
);