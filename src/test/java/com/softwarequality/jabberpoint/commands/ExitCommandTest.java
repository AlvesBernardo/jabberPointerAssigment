package com.softwarequality.jabberpoint.commands;

import com.softwarequality.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {

    private ExitCommand exitCommand2;
    private ExitCommand command;
    private TestablePresentation testablePresentation;

    @BeforeEach
    void setUp() {
        Presentation presentation = new Presentation();  // create Presentation instance
        testablePresentation = new TestablePresentation(presentation);
        this.command = new ExitCommand(testablePresentation);
    }

    @Test
    void ExitCommandConstructorToThrowError() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.exitCommand2 = new ExitCommand(null);
        });
    }

    @Test
    void execute_shouldCallExitOnPresentation() {
        // Act
        this.command.execute();

        // Assert
        assertTrue(testablePresentation.exitCalled, "Exit method was not called on the presentation");
    }

    class TestablePresentation extends Presentation {
        boolean exitCalled = false;

        @Override
        public void exit() {
            this.exitCalled = true;
        }

        public TestablePresentation(Presentation presentation) {
            super(presentation);
        }
    }
}
