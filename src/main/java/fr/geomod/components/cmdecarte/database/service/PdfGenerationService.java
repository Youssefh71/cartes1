package fr.geomod.components.cmdecarte.database.service;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.database.model.entity.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;



import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;


@Service
@SpringBootApplication
public class PdfGenerationService {


     public void createPdf(Optional<Client> client , File dest, Optional<Devis> devis, Optional<Contact> contact, Optional<Banque> banque, Basket basket) throws IOException {



        String clientTest = "fr";

        String src = "./src/main/resources/pdf/model.pdf";

         Map<String, Integer> listCell = new HashMap<>();


         for(BasketCell cell: basket.getCells()){

             //récupere l'identifiant du pays (FR, GB ou autre)

             String pays = cell.getCellId().substring(0, 2);

             //Vérifier si il y déja de la donnée pour se pays.
             //Si il n'yen a pas on viens initialiser la hasmap à 1;
             if(!listCell.containsKey(pays)) {
                 listCell.put(pays,1);

             }    else {
                 //Si une valeur existe déjà rajouter +1 à la valeur existante

                 listCell.put(pays,listCell.get(pays)+1);

             }

         }

         System.out.println(listCell);
         System.out.println(basket.getCells().size());

         /**
          * Add of quote elements
          */
         // Date Deadline
         Calendar echeance = Calendar.getInstance();
         echeance.add(Calendar.DATE, devis.get().getValidity());
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

         // Initialize PDF document
         PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));

         Document document = new Document(pdfDoc);

         // Add Quote
         document.add(new Paragraph(devis.get().getNumero()).setFixedPosition(95, 699, 60).setFontSize(9).setBold());

         // Add Date
         document.add(new Paragraph(devis.get().getDateDevis().toString()).setFixedPosition(95, 684, 60).setFontSize(9));

         // Add Validity
         document.add(new Paragraph(devis.get().getValidity() + " jours").setFixedPosition(95, 669, 60).setFontSize(9));

         // Add Validity - Deadline
         document.add(new Paragraph(sdf.format(echeance.getTime())).setFixedPosition(95, 655, 60).setFontSize(9));


         /**
          * Add coordinates of Geomod
          */
         // Add mail Geomod
         document.add(new Paragraph(contact.get().getMail()).setFixedPosition(95, 601, 100).setFontSize(9));

         // Add phone Geomod
         document.add(new Paragraph(contact.get().getPhone()).setFixedPosition(92, 587, 300).setFontSize(9));



         /**
          * Add customer details
          */

         if ("fr".equalsIgnoreCase(clientTest)) {

             // Add customer adresse french

             Text name = new Text(client.get().getName()).setFontSize(10).setBold();
             Text adresse = new Text(client.get().getAdresse()).setFontSize(10);
             Text adresse2 = new Text(client.get().getAdresse2()).setFontSize(10);
             Text ville = new Text(client.get().getVille()).setFontSize(10);
             Text zipCode = new Text(client.get().getZipCode()).setFontSize(10);
             Paragraph p = new Paragraph()
                     .add(name).add("\n")
                     .add(adresse).add("\n")
                     .add(adresse2).add("\n")
                     .add(adresse2).add("\n")
                     .add(adresse2).add("\n")
                     .add(adresse2).add("\n")
                     .add(zipCode).add(" ").add(ville)
                     .setRelativePosition(300, 100, 200,0);


             document.add(p);


         } else {

             // Add customer adresse english

             Text nameEn = new Text(client.get().getName()).setFontSize(10).setBold();
             Text adresse = new Text(client.get().getAdresse()).setFontSize(10);
             Text adresse2 = new Text(client.get().getAdresse2()).setFontSize(10);
             Text ville = new Text(client.get().getVille()).setFontSize(10);
             //Text pays= new Text(clientId.getPays())
             //.setFontSize(10);
             Text zipCode = new Text(client.get().getZipCode()).setFontSize(10);
             Paragraph customer = new Paragraph().add(nameEn).add("\n").add(adresse).add("\n").add(adresse2).add("\n").add(ville).add("\n")
                     //.add(pays)
                     .add("\n").add(zipCode).setFixedPosition(320, 638, 200);

             document.add(customer);


         }


         /**
          * Add order detail
          */
         //Add code
         document.add(new Paragraph("701-01").setFontSize(9).setFixedPosition(40, 500, 30));
         //Add Designation
         document.add(new Paragraph("S Exploitation ENC (Droit)").setFontSize(9).setFixedPosition(85, 500, 200));
         //Add Qte
         document.add(new Paragraph("1").setFontSize(9).setFixedPosition(385, 500, 100));
         //Add price
         document.add(new Paragraph("177.46 €").setFontSize(9).setFixedPosition(427, 500, 100));
         //Add Total HT
         document.add(new Paragraph("177.46 €").setFontSize(9).setFixedPosition(493, 500, 100));
         //Add TVA
         document.add(new Paragraph("20.0%").setFontSize(9).setFixedPosition(535, 500, 100));


         /**
          * Add Geomod bank details
          */
         // Add Name Bank
         document.add(new Paragraph(banque.get().getName()).setFixedPosition(165, 197, 100).setFontSize(9));

         // Add Iban Bank
         document.add(new Paragraph(banque.get().getIban()).setFixedPosition(165, 182, 300).setFontSize(9));

         // Add Bic Bank
         document.add(new Paragraph(banque.get().getBic()).setFixedPosition(165, 167, 300).setFontSize(9));


         document.close();

    }


}
