//package com.softwarequality.jabberpoint;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//public class ConstantsTest
//{
//
//	@Test
//	public void testGetValue()
//	{
//		String testJson = "{ \"testKey\": \"testValue\" }";
//		InputStream inputStream = new ByteArrayInputStream(testJson.getBytes());
//		ClassLoader classLoader = Mockito.mock(ClassLoader.class);
//		Mockito.when(classLoader.getResourceAsStream(Mockito.anyString())).thenReturn(inputStream);
//
//		// here we mock the getClassLoader() method to return our mocked classLoader
//		Constants constants = Mockito.spy(new Constants(""));
//		Mockito.doReturn(classLoader).when(constants).getClass().getClassLoader();
//
//		Assertions.assertEquals("testValue", constants.getValue("testKey"));
//	}
//}
