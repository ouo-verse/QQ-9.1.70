package ul4;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.profile.impl.view.SexAtView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020\u0005\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lul4/d;", "Lul4/q;", "", "Q1", "P1", "", IProfileProtocolConst.PARAM_IS_FRIEND, "M1", "init", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "listener", "S1", "G0", "Z", "isVoiceRoom", "Lrl4/a;", "H0", "Lrl4/a;", "clickListener", "Lxl4/c;", "I0", "Lxl4/c;", "profileCPDDReport", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "", "reportParamMap", "", "roomId", "isCaptain", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;ZLjava/util/Map;JZ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d extends q {

    /* renamed from: G0, reason: from kotlin metadata */
    private final boolean isVoiceRoom;

    /* renamed from: H0, reason: from kotlin metadata */
    @Nullable
    private rl4.a clickListener;

    /* renamed from: I0, reason: from kotlin metadata */
    @Nullable
    private xl4.c profileCPDDReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ul4/d$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
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
                    rl4.a aVar = d.this.clickListener;
                    if (aVar != null) {
                        aVar.b(d.this);
                    }
                    d.this.dismiss();
                } else if (id5 == R.id.zzo) {
                    rl4.a aVar2 = d.this.clickListener;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    d.this.dismiss();
                } else if (id5 == R.id.zzv) {
                    rl4.a aVar3 = d.this.clickListener;
                    if (aVar3 != null) {
                        aVar3.d();
                    }
                } else if (id5 == R.id.zzw) {
                    d.this.N0();
                    d.this.dismiss();
                } else if (id5 == R.id.zzu) {
                    d.this.M0();
                    d.this.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ul4/d$b", "Lcom/tencent/mobileqq/newnearby/INearbyAddFriendHelper$c;", "", "result", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements INearbyAddFriendHelper.c {
        b() {
        }

        @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper.c
        public void a(boolean result) {
            d.this.M1(result);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, boolean z16, @NotNull Map<String, String> reportParamMap, long j3, boolean z17) {
        super(activity, userId, true, z17, reportParamMap, Long.valueOf(j3), true, "pg_kl_smoba_cpdd", 0, 256, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        this.isVoiceRoom = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(boolean isFriend) {
        TextView Q0 = Q0(y0(isFriend), -16777216, Color.parseColor("#EBEDF5"));
        Q0.setOnClickListener(new View.OnClickListener() { // from class: ul4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.N1(d.this, view);
            }
        });
        if (!isFriend) {
            TextView Q02 = Q0(R.string.f2312371a, -1, Color.parseColor("#00CAFC"));
            Q02.setOnClickListener(new View.OnClickListener() { // from class: ul4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.O1(d.this, view);
                }
            });
            K0(Q0, Q02);
            xl4.c cVar = this.profileCPDDReport;
            if (cVar != null) {
                cVar.c(Q02);
            }
            z1(isFriend, Q02);
        } else {
            K0(Q0);
        }
        xl4.c cVar2 = this.profileCPDDReport;
        if (cVar2 != null) {
            cVar2.m(Q0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(d this$0, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            bm4.a aVar = (bm4.a) mm4.b.b(bm4.a.class);
            QBaseActivity qBaseActivity = this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
            String valueOf = String.valueOf(this$0.getUserId().uid.get());
            if (this$0.isVoiceRoom) {
                i3 = 303;
            } else {
                i3 = 302;
            }
            aVar.Q(qBaseActivity, valueOf, i3, this$0.getUserId());
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            if (this$0.isVoiceRoom) {
                ((bm4.a) mm4.b.b(bm4.a.class)).B3(this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), String.valueOf(this$0.getUserId().uid.get()), this$0.F0(), this$0.getUserId(), this$0.A0());
            } else {
                ((bm4.a) mm4.b.b(bm4.a.class)).z2(this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), String.valueOf(this$0.getUserId().uid.get()), this$0.F0(), this$0.getUserId(), this$0.A0());
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P1() {
        xl4.c cVar;
        View H0 = H0();
        if (H0 != null && (cVar = this.profileCPDDReport) != null) {
            cVar.f(H0);
        }
    }

    private final void Q1() {
        a aVar = new a();
        View operationPanel = LayoutInflater.from(this.G).inflate(R.layout.hvt, (ViewGroup) null);
        View findViewById = operationPanel.findViewById(R.id.zzm);
        if (findViewById != null) {
            findViewById.setOnClickListener(aVar);
        }
        View findViewById2 = operationPanel.findViewById(R.id.zzr);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: ul4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.R1(d.this, view);
                }
            });
        }
        View findViewById3 = operationPanel.findViewById(R.id.zzo);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(aVar);
        }
        View findViewById4 = operationPanel.findViewById(R.id.zzv);
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(aVar);
        }
        SexAtView sexAtView = (SexAtView) operationPanel.findViewById(R.id.zzm);
        if (sexAtView != null) {
            sexAtView.setUserId(getUserId());
        }
        SexAtView sexAtView2 = (SexAtView) operationPanel.findViewById(R.id.zzm);
        if (sexAtView2 != null) {
            sexAtView2.setEnableBold(true);
        }
        TextView textView = (TextView) operationPanel.findViewById(R.id.zzw);
        if (textView != null) {
            P0(textView);
            textView.setOnClickListener(aVar);
        }
        TextView textView2 = (TextView) operationPanel.findViewById(R.id.zzu);
        if (textView2 != null) {
            O0(textView2);
            textView2.setOnClickListener(aVar);
        }
        View findViewById5 = operationPanel.findViewById(R.id.zzx);
        if (findViewById5 != null) {
            fh4.g.f(findViewById5, fh4.b.b(10), Color.parseColor("#80F5F5F5"));
        }
        View findViewById6 = operationPanel.findViewById(R.id.zzy);
        if (findViewById6 != null) {
            fh4.g.f(findViewById6, fh4.b.b(10), Color.parseColor("#80F5F5F5"));
        }
        Intrinsics.checkNotNullExpressionValue(operationPanel, "operationPanel");
        J0(operationPanel);
        xl4.c cVar = this.profileCPDDReport;
        if (cVar != null) {
            cVar.d(operationPanel.findViewById(R.id.zzm));
            cVar.g(operationPanel.findViewById(R.id.zzo));
            cVar.i(operationPanel.findViewById(R.id.zzr));
            cVar.j(operationPanel.findViewById(R.id.zzw));
            cVar.h(operationPanel.findViewById(R.id.zzu));
        }
        v1(operationPanel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.timi.game.utils.o.a()) {
            com.tencent.timi.game.utils.l.e("CPDDProfileDialog", "kaiheiClick double clicked!");
        } else {
            rl4.a aVar = this$0.clickListener;
            if (aVar != null) {
                aVar.c(this$0);
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void S1(@Nullable Object listener) {
        if (listener instanceof rl4.a) {
            this.clickListener = (rl4.a) listener;
        }
    }

    @Override // ul4.q
    public void init() {
        ql4.b.f429064a.a(this, "pg_kl_smoba_cpdd");
        this.profileCPDDReport = new xl4.c(T0());
        if (!getIsMaster()) {
            Q1();
            f1(new b());
        } else {
            P1();
        }
        xl4.c cVar = this.profileCPDDReport;
        if (cVar != null) {
            cVar.e(getCloseButton(), getIsMaster());
        }
        xl4.c cVar2 = this.profileCPDDReport;
        if (cVar2 != null) {
            cVar2.k(getReportButton());
        }
        xl4.c cVar3 = this.profileCPDDReport;
        if (cVar3 != null) {
            cVar3.l(getRoleInfoFrame());
        }
    }

    @Override // ul4.q, android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        super.onClick(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }
}
