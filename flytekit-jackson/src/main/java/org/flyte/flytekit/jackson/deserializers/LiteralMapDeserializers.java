/*
 * Copyright 2020-2023 Flyte Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.flyte.flytekit.jackson.deserializers;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers;
import java.util.Map;
import org.flyte.api.v1.LiteralType;
import org.flyte.flytekit.jackson.JacksonLiteralMap;

public class LiteralMapDeserializers extends Deserializers.Base {

  @Override
  public JsonDeserializer<?> findBeanDeserializer(
      JavaType type, DeserializationConfig config, BeanDescription beanDesc) {
    if (type.getRawClass().equals(JacksonLiteralMap.class)) {
      Map<String, LiteralType> literalTypeMap = type.getValueHandler();

      return new LiteralMapDeserializer(literalTypeMap);
    }

    return null;
  }
}
