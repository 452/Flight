package service

import model.PostalCode
import parsers.PostalCodeParserCSV

import scala.io.Source

/**
  * Created by ogur on 12/22/15.
  */
abstract class PostalCodeService(postalCodeMetaDataFilePath: String, validPostalCodesFilePath: String) {

  /* Outputs the intersection of postalCodeMetaData and validPostalCodes */
  def validPostalCodes: Seq[PostalCode]

}

class PostalCodeServiceCSV(postalCodeMetaDataFilePath: String, validPostalCodesFilePath: String)
  extends PostalCodeService(postalCodeMetaDataFilePath, validPostalCodesFilePath) {

  override def validPostalCodes: Seq[PostalCode] = {
    val postalCodesMetaDate: Seq[PostalCode] =  new PostalCodeParserCSV(postalCodeMetaDataFilePath).parse

    // Create a map of (postalCode code -> PostalCode Object)
    val postalCodeToObject = (Map.empty[String, PostalCode] /: postalCodesMetaDate) {
                                (soFar, pc) => soFar updated (pc.postalCode, pc)
                              }

    // Read the valid postal codes codes one by one
    val validPostalCodes = Source.fromFile(validPostalCodesFilePath).getLines()


    // Filter the valid codes and collect to a list of PostalCode objects
    (validPostalCodes collect {case pc if postalCodeToObject.contains(pc) => postalCodeToObject(pc)}).
    toList

  }
}