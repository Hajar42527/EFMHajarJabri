create database if not exists db_appartements; 
use db_appartements;

create table RUE
(
  code_rue int primary key auto_increment,
  NOM_rue varchar(30)
);

create table IMMEUBLE
(
  num_immeuble int primary key auto_increment,
  nb_etages_total int,
  code_rue int,
  FOREIGN KEY (code_rue) REFERENCES RUE(code_rue)
);

create table ETAGE
(
  num_etage int primary key auto_increment,
  nb_appartements_tot int,
  num_immeuble int,
  FOREIGN KEY (num_immeuble) REFERENCES IMMEUBLE(num_immeuble)
);

create table APPARTEMENT
(
  lettre_appartement varchar(2) primary key,
  nb_pieces_total int,
  num_etage int,
  FOREIGN KEY (num_etage) REFERENCES ETAGE(num_etage)
);

insert into RUE values (null,'Flowers');
insert into RUE values (null,'JIHAD');
insert into RUE values (null,'Otman ben affan');
insert into RUE values (null,'EL Nidal');

insert into IMMEUBLE values (null,3,(select code_rue FROM RUE WHERE NOM_rue='Flowers'));
insert into IMMEUBLE values (null,4,(select code_rue FROM RUE WHERE NOM_rue='JIHAD'));
insert into IMMEUBLE values (null,4,(select code_rue FROM RUE WHERE NOM_rue='Otman ben affan'));
insert into IMMEUBLE values (null,5,(select code_rue FROM RUE WHERE NOM_rue='EL Nidal'));

insert into ETAGE values (null,4,1);
insert into ETAGE values (null,5,2);
insert into ETAGE values (null,4,3);
insert into ETAGE values (null,4,4);

insert into APPARTEMENT values ('A',11,1);
insert into APPARTEMENT values ('B',8,2);
insert into APPARTEMENT values ('C',10,2);
insert into APPARTEMENT values ('D',6,4);

