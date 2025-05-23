package x62;

import com.tencent.biz.qrcode.util.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.utils.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\b\u0012\u0004\u0012\u00020\u0007`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lx62/a;", "", "", "success", "", "c", "a", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "uinType", "getShareArticleId", "setShareArticleId", "shareArticleId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getArticleStriked", "()Ljava/util/ArrayList;", "setArticleStriked", "(Ljava/util/ArrayList;)V", "articleStriked", "e", "shareNum", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f447299a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String uinType = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String shareArticleId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static ArrayList<String> articleStriked = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String shareNum = "";

    a() {
    }

    public final boolean a() {
        boolean contains;
        String valueOf = String.valueOf(b.d());
        if (!articleStriked.contains(valueOf)) {
            articleStriked.clear();
            articleStriked.add(valueOf);
        }
        contains = CollectionsKt___CollectionsKt.contains(articleStriked, shareArticleId);
        if (!contains) {
            return false;
        }
        h.T(1, R.string.hit);
        QLog.d("ShareReport", 1, "sharing is stroked!");
        return true;
    }

    public final String b() {
        return uinType;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        uinType = str;
    }

    public final void c(boolean success) {
    }
}
