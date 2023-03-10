/*
 * @(#)PDFExport.java
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
package fr.geomod.components.cmdecarte.pdf;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

/**
 * <p>
 * <B>Title </B>: PDFExport.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: PDFExport.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2023
 */

public class PDFExport {

    private static final String clientTest = "fr";

    /**
     * @param src
     * @param dest
     * @throws IOException
     */
    public void createPdf(String src, String dest) throws IOException {

        // Create today's date
        Calendar dateNow = Calendar.getInstance();
        SimpleDateFormat now = new SimpleDateFormat("dd-MM-yyyy");

        // Period of validity of quote
        int Validity = 30;

        // Date Deadline
        Calendar echeance = Calendar.getInstance();
        echeance.add(Calendar.DATE, Validity);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Initialize PDF document
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src),
                new PdfWriter(dest));

        Document document = new Document(pdfDoc);

        // Add Quote
        document.add(new Paragraph("2022-Z-549").setFixedPosition(95, 698, 60)
                .setFontSize(10).setBold());

        // Add Date
        document.add(new Paragraph(now.format(dateNow.getTime()))
                .setFixedPosition(95, 683, 60).setFontSize(10));

        // Add Validity
        document.add(new Paragraph(Validity + " jours")
                .setFixedPosition(95, 669, 60).setFontSize(10));

        // Add Validity - Deadline
        document.add(new Paragraph(sdf.format(echeance.getTime()))
                .setFixedPosition(95, 655, 60).setFontSize(10));

        if ("fr".equalsIgnoreCase(clientTest)) {

            // Add customer adresse

            Text name = new Text("BAI SA").setFontSize(10).setBold();
            Text adresse = new Text(
                    "\n Service Comptabilité \nBP 84 \n 29688 ROSCOFF cedex")
                            .setFontSize(10);
            Paragraph p = new Paragraph().add(name).add(adresse)
                    .setFixedPosition(320, 638, 200);
            document.add(p);

        } else {

            // Add customer adresse
            Text name = new Text("Ocean Wise Ltd").setFontSize(10).setBold();
            Text adresse = new Text(
                    "\n Dovedale House \n 16 Butts Road \n Alton \n GU34 1 NB Hampshire \n United Kingdom")
                            .setFontSize(10);
            Paragraph p = new Paragraph().add(name).add(adresse)
                    .setFixedPosition(320, 605, 200);
            document.add(p);

        }

        document.close();

    }

}
