package ys0;

import com.tencent.aio.data.AIOContact;
import com.tencent.guild.aio.chosen.msglist.GuildChosenMsgIntent;
import com.tencent.guild.aio.chosen.title.g;
import com.tencent.guild.aio.title.GuildAioTitleBackBtnUIState;
import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.guild.aio.title.c;
import com.tencent.guildmedia.aio.excellentdetail.GuildMediaAnnounceMsgIntent;
import com.tencent.guildmedia.aio.excellentdetail.title.AnnounceDetailMoreIconVisible;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lys0/d;", "Lpn0/a;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "p", "Lcom/tencent/aio/data/AIOContact;", "f", "Lcom/tencent/aio/data/AIOContact;", "contact", "<init>", "()V", h.F, "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends pn0.a<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AIOContact contact;

    private final void o() {
        updateUI(new GuildAioTitleBackBtnUIState(false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(GuildMediaAnnounceMsgIntent.ShowRemoveFirstAnnounceMenu.f112982d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildChosenMsgIntent.ChosenMsgSizeChange) {
            if (((GuildChosenMsgIntent.ChosenMsgSizeChange) intent).getSize() > 0 && vs0.a.f((com.tencent.aio.api.runtime.a) getMContext())) {
                z16 = true;
            } else {
                z16 = false;
            }
            updateUI(new AnnounceDetailMoreIconVisible(z16));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildChosenMsgIntent.ChosenMsgSizeChange.class).getQualifiedName());
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.title.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof g.a) {
            q();
        } else if (intent instanceof c.l) {
            o();
        }
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.contact = context.g().r().c();
    }
}
