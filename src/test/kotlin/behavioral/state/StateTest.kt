package behavioral.state

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StateTest {

    @Test
    fun `should perform state`() {
        // given
        val authorizationPresenter = AuthorizationPresenter()

        // when
        authorizationPresenter.loginUser("admin")

        // then
        assertThat(authorizationPresenter.isAuthorized).isEqualTo(true)
        assertThat(authorizationPresenter.userName).isEqualTo("admin")

        // and
        authorizationPresenter.logoutUser()

        // and
        assertThat(authorizationPresenter.isAuthorized).isEqualTo(false)
        assertThat(authorizationPresenter.userName).isEqualTo("Unknown")
    }
}
