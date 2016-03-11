--update table users
INSERT INTO USER (NAME, BIRTH_DATE, USER_ROLE, EMAIL) VALUES ('Olga', parsedatetime('25-06-1987', 'dd-MM-yyyy'), 'ADMIN', 'olga_bogu@mail.com');
INSERT INTO USER (NAME, BIRTH_DATE, USER_ROLE, EMAIL) VALUES ('John', parsedatetime('16-02-1978', 'dd-MM-yyyy'), 'CLIENT', 'john_smith@mail.com');
--update table events
INSERT INTO EVENT (NAME, RATING, BASE_PRICE) VALUES ('movie 1','HIGH', 15.2);
INSERT INTO EVENT_DATE_MP VALUES ((SELECT ID FROM EVENT WHERE NAME = 'movie 1'), GETDATE());
INSERT INTO EVENT (NAME, RATING, BASE_PRICE) VALUES ('movie 2','MID', 20.0);
INSERT INTO EVENT_DATE_MP VALUES ((SELECT ID FROM EVENT WHERE NAME = 'movie 2'), GETDATE());
INSERT INTO EVENT (NAME, RATING, BASE_PRICE) VALUES ('movie 3','LOW', 32.0);
INSERT INTO EVENT_DATE_MP VALUES ((SELECT ID FROM EVENT WHERE NAME = 'movie 3'), GETDATE());
--update table discount_statistics
INSERT INTO DISCOUNT_STATISTICS (DISCOUNT, COUNTER) VALUES ('BIRTHDAY', 0);
INSERT INTO DISCOUNT_STATISTICS (DISCOUNT, COUNTER) VALUES ('TICKET', 0);
