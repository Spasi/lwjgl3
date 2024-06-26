/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.demo.glfw;

import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import org.lwjgl.system.ffm.*;

import java.lang.foreign.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.util.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL20C.*;
import static org.lwjgl.system.ffm.StackArena.*;

public class CustomBindings {

    //@FFMCritical
    @FFMPrefix("glfw")
    @FFMCharset(FFMCharset.Type.UTF8)
    public interface MyGLFWBindings {
        @FFMBooleanInt(binary = true)
        @FFMSignature("int glfwInit()")
        boolean Init();

        @FFMSignature("void glfwDefaultWindowHints()")
        void DefaultWindowHints();

        @FFMSignature("void glfwWindowHint(int hint, int value)")
        void WindowHint(int hint, int value);

        @FFMSignature("GLFWwindow * glfwCreateWindow(int width, int height, char const *title, GLFWmonitor *monitor, GLFWwindow *share)")
        MemorySegment CreateWindow(int width, int height, String title, @FFMNullable MemorySegment monitor, @FFMNullable MemorySegment share);

        @FFMSignature("void glfwDestroyWindow(GLFWwindow *window)")
        void DestroyWindow(MemorySegment window);

        @FFMSignature("void glfwSetWindowSizeLimits(GLFWwindow *window, int minwidth, int minheight, int maxwidth, int maxheight)")
        void SetWindowSizeLimits(MemorySegment window, int minwidth, int minheight, int maxwidth, int maxheight);

        @FFMSignature("GLFWmonitor** glfwGetMonitors(int *count)")
        MemorySegment GetMonitors(MemorySegment count);

        @FFMSignature("GLFWmonitor * glfwGetPrimaryMonitor()")
        MemorySegment GetPrimaryMonitor();

        @FFMSignature("void glfwGetMonitorPos(GLFWmonitor *monitor, int *xpos, int *ypos)")
        void GetMonitorPos(MemorySegment monitor, MemorySegment xpos, MemorySegment ypos);

        @FFMSignature("char const * glfwGetMonitorName(GLFWmonitor *monitor)")
        String GetMonitorName(MemorySegment monitor);

        @FFMSignature("GLFWvidmode const * glfwGetVideoMode(GLFWmonitor *monitor)")
        MemorySegment GetVideoMode(MemorySegment monitor);

        @FFMSignature("void glfwSetWindowPos(GLFWwindow *window, int xpos, int ypos)")
        void SetWindowPos(MemorySegment window, int xpos, int ypos);

        @FFMSignature("void glfwMakeContextCurrent(GLFWwindow *window)")
        void MakeContextCurrent(MemorySegment window);

        @FFMSignature("void glfwSwapInterval(int interval)")
        void SwapInterval(int interval);

        @FFMSignature("void glfwShowWindow(GLFWwindow *window)")
        void ShowWindow(MemorySegment window);

        @FFMBooleanInt(binary = true)
        @FFMSignature("int glfwWindowShouldClose(GLFWwindow *window)")
        boolean WindowShouldClose(MemorySegment window);

        @FFMSignature("void glfwPollEvents()")
        void PollEvents();

        @FFMSignature("void glfwSwapBuffers(GLFWwindow *window)")
        @FFMFunctionAddress
        void SwapBuffers(MemorySegment address, MemorySegment window); // tests @FFMFunctionAddress

        @FFMSignature("void glfwTerminate(void)")
        void Terminate();
    }

    @FFMPrefix("gl")
    @FFMCharset(FFMCharset.Type.UTF8)
    @FFMFunctionAddress
    public interface MyOpenGLBindings {
        @FFMSignature("void glClear(GLfloat red, GLfloat green, GLfloat blue, GLfloat alpha)")
        void ClearColor(MemorySegment address, float red, float green, float blue, float alpha);

        @FFMSignature("void glClear(GLbitfield mask)")
        void Clear(MemorySegment address, int mask);

        @FFMName("glGetIntegerv") @FFMReturn(1)
        @FFMSignature("void glGetIntegerv(GLenum name, GLint *params)")
        int GetInteger(MemorySegment address, StackAllocator stack, int name);

        @FFMSignature("GLubyte const * glGetIntegerv(GLenum name)")
        String GetString(MemorySegment address, int name);

        @FFMSignature("GLuint glCreateShader(GLenum type)")
        int CreateShader(MemorySegment address, int type);

        @FFMSignature("void glCompileShader(GLuint shader)")
        void CompileShader(MemorySegment address, int shader);

