/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengles;

import org.lwjgl.system.*;

public class EXTTessellationShader {

    static { GLES.initialize(); }

    public static final int GL_PATCHES_EXT = 0xE;

    public static final int GL_PATCH_VERTICES_EXT = 0x8E72;

    public static final int
        GL_TESS_CONTROL_OUTPUT_VERTICES_EXT = 0x8E75,
        GL_TESS_GEN_MODE_EXT                = 0x8E76,
        GL_TESS_GEN_SPACING_EXT             = 0x8E77,
        GL_TESS_GEN_VERTEX_ORDER_EXT        = 0x8E78,
        GL_TESS_GEN_POINT_MODE_EXT          = 0x8E79;

    public static final int
        GL_ISOLINES_EXT = 0x8E7A,
        GL_QUADS_EXT    = 0x7;

    public static final int
        GL_FRACTIONAL_ODD_EXT  = 0x8E7B,
        GL_FRACTIONAL_EVEN_EXT = 0x8E7C;

    public static final int
        GL_MAX_PATCH_VERTICES_EXT                              = 0x8E7D,
        GL_MAX_TESS_GEN_LEVEL_EXT                              = 0x8E7E,
        GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS_EXT             = 0x8E7F,
        GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS_EXT          = 0x8E80,
        GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS_EXT            = 0x8E81,
        GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS_EXT         = 0x8E82,
        GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS_EXT              = 0x8E83,
        GL_MAX_TESS_PATCH_COMPONENTS_EXT                       = 0x8E84,
        GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS_EXT        = 0x8E85,
        GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS_EXT           = 0x8E86,
        GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS_EXT                 = 0x8E89,
        GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS_EXT              = 0x8E8A,
        GL_MAX_TESS_CONTROL_INPUT_COMPONENTS_EXT               = 0x886C,
        GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS_EXT            = 0x886D,
        GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS_EXT    = 0x8E1E,
        GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS_EXT = 0x8E1F,
        GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS_EXT         = 0x92CD,
        GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS_EXT      = 0x92CE,
        GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS_EXT                = 0x92D3,
        GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS_EXT             = 0x92D4,
        GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS_EXT                 = 0x90CB,
        GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS_EXT              = 0x90CC,
        GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS_EXT          = 0x90D8,
        GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS_EXT       = 0x90D9,
        GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED             = 0x8221;

    public static final int
        GL_IS_PER_PATCH_EXT                         = 0x92E7,
        GL_REFERENCED_BY_TESS_CONTROL_SHADER_EXT    = 0x9307,
        GL_REFERENCED_BY_TESS_EVALUATION_SHADER_EXT = 0x9308;

    public static final int
        GL_TESS_EVALUATION_SHADER_EXT = 0x8E87,
        GL_TESS_CONTROL_SHADER_EXT    = 0x8E88;

    public static final int
        GL_TESS_CONTROL_SHADER_BIT_EXT    = 0x8,
        GL_TESS_EVALUATION_SHADER_BIT_EXT = 0x10;

    protected EXTTessellationShader() {
        throw new UnsupportedOperationException();
    }

    // --- [ glPatchParameteriEXT ] ---

    /** {@code void glPatchParameteriEXT(GLenum pname, GLint value)} */
    public static native void glPatchParameteriEXT(@NativeType("GLenum") int pname, @NativeType("GLint") int value);

}