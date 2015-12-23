package parsers

import javax.annotation.Resources

import model.PostalCode
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/22/15.
  */
class CsvParserTest extends SpecificationWithJUnit {
  "Parse" should {
    "return a result with the correct number of rows" in new CsvParserTestContext {
      postalCodesParser.parse must have size 3
    }

    "return a result with the correct number of columns in each row" in new CsvParserTestContext {
      postalCodesParser.parse.forall(_.size == PostalCode.numberOfFields) must beTrue
    }

    "return the expected result" in new CsvParserTestContext {
      val expected = Seq(
          Seq("US","34050","FPO", "", "AA","Erie","029", "","",		"41.0375","-111.6789",""),
          Seq("US","34034","APO",	"", "AA","Dillon","033","","",		"33.0364","-82.2493", ""),
          Seq("US","99553","Akutan","Alaska","AK","Aleutians East","013","","","54.143","-165.7854", "")
      )
      postalCodesParser.parse must be equalTo expected
    }
  }

}

trait CsvParserTestContext extends Scope {
  val filePath = "src/test/resources/PostalCodes.txt"
  val postalCodesParser = new CsvParser(filePath, Some(PostalCode.numberOfFields))
}