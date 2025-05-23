package yj4;

import android.text.TextPaint;
import android.view.MotionEvent;
import com.tencent.mobileqq.qqlive.widget.chat.span.b;
import com.tencent.timi.game.liveroom.impl.room.like.LikeTouchManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lyj4/a;", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/b;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "Landroid/view/MotionEvent;", "event", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends b {
    @Override // com.tencent.mobileqq.qqlive.widget.chat.span.b
    public void a(@Nullable MotionEvent event) {
        boolean z16 = false;
        if (event != null && event.getAction() == 1) {
            z16 = true;
        }
        if (z16) {
            LikeTouchManager.INSTANCE.triggerLikeIfMsgListIdle(event);
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@Nullable TextPaint tp5) {
    }
}
