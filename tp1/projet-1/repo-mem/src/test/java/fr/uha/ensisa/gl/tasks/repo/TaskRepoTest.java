package fr.uha.ensisa.gl.tasks.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import fr.uha.ensisa.gl.tasks.Task;
import fr.uha.ensisa.gl.tasks.TaskRepoMem;

public class TaskRepoTest {
    @Test
    public void findAllInEmptyRepo() {
        TaskRepo repo = new TaskRepoMem();
        assertTrue(repo.findAll().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 420, -90, Integer.MAX_VALUE, Integer.MIN_VALUE})
    public void findAllInEmptyRepo(long id) {
        TaskRepoMem sut = new TaskRepoMem();
        assertNull(sut.find(id));
    }

    @Test
    public void addOneTask() {
        TaskRepoMem sut = new TaskRepoMem();
        Task t = new Task();
        t.setDescription("test");
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
}
