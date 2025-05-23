package rv;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class e extends com.tencent.av.opengl.texture.a {

    /* renamed from: w, reason: collision with root package name */
    private static int f432541w;

    /* renamed from: q, reason: collision with root package name */
    private boolean f432542q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f432543r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f432544s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f432545t;

    /* renamed from: u, reason: collision with root package name */
    protected Bitmap f432546u;

    /* renamed from: v, reason: collision with root package name */
    boolean f432547v;

    /* JADX INFO: Access modifiers changed from: protected */
    public e() {
        super(null, 0);
        this.f432542q = true;
        this.f432543r = false;
        this.f432544s = true;
        this.f432545t = false;
        this.f432547v = false;
    }

    private void C() {
        Bitmap bitmap = this.f432546u;
        if (bitmap != null) {
            E(bitmap);
            this.f432546u = null;
        }
    }

    private Bitmap D() {
        if (this.f432546u == null) {
            Bitmap F = F();
            this.f432546u = F;
            if (F != null) {
                int width = F.getWidth();
                int height = this.f432546u.getHeight();
                if (this.f74098g == -1) {
                    x(width, height);
                }
            }
        }
        return this.f432546u;
    }

    public static void G() {
        f432541w = 0;
    }

    public static boolean J() {
        if (f432541w > 100) {
            return true;
        }
        return false;
    }

    private void K(ov.a aVar) {
        Bitmap D = D();
        if (D != null) {
            try {
                int width = D.getWidth();
                int height = D.getHeight();
                int j3 = j();
                int h16 = h();
                if (this.f74092a == null) {
                    this.f74092a = new int[1];
                }
                this.f74092a[0] = aVar.i().b();
                aVar.n(this);
                if (width == j3 && height == h16) {
                    aVar.c(this, D);
                } else {
                    int internalFormat = GLUtils.getInternalFormat(D);
                    int type = GLUtils.getType(D);
                    aVar.o(this, internalFormat, type);
                    aVar.j(this, 0, 0, D, internalFormat, type);
                }
                C();
                u(aVar);
                this.f74095d = 1;
                this.f432542q = true;
                return;
            } catch (Throwable th5) {
                C();
                throw th5;
            }
        }
        this.f74095d = -1;
        throw new RuntimeException("Texture load fail, no bitmap");
    }

    protected abstract void E(Bitmap bitmap);

    protected abstract Bitmap F();

    public void H(boolean z16) {
        this.f432544s = z16;
    }

    public void I(ov.a aVar) {
        Bitmap D;
        if (!p()) {
            if (this.f432545t) {
                int i3 = f432541w + 1;
                f432541w = i3;
                if (i3 > 100) {
                    return;
                }
            }
            K(aVar);
            return;
        }
        if (!this.f432542q && (D = D()) != null) {
            try {
                if (!D.isRecycled()) {
                    aVar.j(this, 0, 0, D, GLUtils.getInternalFormat(D), GLUtils.getType(D));
                    C();
                    this.f432542q = true;
                }
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("UploadedTexture", 2, "WL_DEBUG updateContent e = " + e16);
                }
            }
        }
    }

    @Override // com.tencent.av.opengl.texture.a
    public int e() {
        if (this.f74098g == -1) {
            D();
        }
        return this.f74099h;
    }

    @Override // com.tencent.av.opengl.texture.a
    public int f() {
        if (this.f74098g == -1) {
            D();
        }
        return this.f74098g;
    }

    @Override // com.tencent.av.opengl.texture.a
    public int g() {
        return GLSLRender.GL_TEXTURE_2D;
    }

    @Override // com.tencent.av.opengl.texture.a
    public boolean q() {
        return this.f432544s;
    }

    @Override // com.tencent.av.opengl.texture.a
    public boolean r(ov.a aVar) {
        I(aVar);
        return true;
    }

    @Override // com.tencent.av.opengl.texture.a
    public qv.b[] s(ov.a aVar) {
        if (this.f432547v) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        }
        return super.s(aVar);
    }

    @Override // com.tencent.av.opengl.texture.a
    public void t() {
        super.t();
        if (this.f432546u != null) {
            C();
        }
    }
}
