/*
 * Copyright 2014 Shape Security, Inc.
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

package com.shapesecurity.shift.scope;

import com.shapesecurity.shift.ast.*;

import org.jetbrains.annotations.NotNull;

public final class Reference {
    @NotNull
    public final VariableReference node;
    @NotNull
    public final Accessibility accessibility;

    private Reference(@NotNull VariableReference node, @NotNull Accessibility accessibility) {
        this.node = node;
        this.accessibility = accessibility;
    }

    public Reference(@NotNull BindingIdentifier node) {
        this.node = node;
        this.accessibility = Accessibility.Write;
    }

    public Reference(@NotNull IdentifierExpression node) {
        this.node = node;
        this.accessibility = Accessibility.Read;
    }

    public Reference(@NotNull AssignmentTargetIdentifier node, @NotNull Accessibility accessibility) {
        this.node = node;
        this.accessibility = accessibility;
    }

    @NotNull
    public final Reference withReadability() {
        return new Reference(this.node, this.accessibility.withReadability());
    }

    @NotNull
    public final Reference withWritability() {
        return new Reference(this.node, this.accessibility.withWritability());
    }
}
