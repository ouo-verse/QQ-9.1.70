package sd3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZplanShareArkInfo;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import sd3.f;
import tl.h;
import zb3.ZootopiaShareArkInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J@\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u001a\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002JD\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0006J \u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0006J\u0016\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J:\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ`\u0010(\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001428\u0010'\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\r0\"\u00a8\u0006+"}, d2 = {"Lsd3/f;", "", "Landroid/content/Context;", "context", "Lzb3/o;", "arkInfo", "", "uinType", "", "uin", "hint", "", "needSendHint", "", "o", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/sqshow/zootopia/data/ac;", "requestCode", DomainData.DOMAIN_NAME, "Landroid/os/Bundle;", "f", "appName", QQCustomArkDialogUtil.APP_VIEW, QQCustomArkDialogUtil.APP_MIN_VERSION, QQCustomArkDialogUtil.META_DATA, "r", h.F, "i", "j", "k", "mapId", "sceneType", "bizParams", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", "callback", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f433689a = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"sd3/f$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/o;", "result", "", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<ZootopiaShareArkInfo> {
        final /* synthetic */ boolean C;
        final /* synthetic */ IGProChannelInfo D;
        final /* synthetic */ int E;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f433690d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f433691e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f433692f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f433693h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Activity f433694i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f433695m;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Integer, ? super String, Unit> function2, int i3, Bundle bundle, QQAppInterface qQAppInterface, Activity activity, String str, boolean z16, IGProChannelInfo iGProChannelInfo, int i16) {
            this.f433690d = function2;
            this.f433691e = i3;
            this.f433692f = bundle;
            this.f433693h = qQAppInterface;
            this.f433694i = activity;
            this.f433695m = str;
            this.C = z16;
            this.D = iGProChannelInfo;
            this.E = i16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ZootopiaShareArkInfo result, QQAppInterface appInterface, Activity activity, String channelId, boolean z16, IGProChannelInfo channelInfo, Bundle bizParams, int i3) {
            String string;
            boolean isBlank;
            Intrinsics.checkNotNullParameter(result, "$result");
            Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(channelId, "$channelId");
            Intrinsics.checkNotNullParameter(channelInfo, "$channelInfo");
            Intrinsics.checkNotNullParameter(bizParams, "$bizParams");
            Bundle f16 = f.f433689a.f(result);
            f16.putString("uin", channelId);
            if (z16) {
                string = channelInfo.getGuildId();
            } else {
                string = bizParams.getString("g_guildId");
            }
            f16.putString("guild_id", string);
            f16.putInt("uintype", 10014);
            f16.putString("uinname", channelInfo.getChannelName());
            boolean z17 = false;
            f16.putBoolean("is_need_show_toast", false);
            f16.putBoolean("is_ark_display_share", true);
            f16.putBoolean(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN, true);
            f16.putString(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID, String.valueOf(i3));
            f16.putInt("zplan_share_type", 1);
            String string2 = bizParams.getString("g_subText");
            if (string2 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(string2);
                if (!isBlank) {
                    z17 = true;
                }
            }
            if (z17) {
                f16.putString("key_zplan_troop_ark_share", string2);
                f16.putBoolean("key_zplan_ark_need_send_hint", true);
            }
            f16.putInt("forward_type", 49);
            Intent intent = new Intent();
            intent.putExtras(f16);
            ForwardBaseOption d16 = k.d(intent, appInterface, activity);
            Integer FORWARD_ABILITY_TYPE_DEFAULT = com.tencent.mobileqq.forward.e.N3;
            Intrinsics.checkNotNullExpressionValue(FORWARD_ABILITY_TYPE_DEFAULT, "FORWARD_ABILITY_TYPE_DEFAULT");
            int intValue = FORWARD_ABILITY_TYPE_DEFAULT.intValue();
            Bundle bundle = new Bundle();
            bundle.putBundle("zootopia_guild_biz_params", bizParams);
            Unit unit = Unit.INSTANCE;
            d16.buildForwardDialog(intValue, bundle);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final ZootopiaShareArkInfo result) {
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = this.f433691e;
            Bundle bundle = this.f433692f;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("visitUin", bundle.getLong("g_targetUin"));
            jSONObject.put("subSource", bundle.getString("g_subSource"));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
            result.h(jSONObject2);
            result.l(i3);
            ArkDispatchTask arkDispatchTask = ArkDispatchTask.getInstance();
            final QQAppInterface qQAppInterface = this.f433693h;
            final Activity activity = this.f433694i;
            final String str = this.f433695m;
            final boolean z16 = this.C;
            final IGProChannelInfo iGProChannelInfo = this.D;
            final Bundle bundle2 = this.f433692f;
            final int i16 = this.E;
            arkDispatchTask.postToMainThread(new Runnable() { // from class: sd3.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.c(ZootopiaShareArkInfo.this, qQAppInterface, activity, str, z16, iGProChannelInfo, bundle2, i16);
                }
            });
            this.f433690d.invoke(0, "success");
            QLog.i("ZootopiaShareUtil", 1, "shareArkToGuild success");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f433690d.invoke(Integer.valueOf(error), message);
            QLog.e("ZootopiaShareUtil", 1, "shareArkToGuild fail " + error + " " + message);
        }
    }

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle f(ZootopiaShareArkInfo arkInfo) {
        Bundle r16 = r(IZootopiaShareArkService.ZOOTOPIA_ARK_NAME, "gameshare", "1.0.0.7", arkInfo.c());
        r16.putString("forward_ark_app_name", IZootopiaShareArkService.ZOOTOPIA_ARK_NAME);
        r16.putString("forward_ark_app_view", "gameshare");
        r16.putString("forward_ark_app_ver", "1.0.0.7");
        r16.putString("forward_ark_app_meta", arkInfo.c());
        r16.putString("forward_ark_app_prompt", "[\u8d85\u7ea7QQ\u79c0]\u9080\u8bf7\u4f60\u4e00\u8d77\u73a9" + arkInfo.getMapName());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forward", 0);
            jSONObject.put("type", IndividuationUrlHelper.UrlId.CARD_HOME);
            r16.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, jSONObject.toString());
        } catch (Throwable th5) {
            QLog.e("ZootopiaShareUtil", 1, th5, new Object[0]);
        }
        return r16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ZplanShareArkInfo arkInfo, Context context, int i3) {
        Intrinsics.checkNotNullParameter(arkInfo, "$arkInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        Bundle a16 = arkInfo.a();
        Intent intent = new Intent();
        intent.putExtra("is_need_show_toast", false);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("caller_name", context.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_LEBA_MORE);
        intent.putExtra("key_allow_multiple_forward_from_limit", false);
        intent.putExtra("zplan_share_need_troop", true);
        intent.putExtra("forward_type", 54);
        intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID, arkInfo.e());
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtras(a16);
        RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZootopiaShareArkInfo arkInfo, Context context) {
        Intrinsics.checkNotNullParameter(arkInfo, "$arkInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        Bundle f16 = f433689a.f(arkInfo);
        Intent intent = new Intent();
        intent.putExtra("is_need_show_toast", false);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("zplan_share_need_troop", true);
        intent.putExtras(f16);
        QLog.d("ZootopiaShareUtil", 1, "arkBundle => " + f16);
        ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).openNativeForwardRecentPage(context, intent, String.valueOf(arkInfo.getMapID()), true, 0, false);
    }

    private final void n(final Activity activity, final ZplanShareArkInfo arkInfo, final int uinType, final String uin, final String hint, final boolean needSendHint, final int requestCode) {
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: sd3.c
            @Override // java.lang.Runnable
            public final void run() {
                f.q(ZplanShareArkInfo.this, activity, requestCode, uin, uinType, hint, needSendHint);
            }
        });
    }

    private final void o(final Context context, final ZootopiaShareArkInfo arkInfo, final int uinType, final String uin, final String hint, final boolean needSendHint) {
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: sd3.a
            @Override // java.lang.Runnable
            public final void run() {
                f.p(ZootopiaShareArkInfo.this, context, uin, uinType, hint, needSendHint);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ZootopiaShareArkInfo arkInfo, Context context, String uin, int i3, String hint, boolean z16) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(arkInfo, "$arkInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(hint, "$hint");
        Bundle f16 = f433689a.f(arkInfo);
        QLog.d("ZootopiaShareUtil", 1, "arkBundle => " + f16);
        Intent intent = new Intent(context, (Class<?>) DirectForwardActivity.class);
        intent.putExtra("toUin", uin);
        if (i3 == 1) {
            intent.putExtra("troopUin", uin);
        }
        intent.putExtra("uinType", i3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            if (i3 == 1) {
                intent.putExtra("nickName", ac.g0(appInterface, uin, false));
            } else {
                intent.putExtra("nickName", ac.F(appInterface, uin));
            }
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN, true);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID, String.valueOf(arkInfo.getMapID()));
            isBlank = StringsKt__StringsJVMKt.isBlank(hint);
            if (!isBlank) {
                intent.putExtra("key_zplan_troop_ark_share", hint);
                intent.putExtra("key_zplan_ark_need_send_hint", z16);
            }
            intent.putExtra("is_need_show_toast", false);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("uintype", i3);
            intent.putExtras(f16);
            intent.putExtra("forward_type", 49);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ZplanShareArkInfo arkInfo, Activity activity, int i3, String uin, int i16, String hint, boolean z16) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(arkInfo, "$arkInfo");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(hint, "$hint");
        Bundle a16 = arkInfo.a();
        Intent intent = new Intent(activity, (Class<?>) DirectForwardActivity.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            intent.putExtra("toUin", uin);
            if (i16 == 1) {
                intent.putExtra("troopUin", uin);
                intent.putExtra("nickName", ac.g0(appInterface, uin, false));
            } else {
                intent.putExtra("nickName", ac.F(appInterface, uin));
            }
            intent.putExtra("uinType", i16);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN, true);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID, arkInfo.e());
            isBlank = StringsKt__StringsJVMKt.isBlank(hint);
            if (!isBlank) {
                intent.putExtra("key_zplan_troop_ark_share", hint);
                intent.putExtra("key_zplan_ark_need_send_hint", z16);
            }
            intent.putExtra("is_need_show_toast", false);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("uintype", i16);
            intent.putExtras(a16);
            intent.putExtra("forward_type", 54);
        }
        activity.startActivityForResult(intent, i3);
    }

    private final Bundle r(String appName, String appView, String appMinVersion, String metaData) {
        Bundle bundle = new Bundle();
        bundle.putString("appName", appName);
        bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, appMinVersion);
        bundle.putString(QQCustomArkDialogUtil.APP_VIEW, appView);
        bundle.putString(QQCustomArkDialogUtil.META_DATA, metaData);
        return bundle;
    }

    public final void h(Activity context, ZplanShareArkInfo arkInfo, int uinType, String uin, String hint, boolean needSendHint, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (uinType >= 0 && !TextUtils.isEmpty(uin)) {
            n(context, arkInfo, uinType, uin, hint, needSendHint, requestCode);
        } else {
            i(context, arkInfo, requestCode);
        }
    }

    public final void i(final Context context, final ZplanShareArkInfo arkInfo, final int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: sd3.d
            @Override // java.lang.Runnable
            public final void run() {
                f.l(ZplanShareArkInfo.this, context, requestCode);
            }
        });
    }

    public final void j(final Context context, final ZootopiaShareArkInfo arkInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        QLog.i("ZootopiaShareUtil", 1, "shareArkToQQ");
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: sd3.b
            @Override // java.lang.Runnable
            public final void run() {
                f.m(ZootopiaShareArkInfo.this, context);
            }
        });
    }

    public final void k(Context context, ZootopiaShareArkInfo arkInfo, int uinType, String uin, String hint, boolean needSendHint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arkInfo, "arkInfo");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (uinType >= 0 && !TextUtils.isEmpty(uin)) {
            o(context, arkInfo, uinType, uin, hint, needSendHint);
        } else {
            j(context, arkInfo);
        }
    }

    public final void g(Context context, int mapId, int sceneType, Bundle bizParams, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bizParams, "bizParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                callback.invoke(-1, "context is not activity");
                return;
            }
            String string = bizParams.getString("g_channelId");
            if (string == null) {
                callback.invoke(-1, "channelId is null");
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            if (qQAppInterface == null) {
                callback.invoke(-1, "app is null");
                return;
            }
            IGPSService iGPSService = (IGPSService) qQAppInterface.getRuntimeService(IGPSService.class);
            IGProChannelInfo channelInfo = iGPSService != null ? iGPSService.getChannelInfo(string) : null;
            if (channelInfo == null) {
                callback.invoke(-1, "channelInfo is null");
            } else {
                z23.c.b(new z23.c(), qQAppInterface, mapId, 0, new a(callback, sceneType, bizParams, qQAppInterface, activity, string, bizParams.getInt("g_guildIdType", 1) == 0, channelInfo, mapId), 4, null);
            }
        } catch (Throwable th5) {
            QLog.e("ZootopiaShareUtil", 1, "shareArkToGuild fail " + th5);
        }
    }
}
