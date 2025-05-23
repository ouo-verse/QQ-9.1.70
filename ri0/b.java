package ri0;

import com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f431468a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f431469b;

    static {
        int[] iArr = new int[ECSalesRankRepo.SalesRankType.values().length];
        f431468a = iArr;
        ECSalesRankRepo.SalesRankType salesRankType = ECSalesRankRepo.SalesRankType.DAILY;
        iArr[salesRankType.ordinal()] = 1;
        ECSalesRankRepo.SalesRankType salesRankType2 = ECSalesRankRepo.SalesRankType.MONTHLY;
        iArr[salesRankType2.ordinal()] = 2;
        int[] iArr2 = new int[ECSalesRankRepo.SalesRankType.values().length];
        f431469b = iArr2;
        iArr2[salesRankType.ordinal()] = 1;
        iArr2[salesRankType2.ordinal()] = 2;
    }
}
