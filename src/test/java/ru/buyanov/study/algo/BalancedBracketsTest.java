package ru.buyanov.study.algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Buyanov
 * @created 6/14/17
 */
public class BalancedBracketsTest {
    private BalancedBrackets service;

    @Before
    public void startUp() {
        service = new BalancedBrackets();
    }

    @Test
    public void testSolution_nullString() throws Exception {
        assertTrue(service.solution(null));
    }

    @Test
    public void testSolution_emptyString() throws Exception {
        assertTrue(service.solution(""));
    }

    @Test
    public void testSolution_noBrackets() throws Exception {
        assertTrue(service.solution("dsafasfasfewr32"));
    }

    @Test
    public void testSolution_oneBracketOnly() throws Exception {
        assertFalse(service.solution("{"));
    }

    @Test
    public void testSolution_separateBrackets() throws Exception {
        assertTrue(service.solution("{}()[]"));
    }

    @Test
    public void testSolution_enclosedBracketsSimple() throws Exception {
        assertTrue(service.solution("{[]}"));
    }

    @Test
    public void testSolution_enclosedBracketsBalanced() throws Exception {
        assertTrue(service.solution("{[]({([]){}}[])({})}"));
    }
}