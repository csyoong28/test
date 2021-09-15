package com.soonyoong.mockito;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class HamcrestMockito {

	@Test
	public void test() {
		List<Integer> num = Arrays.asList(99, 123, 45, 148, 33);
		assertThat(num, hasSize(5));
		assertThat(num, hasItems(99, 45));
		assertThat(num, everyItem(greaterThan(20)));
		assertThat(num, everyItem(greaterThanOrEqualTo(33)));
		assertThat(num, everyItem(lessThan(150)));
	}
}