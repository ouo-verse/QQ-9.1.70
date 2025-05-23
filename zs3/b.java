package zs3;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.directmessage.aio.input.GuildPermissionsChange;
import com.tencent.qqguild.directmessage.aio.input.UIState;
import com.tencent.qqguild.directmessage.aio.input.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import sz1.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lzs3/b;", "Lpn0/a;", "Lcom/tencent/qqguild/directmessage/aio/input/c;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "p", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "f", "Ljava/lang/String;", "mGuildId", "", h.F, "Z", "mIsSelectMode", "", "i", "I", "mPermissions", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b extends pn0.a<c, UIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mPermissions;

    private final void o() {
        IGuildSpeakableThresholdPermission f16 = d.f(this.mGuildId);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.C2C.AIO.GuildAioInput.c2cSpeakThresholdVM", 2, "speakThresholdState:" + f16);
        }
        updateUI(new UIState.GuildUpdateSpeakThresholdChange(this.mPermissions, this.mIsSelectMode, f16, this.mGuildId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        this.mIsSelectMode = GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        this.mPermissions = com.tencent.qqguild.directmessage.aio.input.a.a(com.tencent.guild.aio.util.a.b(g16));
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildPermissionsChange) {
            this.mPermissions = ((GuildPermissionsChange) intent).getPermissions();
            o();
        } else if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            this.mIsSelectMode = ((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode();
            o();
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildPermissionsChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName()});
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        String str;
        MessageSource source;
        Intrinsics.checkNotNullParameter(context, "context");
        p();
        super.onCreate(context);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        DirectMessageNode C = DirectMessageNodeRepository.C(com.tencent.guild.aio.util.a.b(g16));
        if (C == null || (source = C.getSource()) == null || (str = source.getGuildId()) == null) {
            str = "";
        }
        this.mGuildId = str;
    }
}
