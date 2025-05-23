package sa2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.NearbyProFeedsBasePart;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.StatusFeedData;
import com.tencent.mobileqq.nearbypro.feedscheck.widgets.FeedsStatusListView;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import jb2.UserProfileData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B!\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b%\u0010&J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u000e\u00a8\u0006)"}, d2 = {"Lsa2/l;", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/NearbyProFeedsBasePart;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartResume", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", tl.h.F, "Ljava/lang/String;", "selectFeedId", "", "i", "Z", "isOnline", "()Z", "Lop4/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lop4/i;", "getStatusFeed", "()Lop4/i;", "statusFeed", "Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedsStatusListView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedsStatusListView;", "statusListView", "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "statusListLl", "E", "_selectFeedId", "<init>", "(Ljava/lang/String;ZLop4/i;)V", UserInfo.SEX_FEMALE, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class l extends NearbyProFeedsBasePart {

    /* renamed from: C, reason: from kotlin metadata */
    private FeedsStatusListView statusListView;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup statusListLl;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String _selectFeedId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selectFeedId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isOnline;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final op4.i statusFeed;

    public l(@NotNull String selectFeedId, boolean z16, @Nullable op4.i iVar) {
        Intrinsics.checkNotNullParameter(selectFeedId, "selectFeedId");
        this.selectFeedId = selectFeedId;
        this.isOnline = z16;
        this.statusFeed = iVar;
        this._selectFeedId = selectFeedId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(l this$0, List it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = it;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            s.c("\u52a8\u6001\u5217\u8868\u5f02\u5e38\u4e3a\u7a7a");
            this$0.z9().bh();
            return;
        }
        FeedsStatusListView feedsStatusListView = this$0.statusListView;
        if (feedsStatusListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusListView");
            feedsStatusListView = null;
        }
        RecyclerView.Adapter adapter = feedsStatusListView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.feedscheck.widgets.FeedsStatusListView.FeedsStatusAdapter");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ((FeedsStatusListView.b) adapter).s0(it, this$0._selectFeedId);
        this$0._selectFeedId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r3.getStatusFeedType() == 1) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void L9(l this$0, Integer it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.intValue() < 0) {
            return;
        }
        this$0.broadcastMessage("LIST_SELECT_ITEM_POSITION", it);
        FeedsStatusListView feedsStatusListView = this$0.statusListView;
        if (feedsStatusListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusListView");
            feedsStatusListView = null;
        }
        feedsStatusListView.scrollToPosition(it.intValue());
        List<StatusFeedData> value = this$0.E9().Z1().getValue();
        if (value != null && (r3 = value.get(it.intValue())) != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            this$0.broadcastMessage("SELECT_CURRENT_LOCATION_POS", 0);
        } else {
            this$0.broadcastMessage("SELECT_CURRENT_LOCATION_POS", 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(l this$0, UserProfileData userProfileData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isOnline) {
            this$0.E9().R1(userProfileData.getTinyId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(l this$0, xp4.h it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedsStatusListView feedsStatusListView = this$0.statusListView;
        if (feedsStatusListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusListView");
            feedsStatusListView = null;
        }
        RecyclerView.Adapter adapter = feedsStatusListView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.feedscheck.widgets.FeedsStatusListView.FeedsStatusAdapter");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ((FeedsStatusListView.b) adapter).r0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(l this$0, UserProfileData userProfileData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.nearbypro.feedscheck.basepart.g E9 = this$0.E9();
        String longToString = StringUtil.longToString(userProfileData.getTinyId());
        Intrinsics.checkNotNullExpressionValue(longToString, "longToString(it.tinyId)");
        E9.T1(longToString, this$0.isOnline, this$0.statusFeed);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.v4k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.feeds_status_list_ll)");
        this.statusListLl = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.v4l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.feeds_status_list_rv)");
        FeedsStatusListView feedsStatusListView = (FeedsStatusListView) findViewById2;
        this.statusListView = feedsStatusListView;
        FeedsStatusListView feedsStatusListView2 = null;
        if (feedsStatusListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusListView");
            feedsStatusListView = null;
        }
        feedsStatusListView.C(z9());
        E9().Z1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: sa2.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                l.K9(l.this, (List) obj);
            }
        });
        FeedsStatusListView feedsStatusListView3 = this.statusListView;
        if (feedsStatusListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusListView");
        } else {
            feedsStatusListView2 = feedsStatusListView3;
        }
        RecyclerView.Adapter adapter = feedsStatusListView2.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.feedscheck.widgets.FeedsStatusListView.FeedsStatusAdapter");
        ((FeedsStatusListView.b) adapter).n0().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: sa2.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                l.L9(l.this, (Integer) obj);
            }
        });
        ((com.tencent.mobileqq.nearbypro.profile.basepart.b) getViewModel(com.tencent.mobileqq.nearbypro.profile.basepart.b.class)).O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: sa2.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                l.M9(l.this, (UserProfileData) obj);
            }
        });
        E9().a2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: sa2.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                l.N9(l.this, (xp4.h) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        ((com.tencent.mobileqq.nearbypro.profile.basepart.b) getViewModel(com.tencent.mobileqq.nearbypro.profile.basepart.b.class)).O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: sa2.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                l.O9(l.this, (UserProfileData) obj);
            }
        });
    }
}
