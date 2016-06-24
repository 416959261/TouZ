
=======================================������=================================
����ID ���� ��С\��˫���� 0-9�������� �������� ���ܣ�С���ܣ� �����ܣ� ˫���ܣ�0-9�������ܣ���С��ˮ ��˫��ˮ ���ֳ�ˮ

=======================================Ͷע��=================================
����ID �û��� �˻���� �� С �� ˫  0 1 2 3 4 5 6 7 8 9  �ܽ�� �н����



create table qishu(
	qs_id varchar(32) not null,       -- ����ID
	qs_num varchar(100),              -- ����
	daxiao_danshuang_peilv dec(10,2), -- ��С\��˫����
	num_peilv dec(10,2),    		  -- 0-9��������
	kaijiang_num int,                 -- ��������
	total_da dec(10,2),                     -- ���ܣ�
	total_xiao dec(10,2),                   -- С���ܣ�
	total_dan dec(10,2),                    -- �����ܣ� 
	total_shuang dec(10,2),                 -- ˫���ܣ� 
	total_0 dec(10,2),                      -- ���� 0 ���ܣ�
	total_1 dec(10,2),			          -- ���� 1 ���ܣ�
	total_2 dec(10,2),			          -- ���� 2 ���ܣ�
	total_3 dec(10,2),			          -- ���� 3 ���ܣ�
	total_4 dec(10,2),			          -- ���� 4 ���ܣ�
	total_5 dec(10,2),			          -- ���� 5 ���ܣ�
	total_6 dec(10,2),			          -- ���� 6 ���ܣ�
	total_7 dec(10,2),			          -- ���� 7 ���ܣ�
	total_8 dec(10,2),			          -- ���� 8 ���ܣ�
	total_9 dec(10,2),			          -- ���� 9 ���ܣ�
	daxiao_choushui dec(10,2),        -- ��С��ˮ
	danshuang_choushui dec(10,2),     -- ��˫��ˮ
	num_choushui dec(10,2),           -- ���ֳ�ˮ
	createdatetime datetime,
	PRIMARY KEY (qs_id)
);

create table touzhu(
	tz_id             varchar(32) not null,  -- Ͷעid
	qs_id             varchar(32) not null,  -- ����id   
	u_name            varchar(50) not null,  -- �û�����
	u_total_jine      dec(10,2),             -- �û��ܽ��
	u_shengyu_jine    dec(10,2),             -- �û�ʣ���� 
	u_zhongjiang_jine dec(10,2),             -- �û��н���� 
	tz_da_jine        dec(10,2),             -- Ͷע �� ��� 
	tz_xiao_jine   	  dec(10,2),             -- Ͷע С ���
	tz_dan_jine       dec(10,2),             -- Ͷע �� ���
	tz_shuang_jine    dec(10,2),             -- Ͷע ˫ ���
	tz_0_jine         dec(10,2),             -- Ͷע 0  ��� 
	tz_1_jine         dec(10,2),             -- Ͷע 1  ��� 
	tz_2_jine         dec(10,2),             -- Ͷע 2  ���  
	tz_3_jine         dec(10,2),             -- Ͷע 3  ���   
	tz_4_jine         dec(10,2),             -- Ͷע 4  ��� 
	tz_5_jine         dec(10,2),             -- Ͷע 5  ��� 
	tz_6_jine         dec(10,2),             -- Ͷע 6  ��� 
	tz_7_jine         dec(10,2),             -- Ͷע 7  ��� 
	tz_8_jine         dec(10,2),             -- Ͷע 8  ��� 
	tz_9_jine         dec(10,2),             -- Ͷע 9  ��� 
	PRIMARY KEY (tz_id)
);