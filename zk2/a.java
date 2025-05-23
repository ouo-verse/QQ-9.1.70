package zk2;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qwallet.hb.panel.preview.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0016"}, d2 = {"Lzk2/a;", "", "Lorg/json/JSONObject;", WadlProxyConsts.EXTRA_DATA, "", "callbackSn", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "d", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "c", "Landroid/content/Context;", "context", "a", "", "skinId", "", "b", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f452709a = new a();

    a() {
    }

    private final boolean a(JSONObject extraData, String callbackSn, Context context) {
        QLog.i("SchemeSendHbModule", 1, "start forward, " + extraData);
        if (context == null) {
            QLog.w("SchemeSendHbModule", 1, "forward fail, context is null");
            return false;
        }
        if (extraData.optJSONObject("extra_info") == null) {
            QLog.w("SchemeSendHbModule", 1, "extra_info is null");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("callbackSn", callbackSn);
        intent.putExtra("come_from", 2);
        intent.putExtra("is_H5", true);
        intent.putExtra("extra_data", extraData.toString());
        intent.putExtra("forward_type", 18);
        RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, 5);
        return true;
    }

    private final boolean c(JSONObject extraData, p sessionInfo, QBaseActivity activity) {
        IGPSService iGPSService;
        QLog.i("SchemeSendHbModule", 1, "start send: " + extraData);
        int optInt = extraData.optInt("skin_id");
        try {
            int i3 = sessionInfo.f179555d;
            String str = sessionInfo.f179557e;
            Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 3000) {
                        if (i3 == 10014) {
                            extraData.put("recv_type", 11);
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            String str2 = null;
                            if (peekAppRuntime != null) {
                                iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
                            } else {
                                iGPSService = null;
                            }
                            if (iGPSService != null) {
                                str2 = iGPSService.getSelfTinyId();
                            }
                            extraData.put("tinyid", str2);
                            extraData.put("guild_id", sessionInfo.f179559f);
                            extraData.put("sub_guild_id", str);
                        }
                    } else {
                        extraData.put("group_id", str);
                        extraData.put("recv_type", 2);
                    }
                } else {
                    extraData.put("group_id", str);
                    extraData.put("recv_type", 3);
                }
            } else {
                extraData.put("recv_type", 1);
            }
            extraData.put("recv_uin", str);
            extraData.put("appid", String.valueOf(AppSetting.f()));
            extraData.put("from_memo", com.tencent.mobileqq.base.a.b());
            extraData.put("userId", com.tencent.mobileqq.base.a.c());
        } catch (Exception unused) {
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("SchemeSendHbModule", 4, "extra_data = " + extraData);
        }
        Intent intent = new Intent();
        intent.putExtra("come_from", 2);
        intent.putExtra("extra_data", extraData.toString());
        intent.putExtra("skin_id", optInt);
        intent.setFlags(603979776);
        RouteUtils.startActivityForResult(activity, intent, "/qwallet/redpacket/sendhb", 5);
        return true;
    }

    @JvmStatic
    public static final boolean d(@NotNull JSONObject extraData, @Nullable String callbackSn, @NotNull QBaseActivity activity) {
        String str;
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intrinsics.checkNotNullParameter(activity, "activity");
        p d16 = f.f277592a.d();
        Integer num = null;
        if (d16 != null) {
            str = d16.f179557e;
        } else {
            str = null;
        }
        if (d16 != null) {
            num = Integer.valueOf(d16.f179555d);
        }
        QLog.i("SchemeSendHbModule", 1, "start, uin=" + str + " type=" + num);
        if (d16 != null) {
            return f452709a.c(extraData, d16, activity);
        }
        return f452709a.a(extraData, callbackSn, activity);
    }

    public final void b(int skinId, @Nullable Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("skin_id", skinId);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("friend_type", "2|3");
        jSONObject2.put("title", "\u53d1\u9001\u7ed9\u8ba8\u8bba\u7ec4|\u7fa4");
        Unit unit = Unit.INSTANCE;
        jSONObject.put("extra_info", jSONObject2);
        a(jSONObject, null, context);
    }
}
