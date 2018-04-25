/**
 * Copyright (C) 2010-16 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.rvesse.airline.examples.modules;

import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.restrictions.AllowedRawValues;

public class VerbosityModule {

    @Option(name = { "-v", "--verbosity" }, arity = 1, title = "Level", description = "Sets the desired verbosity")
    // The AllowedRawValues annotation allows an option to be restricted to a given set of values
    @AllowedRawValues(allowedValues = { "1", "2", "3" })
    public int verbosity = 1;
}
