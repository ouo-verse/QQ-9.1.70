package xf2;

import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$GetTabsReq;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$GetTabsRsp;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$TabItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.json.JSONObject;
import wf2.NetworkResult;
import zf2.PromotionPanelItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lxf2/b;", "", "", "Lcom/tencent/mobileqq/qqecommerce/repo/pbfile/sellerMsgConfig$TabItem;", "Lzf2/d;", "c", "Lwf2/a;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "isSuccess", "", "<anonymous parameter 1>", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "Ltencent/trpcprotocol/b;", "response", "", "a", "(ZILorg/json/JSONObject;Ltencent/trpcprotocol/b;)V"}, k = 3, mv = {1, 7, 1})
    /* renamed from: xf2.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    static final class C11542b implements l52.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<NetworkResult<PromotionPanelItem>> f447872b;

        /* JADX WARN: Multi-variable type inference failed */
        C11542b(CancellableContinuation<? super NetworkResult<PromotionPanelItem>> cancellableContinuation) {
            this.f447872b = cancellableContinuation;
        }

        @Override // l52.a
        public final void a(boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean z17 = true;
            if (z16) {
                if ((bVar != null ? bVar.f436079c : null) != null) {
                    sellerMsgConfig$GetTabsRsp sellermsgconfig_gettabsrsp = new sellerMsgConfig$GetTabsRsp();
                    MessageMicro.mergeFrom(sellermsgconfig_gettabsrsp, bVar.f436079c);
                    b bVar2 = b.this;
                    List<sellerMsgConfig$TabItem> list = sellermsgconfig_gettabsrsp.items.get();
                    Intrinsics.checkNotNullExpressionValue(list, "rspParam.items.get()");
                    emptyList = bVar2.c(list);
                    QLog.d("ECMsgCenter|PromotionRemoteDataSource", 2, "fetchPromotionItemList succeed.");
                    CancellableContinuation<NetworkResult<PromotionPanelItem>> cancellableContinuation = this.f447872b;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new NetworkResult(emptyList, z17, false, 4, null)));
                }
            }
            QLog.e("ECMsgCenter|PromotionRemoteDataSource", 1, "fetchPromotionItemList failed. isSuccess: " + z16 + ", errorCode: " + (bVar != null ? Integer.valueOf(bVar.f436077a) : null));
            z17 = false;
            CancellableContinuation<NetworkResult<PromotionPanelItem>> cancellableContinuation2 = this.f447872b;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new NetworkResult(emptyList, z17, false, 4, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PromotionPanelItem> c(List<sellerMsgConfig$TabItem> list) {
        int collectionSizeOrDefault;
        List<sellerMsgConfig$TabItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (sellerMsgConfig$TabItem sellermsgconfig_tabitem : list2) {
            String str = sellermsgconfig_tabitem.name.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.name.get()");
            String str2 = sellermsgconfig_tabitem.icon_url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "it.icon_url.get()");
            String str3 = sellermsgconfig_tabitem.night_icon_url.get();
            Intrinsics.checkNotNullExpressionValue(str3, "it.night_icon_url.get()");
            String str4 = sellermsgconfig_tabitem.jump_url.get();
            Intrinsics.checkNotNullExpressionValue(str4, "it.jump_url.get()");
            arrayList.add(new PromotionPanelItem(str, str2, str3, str4));
        }
        return arrayList;
    }

    public final Object b(Continuation<? super NetworkResult<PromotionPanelItem>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).ssoForward("trpc.ecom.seller_msg_config.TabService", "/trpc.ecom.seller_msg_config.TabService/GetTabs", new MessageMicro<sellerMsgConfig$GetTabsReq>() { // from class: com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$GetTabsReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], sellerMsgConfig$GetTabsReq.class);
        }.toByteArray(), 1, (Map<Object, ? extends Object>) null, new C11542b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
