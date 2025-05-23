package vi2;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0001H&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0012H&J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0001H&J(\u0010 \u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001aH&J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010#\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u001aH&J\b\u0010$\u001a\u00020\u0006H&\u00a8\u0006%"}, d2 = {"Lvi2/b;", "", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "", "setSupportFunc", "Landroidx/recyclerview/widget/RecyclerView;", HippyTKDListViewAdapter.X, "notifyDataSetChanged", h.F, "", "roomId", "", "platform", "i", "anchorUid", "", "roomType", "b", "onExitRoom", "msg", "d", NodeProps.VISIBLE, "setVisibility", "", "show", "a", "g", "ownerId", "isSingleLineModel", "e", "f", LightConstants.DowngradeStrategyKey.SMOOTH, "c", "a0", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
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

    void a0();

    void b(long roomId, long anchorUid, int roomType);

    void c(boolean smooth);

    void d(@NotNull Object msg2);

    void e(long roomId, long ownerId, int roomType, boolean isSingleLineModel);

    void f(long roomId);

    void g(@NotNull Object msg2);

    void h();

    void i(long roomId, @Nullable String platform);

    void notifyDataSetChanged();

    void onExitRoom(long roomId);

    void setSupportFunc(@NotNull vi2.a dataSupport, @NotNull c playFunc);

    void setVisibility(int visible);

    @NotNull
    RecyclerView x();
}
