package fr.geomod.components.cmdecarte.Pdf;


import java.util.Map;

public class PdfSouscription {

    //mettre le constructeur en private pour ne plus pouvoir instancier la classe.
    private PdfSouscription() {
    }

    // La cellule service_type 0 correspond à une durée de souscription de 12 mois
    public static final int SERVICE_0 = 12;

        // La cellule service_type 3 correspond à une durée de souscription de 6 mois
    public static final int SERVICE_3 = 6;

    // La cellule service_type 4 correspond à une durée de souscription de 3 mois
    public static final int SERVICE_4 = 3;

    // La cellule service_type 14 correspond à une durée de souscription de 4 mois
    public static final int SERVICE_14 = 4;

    // La cellule service_type 15 correspond à une durée de souscription de 5 mois
    public static final int SERVICE_15 = 5;

    // La cellule service_type 17 correspond à une durée de souscription de 7 mois
    public static final int SERVICE_17 = 7;

    // La cellule service_type 18 correspond à une durée de souscription de 8 mois
    public static final int SERVICE_18 = 8;

    // La cellule service_type 19 correspond à une durée de souscription de 9 mois
    public static final int SERVICE_19 = 9;

    // La cellule service_type 20 correspond à une durée de souscription de 10 mois
    public static final int SERVICE_20 = 10;

    // La cellule service_type 21 correspond à une durée de souscription de 11 mois
    public static final int SERVICE_21 = 11;

    //Map pour la correspondance entre clef (service_type du panier) et les durées de souscription
    public static final Map<Integer, Integer> SERVICE_MAP = Map.of(
            0, PdfSouscription.SERVICE_0,
            3, PdfSouscription.SERVICE_3,
            4, PdfSouscription.SERVICE_4,
            14, PdfSouscription.SERVICE_14,
            15, PdfSouscription.SERVICE_15,
            17, PdfSouscription.SERVICE_17,
            18, PdfSouscription.SERVICE_18,
            19, PdfSouscription.SERVICE_19,
            20, PdfSouscription.SERVICE_20,
            21, PdfSouscription.SERVICE_21);
}
