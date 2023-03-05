package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceComuni;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceProvince;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceComuniRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceProvinceRepo;

@Service
public class BeServiceComuniservice {

	@Autowired
	BeServiceComuniRepo cR;

	@Autowired
	BeServiceProvinceRepo pR;

	public void saveComuni() throws FileNotFoundException, IOException {

		// crea array di solo province dal csv province
		ArrayList<String> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/province-italiane.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				records.add(values[1]);
			}
		}

		// genera il db dei comuni con id della provincia
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/comuni.csv"));

			// Salta la prima riga contenente le intestazioni delle colonne
			String line = br.readLine();

			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");

				BeServiceComuni c = new BeServiceComuni();
				BeServiceProvince p = new BeServiceProvince();

				// Parsa l'id della provincia come long
				// Prendi l'array di Province e associa l indice del valore all "province_id"
				// nella tabella comuni
				p.setId((long) records.indexOf(data[3]));

				c.setBeServiceProvince(p);
				c.setNome(data[2]);

				// Salva la provincia solo se non esiste già nel database
				if (pR.findById(p.getId()).isEmpty()) {
					pR.save(p);

				}

				// Salva il db dei comuni
				cR.save(c);

			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveProvince() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/province-italiane.csv"));

			// Salta la prima riga contenente le intestazioni delle colonne
			String line = br.readLine();

			Long i;
			i = (long) 0;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");

				BeServiceProvince p = new BeServiceProvince();

				// incremento fittizio del id delle province
				i = i + 1;
				p.setId(i);

				p.setNome(data[1]);
				p.setSigla(data[0]);

				// Salva la provincia solo se non esiste già nel database
				if (pR.findById(p.getId()).isEmpty()) {
					pR.save(p);
				}

				// Salva il db delle province
				pR.save(p);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// regex per eliminare numeri fittizzi dalla stringa
	public int parseNumber(String input) {
		String cleanedInput = input.replace("\uFEFF", "").replaceFirst("^0+(?!$)", "");
		return Integer.parseInt(cleanedInput);
	}

}
