package yf2;

import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.f;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$GetUserSettingsReq;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$GetUserSettingsRsp;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$MsgTypeItem;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$SetMsgStatusReq;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$SetMsgStatusRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import zf2.MessageSettingItem;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0014\u0010\n\u001a\u00020\t*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J\f\u0010\u000b\u001a\u00020\u0006*\u00020\tH\u0002J\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lyf2/b;", "", "", "Lcom/tencent/mobileqq/qqecommerce/repo/pbfile/sellerMsgConfig$MsgTypeItem;", "Lzf2/c;", "d", "", "", "switchable", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "e", "f", "Lwf2/a;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "messageType", "newStatus", "g", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "isSuccess", "", "<anonymous parameter 1>", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "Ltencent/trpcprotocol/b;", "response", "", "a", "(ZILorg/json/JSONObject;Ltencent/trpcprotocol/b;)V"}, k = 3, mv = {1, 7, 1})
    /* renamed from: yf2.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    static final class C11610b implements l52.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<NetworkResult<MessageSettingItem>> f450237b;

        /* JADX WARN: Multi-variable type inference failed */
        C11610b(CancellableContinuation<? super NetworkResult<MessageSettingItem>> cancellableContinuation) {
            this.f450237b = cancellableContinuation;
        }

        @Override // l52.a
        public final void a(boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean z17 = true;
            if (z16) {
                if ((bVar != null ? bVar.f436079c : null) != null) {
                    sellerMsgConfig$GetUserSettingsRsp sellermsgconfig_getusersettingsrsp = new sellerMsgConfig$GetUserSettingsRsp();
                    MessageMicro.mergeFrom(sellermsgconfig_getusersettingsrsp, bVar.f436079c);
                    b bVar2 = b.this;
                    List<sellerMsgConfig$MsgTypeItem> list = sellermsgconfig_getusersettingsrsp.items.get();
                    Intrinsics.checkNotNullExpressionValue(list, "rspParam.items.get()");
                    emptyList = bVar2.d(list);
                    QLog.d("ECMsgCenter|MsgSettingsRemoteDataSource", 2, "fetchMsgSettings succeed. size: " + emptyList.size());
                    CancellableContinuation<NetworkResult<MessageSettingItem>> cancellableContinuation = this.f450237b;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new NetworkResult(emptyList, z17, false, 4, null)));
                }
            }
            QLog.e("ECMsgCenter|MsgSettingsRemoteDataSource", 1, "fetchMsgSettings failed. isSuccess: " + z16 + ", errorCode: " + (bVar != null ? Integer.valueOf(bVar.f436077a) : null));
            z17 = false;
            CancellableContinuation<NetworkResult<MessageSettingItem>> cancellableContinuation2 = this.f450237b;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new NetworkResult(emptyList, z17, false, 4, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MessageSettingItem> d(List<sellerMsgConfig$MsgTypeItem> list) {
        int collectionSizeOrDefault;
        List<sellerMsgConfig$MsgTypeItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (sellerMsgConfig$MsgTypeItem sellermsgconfig_msgtypeitem : list2) {
            int i3 = sellermsgconfig_msgtypeitem.msg_type.get();
            String str = sellermsgconfig_msgtypeitem.msg_name.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.msg_name.get()");
            arrayList.add(new MessageSettingItem(new MessageType(i3, str), e(sellermsgconfig_msgtypeitem.status.get(), sellermsgconfig_msgtypeitem.enable_switch.get())));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f(e eVar) {
        if (eVar instanceof com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a) {
            return 1;
        }
        if (eVar instanceof f) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object c(Continuation<? super NetworkResult<MessageSettingItem>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).ssoForward("trpc.ecom.seller_msg_config.SellerMsgConfig", "/trpc.ecom.seller_msg_config.SellerMsgConfig/GetUserSettings", new MessageMicro<sellerMsgConfig$GetUserSettingsReq>() { // from class: com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgConfig$GetUserSettingsReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], sellerMsgConfig$GetUserSettingsReq.class);
        }.toByteArray(), 1, (Map<Object, ? extends Object>) null, new C11610b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object g(MessageType messageType, e eVar, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        sellerMsgConfig$SetMsgStatusReq sellermsgconfig_setmsgstatusreq = new sellerMsgConfig$SetMsgStatusReq();
        sellermsgconfig_setmsgstatusreq.msg_type.set(messageType.getId());
        sellermsgconfig_setmsgstatusreq.status.set(f(eVar));
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).ssoForward("trpc.ecom.seller_msg_config.SellerMsgConfig", "/trpc.ecom.seller_msg_config.SellerMsgConfig/SetMsgStatus", sellermsgconfig_setmsgstatusreq.toByteArray(), 1, (Map<Object, ? extends Object>) null, new c(eVar, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "isSuccess", "", "<anonymous parameter 1>", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "Ltencent/trpcprotocol/b;", "response", "", "a", "(ZILorg/json/JSONObject;Ltencent/trpcprotocol/b;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    static final class c implements l52.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f450239b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f450240c;

        /* JADX WARN: Multi-variable type inference failed */
        c(e eVar, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f450239b = eVar;
            this.f450240c = cancellableContinuation;
        }

        @Override // l52.a
        public final void a(boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
            if (z16) {
                if ((bVar != null ? bVar.f436079c : null) != null) {
                    sellerMsgConfig$SetMsgStatusRsp sellermsgconfig_setmsgstatusrsp = new sellerMsgConfig$SetMsgStatusRsp();
                    MessageMicro.mergeFrom(sellermsgconfig_setmsgstatusrsp, bVar.f436079c);
                    r5 = sellermsgconfig_setmsgstatusrsp.status.get() == b.this.f(this.f450239b);
                    QLog.d("ECMsgCenter|MsgSettingsRemoteDataSource", 2, "updateMsgTypeStatus. isSuccess: " + z16 + ", result: " + r5);
                    CancellableContinuation<Boolean> cancellableContinuation = this.f450240c;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(r5)));
                }
            }
            QLog.e("ECMsgCenter|MsgSettingsRemoteDataSource", 1, "updateMsgTypeStatus failed. isSuccess: " + z16 + ", errorCode: " + (bVar != null ? Integer.valueOf(bVar.f436077a) : null));
            CancellableContinuation<Boolean> cancellableContinuation2 = this.f450240c;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.valueOf(r5)));
        }
    }

    private final e e(int i3, boolean z16) {
        if (i3 == 2) {
            return new f(z16);
        }
        return new com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.a(z16);
    }
}
