package com.siniatech.siniasync
import java.io.File
import java.io.FileInputStream
import java.security.MessageDigest

import scala.Array.canBuildFrom

// TODO - revisit and determine whether there are scala-specific improvements possible
object RichFile {
  implicit def toRichFile(f: File) = new RichFile(f)
}
class RichFile(f: File) {
  def sha1 = {
    val md = MessageDigest.getInstance("SHA1")
    val fis = fileInputStream
    var dataBytes: Array[Byte] = new Array[Byte](1024)
    var nread = 0

    while ({
      nread = fis.read(dataBytes)
      nread != -1
    }) {
      md.update(dataBytes, 0, nread)
    }

    val mdbytes = md.digest()

    mdbytes.map(b => {
      Integer.toString((b & 0xff) + 0x100, 16).substring(1)
    }).mkString
  }

  def fileInputStream = new FileInputStream(f)
}