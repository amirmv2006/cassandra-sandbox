package ir.amv.snippets.cassandrasandbox.book;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("Book")
public class Book {

    @PrimaryKey("book_id")
    private Long id;
    @Column("name")
    private String name;
    @Column("publisher")
    private String publisher;

}
