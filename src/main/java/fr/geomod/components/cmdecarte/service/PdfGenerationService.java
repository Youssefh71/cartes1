package fr.geomod.components.cmdecarte.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.utils.BasketUtils;
import fr.geomod.components.cmdecarte.persistence.entity.Banque;
import fr.geomod.components.cmdecarte.persistence.entity.Client;
import fr.geomod.components.cmdecarte.persistence.entity.Contact;
import fr.geomod.components.cmdecarte.persistence.entity.Devis;
import fr.geomod.components.cmdecarte.persistence.entity.Licensee;
import fr.geomod.components.cmdecarte.persistence.entity.Tva;
import fr.geomod.components.cmdecarte.persistence.entity.UserPermit;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


@Service
public class PdfGenerationService {


    public void generatedPdf(Client client, File dest, Devis devis, Contact contact, Banque banque, Basket basket, Optional<UserPermit> userPermit, Tva tva, Optional<Licensee> licensee) throws IOException {

        boolean langueFr = client.getLangue().equalsIgnoreCase("fr");
        String templatePath = langueFr ? "./src/main/resources/pdf/model_Fr.pdf" : "./src/main/resources/pdf/model_EN.pdf";
        String dayLabel = (langueFr) ? "jours" : "days";
        String monthsLabel = (langueFr) ? "mois" : "months";

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Date Deadline
        Calendar echeance = Calendar.getInstance();
        echeance.add(Calendar.DATE, devis.getValidity());
        String validity = sdf.format(echeance.getTime());

        //Date now
        String dateDevis = sdf.format(devis.getDateDevis());

        // Initialize PDF document
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(templatePath), new PdfWriter(dest));
        Document document = new Document(pdfDoc);
        // Add Quote
        document.add(new Paragraph(devis.getNumero()).setFixedPosition(95, 699, 60).setFontSize(9).setBold());
        // Add Date
        document.add(new Paragraph(dateDevis).setFixedPosition(95, 684, 60).setFontSize(9));
        // Add Validity
        document.add(new Paragraph(devis.getValidity() + " " + dayLabel).setFixedPosition(95, 669, 60).setFontSize(9));
        // Add Validity - Deadline
        document.add(new Paragraph(validity).setFixedPosition(95, 655, 60).setFontSize(9));
        // Add mail Geomod
        document.add(new Paragraph(contact.getMail()).setFixedPosition(95, 601, 100).setFontSize(9));
        // Add phone Geomod
        document.add(new Paragraph(contact.getPhone()).setFixedPosition(92, 587, 300).setFontSize(9));


        //add quote header
        //TODO demander comment se calcul la date de début et de fin de la souscription
        //TODO i18n
        document.add(new Paragraph("ENC " + licensee.get().getName() + " " + "du 01/11/2022 au 31/10/2023").setFixedPosition(30, 553, 300).setFontSize(9).setBold());

        //Add customer adress
        // Add customer adresse french
        Paragraph adresseClient = new Paragraph();
        adresseClient.add(client.getName()).setBold().add("\n");
        if (client.getDestinataire() != null) {
            adresseClient.add(client.getDestinataire()).setFontSize(10).add("\n");
        }
        adresseClient.add(client.getAdresse()).setFontSize(10).add("\n");
        if (client.getAdresse2() != null) {
            adresseClient.add(client.getAdresse2()).setFontSize(10).add("\n");
        }
        if (client.getAdresse3() != null) {
            adresseClient.add(client.getAdresse3()).setFontSize(10).add("\n");
        }
        if (client.getBoite_postal() != null) {
            adresseClient.add(client.getBoite_postal()).setFontSize(10).add("\n");
        }
        if (client.getCs() != null) {
            adresseClient.add(client.getCs()).setFontSize(10).add("\n");
        }
        adresseClient.add(client.getZipCode()).setFontSize(10);
        adresseClient.add(" ");
        adresseClient.add(client.getVille()).setFontSize(10);
        adresseClient.add(" ");
        if (client.getCedex() != null) {
            adresseClient.add(client.getCedex()).setFontSize(10).add("\n");
        }
        if (langueFr) {
            adresseClient.add(client.getPays()).setFontSize(10).add("\n");
        }
        adresseClient.setRelativePosition(300, 100, 200, 0);
        document.add(adresseClient);

        //Add order detail
        //TODO remplacer par le prix venant de l'api primar
        float prixUnitaire = (float) 177.46;

