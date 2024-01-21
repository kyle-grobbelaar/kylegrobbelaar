package com.enviro.assessment.grad001.kylegrobbelaar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class InvestorApplicationTests {

	@Autowired
	private MockMvc mockmvc;

	@Test
	void canRetrieveProducts() throws Exception {
		this.mockmvc.perform(get("/kyle/investments")).andExpect(status().isOk());
	}

	@Test
	void canRetrieveSpecificProduct() throws Exception {
		this.mockmvc.perform(get( "/investment/1" )).andExpect(status().isOk());
	}

	@Test
	void cannotRetrieveNonExistentProduct() throws Exception {
		this.mockmvc.perform(get( "/investment/10000" )).andExpect(status().isNotFound());
	}

	@Test
	void canPostWithdrawalRequest() throws Exception {
		String formData = "withdrawAmount=100";

		this.mockmvc.perform(post( "/withdraw/1" )
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.content( formData ))
				.andExpect( status().isOk() );

		this.mockmvc.perform(post( "/withdraw/1" )
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.content( formData ))
				.andExpect( status().isOk() );

	}

	@Test
	void cannotWithdrawFromRetirementAccount() throws Exception {
		String formData = "withdrawAmount=100";

		this.mockmvc.perform(post( "/withdraw/2" )
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.content( formData ))
				.andExpect( status().isForbidden() );
	}

	@Test
	void cannotWithdrawTooMuch() throws Exception {
		String formData = "withdrawAmount=9999";

		this.mockmvc.perform(post( "/withdraw/1" )
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.content( formData ))
				.andExpect( status().isForbidden() );
	}

	@Test
	void getPersonExistsId() throws Exception {
		this.mockmvc.perform(get( "/investor/id=1" ))
				.andExpect( status().isOk() );
	}

	@Test
	void getPersonExistsEmail() throws Exception {
		this.mockmvc.perform(get( "/investor/email=kyle@mail.com" ))
				.andExpect( status().isOk() );
	}

	@Test
	void getPersonExistsName() throws Exception {
		this.mockmvc.perform(get( "/investor/email=donny@mail.com" ))
				.andExpect( status().isOk() );
	}

	@Test
	void personDoesNotExistId() throws Exception {
		this.mockmvc.perform(get( "/investor/id=1000" ))
				.andExpect( status().isNotFound() );
	}

	@Test
	void personDoesNotExistEmail() throws Exception {
		this.mockmvc.perform(get( "/investor/email=idontexist@mail.com" ))
				.andExpect( status().isNotFound() );
	}

	@Test
	void personDoesNotExistname() throws Exception {
		this.mockmvc.perform(get( "/investor/name=iamnotreal" ))
				.andExpect( status().isNotFound() );
	}
}
