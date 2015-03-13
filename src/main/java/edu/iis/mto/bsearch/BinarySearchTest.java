package edu.iis.mto.bsearch;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {

	private static BinarySearch binarySearch;
	 
    @BeforeClass
    public static void oneTimeSetUp() {
        binarySearch = new BinarySearch();
    }
    
    @Test(expected=IllegalArgumentException.class)
	public void testEmptySeq() {
		int[] seq = new int[0];
		binarySearch.search(1, seq);
	}
    
    @Test
    public void testKeyIsInSeqLenght1(){
    	int[] seq = new int[1];
    	int key = 22;
    	seq[0] = key;
    	SearchResult searchResult = binarySearch.search(key, seq);
    	assertTrue(searchResult.isFound());
    }
    
    @Test
    public void testKeyIsNotInSeqLenght1(){
    	int[] seq = new int[1];
    	int key = 22;
    	seq[0] = 12;
    	SearchResult searchResult = binarySearch.search(key, seq);
    	assertFalse(searchResult.isFound());
    }


}
