package ww3;

import com.tencent.qqnt.msg.data.g;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lww3/a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "a", "Lww3/a$a;", "callback", "c", "onDismiss", "onShow", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lww3/a$a;", "", "", "path", "", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "", "b", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ww3.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC11515a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: ww3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes24.dex */
        public static final class C11516a {
            public static /* synthetic */ void a(InterfaceC11515a interfaceC11515a, String str, int i3, String str2, g gVar, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 4) != 0) {
                        str2 = null;
                    }
                    if ((i16 & 8) != 0) {
                        gVar = null;
                    }
                    interfaceC11515a.b(str, i3, str2, gVar);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPicEmotion");
            }
        }

        void b(@NotNull String path, int subType, @Nullable String textSummary, @Nullable g picExtBizInfo);
    }

    void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.aio.data.msglist.a msgItem);

    void c(@NotNull InterfaceC11515a callback);

    void onDismiss();

    void onShow();
}
