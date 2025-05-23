package wv0;

import android.app.Activity;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView;
import com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uw0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000e\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fJ\"\u0010\u0019\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\"\u0010\u001f\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u001a\u0010 \u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u001a\u0010!\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u001a\u0010\"\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010.R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0018\u0010=\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010'R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00102R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006I"}, d2 = {"Lwv0/a;", "Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "Lxv0/a;", "giftItem", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "i", "", DomainData.DOMAIN_NAME, "sendGiftServiceData", "", "curNum", "curAllNum", "", "curSeq", "o", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "roomId", "j", "data", "Landroid/view/ViewGroup;", "containerView", "invokeSource", "p", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "batchBean", "position", "b", "d", "c", "a", "Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftView;", "Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftView;", "multiGiftView", "e", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "curGiftServiceData", "f", "Landroid/app/Activity;", "hostActivity", h.F, "Ljava/lang/Long;", "J", "curBalance", "curMarketingBalance", BdhLogUtil.LogTag.Tag_Conn, "I", "curComboNum", "D", "curComboSeq", "E", "lastSendTime", UserInfo.SEX_FEMALE, "lastComboNum", "G", "lastAllComboNum", "H", "curBatchGiftData", "selfInvokeSource", "Luw0/a$d;", "Luw0/a$d;", "sendGiftCallback", "Lrh2/a;", "K", "Lrh2/a;", "qqGiftBalanceCallback", "<init>", "()V", "L", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a implements BatchGiftItemView.a {

    /* renamed from: C, reason: from kotlin metadata */
    private int curComboNum;

    /* renamed from: D, reason: from kotlin metadata */
    private long curComboSeq;

    /* renamed from: E, reason: from kotlin metadata */
    private long lastSendTime;

    /* renamed from: F, reason: from kotlin metadata */
    private int lastComboNum;

    /* renamed from: G, reason: from kotlin metadata */
    private int lastAllComboNum;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private d curBatchGiftData;

    /* renamed from: I, reason: from kotlin metadata */
    private int selfInvokeSource = 1;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final a.d sendGiftCallback = new c();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final rh2.a qqGiftBalanceCallback = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BatchGiftView multiGiftView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d curGiftServiceData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity hostActivity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long curBalance;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long curMarketingBalance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"wv0/a$b", "Lrh2/a;", "", "balance", "marketingBalance", "seq", "", "firstSave", "", h.F, "errCode", "", "errMsg", "onFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements rh2.a {
        b() {
        }

        @Override // rh2.a
        public void h(long balance, long marketingBalance, long seq, int firstSave) {
            rt0.a.INSTANCE.k("ICGameGift|BatchGiftPendant", "IQQGiftBalanceCallback.onReceive", "requestBalance success, balance=" + balance + ", seq=" + seq);
            a.this.curBalance = balance;
            a.this.curMarketingBalance = marketingBalance;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            rt0.a.INSTANCE.k("ICGameGift|BatchGiftPendant", "IQQGiftBalanceCallback.onFailed", "requestBalance fail, errCode=" + errCode + ", errMsg=" + errMsg);
        }
    }

    private final d i(xv0.a giftItem) {
        Map<String, String> map;
        d dVar = this.curGiftServiceData;
        if (dVar != null) {
            d clone = dVar.clone();
            Intrinsics.checkNotNullExpressionValue(clone, "it.clone()");
            clone.f264874d = (int) giftItem.getGiftSubId();
            clone.f264878f = ((int) giftItem.getGiftNum()) * clone.f264878f;
            Map<String, String> map2 = clone.M;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("batchSendCnt", String.valueOf(giftItem.getGiftNum()));
                hashMap.put("needBatchInfo", "true");
                map = hashMap;
            } else {
                map2.put("batchSendCnt", String.valueOf(giftItem.getGiftNum()));
                map2.put("needBatchInfo", "true");
                map = map2;
            }
            clone.M = map;
            return clone;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        BatchGiftView batchGiftView = this.multiGiftView;
        if (batchGiftView != null) {
            batchGiftView.e();
        }
    }

    private final void m(d sendGiftServiceData) {
        long j3 = this.curMarketingBalance;
        if (j3 >= 0) {
            this.curMarketingBalance = j3 - sendGiftServiceData.f264878f;
        }
        if (this.curMarketingBalance < 0) {
            this.curMarketingBalance = 0L;
            long j16 = this.curBalance - sendGiftServiceData.f264878f;
            this.curBalance = j16;
            if (j16 <= 0) {
                this.curBalance = 0L;
                l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        uw0.a.k(new vw0.a(this.qqGiftBalanceCallback));
    }

    private final void o(d sendGiftServiceData, int curNum, int curAllNum, long curSeq) {
        if (sendGiftServiceData != null) {
            this.curComboNum = 0;
            this.curBatchGiftData = sendGiftServiceData;
            uw0.a.s(this.hostActivity, this.curBalance, this.curMarketingBalance, this.sendGiftCallback, curNum, curAllNum, curSeq, sendGiftServiceData);
            m(sendGiftServiceData);
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void a(@Nullable xv0.a batchBean, int position) {
        if (batchBean != null) {
            uw0.a.t(i(batchBean), this.curComboSeq, this.lastComboNum, this.lastAllComboNum);
            this.curComboNum = 0;
            this.curComboSeq = 0L;
            this.lastComboNum = 0;
            this.lastAllComboNum = 0;
        }
        n();
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void b(@Nullable xv0.a batchBean, long curSeq, int position) {
        long j3;
        int i3;
        int i16;
        boolean z16;
        fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
        Long l3 = this.roomId;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        IAudienceRoom N = cVar.N(j3);
        if (N != null && !N.isQQAnchor()) {
            rt0.a.INSTANCE.q("ICGameGift|BatchGiftPendant", "handlerGiftEntrance", "anchor is not QQAnchor");
            vt0.b.INSTANCE.a().a("\u5916\u90e8\u5185\u5bb9\u6e90\u623f\u95f4\u4e0d\u652f\u6301\u9001\u793c", 0, this.hostActivity);
            return;
        }
        this.curComboNum++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastSendTime > 1000) {
            this.lastSendTime = currentTimeMillis;
            this.curComboSeq = curSeq;
            int i17 = this.lastAllComboNum;
            int i18 = this.curComboNum;
            this.lastAllComboNum = i17 + i18;
            this.lastComboNum = i18;
            if (batchBean != null) {
                o(i(batchBean), this.curComboNum, this.lastAllComboNum, this.curComboSeq);
            }
        }
        wv0.b bVar = wv0.b.f446564a;
        d dVar = this.curGiftServiceData;
        if (dVar != null) {
            i3 = dVar.f264874d;
        } else {
            i3 = 0;
        }
        if (batchBean != null) {
            i16 = (int) batchBean.getGiftSubId();
        } else {
            i16 = 0;
        }
        int i19 = this.selfInvokeSource;
        int i26 = this.lastAllComboNum;
        if (i26 > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar.c(i3, i16, i19, z16, i26);
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void c(@Nullable xv0.a batchBean, int position) {
        if (batchBean != null) {
            uw0.a.t(i(batchBean), this.curComboSeq, this.lastComboNum, this.lastAllComboNum);
            this.curComboNum = 0;
            this.curComboSeq = 0L;
            this.lastComboNum = 0;
            this.lastAllComboNum = 0;
        }
        n();
    }

    public final void j(@NotNull Activity activity, long roomId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.hostActivity = activity;
        this.roomId = Long.valueOf(roomId);
        n();
    }

    public final boolean k() {
        BatchGiftView batchGiftView = this.multiGiftView;
        if (batchGiftView == null || batchGiftView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final void p(@Nullable d data, @Nullable ViewGroup containerView, int invokeSource) {
        if (this.multiGiftView == null) {
            BatchGiftView batchGiftView = new BatchGiftView(this.hostActivity);
            this.multiGiftView = batchGiftView;
            batchGiftView.g();
            BatchGiftView batchGiftView2 = this.multiGiftView;
            if (batchGiftView2 != null) {
                batchGiftView2.setItemClickListener(this);
            }
            if (containerView != null) {
                containerView.addView(this.multiGiftView);
            }
        }
        if (data != null) {
            this.selfInvokeSource = invokeSource;
            this.curGiftServiceData = data;
            BatchGiftView batchGiftView3 = this.multiGiftView;
            if (batchGiftView3 != null) {
                batchGiftView3.i(data);
            }
            BatchGiftView batchGiftView4 = this.multiGiftView;
            if (batchGiftView4 != null) {
                batchGiftView4.setVisibility(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean q(@Nullable d data) {
        boolean z16;
        Integer num;
        if (k()) {
            d dVar = this.curGiftServiceData;
            if (dVar != null) {
                Integer valueOf = Integer.valueOf(dVar.f264874d);
                if (data != null) {
                    num = Integer.valueOf(data.f264874d);
                } else {
                    num = null;
                }
                if (valueOf.equals(num)) {
                    z16 = true;
                    if (z16) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        BatchGiftView batchGiftView = this.multiGiftView;
        if (batchGiftView != null) {
            batchGiftView.setVisibility(8);
        }
        this.curGiftServiceData = null;
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"wv0/a$c", "Luw0/a$d;", "", "errCode", "", "errMsg", "", "a", "e", "b", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "c", "d", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements a.d {
        c() {
        }

        @Override // uw0.a.d
        public void a(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.l();
        }

        @Override // uw0.a.d
        public void b(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.l();
            a.this.n();
        }

        @Override // uw0.a.d
        public void e(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.l();
            a.this.n();
        }

        @Override // uw0.a.d
        public void c(@Nullable d giftServiceData) {
        }

        @Override // uw0.a.d
        public void d(@Nullable d giftServiceData) {
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void d(@Nullable xv0.a batchBean, int position) {
    }
}
