package models;

import java.util.ArrayList;
import java.util.List;

public class GuestBookBean {

	List<GuestBookEntryJSTL> entries;

	public GuestBookBean() {
		entries = new ArrayList<GuestBookEntryJSTL>();
	}

	public void setAddEntry(String dummy) {
		GuestBookEntryJSTL entry = new GuestBookEntryJSTL();
		entries.add(entry);
	}

	public GuestBookEntryJSTL getLastEntry() {
		return entries.get(entries.size() - 1);
	}

	public List<GuestBookEntryJSTL> getEntries() {
		return entries;
	}

	public void setEntries(List<GuestBookEntryJSTL> entries) {
		this.entries = entries;
	}

} 