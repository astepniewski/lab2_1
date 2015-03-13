package edu.iis.mto.bsearch;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {

	private static BinarySearch binarySearch;

	@BeforeClass
	public static void oneTimeSetUp() {
		binarySearch = new BinarySearch();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptySeq() {
		int[] seq = new int[0];
		binarySearch.search(1, seq);
	}

	@Test
	public void testKeyIsInSeqLenght1() {
		int[] seq = new int[1];
		int key = 22;
		seq[0] = key;
		SearchResult searchResult = binarySearch.search(key, seq);
		assertTrue(searchResult.isFound());
	}

	@Test
	public void testKeyIsNotInSeqLenght1() {
		int[] seq = new int[1];
		int key = 22;
		seq[0] = 12;
		SearchResult searchResult = binarySearch.search(key, seq);
		assertFalse(searchResult.isFound());
	}

	@Test
	public void testKeyIsFirstElementInSeq() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 1;
		SearchResult searchResult = binarySearch.search(key, seq);
		assertEquals(1, searchResult.getPosition());
	}

	@Test
	public void testKeyIsLastElementInSeq() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 9;
		SearchResult searchResult = binarySearch.search(key, seq);
		assertEquals(seq.length, searchResult.getPosition());
	}

	@Test
	public void testKeyIsInTheMiddleOfEvenSeq() {
		int[] seq = { 1, 3, 6, 8, 9, 11 };
		int key = 6;
		SearchResult searchResult = binarySearch.search(key, seq);
		assertEquals(seq.length / 2, searchResult.getPosition());
	}

	@Test
	public void testKeyIsInTheMiddleOfOddSeq() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 6;
		SearchResult searchResult = binarySearch.search(key, seq);
		assertEquals(seq.length / 2 + 1, searchResult.getPosition());
	}

	@Test
	public void testKeyIsNotInSeqLenghtGreaterThan1() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 99;
		SearchResult searchResult = binarySearch.search(key, seq);
		assertFalse(searchResult.isFound());
	}

}
