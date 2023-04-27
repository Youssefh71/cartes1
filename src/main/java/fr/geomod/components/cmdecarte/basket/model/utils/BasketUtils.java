package fr.geomod.components.cmdecarte.basket.model.utils;


import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for working with baskets.
 */
public class BasketUtils {

    //mettre le constructeur en private pour ne plus pouvoir instancier la classe.
    private BasketUtils() {
    }

    // Service type constants
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
            0, BasketUtils.SERVICE_0,
            3, BasketUtils.SERVICE_3,
            4, BasketUtils.SERVICE_4,
            14, BasketUtils.SERVICE_14,
            15, BasketUtils.SERVICE_15,
            17, BasketUtils.SERVICE_17,
            18, BasketUtils.SERVICE_18,
            19, BasketUtils.SERVICE_19,
            20, BasketUtils.SERVICE_20,
            21, BasketUtils.SERVICE_21);

    /**
     * Enum representing the different extraction types for `getNbCellsPerSubscription`.
     * `BY_COUNTRY` groups cells by country, while `TOTAL` counts every cell ID.
     */
    public enum ExtractionType {
        BY_COUNTRY,
        TOTAL
    }


    /**
     * Returns a map of cell IDs and the number of times they appear in the given basket for the given
     * subscription duration, either grouped by country or as a total count.
     *
     * @param basket the basket to extract cell IDs from
     * @param durationSubscription the subscription duration to count cells for
     * @param type the extraction type (by country or total)
     * @return a map of cell IDs and their count
     */
    public static Map<String, Integer> getNbCellsPerSubscription(Basket basket, int durationSubscription, ExtractionType type) {
        Map<String, Integer> extractedCells = new HashMap<>();
        for (BasketCell cell : basket.getCells()) {
            String cellId = cell.getCellId();
            String pays = cellId.substring(0, 2);
            if (cell.getCellService() == durationSubscription) {
                String key = cellId;
                if (type == ExtractionType.BY_COUNTRY) {
                    key = pays;
                }
                // else : ExtractionType.TOTAL => count every cell id
                int count = extractedCells.getOrDefault(key, 0);
                extractedCells.put(key, count + 1);
            }
        }
        return extractedCells;
    }
}
