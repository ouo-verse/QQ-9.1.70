package yl1;

import android.os.Bundle;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\t\u001a\u00020\b*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\n"}, d2 = {"Landroid/os/Bundle;", "", "b", "(Landroid/os/Bundle;)Ljava/lang/Integer;", "", "", "", "bundle", "", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    public static final void a(@NotNull Map<String, Object> map, @Nullable Bundle bundle) {
        Integer b16;
        int i3;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (bundle != null && (b16 = b(bundle)) != null) {
            b16.intValue();
            if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(b16.intValue())) {
                i3 = 2;
            } else if (b16.intValue() == 1) {
                i3 = 1;
            } else {
                i3 = 1;
            }
            map.put("sgrp_forum_short_or_article", i3);
        }
    }

    @Nullable
    public static final Integer b(@Nullable Bundle bundle) {
        Integer d16 = d(bundle);
        if (d16 == null) {
            Integer e16 = e(bundle);
            if (e16 == null) {
                return c(bundle);
            }
            return e16;
        }
        return d16;
    }

    private static final Integer c(Bundle bundle) {
        String string;
        List split$default;
        if (bundle == null || (string = bundle.getString("funclist")) == null) {
            return 1;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{"_"}, false, 0, 6, (Object) null);
        if (!split$default.contains("5")) {
            return 1;
        }
        return 2;
    }

    private static final Integer d(Bundle bundle) {
        Serializable serializable;
        IGProContentRecommendFeed iGProContentRecommendFeed;
        if (bundle != null) {
            serializable = bundle.getSerializable("recommend_feed_detail_data");
        } else {
            serializable = null;
        }
        if (serializable instanceof IGProContentRecommendFeed) {
            iGProContentRecommendFeed = (IGProContentRecommendFeed) serializable;
        } else {
            iGProContentRecommendFeed = null;
        }
        if (iGProContentRecommendFeed == null) {
            return null;
        }
        return Integer.valueOf(iGProContentRecommendFeed.getFeedType());
    }

    private static final Integer e(Bundle bundle) {
        byte[] bArr;
        GProStFeed a16;
        if (bundle != null) {
            bArr = bundle.getByteArray("st_feed_detail_data");
        } else {
            bArr = null;
        }
        if (bArr == null || (a16 = com.tencent.mobileqq.guild.feed.util.m.a(bArr)) == null) {
            return null;
        }
        return Integer.valueOf(a16.feedType);
    }
}
