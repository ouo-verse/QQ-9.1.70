package qa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaViewModel;
import com.qzone.reborn.albumx.qzone.part.QZoneAlbumxMediaListBodyPart;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0014\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0015\u001a\u00020\tR&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R)\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u00170\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001fR \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lqa/d;", "Lcom/qzone/reborn/albumx/qzone/base/media/viewmodel/MediaViewModel;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "rfwMediaInfoList", "Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxMediaListBodyPart$c;", "e2", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "data", "", "m2", "k2", "j2", "mediaInfoList", "l2", "S1", "", "path", "it", "i2", SemanticAttributes.DbSystemValues.H2, "d2", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "G", "Landroidx/lifecycle/MutableLiveData;", "_mediaList", "Landroidx/lifecycle/LiveData;", "H", "Landroidx/lifecycle/LiveData;", "f2", "()Landroidx/lifecycle/LiveData;", "mediaList", "", "I", "Ljava/util/List;", "notUploadedMediaList", "J", "hasUploadedMediaList", "K", "_notUploadMediaLiveData", "L", "g2", "notUploadMediaLiveData", "", "M", "Ljava/util/Map;", "rfwMediaInfoMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends MediaViewModel {

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<List<LocalMediaInfo>>> _mediaList;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<UIStateData<List<LocalMediaInfo>>> mediaList;

    /* renamed from: I, reason: from kotlin metadata */
    private final List<LocalMediaInfo> notUploadedMediaList;

    /* renamed from: J, reason: from kotlin metadata */
    private final List<LocalMediaInfo> hasUploadedMediaList;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<List<LocalMediaInfo>> _notUploadMediaLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final LiveData<List<LocalMediaInfo>> notUploadMediaLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    private final Map<String, RFWMediaInfo> rfwMediaInfoMap;

    public d() {
        MutableLiveData<UIStateData<List<LocalMediaInfo>>> mutableLiveData = new MutableLiveData<>();
        this._mediaList = mutableLiveData;
        this.mediaList = mutableLiveData;
        this.notUploadedMediaList = new ArrayList();
        this.hasUploadedMediaList = new ArrayList();
        MutableLiveData<List<LocalMediaInfo>> mutableLiveData2 = new MutableLiveData<>();
        this._notUploadMediaLiveData = mutableLiveData2;
        this.notUploadMediaLiveData = mutableLiveData2;
        this.rfwMediaInfoMap = new LinkedHashMap();
    }

    private final QZoneAlbumxMediaListBodyPart.c e2(List<RFWMediaInfo> rfwMediaInfoList) {
        QZoneAlbumxMediaListBodyPart.c cVar = new QZoneAlbumxMediaListBodyPart.c();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (rfwMediaInfoList != null) {
            for (RFWMediaInfo rFWMediaInfo : rfwMediaInfoList) {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.path = rFWMediaInfo.getMPath();
                if (rFWMediaInfo.getMUploadTime() > 0) {
                    ea.a.l(localMediaInfo, 4);
                    arrayList2.add(localMediaInfo);
                } else {
                    ea.a.l(localMediaInfo, 2);
                    arrayList.add(localMediaInfo);
                }
                i2(rFWMediaInfo.getMPath(), rFWMediaInfo);
            }
        }
        cVar.d(arrayList);
        cVar.c(arrayList2);
        return cVar;
    }

    private final void j2() {
        List<LocalMediaInfo> S1 = S1();
        List<LocalMediaInfo> list = S1;
        if (list == null || list.isEmpty()) {
            this._mediaList.postValue(UIStateData.obtainEmpty());
        } else {
            this._mediaList.postValue(UIStateData.obtainSuccess(false).setData(false, S1));
        }
    }

    private final void k2(List<? extends LocalMediaInfo> data) {
        Object orNull;
        this.hasUploadedMediaList.clear();
        this.hasUploadedMediaList.addAll(data);
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.hasUploadedMediaList, 0);
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
        if (localMediaInfo != null) {
            if (ea.a.g(localMediaInfo) != 3) {
                LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                ea.a.l(localMediaInfo2, 3);
                ea.a.k(localMediaInfo2, this.hasUploadedMediaList.size());
                this.hasUploadedMediaList.add(0, localMediaInfo2);
                return;
            }
            ea.a.k(localMediaInfo, this.hasUploadedMediaList.size() - 1);
        }
    }

    private final void m2(List<? extends LocalMediaInfo> data) {
        Object orNull;
        this.notUploadedMediaList.clear();
        this.notUploadedMediaList.addAll(data);
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.notUploadedMediaList, 0);
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
        if (localMediaInfo != null) {
            if (ea.a.g(localMediaInfo) != 1) {
                LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                ea.a.l(localMediaInfo2, 1);
                ea.a.k(localMediaInfo2, this.notUploadedMediaList.size());
                this.notUploadedMediaList.add(0, localMediaInfo2);
            } else {
                ea.a.k(localMediaInfo, this.notUploadedMediaList.size() - 1);
            }
        }
        this._notUploadMediaLiveData.postValue(this.notUploadedMediaList);
    }

    @Override // com.qzone.reborn.albumx.qzone.base.media.viewmodel.MediaViewModel
    public List<LocalMediaInfo> S1() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.notUploadedMediaList);
        arrayList.addAll(this.hasUploadedMediaList);
        return arrayList;
    }

    public final void d2() {
        this.rfwMediaInfoMap.clear();
    }

    public final LiveData<UIStateData<List<LocalMediaInfo>>> f2() {
        return this.mediaList;
    }

    public final LiveData<List<LocalMediaInfo>> g2() {
        return this.notUploadMediaLiveData;
    }

    public final void i2(String path, RFWMediaInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (path == null || path.length() == 0) {
            return;
        }
        this.rfwMediaInfoMap.put(path, it);
    }

    public final void l2(List<RFWMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        d2();
        QZoneAlbumxMediaListBodyPart.c e26 = e2(mediaInfoList);
        String tag = getTAG();
        int size = mediaInfoList.size();
        List<LocalMediaInfo> b16 = e26.b();
        Integer valueOf = b16 != null ? Integer.valueOf(b16.size()) : null;
        List<LocalMediaInfo> a16 = e26.a();
        QLog.d(tag, 1, "[queryMediaListAsync] --> queryStepFinish, mediaInfos.size=" + size + ", unUploaded.size=" + valueOf + ", uploaded.size=" + (a16 != null ? Integer.valueOf(a16.size()) : null));
        List<LocalMediaInfo> b17 = e26.b();
        if (b17 != null) {
            m2(b17);
        }
        List<LocalMediaInfo> a17 = e26.a();
        if (a17 != null) {
            k2(a17);
        }
        j2();
    }

    public final RFWMediaInfo h2(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        return this.rfwMediaInfoMap.get(path);
    }
}
