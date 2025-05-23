package ul4;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lul4/m;", "Lul4/q;", "", IProfileProtocolConst.PARAM_IS_FRIEND, "", "K1", "init", "", "A0", "G0", "I", "subId", "H0", WadlProxyConsts.SCENE_ID, "I0", "Z", "showAddQQFriend", "Lxl4/c;", "J0", "Lxl4/c;", "profileReport", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", VirtualAppProxy.KEY_GAME_ID, "", "", "reportParamMap", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ltrpc/yes/common/CommonOuterClass$QQUserId;ILjava/util/Map;II)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class m extends q {

    /* renamed from: G0, reason: from kotlin metadata */
    private final int subId;

    /* renamed from: H0, reason: from kotlin metadata */
    private final int sceneId;

    /* renamed from: I0, reason: from kotlin metadata */
    private final boolean showAddQQFriend;

    /* renamed from: J0, reason: from kotlin metadata */
    @Nullable
    private xl4.c profileReport;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId userId, int i3, @NotNull Map<String, String> reportParamMap, int i16, int i17) {
        super(activity, userId, true, false, reportParamMap, 0L, false, "pg_yes_nearby_make_friend", i3);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(reportParamMap, "reportParamMap");
        this.subId = i16;
        this.sceneId = i17;
        this.showAddQQFriend = true;
    }

    private final void K1(boolean isFriend) {
        TextView Q0 = Q0(y0(isFriend), -16777216, Color.parseColor("#EBEDF5"));
        Q0.setOnClickListener(new View.OnClickListener() { // from class: ul4.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.L1(m.this, view);
            }
        });
        if (!isFriend && this.showAddQQFriend) {
            TextView Q02 = Q0(R.string.f2312371a, -1, Color.parseColor("#00CAFC"));
            Q02.setOnClickListener(new View.OnClickListener() { // from class: ul4.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.M1(m.this, view);
                }
            });
            K0(Q0, Q02);
            xl4.c cVar = this.profileReport;
            if (cVar != null) {
                cVar.c(Q02);
            }
            z1(isFriend, Q02);
        } else {
            K0(Q0);
        }
        xl4.c cVar2 = this.profileReport;
        if (cVar2 != null) {
            cVar2.m(Q0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            this$0.j1();
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            ((bm4.a) mm4.b.b(bm4.a.class)).w3(this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), String.valueOf(this$0.getUserId().uid.get()), this$0.F0(), this$0.getUserId(), this$0.A0(), this$0.subId, this$0.sceneId);
            this$0.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(m this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K1(z16);
    }

    @Override // ul4.q
    public int A0() {
        return getGameIdFromOuter();
    }

    @Override // ul4.q
    public void init() {
        ql4.b.f429064a.a(this, "pg_yes_nearby_make_friend");
        this.profileReport = new xl4.c(T0());
        if (!getIsMaster()) {
            f1(new INearbyAddFriendHelper.c() { // from class: ul4.j
                @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper.c
                public final void a(boolean z16) {
                    m.N1(m.this, z16);
                }
            });
        }
        xl4.c cVar = this.profileReport;
        if (cVar != null) {
            cVar.e(getCloseButton(), getIsMaster());
        }
        xl4.c cVar2 = this.profileReport;
        if (cVar2 != null) {
            cVar2.k(getReportButton());
        }
    }
}
