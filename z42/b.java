package z42;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.light.LightConstants;
import w42.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0010H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H&J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0012\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0019H&\u00a8\u0006\u001e"}, d2 = {"Lz42/b;", "", "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "", "setSupportFunc", "notifyDataSetChanged", "Lw42/f;", "msg", "f", "", "roomId", "e", "anchorUid", "", "roomType", "b", "onExitRoom", "d", com.tencent.luggage.wxa.c8.c.G, "g", NodeProps.VISIBLE, "setVisibility", "", "show", "a", LightConstants.DowngradeStrategyKey.SMOOTH, "c", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                bVar.c(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToBottom");
        }
    }

    void a(boolean show);

    void b(long roomId, long anchorUid, int roomType);

    void c(boolean smooth);

    void d(@NotNull Object msg2);

    void e(long roomId);

    void f(@NotNull f msg2);

    void g(int pos);

    void notifyDataSetChanged();

    void onExitRoom(long roomId);

    void setSupportFunc(@NotNull z42.a dataSupport, @NotNull c playFunc);

    void setVisibility(int visible);
}
