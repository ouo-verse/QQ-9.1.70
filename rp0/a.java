package rp0;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.guild.widget.speakthreshold.GuildSpeakThresholdTipLayout;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import fo0.e;
import fo0.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import np0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B\u001d\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lrp0/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState$GuildUpdateSpeakThresholdChange;", "limitState", "", "e1", "", ViewStickEventHelper.IS_SHOW, "", "from", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "speakThresholdInfo", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "state", "d1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lnp0/a$b;", "d", "Lnp0/a$b;", "getMuteUIStyle", "()Lnp0/a$b;", "muteUIStyle", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mMuteThresholdContainer", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout;", "f", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout;", "mMuteThresholdContent", "Lfo0/f;", "businessPermissionCallback", "<init>", "(Lnp0/a$b;Lfo0/f;)V", h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.base.mvvm.a<e, GuildAioDefaultInputUIState> {

    /* renamed from: i, reason: collision with root package name */
    private static final int f431832i = ViewUtils.dip2px(58.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b muteUIStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mMuteThresholdContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildSpeakThresholdTipLayout mMuteThresholdContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"rp0/a$b", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$c;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements GuildSpeakThresholdTipLayout.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildAioDefaultInputUIState.GuildUpdateSpeakThresholdChange f431836a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f431837b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IGuildSpeakableThresholdPermission f431838c;

        b(GuildAioDefaultInputUIState.GuildUpdateSpeakThresholdChange guildUpdateSpeakThresholdChange, a aVar, IGuildSpeakableThresholdPermission iGuildSpeakableThresholdPermission) {
            this.f431836a = guildUpdateSpeakThresholdChange;
            this.f431837b = aVar;
            this.f431838c = iGuildSpeakableThresholdPermission;
        }

        @Override // com.tencent.mobileqq.guild.widget.speakthreshold.GuildSpeakThresholdTipLayout.c
        public void a() {
            ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).notifyListeners(this.f431836a.getGuildId());
            this.f431837b.f1(false, "onCountDownTimerEnd", this.f431838c);
        }
    }

    public /* synthetic */ a(a.b bVar, f fVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new a.b(0, 0, 0, 7, null) : bVar, (i3 & 2) != 0 ? null : fVar);
    }

    private final void e1(GuildAioDefaultInputUIState.GuildUpdateSpeakThresholdChange limitState) {
        if (limitState.getIsSelectMode()) {
            f1(false, "isMultiSelectMode", limitState.getLimit());
            return;
        }
        boolean D = GuildSpeakLimitStatus.INSTANCE.D(limitState.getPermissions());
        f1(D, "onPermissionChange", limitState.getLimit());
        if (!D) {
            return;
        }
        IGuildSpeakableThresholdPermission limit = limitState.getLimit();
        int guildLimitType = limit.getGuildLimitType();
        GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout = null;
        if (guildLimitType != 2) {
            if (guildLimitType != 4) {
                f1(false, "limitType: " + limit, limit);
                return;
            }
            GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout2 = this.mMuteThresholdContent;
            if (guildSpeakThresholdTipLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContent");
            } else {
                guildSpeakThresholdTipLayout = guildSpeakThresholdTipLayout2;
            }
            guildSpeakThresholdTipLayout.o(new GuildSpeakThresholdTipLayout.JoinTimeTipParam(limit, 0, new b(limitState, this, limit), 0, 10, null));
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
    public final void f1(boolean isShow, String from, IGuildSpeakableThresholdPermission speakThresholdInfo) {
        int i3;
        QLog.i("GuildAioInput.SpeakThresholdView", 1, "updateSpeakThreshold isShow:" + isShow + " from:" + from + " speakThresholdInfo:" + speakThresholdInfo);
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
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<e, GuildAioDefaultInputUIState> createVM() {
        return new rp0.b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuildUpdateSpeakThresholdChange) {
            e1((GuildAioDefaultInputUIState.GuildUpdateSpeakThresholdChange) state);
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
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, f431832i));
        f1(false, "onCreateView", null);
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
            logger.d().d("GuildAioInput.SpeakThresholdView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout = this.mMuteThresholdContent;
        if (guildSpeakThresholdTipLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdContent");
            guildSpeakThresholdTipLayout = null;
        }
        guildSpeakThresholdTipLayout.l();
        super.onDestroy();
    }

    public a(@NotNull a.b muteUIStyle, @Nullable f fVar) {
        Intrinsics.checkNotNullParameter(muteUIStyle, "muteUIStyle");
        this.muteUIStyle = muteUIStyle;
    }
}
