package y84;

import com.epicgames.ue4.ZPlanVersion;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;
import tv4.f;
import zb3.FriendsDressUpData;
import zb3.FriendsRespData;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011J.\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\u0002\u00a8\u0006\u001b"}, d2 = {"Ly84/d;", "", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/common/app/AppInterface;", "c", "data", "Ltv4/d;", "i", "Ltv4/f;", "j", "", "uin", "Lzb3/b;", "", "f", "friendUin", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/google/protobuf/nano/MessageNano;", h.F, "start", "offsetParam", "sessionID", "d", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f449567a = new d();

    d() {
    }

    private final AppInterface c(e<?> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
        }
        if (z16) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    public final void d(long start, long offsetParam, long sessionID, final e<FriendsRespData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface c16 = c(callback);
        if (c16 == null) {
            return;
        }
        QLog.i("ZootopiaFriendsDressUpService", 1, "getFriendZPlanInfo, start=" + start);
        tv4.c cVar = new tv4.c();
        String currentAccountUin = c16.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        cVar.f437561a = Long.parseLong(currentAccountUin);
        cVar.f437562b = start;
        cVar.f437563c = offsetParam;
        cVar.f437564d = ZPlanVersion.ZPlanVersion;
        cVar.f437565e = 6100L;
        cVar.f437566f = sessionID;
        cVar.f437567g = VasUtil.getSignedService(c16).getVipStatus().isSVip();
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        Intrinsics.checkNotNull(a16);
        a16.request("trpc.zplan.spring_festival.Portal.SsoGetFriendZPlanInfo", MessageNano.toByteArray(cVar), new BusinessObserver() { // from class: y84.c
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                d.e(e.this, i3, z16, obj);
            }
        });
    }

    public final void f(long uin, final e<FriendsRespData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface c16 = c(callback);
        if (c16 == null) {
            return;
        }
        MessageNano h16 = h(uin, c16);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.spring_festival.Portal.SsoGetSingleFriendZplanInfo", MessageNano.toByteArray(h16), new BusinessObserver() { // from class: y84.b
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    d.g(e.this, i3, z16, obj);
                }
            });
        }
    }

    public final MessageNano h(long friendUin, AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        tv4.e eVar = new tv4.e();
        eVar.f437576b = 6100L;
        eVar.f437575a = friendUin;
        eVar.f437577c = VasUtil.getSignedService(appRuntime).getVipStatus().isSVip();
        eVar.f437578d = ZPlanVersion.ZPlanVersion;
        return eVar;
    }

    private final tv4.d i(Object data) {
        try {
            return tv4.d.c(data instanceof byte[] ? (byte[]) data : null);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("ZootopiaFriendsDressUpService", 1, "getFriendPlanInfo parse failed.", e16);
            return null;
        }
    }

    private final f j(Object data) {
        try {
            return f.c(data instanceof byte[] ? (byte[]) data : null);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("ZootopiaFriendsDressUpService", 1, "getFriendPlanInfo parse failed.", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e callback, int i3, boolean z16, Object obj) {
        List zip;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!z16) {
            callback.onResultFailure(1000, "\u8bf7\u6c42\u5931\u8d25\uff0c\u672a\u77e5\u9519\u8bef");
            QLog.e("ZootopiaFriendsDressUpService", 1, "getFriendZPlanInfo failed.");
            return;
        }
        tv4.d i16 = f449567a.i(obj);
        if (i16 == null) {
            callback.onResultFailure(2000, "\u89e3\u6790\u8fd4\u56de\u6570\u636e\u5931\u8d25");
            return;
        }
        tv4.b[] bVarArr = i16.f437571d;
        if (bVarArr.length != i16.f437572e.length) {
            callback.onResultFailure(3000, "\u597d\u53cb\u9759\u6001\u56fe\u6570\u636e\u5927\u5c0f\u4e0e\u597d\u53cb\u52a8\u4f5c\u6570\u636e\u5927\u5c0f\u4e0d\u5339\u914d");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(bVarArr, "resp.friendZplanInfoList");
        tv4.a[] aVarArr = i16.f437572e;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "resp.avatarActionList");
        zip = ArraysKt___ArraysKt.zip(bVarArr, aVarArr);
        List list = zip;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Pair pair = (Pair) it.next();
            long j3 = ((tv4.b) pair.getFirst()).f437557a;
            String str = ((tv4.b) pair.getFirst()).f437558b;
            Intrinsics.checkNotNullExpressionValue(str, "it.first.materialUrl");
            String str2 = ((tv4.b) pair.getFirst()).f437559c;
            Intrinsics.checkNotNullExpressionValue(str2, "it.first.compressUrl");
            String str3 = ((tv4.b) pair.getFirst()).f437560d;
            Intrinsics.checkNotNullExpressionValue(str3, "it.first.scheme");
            String str4 = ((tv4.a) pair.getSecond()).f437551b;
            Intrinsics.checkNotNullExpressionValue(str4, "it.second.headMontagePath");
            String str5 = ((tv4.a) pair.getSecond()).f437552c;
            Intrinsics.checkNotNullExpressionValue(str5, "it.second.bodyMontagePath");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new FriendsDressUpData(j3, str, str2, str3, str4, str5, ((tv4.a) pair.getSecond()).f437553d, ((tv4.a) pair.getSecond()).f437554e, ((tv4.a) pair.getSecond()).f437555f));
            i16 = i16;
            arrayList = arrayList2;
        }
        tv4.d dVar = i16;
        ArrayList arrayList3 = arrayList;
        long j16 = dVar.f437568a;
        long j17 = dVar.f437569b;
        boolean z17 = dVar.f437570c != 1;
        long j18 = dVar.f437573f;
        String str6 = dVar.f437574g;
        Intrinsics.checkNotNullExpressionValue(str6, "resp.svipFriendMaxVotesNotice");
        callback.onResultSuccess(new FriendsRespData(j16, j17, arrayList3, z17, j18, str6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e callback, int i3, boolean z16, Object obj) {
        List listOf;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!z16) {
            callback.onResultFailure(1000, "\u8bf7\u6c42\u5931\u8d25\uff0c\u672a\u77e5\u9519\u8bef");
            QLog.e("ZootopiaFriendsDressUpService", 1, "getSingleFriendZPlanInfo failed.");
            return;
        }
        f j3 = f449567a.j(obj);
        tv4.b bVar = j3 != null ? j3.f437579a : null;
        tv4.a aVar = j3 != null ? j3.f437580b : null;
        if (bVar != null && aVar != null) {
            long j16 = bVar.f437557a;
            String str = bVar.f437558b;
            Intrinsics.checkNotNullExpressionValue(str, "friendZPlanInfo.materialUrl");
            String str2 = bVar.f437559c;
            Intrinsics.checkNotNullExpressionValue(str2, "friendZPlanInfo.compressUrl");
            String str3 = bVar.f437560d;
            Intrinsics.checkNotNullExpressionValue(str3, "friendZPlanInfo.scheme");
            String str4 = aVar.f437551b;
            Intrinsics.checkNotNullExpressionValue(str4, "avatarAction.headMontagePath");
            String str5 = aVar.f437552c;
            Intrinsics.checkNotNullExpressionValue(str5, "avatarAction.bodyMontagePath");
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new FriendsDressUpData(j16, str, str2, str3, str4, str5, aVar.f437553d, aVar.f437554e, aVar.f437555f));
            long j17 = j3.f437581c;
            String str6 = j3.f437582d;
            Intrinsics.checkNotNullExpressionValue(str6, "rsp.svipFriendMaxVotesNotice");
            callback.onResultSuccess(new FriendsRespData(0L, 0L, listOf, false, j17, str6));
            return;
        }
        callback.onResultFailure(2000, "\u89e3\u6790\u8fd4\u56de\u6570\u636e\u5931\u8d25");
    }
}
