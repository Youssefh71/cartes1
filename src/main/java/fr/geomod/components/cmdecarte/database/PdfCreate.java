package fr.geomod.components.cmdecarte.database;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;
import fr.geomod.components.cmdecarte.database.model.entity.Banque;
import fr.geomod.components.cmdecarte.database.model.entity.Client;
import fr.geomod.components.cmdecarte.database.model.entity.Contact;
import fr.geomod.components.cmdecarte.database.model.entity.Devis;
import fr.geomod.components.cmdecarte.database.repository.BanqueRepository;
import fr.geomod.components.cmdecarte.database.repository.ClientRepository;
import fr.geomod.components.cmdecarte.database.repository.ContactRepository;
import fr.geomod.components.cmdecarte.database.repository.DevisRepository;
import fr.geomod.components.cmdecarte.database.service.PdfGenerationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.Optional;


@SpringBootApplication
public class PdfCreate  {
        private final DevisRepository devisRepository;
        private final ContactRepository contactRepository;
        private final BanqueRepository banqueRepository;

        public PdfCreate(DevisRepository devisRepository,
                         ContactRepository contactRepository,
                         BanqueRepository banqueRepository) {
                this.devisRepository = devisRepository;
                this.contactRepository = contactRepository;
                this.banqueRepository = banqueRepository;
        }

        public static void main(String[] args) {
                SpringApplication.run(PdfCreate.class);
        }


        @Bean
        public CommandLineRunner pdf(ClientRepository clientRepository){
                return (args) ->{
                        File basketRef = new File("./data/basket1.xml");
                        File dest = new File("./data_pdf/devis.pdf");


                        //Load Basket
                        Basket basket;
                        basket = new BasketJaxbImpl();
                        basket.loadBasket(basketRef);


                        PdfGenerationService pdf = new PdfGenerationService();
                        Optional<Client> client = clientRepository.findById(1l);
                        Optional<Devis> devis = devisRepository.findById(1l);
                        Optional<Contact> contact = contactRepository.findById(1l);
                        Optional<Banque> banque = banqueRepository.findById(1l);
                        pdf.createPdf(client,dest, devis,contact, banque,basket);


                };





        }




}

