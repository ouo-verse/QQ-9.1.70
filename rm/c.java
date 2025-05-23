package rm;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.qzone.reborn.publicaccount.g;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$BottomMenu;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$MenuItem;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.contentbox.FootNavigationLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lrm/c;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$BottomMenu;", "bottomMenu", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcooperation/qzone/contentbox/FootNavigationLayout;", "d", "Lcooperation/qzone/contentbox/FootNavigationLayout;", "mFootNavigationLayout", "Lcom/qzone/reborn/publicaccount/g;", "e", "Lcom/qzone/reborn/publicaccount/g;", "mAioMsgListViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FootNavigationLayout mFootNavigationLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private g mAioMsgListViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(c this$0, QZoneOfficialAccountBase$BottomMenu qZoneOfficialAccountBase$BottomMenu) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9(qZoneOfficialAccountBase$BottomMenu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(c this$0, List dataList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        FootNavigationLayout footNavigationLayout = this$0.mFootNavigationLayout;
        if (footNavigationLayout != null) {
            footNavigationLayout.updateData((List<QZoneOfficialAccountBase$MenuItem>) dataList);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        MutableLiveData<QZoneOfficialAccountBase$BottomMenu> Q1;
        super.onInitView(rootView);
        this.mAioMsgListViewModel = (g) getViewModel(g.class);
        View findViewById = rootView != null ? rootView.findViewById(R.id.f162903n83) : null;
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type cooperation.qzone.contentbox.FootNavigationLayout");
        FootNavigationLayout footNavigationLayout = (FootNavigationLayout) findViewById;
        this.mFootNavigationLayout = footNavigationLayout;
        Intrinsics.checkNotNull(footNavigationLayout);
        footNavigationLayout.setArrowVisible(8);
        FootNavigationLayout footNavigationLayout2 = this.mFootNavigationLayout;
        Intrinsics.checkNotNull(footNavigationLayout2);
        footNavigationLayout2.setNightMode(QQTheme.isNowThemeIsNightForQzone());
        g gVar = this.mAioMsgListViewModel;
        if (gVar != null && (Q1 = gVar.Q1()) != null) {
            Q1.observe(getHostFragment(), new Observer() { // from class: rm.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    c.E9(c.this, (QZoneOfficialAccountBase$BottomMenu) obj);
                }
            });
        }
        F9(null);
    }

    private final void F9(QZoneOfficialAccountBase$BottomMenu bottomMenu) {
        final List<QZoneOfficialAccountBase$MenuItem> list;
        if (bottomMenu == null) {
            list = new ArrayList<>();
            QZoneOfficialAccountBase$MenuItem qZoneOfficialAccountBase$MenuItem = new QZoneOfficialAccountBase$MenuItem();
            qZoneOfficialAccountBase$MenuItem.menu_type.set(1);
            qZoneOfficialAccountBase$MenuItem.caption.set("\u8fdb\u5165QQ\u7a7a\u95f4");
            qZoneOfficialAccountBase$MenuItem.jump_url.set("mqqzone://arouse/activefeed");
            list.add(qZoneOfficialAccountBase$MenuItem);
        } else {
            list = bottomMenu.menu_list.get();
            Intrinsics.checkNotNullExpressionValue(list, "bottomMenu.menu_list.get()");
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: rm.b
            @Override // java.lang.Runnable
            public final void run() {
                c.G9(c.this, list);
            }
        });
    }
}
