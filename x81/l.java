package x81;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l {

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f447467e = {-1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: f, reason: collision with root package name */
    public static final short[] f447468f = {0, 1, 2, 2, 3, 0};

    /* renamed from: a, reason: collision with root package name */
    private FloatBuffer f447469a;

    /* renamed from: b, reason: collision with root package name */
    private ShortBuffer f447470b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f447471c;

    /* renamed from: d, reason: collision with root package name */
    public short[] f447472d;

    public l(float[] fArr, short[] sArr) {
        this.f447471c = fArr;
        this.f447472d = sArr;
        b();
    }

    private void b() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.f447471c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f447469a = asFloatBuffer;
        asFloatBuffer.put(this.f447471c).position(0);
        ShortBuffer asShortBuffer = ByteBuffer.allocateDirect(this.f447472d.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.f447470b = asShortBuffer;
        asShortBuffer.put(this.f447472d).position(0);
    }

    public void a() {
        GLES20.glDrawElements(4, 6, 5123, this.f447470b);
    }

    public void c(int i3, int i16) {
        GLES20.glEnableVertexAttribArray(i3);
        j.a("glEnableVertexAttribArray aPositionHandle");
        GLES20.glEnableVertexAttribArray(i16);
        j.a("glEnableVertexAttribArray aTextureCoordHandle");
        this.f447469a.position(0);
        GLES20.glVertexAttribPointer(i3, 3, 5126, false, 20, (Buffer) this.f447469a);
        this.f447469a.position(3);
        GLES20.glVertexAttribPointer(i16, 2, 5126, false, 20, (Buffer) this.f447469a);
    }

    public l() {
        this.f447471c = f447467e;
        this.f447472d = f447468f;
        b();
    }
}
