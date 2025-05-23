package ul4;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lul4/f;", "Lul4/q;", "", "J1", "K1", "init", "", "listener", "M1", "Lrl4/b;", "G0", "Lrl4/b;", "clickListener", "Lxl4/d;", "H0", "Lxl4/d;", "profileCommunityReport", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "", "reportParamMap", "", "roomId", "", "isCaptain", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;Ljava/util/Map;JZ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f extends q {

    /* renamed from: G0, reason: from kotlin metadata */
    @Nullable
    private rl4.b clickListener;

    /* renamed from: H0, reason: from kotlin metadata */
    @Nullable
    private xl4.d profileCommunityReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ul4/f$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
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
                    rl4.b bVar = f.this.clickListener;
                    if (bVar != null) {
                        bVar.b(f.this);
                    }
                    f.this.dismiss();
                } else if (id5 == R.id.zzo) {
                    rl4.b bVar2 = f.this.clickListener;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    f.this.dismiss();
                } else if (id5 == R.id.zzw) {
                    f.this.N0();
                    f.this.dismiss();
                } else if (id5 == R.id.zzu) {
                    f.this.M0();
                    f.this.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, @NotNull Map<String, String> reportParamMap, long j3, boolean z16) {
        super(activity, userId, true, z16, reportParamMap, Long.valueOf(j3), true, "pg_sgrp_smoba_cpdd", 0, 256, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
    }

    private final void J1() {
        xl4.d dVar;
        View H0 = H0();
        if (H0 != null && (dVar = this.profileCommunityReport) != null) {
            dVar.f(H0);
        }
    }

    private final void K1() {
        a aVar = new a();
        View operationPanel = LayoutInflater.from(this.G).inflate(R.layout.hvt, (ViewGroup) null);
        View findViewById = operationPanel.findViewById(R.id.zzy);
        if (findViewById != null) {
            fh4.g.f(findViewById, fh4.b.b(10), Color.parseColor("#80F5F5F5"));
        }
        View findViewById2 = operationPanel.findViewById(R.id.zzr);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: ul4.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.L1(f.this, view);
                }
            });
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
        View findViewById3 = operationPanel.findViewById(R.id.zzm);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(aVar);
        }
        View findViewById4 = operationPanel.findViewById(R.id.zzo);
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
        Intrinsics.checkNotNullExpressionValue(operationPanel, "operationPanel");
        J0(operationPanel);
        xl4.d dVar = this.profileCommunityReport;
        if (dVar != null) {
            dVar.d(operationPanel.findViewById(R.id.zzm));
        }
        xl4.d dVar2 = this.profileCommunityReport;
        if (dVar2 != null) {
            dVar2.g(operationPanel.findViewById(R.id.zzo));
        }
        xl4.d dVar3 = this.profileCommunityReport;
        if (dVar3 != null) {
            dVar3.i(operationPanel.findViewById(R.id.zzr));
        }
        xl4.d dVar4 = this.profileCommunityReport;
        if (dVar4 != null) {
            dVar4.j(operationPanel.findViewById(R.id.zzw));
        }
        v1(operationPanel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.timi.game.utils.o.a()) {
            com.tencent.timi.game.utils.l.e("CPDDProfileDialog", "kaiheiClick double clicked!");
        } else {
            rl4.b bVar = this$0.clickListener;
            if (bVar != null) {
                bVar.c(this$0);
            }
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void M1(@Nullable Object listener) {
        if (listener instanceof rl4.b) {
            this.clickListener = (rl4.b) listener;
        }
    }

    @Override // ul4.q
    public void init() {
        ql4.b.f429064a.a(this, "pg_sgrp_smoba_cpdd");
        this.profileCommunityReport = new xl4.d(T0());
        if (!getIsMaster()) {
            K1();
        } else {
            J1();
        }
        xl4.d dVar = this.profileCommunityReport;
        if (dVar != null) {
            dVar.e(getCloseButton(), getIsMaster());
        }
        xl4.d dVar2 = this.profileCommunityReport;
        if (dVar2 != null) {
            dVar2.k(getReportButton());
        }
        xl4.d dVar3 = this.profileCommunityReport;
        if (dVar3 != null) {
            dVar3.l(getRoleInfoFrame());
        }
    }
}