        //Add code
        //TODO demandé d'ou viens le code 701-01
        document.add(new Paragraph("701-01").setFontSize(9).setFixedPosition(40, 500, 30));
        //Add Designation
        //TODO demandé comment est composé la désignation S Exploitation ENC (Droit)
        document.add(new Paragraph("S Exploitation ENC (Droit)").
                setFontSize(9).
                setFixedPosition(85, 500, 200));
        //Add Qte
        document.add(new Paragraph("1").setFontSize(9).setFixedPosition(385, 500, 100));
        //Add price
        document.add(new Paragraph(prixUnitaire + " €").setFontSize(9).setFixedPosition(427, 500, 100));
        //Add Total HT
        document.add(new Paragraph(prixUnitaire + " €").setFontSize(9).setFixedPosition(493, 500, 100));
        //Add TVA
        document.add(new Paragraph(tva.getMontant() + "%").setFontSize(9).setFixedPosition(535, 500, 100));

        //Add Geomod bank details
        // Add Name Bank
        document.add(new Paragraph(banque.getName()).setFixedPosition(165, 197, 100).setFontSize(9));
        // Add Iban Bank
        document.add(new Paragraph(banque.getIban()).setFixedPosition(165, 182, 300).setFontSize(9));
        // Add Bic Bank
        document.add(new Paragraph(banque.getBic()).setFixedPosition(165, 167, 300).setFontSize(9));

        //Add Montant
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);

        double taxe = prixUnitaire * (tva.getMontant() / 100);
        double montantTtc = prixUnitaire + taxe;
        //Add Montant ht
        document.add(new Paragraph(prixUnitaire + " €").setFontSize(9).setFixedPosition(510, 198, 50).setTextAlignment(TextAlignment.RIGHT));
        //Add TVA
        document.add(new Paragraph(f.format(taxe) + " €").setFontSize(9).setFixedPosition(510, 183, 50).setTextAlignment(TextAlignment.RIGHT));
        //Add Montant TTC
        document.add(new Paragraph(f.format(montantTtc) + " €").setFontSize(9).setFixedPosition(510, 163, 50).setTextAlignment(TextAlignment.RIGHT).
                setBold());


        //récupère la liste des durées de souscription
        Set<Integer> listSouscription = BasketUtils.SERVICE_MAP.keySet();
        Paragraph encFr = new Paragraph();
        //number of cards per country and per subscription period
        Map<Integer, Map<String, Integer>> extractedCellsByService = new HashMap<>();
        //total number of cards per subscription period
        Map<Integer, Map<String, Integer>> encsByService = new HashMap<>();
        //boucle sur listeSouscription (liste des durées de souscription)
        for (int service : listSouscription) {
            //récupère le nombre de cartes par pays suivant sa durée de souscription
            extractedCellsByService.put(service, BasketUtils.getNbCellsPerSubscription(basket, service, BasketUtils.ExtractionType.BY_COUNTRY));
            //récupère le nombre total de cartes  suivant sa durée de souscription
            encsByService.put(service, BasketUtils.getNbCellsPerSubscription(basket, service, BasketUtils.ExtractionType.TOTAL));
            //crée une chaîne de caractères représentant le nombre de cartes par pays
            String totalEncByPays = "";
            for (String pays : extractedCellsByService.get(service).keySet()) {
                totalEncByPays += (totalEncByPays.length() > 0 ? " " : "") + extractedCellsByService.get(service).get(pays) + " " + pays;
            }
            //vérifie pour chaque durée de souscirption s'il a des cartes par pays
            if (!extractedCellsByService.get(service).isEmpty()) {
                encFr.add(encsByService.get(service).size() + " " + "Encs" + " ");
                encFr.add("(" + totalEncByPays + ")");
                encFr.add("\n");
                encFr.add("pour une souscription de " + BasketUtils.SERVICE_0 + " " + monthsLabel);
                encFr.setRelativePosition(50, 230, 200, 0);
                encFr.setFontSize(9);
                encFr.setBold();
                encFr.add("\n");
                encFr.add("\n");
            }
        }

        //Add UserPermit
        //Todo voir la compsoition du name de l'user permit (florian)
        encFr.add("USER PERMIT :");
        encFr.add("\n");
        encFr.add(userPermit.get().getNumero());
        encFr.setFontSize(9);

        document.add(encFr);
        document.close();
    }
}
