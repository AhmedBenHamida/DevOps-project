package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
@RunWith(SpringJUnit4ClassRunner.class)
public class IStockServiceTest {
		
	
	
	
	StockRepository stockRepository;
	
	 @Before
	    public void setUp() { // NOSONAR
		 	stockRepository = mock(stockRepository.class);
	        
	    }

	    @Test
	    void retrieveAllStocks() {
	        //Given
	        this.setUp();
	        List<Stock> stockList = new ArrayList<>();
	        Stock stockOne = new Stock();
	        stockOne.setIdStock(1l);
	        stockOne.setLibelleStock("XWRE0823");
	        stockOne.setQte(5);
	        stockOne.setQteMin(2);
	        Stock stockTwo = new Stock();
	        stockTwo.setIdStock(1l);
	        stockTwo.setLibelleStock("XWRE0823");
	        stockTwo.setQte(5);
	        stockTwo.setQteMin(2);
	        stockList.add(stockOne);
	        stockList.add(stockTwo);
	        when(stockRepository.findAll()).thenReturn(stockList);
	        //When

	        List<Stock> list = stockList;
	        //Then
	        assertEquals(list.size(),2);
	    }

}
