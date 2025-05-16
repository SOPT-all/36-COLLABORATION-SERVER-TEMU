package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    RECOMMEND("추천"),
    GOODS("의류·잡화·뷰티"),
    BABY("유·아동"),
    NECESSITY("생활/생필품"),
    KITCHEN("홈·주방"),
    DIGITAL("디지털·가전"),
    SPORT("스포츠·건강"),
    CAR("자동차·공구"),
    BOOK("도서")

    ;
    private
    String categoryName;
}
