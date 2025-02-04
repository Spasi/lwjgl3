/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package egl.templates

import egl.*
import org.lwjgl.generator.*

val EGL11 = "EGL11".nativeClassEGL("EGL11", postfix = "") {
    extends = EGL10
    IntConstant(
        "BACK_BUFFER"..0x3084,
        "BIND_TO_TEXTURE_RGB"..0x3039,
        "BIND_TO_TEXTURE_RGBA"..0x303A,
        "CONTEXT_LOST"..0x300E,
        "MIN_SWAP_INTERVAL"..0x303B,
        "MAX_SWAP_INTERVAL"..0x303C,
        "MIPMAP_TEXTURE"..0x3082,
        "MIPMAP_LEVEL"..0x3083,
        "NO_TEXTURE"..0x305C,
        "TEXTURE_2D"..0x305F,
        "TEXTURE_FORMAT"..0x3080,
        "TEXTURE_RGB"..0x305D,
        "TEXTURE_RGBA"..0x305E,
        "TEXTURE_TARGET"..0x3081
    )

    EGLBoolean(
        "BindTexImage",

        EGLDisplay("dpy"),
        EGLSurface("surface"),
        EGLint("buffer")
    )

    EGLBoolean(
        "ReleaseTexImage",

        EGLDisplay("dpy"),
        EGLSurface("surface"),
        EGLint("buffer")
    )

    EGLBoolean(
        "SurfaceAttrib",

        EGLDisplay("dpy"),
        EGLSurface("surface"),
        EGLint("attribute"),
        EGLint("value")
    )

    EGLBoolean(
        "SwapInterval",

        EGLDisplay("dpy"),
        EGLint("interval")
    )
}