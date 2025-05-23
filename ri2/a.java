package ri2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveTempApi;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveServerQIPCModule;
import com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JL\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004JL\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u00a8\u0006\u0015"}, d2 = {"Lri2/a;", "", "Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$GameData;", "gameData", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "", "msg", "", "callback", "b", "a", "Landroid/content/Context;", "context", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "d", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a */
    @NotNull
    public static final a f431480a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ri2/a$a", "Leipc/EIPCResultCallback;", "Leipc/EIPCResult;", "result", "", "onCallback", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ri2.a$a */
    /* loaded from: classes17.dex */
    public static final class C11141a implements EIPCResultCallback {

        /* renamed from: d */
        final /* synthetic */ Function2<Integer, String, Unit> f431481d;

        /* JADX WARN: Multi-variable type inference failed */
        C11141a(Function2<? super Integer, ? super String, Unit> function2) {
            this.f431481d = function2;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult result) {
            int i3;
            String str;
            Bundle bundle;
            if (result != null) {
                i3 = result.code;
            } else {
                i3 = -2;
            }
            if (result == null || (bundle = result.data) == null || (str = bundle.getString(QQLiveIPCConstants.Param.PARAM_PLAY_TOGETHER_CALLBACK_MSG)) == null) {
                str = "";
            }
            Function2<Integer, String, Unit> function2 = this.f431481d;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i3), str);
            }
        }
    }

    a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(a aVar, QQLivePreparePlayTogetherPart.GameData gameData, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        aVar.b(gameData, function2);
    }

    public final void a(@Nullable QQLivePreparePlayTogetherPart.GameData gameData, @Nullable Function2<? super Integer, ? super String, Unit> callback) {
        String str;
        boolean z16;
        AppInterface appInterface;
        int i3;
        if (gameData != null) {
            str = gameData.a();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.invoke(-1, "error gameData");
            }
            QLog.d("QQLivePlayTogetherHelper", 1, "jump start live but gameData invalid");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            if (callback != null) {
                callback.invoke(-1, "error appInterface");
            }
            QLog.e("QQLivePlayTogetherHelper", 1, "enterGameInviteRoom but appInterface is null");
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            if (callback != null) {
                callback.invoke(-1, "error context");
            }
            QLog.e("QQLivePlayTogetherHelper", 1, "enterGameInviteRoom but context is null");
            return;
        }
        Intrinsics.checkNotNull(gameData);
        if (PackageUtil.isAppInstalled(context, gameData.e())) {
            QLog.i("QQLivePlayTogetherHelper", 1, "launchAppWithTokens appId:" + gameData.a() + " paramStr:" + gameData.f() + " packageName:" + gameData.e() + " flags:" + gameData.c());
            IQQLiveTempApi iQQLiveTempApi = (IQQLiveTempApi) QRoute.api(IQQLiveTempApi.class);
            String a16 = gameData.a();
            String f16 = gameData.f();
            String e16 = gameData.e();
            String c16 = gameData.c();
            if (c16 != null) {
                i3 = RFWStringsKt.toIntOrDefault$default(c16, 0, 0, 2, null);
            } else {
                i3 = 0;
            }
            iQQLiveTempApi.launchAppWithTokens(appInterface, context, a16, f16, e16, i3);
        } else {
            String b16 = gameData.b();
            if (TextUtils.isEmpty(b16)) {
                QLog.d("QQLivePlayTogetherHelper", 2, "url is empty");
                return;
            } else {
                MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                d(sMobileQQ, b16);
            }
        }
        if (callback != null) {
            callback.invoke(0, "");
        }
    }

    public final void b(@Nullable QQLivePreparePlayTogetherPart.GameData gameData, @Nullable Function2<? super Integer, ? super String, Unit> callback) {
        QQLiveServerQIPCModule.Companion companion = QQLiveServerQIPCModule.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putParcelable(QQLiveIPCConstants.Param.PARAM_PLAY_TOGETHER_GAME_DATA, gameData);
        Unit unit = Unit.INSTANCE;
        companion.a(QQLiveIPCConstants.Action.ACTION_QQLIVE_PLAY_TOGETHER_LAUNCH_APP, bundle, new C11141a(callback));
    }

    public final void d(@NotNull Context context, @Nullable String r152) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (r152 != null && r152.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(r152, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(r152, "https://", false, 2, null);
                if (!startsWith$default2) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(r152));
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    return;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", "biz_src_jc_qqlive");
            com.tencent.qqlive.common.webview.a.g(context, r152, bundle, QQBrowserActivity.class, new int[]{268435456}, null, QQLiveSDKConfigHelper.getQQLiveAppId());
            return;
        }
        QLog.e("QQLivePlayTogetherHelper", 1, "openUrlOrSchema link is null or empty");
    }
}
