package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT_TYPE", schema = "DISC_VIT_MILES_SANDBOX")
public class AccountType implements Serializable{

    @Id
    @SequenceGenerator(name = "DISC_VIT_MILES_GENERIC_SEQ", sequenceName = "DISC_VIT_MILES_SANDBOX.DISC_VIT_MILES_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DISC_VIT_MILES_GENERIC_SEQ")

    @Column(name = "ACCOUNT_TYPE_ID")
    private Long accountTypeId;

    @Column(name = "MNEMONIC")
    private String mnemonic;

    @Column(name = "ACCOUNT_TYPE_DESCRIPTION")
    private String accountTypeDescription;

    @Column(name = "DATE_CREATED")
    private LocalDate DateCreated;

    private Set<AccountTransaction> accountTransactions;

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeDescription, LocalDate dateCreated) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeDescription = accountTypeDescription;
        DateCreated = dateCreated;
    }

    public AccountType() {
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getAccountTypeDescription() {
        return accountTypeDescription;
    }

    public void setAccountTypeDescription(String accountTypeDescription) {
        this.accountTypeDescription = accountTypeDescription;
    }

    public LocalDate getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        DateCreated = dateCreated;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType accountType = (AccountType) o;
        return Objects.equals(accountTypeId, accountType.accountTypeId) && Objects.equals(mnemonic, accountType.mnemonic) && Objects.equals(accountTypeDescription, accountType.accountTypeDescription) && Objects.equals(DateCreated, accountType.DateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeDescription, DateCreated);
    }

    @Override
    public String toString() {
        return "Account_Type{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeDescription='" + accountTypeDescription + '\'' +
                ", DateCreated=" + DateCreated +
                '}';
    }
}
