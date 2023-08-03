Create database QLDA_SINHVIEN;
go
use QLDA_SINHVIEN;
Create table STUDENTS (
	MASV	nvarchar(50) not null,
	HOTEN	nvarchar(50),
	EMAIL	nvarchar(50) not null,
	SODT	nvarchar(15),
	GIOITINH nvarchar(3),
	DIACHI	nvarchar(50),
	HINH	nvarchar(500),
	constraint pk primary key (MASV)
);


Create table GRADE (
	ID		 int not null,
	MASV	 nvarchar(50) not null,
	TIENGANH float,
	TINHOC	 float,
	GDTC	 float,
	constraint pk_grade primary key (ID),
	constraint pk_grade_student foreign key (MASV) references STUDENTS(MASV)
);
CREATE TABLE USERS (
    USERNAME nvarchar(50) primary key not null,
    PASSWORD nvarchar(50) NOT NULL,
    ROLE nvarchar(50),
);

drop table USERS

-- Thêm dữ liệu vào bảng STUDENTS
INSERT INTO STUDENTS
VALUES
('SV001', N'Nguyễn Tú', 'tun@gmail.com', '0123786789', N'Nam', N'TP Hồ Chí Minh', null),
('SV002', N'Lê Thanh Trường', 'truonglt@gmail.com', '012345667', N'Nam', N'TP Hồ Chí Minh', null),
('SV003', N'Hoàng Hữu Thành', 'thanhhh@gmail.com', '0123456790', N'Nam', N'TP Hồ Chí Minh', null),
('SV004', N'Phùng Thành Phương', 'phuongpt@gmail.com', '0123456778', N'Nam', N'TP Hồ Chí Minh', null),
('SV005', N'Nguyễn Gia Huy', 'Huyng@gmail.com', '0123456765', N'Nam', N'TP Hồ Chí Minh', null),
('SV006', N'Nguyễn Võ Quốc Anh', 'anhnvq@gmail.com', '0123456754', N'Nam', N'TP Hồ Chí Minh', null),
('SV007', N'Trương Gia Kiệt', 'kiettg@gmail.com', '0123456733', N'Nam', N'TP Hồ Chí Minh', null),
('SV008', N'Nguyễn Gia Nguyên', 'nguyenng@gmail.com', '0123456776', N'Nam', N'TP Hồ Chí Minh', null),
('SV009', N'Khổng Minh Quang', 'quangkm@gmail.com', '0123456788', N'Nam', N'TP Hồ Chí Minh', null),
('SV010', N'Phạm Thế Vũ Duy', 'duyptv@gmail.com', '0123456711', N'Nam', N'TP Hồ Chí Minh', null)
-- Thêm dữ liệu vào bảng USER
INSERT INTO STUDENTS
VALUES
('giangvien','123','gv'),
('nguyentuakina','123','admin'),
('sinhvien1','sinhvien','sv'),
('sinhvien2','sinhvien','sv')

create trigger deleteStudent
on STUDENTS instead of delete
as
begin
	Delete from GRADE where GRADE.MASV in (Select MASV from deleted)
    Delete from USERS where USERNAME in (Select EMAIL from deleted)
	Delete from STUDENTS where MASV in (Select MASV from deleted)
end
delete from STUDENTS where MASV = 'SV001';




drop trigger deleteStudent

select * from USERS

