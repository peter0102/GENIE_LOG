package fr.uha.ensisa.gl.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import fr.uha.ensisa.gl.tasks.repo.TaskRepo;

public class TaskRepoMem implements TaskRepo {

    private Collection<Task> repo = new ArrayList<>();

    @Override
    public long persist(Task task){
        this.repo.add(task);
        return -34;
    };
    @Override
    public void remove(long id){

    };
    @Override
    public Task find(long id){
        return null;
    };
    @Override
    public Collection<Task> findAll(){
        return Collections.unmodifiableCollection(repo);
    };
    @Override
    public long count(){
        return 0;
    };
}
