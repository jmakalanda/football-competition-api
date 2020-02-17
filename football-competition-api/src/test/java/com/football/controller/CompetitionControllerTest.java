package com.football.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
//import com.howtodoinjava.rest.controller.EmployeeController;
//import com.howtodoinjava.rest.dao.EmployeeDAO;
//import com.howtodoinjava.rest.model.Employee;
//import com.howtodoinjava.rest.model.Employees;
 
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CompetitionControllerTest {


	@Test
	public void testGetCompatitionString() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/events/list";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed and the data is as expected
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("name"));
	}
	
	
	@Test
	public void testList() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/events/status=inprogress";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed and the data is as expected
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("name"));
	}
	
	
	@Test
	public void testGetCompatitionStringString() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + 8080 + "/events/status=inprogress/liveStatus=HT";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed and the data is as expected
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    //[{"id":"hbahiif","name":"Zaglebie Lubin - Pogon Szczecin","competitionId":"ge","competition":"Ekstraklasa","countryId":"eh","country":"Poland","timestamp":"1470576600","date":"07.08.2016.","time":"13:30","statusType":"inprogress","round":4,"homeTeamName":"Zaglebie Lubin","awayTeamName":"Pogon Szczecin","homeScoreCurrent":0,"awayScoreCurrent":0,"liveStatus":"HT"},{"id":"gjghfdb","name":"StabÃ¦k Fotball - Haugesund FK","competitionId":"f","competition":"Eliteserien","countryId":"f","country":"Norway","timestamp":"1470576600","date":"07.08.2016.","time":"13:30","statusType":"inprogress","round":19,"homeTeamName":"StabÃ¦k Fotball","awayTeamName":"Haugesund FK","homeScoreCurrent":0,"awayScoreCurrent":1,"liveStatus":"HT"}]
	    Assert.assertEquals(true, result.getBody().contains("hbahiif"));
	    Assert.assertEquals(true, result.getBody().contains("Zaglebie Lubin - Pogon Szczecin"));
	    Assert.assertEquals(true, result.getBody().contains("competitionId"));
	}
	
	
	
//	@InjectMocks
//	private CompetitionService competitionService;
//	
//	@Mock
//	private Competition mockCompetition;

	
//	@Autowired
//	private MockMvc mvc;
//	 
//	@Test
//	public void testGetCompatitionString() throws Exception 
//	{
//	  mvc.perform( MockMvcRequestBuilders
//	      .get("/events/list")
//	      .accept(MediaType.APPLICATION_JSON))
//	      .andDo(print())
//	      .andExpect(status().isOk())
//	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
//	      //.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
//	}
//	 
//	@Test
//	public void testGetCompatitionStringString() throws Exception 
//	{
//	  mvc.perform( MockMvcRequestBuilders
//	      .get("/events/status={status}", "inprogress")
//	      .accept(MediaType.APPLICATION_JSON))
//	      .andDo(print())
//	      .andExpect(status().isOk())
//	      .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(1));
//	}

//	private List<Competition> competitions = Arrays.asList
//			 (new Competition("hbaffaf", "FK Tyumen - Luch-Energiya Vladivostok","bbbg", "Football National League", "cb","Russia", "1470484800", "06.08.2016.", "12:00", "finished", 6,"FK Tyumen", "Luch-Energiya Vladivostok", 0, 0,"FT")
//			 ,new Competition("hbaffag", "FK Tyumen - Luch-Energiya Vladivostok","bbbg", "Football National League", "cb","Russia", "1470484800", "06.08.2016.", "12:00", "finished", 6,"FK Tyumen", "Luch-Energiya Vladivostok", 0, 0,"HT"));
//	
	
//	Competition mockCompetition = new Competition("hbaffaf", "FK Tyumen - Luch-Energiya Vladivostok","bbbg", "Football National League", "cb","Russia", "1470484800", "06.08.2016.", "12:00", "finished", 6,"FK Tyumen", "Luch-Energiya Vladivostok", 0, 0,"FT");

	
//	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
//
//	@Test
//	public void testGetCompatitionString() throws Exception {
//
////		Mockito.when(
////				studentService.retrieveCourse(Mockito.anyString(),
////						Mockito.anyString())).thenReturn(mockCourse);
//		
//		Mockito.when(
//				competitionService.findByStatusType(Mockito.anyString())).thenReturn(mockCompetition1);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/events/status=inprogress").accept(
//				MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		System.out.println("DDDDDDDDDDDDDDDDD");
//		System.out.println(result.getResponse());
//		String expected = "{id:Course1,name:Spring,description:10 Steps}";
//
//		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//
//		JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), false);
//	}
//
//	
/*	@Test
	public void createStudentCourse() throws Exception {
		Course mockCourse = new Course("1", "Smallest Number", "1",
				Arrays.asList("1", "2", "3", "4"));

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				studentService.addCourse(Mockito.anyString(),
						Mockito.any(Course.class))).thenReturn(mockCourse);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/students/Student1/courses")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/students/Student1/courses/1",
				response.getHeader(HttpHeaders.LOCATION));

	}*/

	
//	@Test
//	void testList() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetCompatitionString() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetCompatitionStringString() {
//		fail("Not yet implemented");
//	}
}
