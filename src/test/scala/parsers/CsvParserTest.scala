package parsers

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/22/15.
  */
class CsvParserTest extends SpecificationWithJUnit {
  "Parse on PostalCodes.txt" should {
    "return a result with the correct number of rows" in new Context {
      postalCodesParser.parse must  have size 6
    }

  }
  "Parse on ValidPostalCodes.txt" should {
    "return a result containing the postal code 99571" in new Context {
      validPostalCodesParser.parse.flatten must contain("99571")
    }
  }
}

trait Context extends Scope {
  val resourcesDir = List("src", "test", "resources").mkString("/")
  val postalCodesParser = new CsvParser(s"$resourcesDir/PostalCodes.txt")
  val validPostalCodesParser = new CsvParser(s"$resourcesDir/ValidPostalCodes.txt")
}