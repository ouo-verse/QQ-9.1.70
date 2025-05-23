package yj;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.ae;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lyj/j;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mAlbumBackView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mAlbumTitleView", "Lnk/ae;", "f", "Lnk/ae;", "mAlbumViewModel", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumBackView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumTitleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ae mAlbumViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        TextView textView = this.mAlbumTitleView;
        ae aeVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumTitleView");
            textView = null;
        }
        ae aeVar2 = this.mAlbumViewModel;
        if (aeVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar = aeVar2;
        }
        textView.setText(aeVar.U1().getTitle());
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026yncViewModel::class.java)");
        this.mAlbumViewModel = (ae) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.n3v);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.qzo\u2026intimate_album_sync_back)");
            this.mAlbumBackView = (ImageView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.n49);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.qzo\u2026ntimate_album_sync_title)");
            this.mAlbumTitleView = (TextView) findViewById2;
            ImageView imageView = this.mAlbumBackView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumBackView");
                imageView = null;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: yj.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.D9(j.this, view);
                }
            });
        }
        initData();
    }
}
