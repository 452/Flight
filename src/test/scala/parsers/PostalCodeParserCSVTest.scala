package parsers

import java.text.ParseException

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/23/15.
  */
class PostalCodeParserCSVTest extends SpecificationWithJUnit {

  "Parse" should {
    "return a result with the correct length" in new PostalCodeParserCSVTestContext {
      postalCodeParserCSV.parse must be length 3
    }
    "throw an exception" in new PostalCodeParserCSVTestContext {
      val badFilePath = "src/test/resources/InvalidFormatPostalCodes.txt"
      override val postalCodeParserCSV = new PostalCodeParserCSV(badFilePath)
      postalCodeParserCSV.parse must throwA[ParseException]
    }
  }
}

trait PostalCodeParserCSVTestContext extends Scope {
  val filePath = "src/test/resources/PostalCodes.txt"
  val postalCodeParserCSV = new PostalCodeParserCSV(filePath)
}