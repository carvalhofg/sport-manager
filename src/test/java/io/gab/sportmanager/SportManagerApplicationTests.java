package io.gab.sportmanager;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SportManagerApplicationTests {

	@Test
	void main() {
		SportManagerApplication.main(new String[] {});
		Assert.assertTrue(true);
	}

}
