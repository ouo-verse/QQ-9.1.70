package wh0;

import android.text.TextUtils;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.detail.repo.saas.b;
import com.tencent.ecommerce.biz.detail.repo.saas.c;
import com.tencent.ecommerce.biz.detail.repo.shop.preload.ECShopDetailPagePreloadManager;
import com.tencent.ecommerce.biz.util.g;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fR \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lwh0/a;", "", "", "saasProductId", "saasType", "", "goodsType", "", "f", "productID", "recallChannel", "e", "", "isHost", "productId", "Lorg/json/JSONObject;", "d", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "detailPageHostCache", "b", "detailPageCustomCache", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "detailPageHostIsRequestingList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f445642d = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, JSONObject> detailPageHostCache = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, JSONObject> detailPageCustomCache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> detailPageHostIsRequestingList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"wh0/a$a", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/detail/repo/saas/b;", "Lcom/tencent/ecommerce/biz/detail/repo/saas/c;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: wh0.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11483a implements IECNetworkCallback<b, c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f445643a;

        C11483a(String str) {
            this.f445643a = str;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(b reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECDetailPagePreloadManager", "[preloadHostDetailPage]", "preload failed, code = " + errorResponse.getCode() + ", msg = " + errorResponse.getMsg());
            a.b(a.f445642d).remove(this.f445643a);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(b reqModel, c respModel) {
            if (cg0.a.c()) {
                cg0.a.b("ECDetailPagePreloadManager", "[preloadHostDetailPage] finished, saasProductId = " + this.f445643a + ", dataJson = " + respModel.getDataJson());
            }
            a aVar = a.f445642d;
            a.b(aVar).remove(this.f445643a);
            JSONObject dataJson = respModel.getDataJson();
            if (dataJson != null) {
                a.a(aVar).put(this.f445643a, dataJson);
                ng0.a aVar2 = ng0.a.f420126b;
                g gVar = g.f104867a;
                aVar2.b(gVar.b(gVar.a(respModel.getMainPics()), 1));
            }
        }
    }

    a() {
    }

    public static final /* synthetic */ ConcurrentHashMap a(a aVar) {
        return detailPageHostCache;
    }

    public static final /* synthetic */ ArrayList b(a aVar) {
        return detailPageHostIsRequestingList;
    }

    public final void e(String productID, String goodsType, String recallChannel) {
        if (TextUtils.isEmpty(productID)) {
            return;
        }
        if (Intrinsics.areEqual(recallChannel, String.valueOf(10)) || Intrinsics.areEqual(recallChannel, String.valueOf(13)) || Intrinsics.areEqual(goodsType, String.valueOf(101))) {
            ECShopDetailPagePreloadManager.f102383c.c(productID);
        }
        cg0.a.b("ECDetailPagePreloadManager", "[preloadCustomDetailPage] productID = " + productID + ", goodsType = " + goodsType + ", recallChannel = " + recallChannel);
    }

    public final void f(String saasProductId, String saasType, int goodsType) {
        if (TextUtils.isEmpty(saasProductId)) {
            return;
        }
        if ((goodsType == 2 || goodsType == 3) && !detailPageHostCache.containsKey(saasProductId)) {
            ArrayList<String> arrayList = detailPageHostIsRequestingList;
            if (arrayList.contains(saasProductId)) {
                return;
            }
            if (cg0.a.c()) {
                cg0.a.b("ECDetailPagePreloadManager", "[preloadHostDetailPage] saasProductId = " + saasProductId + ", saasType = " + saasType + ", goodsType = " + goodsType);
            }
            com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.shop_product_detail_server.ProductInfo", "/trpc.ecom.shop_product_detail_server.ProductInfo/GetProductDetailBySeller", new b(saasType, saasProductId, goodsType), new c(), new C11483a(saasProductId));
            arrayList.add(saasProductId);
        }
    }

    public final void c(boolean isHost) {
        if (isHost) {
            detailPageHostCache.clear();
        } else {
            detailPageCustomCache.clear();
        }
    }

    public final JSONObject d(boolean isHost, String productId) {
        if (isHost) {
            return detailPageHostCache.get(productId);
        }
        return detailPageCustomCache.get(productId);
    }
}
