package xx0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.icgame.game.tim.api.message.MsgStatus;
import com.tencent.icgame.game.ui.widget.e;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TextMsg;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lxx0/f;", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0006\u0010\u0010\u001a\u00020\bR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lxx0/f$a;", "", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "a", "Lcom/tencent/icgame/game/tim/api/message/a;", "msg", "", "c", "e", "Landroid/content/Context;", "context", "b", "d", "f", "g", "", "REVOCATION_EXPIRED", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xx0.f$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"xx0/f$a$a", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "", "onSuccess", "", "code", "", "desc", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: xx0.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C11572a implements V2TIMCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.icgame.game.tim.api.message.a f448955a;

            C11572a(com.tencent.icgame.game.tim.api.message.a aVar) {
                this.f448955a = aVar;
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, @Nullable String desc) {
                com.tencent.icgame.game.utils.g.d("ICGameMessageUtils", "revocation error: " + code + ", " + desc);
                if (code == 10031 || code == 20016) {
                    f.INSTANCE.g();
                }
                if (!NetworkUtil.isNetworkAvailable()) {
                    com.tencent.icgame.game.ui.widget.f.b("\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5\u3002");
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                this.f448955a.k(MsgStatus.REVOKE);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MessageOuterClass$MsgContent a(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
            MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent.text_msg;
            MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
            messageOuterClass$TextMsg2.text.set(text);
            messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
            return messageOuterClass$MsgContent;
        }

        @JvmStatic
        public final void b(@NotNull Context context, @NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int type = msg2.type();
            if (type != 1) {
                if (type != 70) {
                    str = "";
                } else {
                    str = msg2.a().at_user_msg.text.get();
                }
            } else {
                str = msg2.a().text_msg.text.get();
            }
            if (!TextUtils.isEmpty(str)) {
                Object systemService = context.getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(context.getPackageName(), eu0.a.a(str)));
                com.tencent.icgame.game.ui.widget.f.b("\u5df2\u590d\u5236");
                return;
            }
            com.tencent.icgame.game.ui.widget.f.b("\u590d\u5236\u5931\u8d25");
        }

        @JvmStatic
        public final void c(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.i()) {
                ((sx0.b) qx0.a.b(sx0.b.class)).M(msg2.j()).b(msg2);
            } else {
                ((sx0.b) qx0.a.b(sx0.b.class)).C(msg2.f()).b(msg2);
            }
        }

        @JvmStatic
        public final void d(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @JvmStatic
        public final void e(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.i()) {
                ((sx0.b) qx0.a.b(sx0.b.class)).M(msg2.j()).a(msg2);
            } else {
                ((sx0.b) qx0.a.b(sx0.b.class)).C(msg2.f()).a(msg2);
            }
        }

        @JvmStatic
        public final void f(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!NetworkUtil.isNetworkAvailable()) {
                com.tencent.icgame.game.ui.widget.f.b("\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5\u3002");
            } else {
                V2TIMManager.getMessageManager().revokeMessage(((g) msg2).getV2TIMMessage(), new C11572a(msg2));
            }
        }

        public final void g() {
            String trimIndent;
            trimIndent = StringsKt__IndentKt.trimIndent("\n                \u53d1\u9001\u65f6\u95f4\u8d85\u8fc7" + ("2\u5206\u949f") + "}\u7684\u6d88\u606f\n                \u4e0d\u80fd\u88ab\u64a4\u56de\n                ");
            QBaseActivity b16 = bu0.a.b();
            Intrinsics.checkNotNullExpressionValue(b16, "getTopQActivity()");
            new e.a(b16).f(trimIndent).g(null).i("\u6211\u77e5\u9053\u4e86").c().show();
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final void a(@NotNull Context context, @NotNull com.tencent.icgame.game.tim.api.message.a aVar) {
        INSTANCE.b(context, aVar);
    }

    @JvmStatic
    public static final void b(@NotNull com.tencent.icgame.game.tim.api.message.a aVar) {
        INSTANCE.c(aVar);
    }

    @JvmStatic
    public static final void c(@NotNull com.tencent.icgame.game.tim.api.message.a aVar) {
        INSTANCE.d(aVar);
    }

    @JvmStatic
    public static final void d(@NotNull com.tencent.icgame.game.tim.api.message.a aVar) {
        INSTANCE.e(aVar);
    }

    @JvmStatic
    public static final void e(@NotNull com.tencent.icgame.game.tim.api.message.a aVar) {
        INSTANCE.f(aVar);
    }
}
