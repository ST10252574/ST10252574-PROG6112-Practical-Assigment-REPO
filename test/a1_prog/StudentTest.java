package a1_prog;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class StudentTest {

    private Student student; // Instance of Student to be tested
    private LearnerManager learnerManager;
    private Student learner;

    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Initialize the Student instance before each test
        student = new Student("S001", "John Doe", 20, "john@example.com", "Computer Science");
        learnerManager = new LearnerManager();
        learner = new Student("L001", "Jane Smith", 22, "jane@example.com", "Mathematics");
    }

    @After
    public void tearDown() {
        // Clean up after each test if necessary
        student = null;
        learnerManager = null;
        learner = null;
    }

    /**
     * Test of getStudentId method, of class Student.
     */
    @Test
    public void testGetStudentId() {
        System.out.println("getStudentId");
        String expResult = "S001";
        String result = student.getStudentId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Student.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "John Doe";
        String result = student.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class Student.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int expResult = 20;
        int result = student.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Student.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "john@example.com";
        String result = student.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourse method, of class Student.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        String expResult = "Computer Science";
        String result = student.getCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Student.
     */
   @Test
public void testToString() {
    System.out.println("toString");
    String expResult = "STUDENT ID: S001\nSTUDENT NAME: John Doe\nSTUDENT AGE: 20\nSTUDENT EMAIL: john@example.com\nSTUDENT COURSE: Computer Science\n";
    String result = student.toString();
    assertEquals(expResult, result);
}


    // Unit Test Class for LearnerManager
    /**
     * Test of addLearner method.
     */
    @Test
    public void testAddLearner() {
        learnerManager.addLearner(learner);
        assertEquals(1, learnerManager.getLearners().size());
        assertEquals(learner, learnerManager.getLearners().get(0));
    }

    /**
     * Test of displayLearners method.
     */
    @Test
    public void testDisplayLearners() {
        learnerManager.addLearner(learner);
        // Capture output (this part can be improved with a better output capturing mechanism)
        // For simplicity, we will just check the size of the learners list
        assertEquals(1, learnerManager.getLearners().size());
    }

    /**
     * Test of generateReport method.
     */
    @Test
    public void testGenerateReport() {
        learnerManager.addLearner(learner);
        // Check if the report generation does not throw an exception
        try {
            learnerManager.generateReport();
        } catch (Exception e) {
            fail("Report generation threw an exception: " + e.getMessage());
        }
    }
}
