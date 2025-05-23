package ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.base.l;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.GetAllAlbumListItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lui/a;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAllAlbumListItem;", "data", "", "w", "u", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "groupNameTV", "f", "tipTV", h.F, "albumNumTV", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends l<GetAllAlbumListItem> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView groupNameTV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tipTV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView albumNumTV;

    private final void u(GetAllAlbumListItem data) {
        String str = data.qunName;
        if (str == null || str.length() == 0) {
            str = data.qunId;
        }
        TextView textView = this.groupNameTV;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    private final void v(GetAllAlbumListItem data) {
        Resources resources;
        int i3 = data.albumNum;
        TextView textView = this.albumNumTV;
        if (textView == null) {
            return;
        }
        textView.setText((textView == null || (resources = textView.getResources()) == null) ? null : resources.getString(R.string.f1330957, Integer.valueOf(i3)));
    }

    private final void w(GetAllAlbumListItem data) {
        String str = data.lastestPromptText;
        if (str == null || str.length() == 0) {
            TextView textView = this.tipTV;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = this.tipTV;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.tipTV;
        if (textView3 == null) {
            return;
        }
        textView3.setText("[" + str + "]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.groupNameTV = (TextView) containerView.findViewById(R.id.mh8);
        this.tipTV = (TextView) containerView.findViewById(R.id.mhb);
        this.albumNumTV = (TextView) containerView.findViewById(R.id.mh9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(GetAllAlbumListItem data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        w(data);
        u(data);
        v(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
