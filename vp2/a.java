package vp2;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.search.util.af;
import com.tencent.pb.share.ServicePB$CreateShareReq;
import com.tencent.pb.share.ServicePB$CreateShareRsp;
import com.tencent.pb.share.ServicePB$ShareInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import kn2.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lvp2/a;", "", "", "actionId", "c", "", "b", "Lmqq/app/AppRuntime;", "app", "resourceId", "Lkn2/e;", "shareCallback", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f443148a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"vp2/a$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vp2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C11435a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f443149d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f443150e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f443151f;

        C11435a(e eVar, String str, String str2) {
            this.f443149d = eVar;
            this.f443150e = str;
            this.f443151f = str2;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            if (errorCode == 0 && data != null) {
                ServicePB$CreateShareRsp servicePB$CreateShareRsp = new ServicePB$CreateShareRsp();
                servicePB$CreateShareRsp.mergeFrom(data);
                af afVar = af.f284993a;
                QLog.i("QS.SearchShareRepo", 1, "createShareInfo , code:" + servicePB$CreateShareRsp.err.code.get() + " msg: " + servicePB$CreateShareRsp.err.f342173msg.get(), null);
                if (QLog.isDebugVersion()) {
                    QLog.d("QS.SearchShareRepo", 2, "template_data: " + servicePB$CreateShareRsp.template_data.get() + " ", (Throwable) null);
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("QS.SearchShareRepo", 2, "plat_data: " + servicePB$CreateShareRsp.plat_data.get(), (Throwable) null);
                }
                int i3 = servicePB$CreateShareRsp.err.code.get();
                String resultErrorMsg = servicePB$CreateShareRsp.err.f342173msg.get();
                if (i3 != 0) {
                    e eVar = this.f443149d;
                    String str = this.f443150e;
                    String str2 = this.f443151f;
                    Intrinsics.checkNotNullExpressionValue(resultErrorMsg, "resultErrorMsg");
                    eVar.b(str, str2, i3, resultErrorMsg);
                    return;
                }
                e eVar2 = this.f443149d;
                String str3 = this.f443150e;
                String str4 = this.f443151f;
                String str5 = servicePB$CreateShareRsp.template_data.get();
                Intrinsics.checkNotNullExpressionValue(str5, "rsp.template_data.get()");
                String str6 = servicePB$CreateShareRsp.plat_data.get();
                Intrinsics.checkNotNullExpressionValue(str6, "rsp.plat_data.get()");
                eVar2.a(str3, str4, str5, str6);
                return;
            }
            af afVar2 = af.f284993a;
            QLog.e("QS.SearchShareRepo", 1, "createShareInfo errorCode: " + errorCode, (Throwable) null);
            this.f443149d.b(this.f443150e, this.f443151f, errorCode, "\u7f51\u7edc\u8bf7\u6c42\u9519\u8bef");
        }
    }

    a() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int b(String actionId) {
        String str;
        switch (actionId.hashCode()) {
            case -1309676322:
                str = "qqFriend";
                actionId.equals(str);
                return 1;
            case -791770330:
                if (!actionId.equals("wechat")) {
                    return 1;
                }
                return 2;
            case -755449962:
                if (!actionId.equals("wechatCircle")) {
                    return 1;
                }
                break;
            case -506195697:
                if (!actionId.equals("copyLink")) {
                    return 1;
                }
                return 5;
            case 108102557:
                if (!actionId.equals("qzone")) {
                    return 1;
                }
                return 4;
            case 512954803:
                str = "qqGuild";
                actionId.equals(str);
                return 1;
            default:
                return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String c(String actionId) {
        String str;
        switch (actionId.hashCode()) {
            case -1309676322:
                if (!actionId.equals("qqFriend")) {
                    return "h5_markdown";
                }
                return "ark_tuwen";
            case -791770330:
                str = "wechat";
                actionId.equals(str);
                return "h5_markdown";
            case -755449962:
                str = "wechatCircle";
                actionId.equals(str);
                return "h5_markdown";
            case 512954803:
                if (!actionId.equals("qqGuild")) {
                    return "h5_markdown";
                }
                break;
            default:
                return "h5_markdown";
        }
    }

    public final void a(@Nullable AppRuntime app, @Nullable String resourceId, @NotNull String actionId, @NotNull e shareCallback) {
        boolean z16;
        String str = resourceId;
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(shareCallback, "shareCallback");
        if (str != null && resourceId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && app != null) {
            String c16 = c(actionId);
            int b16 = b(actionId);
            ServicePB$CreateShareReq servicePB$CreateShareReq = new ServicePB$CreateShareReq();
            ServicePB$ShareInfo servicePB$ShareInfo = servicePB$CreateShareReq.info;
            ServicePB$ShareInfo servicePB$ShareInfo2 = new ServicePB$ShareInfo();
            servicePB$ShareInfo2.busi_id.set("qq_search_ai");
            servicePB$ShareInfo2.resource_id.set(str);
            servicePB$ShareInfo2.template.set(c16);
            servicePB$ShareInfo2.plat.set(b16);
            servicePB$ShareInfo.set(servicePB$ShareInfo2);
            af afVar = af.f284993a;
            QLog.i("QS.SearchShareRepo", 1, "createShareInfo templateString=" + c16 + " platInt=" + b16 + " resourceId=" + str, null);
            ProtoUtils.a(app, new C11435a(shareCallback, str, actionId), servicePB$CreateShareReq.toByteArray(), "OidbSvcTrpcTcp.0x9409", 37897, 3);
            return;
        }
        af afVar2 = af.f284993a;
        QLog.e("QS.SearchShareRepo", 1, "createShareInfo resourceId is null or app is null", (Throwable) null);
        if (str == null) {
            str = "";
        }
        shareCallback.b(str, actionId, -1, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
    }
}
