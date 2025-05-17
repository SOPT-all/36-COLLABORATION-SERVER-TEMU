package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    RECOMMEND("recommend"),
    GOODS("goods"),
    BABY("baby"),
    NECESSITY("neccessity"),
    KITCHEN("kitchen"),
    DIGITAL("digital"),
    SPORT("sport"),
    CAR("car"),
    BOOK("book")

    ;
    private
    String categoryName;
}
