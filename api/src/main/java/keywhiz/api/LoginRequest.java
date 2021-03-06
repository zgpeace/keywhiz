/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package keywhiz.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Objects;
import javax.validation.constraints.NotNull;

public class LoginRequest {
  @NotNull
  @JsonProperty
  public final String username;

  @NotNull
  @JsonProperty
  public final char[] password;

  public LoginRequest(@JsonProperty("username") String username,
      @JsonProperty("password") char[] password) {
    this.username = username;
    this.password = password;
  }

  @Override public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof LoginRequest) {
      LoginRequest that = (LoginRequest) o;
      if (Objects.equals(this.username, that.username) &&
          Arrays.equals(this.password, that.password)) {
        return true;
      }
    }
    return false;
  }
}
