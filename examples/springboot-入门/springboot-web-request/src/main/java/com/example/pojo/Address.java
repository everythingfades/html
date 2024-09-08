package com.example.pojo;

public class Address {
  private String province;
  private String street;
  public String getProvince() {
    return province;
  }
  public String getStreet() {
    return street;
  }
  public void setProvince(String province) {
    this.province = province;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  @Override
  public String toString() {
    return "Address [province=" + province + ", street=" + street + "]";
  }
}
