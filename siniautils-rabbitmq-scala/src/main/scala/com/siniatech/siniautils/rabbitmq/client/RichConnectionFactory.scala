/**
 * *****************************************************************************
 * SiniaUtils
 * Copyright (c) 2011-2 Siniatech Ltd
 * http://www.siniatech.com/products/siniautils
 *
 * All rights reserved. This project and the accompanying materials are made
 * available under the terms of the MIT License which can be found in the root
 * of the project, and at http://www.opensource.org/licenses/mit-license.php
 *
 * ****************************************************************************
 */
package com.siniatech.siniautils.rabbitmq.client

import com.rabbitmq.client.ConnectionFactory

class RichConnectionFactory(f: ConnectionFactory) {
  def withUsername(u: String) = { f.setUsername(u); f }
  def withPassword(p: String) = { f.setPassword(p); f }
  def withHost(h: String) = { f.setHost(h); f }
}

object RichConnectionFactory {
  implicit def toRichConnectionFactory(f: ConnectionFactory) = new RichConnectionFactory(f)
}