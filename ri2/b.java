package ri2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.qqlive.kuikly.QQLiveKuiklyConfigUtils;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sq4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"Lri2/b;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "U9", "Lfp4/c;", "msgInfo", "onPush", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "V9", "<init>", "()V", "e", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends c implements g {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Map<Long, sq4.b> f431483f = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lri2/b$a;", "", "", "", "Lsq4/b;", "inviteMap", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ri2.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Map<Long, sq4.b> a() {
            return b.f431483f;
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        f431483f.clear();
        f F9 = F9();
        if (F9 != null) {
            F9.p(285, this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Push|QQLivePlayTogetherPart", "onEnterRoom", "no room");
        }
        QQLiveKuiklyConfigUtils.f271368a.a();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        Unit unit;
        Context context = getContext();
        if (context != null) {
            l.e(context, "notifyPageClose", new JSONObject());
        }
        super.V9();
        f F9 = F9();
        if (F9 != null) {
            F9.e(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Push|QQLivePlayTogetherPart", "onEnterRoom", "no room");
        }
        f431483f.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        Context context = getContext();
        if (context != null) {
            l.e(context, "notifyPageClose", new JSONObject());
        }
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        d A = com.tencent.mobileqq.qqlive.sail.push.a.A(msgInfo);
        if (A != null) {
            AegisLogger.INSTANCE.d("Push|QQLivePlayTogetherPart", "onPush", "on TeamConditionChangeMsg");
            Context context = getContext();
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appID", A.f434258a);
                jSONObject.put("anchorUid", A.f434259b);
                Unit unit = Unit.INSTANCE;
                l.e(context, "notifyGameTeamConditionChange", jSONObject);
            }
        }
        sq4.c z16 = com.tencent.mobileqq.qqlive.sail.push.a.z(msgInfo);
        if (z16 != null) {
            AegisLogger.INSTANCE.d("Push|QQLivePlayTogetherPart", "onPush", "on TeamBuildUpdateMsg");
            Context context2 = getContext();
            if (context2 != null) {
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appID", z16.f434256a);
                jSONObject2.put("anchorUid", z16.f434257b);
                Unit unit2 = Unit.INSTANCE;
                l.e(context2, "notifyGameTeamBuildUpdate", jSONObject2);
            }
        }
        sq4.b y16 = com.tencent.mobileqq.qqlive.sail.push.a.y(msgInfo);
        if (y16 != null) {
            AegisLogger.INSTANCE.d("Push|QQLivePlayTogetherPart", "onPush", "on TeamBuildInvite");
            f431483f.put(Long.valueOf(msgInfo.f400283a), y16);
            String str = y16.f434254a + "&seq=" + msgInfo.f400283a;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https://", false, 2, null);
                if (!startsWith$default2) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(str));
                    if (!(getContext() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra("big_brother_source_key", "qqlive_play_together");
                    getContext().startActivity(intent);
                    return;
                }
            }
            com.tencent.mobileqq.qqlive.anchor.live.utils.c cVar = com.tencent.mobileqq.qqlive.anchor.live.utils.c.f270735a;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            cVar.f(activity, str);
        }
    }
}
