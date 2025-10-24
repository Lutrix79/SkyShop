package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.skypro.skyshop.util.StorageFixture;

import java.util.Collection;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTests {
	private final StorageFixture storageFixture = new StorageFixture();

	@Mock
	private StorageService storageService;

	@InjectMocks
	private SearchService searchService;

	@DisplayName("Поиск в случае отсутствия объектов в StorageService")
	@Test
	public void givenEmptyStorage_WhenNoFind_ThenReturnEmptyList() {
		String searchTerm = "NoSuchProduct";

		Mockito.when(storageService.getAllSearchable()).thenReturn(Collections.emptyList());

		Collection<SearchResult> results = searchService.search(searchTerm);

		Assertions.assertTrue(results.isEmpty());
	}

	@DisplayName("Поиск в случае, если объекты в StorageService есть, но нет подходящего")
	@Test
	public void givenFullStorage_WhenNoFind_ThenReturnEmptyList () {

		String searchTerm = "NoSuchProduct";

		Mockito.when(storageService.getAllSearchable()).thenReturn(storageFixture.storageSearchable);

		Collection<SearchResult> results = searchService.search(searchTerm);

		Assertions.assertTrue(results.isEmpty());
	}

	@DisplayName("Поиск, когда есть подходящий объект в StorageService")
	@Test
	public void givenFullStorage_WhenFind_ThenReturnNotEmptyList () {
		String searchTerm = "Яблоки";

		Mockito.when(storageService.getAllSearchable()).thenReturn(storageFixture.storageSearchable);

		Collection<SearchResult> results = searchService.search(searchTerm);

		Assertions.assertFalse(results.isEmpty());
	}

}
