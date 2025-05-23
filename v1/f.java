package v1;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private Mode f440738a;

    /* renamed from: b, reason: collision with root package name */
    private ErrorCorrectionLevel f440739b;

    /* renamed from: c, reason: collision with root package name */
    private Version f440740c;

    /* renamed from: d, reason: collision with root package name */
    private int f440741d = -1;

    /* renamed from: e, reason: collision with root package name */
    private b f440742e;

    public static boolean b(int i3) {
        if (i3 >= 0 && i3 < 8) {
            return true;
        }
        return false;
    }

    public b a() {
        return this.f440742e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f440739b = errorCorrectionLevel;
    }

    public void d(int i3) {
        this.f440741d = i3;
    }

    public void e(b bVar) {
        this.f440742e = bVar;
    }

    public void f(Mode mode) {
        this.f440738a = mode;
    }

    public void g(Version version) {
        this.f440740c = version;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append("<<\n");
        sb5.append(" mode: ");
        sb5.append(this.f440738a);
        sb5.append("\n ecLevel: ");
        sb5.append(this.f440739b);
        sb5.append("\n version: ");
        sb5.append(this.f440740c);
        sb5.append("\n maskPattern: ");
        sb5.append(this.f440741d);
        if (this.f440742e == null) {
            sb5.append("\n matrix: null\n");
        } else {
            sb5.append("\n matrix:\n");
            sb5.append(this.f440742e.toString());
        }
        sb5.append(">>\n");
        return sb5.toString();
    }
}
