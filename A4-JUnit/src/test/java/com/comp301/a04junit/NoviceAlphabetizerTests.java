package com.comp301.a04junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.alphabetizer.Alphabetizer;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Write tests for the Alphabetizer class here
 */
public class NoviceAlphabetizerTests {

    @Test
    public void alphaConstructor() {
        String[] inputAlpha = {"a1", "b1", "c1"};
        String[] inputNonAlpha = {"b1", "a1", "c1"};
        String[] inputEmpty = {};
        Alphabetizer alpha = new Alphabetizer(inputAlpha);
        Alphabetizer nonAlpha = new Alphabetizer(inputNonAlpha);
        Alphabetizer empty = new Alphabetizer(inputEmpty);
        inputAlpha[0] = "a2";
        assertTrue("the constructor should clone the array", !alpha.next().equals(inputAlpha[0]));
    }

    @Test
    public void alphaTestHasNext01() {
        String[] inputAlpha = {"a1", "b1", "c1"};
        String[] inputNonAlpha = {"b1", "a1", "c1"};
        String[] inputWeirdAlpha = {"CC", "bb","aa"};
        String[] inputEmpty = {};
        Alphabetizer alpha = new Alphabetizer(inputAlpha);
        Alphabetizer nonAlpha = new Alphabetizer(inputNonAlpha);
        Alphabetizer weirdAlpha = new Alphabetizer(inputWeirdAlpha);
        Alphabetizer empty = new Alphabetizer(inputEmpty);
        Alphabetizer nullAlpha = new Alphabetizer(null);
        assertTrue("alpha next should not be null", !ifNextNull(alpha));
        assertTrue("alpha next should not be null", !ifNextNull(alpha));
        assertTrue("alpha next should not be null", !ifNextNull(alpha));
        alpha = new Alphabetizer(inputAlpha);
        assertTrue("alpha should have next of a1", alpha.next().equals("a1"));
        assertTrue("alpha should have next of b1", alpha.next().equals("b1"));
        assertTrue("alpha should have next of c1", alpha.next().equals("c1"));
        assertTrue("alpha should throw an exception after next that is an instance of noSuchElement exception", testExceptionReturnType(alpha));
        assertTrue("nonAlpha should have next of a1", nonAlpha.next().equals("a1"));
        assertTrue("nonAlpha should have next of b1", nonAlpha.next().equals("b1"));
        assertTrue("nonAlpha should have next of c1", nonAlpha.next().equals("c1"));
        assertTrue("nonAlpha should not have next", !nonAlpha.hasNext());
        assertTrue("nonAlpha should throw an exception after next that is an instance of noSuchElement exception", testExceptionReturnType(nonAlpha));
        assertTrue("weirdAlpha should have next of a1", weirdAlpha.next().equals("CC"));
        assertTrue("weirdAlpha should have next of b1", weirdAlpha.next().equals("aa"));
        assertTrue("weirdAlpha should have next of c1", weirdAlpha.next().equals("bb"));
//        assertTrue("weirdAlpha should not have next", !weirdAlpha.hasNext());
//        assertTrue("weirdAlpha should throw an exception after next that is an instance of noSuchElement exception", testExceptionReturnType(weirdAlpha));
        assertTrue("empty string should return exception running next", !empty.hasNext());
        assertTrue("empty should throw an exception after next that is an instance of noSuchElement exception", testExceptionReturnType(empty));
        assertTrue(!nullAlpha.hasNext());
    }

    boolean testExceptionReturnType(Alphabetizer test) {
        try {
            test.next();
        } catch (NoSuchElementException e1) {
            return true;
        }
        return false;
    }
    boolean ifNextNull(Alphabetizer test) {
        if(test.next() != null) {
            return false;
        }
        return true;
    }
}