package stepdefinitions;

public class GetterSetter {
	private String tittle;
	private String author;
	private String publisher;

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "GetterSetter [tittle=" + tittle + ", author=" + author + ", publisher=" + publisher + "]";
	}

}
