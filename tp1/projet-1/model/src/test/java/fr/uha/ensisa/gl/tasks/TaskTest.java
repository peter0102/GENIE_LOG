package fr.uha.ensisa.gl.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import fr.uha.ensisa.gl.tasks.Task;

public class TaskTest {
    @ParameterizedTest
    @ValueSource(strings = { "une tâche", "Oh la belle tâche !"} )
    public void createTask(String taskDescription) {
        Task t = new Task();
        t.setDescription(taskDescription);
        assertEquals(taskDescription, t.getDescription());
    }
}
