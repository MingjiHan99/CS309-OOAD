package original_adapter;

public class StaffModel {
    private int peopleId;
    private String name;
    private String title;
    private String link;

    public StaffModel(int peopleId, String name, String title, String link) {
        this.setPeopleId(peopleId);
        this.setName(name);
        this.setTitle(title);
        this.setLink(link);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    @Override
    public String toString() {
        return "[peopleId=" + peopleId + ", name=" + name + ", title=" + title + ", link=" + link + "]";
    }
}
