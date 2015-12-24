package parsers

import java.text.ParseException

import model.PostalCode

import scala.util.{Failure, Success, Try}

/**
  * Created by ogur on 12/23/15.
  */
abstract class PostalCodeParser(filePath: String) {
  def parse: Seq[PostalCode]
}


class PostalCodeParserCSV(csvFilePath: String) extends PostalCodeParser(csvFilePath)  {
  override def parse: Seq[PostalCode] = {
    Try {
      val fileLines: Seq[Seq[String]] = new CsvParser(csvFilePath, Some(PostalCode.numberOfFields)).parse

      // Convert empty strings to None
      (fileLines map (line => line.map(elem => if (elem.isEmpty) None else Some(elem)))).map(s => s match{
        case Seq(countryCode, Some(postalCode),
        placeName, adminName1, adminCode1, adminName2,
        adminCode2, adminName3, adminCode3, latitude,
        longitude, accuracy) =>

          PostalCode(countryCode, postalCode,
              placeName, adminName1, adminCode1, adminName2,
              adminCode2, adminName3, adminCode3,
              latitude match { case Some(lat) => Some(lat.toDouble); case _ => None },
              longitude match {  case Some(lon) => Some(lon.toDouble); case _ => None},
              accuracy match { case Some(acc) => Some(acc.toInt); case _ => None })

        case x => /* Must be a missing postal code */ throw new Exception(s"Postal code not found (second column). Line description: ${x.toString} ")
      })
    } match {
      case Success(value) => value
      case Failure(ex) => throw new ParseException(s"${ex.getMessage}", 0)
    }
  }
}

object Main extends App {
  val parsed = new PostalCodeParserCSV("src/test/resources/InvalidFormatPostalCodes.txt").parse
  println(parsed)
}
