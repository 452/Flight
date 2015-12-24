package parsers

import model.PostalCode
import spray.json._

/**
  * Created by ogur on 12/24/15.
  */
abstract class PostalCodeConverter(postalCode: PostalCode) {
  def convert: Any
}

class PostalCodeToJsonConverter(postalCode: PostalCode) extends PostalCodeConverter(postalCode) {
  object PostalCodeJsonProtocol extends DefaultJsonProtocol {
    implicit val postalCodeFormat = jsonFormat12(PostalCode.apply)
  }

    override def convert = postalCode.toJson(PostalCodeJsonProtocol.postalCodeFormat)

}

