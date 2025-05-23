package r43;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.jungle.weather.proto.weather$GetNowcastingReply;
import com.tencent.jungle.weather.proto.weather$GetNowcastingRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.mobileqq.weather.hippy.QQWeatherModule;
import com.tencent.mobileqq.weather.util.calendar.CalendarUtils;
import com.tencent.mobileqq.weather.util.report.f;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u0014\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J=\u0010\u0017\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J?\u0010\u0019\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\b\b\u0002\u0010\u0018\u001a\u00020\u0002H\u0002J\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006 "}, d2 = {"Lr43/b;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "l", "cmd", "cmdKey", "", "reqBytes", "Lcom/tencent/mobileqq/weather/servlet/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "d", "", "retCode", "i", "errMsg", "g", "p", "method", "call", "<init>", "()V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends e {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String[] f430727e = {QQPermissionConstants.Permission.WRITE_CALENDAR};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"r43/b$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "deniedPermissions", "", "isShowGuide", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: r43.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C11113b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f430728a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f430729b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f430730c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"r43/b$b$a", "Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils$a;", "", "result", "", "callback", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: r43.b$b$a */
        /* loaded from: classes20.dex */
        public static final class a implements CalendarUtils.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f430731a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function1<Object, Unit> f430732b;

            a(b bVar, Function1<Object, Unit> function1) {
                this.f430731a = bVar;
                this.f430732b = function1;
            }

            @Override // com.tencent.mobileqq.weather.util.calendar.CalendarUtils.a
            public void callback(int result) {
                this.f430731a.i(this.f430732b, result);
            }
        }

        C11113b(JSONObject jSONObject, b bVar, Function1<Object, Unit> function1) {
            this.f430728a = jSONObject;
            this.f430729b = bVar;
            this.f430730c = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            CalendarUtils.f313630a.d(this.f430728a, new a(this.f430729b, this.f430730c));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            this.f430729b.i(this.f430730c, -2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"r43/b$c", "Lcom/tencent/mobileqq/weather/servlet/c;", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "", "errMsg", "", "e", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements com.tencent.mobileqq.weather.servlet.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f430733a;

        c(Function1<Object, Unit> function1) {
            this.f430733a = function1;
        }

        @Override // com.tencent.mobileqq.weather.servlet.c
        public void a(@NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e(QQWeatherModule.NAME, 1, "create request ad error, abort request ad", e16);
        }

        @Override // com.tencent.mobileqq.weather.servlet.c
        public void b(@NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                MessageMicro<weather$GetNowcastingReply> messageMicro = new MessageMicro<weather$GetNowcastingReply>() { // from class: com.tencent.jungle.weather.proto.weather$GetNowcastingReply
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56}, new String[]{"nowcasting", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "weather", QCircleSchemeAttr.Detail.CURRENT_TIME, "category", "nodes", "background"}, new Object[]{"", "", null, 0, 0, null, 0}, weather$GetNowcastingReply.class);
                    public final PBStringField nowcasting = PBField.initString("");
                    public final PBStringField link = PBField.initString("");
                    public WeatherInfo$Weather weather = new WeatherInfo$Weather();
                    public final PBUInt32Field current_time = PBField.initUInt32(0);
                    public final PBEnumField category = PBField.initEnum(0);
                    public final PBRepeatMessageField<weather$NowcastingNode> nodes = PBField.initRepeatMessage(weather$NowcastingNode.class);
                    public final PBEnumField background = PBField.initEnum(0);
                };
                messageMicro.mergeFrom(rspBytes);
                JSONObject jSONObject = (JSONObject) GdtJsonPbUtil.pbToJson(messageMicro);
                Function1<Object, Unit> function1 = this.f430733a;
                if (function1 != null) {
                    function1.invoke(jSONObject);
                }
            } catch (Exception e16) {
                QLog.e(QQWeatherModule.NAME, 1, "create request ad error, abort request ad", e16);
            }
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEATHER, QQPermissionConstants.Business.SCENE.WEATHER_WEEK));
        if (TextUtils.isEmpty(params)) {
            g(callback, "params is null");
            return;
        }
        if (params != null) {
            jSONObject = new JSONObject(params);
        } else {
            jSONObject = null;
        }
        if (qQPermission != null) {
            qQPermission.requestPermissions(f430727e, 2, new C11113b(jSONObject, this, callback));
        }
    }

    private final void g(Function1<Object, Unit> callback, String errMsg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isSuccess", false);
        jSONObject.put("errorMessage", errMsg);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Function1<Object, Unit> callback, int retCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isSuccess", true);
        jSONObject.put("retCode", retCode);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    private final void j(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        f fVar = f.f313674a;
        String optString = jSONObject.optString("warningType", "0");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(RAIN_KUIKLY_TYPE_KEY, \"0\")");
        String optString2 = jSONObject.optString("warningSource", "0");
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(RAIN_KUIKLY_SOURCE_KEY, \"0\")");
        fVar.e(optString, optString2);
    }

    private final void l(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String cmd = jSONObject.optString("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("reqParam");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        PBField pbFromJson = GdtJsonPbUtil.pbFromJson(new MessageMicro<weather$GetNowcastingRequest>() { // from class: com.tencent.jungle.weather.proto.weather$GetNowcastingRequest
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBFloatField latitude = PBField.initFloat(0.0f);
            public final PBFloatField longitude = PBField.initFloat(0.0f);
            public final PBUInt32Field adcode = PBField.initUInt32(0);

            static {
                Float valueOf = Float.valueOf(0.0f);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 24}, new String[]{"latitude", "longitude", "adcode"}, new Object[]{valueOf, valueOf, 0}, weather$GetNowcastingRequest.class);
            }
        }, optJSONObject);
        Intrinsics.checkNotNull(pbFromJson, "null cannot be cast to non-null type com.tencent.jungle.weather.proto.weather.GetNowcastingRequest");
        try {
            byte[] byteArray = ((weather$GetNowcastingRequest) pbFromJson).toByteArray();
            c cVar = new c(callback);
            Intrinsics.checkNotNullExpressionValue(cmd, "cmd");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            m(cmd, uuid, byteArray, cVar);
        } catch (Throwable th5) {
            QLog.e(QQWeatherModule.NAME, 1, "create request ad error, abort request ad", th5);
        }
    }

    private final void m(final String cmd, final String cmdKey, final byte[] reqBytes, final com.tencent.mobileqq.weather.servlet.c callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: r43.a
            @Override // java.lang.Runnable
            public final void run() {
                b.o(cmd, cmdKey, reqBytes, callback);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String cmd, String cmdKey, byte[] reqBytes, com.tencent.mobileqq.weather.servlet.c callback) {
        Intrinsics.checkNotNullParameter(cmd, "$cmd");
        Intrinsics.checkNotNullParameter(cmdKey, "$cmdKey");
        Intrinsics.checkNotNullParameter(reqBytes, "$reqBytes");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        com.tencent.mobileqq.weather.servlet.a.INSTANCE.a(cmd, cmdKey, reqBytes, callback);
    }

    private final void p(String params) {
        JSONObject jSONObject;
        int i3;
        if (params != null) {
            jSONObject = new JSONObject(params);
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            i3 = jSONObject.optInt("userPageSelection");
        } else {
            i3 = 1;
        }
        com.tencent.mobileqq.weather.data.f.f313296a.r(i3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1468099379:
                if (method.equals("addRemindInfoToCalendar")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 115715456:
                if (method.equals("ssoRequest")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 889977651:
                if (method.equals("pageExpose")) {
                    j(params);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 917649776:
                if (method.equals("setUserPageSelection")) {
                    p(params);
                }
                return Unit.INSTANCE;
            default:
                return Unit.INSTANCE;
        }
    }
}
