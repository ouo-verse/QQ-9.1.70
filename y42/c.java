package y42;

import android.text.TextPaint;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 82\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b6\u00107J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Ly42/c;", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/d;", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "info", "", "roomId", "anchorId", "", "d", "", "nickColor", "b", "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "c", "Landroid/text/TextPaint;", "tp", "updateDrawState", "a", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "I", "nickNormalColor", "e", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "getLiveUserInfo", "()Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "setLiveUserInfo", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;)V", "liveUserInfo", "f", "J", "getRoomId", "()J", "setRoomId", "(J)V", h.F, "getAnchorId", "setAnchorId", "i", "Lz42/a;", "getDataSupport", "()Lz42/a;", "setDataSupport", "(Lz42/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lz42/c;", "getPlayFunc", "()Lz42/c;", "setPlayFunc", "(Lz42/c;)V", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends com.tencent.mobileqq.qqlive.widget.chat.span.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int nickNormalColor = c52.a.a(R.color.c5f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveUserInfo liveUserInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long anchorId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z42.a dataSupport;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z42.c playFunc;

    @Override // com.tencent.mobileqq.qqlive.widget.chat.span.d
    public void a() {
        z42.c cVar = this.playFunc;
        if (cVar != null) {
            cVar.t(this.liveUserInfo, this.anchorId);
        }
    }

    public final void b(int nickColor) {
        this.nickNormalColor = nickColor;
    }

    public final void c(@Nullable z42.a dataSupport, @Nullable z42.c playFunc) {
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
    }

    public final void d(@NotNull LiveUserInfo info, long roomId, long anchorId) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.liveUserInfo = info;
        this.roomId = roomId;
        this.anchorId = anchorId;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.span.d, android.text.style.ClickableSpan
    public void onClick(@NotNull View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        z42.c cVar = this.playFunc;
        if (cVar != null) {
            cVar.c(this.liveUserInfo, this.anchorId);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.span.d, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint tp5) {
        Intrinsics.checkNotNullParameter(tp5, "tp");
        tp5.setColor(this.nickNormalColor);
        tp5.setUnderlineText(false);
    }
}
