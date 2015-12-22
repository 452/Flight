package parsers

import com.github.tototoshi.csv.{CSVReader, TSVFormat}

import scala.reflect.io.File

/**
  * Created by ogur on 12/22/15.
  */
class CsvParser(csvFile: String) {
  implicit object TSVfrmt extends TSVFormat

  def parse: Seq[Seq[String]] = CSVReader.open(csvFile).all()
}
