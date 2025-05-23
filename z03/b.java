package z03;

import android.os.Build;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.g;
import com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TDiyFontReq;
import com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TDiyFontRsp;
import com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TFontSsoReq;
import com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TFontSsoRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\f\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0017"}, d2 = {"Lz03/b;", "", "Lcom/tencent/mobileqq/vas/font/diy/data/VipFontUpdate$TFontSsoRsp;", "tFontSsoRsp", "Lz03/b$b;", "observer", "", "d", "", "", "", "reqParamMap", "e", "uin", MessageForRichState.SIGN_MSG_FONT_ID, "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "c", "<init>", "()V", "a", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final b f451715b = new b();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, Long>> f451716c = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR,\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lz03/b$a;", "", "Lz03/b;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lz03/b;", "a", "()Lz03/b;", "", "CMD_REQ_RES_VIP_FONT_FRESH", "Ljava/lang/String;", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "diyFontTimestampMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z03.b$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            return b.f451715b;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lz03/b$b;", "", "", MessageForRichState.SIGN_MSG_FONT_ID, "", DownloadInfo.spKey_Config, "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z03.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC11643b {
        void a(int fontId, @NotNull String config);
    }

    private final void d(VipFontUpdate$TFontSsoRsp tFontSsoRsp, InterfaceC11643b observer) {
        try {
            VipFontUpdate$TDiyFontRsp vipFontUpdate$TDiyFontRsp = tFontSsoRsp.st_diyfont_rsp.get();
            Intrinsics.checkNotNullExpressionValue(vipFontUpdate$TDiyFontRsp, "tFontSsoRsp.st_diyfont_rsp.get()");
            for (VipFontUpdate$TDiyFontRsp.TDiyFontRspInfo tDiyFontRspInfo : vipFontUpdate$TDiyFontRsp.rpt_font_rsp_info.get()) {
                String valueOf = String.valueOf(tDiyFontRspInfo.u64_uin.get());
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(info.u64_uin.get())");
                String str = tDiyFontRspInfo.str_diy_font_config.get();
                Intrinsics.checkNotNullExpressionValue(str, "info.str_diy_font_config.get()");
                int i3 = tDiyFontRspInfo.i32_font_id.get();
                if (QLog.isColorLevel()) {
                    QLog.d("RequestVipFontUpdate", 2, "handleGetDiyFontConfig uin = " + valueOf + " fontId = " + i3 + " config = " + str);
                }
                if (observer != null) {
                    observer.a(i3, str);
                }
            }
        } catch (Exception e16) {
            QLog.e("RequestVipFontUpdate", 1, "handleGetDiyFontConfig error: + " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b this$0, InterfaceC11643b interfaceC11643b, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("RequestVipFontUpdate", 2, "pbGetDiyFontConfig CMD_REQ_RES_VIP_FONT_FRESH callback isSuccess " + z16 + " data " + obj);
        }
        if (z16 && (obj instanceof VipFontUpdate$TFontSsoRsp)) {
            this$0.d((VipFontUpdate$TFontSsoRsp) obj, interfaceC11643b);
        }
    }

    public final boolean c(@NotNull String uin, int fontId, long timeStamp, @Nullable InterfaceC11643b observer) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, Long>> concurrentHashMap = f451716c;
        ConcurrentHashMap<Integer, Long> concurrentHashMap2 = concurrentHashMap.get(uin);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap.put(uin, concurrentHashMap2);
        }
        if (concurrentHashMap2.get(Integer.valueOf(fontId)) != null) {
            Long l3 = concurrentHashMap2.get(Integer.valueOf(fontId));
            Intrinsics.checkNotNull(l3);
            if (l3.longValue() >= timeStamp) {
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RequestVipFontUpdate", 2, "checkUpdateDIYConfig uin = " + uin + " fontId = " + fontId + " oldTime = " + concurrentHashMap2.get(Integer.valueOf(fontId)) + " newTime = " + timeStamp);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(uin, Integer.valueOf(fontId));
        e(hashMap, observer);
        concurrentHashMap2.put(Integer.valueOf(fontId), Long.valueOf(timeStamp));
        return true;
    }

    public final void e(@NotNull Map<String, Integer> reqParamMap, @Nullable final InterfaceC11643b observer) {
        Intrinsics.checkNotNullParameter(reqParamMap, "reqParamMap");
        if (QLog.isColorLevel()) {
            QLog.d("RequestVipFontUpdate", 2, "pbGetDiyFontConfig");
        }
        VipFontUpdate$TFontSsoReq vipFontUpdate$TFontSsoReq = new VipFontUpdate$TFontSsoReq();
        vipFontUpdate$TFontSsoReq.u32_cmd.set(3);
        vipFontUpdate$TFontSsoReq.u64_seq.set(new Random().nextInt(1000));
        vipFontUpdate$TFontSsoReq.i32_implat.set(109);
        vipFontUpdate$TFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
        vipFontUpdate$TFontSsoReq.str_mqqver.set(g.f308459b.getReportVersionName());
        VipFontUpdate$TDiyFontReq vipFontUpdate$TDiyFontReq = new VipFontUpdate$TDiyFontReq();
        for (String str : reqParamMap.keySet()) {
            VipFontUpdate$TDiyFontReq.TDiyFontReqInfo tDiyFontReqInfo = new VipFontUpdate$TDiyFontReq.TDiyFontReqInfo();
            tDiyFontReqInfo.u64_uin.set(Long.parseLong(str));
            Integer num = reqParamMap.get(str);
            if (num != null) {
                tDiyFontReqInfo.i32_font_id.set(num.intValue());
            }
            vipFontUpdate$TDiyFontReq.rpt_font_req_info.add(tDiyFontReqInfo);
        }
        vipFontUpdate$TFontSsoReq.st_diyfont_req.set(vipFontUpdate$TDiyFontReq);
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request(ProfileContants.CMD_REQ_RES_VIP_FONT_FRESH, vipFontUpdate$TFontSsoReq, VipFontUpdate$TFontSsoRsp.class, new BusinessObserver() { // from class: z03.a
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                b.f(b.this, observer, i3, z16, obj);
            }
        });
    }
}
