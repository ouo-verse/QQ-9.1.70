package pv;

import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends TextureProgram {
    public c() {
        super("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (pos+vec4(0.5,0.5,0.0,0.0)).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform float fWidth;uniform float fHeight;uniform float uRadius;uniform vec4 uColor;float sdfBoxWithRadius(in vec2 p, in vec2 b, float radius) {    vec2 d = abs(p) - b + vec2(radius);    return length(max(d, 0.0)) + min(max(d.x, d.y), 0.0) - radius;}void main() {vec2 b = vec2(fWidth, fHeight);vec2 p = vTextureCoord * b;float result = sdfBoxWithRadius(p - b / 2.0, b / 2.0, uRadius);if (result >= 0.0) {    discard;}gl_FragColor = uColor;}", new qv.b[]{new qv.a("aPosition"), new qv.c("uMatrix"), new qv.c("uAlpha"), new qv.c(CameraFilterEngine.TEXTURE_MATRIX_UNIFORM), new qv.c("fWidth"), new qv.c("fHeight"), new qv.c("uRadius"), new qv.c("uColor")}, false);
    }
}
