package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();
    @Test
    void discountTest() {
        //given
        PayRequest payRequestG25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25,
                1000);
        PayRequest payRequestGU = new PayRequest(PayMethodType.MONEY, ConvenienceType.GU,
                1000);
        PayRequest payRequestSeven = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN,
                1000);
        //when
        Integer disCountedAmountG25 = discountByConvenience.getDisCountedAmount(payRequestG25);
        Integer disCountedAmountGU =discountByConvenience.getDisCountedAmount(payRequestGU);
        Integer disCountedAmountSeven =discountByConvenience.getDisCountedAmount(payRequestSeven);
        //then

        assertEquals(800, disCountedAmountG25);
        assertEquals(900, disCountedAmountGU);
        assertEquals(1000, disCountedAmountSeven);
    }

}