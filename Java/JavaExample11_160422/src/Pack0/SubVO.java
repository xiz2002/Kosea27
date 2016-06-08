package Pack0;

/**
 * @author ToyMac
 * 
 * Java Bean(s)
 * 
 * 
 * 		   POJO(Plain Old Java Object) : EJB의 Entity Bean에 비해서 예전 스타일의 자바 객체 
 * 		   
 * 
 *         DTO(Data Transfer Object), VO(Value Object) : 차이점 -> MetaData 여부를 가지면DTO, 가지지 않으면 VO 
 *         Entity / <<Entity>> <-- DB Table relation 1:1 mapping(대응, 사상) 
 *         Ex) 空っぽの箱 (빈 상자 == class) : 필드(속성, 열) 값을 전송(transfer) <---> DB table/view
 *         	음료 상자 = DTO/VO (Class)
 *         	음료 = property (field, column, attribute)
 *         	음료를 운반하다(동사) : getter/setter Method(Function)
 * 
 *         DB table fields id varchar2(20) not null primary key, (필수, 주키)
 *         pwd varchar2(255) not null, (필수 입력) 
 *         name varchar2(50) not null, (필수 입력)
 *         address varchar2(255), (선택사항)
 * 
 */
public class SubVO {
	/*
	 * member field(s) 
	 * MemberVo member = new MemberVo(); 
	 * member.id = "TEST"; //클래스 필드에 직접접근하지 않는다. (보안, 은닉)
	 * member.setId("TEST"); // 메소드를 통하여 접근한다.
	*/ 
	private String id;
	private String pw;
	private String name;
	private String address;

//	Construct
	public SubVO() {}
	
	/**
	 * @param id
	 * @param pw
	 * @param name
	 * 
	 * not null(필수 항목)만 값을 삽입(insertion)
	 */
	public SubVO(String id,
				 String pw, 
				 String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	/**
	 * @param id
	 * @param pw
	 * @param name
	 * @param address
	 * 
	 * fields setters = overloading Constructor
	 * = telescoping Constructor
	 * : 동시 멤버 필드 초기화 (대입)
	 * 주의) Overloading constructor 출현 -> 기본 생성자를 사용하려면 기본 생성자는 명시적 선언!
	 */
	public SubVO(String id, 
				 String pw, 
				 String name, 
				 String address) {
//		this.setId(id);
//		this.setPw(pw);
//		this.setName(name);
//		this.setAddress(address);
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
	}
	
//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 * 
//	 * getters -> Object.toString overriding(상속)
//	 * : 동시 멤버 필드 값을 리턴 --> 멤버필드 값 확인.
//	 * 
//	 * Ex) 사용 예) 
//	 * 		인쇄(print) -> 객체.toString() 또는 객체
//	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubVO [id=");
		builder.append(id);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
//	@Override
//	public String toString() {
//		return "SubVO [id=" + id + ", "
//						+ "pw=" + pw + ", "
//						+ "name=" + name + ", "
//						+ "address=" + address + "]";
//	}
//
//	@Override
//	public String toString() {
//		return String.format("SubVO (id:%s, "
//								+ "pw:%s,"
//								+ " name:%s,"
//								+ " address:%s)", id, pw, name, address);
//	}

	
	
	//	 Setter
	public void setId(String id) {/*암호화/복호와... 코드 가공부*/ this.id = id; }

	public void setPw(String pw) {	this.pw = pw; }

	public void setName(String name) {	this.name = name; }

	public void setAddress(String address) {	this.address = address; }
	

//	 Getter
	public String getId() {	/*암호화/복호와... 코드 가공부*/ return id; }
	
	public String getPw() {	return pw; }
	
	public String getName() { return name;	}
	
	public String getAddress() { return address; }
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;	// 소수 (솟수) Ex) 1,3,5,7,11.......
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * Object.equals() : 객체의 주소값으로 비교
	 * equals Overriding Method 
	 * 	: '두' 객체의 필드들의 '값' 을 비교
	 * 
	 * Ex) SubVO subVo1 = new SubVO();
	 * 	   Field Value insert......
	 * 	   SubVO subVo2 = new SubVo();
	 *     Field Value insert......
	 *    
	 *     boolean flag = subVo1.equals(subV2);
	 *     : 두객체 (subVo1, subVo2)의 필드값들을 일일히 비교
	 *       친자 확인(instanceof), 생성 여부 (null)..
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SubVO)) {
			return false;
		}
		SubVO other = (SubVO) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pw == null) {
			if (other.pw != null) {
				return false;
			}
		} else if (!pw.equals(other.pw)) {
			return false;
		}
		return true;
	}

}