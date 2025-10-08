package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.skypro.skyshop.util.StorageUtil;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SkyShopApplicationTests {

	@Mock
	private StorageService storageService;
	@InjectMocks
	private SearchService searchService;

	//Поиск в случае отсутствия объектов в StorageService
	@Test
	public void givenEmptyStorage_WhenFind_ThenReturnEmptyList() {
		String searchTerm = "NoSuchProduct";

		Mockito.lenient().when(storageService.getAllSearchable()).thenReturn(Collections.emptyList());

		Collection<SearchResult> results = searchService.search(searchTerm);

		Assertions.assertTrue(results.isEmpty());
	}

	//Поиск в случае, если объекты в StorageService есть, но нет подходящего
	@Test
	public void givenFullStorage_WhenNoFind_ThenReturnEmptyList () {
		StorageUtil storageUtil = new StorageUtil();
		String searchTerm = "NoSuchProduct";

		Mockito.lenient().when(storageService.getAllSearchable()).thenReturn(storageUtil.initStorage());

		Collection<SearchResult> results = searchService.search(searchTerm);

		Assertions.assertTrue(results.isEmpty());
	}

	//Поиск, когда есть подходящий объект в StorageService
	@Test
	public void givenFullStorage_WhenFind_ThenReturnNotEmptyList () {
		StorageUtil storageUtil = new StorageUtil();
		String searchTerm = "Яблоки";

		Mockito.lenient().when(storageService.getAllSearchable()).thenReturn(storageUtil.initStorage());

		Collection<SearchResult> results = searchService.search(searchTerm);

		Assertions.assertFalse(results.isEmpty());
	}



}
