
-- Wieviele Produkte gibt es in Kategorie X?
select count(*)
	from pro_produkte pp
		join kat_kategorien 
			on pro_kat_id = kat_id 	
	where kat_name = "Körperpflege"



-- Wie oft sieht sich Kunde X ein Produkt an, wie oft kauft er?
select count(his_status), his_status 
	from his_historie hh
		join kun_kundenstamm
			on hh.his_kun_id = kun_id 
	where kun_email ="Lavinia.Mcclain@web.de"
group by his_status 
		


-- Für welche Produkte X interessiert sich Kunde Y?
select pro_name, kun_name
	from his_historie hh 
		join pro_produkte 
			on hh.his_pro_id = pro_id 
		join kun_kundenstamm 
			on hh.his_kun_id = kun_id
	where kun_name = "Lavinia Mcclain" and his_status = "Angesehen"
group by pro_name



-- Wie groß ist unser Kundenstamm?
select count(*)
	from kun_kundenstamm kk 



-- Welche Produktkategorien hat Kunde mit Email X angesehen?
select kat_name, kun_email
	from his_historie hh 
		join pro_produkte 
			on hh.his_pro_id = pro_id 
		join kat_kategorien 
			on pro_kat_id = kat_id
		join kun_kundenstamm 
			on hh.his_kun_id = kun_id
	where kun_email = "Lavinia.Mcclain@web.de" and his_status ="Angesehen"
group by kat_name 



-- Wieviele Produkte wurden am Tag X gekauft? 
select count(*)
	from his_historie hh 
	where his_status = "Gekauft"



-- Wie oft wird ein Produkt X angesehen? 
select count (*)
	from his_historie hh 
		join pro_produkte
			on hh.his_pro_id = pro_id 
	where his_status = "Angesehen" 
	and pro_name = "Gaming Bildschirm Mars RR296640  Orange"



-- Wie teuer sind Produkte die Kunde kauft/ansieht durchschnittlich?
select avg(pro_preis), kun_name
	from his_historie hh 
		join pro_produkte 
			on hh.his_pro_id = pro_id 
		join kun_kundenstamm 
			on hh.his_kun_id = kun_id 
	where kun_name = "Priscilla Barron"
