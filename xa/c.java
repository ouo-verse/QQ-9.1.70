package xa;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStShare;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lxa/c;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "d", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", "g", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;)V", "shareInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "e", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "albumInfo", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "c", "Ljava/util/List;", "()Ljava/util/List;", "setMedias", "(Ljava/util/List;)V", "medias", "", "I", "()I", "f", "(I)V", QzoneIPCModule.RESULT_CODE, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CommonStShare shareInfo = new CommonStShare();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfo = new CommonAlbumInfo();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<CommonStMedia> medias = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int resultCode;

    /* renamed from: a, reason: from getter */
    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final List<CommonStMedia> b() {
        return this.medias;
    }

    /* renamed from: c, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* renamed from: d, reason: from getter */
    public final CommonStShare getShareInfo() {
        return this.shareInfo;
    }

    public final void e(CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(commonAlbumInfo, "<set-?>");
        this.albumInfo = commonAlbumInfo;
    }

    public final void f(int i3) {
        this.resultCode = i3;
    }

    public final void g(CommonStShare commonStShare) {
        Intrinsics.checkNotNullParameter(commonStShare, "<set-?>");
        this.shareInfo = commonStShare;
    }
}
