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
	where kun_email ="Lee.Perez@lost.de"
group by his_status 
		


-- Für welche Produkte X interessiert sich Kunde Y?
select pro_name, kun_name
	from his_historie hh 
		join pro_produkte 
			on hh.his_pro_id = pro_id 
		join kun_kundenstamm 
			on hh.his_kun_id = kun_id
	where kun_name = "Azalia Larson" and his_status = "Angesehen"
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
	where kun_email = "Aaron.Compton@gmx.de" and his_status ="Angesehen"
group by kat_name 


-- Wieviele Produkte wurden am Tag X gekauft? 
select count(*)
	from his_historie hh 
	where his_status = "Gekauft" and his_zeitstempel like '%2020-05-19%'


-- Wie oft wird ein Produkt X angesehen? 
select count (*), his_status 
	from his_historie hh 
		join pro_produkte
			on hh.his_pro_id = pro_id 
	where his_status = "Angesehen" 
	and pro_name = "Unisex Rucksack Sandfarben 24/30 Adult"


-- Wie teuer sind Produkte die Kunde kauft/ansieht durchschnittlich?
select avg(pro_preis), kun_name
	from his_historie hh 
		join pro_produkte 
			on hh.his_pro_id = pro_id 
		join kun_kundenstamm 
			on hh.his_kun_id = kun_id 
	where kun_name = "Alana Joyner"
	
	
-- Welches Produkt hat sich Kunde X am meisten angesehen?
select count(his_status), pro_name
	from his_historie hh 
		join pro_produkte 
			on hh.his_pro_id = pro_id 
		join kun_kundenstamm 
			on hh.his_kun_id = kun_id 
	where his_status = "Angesehen" and kun_name = "Alana Joyner"
group by pro_name order by count(his_status) desc


-- Welche Kategorie läuft am besten?
select kat_name, count(his_status) 
	from his_historie hh 
		join pro_produkte 
		 	on hh.his_pro_id = pro_id
		join kat_kategorien 
			on pro_produkte.pro_kat_id = kat_id 
group by kat_name order by count(his_status) desc


-- Wie ist das Angesehen/Verkauft Verhältnis bei Kategorie X?
select kat_name, count(his_status), his_status  
	from his_historie hh 
		join pro_produkte 
		 	on hh.his_pro_id = pro_id
		join kat_kategorien 
			on pro_produkte.pro_kat_id = kat_id 
		where kat_name ="Gaming"
group by his_status




		





