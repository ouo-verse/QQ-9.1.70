package rb;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart;
import com.qzone.reborn.albumx.common.viewmodel.l;
import com.qzone.reborn.feedx.util.k;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qc.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"Lrb/c;", "Lcom/qzone/reborn/albumx/common/part/selectalbum/CommonSelectAlbumBlankPart;", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "E9", "", "J9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends CommonSelectAlbumBlankPart {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l G9 = this$0.G9();
        Intrinsics.checkNotNull(G9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.upload.QZAlbumxUploadSelectAlbumPageViewModel");
        this$0.broadcastMessage("ACTION_CREATE_ALBUM", ((h) G9).a2().getUin());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart
    public l E9() {
        ViewModel viewModel = getViewModel(h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxUpl\u2026ageViewModel::class.java)");
        return (l) viewModel;
    }

    @Override // com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumBlankPart
    protected void J9() {
        F9().setData(k.j(getContext(), G9().Q1(), new View.OnClickListener() { // from class: rb.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.P9(c.this, view);
            }
        }));
    }
}
