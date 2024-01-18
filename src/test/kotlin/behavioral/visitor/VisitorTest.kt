package behavioral.visitor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VisitorTest {

    @Test
    fun `should apply visitor`() {
        // given
        val projectAlpha = FixedPriceContract(costPerYear = 10000)
        val projectBeta = SupportContract(costPerMonth = 500)
        val projectGamma = TimeAndMaterialsContract(hours = 150, costPerHour = 10)
        val projectKappa = TimeAndMaterialsContract(hours = 50, costPerHour = 50)

        // and
        val projects = arrayOf(projectAlpha, projectBeta, projectGamma, projectKappa)

        // and
        val monthlyCostReportVisitor = MonthlyCostReportVisitor()

        // when
        val monthlyCost = projects.map { it.accept(monthlyCostReportVisitor) }
            .sum()

        // then
        assertThat(monthlyCost).isEqualTo(5333)

        // and
        val yearlyReportVisitor = YearlyReportVisitor()
        val yearlyCost = projects.map { it.accept(yearlyReportVisitor) }
            .sum()

        assertThat(yearlyCost).isEqualTo(20000)
    }
}
