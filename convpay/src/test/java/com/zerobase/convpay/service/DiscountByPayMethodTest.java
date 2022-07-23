package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    private DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountSuccess() {
        //given
        PayRequest payRequestMoeny = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);

        //when
        Integer disCountedAmountMoney = discountByPayMethod.getDisCountedAmount(payRequestMoeny);
        Integer disCountedAmountCard = discountByPayMethod.getDisCountedAmount(payRequestCard);
        //then

        assertEquals(700, disCountedAmountMoney);
        assertEquals(1000, disCountedAmountCard);
    }

}