package yi4;

import android.app.Activity;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView;
import com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pk4.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0002&'B\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000e\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fJ\"\u0010\u001b\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\"\u0010!\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010 \u001a\u00020\tH\u0016J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"J\"\u0010%\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010 \u001a\u00020\tH\u0016J\u001a\u0010&\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\tH\u0016J\u001a\u0010'\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\tH\u0016J\u001a\u0010(\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\tH\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00104R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R\u0016\u0010=\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00104R\u0016\u0010?\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00108R\u0016\u0010A\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00108R\u0018\u0010C\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010,R\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00108R\u0018\u0010F\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lyi4/a;", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/a;", "giftItem", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "j", "", "p", "sendGiftServiceData", "", "curNum", "curAllNum", "", "curSeq", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "o", "giftData", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "roomId", "l", "data", "Landroid/view/ViewGroup;", "containerView", "invokeSource", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "batchBean", "position", "c", "Lyi4/a$b;", "listener", "r", "e", "a", "b", "d", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftView;", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftView;", "multiGiftView", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "curGiftServiceData", "f", "Landroid/app/Activity;", "hostActivity", h.F, "Ljava/lang/Long;", "i", "J", "curBalance", "curMarketingBalance", BdhLogUtil.LogTag.Tag_Conn, "I", "curComboNum", "D", "curComboSeq", "E", "lastSendTime", UserInfo.SEX_FEMALE, "lastComboNum", "G", "lastAllComboNum", "H", "curBatchGiftData", "selfInvokeSource", "Lyi4/a$b;", "giftPanelInterface", "Lpk4/b$k;", "K", "Lpk4/b$k;", "sendGiftCallback", "Lrh2/a;", "L", "Lrh2/a;", "qqGiftBalanceCallback", "<init>", "()V", "M", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
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
    private com.tencent.mobileqq.qqgift.data.service.d curBatchGiftData;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private b giftPanelInterface;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BatchGiftView multiGiftView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqgift.data.service.d curGiftServiceData;

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

    /* renamed from: I, reason: from kotlin metadata */
    private int selfInvokeSource = 1;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b.k sendGiftCallback = new d();

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final rh2.a qqGiftBalanceCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lyi4/a$b;", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "actionedGiftInfo", "", "curComboSeq", "", "lastComboNum", "lastAllComboNum", "", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void b(@Nullable com.tencent.mobileqq.qqgift.data.service.d actionedGiftInfo, long curComboSeq, int lastComboNum, int lastAllComboNum);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"yi4/a$c", "Lrh2/a;", "", "balance", "marketingBalance", "seq", "", "firstSave", "", h.F, "errCode", "", "errMsg", "onFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements rh2.a {
        c() {
        }

        @Override // rh2.a
        public void h(long balance, long marketingBalance, long seq, int firstSave) {
            AegisLogger.INSTANCE.i("Gift|BatchGiftPendant", "IQQGiftBalanceCallback.onReceive", "requestBalance success, balance=" + balance + ", seq=" + seq);
            a.this.curBalance = balance;
            a.this.curMarketingBalance = marketingBalance;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            AegisLogger.INSTANCE.i("Gift|BatchGiftPendant", "IQQGiftBalanceCallback.onFailed", "requestBalance fail, errCode=" + errCode + ", errMsg=" + errMsg);
        }
    }

    private final com.tencent.mobileqq.qqgift.data.service.d j(com.tencent.timi.game.liveroom.impl.room.batchgift.view.a giftItem) {
        Map<String, String> map;
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.curGiftServiceData;
        if (dVar != null) {
            com.tencent.mobileqq.qqgift.data.service.d clone = dVar.clone();
            Intrinsics.checkNotNullExpressionValue(clone, "it.clone()");
            if (giftItem.getGiftNum() > 0 && giftItem.getIsEffect()) {
                clone.f264883i = 1;
            }
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

    private final int k(com.tencent.mobileqq.qqgift.data.service.d giftData) {
        Object value;
        int i3;
        Map<String, String> map = giftData.M;
        if (map != null && !map.isEmpty()) {
            if (map.containsKey("batchSendCnt")) {
                value = MapsKt__MapsKt.getValue(map, "batchSendCnt");
                String str = (String) value;
                if (str != null) {
                    i3 = Integer.parseInt(str);
                } else {
                    i3 = 1;
                }
                int max = giftData.f264878f * Math.max(i3, 1);
                AegisLogger.INSTANCE.i("Gift|BatchGiftPendant", "getSingleClickPrice", "batchCnt: " + i3 + ", singleClickPrice: " + max);
                return giftData.f264878f * max;
            }
            return giftData.f264878f;
        }
        return giftData.f264878f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        BatchGiftView batchGiftView = this.multiGiftView;
        if (batchGiftView != null) {
            batchGiftView.f();
        }
    }

    private final void o(com.tencent.mobileqq.qqgift.data.service.d sendGiftServiceData) {
        int k3 = k(sendGiftServiceData);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.w("Gift|BatchGiftPendant", "preDealBalance", "do preDealBalance while giftData is: giftId: " + sendGiftServiceData.f264874d + ",  giftName: " + sendGiftServiceData.f264876e + ",  giftPrice: " + sendGiftServiceData.f264878f + ", singleClickPrice: " + k3);
        long j3 = this.curMarketingBalance;
        if (j3 >= 0) {
            this.curMarketingBalance = j3 - k3;
        }
        if (this.curMarketingBalance < 0) {
            this.curMarketingBalance = 0L;
            long j16 = this.curBalance - k3;
            this.curBalance = j16;
            if (j16 <= 0) {
                this.curBalance = 0L;
                companion.w("Gift|BatchGiftPendant", "preDealBalance", "blance not enough, close comboView");
                n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        pk4.b.t(new rk4.a(this.qqGiftBalanceCallback));
    }

    private final void q(com.tencent.mobileqq.qqgift.data.service.d sendGiftServiceData, int curNum, int curAllNum, long curSeq) {
        if (sendGiftServiceData != null) {
            this.curComboNum = 0;
            this.curBatchGiftData = sendGiftServiceData;
            AegisLogger.INSTANCE.w("Gift|BatchGiftPendant", "sendGift", "sendComboGift sendGift, curSeq=" + curSeq + ", curNum=" + curNum + ", curAllNum=" + curAllNum);
            pk4.b.J(this.hostActivity, this.curBalance, this.curMarketingBalance, this.sendGiftCallback, curNum, curAllNum, curSeq, this.curBatchGiftData);
            o(sendGiftServiceData);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void b(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, int position) {
        if (batchBean != null) {
            AegisLogger.INSTANCE.w("Gift|BatchGiftPendant", "onAnimationEnd", "comboOver onAnimationEnd, curComboSeq=" + this.curComboSeq + ", lastComboNum=" + this.lastComboNum + ", lastAllComboNum=" + this.lastAllComboNum);
            pk4.b.K(j(batchBean), this.curComboSeq, this.lastComboNum, this.lastAllComboNum, this.curBalance);
            this.curComboNum = 0;
            this.curComboSeq = 0L;
            this.lastComboNum = 0;
            this.lastAllComboNum = 0;
        }
        p();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void c(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, long curSeq, int position) {
        long j3;
        int i3;
        int i16;
        boolean z16;
        SailAudienceRoomManager m3 = com.tencent.mobileqq.qqlive.sail.c.f272176a.m();
        Long l3 = this.roomId;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        e t16 = SailAudienceRoomManager.t(m3, j3, 0, 2, null);
        if (t16 != null && !t16.b().y()) {
            AegisLogger.INSTANCE.w("Gift|BatchGiftPendant", "handlerGiftEntrance", "anchor is not QQAnchor");
            gt3.a.INSTANCE.a().a("\u5916\u90e8\u5185\u5bb9\u6e90\u623f\u95f4\u4e0d\u652f\u6301\u9001\u793c", 0, this.hostActivity);
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
                q(j(batchBean), this.curComboNum, this.lastAllComboNum, this.curComboSeq);
            }
        }
        yi4.b bVar = yi4.b.f450450a;
        com.tencent.mobileqq.qqgift.data.service.d dVar = this.curGiftServiceData;
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

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void d(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, int position) {
        if (batchBean != null) {
            AegisLogger.INSTANCE.w("Gift|BatchGiftPendant", "onAnimationCancel", "comboOver onAnimationCancel, curComboSeq=" + this.curComboSeq + ", lastComboNum=" + this.lastComboNum + ", lastAllComboNum=" + this.lastAllComboNum);
            pk4.b.K(j(batchBean), this.curComboSeq, this.lastComboNum, this.lastAllComboNum, this.curBalance);
            this.curComboNum = 0;
            this.curComboSeq = 0L;
            this.lastComboNum = 0;
            this.lastAllComboNum = 0;
        }
        p();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public boolean e(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, long curSeq, int position) {
        long j3;
        boolean z16;
        if (batchBean != null) {
            j3 = batchBean.getGiftNum();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            if (batchBean != null && batchBean.getIsEffect()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.curComboSeq = curSeq;
                b bVar = this.giftPanelInterface;
                if (bVar != null) {
                    bVar.b(j(batchBean), this.curComboSeq, 1, 1);
                }
                return true;
            }
        }
        return false;
    }

    public final void l(@NotNull Activity activity, long roomId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.hostActivity = activity;
        this.roomId = Long.valueOf(roomId);
        p();
    }

    public final boolean m() {
        BatchGiftView batchGiftView = this.multiGiftView;
        if (batchGiftView == null || batchGiftView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final void r(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.giftPanelInterface = listener;
    }

    public final void s(@Nullable com.tencent.mobileqq.qqgift.data.service.d data, @Nullable ViewGroup containerView, int invokeSource) {
        if (this.multiGiftView == null) {
            BatchGiftView batchGiftView = new BatchGiftView(this.hostActivity);
            this.multiGiftView = batchGiftView;
            batchGiftView.h();
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
                batchGiftView3.j(data);
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
    public final boolean t(@Nullable com.tencent.mobileqq.qqgift.data.service.d data) {
        boolean z16;
        Integer num;
        if (m()) {
            com.tencent.mobileqq.qqgift.data.service.d dVar = this.curGiftServiceData;
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
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"yi4/a$d", "Lpk4/b$k;", "", "errCode", "", "errMsg", "", "a", "f", "e", "b", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "c", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements b.k {
        d() {
        }

        @Override // pk4.b.k
        public void a(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.n();
        }

        @Override // pk4.b.k
        public void b(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.n();
            a.this.p();
        }

        @Override // pk4.b.k
        public void e(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.n();
            a.this.p();
        }

        @Override // pk4.b.k
        public void f(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.n();
        }

        @Override // pk4.b.k
        public void c(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftServiceData) {
        }

        @Override // pk4.b.k
        public void d(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftServiceData) {
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void a(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, int position) {
    }
}
