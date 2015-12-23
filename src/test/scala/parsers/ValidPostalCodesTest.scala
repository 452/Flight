package parsers

import model.PostalCode
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/22/15.
  */
class ValidPostalCodesTest extends SpecificationWithJUnit {
  "Parse" should {
    "return that result" in new ValidPostalCodesTestContext  {
      validPostalCodesParser.parse must be equalTo Seq(Seq("99571"), Seq("99583"))
    }
  }
}

trait ValidPostalCodesTestContext extends Scope {
  val filePath = "src/test/resources/ValidPostalCodes.txt"
  val validPostalCodesParser = new CsvParser(filePath)
}