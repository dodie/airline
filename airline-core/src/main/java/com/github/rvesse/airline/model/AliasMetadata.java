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
package com.github.rvesse.airline.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.rvesse.airline.utils.AirlineUtils;

/**
 * Metadata about command aliases
 * 
 * @author rvesse
 *
 */
public class AliasMetadata {

    private final String name;
    private final List<String> arguments;

    /**
     * Creates a new alias metadata
     * 
     * @param name
     *            Alias name
     * @param arguments
     *            Arguments the alias expands to
     */
    public AliasMetadata(String name, List<String> arguments) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Alias name cannot be null/empty/whitespace");
        this.name = name;
        this.arguments = AirlineUtils.unmodifiableListCopy(arguments);
    }

    /**
     * Gets the alias name
     * 
     * @return Alias name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the arguments that the alias expands to
     * 
     * @return Arguments
     */
    public List<String> getArguments() {
        return this.arguments;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AliasMetadata { name = '").append(this.name).append("', ");
        builder.append("arguments = [");
        for (int i = 0; i < this.arguments.size(); i++) {
            if (i > 0)
                builder.append(", ");
            builder.append("'").append(this.arguments.get(i)).append("'");
        }
        builder.append("] }");
        return builder.toString();
    }
}
