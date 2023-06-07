package app.k9mail.feature.account.setup.domain.entity

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class ConnectionSecurityTest {

    @Test
    fun `should provide right default smtp port`() {
        val connectionSecurities = ConnectionSecurity.all()

        for (security in connectionSecurities) {
            val port = security.toSmtpDefaultPort()

            assertThat(port).isEqualTo(
                when (security) {
                    ConnectionSecurity.None -> 587L
                    ConnectionSecurity.StartTLS -> 587L
                    ConnectionSecurity.TLS -> 465L
                },
            )
        }
    }

    @Test
    fun `should provide right default imap port`() {
        val connectionSecurities = ConnectionSecurity.all()

        for (security in connectionSecurities) {
            val port = security.toImapDefaultPort()

            assertThat(port).isEqualTo(
                when (security) {
                    ConnectionSecurity.None -> 143L
                    ConnectionSecurity.StartTLS -> 143L
                    ConnectionSecurity.TLS -> 993L
                },
            )
        }
    }

    @Test
    fun `should provide right default pop3 port`() {
        val connectionSecurities = ConnectionSecurity.all()

        for (security in connectionSecurities) {
            val port = security.toPop3DefaultPort()

            assertThat(port).isEqualTo(
                when (security) {
                    ConnectionSecurity.None -> 110L
                    ConnectionSecurity.StartTLS -> 110L
                    ConnectionSecurity.TLS -> 995L
                },
            )
        }
    }
}
