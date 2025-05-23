package rh1;

import android.util.Log;
import com.tencent.mobileqq.guild.discoveryv2.RecommendAdMessage;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R8\u0010\u0019\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00170\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lrh1/a;", "", "", "aId", "", "a", "f", "", "isContractAd", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/RecommendAdMessage;", "message", "e", "b", "", "Ljava/lang/String;", "schemaSource", "", "I", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "kotlin.jvm.PlatformType", "", "Ljava/util/List;", "mInvalidAdList", "<init>", "(Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String schemaSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int busiType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<Long> mInvalidAdList;

    public a(@NotNull String schemaSource, int i3) {
        Intrinsics.checkNotNullParameter(schemaSource, "schemaSource");
        this.schemaSource = schemaSource;
        this.busiType = i3;
        this.mInvalidAdList = Collections.synchronizedList(new ArrayList());
    }

    private final void a(long aId) {
        this.mInvalidAdList.add(Long.valueOf(aId));
    }

    public static /* synthetic */ ByteStringMicro d(a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return aVar.c(z16);
    }

    private final void f(long aId) {
        this.mInvalidAdList.remove(Long.valueOf(aId));
    }

    public final void b() {
        this.mInvalidAdList.clear();
    }

    @NotNull
    public final ByteStringMicro c(boolean isContractAd) {
        d dVar = d.f431454a;
        List<Long> mInvalidAdList = this.mInvalidAdList;
        Intrinsics.checkNotNullExpressionValue(mInvalidAdList, "mInvalidAdList");
        return dVar.f(mInvalidAdList, this.schemaSource, this.busiType, isContractAd);
    }

    public final void e(@NotNull RecommendAdMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.getAddAdId() != 0) {
            a(message.getAddAdId());
        } else if (message.getRemoveAdId() != 0) {
            f(message.getRemoveAdId());
        }
        Log.d("GuildDiscAdPageData", "recv RecommendAdMessage " + message);
    }
}
