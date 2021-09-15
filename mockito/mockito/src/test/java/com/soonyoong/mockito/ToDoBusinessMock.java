package com.soonyoong.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;  
public class ToDoBusinessMock {
	@Test
	public void testusing_Mocks() {
		ToDoService doService = mock(ToDoService.class);
		List<String> combinedlist = Arrays.asList(" Use Core Java ", " Use Spring Core ", " Use w3eHibernate ",	" Use Spring MVC ");
		when(doService.getTodos("dummy")).thenReturn(combinedlist);
		ToDoBusiness business = new ToDoBusiness(doService);
		List<String> alltd = business.getTodosforHibernate("dummy");
		System.out.println(alltd);
		assertEquals(1, alltd.size());
	}
	
	@Test
	public void deleteTodosusing_BDD() {
		// Given
		ToDoService todoService = mock(ToDoService.class);
		List<String> combinedlist = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");
		given(todoService.getTodos("dummy")).willReturn(combinedlist);
		ToDoBusiness business = new ToDoBusiness(todoService);
		// When
		business.deleteTodosNotRelatedToHibernate("dummy");
		// Then
		verify(todoService).deleteTodos("Use Spring MVC");
		verify(todoService, never()).deleteTodos("Use Hibernate Java");
		verify(todoService, never()).deleteTodos("Use Hibernate");
		verify(todoService, times(1)).deleteTodos("Use Spring MVC");
	}
	
	@Test
	public void deleteTodosusing_BDD_usingArgumentCaptor() {
		// Declare an Argument Captor
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		// Given
		ToDoService todoService = mock(ToDoService.class);
		List<String> combinedlist = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");
		given(todoService.getTodos("dummy")).willReturn(combinedlist);
		ToDoBusiness business = new ToDoBusiness(todoService);
		// When
		business.deleteTodosNotRelatedToHibernate("dummy");
		// Then
		then(todoService).should().deleteTodos(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(), is("Use Spring MVC"));
	}
	
	@Test
	public void deleteTodosusing_BDD_usingArgumentCaptorWithMultiple() {
		// Declare an Argument Captor
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		// Given
		ToDoService todoService = mock(ToDoService.class);
		List<String> combinedlist = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC", "using python");
		given(todoService.getTodos("dummy")).willReturn(combinedlist);
		ToDoBusiness business = new ToDoBusiness(todoService);
		// When
		business.deleteTodosNotRelatedToHibernate("dummy");
		// Then
		then(todoService).should(times(2)).deleteTodos(argumentCaptor.capture());  
		assertThat(argumentCaptor.getAllValues().size(),is(2));  
	}
}
