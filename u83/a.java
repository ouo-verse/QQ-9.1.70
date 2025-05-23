package u83;

import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorDebugInstance;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorDebugUnStoredContext;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.collector.m;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugBaseModel;
import com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugPanelViewModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lu83/a;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lu83/a$a;", "", "", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel;", "baseModelList", "d", "selectedBaseModel", "e", "a", "", "storyID", "", "currentLoop", "b", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "albumResult", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugPanelViewModel;", "c", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u83.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: u83.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C11331a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((WinkNewAlbumDebugBaseModel) t17).getScore()), Float.valueOf(((WinkNewAlbumDebugBaseModel) t16).getScore()));
                return compareValues;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: u83.a$a$b */
        /* loaded from: classes21.dex */
        public static final class b<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((WinkNewAlbumDebugBaseModel) t17).getScore()), Float.valueOf(((WinkNewAlbumDebugBaseModel) t16).getScore()));
                return compareValues;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: u83.a$a$c */
        /* loaded from: classes21.dex */
        public static final class c<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((WinkNewAlbumDebugBaseModel) t17).getScore()), Float.valueOf(((WinkNewAlbumDebugBaseModel) t16).getScore()));
                return compareValues;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: u83.a$a$d */
        /* loaded from: classes21.dex */
        public static final class d<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((WinkNewAlbumDebugBaseModel) t17).getPhotoSimilarity()), Float.valueOf(((WinkNewAlbumDebugBaseModel) t16).getPhotoSimilarity()));
                return compareValues;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<WinkNewAlbumDebugBaseModel> a(@NotNull List<WinkNewAlbumDebugBaseModel> baseModelList) {
            Intrinsics.checkNotNullParameter(baseModelList, "baseModelList");
            CollectionsKt___CollectionsKt.sortedWith(baseModelList, new C11331a());
            for (WinkNewAlbumDebugBaseModel winkNewAlbumDebugBaseModel : baseModelList) {
                float[] M = WinkNewAlbumDatabaseImp.M(winkNewAlbumDebugBaseModel.getPhotoID());
                Intrinsics.checkNotNullExpressionValue(M, "loadImageFeature(baseModel.photoID)");
                winkNewAlbumDebugBaseModel.n(M);
            }
            return baseModelList;
        }

        @NotNull
        public final List<WinkNewAlbumDebugBaseModel> b(@NotNull String storyID, int currentLoop, @NotNull List<WinkNewAlbumDebugBaseModel> baseModelList) {
            List mutableList;
            List<WinkNewAlbumDebugBaseModel> sortedWith;
            Intrinsics.checkNotNullParameter(storyID, "storyID");
            Intrinsics.checkNotNullParameter(baseModelList, "baseModelList");
            List<WinkNewAlbumCollectorDebugUnStoredContext> s16 = WinkNewAlbumCollectorDebugInstance.f324014a.s(storyID, currentLoop);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) baseModelList);
            for (WinkNewAlbumCollectorDebugUnStoredContext winkNewAlbumCollectorDebugUnStoredContext : s16) {
                WinkNewAlbumDebugBaseModel winkNewAlbumDebugBaseModel = new WinkNewAlbumDebugBaseModel();
                winkNewAlbumDebugBaseModel.p(winkNewAlbumCollectorDebugUnStoredContext.getPhotoID());
                winkNewAlbumDebugBaseModel.q(winkNewAlbumCollectorDebugUnStoredContext.getPhotoPath());
                winkNewAlbumDebugBaseModel.w(winkNewAlbumCollectorDebugUnStoredContext.getIsVideo());
                winkNewAlbumDebugBaseModel.s(winkNewAlbumCollectorDebugUnStoredContext.getTextSimilarity());
                winkNewAlbumDebugBaseModel.v(true);
                winkNewAlbumDebugBaseModel.o(winkNewAlbumCollectorDebugUnStoredContext.getMediaType());
                float[] M = WinkNewAlbumDatabaseImp.M(winkNewAlbumDebugBaseModel.getPhotoID());
                Intrinsics.checkNotNullExpressionValue(M, "loadImageFeature(debugBaseModel.photoID)");
                winkNewAlbumDebugBaseModel.n(M);
                mutableList.add(winkNewAlbumDebugBaseModel);
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(mutableList, new b());
            return sortedWith;
        }

        @NotNull
        public final WinkNewAlbumDebugPanelViewModel c(@NotNull WinkNewMemoryAlbumResult albumResult) {
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            int collectionSizeOrDefault2;
            Set set;
            int collectionSizeOrDefault3;
            Intrinsics.checkNotNullParameter(albumResult, "albumResult");
            WinkNewAlbumDebugPanelViewModel winkNewAlbumDebugPanelViewModel = new WinkNewAlbumDebugPanelViewModel();
            if (albumResult.g().size() != albumResult.h().size()) {
                QLog.e("WinkNewAlbumDebugManager", 1, "getDebugViewModel error, different size between all dbList: " + albumResult.g().size() + " and phtotList: " + albumResult.h().size());
                return winkNewAlbumDebugPanelViewModel;
            }
            if (albumResult.j().size() != albumResult.i().size()) {
                QLog.e("WinkNewAlbumDebugManager", 1, "getDebugViewModel error, different size between shown dbList: " + albumResult.j().size() + " and phtotList: " + albumResult.i().size());
                return winkNewAlbumDebugPanelViewModel;
            }
            winkNewAlbumDebugPanelViewModel.e(albumResult.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
            winkNewAlbumDebugPanelViewModel.j(albumResult.getStoryID());
            winkNewAlbumDebugPanelViewModel.g(albumResult.getCurrentLoop());
            List<z83.a> h16 = albumResult.h();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : h16) {
                linkedHashMap.put(((z83.a) obj).getId(), obj);
            }
            List<z83.a> i3 = albumResult.i();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(i3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = i3.iterator();
            while (it.hasNext()) {
                arrayList.add(((z83.a) it.next()).getId());
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            List<com.tencent.mobileqq.wink.newalbum.database.a> g16 = albumResult.g();
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault3);
            for (com.tencent.mobileqq.wink.newalbum.database.a aVar : g16) {
                WinkNewAlbumDebugBaseModel winkNewAlbumDebugBaseModel = new WinkNewAlbumDebugBaseModel();
                winkNewAlbumDebugBaseModel.s(aVar.getSimilarity());
                winkNewAlbumDebugBaseModel.p(aVar.getPhotoID());
                z83.a aVar2 = (z83.a) linkedHashMap.get(winkNewAlbumDebugBaseModel.getPhotoID());
                if (aVar2 != null) {
                    winkNewAlbumDebugBaseModel.q(aVar2.getPath());
                    winkNewAlbumDebugBaseModel.o(aVar2.getMediaType());
                    winkNewAlbumDebugBaseModel.w(aVar2.D());
                }
                winkNewAlbumDebugBaseModel.t(set.contains(winkNewAlbumDebugBaseModel.getPhotoID()));
                arrayList2.add(winkNewAlbumDebugBaseModel);
            }
            winkNewAlbumDebugPanelViewModel.f(arrayList2);
            return winkNewAlbumDebugPanelViewModel;
        }

        @NotNull
        public final List<WinkNewAlbumDebugBaseModel> d(@NotNull List<WinkNewAlbumDebugBaseModel> baseModelList) {
            List<WinkNewAlbumDebugBaseModel> sortedWith;
            Intrinsics.checkNotNullParameter(baseModelList, "baseModelList");
            ArrayList arrayList = new ArrayList();
            for (WinkNewAlbumDebugBaseModel winkNewAlbumDebugBaseModel : baseModelList) {
                if (winkNewAlbumDebugBaseModel.getIsShown()) {
                    arrayList.add(winkNewAlbumDebugBaseModel);
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new c());
            return sortedWith;
        }

        @NotNull
        public final List<WinkNewAlbumDebugBaseModel> e(@NotNull WinkNewAlbumDebugBaseModel selectedBaseModel, @NotNull List<WinkNewAlbumDebugBaseModel> baseModelList) {
            List<WinkNewAlbumDebugBaseModel> sortedWith;
            Intrinsics.checkNotNullParameter(selectedBaseModel, "selectedBaseModel");
            Intrinsics.checkNotNullParameter(baseModelList, "baseModelList");
            ArrayList arrayList = new ArrayList();
            for (WinkNewAlbumDebugBaseModel winkNewAlbumDebugBaseModel : baseModelList) {
                winkNewAlbumDebugBaseModel.u(selectedBaseModel.getPhotoID());
                winkNewAlbumDebugBaseModel.r(m.f324110a.e(selectedBaseModel.getImageFeature(), winkNewAlbumDebugBaseModel.getImageFeature()));
                arrayList.add(winkNewAlbumDebugBaseModel);
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new d());
            return sortedWith;
        }

        Companion() {
        }
    }
}
