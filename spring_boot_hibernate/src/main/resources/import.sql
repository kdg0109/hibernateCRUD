CREATE TABLE emp (
       ename        VARCHAR2(20)  NOT NULL,
       job                   VARCHAR2(20)             NOT NULL,
       phone        VARCHAR2(15),
       CONSTRAINT PK_emp PRIMARY KEY(ename)
);

insert into emp values ('김준기', '그룹장', '01011111111');
insert into emp values ('임운혁', '팀잠', '01022222222');
insert into emp values ('송석일', '수석연구원', '01033333333');
insert into emp values ('정성호', '책임연구원', '01044444444');
insert into emp values ('제영호', '책임연구원', '01055555555');
insert into emp values ('유영규', '선임연구원', '01066666666');
insert into emp values ('이태규', '연구원', '01077777777');

commit;