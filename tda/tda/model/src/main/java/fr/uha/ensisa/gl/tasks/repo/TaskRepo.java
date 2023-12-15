package fr.uha.ensisa.gl.tasks.repo;

import java.util.Collection;

import fr.uha.ensisa.gl.tasks.Task;

public interface TaskRepo {
    
	public long persist(Task t);
	public void remove(long id);
	public Task find(long id);
	public Collection<Task> findAll();
	public long count();
}
