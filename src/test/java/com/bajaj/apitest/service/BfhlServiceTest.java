package com.bajaj.apitest.service;

import com.bajaj.apitest.dto.BfhlRequest;
import com.bajaj.apitest.dto.BfhlResponse;
import com.bajaj.apitest.service.impl.BfhlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

    private BfhlService bfhlService;

    @BeforeEach
    public void setUp() {
        this.bfhlService = new BfhlServiceImpl();
    }

    @Test
    public void testExampleA() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("a", "1", "334", "4", "R", "$"));
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isIs_success());
        assertEquals("meet_kelwa_23071997", response.getUser_id());
        assertEquals("meetkelwa230797@acropolis.in", response.getEmail());
        assertEquals("0827CI231081", response.getRoll_number());
        
        assertEquals(Arrays.asList("1"), response.getOdd_numbers());
        assertEquals(Arrays.asList("334", "4"), response.getEven_numbers());
        assertEquals(Arrays.asList("A", "R"), response.getAlphabets());
        assertEquals(Arrays.asList("$"), response.getSpecial_characters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcat_string());
    }

    @Test
    public void testExampleB() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isIs_success());
        assertEquals(Arrays.asList("5"), response.getOdd_numbers());
        assertEquals(Arrays.asList("2", "4", "92"), response.getEven_numbers());
        assertEquals(Arrays.asList("A", "Y", "B"), response.getAlphabets());
        assertEquals(Arrays.asList("&", "-", "*"), response.getSpecial_characters());
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcat_string());
    }

    @Test
    public void testExampleC() {
        BfhlRequest request = new BfhlRequest(Arrays.asList("A", "ABCD", "DOE"));
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isIs_success());
        assertTrue(response.getOdd_numbers().isEmpty());
        assertTrue(response.getEven_numbers().isEmpty());
        assertEquals(Arrays.asList("A", "ABCD", "DOE"), response.getAlphabets());
        assertTrue(response.getSpecial_characters().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("EoDdCbAa", response.getConcat_string());
    }

    @Test
    public void testEmptyData() {
        BfhlRequest request = new BfhlRequest(Collections.emptyList());
        BfhlResponse response = bfhlService.processRequest(request);

        assertTrue(response.isIs_success());
        assertTrue(response.getOdd_numbers().isEmpty());
        assertTrue(response.getEven_numbers().isEmpty());
        assertTrue(response.getAlphabets().isEmpty());
        assertTrue(response.getSpecial_characters().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("", response.getConcat_string());
    }

    @Test
    public void testNullData() {
        BfhlResponse response = bfhlService.processRequest(null);
        assertFalse(response.isIs_success());
        assertEquals("0", response.getSum());
        assertEquals("", response.getConcat_string());
    }
}
