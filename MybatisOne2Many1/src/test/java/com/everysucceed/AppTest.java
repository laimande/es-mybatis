package com.everysucceed;

import static org.junit.Assert.assertTrue;

import com.es.util.SqlSessionUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(SqlSessionUtils.openSession());
    }
}
