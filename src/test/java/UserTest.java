import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import ru.netology.AccessDeniedException;
import ru.netology.User;
import ru.netology.UserNotFoundException;

public class UserTest {
    User userTest;
    User userTest1;

    @BeforeEach
    public void createNewUser() {
        userTest = new User("Vasya", "passTest", "VasyaPupkin@mail.com", 15);
        userTest1 = new User("Nikita", "passTest1", "NikitaLitvinkov@mail.com", 27);
    }

    @AfterEach
    public void deleteNewUser() {
        userTest = null;
        userTest1 = null;
    }

    @Test
    public void getUserByLoginAndPasswordTestFalse() {
        String loginTest = "Vasya", passwordTest = "Pupkin";
        Class<UserNotFoundException> expected = UserNotFoundException.class;
        Executable executable = () -> User.getUserByLoginAndPassword(loginTest, passwordTest);
        Assertions.assertThrowsExactly(expected, executable);
    }

    @Test
    public void validateUserTestTrue() throws AccessDeniedException {
        boolean result = User.validateUser(userTest1);
        Assertions.assertTrue(result);
    }

    @Test
    public void validateUserTestFalse() {
        Class<AccessDeniedException> expected = AccessDeniedException.class;
        Executable executable = () -> User.validateUser(userTest);
        Assertions.assertThrowsExactly(expected, executable);
    }
}
