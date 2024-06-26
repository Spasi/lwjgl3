/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.system.ffm;

import java.lang.annotation.*;

/**
 * Defines a native function signature.
 *
 * <p>There is no functionality that depends on this annotation. It's purpose is purely informational.</p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FFMSignature {
    /** The function signature as specified in the native language. */
    String value();
}