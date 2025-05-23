package qe1;

import android.app.Activity;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\rH&J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H&\u00a8\u0006\u001e"}, d2 = {"Lqe1/b;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "Landroid/app/Activity;", "getActivity", "", "l0", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "m0", "msgId", "", "n0", "isExpand", "", "o0", "k0", "s0", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "chatAnswerData", "p0", "Lqe1/c;", "notifier", "t0", "q0", "Lqe1/a;", "provider", "r0", "u0", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class b extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<com.tencent.mobileqq.guild.aisearch.models.a> {
    public b() {
        super(new d());
    }

    @NotNull
    /* renamed from: getActivity */
    public abstract Activity getHostActivity();

    public abstract void k0();

    @NotNull
    public abstract String l0();

    @Nullable
    public abstract AiChatSession m0();

    public abstract boolean n0(@NotNull String msgId);

    public abstract void o0(@NotNull String msgId, boolean isExpand);

    public abstract void p0(@NotNull ChatAnswerData chatAnswerData);

    public abstract void q0(@NotNull c notifier);

    public abstract void r0(@NotNull a provider);

    public abstract void s0();

    public abstract void t0(@NotNull c notifier);

    public abstract void u0(@NotNull a provider);
}
