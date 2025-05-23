package vz2;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdLoadHelper;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdReportHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J8\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011R*\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R*\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R&\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001dR2\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00070\u001fj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0007` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lvz2/b;", "", "", "b", "c", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "advCallback", "", "maskPosId", "tianShuMaskPosId", GetAdInfoRequest.SOURCE_FROM, "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "maskAdvName", "", "disableMaskAdReq", "d", "f", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "a", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mMaskAdInfoList", "mTianShuAdInfoList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mCachedAidSet", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "mCachedFilePathMap", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: b, reason: from kotlin metadata */
    @Nullable
    private static ArrayList<JSONObject> mMaskAdInfoList;

    /* renamed from: c, reason: from kotlin metadata */
    @Nullable
    private static ArrayList<JSONObject> mTianShuAdInfoList;

    /* renamed from: a */
    @NotNull
    public static final b f443772a = new b();

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static HashSet<Long> mCachedAidSet = new HashSet<>();

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private static HashMap<Long, String> mCachedFilePathMap = new HashMap<>();

    b() {
    }

    private final void b() {
        ArrayList<JSONObject> arrayList = mMaskAdInfoList;
        if (arrayList != null) {
            Iterator<JSONObject> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong = next.optLong("aid", 0L);
                if (optLong != 0) {
                    mCachedAidSet.add(Long.valueOf(optLong));
                    HashMap<Long, String> hashMap = mCachedFilePathMap;
                    Long valueOf = Long.valueOf(optLong);
                    String optString = next.optString(AdHippyFragment.RES_PATH, "");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(AdHippyFragment.RES_PATH, \"\")");
                    hashMap.put(valueOf, optString);
                }
            }
        }
        ArrayList<JSONObject> arrayList2 = mTianShuAdInfoList;
        if (arrayList2 != null) {
            Iterator<JSONObject> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                JSONObject next2 = it5.next();
                long optLong2 = next2.optLong("aid", 0L);
                if (optLong2 != 0) {
                    mCachedAidSet.add(Long.valueOf(optLong2));
                    HashMap<Long, String> hashMap2 = mCachedFilePathMap;
                    Long valueOf2 = Long.valueOf(optLong2);
                    String optString2 = next2.optString(AdHippyFragment.RES_PATH, "");
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(AdHippyFragment.RES_PATH, \"\")");
                    hashMap2.put(valueOf2, optString2);
                }
            }
        }
    }

    private final void c() {
        MaskAdReportHelper.INSTANCE.reportAction("new_folder_splashad_requestwithsource", "", "", "2", "");
    }

    public static /* synthetic */ void e(b bVar, VasAdCallback vasAdCallback, String str, String str2, String str3, MaskAdvName maskAdvName, boolean z16, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z16 = false;
        }
        bVar.d(vasAdCallback, str, str2, str3, maskAdvName, z16);
    }

    @NotNull
    public final String a(@NotNull GdtAd ad5) {
        String str;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        QLog.d("MaskAdRequestHelper", 1, "getAdResPath: aid:", Long.valueOf(ad5.getAId()));
        if (!mCachedFilePathMap.containsKey(Long.valueOf(ad5.getAId())) || (str = mCachedFilePathMap.get(Long.valueOf(ad5.getAId()))) == null) {
            return "";
        }
        return str;
    }

    public final void d(@NotNull VasAdCallback advCallback, @NotNull String maskPosId, @NotNull String tianShuMaskPosId, @NotNull String r102, @NotNull MaskAdvName maskAdvName, boolean disableMaskAdReq) {
        Intrinsics.checkNotNullParameter(advCallback, "advCallback");
        Intrinsics.checkNotNullParameter(maskPosId, "maskPosId");
        Intrinsics.checkNotNullParameter(tianShuMaskPosId, "tianShuMaskPosId");
        Intrinsics.checkNotNullParameter(r102, "sourceFrom");
        Intrinsics.checkNotNullParameter(maskAdvName, "maskAdvName");
        mMaskAdInfoList = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(maskAdvName);
        mTianShuAdInfoList = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.TIANSHU);
        b();
        boolean z16 = true;
        QLog.d("MaskAdRequestHelper", 1, "requestMaskAd reqPublicAccountAd");
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add(maskPosId);
        build.getAdvPos().add(tianShuMaskPosId);
        build.setUin(MaskAdLoadHelper.INSTANCE.getCurrentUin());
        build.setBusiType(Integer.valueOf(com.tencent.mobileqq.vas.adv.api.impl.b.b(com.tencent.mobileqq.vas.adv.api.impl.b.f307952a, maskPosId, 0, 2, null)));
        build.setSpecifiedAdsJsonList(mMaskAdInfoList);
        build.setSpecifiedTianShuAdsJsonList(mTianShuAdInfoList);
        build.setTargetPosId(maskPosId);
        build.setTianShuPosId(tianShuMaskPosId);
        build.setSourceFrom(r102);
        build.setDisableMaskReq(disableMaskAdReq);
        iVasAdvApi.requestAd(build, advCallback);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AdHippyFragment.AID_SET, mCachedAidSet.toString());
        c.f443777a.a(MaskAdvName.QQ_HEALTH, AdHippyFragment.MASK_AD_DISPLAY_REQUEST_START, jSONObject);
        ArrayList<JSONObject> arrayList = mMaskAdInfoList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            c();
        }
    }

    public final void f(@NotNull MaskAdvName maskAdvName) {
        Intrinsics.checkNotNullParameter(maskAdvName, "maskAdvName");
        mMaskAdInfoList = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(maskAdvName);
        b();
    }
}
