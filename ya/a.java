package ya;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lya/a;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "b", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "albumInfo", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "Ljava/util/List;", "()Ljava/util/List;", "setSharers", "(Ljava/util/List;)V", "sharers", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<CommonClientAttr> sharers = new ArrayList();

    public final List<CommonClientAttr> a() {
        return this.sharers;
    }

    public final void b(CommonAlbumInfo commonAlbumInfo) {
        this.albumInfo = commonAlbumInfo;
    }
}
