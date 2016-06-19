package DTOVO;

public class MemberVO {
	String id, pw, name, cellPhone, homePhone, zipCode, address, email, joinDate;
	int degree;
	char gender;
	
	public MemberVO() {
	}
	
	public MemberVO(String id, String pw, String name, int degree, 
					char gender, String cellPhone, 
					String homePhone, String zipCode, String address, 
					String email, String joinDate) {
		setId(id);
		setPw(pw);
		setName(name);
		setDegree(degree);
		setGender(gender);
		setCellPhone(cellPhone);
		setHomePhone(homePhone);
		setZipCode(zipCode);
		setEmail(email);
		setJoinDate(joinDate);	
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}
	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the joinDate
	 */
	public String getJoinDate() {
		return joinDate;
	}
	/**
	 * @return the degree
	 */
	public int getDegree() {
		return degree;
	}
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param pw the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	/**
	 * @param degree the degree to set
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", cellPhone=" + cellPhone + ", homePhone="
				+ homePhone + ", zipCode=" + zipCode + ", address=" + address + ", email=" + email + ", joinDate="
				+ joinDate + ", degree=" + degree + ", gender=" + gender + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cellPhone == null) ? 0 : cellPhone.hashCode());
		result = prime * result + degree;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gender;
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cellPhone == null) {
			if (other.cellPhone != null)
				return false;
		} else if (!cellPhone.equals(other.cellPhone))
			return false;
		if (degree != other.degree)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	
}
