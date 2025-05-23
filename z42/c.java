package z42;

import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh2.f;
import tl.h;
import w42.FollowPushScreenMessage;
import w42.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0007H&J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H&J,\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH&J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001aH&J\u0012\u0010!\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\b\u0010#\u001a\u00020\"H&JC\u0010*\u001a\u00020)2\u0006\u0010\u0013\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070%H&J\u001a\u0010-\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u001e\u001a\u00020\u001aH&J\u001a\u0010.\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u001e\u001a\u00020\u001aH&J\b\u0010/\u001a\u00020\rH&J\b\u00100\u001a\u00020\u0007H&J\u0018\u00103\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u0002012\u0006\u0010\u0005\u001a\u000202H&J\b\u00104\u001a\u00020\rH&J\b\u00105\u001a\u00020\u0007H&\u00a8\u00066"}, d2 = {"Lz42/c;", "", "", h.F, "Landroid/view/View;", "view", "announce", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "Landroid/view/MotionEvent;", "event", "i", "", "listScrolling", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatBaseText;", "Lw42/f;", "msg", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "id", "Lqh2/f;", "callback", "e", "", "roomId", "nick", "speakId", "anchorId", "f", "j", "o", "Ly42/b;", "v", "Lw42/c;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "function", "Landroid/text/style/ClickableSpan;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "liveUserInfo", "c", "t", "p", "g", "Lw42/m;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamHintMsgItemView;", "y", "r", "l", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface c {
    @NotNull
    ClickableSpan A(@NotNull FollowPushScreenMessage msg2, long anchorId, long roomId, @NotNull Function1<? super FollowPushScreenMessage, Unit> function);

    void c(@Nullable LiveUserInfo liveUserInfo, long anchorId);

    void e(int id5, @NotNull f callback);

    @Nullable
    String f(long roomId, @Nullable String nick, long speakId, long anchorId);

    void g();

    @NotNull
    String h();

    void i(@NotNull MotionEvent event);

    boolean j(long anchorId);

    void k(boolean listScrolling);

    void l();

    void m();

    @NotNull
    String o(@Nullable String announce);

    boolean p();

    void q(@NotNull View view, @NotNull String announce);

    boolean r();

    void t(@Nullable LiveUserInfo liveUserInfo, long anchorId);

    @NotNull
    y42.b v();

    void w();

    void y(@NotNull m msg2, @NotNull ChatTeamHintMsgItemView view);

    void z(@NotNull ChatBaseText view, @NotNull w42.f msg2);
}
