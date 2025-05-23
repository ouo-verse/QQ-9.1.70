package ug;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lug/b;", "", "", "feedKey", "", "c", "", "a", "Lcom/qzone/proxy/feedcomponent/model/CustomPraiseData;", "b", "", "Ljava/util/Set;", "likedFeedSet", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f438918a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> likedFeedSet = new LinkedHashSet();

    b() {
    }

    public final CustomPraiseData b() {
        com.tencent.mobileqq.service.qzone.bean.b b16 = com.tencent.mobileqq.service.qzone.a.f286399a.b();
        if (b16 == null) {
            return null;
        }
        CustomPraiseData customPraiseData = new CustomPraiseData();
        customPraiseData.cmShowActionId = b16.d();
        customPraiseData.subType = 4;
        customPraiseData.frameRate = 30;
        customPraiseData.itemId = BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD;
        return customPraiseData;
    }

    public final boolean c(String feedKey) {
        boolean contains;
        if (TextUtils.isEmpty(feedKey)) {
            return false;
        }
        contains = CollectionsKt___CollectionsKt.contains(likedFeedSet, feedKey);
        return contains;
    }

    public final void a(String feedKey) {
        if (feedKey != null) {
            likedFeedSet.add(feedKey);
        }
    }
}
