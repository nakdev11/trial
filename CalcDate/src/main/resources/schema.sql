create database if not exists mydb;

use mydb;

drop table if exists calc_date_tbl;

create table calc_date_tbl(
	date_id varchar(10) primary key,
	date_name varchar(100),
	calc_value_y int(5),
	calc_value_m int(5),
	calc_value_d int(5));
	