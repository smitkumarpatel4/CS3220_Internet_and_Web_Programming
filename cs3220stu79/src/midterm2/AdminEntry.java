package midterm2;

public class AdminEntry {

	static int c = 1;
	int id;
	String quote;
	String author;
	int like;
	int dislike;
	int view;

	public AdminEntry(String quote, String author) {
		super();
		this.quote = quote;
		this.author = author;
		this.id = c++;
		this.view = 0;
		this.like = 0;
		this.dislike = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getLike() {
		return like;
	}

	public void setLike() {
		this.like = like + 1;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike() {
		this.dislike = dislike + 1;
	}
}
