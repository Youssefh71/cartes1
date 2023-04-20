package fr.geomod.components.cmdecarte;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;
import fr.geomod.components.cmdecarte.persistence.entity.*;
import fr.geomod.components.cmdecarte.persistence.repository.BanqueRepository;
import fr.geomod.components.cmdecarte.persistence.repository.ClientRepository;
import fr.geomod.components.cmdecarte.persistence.repository.ContactRepository;
import fr.geomod.components.cmdecarte.persistence.repository.DevisRepository;
import fr.geomod.components.cmdecarte.persistence.repository.LicenseeRepository;
import fr.geomod.components.cmdecarte.persistence.repository.TvaRepository;
import fr.geomod.components.cmdecarte.persistence.repository.UserPermitRepository;
import fr.geomod.components.cmdecarte.service.PdfGenerationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {
    private final DevisRepository devisRepository;
    private final ContactRepository contactRepository;
    private final BanqueRepository banqueRepository;
    private final ClientRepository clientRepository;
    private final UserPermitRepository userPermitRepository;
    private final TvaRepository tvaRepository;
    private final LicenseeRepository licenseeRepository;
    private final PdfGenerationService pdfGenerationService;

    public Application(
            DevisRepository devisRepository, ContactRepository contactRepository, BanqueRepository banqueRepository, ClientRepository clientRepository,
            UserPermitRepository userPermitRepository, TvaRepository tvaRepository, LicenseeRepository licenseeRepository, PdfGenerationService pdf, PdfGenerationService pdfGenerationService) {
        this.devisRepository = devisRepository;
        this.contactRepository = contactRepository;
        this.banqueRepository = banqueRepository;
        this.clientRepository = clientRepository;
        this.userPermitRepository = userPermitRepository;
        this.tvaRepository = tvaRepository;
        this.licenseeRepository = licenseeRepository;
        this.pdfGenerationService = pdfGenerationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner pdf() {
        return (args) -> {
            File basketRef = new File("./data/basketTest.xml");
            File dest = new File("./data_pdf/devis.pdf");

            try{
                //Load Basket
                Basket basket;
                basket = new BasketJaxbImpl();
                basket.loadBasket(basketRef);

                // Récupérer les objets depuis les repositories
                Optional<Client> client = clientRepository.findById(1L);
                Optional<Devis> devis = devisRepository.findById(1L);
                Optional<Contact> contact = contactRepository.findById(1L);
                Optional<Banque> banque = banqueRepository.findById(1L);
                UserPermit userPermit = userPermitRepository.findById(1L).orElse(null);
                Optional<Tva> tva = tvaRepository.findById(1L);
                Licensee licensee = licenseeRepository.findById(1L).orElse(null);

                // Vérifier si tous les objets nécessaires sont présents
                if (Stream.of(client, devis, contact, banque, tva).allMatch(Optional::isPresent)) {
                    pdfGenerationService.generatedPdf(
                            client.get(),
                            dest,
                            devis.get(),
                            contact.get(),
                            banque.get(),
                            basket,
                            Optional.ofNullable(userPermit),
                            tva.get(),
                            Optional.ofNullable(licensee)
                    );
                } else {
                    System.out.println("Object variable must not be null");
                }

            }catch (Exception e) {
                System.out.println(e);
            }

        };
    }
}
