package behavioral.chainofresponsibility

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChainOfResponsibilityTest {

    @Test
    fun `should apply chain of responsibility`() {
        // given
        val authenticationHeader = AuthenticationHeader("123456")
        val contentTypeHeader = ContentTypeHeader("json")
        val messageBody = BodyPayload("Body:\n{\n\"username\"=\"dbacinski\"\n}")

        // when
        authenticationHeader.next = contentTypeHeader
        contentTypeHeader.next = messageBody

        // and
        val messageWithAuthentication =
            authenticationHeader.addHeader("Headers with Authentication:\n")

        // and
        val messageWithoutAuth =
            contentTypeHeader.addHeader("Headers:\n")

        // then
        assertThat(messageWithAuthentication).isEqualTo(
            """
                Headers with Authentication:
                Authorization: Bearer 123456
                ContentType: json
                Body:
                {
                "username"="dbacinski"
                }
            """.trimIndent()
        )

        // then
        assertThat(messageWithoutAuth).isEqualTo(
            """
                Headers:
                ContentType: json
                Body:
                {
                "username"="dbacinski"
                }
            """.trimIndent()
        )
    }
}
