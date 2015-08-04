/**
 * Copyright (C) 2010-15 the original author or authors.
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
package com.github.rvesse.airline.restrictions.common;

import com.github.rvesse.airline.model.ArgumentsMetadata;
import com.github.rvesse.airline.model.OptionMetadata;
import com.github.rvesse.airline.parser.ParseState;
import com.github.rvesse.airline.parser.errors.ParseRestrictionViolatedException;
import com.github.rvesse.airline.utils.AirlineUtils;

public class LengthRestriction extends AbstractStringRestriction {

    private final boolean maximum;
    private final int length;

    public LengthRestriction(int length, boolean maximum) {
        this.length = length;
        this.maximum = maximum;
    }

    @Override
    protected boolean isValid(String value) {
        if (maximum) {
            return value.length() <= this.length;
        } else {
            return value.length() > this.length;
        }
    }

    @Override
    protected <T> ParseRestrictionViolatedException violated(ParseState<T> state, OptionMetadata option, String value) {
        if (maximum) {
            return new ParseRestrictionViolatedException(
                    "Option '%s' was given value '%s' that has length %d which exceeds the maximum permitted length of %d",
                    option.getTitle(), value, value.length(), this.length);
        } else {
            return new ParseRestrictionViolatedException(
                    "Option '%s' was given value '%s' that has length %d which is below the minimum required length of %d",
                    option.getTitle(), value, value.length(), this.length);
        }
    }

    @Override
    protected <T> ParseRestrictionViolatedException violated(ParseState<T> state, ArgumentsMetadata arguments, String value) {
        if (maximum) {
            return new ParseRestrictionViolatedException(
                    "Argument '%s' was given value '%s' that has length %d which exceeds the maximum permitted length of %d",
                    AirlineUtils.first(arguments.getTitle()), value, value.length(), this.length);

        } else {
            return new ParseRestrictionViolatedException(
                    "Argument '%s' was given value '%s' that has length %d which is below the minimum required length of %d",
                    AirlineUtils.first(arguments.getTitle()), value, value.length(), this.length);
        }
    }

}