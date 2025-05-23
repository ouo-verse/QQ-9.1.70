package rk;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lrk/a;", "Lrk/c;", "", "e", "I", "j", "()I", DomainData.DOMAIN_NAME, "(I)V", "albumType", "f", "l", "p", "indexInAlbum", "g", "k", "o", "allPhotoCount", "", "Lcom/qzone/album/data/model/PhotoCacheData;", tl.h.F, "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/util/List;)V", s4.c.PICS, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class a extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int albumType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int indexInAlbum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int allPhotoCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<PhotoCacheData> pics = new ArrayList();

    /* renamed from: j, reason: from getter */
    public final int getAlbumType() {
        return this.albumType;
    }

    /* renamed from: k, reason: from getter */
    public final int getAllPhotoCount() {
        return this.allPhotoCount;
    }

    /* renamed from: l, reason: from getter */
    public final int getIndexInAlbum() {
        return this.indexInAlbum;
    }

    public final List<PhotoCacheData> m() {
        return this.pics;
    }

    public final void n(int i3) {
        this.albumType = i3;
    }

    public final void o(int i3) {
        this.allPhotoCount = i3;
    }

    public final void p(int i3) {
        this.indexInAlbum = i3;
    }

    public final void q(List<PhotoCacheData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.pics = list;
    }
}
