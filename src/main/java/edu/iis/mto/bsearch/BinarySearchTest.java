package edu.iis.mto.bsearch;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import org.junit.Test;

public class BinarySearchTest {

	@Test(expected = IllegalArgumentException.class)
	public void testEmptySeq() {
		int[] seq = new int[0];
		BinarySearch.search(1, seq);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSeqIsNotSorted() {
		int[] seq = { 1, 45, 6, 2, 9 };
		BinarySearch.search(1, seq);
	}

	@Test
	public void testKeyIsInSeqLenght1() {
		int[] seq = new int[1];
		int key = 22;
		seq[0] = key;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(true, is(searchResult.isFound()));
	}

	@Test
	public void testKeyIsNotInSeqLenght1() {
		int[] seq = new int[1];
		int key = 22;
		seq[0] = 12;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(false, is(searchResult.isFound()));
	}

	@Test
	public void testKeyIsFirstElementInSeq() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 1;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(1, is(searchResult.getPosition()));
	}

	@Test
	public void testKeyIsLastElementInSeq() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 9;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(seq.length, is(searchResult.getPosition()));
	}

	@Test
	public void testKeyIsInTheMiddleOfEvenSeq() {
		int[] seq = { 1, 3, 6, 8, 9, 11 };
		int key = 6;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(seq.length / 2, is(searchResult.getPosition()));
	}

	@Test
	public void testKeyIsInTheMiddleOfOddSeq() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 6;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(seq.length / 2 + 1, is(searchResult.getPosition()));
	}

	@Test
	public void testKeyIsNotInSeqLenghtGreaterThan1() {
		int[] seq = { 1, 3, 6, 8, 9 };
		int key = 99;
		SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(false, is(searchResult.isFound()));
	}

}
