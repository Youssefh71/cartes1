package fr.geomod.components.cmdecarte.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import fr.geomod.components.cmdecarte.Pdf.PdfSouscription;
import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
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
import java.util.*;


@Service
public class PdfGenerationService {


    public void createPdf(Client client, File dest, Devis devis, Contact contact, Banque banque, Basket basket, Optional<UserPermit> userPermit, Tva tva, Optional<Licensee> licensee) throws IOException {

        boolean langueFr = client.getLangue().equalsIgnoreCase("fr");
        String dayLabel = (langueFr) ? "jours" : "days";
        String monthsLabel = (langueFr) ? "mois" : "months";


        //Chargement du model pdf suivant le pays du client.
        String templatePath = langueFr ? "./src/main/resources/pdf/model_Fr.pdf" : "./src/main/resources/pdf/model_EN.pdf";

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

        //ServiceType du panier
        int serviceType = basket.getCells().get(0).getCellService();

        //dureeSouscription = correspondance entre leservice_type du panier et la durée de souscription
        int dureeSouscription = PdfSouscription.SERVICE_MAP.get(serviceType);

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
        Paragraph customerFrench = new Paragraph();
        customerFrench.add(client.getName()).setBold().add("\n");
        if (client.getDestinataire() != null) {
            customerFrench.add(client.getDestinataire()).setFontSize(10).add("\n");
        }
        customerFrench.add(client.getAdresse()).setFontSize(10).add("\n");
        if (client.getAdresse2() != null) {
            customerFrench.add(client.getAdresse2()).setFontSize(10).add("\n");
        }
        if (client.getAdresse3() != null) {
            customerFrench.add(client.getAdresse3()).setFontSize(10).add("\n");
        }
        if (client.getBoite_postal() != null) {
            customerFrench.add(client.getBoite_postal()).setFontSize(10).add("\n");
        }
        if (client.getCs() != null) {
            customerFrench.add(client.getCs()).setFontSize(10).add("\n");
        }
        customerFrench.add(client.getZipCode()).setFontSize(10);
        customerFrench.add(" ");
        customerFrench.add(client.getVille()).setFontSize(10);
        customerFrench.add(" ");
        if (client.getCedex() != null) {
            customerFrench.add(client.getCedex()).setFontSize(10).add("\n");
        }
        if (langueFr) {
            customerFrench.add(client.getPays()).setFontSize(10).add("\n");
        }
        customerFrench.setRelativePosition(300, 100, 200, 0);
        document.add(customerFrench);

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

        //Add ENC
        // Add of the number of cards per country

        String totalEncByPays = "";
        for (String pays : listCellName.keySet()) {
            totalEncByPays += (totalEncByPays.length() > 0 ? " " : "") + listCellName.get(pays) + " " + pays;
        }

        Paragraph encFr = new Paragraph()
                .add(basket.getCells().size() + " " + "Encs" + " ")
                .add("(" + totalEncByPays + ")")
                .add("\n")
                .add("pour une souscription de " + dureeSouscription + " " + monthsLabel)
                .setRelativePosition(50, 230, 200, 0)
                .setFontSize(9)
                .setBold();
        document.add(encFr);

        //Add UserPermit
        //Todo voir la compsoition du name de l'user permit (florian)
        Paragraph permit = new Paragraph()
                .add("USER PERMIT :")
                .add("\n")
                .add(userPermit.get().getNumero())
                .setRelativePosition(50, 250, 200, 0)
                .setFontSize(9);
        document.add(permit);
        document.close();
    }
}
