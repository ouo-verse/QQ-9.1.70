package ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.base.l;
import com.qzone.reborn.groupalbum.viewmodel.al;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.GetAllAlbumListItem;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0014J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lui/e;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAllAlbumListItem;", "data", "", "position", "", "v", HippyTKDListViewAdapter.X, "Landroid/view/View;", "view", "", "groupId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroid/content/Context;", "context", "y", "", "getViewStubLayoutId", "containerView", "onInitView", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "e", "Ljava/lang/String;", "TAG", "f", "Landroid/view/View;", "myAlbumRootView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends l<GetAllAlbumListItem> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "GroupAlbumMyAlbumRootSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View myAlbumRootView;

    private final void v(final GetAllAlbumListItem data, int position) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        View view = this.myAlbumRootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.w(e.this, data, view2);
                }
            });
        }
        View view2 = this.myAlbumRootView;
        if (view2 != null) {
            Drawable drawable = null;
            if (position == 0) {
                if (view2 != null && (resources3 = view2.getResources()) != null) {
                    drawable = resources3.getDrawable(R.drawable.f13720m, null);
                }
            } else if (position == x()) {
                View view3 = this.myAlbumRootView;
                if (view3 != null && (resources2 = view3.getResources()) != null) {
                    drawable = resources2.getDrawable(R.drawable.f13710l, null);
                }
            } else {
                View view4 = this.myAlbumRootView;
                if (view4 != null && (resources = view4.getResources()) != null) {
                    drawable = resources.getDrawable(R.drawable.qui_common_bg_bottom_light_bg, null);
                }
            }
            view2.setBackground(drawable);
        }
        B(this.myAlbumRootView, data.qunId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(e this$0, GetAllAlbumListItem data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.y(context, data.qunId);
        this$0.A(view, data.qunId);
    }

    private final int x() {
        ArrayList<GetAllAlbumListItem> R1;
        al alVar = (al) t(al.class);
        return ((alVar == null || (R1 = alVar.R1()) == null) ? 0 : R1.size()) - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.myAlbumRootView = containerView.findViewById(R.id.mha);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(GetAllAlbumListItem data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        v(data, position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    private final void y(Context context, String groupId) {
        if ((groupId == null || groupId.length() == 0) || context == null) {
            return;
        }
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(context, "mqzone://arouse/groupalbum/homealbum?groupid=" + groupId + "&tabid=1&from=2");
    }

    private final void A(View view, String groupId) {
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (groupId == null) {
            groupId = "";
        }
        hashMap.put("group_id", groupId);
        fo.c.e("em_qz_group_album_entries", "pg_qz_all_group_albums", view, hashMap);
    }

    private final void B(View view, String groupId) {
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (groupId == null) {
            groupId = "";
        }
        hashMap.put("group_id", groupId);
        fo.c.g("em_qz_group_album_entries", "pg_qz_all_group_albums", view, hashMap);
    }
}
