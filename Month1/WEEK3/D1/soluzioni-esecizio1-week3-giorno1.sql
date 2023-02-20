/* Estrarre il nome e il cognome dei clienti nati nel 1982 */
SELECT numerocliente, nome, cognome, regioneresidenza, datanascita
	FROM public.clienti WHERE DATE_PART('year',  datanascita) = 1982;

/*oppure*/

SELECT numerocliente, nome, cognome, regioneresidenza, datanascita
	FROM public.clienti WHERE EXTRACT(YEAR FROM datanascita) = 1982;
	
/*-----------------------------------------------------------------------*/
/* Estrarre il numero di fatture con iva al 20% */
SELECT COUNT(*) AS conteggiofatture
	FROM fatture
	WHERE iva = 20;
/*-----------------------------------------------------------------------*/
/* Riportare il numero di fatture e la somma dei relativi importi divisi per anno di fatturazione */
SELECT extract (year from datafattura) AS anno, 
COUNT (*) AS numerofattura,
SUM(importo) AS totaleimporto
FROM fatture
GROUP BY extract (year from datafattura)
/*-----------------------------------------------------------------------*/
/* Estrarre i prodotti attivati nel 2017 e che sono in produzione oppure in commercio */
SELECT *
FROM prodotti
WHERE  
  extract (year from dataattivazione) = 2017  
  AND (inproduzione = TRUE
  OR incommercio = TRUE);
/*-----------------------------------------------------------------------*/
/* Considerando soltanto le fatture con iva al 20 per cento, estrarre il numero di fatture per ogni anno */
SELECT   
   	extract (year from datafattura) AS anno,
   	COUNT(*) AS numerofatture
	FROM fatture
	WHERE iva=20
GROUP BY extract (year from datafattura);
/*-----------------------------------------------------------------------*/
/* Estrarre gli anni in cui sono state registrate più di 2 fatture con tipologia ‘A’ */
SELECT  
   extract (year from datafattura) AS anno,
   COUNT(*) AS numerofatture
FROM fatture
WHERE tipologia= 'A'
GROUP BY extract (year from datafattura)
HAVING COUNT(*) > 2;
/*-----------------------------------------------------------------------*/
/* Riportare l’elenco delle fatture (numero, importo, iva e data) con in aggiunta il nome del fornitore */
SELECT
   fa.numerofattura,
   fa.importo,
   fa.iva,  
   fa.datafattura,
   fo.denominazione 
      AS denominazionefornitori
FROM fatture as fa
LEFT JOIN fornitori as fo
ON fa.numerofornitore = fo.numerofornitore;
/*-----------------------------------------------------------------------*/
/* Estrarre il totale degli importi delle fatture divisi per residenza dei clienti */
SELECT 
  c.regioneresidenza,
  SUM(f.Importo) AS totaleimporto
FROM fatture AS f
INNER JOIN clienti AS c
  ON f.idcliente = c.numerocliente
GROUP BY c.regioneresidenza;
/*-----------------------------------------------------------------------*/
/* Estrarre il numero dei clienti nati nel 1980 che hanno almeno una fattura superiore a 50 euro */
SELECT  
   COUNT(DISTINCT C.numerocliente) 
                  AS numeroclienti
FROM clienti AS C
INNER JOIN fatture AS F
  ON C.numerocliente = F.idcliente  
WHERE extract (year from C.datanascita) = 1980
  AND F.importo > 50;
/*oppure*/
SELECT  
   COUNT(C.numerocliente) 
                  AS numeroclienti
FROM clienti AS c
WHERE extract (year from c.datanascita) = 1980
AND EXISTS (SELECT * FROM fatture AS f WHERE c.numerocliente = f.idcliente 
AND F.importo > 50);
/*-----------------------------------------------------------------------*/
/* Estrarre una colonna di nome “Denominazione” contenente il nome, seguito da un carattere “-“, seguito dal cognome, per i soli clienti residenti nella regione Lombardia */
SELECT CONCAT(nome,'-',cognome) AS denominazione
FROM clienti
WHERE regioneresidenza = 'Lombardia';  