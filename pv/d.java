package pv;

import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends TextureProgram {
    public d() {
        super("uniform mat4 uMatrix;uniform mat4  uTextureMatrix;attribute vec2 aPosition;varying vec2 vTextureCoord;void main() {vec4 pos = vec4(aPosition, 0.0, 1.0);gl_Position = uMatrix * pos;vTextureCoord = (uTextureMatrix * (pos+vec4(0.5,0.5,0.0,0.0))).xy;}", "precision mediump float;varying vec2 vTextureCoord;uniform float uAlpha;uniform sampler2D  uTextureSampler0;uniform float fWidth;uniform float fHeight;uniform float uRadius;uniform vec4 uColor;float sdfBoxWithRadius(in vec2 p, in vec2 b, float radius) {    vec2 d = abs(p) - b + vec2(radius);    return length(max(d, 0.0)) + min(max(d.x, d.y), 0.0) - radius;}void main() {vec2 p = vTextureCoord * vec2(fWidth, fHeight);vec2 b = vec2(fWidth, fHeight);float result = sdfBoxWithRadius(p - b / 2.0, b / 2.0, uRadius);if (result >= 0.0) {    discard;}vec4 textureColor = texture2D(uTextureSampler0, vTextureCoord);vec3 color = textureColor.xyz * (1.0 - uColor.w) + uColor.xyz * uColor.w;gl_FragColor = vec4(color, textureColor.w);gl_FragColor *= uAlpha;}", new qv.b[]{new qv.a("aPosition"), new qv.c("uMatrix"), new qv.c("uAlpha"), new qv.c(CameraFilterEngine.TEXTURE_MATRIX_UNIFORM), new qv.c("uTextureSampler0"), new qv.c("fWidth"), new qv.c("fHeight"), new qv.c("uRadius"), new qv.c("uColor")}, false);
    }
}
