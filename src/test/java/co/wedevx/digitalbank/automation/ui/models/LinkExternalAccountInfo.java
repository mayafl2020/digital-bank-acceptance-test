package co.wedevx.digitalbank.automation.ui.models;

public class LinkExternalAccountInfo {

    private String openBankingProviders;
    private String username;
    private String password;

    public String getOpenBankingProviders() {
        return openBankingProviders;
    }

    public void setOpenBankingProviders(String openBankingProviders) {
        this.openBankingProviders = openBankingProviders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkExternalAccountInfo(String openBankingProviders, String username, String password) {
        this.openBankingProviders = openBankingProviders;
        this.username = username;
        this.password = password;
    }
}
