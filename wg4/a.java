package wg4;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.ui.widget.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lwg4/a;", "", "", "b", "Lcom/tencent/mobileqq/app/QBaseActivity;", "context", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445636a = new a();

    a() {
    }

    public final void a(@NotNull QBaseActivity context, @NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!msg2.a().timi_emo_msg.msg_data.has()) {
            f.d(true, "\u8868\u60c5\u6570\u636e\u7f3a\u5931\uff0c\u65e0\u6cd5\u6536\u85cf\u3002");
        }
        String url = msg2.a().timi_emo_msg.msg_data.get().url.get();
        yg4.a aVar = new yg4.a(context);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        aVar.b(url);
    }

    public final void b() {
    }
}
