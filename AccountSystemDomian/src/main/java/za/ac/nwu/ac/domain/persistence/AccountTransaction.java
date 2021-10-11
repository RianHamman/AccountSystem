package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "ACCOUNT_TYPE", schema = "DISC_VIT_MILES_SANDBOX")
public class AccountTransaction implements Serializable{

    @Id
    @SequenceGenerator(name = "DISC_VIT_MILES_GENERIC_SEQ", sequenceName = "DISC_VIT_MILES_SANDBOX.DISC_VIT_MILES_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISC_VIT_MILES_GENERIC_SEQ")

    @Column(name = "TRANS_ID")
    private Long transID;

    @Column(name = "ACC_TYPE_ID")
    private AccountType accountType;

    @Column(name = "MEMBER_ID")
    private Long memberID;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "TRANS_DATE")
    private LocalDate transDate;

    public AccountTransaction(Long transID, AccountType accountType, Long memberID, Long amount, LocalDate transDate) {
        this.transID = transID;
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transDate = transDate;
    }

    public AccountTransaction() {
    }

    public Long getTransID() {
        return transID;
    }

    public void setTransID(Long transID) {
        this.transID = transID;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACC_TYPE_ID")
    public AccountType getAccountType(){
        return accountType;
    }

    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transID, that.transID) && Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transDate, that.transDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transID, accountType, memberID, amount, transDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transID=" + transID +
                ", accTypeId=" + accountType +
                ", memberID=" + memberID +
                ", amount=" + amount +
                ", transDate=" + transDate +
                '}';
    }
}
