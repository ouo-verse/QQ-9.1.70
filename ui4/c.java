package ui4;

import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass$KPLScheduleModifyNotifyMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lui4/c;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f439055b = "TimiAudienceWebPluginHelper_";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f439056c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lui4/c$a;", "", "", "c", "", "roomId", "a", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "msg", "b", "", "TAG", "Ljava/lang/String;", "", "isPreloaded", "Z", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ui4.c$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(long roomId) {
            pi4.b.f426282a.a("live_trigge_race_model_type", "FINISH_SUBSCRIBE");
        }

        public final void b(@NotNull MessageOuterClass$TimMsgBody msg2) {
            String str;
            MessageOuterClass$KPLScheduleModifyNotifyMsg messageOuterClass$KPLScheduleModifyNotifyMsg;
            PBStringField pBStringField;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            MessageOuterClass$MsgContent messageOuterClass$MsgContent = msg2.content;
            if (messageOuterClass$MsgContent == null || (messageOuterClass$KPLScheduleModifyNotifyMsg = messageOuterClass$MsgContent.kpl_schedule_modify_notify_msg) == null || (pBStringField = messageOuterClass$KPLScheduleModifyNotifyMsg.schedule) == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            pi4.b.f426282a.a("live_race_change_model_type", str);
        }

        public final void c() {
            c.f439056c = false;
        }

        Companion() {
        }
    }
}
