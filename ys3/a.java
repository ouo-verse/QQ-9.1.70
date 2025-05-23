package ys3;

import android.text.TextUtils;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.base.mvvm.AIOViewModel;
import com.tencent.qqguild.directmessage.aio.input.GuildC2CPermissions;
import com.tencent.qqguild.directmessage.aio.input.GuildPermissionsChange;
import com.tencent.qqguild.directmessage.aio.input.UIState;
import com.tencent.qqguild.directmessage.aio.input.c;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001\u000f\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lys3/a;", "Lcom/tencent/qqguild/base/mvvm/AIOViewModel;", "Lcom/tencent/qqguild/directmessage/aio/input/c;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "from", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Ljava/lang/String;", "mGuildId", "ys3/a$b", "f", "Lys3/a$b;", "mSpeakThresholdUpdateListener", "<init>", "()V", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends AIOViewModel<c, UIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mSpeakThresholdUpdateListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"ys3/a$b", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements IGuildSpeakThresholdApi.a {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) a.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (!TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                return;
            }
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) a.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (channelIds.contains(com.tencent.guild.aio.util.a.b(g17))) {
                a.this.m("onSpeakThresholdUpdate withChannel");
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            if (guildIds.contains(a.this.mGuildId)) {
                a.this.m("onSpeakThresholdUpdate guildIds");
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (TextUtils.equals(a.this.mGuildId, guildId)) {
                a.this.m("onSpeakThresholdUpdate guildId");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void m(String from) {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        int a16 = com.tencent.qqguild.directmessage.aio.input.a.a(com.tencent.guild.aio.util.a.b(g16));
        GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(a16);
        QLog.i("Guild.C2C.AIO.GuildAioInput.c2cContainerVM", 1, "[senGuildPermissionChangeIntent] permissions = " + a16 + " from:" + from);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(guildPermissionsChange);
        if (GuildC2CPermissions.INSTANCE.b(a16)) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("Guild.C2C.AIO.GuildAioInput.c2cContainerVM", false, 2, null));
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).removeListener(this.mSpeakThresholdUpdateListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        String str;
        MessageSource source;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).addListener(this.mSpeakThresholdUpdateListener);
        m("onCreate");
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        DirectMessageNode C = DirectMessageNodeRepository.C(com.tencent.guild.aio.util.a.b(g16));
        if (C == null || (source = C.getSource()) == null || (str = source.getGuildId()) == null) {
            str = "";
        }
        this.mGuildId = str;
    }
}
