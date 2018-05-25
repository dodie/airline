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
package com.github.rvesse.airline.parser.errors.handlers;

import com.github.rvesse.airline.parser.ParseResult;
import com.github.rvesse.airline.parser.ParseState;
import com.github.rvesse.airline.parser.errors.ParseException;

/**
 * An error handler which fails as soon as a parser error is encountered
 * 
 * @author rvesse
 *
 */
public class FailFast implements ParserErrorHandler {

    @Override
    public void handleError(ParseException e) {
        throw e;
    }

    @Override
    public <T> ParseResult<T> finished(ParseState<T> state) {
        // Can only reach here if no errors handled so there were no errors
        return new ParseResult<T>(state, null);
    }
}
