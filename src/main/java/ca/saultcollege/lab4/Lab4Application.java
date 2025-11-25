package ca.saultcollege.lab4;

import ca.saultcollege.lab4.entities.DiscMagEntity;
import ca.saultcollege.lab4.entities.MagazineEntity;
import ca.saultcollege.lab4.entities.TicketEntity;
import com.github.javafaker.Faker;
import ca.saultcollege.lab4.entities.BookEntity;
import ca.saultcollege.lab4.repositories.BookEntityRepository;
import ca.saultcollege.lab4.repositories.DiscMagEntityRepository;
import ca.saultcollege.lab4.repositories.MagazineEntityRepository;
import ca.saultcollege.lab4.repositories.TicketEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab4Application implements CommandLineRunner {

	private final Faker faker = new Faker();


	private final BookEntityRepository bookRepository;
	private final MagazineEntityRepository magazineRepository;
	private final DiscMagEntityRepository discMagRepository;
	private final TicketEntityRepository ticketRepository;

	public Lab4Application(
			BookEntityRepository bookRepository,
			MagazineEntityRepository magazineRepository,
			DiscMagEntityRepository discMagRepository,
			TicketEntityRepository ticketRepository){
		this.bookRepository = bookRepository;
		this.magazineRepository = magazineRepository;
		this.discMagRepository = discMagRepository;
		this.ticketRepository = ticketRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepoCrudDemo();
		magazineRepoCrudDemo();
		discMagazineRepoCrudDemo();
		ticketRepoCrudDemo();

	}
	private void bookRepoCrudDemo(){
		System.out.println("==============BEGINNING BOOK REPO CRUD DEMONSTRATION==============");

		System.out.println("CREATE BOOK DEMO");
		BookEntity book = new BookEntity(
		faker.book().title(),
		faker.number().randomDouble(2, 1, 5),
		faker.number().numberBetween(1, 5),
		faker.book().author());

		BookEntity savedBook = bookRepository.save(book);
		System.out.println(savedBook);

		System.out.println("READ BOOK DEMO");


		System.out.println("READ BOOK BY ID DEMO");
		Optional<BookEntity> optionalBook = bookRepository.findById(savedBook.getId());
		System.out.println(optionalBook);

		System.out.println("READ ALL BOOK DEMO");
		List<BookEntity> allBooks = bookRepository.findAll();
		System.out.println(allBooks);


		System.out.println("UPDATE BOOK DEMO");
		savedBook.setTitle(faker.book().title());
		savedBook.setCopies(faker.number().numberBetween(5, 10));
		savedBook.setPrice(faker.number().randomDouble(2, 5, 10));
		savedBook.setAuthor(faker.book().author());
		BookEntity updatedBook = bookRepository.save(savedBook);

		System.out.println(updatedBook);

		System.out.println("DELETE BOOK DEMO");
		System.out.println("Book list before deletion: " + allBooks);
		bookRepository.deleteById(savedBook.getId());
		List<BookEntity> booksAfterDeletion = bookRepository.findAll();
		System.out.println("books after deletion: " + booksAfterDeletion);
	}

	private void magazineRepoCrudDemo(){
		System.out.println("==============BEGINNING MAGAZINE REPO CRUD DEMONSTRATION==============");

		System.out.println("CREATE MAGAZINE DEMO");
		 MagazineEntity magazine = new MagazineEntity(
				faker.company().name() + " Monthly Magazine",
				 faker.number().randomDouble(2, 1, 5),
				faker.number().numberBetween(1, 5),
				 faker.number().numberBetween(1, 5),
				 LocalDate.now().plusMonths(1));

		MagazineEntity savedMagazine = magazineRepository.save(magazine);
		System.out.println(savedMagazine);

		System.out.println("READ MAGAZINE DEMO");


		System.out.println("READ MAGAZINE BY ID DEMO");
		Optional<MagazineEntity> optionalMagazine = magazineRepository.findById(savedMagazine.getId());
		System.out.println(optionalMagazine);

		System.out.println("READ ALL MAGAZINE DEMO");
		List<MagazineEntity> allMags = magazineRepository.findAll();
		System.out.println(allMags);


		System.out.println("UPDATE MAGAZINE DEMO");
		savedMagazine.setTitle(faker.company().name() + " Monthly Magazine");
		savedMagazine.setCopies(faker.number().numberBetween(5, 10));
		savedMagazine.setPrice(faker.number().randomDouble(2, 5, 10));
		savedMagazine.setOrderQty(faker.number().numberBetween(5, 10));
		savedMagazine.setCurrentIssue(LocalDate.now().plusMonths(10));;
		MagazineEntity updatedMagazine = magazineRepository.save(savedMagazine);

		System.out.println(updatedMagazine);

		System.out.println("DELETE MAGAZINE DEMO");
		System.out.println("MAGAZINE list before deletion: " + allMags);
		magazineRepository.deleteById(savedMagazine.getId());
		List<MagazineEntity> magsAfterDeletion = magazineRepository.findAll();
		System.out.println("MAGAZINES after deletion: " + magsAfterDeletion);
	}

	private void discMagazineRepoCrudDemo(){
		System.out.println("==============BEGINNING MAGAZINE REPO CRUD DEMONSTRATION==============");

		System.out.println("CREATE DISC MAGAZINE DEMO");
		DiscMagEntity discMag = new DiscMagEntity(
				faker.company().name() + " Monthly Disc Magazine",
				faker.number().randomDouble(2, 1, 5),
				faker.number().numberBetween(1, 5),
				faker.number().numberBetween(1, 5),
				LocalDate.now().plusMonths(1),
				faker.bool().bool());

		DiscMagEntity savedDiscMag = discMagRepository.save(discMag);

		System.out.println(savedDiscMag);

		System.out.println("READ DISC MAGAZINE DEMO");


		System.out.println("READ DISC MAGAZINE BY ID DEMO");
		Optional<DiscMagEntity> optionalDiscMag = discMagRepository.findById(savedDiscMag.getId());
		System.out.println(optionalDiscMag);

		System.out.println("READ ALL DISC MAGAZINE DEMO");
		List<DiscMagEntity> allDiscMags = discMagRepository.findAll();
		System.out.println(allDiscMags);


		System.out.println("UPDATE DISC MAGAZINE DEMO");
		savedDiscMag.setTitle(faker.company().name() + " Monthly Magazine");
		savedDiscMag.setCopies(faker.number().numberBetween(5, 10));
		savedDiscMag.setPrice(faker.number().randomDouble(2, 5, 10));
		savedDiscMag.setOrderQty(faker.number().numberBetween(5, 10));
		savedDiscMag.setCurrentIssue(LocalDate.now().plusMonths(10));
		savedDiscMag.setHasDisc(faker.bool().bool());

		DiscMagEntity updatedDiscMag = discMagRepository.save(savedDiscMag);

		System.out.println(updatedDiscMag);

		System.out.println("DELETE DISC MAGAZINE DEMO");
		System.out.println("DISC MAGAZINE list before deletion: " + allDiscMags);
		discMagRepository.deleteById(savedDiscMag.getId());
		List<DiscMagEntity> discMagsAfterDeletion = discMagRepository.findAll();
		System.out.println("DISC MAGAZINES after deletion: " + discMagsAfterDeletion);
	}

	private void ticketRepoCrudDemo(){
		System.out.println("==============BEGINNING TICKET REPO CRUD DEMONSTRATION==============");

		System.out.println("CREATE TICKET DEMO");
		TicketEntity ticket = new TicketEntity(
				faker.esports().event(),
				faker.number().randomDouble(2, 1, 5),
				faker.lorem().sentence());

		TicketEntity savedTicket = ticketRepository.save(ticket);
		System.out.println(savedTicket);

		System.out.println("READ TICKET DEMO");


		System.out.println("READ TICKET BY ID DEMO");
		Optional<TicketEntity> optionalTicket = ticketRepository.findById(savedTicket.getId());
		System.out.println(optionalTicket);

		System.out.println("READ ALL TICKET DEMO");
		List<TicketEntity> allTickets = ticketRepository.findAll();
		System.out.println(allTickets);


		System.out.println("UPDATE TICKET DEMO");
		savedTicket.setTitle(faker.esports().event());
		savedTicket.setPrice(faker.number().randomDouble(2, 5, 10));
		savedTicket.setDescription(faker.lorem().sentence());
		TicketEntity updatedTicket = ticketRepository.save(savedTicket);

		System.out.println(updatedTicket);

		System.out.println("DELETE TICKET DEMO");
		System.out.println("TICKET list before deletion: " + allTickets);
		ticketRepository.deleteById(savedTicket.getId());
		List<TicketEntity> TicketsAfterDeletion = ticketRepository.findAll();
		System.out.println("TICKETS after deletion: " + TicketsAfterDeletion);
	}
















}