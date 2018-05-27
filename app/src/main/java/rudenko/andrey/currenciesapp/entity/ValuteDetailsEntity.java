package rudenko.andrey.currenciesapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public class ValuteDetailsEntity {

    @SerializedName("ID")
    private String id;
    @SerializedName("NumCode")
    private Integer numCode;
    @SerializedName("CharCode")
    private String charCode;
    @SerializedName("Nominal")
    private Integer nominal;
    @SerializedName("Name")
    private String name;
    @SerializedName("Value")
    private Double value;
    @SerializedName("Previous")
    private Double previous;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumCode() {
        return numCode;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrevious() {
        return previous;
    }

    public void setPrevious(Double previous) {
        this.previous = previous;
    }

}
