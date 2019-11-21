package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Farmer {
	private String full_name;
	private int contact_no;
	@Id
	private String f_email;
	private String address;
	private String city;
	private String state;
	private int pincode;
	private int land_area;
	private String land_address;
	private int land_pincode;
	private int account_no;
	private int ifsc_code;
	private int adhar_no;
	private String adhar_fname; 
	private String pan_fname ;
	private String certificate_fname ;
	private String password ;
	private String status;
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public int getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	
	public String getF_email() {
		return f_email;
	}
	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getLand_area() {
		return land_area;
	}
	public void setLand_area(int land_area) {
		this.land_area = land_area;
	}
	public String getLand_address() {
		return land_address;
	}
	public void setLand_address(String land_address) {
		this.land_address = land_address;
	}
	public int getLand_pincode() {
		return land_pincode;
	}
	public void setLand_pincode(int land_pincode) {
		this.land_pincode = land_pincode;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public int getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(int ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	public int getAdhar_no() {
		return adhar_no;
	}
	public void setAdhar_no(int adhar_no) {
		this.adhar_no = adhar_no;
	}
	public String getAdhar_fname() {
		return adhar_fname;
	}
	public void setAdhar_fname(String adhar_fname) {
		this.adhar_fname = adhar_fname;
	}
	public String getPan_fname() {
		return pan_fname;
	}
	public void setPan_fname(String pan_fname) {
		this.pan_fname = pan_fname;
	}
	public String getCertificate_fname() {
		return certificate_fname;
	}
	public void setCertificate_fname(String certificate_fname) {
		this.certificate_fname = certificate_fname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Farmer() {
		super();
	}
	@Override
	public String toString() {
		return "Farmer [full_name=" + full_name + ", contact_no=" + contact_no + ", f_email=" + f_email
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", land_area=" + land_area + ", land_address=" + land_address + ", land_pincode=" + land_pincode
				+ ", account_no=" + account_no + ", ifsc_code=" + ifsc_code + ", adhar_no=" + adhar_no
				+ ", adhar_fname=" + adhar_fname + ", pan_fname=" + pan_fname + ", certificate_fname="
				+ certificate_fname + ", password=" + password + ", status=" + status + "]";
	}
	
	
	
}