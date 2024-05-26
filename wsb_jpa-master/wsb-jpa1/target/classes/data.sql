
insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'Bieszczady', '62-030'),
            (2, 'xx', 'yy', 'Zawada', '62-666'),
            (3, 'xx', 'yy', 'Zielona', '65-030'),
            (4, 'xx', 'yy', 'Wroclaw', '50-030'),
            (5, 'xx', 'yy', 'Hel', '66-666');

insert into doctor (id, first_name, last_name,telephone_number, email, doctor_number,specialization)
            values (1, 'Jan','Plaszczka','888-666-666', 'monikajestpiekna@gmail.com', '1','SURGEON'),
            (2, 'Zdzisiu','Kruk','222-666-666', 'zdzisiujestpiekna@gmail.com', '2','GP'),
            (3, 'Gabi','Drzewiecka','333-666-666', 'gabijestpiekna@gmail.com', '3','DERMATOLOGIST'),
            (4, 'Billie','Eillish','444-666-666', 'billiejestpiekna@gmail.com', '4','OCULIST'),
            (5, 'Gran','Canari','555-666-666', 'granjestpiekna@gmail.com', '5','SURGEON');

insert into patient (id, first_name, last_name,telephone_number, email, patient_number, date_of_birth, age, address_id)
            values (1, 'Monika', 'Nudziara','111-111-111','zyciekestnudne@gmail.com','1','1999-01-01',5,1),
            (2, 'Homar', 'Gruszka','222-222-222','homarkestnudne@gmail.com','2','1999-01-01',55,2),
            (3, 'Gabrys', 'Kopara','333-333-333','gabryskestnudne@gmail.com','3','1999-01-01',105,3),
            (4, 'Gnom', 'Zgredek','111111111111','gnomkestnudne@gmail.com','4','1999-01-01',4,4),
            (5, 'Garnek', 'Maly','111111111111','garnekkestnudne@gmail.com','5','1999-01-01',5,5);

insert into MEDICAL_TREATMENT (id, description, type)
            values (1, 'sth','USG'),
            (2, 'else','RTG'),
            (3, 'power','EKG');

insert into visit (id, description, time, doctor_id, patient_id)
            values (1, 'sth','1991-01-01 12:00:00',
            (SELECT id FROM DOCTOR WHERE id = 1),
            (SELECT id FROM PATIENT WHERE id = 1)),
            (2, 'else','1992-01-01 12:00:00',
            (SELECT id FROM DOCTOR WHERE id = 2),
            (SELECT id FROM PATIENT WHERE id = 2)),
            (3, 'power','1993-01-01 12:00:00',
            (SELECT id FROM DOCTOR WHERE id = 3),
            (SELECT id FROM PATIENT WHERE id = 3)),
            (4, 'sth','1994-01-01 12:00:00',
            (SELECT id FROM DOCTOR WHERE id = 4),
            (SELECT id FROM PATIENT WHERE id = 4)),
            (5, 'power','1995-01-01 12:00:00',
            (SELECT id FROM DOCTOR WHERE id = 5),
            (SELECT id FROM PATIENT WHERE id = 5));
