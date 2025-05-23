package xz4;

import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f449175a;

    /* renamed from: b, reason: collision with root package name */
    public final d05.b f449176b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f449177c = false;

    public a(XhsNote xhsNote) {
        String generateSessionId = XhsShareSdkTools.generateSessionId(xhsNote);
        this.f449175a = generateSessionId;
        this.f449176b = new d05.b(generateSessionId);
    }
}
