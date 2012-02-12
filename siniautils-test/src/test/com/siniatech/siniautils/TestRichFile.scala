package com.siniatech.siniautils
import org.scalatest.junit.ShouldMatchersForJUnit
import org.scalatest.junit.JUnitSuite
import org.junit.Test
import java.io.File
import com.siniatech.siniautils.RichFile._

class TestRichFile extends JUnitSuite with ShouldMatchersForJUnit {

  @Test
  def cantCreateDodgyGraph {
    val file = new File("src/test/resources/testfile")
    println(file.sha1)
    
  }
}