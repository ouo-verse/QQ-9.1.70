package y83;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource;
import com.tencent.mobileqq.wink.request.QQWinkPushNotificationMemoryAlbumReq;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemType;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import v83.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002J\u0016\u0010\f\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J$\u0010\r\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R8\u0010\u001a\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00030\u0003 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u001e\u00a8\u0006\""}, d2 = {"Ly83/b;", "Lx83/a;", "", "", "p", "", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "allAlbumDataList", "", "exposedAlbumIds", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ly83/c;", "pushData", "k", "", "g", "f", "b", "Ljava/lang/String;", "TAG", "kotlin.jvm.PlatformType", "c", "Ljava/util/Set;", "_exposedAlbumIds", "d", "o", "()Ljava/util/Set;", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends x83.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f449557a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "WinkNewAlbum_WinkAlbumExposePushManager";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> _exposedAlbumIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> exposedAlbumIds;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f449561a;

        static {
            int[] iArr = new int[WinkAlbumItemType.values().length];
            try {
                iArr[WinkAlbumItemType.DATA_TYPE_MEMORY_ALBUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkAlbumItemType.DATA_TYPE_NEW_ALBUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f449561a = iArr;
        }
    }

    static {
        Set<String> _exposedAlbumIds2 = Collections.newSetFromMap(new ConcurrentHashMap());
        _exposedAlbumIds = _exposedAlbumIds2;
        Intrinsics.checkNotNullExpressionValue(_exposedAlbumIds2, "_exposedAlbumIds");
        exposedAlbumIds = _exposedAlbumIds2;
    }

    b() {
    }

    private final void k(final WinkAlbumPushData pushData, final Set<String> exposedAlbumIds2) {
        String content = pushData.getContent();
        String addParameter = URLUtil.addParameter(QCircleScheme.AttrQQPublish.PUBLISH_SCHEMA_PREFIX, "target", "16");
        Intrinsics.checkNotNullExpressionValue(addParameter, "addParameter(schema,\n   \u2026lish.TARGET_MEMORY_ALBUM)");
        String addParameter2 = URLUtil.addParameter(addParameter, QCircleScheme.AttrQQPublish.MEMORY_ALBUM_ID, pushData.getAlbumId());
        Intrinsics.checkNotNullExpressionValue(addParameter2, "addParameter(schema,\n   \u2026        pushData.albumId)");
        String addParameter3 = URLUtil.addParameter(addParameter2, QCircleScheme.AttrQQPublish.MEMORY_ALBUM_TITLE, pushData.getAlbumName());
        Intrinsics.checkNotNullExpressionValue(addParameter3, "addParameter(schema,\n   \u2026      pushData.albumName)");
        QLog.d(c(), 1, "doPush, pushData:" + pushData + ", schema:" + addParameter3);
        VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), new QQWinkPushNotificationMemoryAlbumReq(content, addParameter3), new VSDispatchObserver.OnVSRspCallBack() { // from class: y83.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                b.l(exposedAlbumIds2, pushData, baseRequest, z16, j3, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Set exposedAlbumIds2, WinkAlbumPushData pushData, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        String str2;
        Intrinsics.checkNotNullParameter(exposedAlbumIds2, "$exposedAlbumIds");
        Intrinsics.checkNotNullParameter(pushData, "$pushData");
        b bVar = f449557a;
        String c16 = bVar.c();
        if (baseRequest != null) {
            str2 = baseRequest.getTraceId();
        } else {
            str2 = null;
        }
        QLog.d(c16, 1, "doPush, traceId:" + str2 + ", isSuccess:" + z16 + ", retCode:" + j3 + ", errMsg:" + str);
        if (z16 && j3 == 0) {
            exposedAlbumIds2.add(pushData.getAlbumId());
            bVar.q(exposedAlbumIds2);
        }
    }

    private final void m(List<WinkAlbumItemWrapper> allAlbumDataList, Set<String> exposedAlbumIds2) {
        Object obj;
        WinkAlbumPushData e16;
        s53.a winkMemoryAlbum;
        WinkNewMemoryAlbumResult winkNewAlbum;
        if (!e.f441245a.h()) {
            QLog.d(c(), 1, "doPushUnExposedAlbumIfNeed, push is not enable ");
            return;
        }
        Iterator<T> it = allAlbumDataList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                WinkAlbumItemWrapper winkAlbumItemWrapper = (WinkAlbumItemWrapper) obj;
                int i3 = a.f449561a[winkAlbumItemWrapper.getType().ordinal()];
                boolean z16 = false;
                if (i3 == 1 ? !((winkMemoryAlbum = winkAlbumItemWrapper.getWinkMemoryAlbum()) == null || winkMemoryAlbum.getExposed()) : !(i3 != 2 || (winkNewAlbum = winkAlbumItemWrapper.getWinkNewAlbum()) == null || winkNewAlbum.getIsExposed())) {
                    z16 = true;
                }
            } else {
                obj = null;
                break;
            }
        }
        WinkAlbumItemWrapper winkAlbumItemWrapper2 = (WinkAlbumItemWrapper) obj;
        if (winkAlbumItemWrapper2 != null && (e16 = winkAlbumItemWrapper2.e()) != null) {
            f449557a.k(e16, exposedAlbumIds2);
        }
    }

    private final void n(List<WinkAlbumItemWrapper> allAlbumDataList, Set<String> exposedAlbumIds2) {
        boolean z16;
        WinkNewMemoryAlbumResult winkNewAlbum;
        WinkNewMemoryAlbumResult winkNewAlbum2;
        ArrayList<WinkAlbumItemWrapper> arrayList = new ArrayList();
        Iterator<T> it = allAlbumDataList.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            WinkAlbumItemWrapper winkAlbumItemWrapper = (WinkAlbumItemWrapper) next;
            int i3 = a.f449561a[winkAlbumItemWrapper.getType().ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && (winkNewAlbum2 = winkAlbumItemWrapper.getWinkNewAlbum()) != null) {
                    z17 = winkNewAlbum2.getIsExposed();
                }
            } else {
                s53.a winkMemoryAlbum = winkAlbumItemWrapper.getWinkMemoryAlbum();
                if (winkMemoryAlbum != null) {
                    z17 = winkMemoryAlbum.getExposed();
                }
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (WinkAlbumItemWrapper winkAlbumItemWrapper2 : arrayList) {
            int i16 = a.f449561a[winkAlbumItemWrapper2.getType().ordinal()];
            String str = null;
            if (i16 != 1) {
                if (i16 == 2 && (winkNewAlbum = winkAlbumItemWrapper2.getWinkNewAlbum()) != null) {
                    str = winkNewAlbum.getAlbumID();
                }
            } else {
                s53.a winkMemoryAlbum2 = winkAlbumItemWrapper2.getWinkMemoryAlbum();
                if (winkMemoryAlbum2 != null) {
                    str = winkMemoryAlbum2.getId();
                }
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(c(), 1, "doSaveExposedAlbumIds, newExposedAlbumIds:" + arrayList3);
        }
        if (Intrinsics.areEqual(WinkAlbumDataSource.f324204a.v().getValue(), Boolean.TRUE)) {
            QLog.d(c(), 1, "doSaveExposedAlbumIds, all album data load finished ");
            exposedAlbumIds2.clear();
        }
        exposedAlbumIds2.addAll(arrayList3);
        q(exposedAlbumIds2);
    }

    private final Set<String> p() {
        List split$default;
        Set<String> set;
        boolean z16;
        ar arVar = ar.f326685a;
        split$default = StringsKt__StringsKt.split$default((CharSequence) arVar.i(arVar.k("ae_key_editor_memory_album_exposed_album"), ""), new String[]{";"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (((String) obj).length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        return set;
    }

    private final void q(Set<String> exposedAlbumIds2) {
        String joinToString$default;
        ar arVar = ar.f326685a;
        String k3 = arVar.k("ae_key_editor_memory_album_exposed_album");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(exposedAlbumIds2, ";", null, null, 0, null, null, 62, null);
        QLog.d(c(), 1, "saveExposedAlbumIds, value:" + joinToString$default);
        arVar.r(k3, joinToString$default);
    }

    @Override // x83.a
    @NotNull
    public String c() {
        return TAG;
    }

    @Override // x83.a
    public void f() {
        List<WinkAlbumItemWrapper> list;
        Set<String> mutableSet;
        list = CollectionsKt___CollectionsKt.toList(WinkAlbumDataSource.f324204a.x());
        Set<String> _exposedAlbumIds2 = _exposedAlbumIds;
        Intrinsics.checkNotNullExpressionValue(_exposedAlbumIds2, "_exposedAlbumIds");
        mutableSet = CollectionsKt___CollectionsKt.toMutableSet(_exposedAlbumIds2);
        n(list, mutableSet);
        m(list, mutableSet);
        _exposedAlbumIds2.clear();
    }

    @Override // x83.a
    public boolean g() {
        Set<String> p16 = p();
        _exposedAlbumIds.addAll(p16);
        QLog.d(f449557a.c(), 1, "onStartProcess, exposedAlbumIds:" + p16);
        return true;
    }

    @NotNull
    public final Set<String> o() {
        return exposedAlbumIds;
    }
}
