package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
class IFournisseurServiceTest {

    FournisseurRepository fournisseurRepository;

    FournisseurServiceImpl fournisseurService;

    DetailFournisseurRepository detailFournisseurRepository;

    SecteurActiviteRepository secteurActiviteRepository;

    ProduitRepository produitRepository;

    @Before
    public void setUp() { // NOSONAR
        fournisseurRepository = mock(FournisseurRepository.class);
        detailFournisseurRepository = mock(DetailFournisseurRepository.class);
        secteurActiviteRepository = mock(SecteurActiviteRepository.class);
        produitRepository = mock(ProduitRepository.class);
        fournisseurService = new FournisseurServiceImpl();
    }

    @Test
    void retrieveAllFournisseurs() {
        //Given
        this.setUp();
        List<Fournisseur> fournisseurList = new ArrayList<>();
        Fournisseur fournisseurOne = new Fournisseur();
        fournisseurOne.setIdFournisseur(1l);
        fournisseurOne.setCode("XWRE0823");
        fournisseurOne.setLibelle("libelle");
        fournisseurOne.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        Fournisseur fournisseurTwo = new Fournisseur();
        fournisseurTwo.setIdFournisseur(2l);
        fournisseurTwo.setCode("XWRE0824");
        fournisseurTwo.setLibelle("libelleTwo");
        fournisseurTwo.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        fournisseurList.add(fournisseurOne);
        fournisseurList.add(fournisseurTwo);
        when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
        //When

        List<Fournisseur> list = fournisseurService.retrieveAllFournisseurs();
        //Then
        assertEquals(list.size(),2);
    }

    @Test
    void addFournisseur() {
        //Given
        this.setUp();
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCode("XWRE0823");
        fournisseur.setLibelle("libelle");
        Fournisseur newFournisseur = new Fournisseur();
        newFournisseur.setIdFournisseur(1l);
        newFournisseur.setCode("XWRE0823");
        newFournisseur.setLibelle("libelle");
        when(fournisseurRepository.save(any())).thenReturn(newFournisseur);
        //When
        Fournisseur createdFournisseur = fournisseurService.addFournisseur(fournisseur);
        //Then
        assertEquals(createdFournisseur.getCode(), "XWRE0823");
        assertEquals(createdFournisseur.getLibelle(), "libelle");
    }
}