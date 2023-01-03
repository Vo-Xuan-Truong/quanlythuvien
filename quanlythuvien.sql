create database quanlythuvien;

CREATE TABLE librarian (
  `id` INT NOT NULL AUTO_INCREMENT primary key,
  `ten` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `sodienthoai` VARCHAR(45) NULL
);
  
  
  CREATE TABLE user (
  `masinhvien` VARCHAR(45) NOT NULL primary key,
  `ten` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `sodienthoai` VARCHAR(45) NULL
  );
  
  create table book(
	masach varchar(50)  not null primary key,
    tensach varchar(50)  not null,
    tacgia varchar(50)  not null,
    nhaxuatban varchar(50)  not null,
    soluong int  not null
);

  CREATE TABLE `quanlythuvien`.`muonsach` (
  `mamuon` INT NOT NULL AUTO_INCREMENT primary key,
  `masinhvien` VARCHAR(45) NOT NULL,
  `masach` VARCHAR(50) NOT NULL,
  `ngaymuon` DATE NOT NULL,
  `trangthaitra` VARCHAR(45) NOT NULL default 'no',
  CONSTRAINT fk_book FOREIGN KEY (masach) REFERENCES book(masach),
  CONSTRAINT fk_user FOREIGN KEY (masinhvien) REFERENCES user(masinhvien)
   );




INSERT INTO `quanlythuvien`.`user` (`masinhvien`, `ten`, `email`, `password`, `sodienthoai`) VALUES ('SV1', 'Hoc Sinh A', 'hsa@gmail.com', '123', '123456789');
INSERT INTO `quanlythuvien`.`user` (`masinhvien`, `ten`, `email`, `password`, `sodienthoai`) VALUES ('SV2', 'Hoc Sinh B', 'hsb@gmail.com', '123', '123456788');


INSERT INTO `quanlythuvien`.`librarian` (`ten`, `email`, `password`, `sodienthoai`) VALUES ('librarian1', 'l1@gmail.com', '123', '0987654321');
INSERT INTO `quanlythuvien`.`librarian` (`ten`, `email`, `password`, `sodienthoai`) VALUES ('librarian2', 'l2@gmail.com', '123', '0987654322');

INSERT INTO `quanlythuvien`.`book` (`masach`, `tensach`, `tacgia`, `nhaxuatban`, `soluong`) VALUES ('B1', 'SachA', 'TG1', 'KD', '10');
INSERT INTO `quanlythuvien`.`book` (`masach`, `tensach`, `tacgia`, `nhaxuatban`, `soluong`) VALUES ('B2', 'SachB', 'TG2', 'KD', '10');
INSERT INTO `quanlythuvien`.`book` (`masach`, `tensach`, `tacgia`, `nhaxuatban`, `soluong`) VALUES ('B3', 'SachC', 'TG3', 'KD', '10');

INSERT INTO `quanlythuvien`.`muonsach` (`mamuon`, `masinhvien`, `masach`, `ngaymuon`, `trangthaitra`) VALUES ('1', 'SV2', 'B1', '2022/1/1', 'no');
INSERT INTO `quanlythuvien`.`muonsach` (`mamuon`, `masinhvien`, `masach`, `ngaymuon`, `trangthaitra`) VALUES ('2', 'SV2', 'B2', '2022/1/2', 'yes');
