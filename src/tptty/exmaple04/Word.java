package tptty.exmaple04;

public class Word {
	String eng;
	String kor;
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Word) {
			Word temp = (Word)obj;
			return (this.eng.equals(temp.eng) && this.kor.equals(temp.kor));
		}
		else
			return false;
	}
	

	@Override
	public int hashCode() {
		return this.eng.hashCode()+this.kor.hashCode();
		//eng와 kor이 같다면 같은 hashCode반환
	}




	public Word(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
	}

	@Override
	public String toString() {
		
		return eng+" : "+kor;
	}
}
