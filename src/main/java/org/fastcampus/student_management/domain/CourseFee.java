package org.fastcampus.student_management.domain;

public class CourseFee {

    private int fee;

    public CourseFee(int fee) {
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }

    public void changeFee(int fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("금액은 음수가 불가능 합니다.");
        }

        this.fee = fee;
    }
}
