
-- Welche Produktkategorien hat Kunde mit Email X angesehen?
select kat_name, pro_name, kun_email
from his_historie hh 
inner join pro_produkte 
	on hh.his_pro_id = pro_id 
inner join kat_kategorien 
	on pro_kat_id = kat_id
inner join kun_kundenstamm 
	on hh.his_kun_id = kun_id
where kun_email = "Lavinia.Mcclain@web.de"


-- Wie oft wird ein Produkt X angesehen? 
select count (*)from his_historie hh 
inner join pro_produkte
	on hh.his_pro_id = pro_id 
where his_status = "Angesehen" and pro_name = "Gaming Bildschirm Mars RR296640  Orange"


-- Wie teuer sind Produkte die Kunde kauft/ansieht durchschnittlich?
select avg(pro_preis), kun_name
from his_historie hh 
	inner join pro_produkte 
		on hh.his_pro_id = pro_id 
	inner join kun_kundenstamm 
		on hh.his_kun_id = kun_id 
where kun_name = "Priscilla Barron"
