package fr.uha.ensisa.gl.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import fr.uha.ensisa.gl.tasks.repo.TaskRepo;

public class TaskRepoMem implements TaskRepo {

    private Collection<Task> repo = new ArrayList<>();
    // TODO make sure the array list is the right choice

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Task find(long id) {
        for (Task t: repo) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Collection<Task> findAll() {
        return Collections.unmodifiableCollection(repo);
    }

    @Override
    public long persist(Task task) {
        // TODO: Tester que c'est pas bien de faire ça comme ça
        task.setId(this.repo.size());
        this.repo.add(task);
        return task.getId();
    }

    @Override
    public void remove(long arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

}
