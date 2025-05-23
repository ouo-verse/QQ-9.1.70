package s81;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J8\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J&\u0010\u0012\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0007R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0013j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002`\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ls81/b;", "", "", "pageCode", "modeCode", "eventCode", "", "params", "", "d", "", "type", "c", "Ljava/util/ArrayList;", "apolloEmojiList", "Lcom/tencent/common/app/AppInterface;", "mAppInterface", "mCurType", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "sApolloTagSelectedMap", "<init>", "()V", "cmshow_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f433463a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final HashMap<Integer, String> sApolloTagSelectedMap = new HashMap<>();

    static {
        UserAction.registerTunnel(new TunnelInfo("0AND0FB8I14UU93I", AppSetting.n(), "1000"));
    }

    b() {
    }

    @JvmStatic
    public static final void b(ArrayList<Integer> apolloEmojiList, AppInterface mAppInterface, int mCurType) {
        Intrinsics.checkNotNullParameter(apolloEmojiList, "apolloEmojiList");
        Intrinsics.checkNotNullParameter(mAppInterface, "mAppInterface");
        if (apolloEmojiList.size() > 0) {
            StringBuilder sb5 = null;
            String[] strArr = {null, null, null, null, null};
            int size = apolloEmojiList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 <= 4) {
                    strArr[i3] = String.valueOf(apolloEmojiList.get(i3).intValue());
                } else {
                    if (sb5 == null) {
                        sb5 = new StringBuilder();
                    }
                    Integer num = apolloEmojiList.get(i3);
                    Intrinsics.checkNotNullExpressionValue(num, "apolloEmojiList[k]");
                    sb5.append(num.intValue());
                    if (i3 != apolloEmojiList.size()) {
                        sb5.append(",");
                    }
                }
            }
        }
    }

    @JvmStatic
    public static final int c(int type) {
        if (type != 0) {
            if (type == 1) {
                return 1;
            }
            if (type == 1000 || type == 1045) {
                return 3;
            }
            if (type != 3000) {
                return type;
            }
            return 2;
        }
        return 0;
    }

    @JvmStatic
    public static final void d(final String pageCode, final String modeCode, final String eventCode, final Map<String, String> params) {
        Intrinsics.checkNotNullParameter(pageCode, "pageCode");
        Intrinsics.checkNotNullParameter(modeCode, "modeCode");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: s81.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(pageCode, modeCode, eventCode, params);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String pageCode, String modeCode, String eventCode, Map map) {
        Intrinsics.checkNotNullParameter(pageCode, "$pageCode");
        Intrinsics.checkNotNullParameter(modeCode, "$modeCode");
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        String str = pageCode + '#' + modeCode + '#' + eventCode;
        HashMap hashMap = new HashMap();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String account = runtime != null ? runtime.getAccount() : null;
        if (account == null) {
            account = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(account, "BaseApplicationImpl.getA\u2026().runtime?.account ?: \"\"");
        }
        hashMap.put("qqUin", account);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        if (map != null) {
            hashMap.putAll(map);
        }
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            sb5.append((String) entry.getKey());
            sb5.append(":");
            sb5.append((String) entry.getValue());
            sb5.append(";");
        }
        QLog.d("ApolloDtReportUtil", 1, "report " + str + " ; params:  " + ((Object) sb5));
        ReportMethodProxy.onUserActionToTunnel("0AND0FB8I14UU93I", str, hashMap, true, true);
    }
}
