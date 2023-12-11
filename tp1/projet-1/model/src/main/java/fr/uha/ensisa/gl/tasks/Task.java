package fr.uha.ensisa.gl.tasks;

public class Task {
    private long id;
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getDescription() {
        return this.description;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }

}
