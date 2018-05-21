package com.nupurjaiswal.marketplace.controller;

import com.nupurjaiswal.marketplace.domain.Seller;
import com.nupurjaiswal.marketplace.repository.BidRepository;
import com.nupurjaiswal.marketplace.repository.BuyerRepository;
import com.nupurjaiswal.marketplace.repository.ProjectRepository;
import com.nupurjaiswal.marketplace.repository.SellerRepository;
import com.nupurjaiswal.marketplace.service.BidService;
import com.nupurjaiswal.marketplace.service.BuyerService;
import com.nupurjaiswal.marketplace.service.ProjectService;
import com.nupurjaiswal.marketplace.service.SellerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MarketplaceController.class)
public class MarketplaceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SellerService sellerService;

    @MockBean
    private SellerRepository sellerRepository;

    @MockBean
    private BuyerService buyerService;

    @MockBean
    private BuyerRepository buyerRepository;

    @MockBean
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;

    @MockBean
    private BidService bidService;

    @MockBean
    private BidRepository bidRepository;

    @Test
    public void givenSellers_whenGetSellers_thenReturnJsonArray() throws Exception{

        Seller seller = new Seller("Intuit");

        List<Seller> allSellers = Arrays.asList(seller);

        given(sellerService.getAllSellers()).willReturn(allSellers);

        mvc.perform(MockMvcRequestBuilders.get("/sellers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


}
