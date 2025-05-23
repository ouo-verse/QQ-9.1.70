package ui;

import android.text.TextUtils;
import android.view.View;
import com.qzone.reborn.base.l;
import com.qzone.util.ar;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GetAllAlbumListItem;
import com.tencent.qqnt.kernel.nativeinterface.MediaType;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lui/b;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAllAlbumListItem;", "data", "", "u", "", "coverUrl", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "v", "e", "Ljava/lang/String;", "TAG", "Lcom/tencent/widget/RoundRectImageView;", "f", "Lcom/tencent/widget/RoundRectImageView;", "albumPic", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends l<GetAllAlbumListItem> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "GroupAlbumMyAlbumCoverSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView albumPic;

    private final void u(GetAllAlbumListItem data) {
        String coverUrl;
        RoundRectImageView roundRectImageView = this.albumPic;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        roundRectImageView.setCornerRadiusAndMode(ar.d(4.0f), 1);
        if (data.mediaList.size() <= 0) {
            QLog.e(this.TAG, 1, "bindAlbumPic error,data.mediaList = null");
            return;
        }
        if (data.mediaList.get(0).type == MediaType.KMEDIATYPEVIDEO.ordinal()) {
            coverUrl = data.mediaList.get(0).video.cover.defaultUrl.url;
        } else if (data.mediaList.get(0).type == MediaType.KMEDIATYPEIMAGE.ordinal()) {
            coverUrl = data.mediaList.get(0).image.defaultUrl.url;
        } else {
            coverUrl = "";
        }
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        w(coverUrl);
    }

    private final void w(String coverUrl) {
        if (TextUtils.isEmpty(coverUrl)) {
            QLog.e(this.TAG, 1, "updateCover error,coverUrl = null");
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(coverUrl);
        RoundRectImageView roundRectImageView = this.albumPic;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumPic");
            roundRectImageView = null;
        }
        obtain.setTargetView(roundRectImageView);
        obtain.setLoadingDrawable(p().getResources().getDrawable(R.drawable.at8, null));
        obtain.setFailDrawable(p().getResources().getDrawable(R.drawable.at_, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mh_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.my_album_pic)");
        this.albumPic = (RoundRectImageView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(GetAllAlbumListItem data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        u(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
