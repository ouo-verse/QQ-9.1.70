package tr0;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.util.aa;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J&\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Ltr0/c;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "", "", "payloads", "", "N1", "payload", "", "T1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "J1", "Q1", "M1", "R1", "S1", "", "status", "U1", "O1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Landroid/widget/ImageView;", "K1", "Ltr0/d;", "L1", "D", "Z", "delayShowSending", "E", "I", "msgSendStatus", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "Ljava/lang/Runnable;", "runnable", "G", "Landroid/widget/ImageView;", "statusView", "Landroid/view/View;", "root", "<init>", "(Landroid/view/View;)V", "H", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends AbsGuildLiveComponent {
    private static final int I = ViewUtils.dip2px(16.0f);

    /* renamed from: D, reason: from kotlin metadata */
    private boolean delayShowSending;

    /* renamed from: E, reason: from kotlin metadata */
    private int msgSendStatus;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView statusView;

    public c(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.msgSendStatus = -1;
        this.runnable = new Runnable() { // from class: tr0.a
            @Override // java.lang.Runnable
            public final void run() {
                c.P1(c.this);
            }
        };
        ImageView imageView = new ImageView(root.getContext());
        int i3 = I;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
        imageView.setVisibility(8);
        this.statusView = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(c this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.msgSendStatus == 0) {
            this$0.sendIntent(new a.i((GuildMsgItem) msgItem));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J1(GuildMsgItem msgItem) {
        B1(msgItem);
        int i3 = msgItem.getMsgRecord().sendStatus;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    S1();
                    return;
                }
                return;
            }
            M1();
            return;
        }
        Q1();
    }

    private final void M1() {
        aa.c(this.runnable, 500L);
        this.delayShowSending = true;
    }

    private final boolean N1(List<Object> payloads) {
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Object obj2 = ((Map) obj).get(GuildMsgItemPayloadType.STATUS_PAYLOAD);
                if (obj2 != null) {
                    T1(obj2);
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void O1() {
        if (this.delayShowSending) {
            aa.a(this.runnable);
            this.delayShowSending = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R1();
    }

    private final void Q1() {
        ImageView imageView = this.statusView;
        imageView.setVisibility(0);
        imageView.setRotation(0.0f);
        imageView.setImageResource(R.drawable.f160226dl);
        imageView.setBackgroundDrawable(new ColorDrawable(0));
    }

    private final void R1() {
        boolean z16;
        GuildMsgItem currentMsgItem = getCurrentMsgItem();
        if (currentMsgItem != null) {
            z16 = qr0.d.o(currentMsgItem);
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        ImageView imageView = this.statusView;
        imageView.setVisibility(0);
        imageView.setRotation(0.0f);
        imageView.setImageResource(R.drawable.f160545jt);
        imageView.setBackgroundDrawable(new ColorDrawable(0));
    }

    private final void S1() {
        this.statusView.setVisibility(8);
    }

    private final void T1(Object payload) {
        if (payload instanceof b.GuildMsgItemStatusPayload) {
            b.GuildMsgItemStatusPayload guildMsgItemStatusPayload = (b.GuildMsgItemStatusPayload) payload;
            int sendStatus = guildMsgItemStatusPayload.getSendStatus();
            if (sendStatus != 0) {
                if (sendStatus != 1) {
                    if (sendStatus == 2) {
                        O1();
                        S1();
                    }
                } else {
                    O1();
                    R1();
                }
            } else {
                O1();
                Q1();
            }
            U1(guildMsgItemStatusPayload.getSendStatus());
        }
    }

    private final void U1(int status) {
        this.msgSendStatus = status;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: K1, reason: from getter and merged with bridge method [inline-methods] */
    public ImageView d1() {
        return this.statusView;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public d createVM() {
        return new d();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            if (N1(payloads)) {
                J1((GuildMsgItem) msgItem);
            }
            U1(((GuildMsgItem) msgItem).getMsgRecord().sendStatus);
            this.statusView.setOnClickListener(new View.OnClickListener() { // from class: tr0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.I1(c.this, msgItem, view);
                }
            });
            return;
        }
        this.statusView.setVisibility(8);
    }
}
