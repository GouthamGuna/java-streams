package in.dev.gmsk.model;

import java.util.List;

public class Fee {

    private String totalAmount;
    private String totalBalance;
    private String totalFeeAmount;
    private List<Fee> feeList;

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getTotalFeeAmount() {
        return totalFeeAmount;
    }

    public void setTotalFeeAmount(String totalFeeAmount) {
        this.totalFeeAmount = totalFeeAmount;
    }

    public List<Fee> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<Fee> feeList) {
        this.feeList = feeList;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "totalAmount='" + totalAmount + '\'' +
                ", totalBalance='" + totalBalance + '\'' +
                ", totalFeeAmount='" + totalFeeAmount + '\'' +
                ", feeList=" + feeList +
                '}';
    }
}
