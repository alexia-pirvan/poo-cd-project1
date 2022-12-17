public final class UserAccount {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public UserAccount(final UserAccount credentials) {
        this.name = credentials.getName();
        this.password = credentials.getPassword();
        this.accountType = credentials.getAccountType();
        this.country = credentials.getCountry();
        this.balance = credentials.getBalance();
    }

    public UserAccount() {

    }

    @Override
    public String toString() {
        return "UserAccount{"
                + "name='" + name + '\''
                + ", password='" + password
                + '\'' + ", accountType='" + accountType
                + '\'' + ", country='" + country
                + '\'' + ", balance=" + balance
                + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(final String balance) {
        this.balance = balance;
    }
}