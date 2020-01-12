/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ir.amv.snippets.cassandrasandbox;

import com.datastax.driver.core.Session;
import ir.amv.snippets.cassandrasandbox.book.Book;
import ir.amv.snippets.cassandrasandbox.book.BookRepository;
import ir.amv.snippets.cassandrasandbox.util.CassandraKeyspace;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Version;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test showing the basic usage of {@link BasicUserRepository}.
 *
 * @author Oliver Gierke
 * @author Thomas Darimont
 * @author Christoph Strobl
 * @author Mark Paluch
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CassandraSandboxApplication.class)
public class BasicUserRepositoryTests {

	public final static Version CASSANDRA_3_4 = Version.parse("3.4");

	@ClassRule public final static CassandraKeyspace CASSANDRA_KEYSPACE = CassandraKeyspace.onLocalhost();

	@Autowired
	BookRepository repository;
	@Autowired
    Session session;
	Book book;

	@Before
	public void setUp() {

		book = new Book();
		book.setId(42L);
		book.setName("foobar");
		book.setPublisher("firstname");
	}

	/**
	 * Saving an object using the Cassandra Repository will create a persistent representation of the object in Cassandra.
	 */
	@Test
	public void findSavedUserById() {

		book = repository.save(book);

		assertThat(repository.findById(book.getId())).contains(book);
	}

}
