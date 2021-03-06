package za.ac.nwu.ac.domain.dto;

import org.springframework.cglib.core.Local;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTypeDto implements Serializable {

    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public AccountTypeDto()
    {

    };

    public AccountTypeDto(String mnemonic, String accountTypeName, LocalDate creationDate)
    {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType)
    {
        this.setAccountTypeName(accountType.getAccountTypeDescription());
        this.setCreationDate(accountType.getDateCreated());
        this.setMnemonic(accountType.getMnemonic());
    }

    public String getMnemonic()
    {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic){
        this.mnemonic = mnemonic;
    }

    public String getAccountTypeName(){
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName){
        this.accountTypeName = accountTypeName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
