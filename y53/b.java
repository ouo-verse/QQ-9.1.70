package y53;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.light.device.OfflineConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0002\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "a", "", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    @NotNull
    public static final MetaCategory a(@NotNull MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(metaCategory, "<this>");
        MetaCategory metaCategory2 = new MetaCategory(metaCategory.f30532id, metaCategory.name, metaCategory.thumbUrl, metaCategory.subCategories, metaCategory.materials, new HashMap(metaCategory.dynamicFields));
        ArrayList<MetaMaterial> materials = metaCategory.materials;
        if (materials != null) {
            Intrinsics.checkNotNullExpressionValue(materials, "materials");
            ArrayList arrayList = new ArrayList();
            for (MetaMaterial it : materials) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                MetaMaterial b16 = b(it);
                if (b16 != null) {
                    arrayList.add(b16);
                }
            }
            metaCategory2.materials = new ArrayList<>(arrayList);
        }
        ArrayList<MetaCategory> subCategories = metaCategory.subCategories;
        if (subCategories != null) {
            Intrinsics.checkNotNullExpressionValue(subCategories, "subCategories");
            ArrayList arrayList2 = new ArrayList();
            for (MetaCategory it5 : subCategories) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                MetaCategory a16 = a(it5);
                if (a16 != null) {
                    arrayList2.add(a16);
                }
            }
            metaCategory2.subCategories = new ArrayList<>(arrayList2);
        }
        return metaCategory2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b8, code lost:
    
        if (r4 != false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0090  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MetaMaterial b(@NotNull MetaMaterial metaMaterial) {
        boolean z16;
        int phonePerfLevel;
        Pair pair;
        String str;
        boolean z17;
        Map<String, String> map;
        boolean isBlank;
        boolean isBlank2;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean isBlank3;
        boolean isBlank4;
        boolean isBlank5;
        boolean isBlank6;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        MetaAdditionalPackage metaAdditionalPackage = metaMaterial.additionalPackage;
        if (metaAdditionalPackage == null) {
            return metaMaterial;
        }
        String str2 = metaAdditionalPackage.superLowPackageUrl;
        boolean z27 = false;
        if (str2 != null) {
            isBlank6 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank6) {
                z16 = false;
                if (z16) {
                    String str3 = metaAdditionalPackage.lowPackageUrl;
                    if (str3 != null) {
                        isBlank5 = StringsKt__StringsJVMKt.isBlank(str3);
                        if (!isBlank5) {
                            z18 = false;
                            if (z18) {
                                String str4 = metaAdditionalPackage.midPackageUrl;
                                if (str4 != null) {
                                    isBlank4 = StringsKt__StringsJVMKt.isBlank(str4);
                                    if (!isBlank4) {
                                        z19 = false;
                                        if (z19) {
                                            String str5 = metaAdditionalPackage.highPackageUrl;
                                            if (str5 != null) {
                                                isBlank3 = StringsKt__StringsJVMKt.isBlank(str5);
                                                if (!isBlank3) {
                                                    z26 = false;
                                                    if (z26) {
                                                        return metaMaterial;
                                                    }
                                                }
                                            }
                                            z26 = true;
                                            if (z26) {
                                            }
                                        }
                                    }
                                }
                                z19 = true;
                                if (z19) {
                                }
                            }
                        }
                    }
                    z18 = true;
                    if (z18) {
                    }
                }
                phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.getContext());
                if (phonePerfLevel == 1) {
                    if (phonePerfLevel != 2) {
                        if (phonePerfLevel != 3) {
                            if (phonePerfLevel != 4) {
                                if (phonePerfLevel != 5) {
                                    pair = TuplesKt.to("", "");
                                } else {
                                    pair = TuplesKt.to(metaMaterial.packageUrl, metaMaterial.packageMd5);
                                }
                            } else {
                                pair = TuplesKt.to(metaAdditionalPackage.highPackageUrl, metaAdditionalPackage.highPackageMd5);
                            }
                        } else {
                            pair = TuplesKt.to(metaAdditionalPackage.midPackageUrl, metaAdditionalPackage.midPackageMd5);
                        }
                    } else {
                        pair = TuplesKt.to(metaAdditionalPackage.lowPackageUrl, metaAdditionalPackage.lowPackageMd5);
                    }
                } else {
                    pair = TuplesKt.to(metaAdditionalPackage.superLowPackageUrl, metaAdditionalPackage.superLowPackageMd5);
                }
                str = (String) pair.component1();
                String str6 = (String) pair.component2();
                if (str != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank2) {
                        z17 = false;
                        if (!z17) {
                            if (str6 != null) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(str6);
                            }
                            z27 = true;
                            if (!z27) {
                                if (com.tencent.mobileqq.wink.editor.hdr.e.f320476a.b()) {
                                    w53.b.a("copyWithPhoneLeve", "id:" + metaMaterial.f30533id + ", phoneLevel " + OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) + ", " + str + ", " + str6);
                                }
                                metaMaterial = metaMaterial.copy();
                                if (!Intrinsics.areEqual(metaMaterial.packageUrl, str) && (map = metaMaterial.additionalFields) != null) {
                                    map.put("isDowngrade", "1");
                                }
                                metaMaterial.packageUrl = str;
                                metaMaterial.packageMd5 = str6;
                                Intrinsics.checkNotNullExpressionValue(metaMaterial, "this@copyWithPhoneLeve.c\u2026md5\n                    }");
                            }
                        }
                        return metaMaterial;
                    }
                }
                z17 = true;
                if (!z17) {
                }
                return metaMaterial;
            }
        }
        z16 = true;
        if (z16) {
        }
        phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.getContext());
        if (phonePerfLevel == 1) {
        }
        str = (String) pair.component1();
        String str62 = (String) pair.component2();
        if (str != null) {
        }
        z17 = true;
        if (!z17) {
        }
        return metaMaterial;
    }

    @NotNull
    public static final List<MetaCategory> c(@NotNull List<MetaCategory> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            MetaCategory a16 = a((MetaCategory) it.next());
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }
}
