package v53;

import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.FilterableInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.tencent.mobileqq.wink.intermediate.protocol.SHADOW_BACKEND_INTERFACE.GetMaterialInfoByIdsRsp;
import com.tencent.mobileqq.wink.pb.GetMediaMaterialRecommendationRsp;
import com.tencent.mobileqq.wink.pb.MediaMatRecInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QShadowMaterialDistribution$CategoryMaterialsMapping;
import qshadow.QShadowMaterialDistribution$FilterableInfo;
import qshadow.QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp;
import qshadow.QShadowMaterialDistribution$GetMaterialInfoByIdsRsp;
import qshadow.QShadowMetaMaterial$AdditionalEntry;
import qshadow.QShadowMetaMaterial$CategoryInfo;
import qshadow.QShadowMetaMaterial$MaterialInfo;
import qshadow.QShadowMetaMaterial$MetaAdditionalPackage;
import qshadow.QShadowMetaMaterial$MetaSdkInfo;
import qshadow.QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp;
import qshadow.QShadowMetaMaterialRecommendation$RecommendationEntry;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\n\u001a\u00020\t*\u00020\b\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\u000e\u001a\n\u0010\u0013\u001a\u00020\u0012*\u00020\u0011\u001a\n\u0010\u0016\u001a\u00020\u0015*\u00020\u0014\u001a\n\u0010\u0019\u001a\u00020\u0018*\u00020\u0017\u001a(\u0010\u001e\u001a\u00020\u0001*\u00020\u001a2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0004\u001a\u001c\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006!"}, d2 = {"Lqshadow/QShadowMetaMaterial$CategoryInfo;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "d", "Lqshadow/QShadowMetaMaterial$MaterialInfo;", "", "urlPrefix", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "e", "Lqshadow/QShadowMetaMaterial$MetaSdkInfo;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaSdkInfo;", "f", "Lqshadow/QShadowMetaMaterial$MetaAdditionalPackage;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaAdditionalPackage;", "b", "Lqshadow/QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp;", "Lcom/tencent/mobileqq/wink/pb/GetMediaMaterialRecommendationRsp;", h.F, "Lqshadow/QShadowMetaMaterialRecommendation$RecommendationEntry;", "Lcom/tencent/mobileqq/wink/pb/MediaMatRecInfo;", "i", "Lqshadow/QShadowMaterialDistribution$GetMaterialInfoByIdsRsp;", "Lcom/tencent/mobileqq/wink/intermediate/protocol/SHADOW_BACKEND_INTERFACE/GetMaterialInfoByIdsRsp;", "g", "Lqshadow/QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp;", "Lcamera/SHADOW_BACKEND_INTERFACE/GetCatMatTreeRsp;", "a", "Lqshadow/QShadowMaterialDistribution$CategoryMaterialsMapping;", "", "materialMap", "cdnPrefix", "c", "urlString", "k", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @NotNull
    public static final GetCatMatTreeRsp a(@NotNull QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        Intrinsics.checkNotNullParameter(qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp, "<this>");
        GetCatMatTreeRsp getCatMatTreeRsp = new GetCatMatTreeRsp();
        getCatMatTreeRsp.ETag = qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.etag.get();
        String str = qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.cdnPrefixURL.get();
        if (str == null) {
            str = "";
        }
        List<QShadowMetaMaterial$MaterialInfo> list = qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.materialInfos.get();
        Intrinsics.checkNotNullExpressionValue(list, "materialInfos.get()");
        List<QShadowMetaMaterial$MaterialInfo> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (QShadowMetaMaterial$MaterialInfo qShadowMetaMaterial$MaterialInfo : list2) {
            String str2 = qShadowMetaMaterial$MaterialInfo.get().f429484id.get();
            QShadowMetaMaterial$MaterialInfo qShadowMetaMaterial$MaterialInfo2 = qShadowMetaMaterial$MaterialInfo.get();
            Intrinsics.checkNotNullExpressionValue(qShadowMetaMaterial$MaterialInfo2, "materialInfo.get()");
            Pair pair = TuplesKt.to(str2, e(qShadowMetaMaterial$MaterialInfo2, str));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        List<QShadowMaterialDistribution$CategoryMaterialsMapping> list3 = qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.categoryMaterialsMappings.get();
        Intrinsics.checkNotNullExpressionValue(list3, "this.categoryMaterialsMappings.get()");
        List<QShadowMaterialDistribution$CategoryMaterialsMapping> list4 = list3;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
        for (QShadowMaterialDistribution$CategoryMaterialsMapping it : list4) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(c(it, linkedHashMap, str));
        }
        getCatMatTreeRsp.Categories = new ArrayList<>(arrayList);
        List<QShadowMaterialDistribution$FilterableInfo> list5 = qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.filterableInfos.get();
        Intrinsics.checkNotNullExpressionValue(list5, "filterableInfos.get()");
        List<QShadowMaterialDistribution$FilterableInfo> list6 = list5;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault3);
        for (QShadowMaterialDistribution$FilterableInfo qShadowMaterialDistribution$FilterableInfo : list6) {
            FilterableInfo filterableInfo = new FilterableInfo();
            filterableInfo.FilterableField = qShadowMaterialDistribution$FilterableInfo.filterableField.get();
            filterableInfo.FilterableEnumValue = new ArrayList<>(qShadowMaterialDistribution$FilterableInfo.filterableEnumValue.get());
            arrayList2.add(filterableInfo);
        }
        getCatMatTreeRsp.FilterableInfos = new ArrayList<>(arrayList2);
        return getCatMatTreeRsp;
    }

    @NotNull
    public static final MetaAdditionalPackage b(@NotNull QShadowMetaMaterial$MetaAdditionalPackage qShadowMetaMaterial$MetaAdditionalPackage, @NotNull String urlPrefix) {
        Intrinsics.checkNotNullParameter(qShadowMetaMaterial$MetaAdditionalPackage, "<this>");
        Intrinsics.checkNotNullParameter(urlPrefix, "urlPrefix");
        return new MetaAdditionalPackage(k(qShadowMetaMaterial$MetaAdditionalPackage.lowPackageUrl.get(), urlPrefix), qShadowMetaMaterial$MetaAdditionalPackage.lowPackageMd5.get(), k(qShadowMetaMaterial$MetaAdditionalPackage.superLowPackageUrl.get(), urlPrefix), qShadowMetaMaterial$MetaAdditionalPackage.superLowPackageMd5.get(), k(qShadowMetaMaterial$MetaAdditionalPackage.midPackageUrl.get(), urlPrefix), qShadowMetaMaterial$MetaAdditionalPackage.midPackageMd5.get(), k(qShadowMetaMaterial$MetaAdditionalPackage.highPackageUrl.get(), urlPrefix), qShadowMetaMaterial$MetaAdditionalPackage.highPackageMd5.get());
    }

    @NotNull
    public static final MetaCategory c(@NotNull QShadowMaterialDistribution$CategoryMaterialsMapping qShadowMaterialDistribution$CategoryMaterialsMapping, @Nullable Map<String, MetaMaterial> map, @NotNull String cdnPrefix) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        MetaMaterial metaMaterial;
        Intrinsics.checkNotNullParameter(qShadowMaterialDistribution$CategoryMaterialsMapping, "<this>");
        Intrinsics.checkNotNullParameter(cdnPrefix, "cdnPrefix");
        ArrayList arrayList = new ArrayList();
        List<String> list = qShadowMaterialDistribution$CategoryMaterialsMapping.materialIDs.get();
        Intrinsics.checkNotNullExpressionValue(list, "materialIDs.get()");
        for (String str : list) {
            if (map != null && (metaMaterial = map.get(str)) != null) {
                arrayList.add(metaMaterial);
            }
        }
        String str2 = qShadowMaterialDistribution$CategoryMaterialsMapping.f429482id.get();
        String str3 = qShadowMaterialDistribution$CategoryMaterialsMapping.name.get();
        String k3 = k(qShadowMaterialDistribution$CategoryMaterialsMapping.thumbUrl.get(), cdnPrefix);
        List<QShadowMaterialDistribution$CategoryMaterialsMapping> list2 = qShadowMaterialDistribution$CategoryMaterialsMapping.subCategoryMaterialsMapping.get();
        Intrinsics.checkNotNullExpressionValue(list2, "subCategoryMaterialsMapping.get()");
        List<QShadowMaterialDistribution$CategoryMaterialsMapping> list3 = list2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (QShadowMaterialDistribution$CategoryMaterialsMapping it : list3) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(c(it, map, cdnPrefix));
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        List<QShadowMetaMaterial$AdditionalEntry> list4 = qShadowMaterialDistribution$CategoryMaterialsMapping.dynamicFields.get();
        Intrinsics.checkNotNullExpressionValue(list4, "dynamicFields.get()");
        List<QShadowMetaMaterial$AdditionalEntry> list5 = list4;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (QShadowMetaMaterial$AdditionalEntry qShadowMetaMaterial$AdditionalEntry : list5) {
            Pair pair = TuplesKt.to(qShadowMetaMaterial$AdditionalEntry.dynamic_key.get(), qShadowMetaMaterial$AdditionalEntry.dynamic_value.get());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new MetaCategory(str2, str3, k3, arrayList3, arrayList, linkedHashMap);
    }

    @NotNull
    public static final MetaCategory d(@NotNull QShadowMetaMaterial$CategoryInfo qShadowMetaMaterial$CategoryInfo) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(qShadowMetaMaterial$CategoryInfo, "<this>");
        String str = qShadowMetaMaterial$CategoryInfo.f429483id.get();
        String str2 = qShadowMetaMaterial$CategoryInfo.name.get();
        String str3 = qShadowMetaMaterial$CategoryInfo.thumbUrl.get();
        List<QShadowMetaMaterial$CategoryInfo> list = qShadowMetaMaterial$CategoryInfo.subCategories.get();
        Intrinsics.checkNotNullExpressionValue(list, "subCategories.get()");
        List<QShadowMetaMaterial$CategoryInfo> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (QShadowMetaMaterial$CategoryInfo it : list2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(d(it));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        List<QShadowMetaMaterial$MaterialInfo> list3 = qShadowMetaMaterial$CategoryInfo.materials.get();
        Intrinsics.checkNotNullExpressionValue(list3, "materials.get()");
        List<QShadowMetaMaterial$MaterialInfo> list4 = list3;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        for (QShadowMetaMaterial$MaterialInfo it5 : list4) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList3.add(j(it5, null, 1, null));
        }
        ArrayList arrayList4 = new ArrayList(arrayList3);
        List<QShadowMetaMaterial$AdditionalEntry> list5 = qShadowMetaMaterial$CategoryInfo.dynamicFields.get();
        Intrinsics.checkNotNullExpressionValue(list5, "dynamicFields.get()");
        List<QShadowMetaMaterial$AdditionalEntry> list6 = list5;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault3);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (QShadowMetaMaterial$AdditionalEntry qShadowMetaMaterial$AdditionalEntry : list6) {
            Pair pair = TuplesKt.to(qShadowMetaMaterial$AdditionalEntry.dynamic_key.get(), qShadowMetaMaterial$AdditionalEntry.dynamic_value.get());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new MetaCategory(str, str2, str3, arrayList2, arrayList4, linkedHashMap);
    }

    @NotNull
    public static final MetaMaterial e(@NotNull QShadowMetaMaterial$MaterialInfo qShadowMetaMaterial$MaterialInfo, @NotNull String urlPrefix) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(qShadowMetaMaterial$MaterialInfo, "<this>");
        Intrinsics.checkNotNullParameter(urlPrefix, "urlPrefix");
        String str = qShadowMetaMaterial$MaterialInfo.f429484id.get();
        QShadowMetaMaterial$MetaSdkInfo qShadowMetaMaterial$MetaSdkInfo = qShadowMetaMaterial$MaterialInfo.metaSdkInfo.get();
        Intrinsics.checkNotNullExpressionValue(qShadowMetaMaterial$MetaSdkInfo, "metaSdkInfo.get()");
        MetaSdkInfo f16 = f(qShadowMetaMaterial$MetaSdkInfo);
        String k3 = k(qShadowMetaMaterial$MaterialInfo.thumbURL.get(), urlPrefix);
        int i3 = qShadowMetaMaterial$MaterialInfo.thumbWidth.get();
        int i16 = qShadowMetaMaterial$MaterialInfo.thumbHeight.get();
        String k16 = k(qShadowMetaMaterial$MaterialInfo.packageURL.get(), urlPrefix);
        HashMap hashMap = new HashMap();
        List<QShadowMetaMaterial$AdditionalEntry> list = qShadowMetaMaterial$MaterialInfo.additionalFields.get();
        Intrinsics.checkNotNullExpressionValue(list, "additionalFields.get()");
        List<QShadowMetaMaterial$AdditionalEntry> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (QShadowMetaMaterial$AdditionalEntry qShadowMetaMaterial$AdditionalEntry : list2) {
            Pair pair = TuplesKt.to(qShadowMetaMaterial$AdditionalEntry.dynamic_key.get(), k(qShadowMetaMaterial$AdditionalEntry.dynamic_value.get(), urlPrefix));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        String str2 = qShadowMetaMaterial$MaterialInfo.checksumMd5.get();
        QShadowMetaMaterial$MetaAdditionalPackage additionalPackage = qShadowMetaMaterial$MaterialInfo.additionalPackage;
        Intrinsics.checkNotNullExpressionValue(additionalPackage, "additionalPackage");
        return new MetaMaterial(str, f16, k3, i3, i16, k16, hashMap, linkedHashMap, str2, b(additionalPackage, urlPrefix), qShadowMetaMaterial$MaterialInfo.displayName.get(), qShadowMetaMaterial$MaterialInfo.authorName.get(), false, qShadowMetaMaterial$MaterialInfo.usageCnt.get());
    }

    @NotNull
    public static final MetaSdkInfo f(@NotNull QShadowMetaMaterial$MetaSdkInfo qShadowMetaMaterial$MetaSdkInfo) {
        Intrinsics.checkNotNullParameter(qShadowMetaMaterial$MetaSdkInfo, "<this>");
        return new MetaSdkInfo(qShadowMetaMaterial$MetaSdkInfo.Sdk.get(), qShadowMetaMaterial$MetaSdkInfo.SdkVersion.get());
    }

    @NotNull
    public static final GetMaterialInfoByIdsRsp g(@NotNull QShadowMaterialDistribution$GetMaterialInfoByIdsRsp qShadowMaterialDistribution$GetMaterialInfoByIdsRsp) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(qShadowMaterialDistribution$GetMaterialInfoByIdsRsp, "<this>");
        List<QShadowMetaMaterial$MaterialInfo> list = qShadowMaterialDistribution$GetMaterialInfoByIdsRsp.materials.get();
        Intrinsics.checkNotNullExpressionValue(list, "materials.get()");
        List<QShadowMetaMaterial$MaterialInfo> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (QShadowMetaMaterial$MaterialInfo qShadowMetaMaterial$MaterialInfo : list2) {
            String str = qShadowMetaMaterial$MaterialInfo.get().f429484id.get();
            QShadowMetaMaterial$MaterialInfo qShadowMetaMaterial$MaterialInfo2 = qShadowMetaMaterial$MaterialInfo.get();
            Intrinsics.checkNotNullExpressionValue(qShadowMetaMaterial$MaterialInfo2, "materialInfo.get()");
            Pair pair = TuplesKt.to(str, j(qShadowMetaMaterial$MaterialInfo2, null, 1, null));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new GetMaterialInfoByIdsRsp(0, "", linkedHashMap);
    }

    @NotNull
    public static final GetMediaMaterialRecommendationRsp h(@NotNull QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp qShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(qShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp, "<this>");
        List<QShadowMetaMaterialRecommendation$RecommendationEntry> list = qShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp.Materials.get();
        Intrinsics.checkNotNullExpressionValue(list, "Materials.get()");
        List<QShadowMetaMaterialRecommendation$RecommendationEntry> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (QShadowMetaMaterialRecommendation$RecommendationEntry it : list2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(i(it));
        }
        Object[] array = arrayList.toArray(new MediaMatRecInfo[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new GetMediaMaterialRecommendationRsp(0, (MediaMatRecInfo[]) array, qShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp.SessionID.get(), qShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp.ExpireTime.get(), qShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp.Extra.get());
    }

    @NotNull
    public static final MediaMatRecInfo i(@NotNull QShadowMetaMaterialRecommendation$RecommendationEntry qShadowMetaMaterialRecommendation$RecommendationEntry) {
        Intrinsics.checkNotNullParameter(qShadowMetaMaterialRecommendation$RecommendationEntry, "<this>");
        QShadowMetaMaterial$MaterialInfo MaterialInfo = qShadowMetaMaterialRecommendation$RecommendationEntry.MaterialInfo;
        Intrinsics.checkNotNullExpressionValue(MaterialInfo, "MaterialInfo");
        return new MediaMatRecInfo(j(MaterialInfo, null, 1, null), qShadowMetaMaterialRecommendation$RecommendationEntry.Reason.get(), qShadowMetaMaterialRecommendation$RecommendationEntry.Confidence.get());
    }

    public static /* synthetic */ MetaMaterial j(QShadowMetaMaterial$MaterialInfo qShadowMetaMaterial$MaterialInfo, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return e(qShadowMetaMaterial$MaterialInfo, str);
    }

    private static final String k(String str, String str2) {
        String replace$default;
        if (str != null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "$host/", str2, false, 4, (Object) null);
            return replace$default;
        }
        return null;
    }
}
