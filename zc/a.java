package zc;

import android.os.Bundle;
import com.google.protobuf.nano.MessageNano;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.tencent.biz.ProtoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\f2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006\u00a8\u0006\u0014"}, d2 = {"Lzc/a;", "", "", "data", "Lq8/b;", "e", "Lkotlin/Function1;", "", "Lq5/a;", "", "callback", "d", "", "inputString", "b", "key", "c", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    private final String b(String inputString) {
        String replaceAll = Pattern.compile("\\[(\\w+)\\]", 2).matcher(inputString).replaceAll("/$1");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "matcher.replaceAll(\"/\\$1\")");
        return replaceAll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(byte[] data, Function1<? super List<? extends q5.a>, Unit> callback) {
        List emptyList;
        q8.b e16 = e(data);
        if (e16 != null) {
            p8.a[] aVarArr = e16.f428691a;
            Intrinsics.checkNotNullExpressionValue(aVarArr, "retData.result");
            if (!(aVarArr.length == 0)) {
                ArrayList arrayList = new ArrayList();
                p8.a[] aVarArr2 = e16.f428691a;
                Intrinsics.checkNotNullExpressionValue(aVarArr2, "retData.result");
                for (p8.a aVar : aVarArr2) {
                    p8.b[] bVarArr = aVar.f425692a;
                    Intrinsics.checkNotNullExpressionValue(bVarArr, "item.texts");
                    for (p8.b bVar : bVarArr) {
                        String textStr = bVar.f425695a;
                        Intrinsics.checkNotNullExpressionValue(textStr, "textStr");
                        String splash2Emo = QzoneEmotionUtils.splash2Emo(b(textStr));
                        q5.a aVar2 = new q5.a();
                        aVar2.f428353b = splash2Emo;
                        aVar2.f428352a = QZoneCommentQuickInputHelper.f44833h;
                        arrayList.add(aVar2);
                    }
                }
                callback.invoke(arrayList);
                return;
            }
        }
        QLog.e("QZoneQuickCommentRepo", 1, "handleContentData error. data is null or empty.");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        callback.invoke(emptyList);
    }

    private final q8.b e(byte[] data) {
        try {
            return q8.b.c(data);
        } catch (Exception e16) {
            QLog.e("QZoneQuickCommentRepo", 1, "parseContentRsp error. " + e16);
            return null;
        }
    }

    public final void c(String key, Function1<? super List<? extends q5.a>, Unit> callback) {
        List emptyList;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.qzone.component.a aVar = com.qzone.component.a.f46288a;
        byte[] a16 = aVar.a(key);
        if (a16 != null) {
            QLog.i("QZoneQuickCommentRepo", 1, "has get AI quick comment from cache. key: " + key + ", cache count: " + aVar.c());
            d(a16, callback);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("QZoneQuickCommentRepo", 1, "get AI quick comment error. appRuntime is null.");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.invoke(emptyList);
        } else {
            q8.a aVar2 = new q8.a();
            aVar2.f428689a = 100002L;
            aVar2.f428690b = key;
            ProtoUtils.a(peekAppRuntime, new b(callback, key, this), MessageNano.toByteArray(aVar2), "OidbSvcTrpcTcp.0x93af", 37807, 2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"zc/a$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<List<? extends q5.a>, Unit> f452299d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f452300e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f452301f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super List<? extends q5.a>, Unit> function1, String str, a aVar) {
            this.f452299d = function1;
            this.f452300e = str;
            this.f452301f = aVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            List<? extends q5.a> emptyList;
            QLog.e("QZoneQuickCommentRepo", 1, "request QZone AI quick comment error. errorCode: " + errorCode + ", errorMsg: " + errorMsg);
            Function1<List<? extends q5.a>, Unit> function1 = this.f452299d;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            function1.invoke(emptyList);
            return super.onError(errorCode, errorMsg, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            List<? extends q5.a> emptyList;
            if (errorCode == 0 && data != null) {
                com.qzone.component.a aVar = com.qzone.component.a.f46288a;
                aVar.b(this.f452300e, data);
                QLog.i("QZoneQuickCommentRepo", 1, "current size of AI cache: " + aVar.c());
                this.f452301f.d(data, this.f452299d);
                return;
            }
            Function1<List<? extends q5.a>, Unit> function1 = this.f452299d;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            function1.invoke(emptyList);
        }
    }
}
