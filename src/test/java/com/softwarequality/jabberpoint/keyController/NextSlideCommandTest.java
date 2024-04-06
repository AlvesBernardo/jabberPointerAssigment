//import com.softwarequality.jabberpoint.keyController.KeyController;
//import com.softwarequality.jabberpoint.presentation.Presentation;
//import com.softwarequality.jabberpoint.presentation.PresentationFacade;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//class NextSlideCommandTest {
//
//    private TestablePresentationFacade testablePresentation;
//    private NextSlideCommand nextSlideCommand;
//
//    @BeforeEach
//    void setUp() {
//        this.testablePresentation = new TestablePresentationFacade();
//        this.nextSlideCommand = new NextSlideCommand(testablePresentation);
//    }
//
//    @Test
//    void execute_shouldCallNextSlideOnPresentation() {
//        // Act
//        this.nextSlideCommand.execute();
//
//        // Assert
//        assertTrue(this.testablePresentation.nextSlideCalled, "nextSlide method was not called on the presentation facade");
//    }
//
//
//    class TestablePresentationFacade extends PresentationFacade {
//        boolean exitCalled = false;
//
//        @Override
//        public void exit() {
//            this.exitCalled = true;
//        }
//
//        public TestablePresentationFacade(Presentation presentation) {
//            super(presentation);
//        }
//    }
//}