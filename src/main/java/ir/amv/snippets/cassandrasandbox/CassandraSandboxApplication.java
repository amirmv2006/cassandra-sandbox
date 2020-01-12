package ir.amv.snippets.cassandrasandbox;

import ir.amv.snippets.cassandrasandbox.book.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class CassandraSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(CassandraSandboxApplication.class, args);
    }

}
