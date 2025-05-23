package xj;

import com.qzone.reborn.intimate.event.QZoneIntimateNewBadgeEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lxj/a;", "", "", "spaceId", "", "d", "", "a", "c", "pushInfo", "b", "", "Ljava/util/Set;", "getMSpaceIdSet", "()Ljava/util/Set;", "setMSpaceIdSet", "(Ljava/util/Set;)V", "mSpaceIdSet", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f448035a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Set<String> mSpaceIdSet = new LinkedHashSet();

    a() {
    }

    public final void a(String spaceId) {
        if (spaceId != null) {
            mSpaceIdSet.add(spaceId);
        }
    }

    public final void b(String pushInfo) {
        if (pushInfo == null || pushInfo.length() == 0) {
            RFWLog.i("QZoneIntimateBadgePushManager", RFWLog.USR, "handlePush fail, pushInfo is null or empty");
            return;
        }
        Object obj = new JSONObject(pushInfo).get("space_id");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        a(str);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateNewBadgeEvent(str));
        RFWLog.i("QZoneIntimateBadgePushManager", RFWLog.USR, "handlePush success, space_id is " + str);
    }

    public final void c(String spaceId) {
        if (spaceId != null) {
            mSpaceIdSet.remove(spaceId);
        }
    }

    public final boolean d(String spaceId) {
        if (spaceId == null || spaceId.length() == 0) {
            return false;
        }
        return mSpaceIdSet.contains(spaceId);
    }
}