        @FFMSignature("void glShaderSource(GLuint shader, GLsizei count, GLchar const * const *string, GLint const *length)")
        void ShaderSource(MemorySegment address, int shader, int count, MemorySegment string, MemorySegment length);

        @FFMReturn(3) @FFMReturn.Output(2)
        @FFMSignature("void glGetShaderInfoLog(GLuint shader, GLsizei bufSize, GLsizei *length, GLchar *infoLog)")
        String GetShaderInfoLog(MemorySegment address, StackAllocator allocator, int shader, int bufSize);

        @FFMName("glGetShaderiv") @FFMReturn(2)
        @FFMSignature("void glGetShaderiv(GLuint shader, GLenum pname, GLint *params)")
        int GetShaderi(MemorySegment address, int shader, int pname);

        @FFMReturn(3) @FFMReturn.Output(2)
        @FFMSignature("void glGetShaderSource(GLuint shader, GLsizei bufSize, GLsizei *length, GLchar *source)")
        String GetShaderSource(MemorySegment address, StackAllocator allocator, int shader, @FFMReturn.Size int bufSize);

        @FFMSignature("void glDeleteShader(GLuint shader)")
        void DeleteShader(MemorySegment address, int shader);
    }

    static {
        //Configuration.DISABLE_CHECKS.set(true);
        Configuration.DEBUG_GENERATOR.set(true);
    }

    private static final SymbolLookup LOADER = SymbolLookup.libraryLookup(Objects.requireNonNull(org.lwjgl.glfw.GLFW.getLibrary().getPath()), Arena.global());

    private static final MyGLFWBindings   glfw = BindingGenerator.generate(MethodHandles.lookup(), MyGLFWBindings.class, LOADER);
    private static final MyOpenGLBindings gl   = BindingGenerator.generate(MethodHandles.lookup(), MyOpenGLBindings.class);

    public static void main(String[] ignored) {
        System.err.println("BEFORE Init");
        if (!glfw.Init()) {
            throw new IllegalStateException("Unable to initialize glfw");
        }

        glfw.DefaultWindowHints();
        glfw.WindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfw.WindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfw.WindowHint(GLFW_SCALE_TO_MONITOR, GLFW_TRUE);
        glfw.WindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GLFW_TRUE);
        if (Platform.get() == Platform.MACOSX) {
            glfw.WindowHint(GLFW_COCOA_RETINA_FRAMEBUFFER, GLFW_FALSE);
        }

        System.err.println("BEFORE Monitors");

        try (var stack = stackPush()) {
            var count_p     = stack.allocateFrom(ValueLayout.JAVA_INT, 1);
            var xpos_p      = stack.allocateFrom(ValueLayout.JAVA_INT, 1);
            var ypos_p      = stack.allocateFrom(ValueLayout.JAVA_INT, 1);
            var monitors_pp = glfw.GetMonitors(count_p);
            if (!MemorySegment.NULL.equals(monitors_pp)) {
                var count    = count_p.getAtIndex(ValueLayout.JAVA_INT, 0);
                var monitors = monitors_pp.reinterpret(ValueLayout.ADDRESS.scale(0, count));
                for (int i = 0; i < count; i++) {
                    var monitor = monitors.getAtIndex(ValueLayout.ADDRESS, i);
                    glfw.GetMonitorPos(monitor, xpos_p, ypos_p);

                    var name = glfw.GetMonitorName(monitor);
                    System.err.println("Monitor #" + i + " " + name + " at " + xpos_p.getAtIndex(ValueLayout.JAVA_INT, 0) + "," + ypos_p.getAtIndex(ValueLayout.JAVA_INT, 0));
                }
            }

        }

        System.err.println("BEFORE CreateWindow");

        int WIDTH  = 300;
        int HEIGHT = 300;

        var window = glfw.CreateWindow(WIDTH, HEIGHT, "GLFW Gears Demo", MemorySegment.NULL, MemorySegment.NULL);
        if (MemorySegment.NULL.equals(window)) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfw.SetWindowSizeLimits(window, WIDTH, HEIGHT, GLFW_DONT_CARE, GLFW_DONT_CARE);
        //glfw.SetWindowAspectRatio(window, 1, 1);

        var monitor = glfw.GetPrimaryMonitor();

