package fr.geomod.components.cmdecarte.database.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import fr.geomod.components.cmdecarte.basket.controler.BasketControler;
import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketComparison;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;
import fr.geomod.components.cmdecarte.database.model.entity.Client;
import fr.geomod.components.cmdecarte.database.model.entity.Devis;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

@Service
@SpringBootApplication
public class PdfGenerationService {

    public static void main(String[] args) {


        File basketRef = new File("./data/basket1.xml");
        File devis = new File("./data_pdf/devis.pdf");

        Basket basketReference;
        
        basketReference = new BasketJaxbImpl();
        basketReference.loadBasket(basketRef);
        
        //Charger objet client depuis la BDD
        
        Client client = null;
        
        PdfGenerationService pdf = new PdfGenerationService();
        pdf.createPdf(client, basketReference, devis);
        
    }

    public void createPdf(Client client , Basket basket, File devis) {


    }


}
