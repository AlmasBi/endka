package com.example.myapplication;

public class ExampleItem2 {

    public Integer Confirmed;
    public Integer Deaths;
    public Integer Recovered;
    public Integer Active;
    public String Date;
    public String url;


    public ExampleItem2(Integer Confirmed,Integer Deaths,Integer Recovered,Integer Active,String Date){
        this.Confirmed=Confirmed;

        this.Deaths=Deaths;
        this.Recovered=Recovered;
        this.Active=Active;
        this.Date=Date;
        this.url=url;

    }



    public Integer getConfirmed() {
        return Confirmed;
    }
    public Integer getDeaths() {
        return Deaths;
    }
    public Integer getRecovered() {
        return Recovered;
    }
    public Integer getActive() {
        return Active;
    }
    public String getDate() {
        return Date;
    }
}
