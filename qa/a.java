package qa;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.localupload.recommend.IUploadRecommendCallBack;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.events.QZoneLocalPhotoRecommendScanFinishEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import qa.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\f\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0016J\u0016\u0010\u0016\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001d\u001a\u00020\u001bH\u0016R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R#\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R#\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0$8\u0006\u00a2\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R4\u00109\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001e028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lqa/a;", "Lcom/qzone/reborn/base/n;", "Lcom/tencent/biz/richframework/localupload/recommend/IUploadRecommendCallBack;", "", "T1", "", "isFinish", "N1", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "data", "U1", "W1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "scanningStatus", "X1", "standaloneMode", "Z1", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "recommendInfoList", "onPhotoRecommendListChange", "onMakeVideoRecommendListChange", "onScanProcessChange", "O1", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "classifyInfo", "", "R1", "getLogTag", "", "i", "Ljava/util/List;", "videoRecommendList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "photoRecommendList", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "videoRecommendListLiveData", "D", "P1", "photoRecommendListLiveData", "E", "Q1", "scanningStatusLiveData", UserInfo.SEX_FEMALE, "Z", "", "G", "Ljava/util/Map;", "getClassifyIdTemplateIdMap", "()Ljava/util/Map;", "setClassifyIdTemplateIdMap", "(Ljava/util/Map;)V", "classifyIdTemplateIdMap", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends n implements IUploadRecommendCallBack {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean standaloneMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<RFWUploadRecommendInfo> videoRecommendList = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<RFWUploadRecommendInfo> photoRecommendList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<RFWUploadRecommendInfo>> videoRecommendListLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<List<RFWUploadRecommendInfo>> photoRecommendListLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Integer> scanningStatusLiveData = new MutableLiveData<>(-1);

    /* renamed from: G, reason: from kotlin metadata */
    private volatile Map<String, List<String>> classifyIdTemplateIdMap = new ConcurrentHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"qa/a$b", "Lcom/tencent/mobileqq/wink/api/f;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements f {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a this$0, List metaCategories) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(metaCategories, "$metaCategories");
            this$0.U1(metaCategories);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e() {
            ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).unRegisterRecommendCallback();
        }

        @Override // com.tencent.mobileqq.wink.api.f
        public void a(final List<MetaCategory> metaCategories) {
            Intrinsics.checkNotNullParameter(metaCategories, "metaCategories");
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final a aVar = a.this;
            rFWThreadManager.execOnSubThread(new Runnable() { // from class: qa.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.d(a.this, metaCategories);
                }
            });
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: qa.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.e();
                }
            });
        }
    }

    private final void T1() {
        Object firstOrNull;
        String str;
        RFWMediaInfo firstMediaInfo;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.videoRecommendList);
        RFWUploadRecommendInfo rFWUploadRecommendInfo = (RFWUploadRecommendInfo) firstOrNull;
        if (rFWUploadRecommendInfo == null || (firstMediaInfo = rFWUploadRecommendInfo.getFirstMediaInfo()) == null || (str = firstMediaInfo.getMPath()) == null) {
            str = "";
        }
        o7.c.d(str);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneLocalPhotoRecommendScanFinishEvent(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(List<MetaCategory> data) {
        Object orNull;
        ArrayList<MetaCategory> arrayList;
        List<String> split$default;
        if (data.isEmpty()) {
            QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[parseEditTemplateList] data is empty");
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(data, 0);
        MetaCategory metaCategory = (MetaCategory) orNull;
        if (metaCategory != null && (arrayList = metaCategory.subCategories) != null) {
            Iterator<MetaCategory> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<MetaMaterial> arrayList2 = it.next().materials;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "subCategory.materials");
                for (MetaMaterial metaMaterial : arrayList2) {
                    String str = metaMaterial.additionalFields.get("qzoneCategories");
                    if (str != null) {
                        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
                        for (String str2 : split$default) {
                            List<String> list = this.classifyIdTemplateIdMap.get(str2);
                            if (list != null) {
                                String str3 = metaMaterial.f30533id;
                                Intrinsics.checkNotNullExpressionValue(str3, "material.id");
                                list.add(str3);
                            } else {
                                ArrayList arrayList3 = new ArrayList();
                                String str4 = metaMaterial.f30533id;
                                Intrinsics.checkNotNullExpressionValue(str4, "material.id");
                                arrayList3.add(str4);
                                this.classifyIdTemplateIdMap.put(str2, arrayList3);
                            }
                        }
                    }
                }
            }
        }
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[parseEditTemplateList] finish, classifyIdTemplateIdMap: " + this.classifyIdTemplateIdMap.size());
    }

    public final MutableLiveData<List<RFWUploadRecommendInfo>> P1() {
        return this.photoRecommendListLiveData;
    }

    public final MutableLiveData<Integer> Q1() {
        return this.scanningStatusLiveData;
    }

    public final String R1(RFWClassifyInfo classifyInfo) {
        List<String> list;
        int lastIndex;
        String str;
        if (classifyInfo == null || (list = this.classifyIdTemplateIdMap.get(classifyInfo.getClassifyId())) == null) {
            return "";
        }
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex < 0) {
            str = "";
        } else {
            str = list.get(0);
        }
        String str2 = str;
        return str2 == null ? "" : str2;
    }

    public final MutableLiveData<List<RFWUploadRecommendInfo>> S1() {
        return this.videoRecommendListLiveData;
    }

    public final void X1(int scanningStatus) {
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[setScanningStatus] scanningStatus = " + scanningStatus);
        this.scanningStatusLiveData.postValue(Integer.valueOf(scanningStatus));
    }

    public final void Z1(boolean standaloneMode) {
        this.standaloneMode = standaloneMode;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendListViewModel";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.IUploadRecommendCallBack
    public void onMakeVideoRecommendListChange(List<RFWUploadRecommendInfo> recommendInfoList) {
        List<RFWUploadRecommendInfo> list;
        Intrinsics.checkNotNullParameter(recommendInfoList, "recommendInfoList");
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[onMakeVideoRecommendListChange] videoRecommend.size = " + recommendInfoList.size());
        this.videoRecommendList.clear();
        this.videoRecommendList.addAll(recommendInfoList);
        MutableLiveData<List<RFWUploadRecommendInfo>> mutableLiveData = this.videoRecommendListLiveData;
        list = CollectionsKt___CollectionsKt.toList(this.videoRecommendList);
        mutableLiveData.postValue(list);
        T1();
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.IUploadRecommendCallBack
    public void onPhotoRecommendListChange(List<RFWUploadRecommendInfo> recommendInfoList) {
        List<RFWUploadRecommendInfo> list;
        Intrinsics.checkNotNullParameter(recommendInfoList, "recommendInfoList");
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[onPhotoRecommendListChange] photoRecommend.size = " + recommendInfoList.size());
        this.photoRecommendList.clear();
        this.photoRecommendList.addAll(recommendInfoList);
        int i3 = 0;
        for (Object obj : this.photoRecommendList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RFWUploadRecommendInfo rFWUploadRecommendInfo = (RFWUploadRecommendInfo) obj;
            if (i3 == 0) {
                ga.b.g(rFWUploadRecommendInfo, 2);
                ga.b.f(rFWUploadRecommendInfo, true);
            } else {
                ga.b.g(rFWUploadRecommendInfo, 1);
                ga.b.f(rFWUploadRecommendInfo, false);
            }
            i3 = i16;
        }
        MutableLiveData<List<RFWUploadRecommendInfo>> mutableLiveData = this.photoRecommendListLiveData;
        list = CollectionsKt___CollectionsKt.toList(this.photoRecommendList);
        mutableLiveData.postValue(list);
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.IUploadRecommendCallBack
    public void onScanProcessChange(boolean isFinish) {
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[onScanProcessChange] isFinish = " + isFinish);
        N1(isFinish);
    }

    public final void O1() {
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[fetchQZoneEditTemplateList]");
        ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).fetchQZoneRecommendTemplateList(new b());
    }

    public final void W1() {
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[registerAndResumeRecommend]");
        QZoneUploadRecommendDirector.Companion companion = QZoneUploadRecommendDirector.INSTANCE;
        companion.a().registerRecommendCallBack(this);
        companion.a().startRecommend();
    }

    public final void a2() {
        QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 1, "[unRegisterRecommend]");
        QZoneUploadRecommendDirector.INSTANCE.a().unregisterRecommendCallBack(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        if (r6.videoRecommendList.isEmpty() != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void N1(boolean isFinish) {
        int i3 = 5;
        if (isFinish) {
            if (this.videoRecommendList.isEmpty() && this.photoRecommendList.isEmpty()) {
                i3 = 4;
            } else if (!this.standaloneMode) {
                i3 = 3;
            } else if (!(true ^ this.videoRecommendList.isEmpty())) {
                return;
            }
        } else {
            if (!this.videoRecommendList.isEmpty() || !this.photoRecommendList.isEmpty()) {
                if (!this.standaloneMode) {
                    i3 = 2;
                }
            }
            i3 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneAlbumxLocalPhotoRecommendListViewModel", 2, "[changeScanningStatus] scanningStatus = " + i3 + ", isFinish:" + isFinish + ", video.size = " + this.videoRecommendList.size() + ", photo.size = " + this.photoRecommendList.size());
        }
        this.scanningStatusLiveData.postValue(Integer.valueOf(i3));
    }
}
