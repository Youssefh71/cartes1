/*
 * @(#)DataApplication.java
 *
 * Copyright (c) 2023 GEOMOD SA. All rights reserved.
 * GEOMOD PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 *
 * This file, together  with  its accompanying  software product  and
 * documentation, is  protected by the  intellectual  property rights
 * in  France  and  other  countries, any  applicable  copyrights  or
 * patent rights, and international treaty provisions. No part may be
 * reproduced  in  any  form  by  any  mean  without   prior  written
 * authorization of GEOMOD.
 */
package fr.geomod.components.cmdecarte.database;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;


import fr.geomod.components.cmdecarte.database.model.entity.Banque;
import fr.geomod.components.cmdecarte.database.model.entity.Contact;
import fr.geomod.components.cmdecarte.database.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import fr.geomod.components.cmdecarte.database.model.entity.Client;
import fr.geomod.components.cmdecarte.database.model.entity.Devis;
import org.springframework.stereotype.Service;

/**
 * <p>
 * <B>Title </B>: DataApplication.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: DataApplication.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 *
 * @author GEOMOD
 * @since 2023
 */

@SpringBootApplication
@Service
public class PdfApplication implements CommandLineRunner {


    @Autowired
    private RepositoryService repositoryService;

    private String src = "./src/main/resources/pdf/model.pdf";

    private String dest = "./data_pdf/test.pdf";


    private static final String clientTest = "fr";


    public static void main(String[] args) {
        SpringApplication.run(PdfApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Optional<Devis> optDevis = repositoryService.getDevisById(1L);
        Devis devisId = optDevis.get();

        Optional<Client> optClient = repositoryService.getClientById(1L);
        Client clientId = optClient.get();

        Optional<Banque> optBanque = repositoryService.getBanqueById(1L);
        Banque banqueId = optBanque.get();

        Optional<Contact> optContact = repositoryService.getContactById(1L);
        Contact contactId = optContact.get();



        /**
         * Add of quote elements
         */
        // Date Deadline
        Calendar echeance = Calendar.getInstance();
        echeance.add(Calendar.DATE, devisId.getValidity());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Initialize PDF document
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));

        Document document = new Document(pdfDoc);

        // Add Quote
        document.add(new Paragraph(devisId.getNumero()).setFixedPosition(95, 699, 60).setFontSize(9).setBold());

        // Add Date
        document.add(new Paragraph(devisId.getDateDevis().toString()).setFixedPosition(95, 684, 60).setFontSize(9));

        // Add Validity
        document.add(new Paragraph(devisId.getValidity() + " jours").setFixedPosition(95, 669, 60).setFontSize(9));

        // Add Validity - Deadline
        document.add(new Paragraph(sdf.format(echeance.getTime())).setFixedPosition(95, 655, 60).setFontSize(9));


        /**
         * Add coordinates of Geomod
         */
        // Add mail Geomod
        document.add(new Paragraph(contactId.getMail()).setFixedPosition(95, 601, 100).setFontSize(9));

        // Add phone Geomod
        document.add(new Paragraph(contactId.getPhone()).setFixedPosition(92, 587, 300).setFontSize(9));



        /**
         * Add customer details
         */

        if ("fr".equalsIgnoreCase(clientTest)) {

            // Add customer adresse french

            Text name = new Text(clientId.getName()).setFontSize(10).setBold();
            Text adresse = new Text(clientId.getAdresse()).setFontSize(10);
            Text adresse2 = new Text(clientId.getAdresse2()).setFontSize(10);
            Text ville = new Text(clientId.getVille()).setFontSize(10);
            Text zipCode = new Text(clientId.getZipCode()).setFontSize(10);
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

            Text nameEn = new Text(clientId.getName()).setFontSize(10).setBold();
            Text adresse = new Text(clientId.getAdresse()).setFontSize(10);
            Text adresse2 = new Text(clientId.getAdresse2()).setFontSize(10);
            Text ville = new Text(clientId.getVille()).setFontSize(10);
            //Text pays= new Text(clientId.getPays())
            //.setFontSize(10);
            Text zipCode = new Text(clientId.getZipCode()).setFontSize(10);
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
        document.add(new Paragraph(banqueId.getName()).setFixedPosition(165, 197, 100).setFontSize(9));

        // Add Iban Bank
        document.add(new Paragraph(banqueId.getIban()).setFixedPosition(165, 182, 300).setFontSize(9));

        // Add Bic Bank
        document.add(new Paragraph(banqueId.getBic()).setFixedPosition(165, 167, 300).setFontSize(9));


        document.close();


    }


}
