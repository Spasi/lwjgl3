/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.system.ffm;

import java.lang.annotation.*;

/**
 * Specifies the charset used for string values.
 *
 * <p>The default charset is {@link Type#ISO_8859_1}. When this annotation is applied to a class, it changes the default charset for that class. The charset
 * can further be customized per function, by applying this annotation to specific return values and parameters.</p>
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FFMCharset {

    /** The default charset type. */
    public static final Type DEFAULT = Type.ISO_8859_1;

    /**
     * The charset type.
     *
     * <p>If not specified, defaults to {@link Type#ISO_8859_1} (a.k.a. <em>Latin-1</em>).</p>
     */
    Type value() default Type.ISO_8859_1; // TODO: switch to UTF_8?

    public enum Type {
        US_ASCII(1, "US_ASCII"),
        ISO_8859_1(1, "ISO_8859_1"),
        UTF8(1, "UTF_8"),
        UTF16(2, "UTF_16LE"),
        UTF32(4, "UTF_32LE");

        public final int    byteSize;
        public final String charset;

        private Type(int byteSize, String charset) {
            this.byteSize = byteSize;
            this.charset = charset;
        }
    }
}
