package ul4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.profile.impl.view.SexAtView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\u0016\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0&\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006,"}, d2 = {"Lul4/i;", "Lul4/q;", "", "L1", "", "P1", IProfileProtocolConst.PARAM_IS_FRIEND, "M1", "init", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "L0", "", "x0", "", "listener", "Q1", "Lrl4/c;", "G0", "Lrl4/c;", "clickListener", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "H0", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "getSelfQQUserId", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "R1", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;)V", "selfQQUserId", "Lxl4/e;", "I0", "Lxl4/e;", "profileFleetReport", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "userId", "isCaptain", "", "reportParamMap", "", "roomId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;ZLjava/util/Map;J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i extends q {

    /* renamed from: G0, reason: from kotlin metadata */
    @Nullable
    private rl4.c clickListener;

    /* renamed from: H0, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId selfQQUserId;

    /* renamed from: I0, reason: from kotlin metadata */
    @Nullable
    private xl4.e profileFleetReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ul4/i$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            if (!com.tencent.timi.game.utils.o.a()) {
                int id5 = v3.getId();
                if (id5 == R.id.zzm) {
                    rl4.c cVar = i.this.clickListener;
                    if (cVar != null) {
                        cVar.b(i.this);
                    }
                    i.this.dismiss();
                } else if (id5 == R.id.zzw) {
                    rl4.c cVar2 = i.this.clickListener;
                    if (cVar2 != null) {
                        cVar2.c(i.this);
                    }
                } else if (id5 == R.id.zzo) {
                    rl4.c cVar3 = i.this.clickListener;
                    if (cVar3 != null) {
                        cVar3.a();
                    }
                    i.this.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ul4/i$b", "Lcom/tencent/mobileqq/newnearby/INearbyAddFriendHelper$c;", "", "result", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements INearbyAddFriendHelper.c {
        b() {
        }

        @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper.c
        public void a(boolean result) {
            i.this.M1(result);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, boolean z16, @NotNull Map<String, String> reportParamMap, long j3) {
        super(activity, userId, false, z16, reportParamMap, Long.valueOf(j3), false, "pg_yes_smoba_team", 0, 256, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
    }

    private final boolean L1() {
        int i3;
        gm4.c K0;
        YoloRoomOuterClass$YoloRoomInfo roomInfo;
        YoloRoomOuterClass$YoloRoomDataInfo yoloRoomOuterClass$YoloRoomDataInfo;
        PBInt32Field pBInt32Field;
        Long roomId = getRoomId();
        if (roomId == null) {
            return false;
        }
        long longValue = roomId.longValue();
        fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
        if (gVar != null && (K0 = gVar.K0(longValue)) != null && (roomInfo = K0.getRoomInfo()) != null && (yoloRoomOuterClass$YoloRoomDataInfo = roomInfo.room_data_info) != null && (pBInt32Field = yoloRoomOuterClass$YoloRoomDataInfo.sub_create_from) != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = -1;
        }
        if (i3 != 0 && i3 != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(boolean isFriend) {
        if (!getIsMaster()) {
            if (L1() && !isFriend) {
                TextView Q0 = Q0(R.string.f2312371a, -1, Color.parseColor("#00CAFC"));
                Q0.setOnClickListener(new View.OnClickListener() { // from class: ul4.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        i.N1(i.this, view);
                    }
                });
                K0(Q0);
                xl4.e eVar = this.profileFleetReport;
                if (eVar != null) {
                    eVar.c(Q0);
                }
                z1(isFriend, Q0);
                return;
            }
            return;
        }
        TextView Q02 = Q0(R.string.f2313071h, -16777216, Color.parseColor("#EBEDF5"));
        Q02.setOnClickListener(new View.OnClickListener() { // from class: ul4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.O1(i.this, view);
            }
        });
        K0(Q02);
        xl4.e eVar2 = this.profileFleetReport;
        if (eVar2 != null) {
            eVar2.n(Q02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            if (this$0.selfQQUserId != null) {
                bm4.a aVar = (bm4.a) mm4.b.b(bm4.a.class);
                QBaseActivity qBaseActivity = this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = this$0.selfQQUserId;
                Intrinsics.checkNotNull(commonOuterClass$QQUserId);
                aVar.k0(qBaseActivity, commonOuterClass$QQUserId, String.valueOf(this$0.getUserId().uid.get()), this$0.F0(), this$0.getUserId(), this$0.A0());
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(i this$0, View view) {
        rl4.c cVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a() && (cVar = this$0.clickListener) != null) {
            cVar.d(this$0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P1() {
        boolean z16;
        a aVar = new a();
        boolean i16 = i1();
        View operationPanel = LayoutInflater.from(this.G).inflate(R.layout.hvt, (ViewGroup) null);
        View findViewById = operationPanel.findViewById(R.id.yii);
        if (findViewById != null) {
            fh4.g.o(findViewById, getIsCaptain());
        }
        View findViewById2 = operationPanel.findViewById(R.id.zzw);
        if (findViewById2 != null) {
            if (getIsCaptain() && i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            fh4.g.o(findViewById2, z16);
        }
        View findViewById3 = operationPanel.findViewById(R.id.zzx);
        if (findViewById3 != null) {
            fh4.g.f(findViewById3, fh4.b.b(10), Color.parseColor("#80F5F5F5"));
        }
        View findViewById4 = operationPanel.findViewById(R.id.zzy);
        if (findViewById4 != null) {
            fh4.g.f(findViewById4, fh4.b.b(10), Color.parseColor("#80F5F5F5"));
        }
        View findViewById5 = operationPanel.findViewById(R.id.zzw);
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(aVar);
        }
        View findViewById6 = operationPanel.findViewById(R.id.zzr);
        if (findViewById6 != null) {
            fh4.g.o(findViewById6, false);
        }
        View findViewById7 = operationPanel.findViewById(R.id.zzt);
        if (findViewById7 != null) {
            fh4.g.o(findViewById7, false);
        }
        View findViewById8 = operationPanel.findViewById(R.id.zzm);
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(aVar);
        }
        View findViewById9 = operationPanel.findViewById(R.id.zzo);
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(aVar);
        }
        SexAtView sexAtView = (SexAtView) operationPanel.findViewById(R.id.zzm);
        if (sexAtView != null) {
            sexAtView.setUserId(getUserId());
        }
        SexAtView sexAtView2 = (SexAtView) operationPanel.findViewById(R.id.zzm);
        if (sexAtView2 != null) {
            sexAtView2.setEnableBold(true);
        }
        Intrinsics.checkNotNullExpressionValue(operationPanel, "operationPanel");
        J0(operationPanel);
        xl4.e eVar = this.profileFleetReport;
        if (eVar != null) {
            eVar.d(operationPanel.findViewById(R.id.zzm));
        }
        xl4.e eVar2 = this.profileFleetReport;
        if (eVar2 != null) {
            eVar2.g(operationPanel.findViewById(R.id.zzo));
        }
        xl4.e eVar3 = this.profileFleetReport;
        if (eVar3 != null) {
            eVar3.m(operationPanel.findViewById(R.id.zzw));
        }
        v1(operationPanel);
    }

    @Override // ul4.q
    public boolean L0() {
        return false;
    }

    public void Q1(@Nullable Object listener) {
        if (listener instanceof rl4.c) {
            this.clickListener = (rl4.c) listener;
        }
    }

    public final void R1(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.selfQQUserId = commonOuterClass$QQUserId;
    }

    @Override // ul4.q
    public void init() {
        r1();
        this.profileFleetReport = new xl4.e(T0());
        if (!getIsMaster()) {
            P1();
        }
        f1(new b());
        xl4.e eVar = this.profileFleetReport;
        if (eVar != null) {
            eVar.e(getCloseButton(), getIsMaster());
        }
        xl4.e eVar2 = this.profileFleetReport;
        if (eVar2 != null) {
            eVar2.k(getReportButton());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ul4.q, com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ql4.b.f429064a.a(this, "pg_yes_smoba_team");
    }

    @Override // ul4.q
    @NotNull
    public String x0() {
        return "\u5df2\u5728\u8f66\u961f\u65f6\u65e0\u6cd5\u8fdb\u884c\u89d2\u8272\u5207\u6362";
    }
}
