package cn.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Iterator;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;

public class CommonTest {
	 @Test
    public void testDecimalFromat() {
      assertEquals("null", new DecimalFormat( "#0.00").format(null));
    }
}
