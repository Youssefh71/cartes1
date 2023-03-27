package fr.geomod.components.cmdecarte.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.persistence.entity.Banque;
import fr.geomod.components.cmdecarte.persistence.entity.Client;
import fr.geomod.components.cmdecarte.persistence.entity.Contact;
import fr.geomod.components.cmdecarte.persistence.entity.Devis;
import fr.geomod.components.cmdecarte.persistence.entity.Tva;
import fr.geomod.components.cmdecarte.persistence.entity.UserPermit;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class PdfGenerationService {

    public void createPdf(Optional<Client> client, File dest, Optional<Devis> devis, Optional<Contact> contact, Optional<Banque> banque, Basket basket, Optional<UserPermit> userPermit, Optional<Tva> tva) throws IOException {

        //Chargement du model pdf suivant le pays du client.
        String src;
        if (client.get().getPays().equalsIgnoreCase("france")) {
            src = "./src/main/resources/pdf/model_Fr.pdf";
        } else {
            src = "./src/main/resources/pdf/model_EN.pdf";
        }

        //Map contenant la liste des cells du panier
        Map<String, Integer> listCellName = new HashMap<>();
        for (BasketCell cell : basket.getCells()) {
            //Récuperer l'identifiant du pays (FR, GB ou autre)
            String pays = cell.getCellId().substring(0, 2);

            //Vérifier s'il y a déja de la donnée pour ce pays.
            //S'il n'y en a pas on vient initialiser la hasmap à 1 ;
            if (!listCellName.containsKey(pays)) {
                listCellName.put(pays, 1);
            } else {
                //Si une valeur existe déjà rajouter +1 à la valeur existante
                listCellName.put(pays, listCellName.get(pays) + 1);
            }
        }

        String str = listCellName.toString();
        String encCount = str.substring(str.indexOf("{") + 1, str.indexOf("}")).replaceAll("=", " ");

        //Map contenant la liste des délais de souscription
        Map<Integer, String> listService = new HashMap<>();
        for (BasketCell cell : basket.getCells()) {
            int service = cell.getCellService();
            if (!listService.containsKey(service)) {
                listService.put(service, "1");
            }
        }
        listService.replace(0, "12 mois");
        listService.replace(3, "6 mois");
        listService.replace(4, "3 mois");
        listService.replace(14, "4 mois");
        listService.replace(15, "5 mois");
        listService.replace(17, "7 mois");
        listService.replace(18, "8 mois");
        listService.replace(19, "9 mois");
        listService.replace(20, "10 mois");
        listService.replace(21, "11 mois");

        String str1 = listService.toString();
        String str2 = str1.substring(str1.indexOf("{") + 1, str1.indexOf("}")).replaceAll("=", "");
        String souscription = str2.substring(1);
        System.out.println(souscription);

        //nombre de cell
        int liste = basket.getCells().size();
        String listeSize = liste + "";


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


        if ("fr".equalsIgnoreCase(client.get().getLangue())) {
            // Add customer adresse french
            Text name = new Text(client.get().getName()).setFontSize(10).setBold();
            //          Text destinataire = new Text(client.get().getDestinataire()).setFontSize(10);
            Text adresse = new Text(client.get().getAdresse()).setFontSize(10);
            //          Text adresse2 = new Text(client.get().getAdresse2()).setFontSize(10);
            //          Text adresse3 = new Text(client.get().getAdresse3()).setFontSize(10);
            //          Text bp = new Text(client.get().getBoite_postal()).setFontSize(10);
            //         Text cs = new Text(client.get().getCs()).setFontSize(10);
            Text ville = new Text(client.get().getVille()).setFontSize(10);
            //          Text cedex = new Text(client.get().getCedex()).setFontSize(10);
            Text zipCode = new Text(client.get().getZipCode()).setFontSize(10);
            Paragraph p = new Paragraph()
                    .add(name).add("\n")
                    .add(adresse).add("\n")
                    .add(zipCode).add(" ").add(ville)
                    .setRelativePosition(300, 100, 200, 0);
            document.add(p);
        } else {
            // Add customer adresse english
            Text nameEn = new Text(client.get().getName()).setFontSize(10).setBold();
            Text adresse = new Text(client.get().getAdresse()).setFontSize(10);
            Text ville = new Text(client.get().getVille()).setFontSize(10);
            //Text pays= new Text(clientId.getPays())
            //.setFontSize(10);
            Text zipCode = new Text(client.get().getZipCode()).setFontSize(10);
            Paragraph customer = new Paragraph().add(nameEn).add("\n").add(adresse).add("\n").add("\n").add(ville).add("\n")
                    //.add(pays)
                    .add("\n").add(zipCode).setFixedPosition(320, 638, 200);
            document.add(customer);
        }

        /**
         * Add order detail
         */

        //TODO remplacer par le prix venant de l'api primar
          float prixUnitaire = (float) 177.46;

        //Add code
        //TODO demandé d'ou viens le code 701-01
        document.add(new Paragraph("701-01").setFontSize(9).setFixedPosition(40, 500, 30));
        //Add Designationry_àço:xxxxxx
        //TODO demandé comment est composé la désignation S Exploitation ENC (Droit)
        document.add(new Paragraph("S Exploitation ENC (Droit)").setFontSize(9).setFixedPosition(85, 500, 200));
        //Add Qte
        document.add(new Paragraph("1").setFontSize(9).setFixedPosition(385, 500, 100));
        //Add price
        document.add(new Paragraph(prixUnitaire +" " + "€").setFontSize(9).setFixedPosition(427, 500, 100));
        //Add Total HT
        document.add(new Paragraph(prixUnitaire +" " + "€").setFontSize(9).setFixedPosition(493, 500, 100));
        //Add TVA
        document.add(new Paragraph(tva.get().getMontant()+ "%").setFontSize(9).setFixedPosition(535, 500, 100));

        /**
         * Add Geomod bank details
         */
        // Add Name Bank
        document.add(new Paragraph(banque.get().getName()).setFixedPosition(165, 197, 100).setFontSize(9));
        // Add Iban Bank
        document.add(new Paragraph(banque.get().getIban()).setFixedPosition(165, 182, 300).setFontSize(9));
        // Add Bic Bank
        document.add(new Paragraph(banque.get().getBic()).setFixedPosition(165, 167, 300).setFontSize(9));

        /**
         * Add Montant
         */
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        double taxe = prixUnitaire*(tva.get().getMontant()/100);
        double montantTtc = prixUnitaire+prixUnitaire*(tva.get().getMontant()/100);



        //Add Montant ht
        document.add(new Paragraph(prixUnitaire +" " + "€").setFontSize(9).setFixedPosition(510, 198, 50).setTextAlignment(TextAlignment.RIGHT));
        //Add TVA
        document.add(new Paragraph(f.format(taxe) +" " + "€").setFontSize(9).setFixedPosition(510, 183, 50).setTextAlignment(TextAlignment.RIGHT));
        //Add Montant TTC
        document.add(new Paragraph( f.format(montantTtc) + " " + "€").setFontSize(9).setFixedPosition(510, 163, 50).setTextAlignment(TextAlignment.RIGHT).setBold());

        /**
         * Add ENC
         */
        // Add of the number of cards per country
        if (client.get().getPays().equalsIgnoreCase("france")) {
            Paragraph encFr = new Paragraph()
                    .add(listeSize + " " + "Encs" + " ")
                    .add("(" + encCount + ")")
                    .add("\n")
                    .add("pour une souscription de" + " " + souscription)
                    .setRelativePosition(50, 250, 200, 0)
                    .setFontSize(9)
                    .setBold();
            document.add(encFr);

        } else {
            Paragraph encEn = new Paragraph()
                    .add(listeSize + " " + "Encs" + " ")
                    .add("(" + encCount + ")")
                    .add("\n")
                    .add("for a subscription of" + " " + souscription)
                    .setRelativePosition(50, 250, 200, 0)
                    .setFontSize(9)
                    .setBold();

            document.add(encEn);
        }

        /**
         * Add UserPermit
         */
        Paragraph permit = new Paragraph()
                .add("USER PERMIT :")
                .add("\n")
                .add(userPermit.get().getNumero())
                .setRelativePosition(50, 260, 200, 0)
                .setFontSize(9);
        document.add(permit);


        document.close();

    }


}
