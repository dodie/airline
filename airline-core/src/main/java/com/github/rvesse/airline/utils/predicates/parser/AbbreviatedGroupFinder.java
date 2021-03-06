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
package com.github.rvesse.airline.utils.predicates.parser;

import java.util.Collection;

import com.github.rvesse.airline.model.CommandGroupMetadata;
import com.github.rvesse.airline.utils.predicates.AbstractAbbreviationFinder;

public final class AbbreviatedGroupFinder extends AbstractAbbreviationFinder<CommandGroupMetadata> {

    public AbbreviatedGroupFinder(String cmd, Collection<CommandGroupMetadata> groups) {
        super(cmd, groups);
    }

    @Override
    protected boolean isExactNameMatch(String value, CommandGroupMetadata item) {
        return item.getName().equals(value);
    }

    @Override
    protected boolean isPartialNameMatch(String value, CommandGroupMetadata item) {
        return item.getName().startsWith(value);
    }
}
