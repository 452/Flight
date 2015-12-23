package parsers

import java.text.ParseException

import model.PostalCode

/**
  * Created by ogur on 12/23/15.
  */
abstract class PostalCodeParser(filePath: String) {
  def parse: Seq[PostalCode]
}


class PostalCodeParserCSV(csvFilePath: String) extends PostalCodeParser(csvFilePath)  {
  override def parse: Seq[PostalCode] = {
    try {
      val fileLines: Seq[Seq[String]] = new CsvParser(csvFilePath, Some(PostalCode.numberOfFields)).parse

      // Convert empty strings to None
      (fileLines map (line => line.map(elem => if (elem.isEmpty) None else Some(elem)))).map(s => s match{
        // Map to Option[PostalCodes]
        case Seq(countryCode, postalCode,
        placeName, adminName1, adminCode1, adminName2,
        adminCode2, adminName3, adminCode3, latitude,
        longitude, accuracy) =>

          PostalCode(countryCode, postalCode.get,
            placeName, adminName1, adminCode1, adminName2,
            adminCode2, adminName3, adminCode3,
            latitude match { case None => None; case Some(lat) => Some(lat.toDouble) },
            longitude match { case None => None; case Some(lon) => Some(lon.toDouble) },
            accuracy match { case None => None; case Some(acc) => Some(acc.toInt) })

        case x: Any => throw new Exception(s"Parsing exception. Message - ${x.toString} ")
      })
    } catch {
      case e: Exception => throw new ParseException(s"${e.getMessage}. Invalid CSV file format", 0)
    }
  }
}

object Main extends App {
  new PostalCodeParserCSV("src/test/resources/InvalidFormatPostalCodes.txt").parse
}