package parsers

import javax.annotation.Resources

import test.FlightsInfo
import test.Flight
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import scala.collection.JavaConversions._


class FlightsCsvParserTest extends SpecificationWithJUnit {
  "Parse" should {

    "return the expected result" in new FlightsCsvParserTestContext {
//      val expected = List[Flight]
//      (
//        new Flight(2014,1,1,1,3,"2014-01-01","JFK","LAX"),
//        new Flight(2014,1,1,2,4,"2014-01-02","JFK","LAX"),
//        new Flight(2014,1,1,3,5,"2014-01-03","JFK","LAX")
//      )
//      flightsInfoParser.flightsList must be equalTo expected
    }
  }

}

trait FlightsCsvParserTestContext extends Scope {
  val filePath = "src/test/resources/FlightsCodes.txt"
  val flightsInfoParser = new FlightsInfo()
}