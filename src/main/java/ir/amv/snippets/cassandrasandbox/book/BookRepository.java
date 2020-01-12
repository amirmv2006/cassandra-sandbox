package ir.amv.snippets.cassandrasandbox.book;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BookRepository extends CassandraRepository<Book, Long> {
}
