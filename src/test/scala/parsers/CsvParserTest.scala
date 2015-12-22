package parsers

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/22/15.
  */
class CsvParserTest extends SpecificationWithJUnit {
  "Parse" should {
    "return the correct number of rows" in new Context {
      csvParser.parse must  have size 6
    }
  }
}

trait Context extends Scope {
  val csvParser = new CsvParser("")
}