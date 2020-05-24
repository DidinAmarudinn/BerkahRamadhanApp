package com.example.loginwithgoogle.Menu.news.coronainfo;

import com.google.gson.annotations.SerializedName;

public class ResponeWorld  {
    @SerializedName("confirmed")
    private Confirmed confirmed;
    @SerializedName("deaths")
    private Deaths deaths;
    @SerializedName("recovered")
    private Recovered recovered;
    public ResponeWorld(Confirmed confirmed, Deaths deaths, Recovered recovered) {
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }
    public Confirmed getConfirmed() {
        return confirmed;
    }
    public void setConfirmed(Confirmed confirmed) {
        this.confirmed = confirmed;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public Recovered getRecovered() {
        return recovered;
    }

    public void setRecovered(Recovered recovered) {
        this.recovered = recovered;
    }
    public class Confirmed{
        @SerializedName("value")
        private String value;
        @SerializedName("detail")
        private String detail;

        public Confirmed(String value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
    public class Deaths{
        @SerializedName("value")
        private String value;
        @SerializedName("detail")
        private String detail;

        public Deaths(String value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
    public class Recovered{
        @SerializedName("value")
        private String value;
        @SerializedName("detail")
        private String detail;

        public Recovered(String value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
