package parsers

import com.github.tototoshi.csv.{CSVReader, TSVFormat}

/**
  * Created by ogur on 12/22/15.
  */
class CsvParser(csvFile: String, numberOfColumns: Option[Int] = None) {
  implicit object format extends TSVFormat

  def parse: Seq[Seq[String]] = numberOfColumns match {
    case None => CSVReader.open(csvFile).all
    case Some(n) => CSVReader.open(csvFile).all map (line => line ++ Seq.fill(n - line.length)(""))
  }

}