        var vidmode = Objects.requireNonNull(glfw.GetVideoMode(monitor)).reinterpret(org.lwjgl.glfw.GLFWVidMode.SIZEOF);
        // Center window
        glfw.SetWindowPos(
            window,
            (vidmode.get(ValueLayout.JAVA_INT, 0) - WIDTH) / 2,
            (vidmode.get(ValueLayout.JAVA_INT, 4) - HEIGHT) / 2
        );

        glfw.MakeContextCurrent(window);

        var caps      = GL.createCapabilities();
        var debugProc = GLUtil.setupDebugMessageCallback();

        // Do some random OpenGL calls to test the bindings
        try (var stack = stackPush()) {
            System.err.println("GL_VERSION = " + gl.GetString(MemorySegment.ofAddress(caps.glGetString), GL_VERSION));
            System.err.println("GL_MAX_TEXTURE_SIZE = " + gl.GetInteger(MemorySegment.ofAddress(caps.glGetIntegerv), stack, GL_MAX_TEXTURE_SIZE));

            var vsh = gl.CreateShader(MemorySegment.ofAddress(caps.glCreateShader), GL_VERTEX_SHADER);

            var header = stack.allocateFrom("#version 120\n#line 0\n", StandardCharsets.ISO_8859_1);
            var code = stack.allocateFrom(
                "uniform mat4 u_MVP;\n" +
                "uniform mat3 u_NORMAL;\n" +
                "\n" +
                "uniform vec3 u_LIGHT;\n" +
                "\n" +
                "attribute vec3 in_Position;\n" +
                "attribute vec3 in_Normal;\n" +
                "\n" +
                "varying float v_Shade;\n" +
                "\n" +
                "void main() {\n" +
                "    vec3 normal = normalize(u_NORMAL * in_Normal);\n" +
                "    v_Shade = max(dot(normal, u_LIGHT), 0.0);\n" +
                "    gl_Position = u_MVP * vec4(in_Position, 1.0);\n" +
                "}\n",
                StandardCharsets.UTF_8
            );

            var strings = stack.allocate(ValueLayout.ADDRESS, 2L);
            strings.setAtIndex(ValueLayout.ADDRESS, 0L, header);
            strings.setAtIndex(ValueLayout.ADDRESS, 1L, code);

            var lengths = stack.allocate(ValueLayout.JAVA_INT, 2L);
            lengths.setAtIndex(ValueLayout.JAVA_INT, 0L, (int)header.byteSize() - 1);
            lengths.setAtIndex(ValueLayout.JAVA_INT, 1L, (int)code.byteSize() - 1);

            gl.ShaderSource(MemorySegment.ofAddress(caps.glShaderSource), vsh, 2, strings, lengths);

            gl.CompileShader(MemorySegment.ofAddress(caps.glCompileShader), vsh);

            var infoLogLength = gl.GetShaderi(MemorySegment.ofAddress(caps.glGetShaderiv), vsh, GL_INFO_LOG_LENGTH);
            if (infoLogLength != 0) {
                System.err.println("infoLog = " + gl.GetShaderInfoLog(MemorySegment.ofAddress(caps.glGetShaderInfoLog), stack, vsh, infoLogLength));
            }

            var sourceLength = gl.GetShaderi(MemorySegment.ofAddress(caps.glGetShaderiv), vsh, GL_SHADER_SOURCE_LENGTH);
            System.err.println("source = " + gl.GetShaderSource(MemorySegment.ofAddress(caps.glGetShaderSource), stack, vsh, sourceLength));

            if (gl.GetShaderi(MemorySegment.ofAddress(caps.glGetShaderiv), vsh, GL_COMPILE_STATUS) != GL_TRUE) {
                throw new IllegalStateException("Failed to compile shader.");
            }

            gl.DeleteShader(MemorySegment.ofAddress(caps.glDeleteShader), vsh);
        }

        gl.ClearColor(MemorySegment.ofAddress(caps.glClearColor), 1.0f, 0.0f, 0.0f, 0.0f);

        glfw.SwapInterval(1);
        glfw.ShowWindow(window);

        System.err.println("BEFORE render loop");

        var SwapBuffers = LOADER.find("glfwSwapBuffers").orElseThrow();
        while (!glfw.WindowShouldClose(window)) {
            glfw.PollEvents();

            gl.Clear(MemorySegment.ofAddress(caps.glClear), GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            glfw.SwapBuffers(SwapBuffers, window);
        }

        if (debugProc != null) {
            debugProc.free();
        }

        glfw.DestroyWindow(window);

        glfw.Terminate();
    }

}