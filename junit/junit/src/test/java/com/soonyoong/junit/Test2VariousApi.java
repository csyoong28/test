package com.soonyoong.junit;

import org.junit.jupiter.api.*;

import java.util.*;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.util.Sets.newHashSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Sets.newHashSet;
public class Test2VariousApi {
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("before class");
    }
    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @Test
    public void createStream_whenFindAnyResultIsPresent_thenCorrect() {
        List<String> list = Arrays.asList("A","B","C","D");
        Optional<String> result = list.stream().findAny();
        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
    }

    @Test
    public void testContainsEntry() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        Map<Integer, Set<String>> result = givenList.stream().collect(groupingBy(String::length, toSet()));
        assertThat(result).containsEntry(1, newHashSet(List.of("a")))
                .containsEntry(2, newHashSet(List.of("bb", "dd")))
                .containsEntry(3, newHashSet(List.of("ccc")));
    }

    @Test
    public void testAssertThatThrownBy() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> result = givenList.stream().collect(toUnmodifiableList());
        assertThatThrownBy(() -> result.add("foo")).isInstanceOf(UnsupportedOperationException.class);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("after class");
    }

    @Disabled
    @Test
    public void shouldBeIgnored() {
        System.out.println("huh, not ignored?!");     //@ignore is used when functionality is still under development, and the test should not be executed yet
    }

}
