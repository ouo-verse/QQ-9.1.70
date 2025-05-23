package rk1;

import com.google.gson.Gson;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.guild.feed.publish.event.GuildEditTextLinkEvent;
import com.tencent.mobileqq.guild.feed.publish.result.EditTextLinkResult;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0014\u00a8\u0006\u0015"}, d2 = {"Lrk1/f;", "Lrk1/a;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "p", "k", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "editLink";
    }

    @Override // ok1.a
    protected boolean o(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.yf(g(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK), g("desc"));
        return true;
    }

    @Override // rk1.a
    @NotNull
    protected ArrayList<Class<Object>> p() {
        ArrayList<Class<Object>> arrayList = new ArrayList<>();
        arrayList.add(GuildEditTextLinkEvent.class);
        return arrayList;
    }

    @Override // rk1.a
    protected void q(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildEditTextLinkEvent) {
            GuildEditTextLinkEvent guildEditTextLinkEvent = (GuildEditTextLinkEvent) event;
            i(new Gson().toJson(new EditTextLinkResult(guildEditTextLinkEvent.getUrl(), guildEditTextLinkEvent.getDesc())));
        }
    }
}
