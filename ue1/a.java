package ue1;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0002#\u0007B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\u0002*\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002J$\u0010\u0010\u001a\u00020\u000f*\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0011\u001a\u00020\u0006*\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0006J\u0014\u0010\u0019\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u001c\u0010\u001f\u001a\u00020\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001dJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u00062\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012J$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012R&\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\f0\tj\b\u0012\u0004\u0012\u00020\f`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R&\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010'R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010+R!\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u00102\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u0002038F\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lue1/a;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "", "c", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "", "b", "o", "Ljava/util/ArrayList;", "Lue1/a$b;", "Lkotlin/collections/ArrayList;", "", "path", DomainData.DOMAIN_NAME, "", "i", "l", "", "mediaList", "j", "localMediaInfo", "e", "t", "selectedMedias", "k", "mediaInfo", "isSelected", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "editMap", "p", "d", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Ljava/util/ArrayList;", "originPaths", "_mediaHandleList", "I", "_selectState", "initMediaType", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_sendUiLiveData", "f", "()Ljava/util/ArrayList;", "publishMediaHandleList", "g", "()I", "selectState", "Landroidx/lifecycle/LiveData;", h.F, "()Landroidx/lifecycle/LiveData;", "sendUiLiveData", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements com.tencent.qqnt.qbasealbum.customization.common.a {

    /* renamed from: c, reason: from kotlin metadata */
    private int _selectState;

    /* renamed from: a, reason: from kotlin metadata */
    private ArrayList<String> originPaths = new ArrayList<>();

    /* renamed from: b, reason: from kotlin metadata */
    private ArrayList<MediaHandle> _mediaHandleList = new ArrayList<>();

    /* renamed from: d, reason: from kotlin metadata */
    private int initMediaType = -1;

    /* renamed from: e, reason: from kotlin metadata */
    private MutableLiveData<Boolean> _sendUiLiveData = new MutableLiveData<>();

    private final void b(LocalMediaInfo r102) {
        String path = r102.getPath();
        if (path == null) {
            path = "";
        }
        this._mediaHandleList.add(new MediaHandle(path, e(r102), null, 4, null));
        QLog.i("GuildFeedPublishOtherCommonData", 1, "[onAdd]--idx:" + this._mediaHandleList.size() + ",path:" + path);
    }

    private final boolean c() {
        if (!this._mediaHandleList.isEmpty()) {
            return true;
        }
        return this._mediaHandleList.isEmpty() && this.initMediaType != -1;
    }

    private final int i(ArrayList<MediaHandle> arrayList, String str) {
        Object obj;
        int indexOf;
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((MediaHandle) obj).getPath(), str)) {
                break;
            }
        }
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends Object>) arrayList, obj);
        return indexOf;
    }

    private final void l(ArrayList<MediaHandle> arrayList) {
        for (MediaHandle mediaHandle : arrayList) {
            if (!RFWFileUtils.fileExists(mediaHandle.getPath())) {
                mediaHandle.d("");
            }
        }
    }

    private final boolean n(ArrayList<MediaHandle> arrayList, String str) {
        Object obj;
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((MediaHandle) obj).getPath(), str)) {
                break;
            }
        }
        return TypeIntrinsics.asMutableCollection(arrayList).remove(obj);
    }

    private final void o(LocalMediaInfo r56) {
        String path = r56.getPath();
        if (path == null) {
            path = "";
        }
        if (!n(this._mediaHandleList, path)) {
            QLog.e("GuildFeedPublishOtherCommonData", 1, "[updateIndexWhenSelect]--can not delete,path:" + path);
            return;
        }
        QLog.i("GuildFeedPublishOtherCommonData", 1, "[onRemove]--path:" + path);
    }

    public final int d(LocalMediaInfo r26) {
        Intrinsics.checkNotNullParameter(r26, "media");
        String path = r26.getPath();
        if (path == null) {
            path = "";
        }
        return i(this._mediaHandleList, path);
    }

    public final int e(LocalMediaInfo localMediaInfo) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        String mMimeType = localMediaInfo.getMMimeType();
        if (mMimeType != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mMimeType, "video", false, 2, null);
            if (startsWith$default) {
                return 1;
            }
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(mMimeType, "image", false, 2, null);
            if (startsWith$default2) {
                return 0;
            }
        }
        return localMediaInfo.getMMediaType();
    }

    public final ArrayList<MediaHandle> f() {
        return this._mediaHandleList;
    }

    /* renamed from: g, reason: from getter */
    public final int get_selectState() {
        return this._selectState;
    }

    public final LiveData<Boolean> h() {
        return this._sendUiLiveData;
    }

    public final void j(List<LocalMediaInfo> mediaList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Object first;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        bg bgVar = bg.f302144a;
        List<LocalMediaInfo> list = mediaList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (LocalMediaInfo localMediaInfo : list) {
            String path = localMediaInfo.getPath();
            if (path == null) {
                path = "";
            }
            String picPathBeforeEdit = TextUtils.isEmpty(localMediaInfo.getPicPathBeforeEdit()) ? path : localMediaInfo.getPicPathBeforeEdit();
            int e16 = e(localMediaInfo);
            Intrinsics.checkNotNull(picPathBeforeEdit);
            arrayList.add(new MediaHandle(path, e16, picPathBeforeEdit));
        }
        ArrayList<MediaHandle> n3 = bgVar.n(arrayList);
        this._mediaHandleList = n3;
        l(n3);
        ArrayList<String> arrayList2 = this.originPaths;
        ArrayList<MediaHandle> arrayList3 = this._mediaHandleList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(((MediaHandle) it.next()).getPath());
        }
        arrayList2.addAll(arrayList4);
        if (!mediaList.isEmpty()) {
            s(this, null, 1, null);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mediaList);
            int e17 = e((LocalMediaInfo) first);
            this.initMediaType = e17;
            QLog.i("GuildFeedPublishOtherCommonData", 1, "[onInitMediaHandle]--initMediaType:" + e17);
        }
        t();
    }

    public final void k(List<LocalMediaInfo> selectedMedias) {
        Intrinsics.checkNotNullParameter(selectedMedias, "selectedMedias");
        if (get_selectState() == 2) {
            if (!selectedMedias.isEmpty()) {
                List<LocalMediaInfo> list = selectedMedias;
                boolean z16 = true;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (!(!RFWFileUtils.fileExists(((LocalMediaInfo) it.next()).getPath()))) {
                            z16 = false;
                            break;
                        }
                    }
                }
                if (!z16) {
                    return;
                }
            }
            this._selectState = 0;
            this._mediaHandleList.clear();
        }
    }

    public final ArrayList<LocalMediaInfo> m(List<LocalMediaInfo> mediaList) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>(this._mediaHandleList.size());
        List<LocalMediaInfo> list = mediaList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((LocalMediaInfo) obj).getPath(), obj);
        }
        Logger.f235387a.d().d("GuildFeedPublishOtherCommonData", 1, "[onReArrange]--selectedSize:" + mediaList.size() + ",handleSize:" + this._mediaHandleList.size());
        for (MediaHandle mediaHandle : this._mediaHandleList) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) linkedHashMap.get(mediaHandle.getPath());
            if (localMediaInfo == null) {
                int i3 = 0;
                LocalMediaInfo localMediaInfo2 = new LocalMediaInfo(false, 1, null);
                localMediaInfo2.setPath("");
                int i16 = get_selectState();
                if (i16 != 1) {
                    i3 = i16 != 2 ? this.initMediaType : 1;
                }
                localMediaInfo2.setMMediaType(i3);
                arrayList.add(localMediaInfo2);
                Logger.f235387a.d().d("GuildFeedPublishOtherCommonData", 1, "[onReArrange]--insert placeholder,path:" + mediaHandle.getPath() + ",mediaListSize:" + mediaList.size());
            } else {
                arrayList.add(localMediaInfo);
            }
        }
        return arrayList;
    }

    public final void q(LocalMediaInfo mediaInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (TextUtils.isEmpty(mediaInfo.getPath())) {
            QLog.e("GuildFeedPublishOtherCommonData", 1, "[updateIdxWhenSelect]--empty path!");
        } else if (z16) {
            b(mediaInfo);
        } else {
            o(mediaInfo);
        }
    }

    public final void r(List<MediaHandle> mediaList) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mediaList);
        MediaHandle mediaHandle = (MediaHandle) firstOrNull;
        int mediaType = mediaHandle != null ? mediaHandle.getMediaType() : -1;
        this._selectState = mediaType != 0 ? mediaType != 1 ? 0 : 2 : 1;
        QLog.i("GuildFeedPublishOtherCommonData", 1, "[onUpdateSelectState]--selectState:" + get_selectState());
    }

    public final void t() {
        this._sendUiLiveData.setValue(Boolean.valueOf(c()));
    }

    public final void p(Map<String, String> editMap) {
        Object obj;
        if (editMap != null) {
            for (Map.Entry<String, String> entry : editMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Iterator<T> it = this._mediaHandleList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((MediaHandle) obj).getBeforeEditPath(), key)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                MediaHandle mediaHandle = (MediaHandle) obj;
                if (mediaHandle != null) {
                    mediaHandle.d(value);
                    QLog.i("GuildFeedPublishOtherCommonData", 1, "[onReplacePath]--origin:" + key + ",edited:" + value);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lue1/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "path", "b", "I", "()I", "mediaType", "beforeEditPath", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ue1.a$b, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class MediaHandle {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private String path;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int mediaType;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String beforeEditPath;

        public MediaHandle(String path, int i3, String beforeEditPath) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(beforeEditPath, "beforeEditPath");
            this.path = path;
            this.mediaType = i3;
            this.beforeEditPath = beforeEditPath;
        }

        /* renamed from: a, reason: from getter */
        public final String getBeforeEditPath() {
            return this.beforeEditPath;
        }

        /* renamed from: b, reason: from getter */
        public final int getMediaType() {
            return this.mediaType;
        }

        /* renamed from: c, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.path = str;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + this.mediaType) * 31) + this.beforeEditPath.hashCode();
        }

        public String toString() {
            return "MediaHandle(path=" + this.path + ", mediaType=" + this.mediaType + ", beforeEditPath=" + this.beforeEditPath + ")";
        }

        public /* synthetic */ MediaHandle(String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, (i16 & 4) != 0 ? str : str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaHandle)) {
                return false;
            }
            MediaHandle mediaHandle = (MediaHandle) other;
            return Intrinsics.areEqual(this.path, mediaHandle.path) && this.mediaType == mediaHandle.mediaType && Intrinsics.areEqual(this.beforeEditPath, mediaHandle.beforeEditPath);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void s(a aVar, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = aVar._mediaHandleList;
        }
        aVar.r(list);
    }
}
