package zs3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.speakthreshold.GuildSpeakThresholdTipLayout;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.directmessage.aio.input.GuildC2CPermissions;
import com.tencent.qqguild.directmessage.aio.input.UIState;
import com.tencent.qqguild.directmessage.aio.input.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import np0.a;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lzs3/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqguild/directmessage/aio/input/c;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$GuildUpdateSpeakThresholdChange;", "limitState", "", "e1", "", ViewStickEventHelper.IS_SHOW, "", "from", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "state", "d1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lnp0/a$b;", "d", "Lnp0/a$b;", "getMuteUIStyle", "()Lnp0/a$b;", "muteUIStyle", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mMuteThresholdContainer", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout;", "f", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout;", "mMuteThresholdContent", "<init>", "(Lnp0/a$b;)V", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends com.tencent.aio.base.mvvm.a<c, UIState> {

    /* renamed from: i, reason: collision with root package name */
    private static final int f453156i = ViewUtils.dip2px(58.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b muteUIStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mMuteThresholdContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildSpeakThresholdTipLayout mMuteThresholdContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"zs3/a$b", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$c;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements GuildSpeakThresholdTipLayout.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UIState.GuildUpdateSpeakThresholdChange f453160a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f453161b;

        b(UIState.GuildUpdateSpeakThresholdChange guildUpdateSpeakThresholdChange, a aVar) {
            this.f453160a = guildUpdateSpeakThresholdChange;
            this.f453161b = aVar;
        }

        @Override // com.tencent.mobileqq.guild.widget.speakthreshold.GuildSpeakThresholdTipLayout.c
        public void a() {
            ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).notifyListeners(this.f453160a.getGuildId());
            this.f453161b.f1(false, "onCountDownTimerEnd");
        }
    }

    public /* synthetic */ a(a.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new a.b(0, 0, 0, 7, null) : bVar);
    }

    private final void e1(UIState.GuildUpdateSpeakThresholdChange limitState) {
        if (limitState.getIsSelectMode()) {
            f1(false, "onPermissionChange isMultiSelectMode");
            return;
        }
        boolean b16 = GuildC2CPermissions.INSTANCE.b(limitState.getPermissions());
        f1(b16, "onPermissionChange");
        if (!b16) {
            return;
        }
        IGuildSpeakableThresholdPermission limit = limitState.getLimit();
        int directMsgLimitType = limit.getDirectMsgLimitType();
        GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout = null;
        if (directMsgLimitType != 2) {
            if (directMsgLimitType != 4) {
                return;
            }
            GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout2 = this.mMuteThresholdContent;
            if (guildSpeakThresholdTipLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContent");
                guildSpeakThresholdTipLayout2 = null;
            }
            guildSpeakThresholdTipLayout2.o(new GuildSpeakThresholdTipLayout.JoinTimeTipParam(limit, 0, new b(limitState, this), 0, 10, null));
            return;
        }
        GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout3 = this.mMuteThresholdContent;
        if (guildSpeakThresholdTipLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContent");
        } else {
            guildSpeakThresholdTipLayout = guildSpeakThresholdTipLayout3;
        }
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        String verifyUrl = limit.getVerifyUrl();
        Intrinsics.checkNotNullExpressionValue(verifyUrl, "speakThresholdState.verifyUrl");
        guildSpeakThresholdTipLayout.n(new GuildSpeakThresholdTipLayout.AuthTipParam(0, 0, 0, 0, 0, (Activity) mContext, verifyUrl, 31, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(boolean isShow, String from) {
        int i3;
        QLog.i("Guild.C2C.AIO.GuildAioInput.c2cSpeakThresholdView", 1, "updateSpeakThresholdVisible isShow = " + isShow + " from:" + from);
        LinearLayout linearLayout = this.mMuteThresholdContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContainer");
            linearLayout = null;
        }
        if (isShow) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<c, UIState> createVM() {
        return new zs3.b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull UIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof UIState.GuildUpdateSpeakThresholdChange) {
            e1((UIState.GuildUpdateSpeakThresholdChange) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View inflate = View.inflate(createViewParams.a(), R.layout.eel, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.mMuteThresholdContainer = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContainer");
            linearLayout = null;
        }
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, f453156i));
        f1(false, "onCreateView");
        LinearLayout linearLayout2 = this.mMuteThresholdContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContainer");
            linearLayout2 = null;
        }
        linearLayout2.setBackgroundResource(this.muteUIStyle.getMuteLayoutBgId());
        LinearLayout linearLayout3 = this.mMuteThresholdContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContainer");
            linearLayout3 = null;
        }
        View findViewById = linearLayout3.findViewById(R.id.x1a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mMuteThresholdContainer.\u2026eak_threshold_tip_layout)");
        GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout = (GuildSpeakThresholdTipLayout) findViewById;
        this.mMuteThresholdContent = guildSpeakThresholdTipLayout;
        if (guildSpeakThresholdTipLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContent");
            guildSpeakThresholdTipLayout = null;
        }
        guildSpeakThresholdTipLayout.setBackgroundResource(this.muteUIStyle.getMuteLayoutBgId());
        GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout2 = this.mMuteThresholdContent;
        if (guildSpeakThresholdTipLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContent");
            guildSpeakThresholdTipLayout2 = null;
        }
        guildSpeakThresholdTipLayout2.setC2C(true);
        LinearLayout linearLayout4 = this.mMuteThresholdContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContainer");
            return null;
        }
        return linearLayout4;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.C2C.AIO.GuildAioInput.c2cSpeakThresholdView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout = this.mMuteThresholdContent;
        if (guildSpeakThresholdTipLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContent");
            guildSpeakThresholdTipLayout = null;
        }
        guildSpeakThresholdTipLayout.l();
        super.onDestroy();
    }

    public a(@NotNull a.b muteUIStyle) {
        Intrinsics.checkNotNullParameter(muteUIStyle, "muteUIStyle");
        this.muteUIStyle = muteUIStyle;
    }
}
