package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.enums;

public enum ProductTag {
    HIGH_REPURCHASE("재구매 고객이 많은 스토어"),
    LOW_RETURN("상품 반품률이 낮은 스토어"),
    ESTABLISHED_YEAR_AGO("1년 전 설립된 판매자"),
    NONE(null);

    private String tag;

    ProductTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
