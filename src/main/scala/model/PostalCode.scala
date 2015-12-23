package model

/**
  * Created by ogur on 12/23/15.
  */
case class PostalCode(countryCode: Option[String] = None,
                 postalCode: String,
                  placeNme: Option[String] = None,
                  adminName1: Option[String] = None,
                  adminCode1: Option[String] = None,
                  adminName2: Option[String] = None,
                  adminCode2: Option[String] = None,
                  adminName3: Option[String] = None,
                  adminCode3: Option[String] = None,
                  latitude: Option[Double] = None,
                  longitude: Option[Double] = None,
                  accuracy: Option[Int] = None)

object PostalCode {
  val numberOfFields = 12
}