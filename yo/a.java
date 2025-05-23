package yo;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtReporter;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends g {

    /* renamed from: j, reason: collision with root package name */
    public String f450698j;

    public a(String str, String str2) {
        super(str, str2);
    }

    @Override // yo.g
    public int m(Context context) {
        int m3 = super.m(context);
        if (QZLog.isColorLevel()) {
            QZLog.i("GdtMiniSchemeInfo", 1, "GdtMiniApp Click report url = " + this.f450698j);
        }
        if (!TextUtils.isEmpty(this.f450698j)) {
            GdtReporter.doCgiReport(this.f450698j);
        }
        return m3;
    }
}
