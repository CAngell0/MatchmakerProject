package matchmaker.tests;

/**
 * Project imports
 */
import matchmaker.controller.Controller;

/**
 * Reflection imports
 */
import java.lang.reflect.*;

/**
 * Testing imports
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControllerTest
{
	private Controller testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
	}

	@Test
	void testDataMembers()
	{
		Field [] fields = testedController.getClass().getDeclaredFields();

		for (Field field : fields)
		{
			assertTrue(Modifier.isPrivate(field.getModifiers()), "All data members must be private!");
			String name = field.getType().getSimpleName();
			

		}

	}

	@Test
	void testControllerMethods()
	{
		Method [] methods = testedController.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 1, "You need at least 1 method in the controller");
		
		boolean hasStart = false;

		for (Method method : methods)
		{
			Type[] types = method.getGenericParameterTypes();
			if (method.getName().equals("start"))
			{
				hasStart = true;
				assertTrue(Modifier.isPublic(method.getModifiers()), "The " + method.getName()+ " method must be public");
				assertTrue(types.length == 0, "The start method has no parameter!");
			}

			
		}
		assertTrue(hasStart, "You need a method named start");

	}
	
}
