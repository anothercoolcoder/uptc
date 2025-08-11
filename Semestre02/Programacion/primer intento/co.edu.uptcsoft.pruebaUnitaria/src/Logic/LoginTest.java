package Logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LoginTest {

    @Test
    public void testLoginWithCorrectCredentials() {
        assertTrue(LoginApp.login("admin", "12345"));
    }

    @Test
    public void testLoginWithWrongUsername() {
        assertFalse(LoginApp.login("user", "12345"));
    }

    @Test
    public void testLoginWithWrongPassword() {
        assertFalse(LoginApp.login("admin", "wrongpass"));
    }

    @Test
    public void testLoginWithEmptyCredentials() {
        assertFalse(LoginApp.login("", ""));
    }

    @Test
    public void testLoginWithNullValues() {
        assertFalse(LoginApp.login(null, null));
    }
}