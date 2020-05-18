-- Wieviele Produkte gibt es in Kategorie X?
SELECT * FROM pro_produkte WHERE pro_kat_id = ?

-- Wie oft sieht sich Kunde X ein Produkt an, wie oft kauft er?
SELECT his_status table his_historie WHERE his_status = ? AND his_kun_id = ? 

-- Für welche Produkte X interessiert sich Kunde Y?
SELECT his_pro_id table his_historie WHERE his_kun_id = ? 

-- Wie groß ist unser Kundenstamm?
SELECT * FROM kun_kundenstamm

-- Wieviele Produkte wurden am Tag X gekauft? 
SELECT * FROM his_historie WHERE his_status = Gekauft


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
