package v83;

import com.tencent.biz.qqcircle.requests.QCircleNewGetUserSwitchRequest;
import com.tencent.biz.qqcircle.requests.QCircleNewSetUserSwitchRequest;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qphone.base.util.QLog;
import feedcloud.GetSwitchRsp;
import feedcloud.SetSwitchRsp;
import feedcloud.Switch;
import feedcloud.SwitchInfos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J6\u0010\u000e\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0002J\u0013\u0010\u0016\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0002R\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lv83/e;", "", "", "i", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/GetSwitchRsp;", "rsp", "e", "isChecked", "", "k", "Lv83/a;", "listener", "c", "f", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "enable", "d", "b", "Ljava/lang/String;", "TAG", "", "Lmqq/util/WeakReference;", "Ljava/util/List;", "listeners", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f441245a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "WinkNewAlbum_WinkAlbumUserSettingManager";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<a>> listeners = new ArrayList();

    e() {
    }

    private final boolean e(BaseRequest request, boolean isSuccess, long retCode, String errMsg, GetSwitchRsp rsp) {
        String traceId;
        if (request == null) {
            traceId = "";
        } else {
            traceId = request.getTraceId();
        }
        if (isSuccess && retCode == 0) {
            if (rsp == null) {
                QLog.d(TAG, 1, "[loadNetworkSwitchData] current rsp not is GetSwitchRsp.");
                return false;
            }
            SwitchInfos switchInfos = rsp.switch_.get(RFWApplication.getAccountId());
            if (switchInfos == null) {
                QLog.d(TAG, 1, "[loadNetworkSwitchData] switch should not be null.");
                return false;
            }
            Map<String, Boolean> map = switchInfos.switchInfo;
            Intrinsics.checkNotNullExpressionValue(map, "switchVal.switchInfo");
            Boolean bool = map.get(Switch.MEMORY_ALBUM.toString());
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        QLog.d(TAG, 1, "[loadNetworkSwitchData] update fail, retCode: " + retCode + " | errMsg: " + errMsg + " | traceId: " + traceId);
        return false;
    }

    private final Object i(Continuation<? super Boolean> continuation) {
        List listOf;
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String accountId = RFWApplication.getAccountId();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Switch.MEMORY_ALBUM.toString());
        VSNetworkHelper.getInstance().sendRequest(new QCircleNewGetUserSwitchRequest(accountId, listOf), new VSDispatchObserver.OnVSRspCallBack() { // from class: v83.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.j(CompletableDeferred.this, baseRequest, z16, j3, str, (GetSwitchRsp) obj);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(CompletableDeferred deferredResult, BaseRequest baseRequest, boolean z16, long j3, String str, GetSwitchRsp getSwitchRsp) {
        Intrinsics.checkNotNullParameter(deferredResult, "$deferredResult");
        boolean e16 = f441245a.e(baseRequest, z16, j3, str, getSwitchRsp);
        ar arVar = ar.f326685a;
        arVar.m(arVar.k("ae_key_editor_memory_album_enable"), e16);
        deferredResult.complete(Boolean.valueOf(e16));
    }

    private final void k(final boolean isChecked) {
        final QCircleNewSetUserSwitchRequest qCircleNewSetUserSwitchRequest = new QCircleNewSetUserSwitchRequest(RFWApplication.getAccountId(), Switch.MEMORY_ALBUM.toString(), isChecked);
        VSNetworkHelper.getInstance().sendRequest(qCircleNewSetUserSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: v83.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                e.l(QCircleNewSetUserSwitchRequest.this, isChecked, baseRequest, z16, j3, str, (SetSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QCircleNewSetUserSwitchRequest request, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String errMsg, SetSwitchRsp setSwitchRsp) {
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (z17 && j3 == 0) {
            QLog.i(TAG, 1, "[setMemoryAlbumAuthorize] one key switch change, isChecked: " + z16 + " | traceId: " + request.getTraceId() + " | cmdName: " + request.get$cmd());
            return;
        }
        QLog.e(TAG, 1, "[setMemoryAlbumAuthorize] update fail, retCode: " + j3 + " | errMsg: " + errMsg + " | traceId:" + request.getTraceId() + " | cmdName: " + request.get$cmd());
    }

    public final void c(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(new WeakReference<>(listener));
    }

    public final void d(boolean enable) {
        ar arVar = ar.f326685a;
        String k3 = arVar.k("ae_key_editor_memory_album_enable_message_push");
        QLog.d(TAG, 1, "enableMemoryAlbumMessagePush, enable:" + enable);
        arVar.m(k3, enable);
    }

    public final boolean f() {
        ar arVar = ar.f326685a;
        boolean c16 = arVar.c(arVar.k("ae_key_editor_memory_album_enable"), false);
        QLog.d(TAG, 1, "isMemoryAlbumAuthorize, ret:" + c16);
        return c16;
    }

    @Nullable
    public final Object g(@NotNull Continuation<? super Boolean> continuation) {
        ar arVar = ar.f326685a;
        String k3 = arVar.k("ae_key_editor_memory_album_enable");
        if (arVar.a(k3)) {
            boolean c16 = arVar.c(k3, false);
            QLog.d(TAG, 1, "isMemoryAlbumAuthorize, ret:" + c16);
            if (!arVar.c(arVar.k("ae_key_editor_memory_album_enable_save"), false)) {
                arVar.m(arVar.k("ae_key_editor_memory_album_enable_save"), true);
                f441245a.k(c16);
            }
            return Boxing.boxBoolean(c16);
        }
        return i(continuation);
    }

    public final boolean h() {
        ar arVar = ar.f326685a;
        boolean c16 = arVar.c(arVar.k("ae_key_editor_memory_album_enable_message_push"), true);
        QLog.d(TAG, 1, "isMemoryAlbumMessagePushEnabled, ret:" + c16);
        return c16;
    }

    public final void m(boolean isChecked) {
        ar arVar = ar.f326685a;
        arVar.m(arVar.k("ae_key_editor_memory_album_enable"), isChecked);
        QLog.d(TAG, 1, "setMemoryAlbumAuthorize, isChecked:" + isChecked);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.a(isChecked);
            }
        }
        k(isChecked);
    }
}
