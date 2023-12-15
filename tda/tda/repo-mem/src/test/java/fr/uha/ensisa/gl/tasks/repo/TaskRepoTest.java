package fr.uha.ensisa.gl.tasks.repo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import fr.uha.ensisa.gl.tasks.Task;
import fr.uha.ensisa.gl.tasks.TaskRepoMem;

public class TaskRepoTest {
    @Test
    public void findAllInEmptyRepo() {
        TaskRepoMem sut = new TaskRepoMem();
        assertTrue(sut.findAll().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(longs = {0,1,420,-90,Long.MAX_VALUE,Long.MIN_VALUE })
    public void findEmptyRepo(long id){
        TaskRepoMem sut = new TaskRepoMem();
        assertNull(sut.find(id));
    }

    @Test
    public void addOneTask() {
        TaskRepoMem sut = new TaskRepoMem();
        Task t = new Task();
        t.setDescription("Jouez à Spider-Man 2 !!");
        sut.persist(t);
        Task actual = sut.findAll().iterator().next();
        assertNotNull(actual);
        assertEquals(t.getDescription(), actual.getDescription());
    }

    @Test
    public void hackingReturnFromFindAll() {
        TaskRepoMem sut = new TaskRepoMem();
        Task t = new Task();
        sut.persist(t);
        assertThrows(Exception.class, () -> sut.findAll().add(new Task()));
        assertEquals(1, sut.findAll().size());
    }

    @Test
    public void persistTaskWithId() {
        TaskRepoMem sut = new TaskRepoMem();
        Task t = new Task();
        long id = sut.persist(t);
        assertEquals(id, t.getId());
    }

    @Test
    public void findTaskById() {
        TaskRepoMem sut = new TaskRepoMem();
        Task t = new Task();
        long id = sut.persist(t);
        Task actual = sut.find(id);
        assertNotNull(actual);
        assertEquals(id, actual.getId());
        assertEquals(t.getDescription(), actual.getDescription());
    }
}
