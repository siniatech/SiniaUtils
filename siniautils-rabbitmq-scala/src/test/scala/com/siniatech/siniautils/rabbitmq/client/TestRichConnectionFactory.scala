/**
 * *****************************************************************************
 * SiniaUtils
 * Copyright (c) 2011-2 Siniatech Ltd
 * http://www.siniatech.com/siniautils
 *
 * All rights reserved. This project and the accompanying materials are made
 * available under the terms of the MIT License which can be found in the root
 * of the project, and at http://www.opensource.org/licenses/mit-license.php
 *
 * ****************************************************************************
 */
package com.siniatech.siniautils.rabbitmq.client

import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit

import com.rabbitmq.client.ConnectionFactory
import com.siniatech.siniautils.rabbitmq.client.RichConnectionFactory._

class TestRichConnectionFactory extends JUnitSuite with ShouldMatchersForJUnit {

  private val Bill = "bill"
  private val Pwd = "pwd"
  private val Host = "192.168.0.1"

  @Test
  def testCanSetUsername {
    val f = new ConnectionFactory().withUsername(Bill)
    f.getUsername should equal(Bill)
  }

  @Test
  def testCanSetPassword {
    val f = new ConnectionFactory().withPassword(Pwd)
    f.getPassword should equal(Pwd)
  }

  @Test
  def testCanSetHost {
    val f = new ConnectionFactory().withHost(Host)
    f.getHost should equal(Host)
  }

  @Test
  def testCanChain {
    val f = new ConnectionFactory().withUsername(Bill).withPassword(Pwd).withHost(Host)
    f.getUsername should equal(Bill)
    f.getPassword should equal(Pwd)
    f.getHost should equal(Host)
  }

}