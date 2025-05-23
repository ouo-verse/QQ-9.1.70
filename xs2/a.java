package xs2;

import android.content.Context;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.ServerConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u0019"}, d2 = {"Lxs2/a;", "", "", "sJson", "Ljava/util/ArrayList;", "Lxs2/a$b;", "Lkotlin/collections/ArrayList;", "e", "Lxs2/a$a;", "f", "sText", "", "nSeconds", "a", "b", "c", "sUin", "d", "Landroid/content/Context;", LinkReportConstant$GlobalKey.CONNECT_TYPE, "", "remainingTime", "g", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f448450a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lxs2/a$a;", "", "", "a", "I", "()I", "setMDefDay", "(I)V", "mDefDay", "b", "setMDefHour", "mDefHour", "c", "setMDefMinute", "mDefMinute", "d", "setMMaxDay", "mMaxDay", "defDay", "defHour", "defMinute", "maxDay", "<init>", "(IIII)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xs2.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11565a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int mDefDay;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int mDefHour;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int mDefMinute;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mMaxDay;

        public C11565a(int i3, int i16, int i17, int i18) {
            this.mDefDay = i3;
            this.mDefHour = i16;
            this.mDefMinute = i17;
            this.mMaxDay = i18;
        }

        /* renamed from: a, reason: from getter */
        public final int getMDefDay() {
            return this.mDefDay;
        }

        /* renamed from: b, reason: from getter */
        public final int getMDefHour() {
            return this.mDefHour;
        }

        /* renamed from: c, reason: from getter */
        public final int getMDefMinute() {
            return this.mDefMinute;
        }

        /* renamed from: d, reason: from getter */
        public final int getMMaxDay() {
            return this.mMaxDay;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lxs2/a$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setSText", "(Ljava/lang/String;)V", "sText", "", "I", "()I", "c", "(I)V", "nSeconds", "<init>", "(Ljava/lang/String;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String sText;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int nSeconds;

        public b(String str, int i3) {
            this.sText = str;
            this.nSeconds = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getNSeconds() {
            return this.nSeconds;
        }

        /* renamed from: b, reason: from getter */
        public final String getSText() {
            return this.sText;
        }

        public final void c(int i3) {
            this.nSeconds = i3;
        }
    }

    a() {
    }

    private final ArrayList<b> e(String sJson) {
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(sJson);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                arrayList.add(new b(jSONObject.optString("text"), jSONObject.optInt("seconds")));
            }
        } catch (JSONException unused) {
            QLog.e("TroopMemberGagHelper", 1, "parseGagConfig failed");
        }
        return arrayList;
    }

    private final C11565a f(String sJson) {
        try {
            JSONObject jSONObject = new JSONObject(sJson);
            return new C11565a(jSONObject.optInt("defday"), jSONObject.optInt("defhour"), jSONObject.optInt("defminute"), jSONObject.optInt("maxday"));
        } catch (JSONException unused) {
            QLog.e("TroopMemberGagHelper", 1, "parseGagCustomConfig failed");
            return null;
        }
    }

    public final ArrayList<b> b() {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = "[{\"seconds\":600,\"text\":\"10\u5206\u949f\"},{\"seconds\":3600,\"text\":\"1\u5c0f\u65f6\"},{\"seconds\":43200,\"text\":\"12\u5c0f\u65f6\"},{\"seconds\":86400,\"text\":\"1\u5929\"}]".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String b642 = PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        String serverConfigValue = ((QQAppInterface) peekAppRuntime).getServerConfigValue(ServerConfigManager.ConfigType.common, "GagMemberConfig");
        if (serverConfigValue != null) {
            b642 = serverConfigValue;
        }
        Intrinsics.checkNotNullExpressionValue(b642, "b64");
        byte[] bytes2 = b642.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(bytes2, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(b64.toByteArray(), Base64Util.DEFAULT)");
        return e(new String(decode, charset));
    }

    public final C11565a c() {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = "{\"defday\":2,\"defhour\":0,\"defminute\":0,\"maxday\":30}".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String b642 = PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        String serverConfigValue = ((QQAppInterface) peekAppRuntime).getServerConfigValue(ServerConfigManager.ConfigType.common, "GagMemberCustomConfig");
        if (serverConfigValue != null) {
            b642 = serverConfigValue;
        }
        Intrinsics.checkNotNullExpressionValue(b642, "b64");
        byte[] bytes2 = b642.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(bytes2, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(b64.toByteArray(), Base64Util.DEFAULT)");
        return f(new String(decode, charset));
    }

    public final String d(String sUin) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ssConstant.MAIN\n        )");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(sUin, true);
        if (findTroopInfo == null) {
            return "";
        }
        if (findTroopInfo.isTroopOwner(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin())) {
            return "1";
        }
        return "2";
    }

    public final String g(Context ct5, long remainingTime) {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        String string = context.getString(R.string.emx);
        Intrinsics.checkNotNullExpressionValue(string, "context\n                \u2026p_gag_time_format_minute)");
        String string2 = context.getString(R.string.emw);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026oop_gag_time_format_hour)");
        String string3 = context.getString(R.string.emv);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026roop_gag_time_format_day)");
        if (remainingTime < 60) {
            return "1" + string;
        }
        long j3 = remainingTime + 59;
        long j16 = 86400;
        long j17 = j3 / j16;
        long j18 = j3 - (j16 * j17);
        long j19 = 3600;
        long j26 = j18 / j19;
        long j27 = (j18 - (j19 * j26)) / 60;
        String str = "";
        if (j17 > 0) {
            str = "" + j17 + string3;
        }
        if (j26 > 0) {
            str = str + j26 + string2;
        }
        if (j27 <= 0) {
            return str;
        }
        return str + j27 + string;
    }

    public final b a(String sText, int nSeconds) {
        if (sText != null) {
            return new b(sText, nSeconds);
        }
        return null;
    }
}
