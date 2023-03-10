/*
 * @(#)PdfCreate.java
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

import fr.geomod.components.cmdecarte.database.service.PdfGenerationService;

import java.io.File;
import java.io.IOException;

/**
 * <p><B>Title </B>: PdfCreate.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: PdfCreate.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

public class PdfCreate {

public static final String SRC = "./src/main/resources/pdf/model.pdf";
    
    public static final String DEST = "./data_pdf/test.pdf";


    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PDFExport().createPdf(SRC,DEST);

    }
    
}


