package parsers

import model.PostalCode
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import spray.json.DefaultJsonProtocol._
import spray.json.{JsObject, pimpAny}

/**
  * Created by ogur on 12/24/15.
  */
class PostalCodeToJsonConverterTest extends SpecificationWithJUnit {

  "Convert" should {
    "return a json with the correct size" in new PostalCodeToJsonConverterTestContext {
      postalCodeToJsonConverter.convert.asJsObject.fields must be length 2
    }

    "return the expected result" in new PostalCodeToJsonConverterTestContext {
      val expected = JsObject(Map("countryCode" -> "US".toJson, "postalCode" -> "34050".toJson))
      postalCodeToJsonConverter.convert must be equalTo expected
    }
  }
}

trait PostalCodeToJsonConverterTestContext extends Scope {
  val postalCodeToJsonConverter = new PostalCodeToJsonConverter(
                                    PostalCode(Some("US"),"34050"))
}