package vm1;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wm1.QuoteChannelInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lvm1/f;", "Lvm1/d;", "Lwm1/e;", "quoteChannelInfo", "Lnm1/b;", "translateInfo", "", "c", "Lwm1/i;", "wordInfo", "Lorg/json/JSONObject;", "b", "a", "", "Ljava/lang/Integer;", "mPatternId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mPatternId;

    private final String c(QuoteChannelInfo quoteChannelInfo, nm1.b translateInfo) {
        zl1.a aVar;
        String h16;
        String str = "";
        String guildId = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildIdOf(quoteChannelInfo.getHashtagSpan().o());
        if (TextUtils.isEmpty(guildId)) {
            com.tencent.base.api.runtime.a<zl1.a> a16 = translateInfo.a();
            Intrinsics.checkNotNull(a16);
            zl1.a h17 = a16.h();
            if (h17 instanceof zl1.a) {
                aVar = h17;
            } else {
                aVar = null;
            }
            if (aVar != null && (h16 = aVar.h()) != null) {
                str = h16;
            }
            guildId = str;
        }
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return guildId;
    }

    @Override // vm1.d
    @Nullable
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        boolean z16;
        String o16;
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        QuoteChannelInfo quoteChannelInfo = (QuoteChannelInfo) wordInfo;
        String o17 = quoteChannelInfo.getHashtagSpan().o();
        if (o17 != null && o17.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            o16 = "0";
        } else {
            o16 = quoteChannelInfo.getHashtagSpan().o();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("channel_id", o16);
        jSONObject.put("name", quoteChannelInfo.getHashtagSpan().p());
        jSONObject.put("at_type", quoteChannelInfo.getHashtagSpan().g());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", 4);
        jSONObject2.put("id", String.valueOf(this.mPatternId));
        jSONObject2.put("guild_info", jSONObject);
        return jSONObject2;
    }

    @Override // vm1.d
    @Nullable
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        boolean z16;
        String o16;
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        if (translateInfo.a() == null) {
            return null;
        }
        QuoteChannelInfo quoteChannelInfo = (QuoteChannelInfo) wordInfo;
        this.mPatternId = Integer.valueOf(sm1.a.f433976a.a());
        String o17 = quoteChannelInfo.getHashtagSpan().o();
        boolean z17 = false;
        if (o17 != null && o17.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            o16 = "0";
        } else {
            o16 = quoteChannelInfo.getHashtagSpan().o();
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", quoteChannelInfo.getHashtagSpan().p());
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("guild_id", c(quoteChannelInfo, translateInfo));
        jSONObject3.put("channel_id", o16);
        jSONObject3.put("channel_type", quoteChannelInfo.getHashtagSpan().q());
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("sign", jSONObject3);
        if (quoteChannelInfo.getHashtagSpan().g() == 512) {
            z17 = true;
        }
        jSONObject2.put("is_square", z17);
        jSONObject.put("channelInfo", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("type", 5);
        jSONObject4.put("pattern_id", String.valueOf(this.mPatternId));
        jSONObject4.put("channel_content", jSONObject);
        return jSONObject4;
    }
}
