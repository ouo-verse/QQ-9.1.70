package wj1;

import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import ij1.g;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0003\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "", "c", "", "b", "Lij1/g;", "d", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    public static final boolean a(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (gVar.p() != null) {
            GuildTaskProgressState taskProgressState = gVar.p();
            Intrinsics.checkNotNullExpressionValue(taskProgressState, "taskProgressState");
            if (kn1.c.a(taskProgressState)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@Nullable String str) {
        boolean z16;
        if (str != null) {
            try {
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "isNativePublisher. Json parse error: " + e16;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedSquareMiscExt", 1, (String) it.next(), null);
                }
            }
            if (new JSONObject(new JSONObject(str).optString("jsonFeed")).optInt(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE) == 1) {
                z16 = true;
                Logger.f235387a.d().i("GuildFeedSquareMiscExt", 1, "isNativePublisher  isNative = " + z16);
                return z16;
            }
        }
        z16 = false;
        Logger.f235387a.d().i("GuildFeedSquareMiscExt", 1, "isNativePublisher  isNative = " + z16);
        return z16;
    }

    public static final boolean c(@NotNull i<?> iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar.c() != 1) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (gVar.p() != null) {
            GuildTaskProgressState taskProgressState = gVar.p();
            Intrinsics.checkNotNullExpressionValue(taskProgressState, "taskProgressState");
            if (kn1.c.b(taskProgressState)) {
                return true;
            }
        }
        return false;
    }
}
