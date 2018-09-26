package org.memoryextension.java.samples.basicwebapp.pojos;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class PingPongTest {

	private static final String NAME = "Adam";

	private static final Integer AGE = 25;

	private static final String EMAIL = "foo@example.com";


  private static Validator validator;

  @Before
  public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
  }


	@Test
	public void test() {
		PingPong pp = new PingPong();
		pp.setStart(645);
		pp.setEnd(923);

		assertEquals(new Integer(923), pp.getEnd());
		assertEquals(new Integer(645), pp.getStart() );
	}

	@Test
	public void testConstructor() {
		PingPong pp = new PingPong();
		assertNull(pp.getStart());
		assertNull(pp.getEnd());
		
		pp = new PingPong(1,57);
		assertEquals(new Integer(1), pp.getStart());
		assertEquals(new Integer(57), pp.getEnd());
		
	}



}
