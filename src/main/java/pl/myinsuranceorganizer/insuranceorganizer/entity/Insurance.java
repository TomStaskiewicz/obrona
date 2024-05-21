package pl.myinsuranceorganizer.insuranceorganizer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "insurances")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //???? nullable false? wtf
    @Column(name = "client_Name", nullable = false)
    private String clientName;

    @Column(name = "insurance_Name")
    private String insuranceName;

    @Column( name = "sum_Insurance")
    private Integer sumInsurance;

    @Column(name = "premium")
    private Double premium;

    @Column(name = "premiumPaid")
    private Boolean premiumPaid;

    // hibernate needs default constructor
    public Insurance() {

    }

    public Insurance(String clientName, String insuranceName, Integer sumInsurance, Double premium, Boolean premiumPaid) {
        this.clientName = clientName;
        this.insuranceName = insuranceName;
        this.sumInsurance = sumInsurance;
        this.premium = premium;
        this.premiumPaid = premiumPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public Integer getSumInsurance() {
        return sumInsurance;
    }

    public void setSumInsurance(Integer sumInsurance) {
        this.sumInsurance = sumInsurance;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Boolean getPremiumPaid() {
        return premiumPaid;
    }

    public void setPremiumPaid(Boolean premiumPaid) {
        this.premiumPaid = premiumPaid;
    }
}
