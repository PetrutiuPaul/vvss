package ppir2169MV.repository.repoInterfaces;


import ppir2169MV.model.Carte;

import java.util.List;

public interface CartiRepoInterface {
	void adaugaCarte(Carte c);
	void modificaCarte(Carte nou, Carte vechi);
	void stergeCarte(Carte c);
	List<Carte> cautaCarte(String ref);
	List<Carte> getCarti();
	List<Carte> getCartiOrdonateDinAnul(String an);
}
