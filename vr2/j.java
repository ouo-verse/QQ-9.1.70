package vr2;

import android.os.SystemClock;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.util.AppSetting;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lvr2/j;", "", "", "b", "", "errCode", "", "errMsg", "", "a", "Ljava/lang/String;", "groupUin", "I", "aiVoiceType", "c", "timbreId", "d", "text", "", "e", "J", "startTimestamp", "f", "Z", "isReported", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "g", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j {

    /* renamed from: g, reason: collision with root package name */
    private static final a f443209g = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String groupUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int aiVoiceType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String timbreId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long startTimestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isReported;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lvr2/j$a;", "", "", "COST_TIME", "Ljava/lang/String;", "", "DEFAULT_SAMPLE", "D", "ERR_CODE", "ERR_MSG", "GROUP_ID", "GROUP_UIN", "REPORT_EVENT", "REPORT_SAMPLE_KEY", "TEXT_LEN", "TIMBRE_ID", "VOICE_TYPE", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public j(String groupUin, int i3, String timbreId, String text) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        Intrinsics.checkNotNullParameter(timbreId, "timbreId");
        Intrinsics.checkNotNullParameter(text, "text");
        this.groupUin = groupUin;
        this.aiVoiceType = i3;
        this.timbreId = timbreId;
        this.text = text;
        this.startTimestamp = SystemClock.uptimeMillis();
    }

    private final boolean b() {
        if (!AppSetting.isPublicVersion()) {
            return true;
        }
        try {
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("105422", new byte[0]);
            double d16 = 0.1d;
            if (!(loadRawConfig.length == 0)) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                d16 = new JSONObject(new String(loadRawConfig, UTF_8)).optDouble("aiVoiceMsgReportSample", 0.1d);
            }
            return Math.random() <= d16;
        } catch (Exception e16) {
            if (AppSetting.isDebugVersion()) {
                throw e16;
            }
            return false;
        }
    }

    public final void a(int errCode, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (!this.isReported && b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("group_uin", this.groupUin);
            hashMap.put(ITroopAIVoiceChatApi.AI_CHAT_TYPE, Integer.valueOf(this.aiVoiceType));
            hashMap.put("timbre_id", this.timbreId);
            hashMap.put(CheckForwardServlet.KEY_ERR_CODE, Integer.valueOf(errCode));
            hashMap.put("err_msg", errMsg);
            hashMap.put("cost_time", Long.valueOf(SystemClock.uptimeMillis() - this.startTimestamp));
            hashMap.put("text_len", Integer.valueOf(this.text.length()));
            ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("troop_ai_voice_send_result", hashMap);
            this.isReported = true;
        }
    }
}
