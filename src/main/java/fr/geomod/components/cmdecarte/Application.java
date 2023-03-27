package fr.geomod.components.cmdecarte;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;
import fr.geomod.components.cmdecarte.persistence.entity.*;
import fr.geomod.components.cmdecarte.persistence.repository.BanqueRepository;
import fr.geomod.components.cmdecarte.persistence.repository.ClientRepository;
import fr.geomod.components.cmdecarte.persistence.repository.ContactRepository;
import fr.geomod.components.cmdecarte.persistence.repository.DevisRepository;
import fr.geomod.components.cmdecarte.persistence.repository.TvaRepository;
import fr.geomod.components.cmdecarte.persistence.repository.UserPermitRepository;
import fr.geomod.components.cmdecarte.service.PdfGenerationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.Optional;

@SpringBootApplication
public class Application {
    private final DevisRepository devisRepository;
    private final ContactRepository contactRepository;
    private final BanqueRepository banqueRepository;
    private final ClientRepository clientRepository;
    private final UserPermitRepository userPermitRepository;
    private final TvaRepository tvaRepository;

    public Application(DevisRepository devisRepository,
                       ContactRepository contactRepository,
                       BanqueRepository banqueRepository, ClientRepository clientRepository,
                       UserPermitRepository userPermitRepository, TvaRepository tvaRepository)
    {
        this.devisRepository = devisRepository;
        this.contactRepository = contactRepository;
        this.banqueRepository = banqueRepository;
        this.clientRepository = clientRepository;
        this.userPermitRepository = userPermitRepository;
        this.tvaRepository = tvaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner pdf() {
        return (args) -> {
            File basketRef = new File("./data/basketTest.xml");
            File dest = new File("./data_pdf/devis.pdf");

            //Load Basket
            Basket basket;
            basket = new BasketJaxbImpl();
            basket.loadBasket(basketRef);

            PdfGenerationService pdf = new PdfGenerationService();
            Optional<Client> client = clientRepository.findById(1L);
            Optional<Devis> devis = devisRepository.findById(1L);
            Optional<Contact> contact = contactRepository.findById(1L);
            Optional<Banque> banque = banqueRepository.findById(1L);
            Optional<UserPermit> userPermit = userPermitRepository.findById(1L);
            Optional<Tva> tva = tvaRepository.findById(1L);
            pdf.createPdf(client, dest, devis, contact, banque, basket, userPermit, tva);
        };
    }
}
