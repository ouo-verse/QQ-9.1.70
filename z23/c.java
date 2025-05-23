package z23;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import e33.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaShareArkInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007Jt\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0015\u00a8\u0006\u0019"}, d2 = {"Lz23/c;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "mapId", "source", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/o;", "callback", "", "a", ISchemeApi.KEY_GUILD_ID_TYPE, "", "guildId", "channelId", "sceneType", "", "text", IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, "extInfo", "Lkotlin/Function2;", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/c$b", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaShareArkInfo> f451802a;

        b(com.tencent.mobileqq.zootopia.api.e<ZootopiaShareArkInfo> eVar) {
            this.f451802a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasShareArkService", 1, "getShareArkInfo onError " + errCode + ", " + errMsg);
            this.f451802a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data != null) {
                com.tencent.mobileqq.zootopia.api.e<ZootopiaShareArkInfo> eVar = this.f451802a;
                try {
                    sv4.d dVar = sv4.b.c(data).f434852a;
                    ZootopiaShareArkInfo zootopiaShareArkInfo = new ZootopiaShareArkInfo(dVar.f434860a);
                    String str = dVar.f434861b;
                    Intrinsics.checkNotNullExpressionValue(str, "info.mapName");
                    zootopiaShareArkInfo.k(str);
                    String str2 = dVar.f434862c;
                    Intrinsics.checkNotNullExpressionValue(str2, "info.background");
                    zootopiaShareArkInfo.e(str2);
                    String str3 = dVar.f434863d;
                    Intrinsics.checkNotNullExpressionValue(str3, "info.footerColor");
                    zootopiaShareArkInfo.i(str3);
                    String str4 = dVar.f434864e;
                    Intrinsics.checkNotNullExpressionValue(str4, "info.buttonColor");
                    zootopiaShareArkInfo.f(str4);
                    String str5 = dVar.f434865f;
                    Intrinsics.checkNotNullExpressionValue(str5, "info.button");
                    zootopiaShareArkInfo.g(str5);
                    eVar.onResultSuccess(zootopiaShareArkInfo);
                    QLog.i("ZplanVasShareArkService", 1, "getShareArkInfo success");
                } catch (Throwable unused) {
                    QLog.e("ZplanVasShareArkService", 2, "getShareArkInfo parse data error");
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/c$c", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z23.c$c */
    /* loaded from: classes36.dex */
    public static final class C11647c implements e33.b {

        /* renamed from: a */
        final /* synthetic */ Function2<Integer, String, Unit> f451803a;

        /* JADX WARN: Multi-variable type inference failed */
        C11647c(Function2<? super Integer, ? super String, Unit> function2) {
            this.f451803a = function2;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasShareArkService", 1, "sendShareArkToGuild onError " + errCode + ", " + errMsg);
            Function2<Integer, String, Unit> function2 = this.f451803a;
            Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : -999);
            if (errMsg == null) {
                errMsg = "";
            }
            function2.invoke(valueOf, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            this.f451803a.invoke(0, "");
            QLog.i("ZplanVasShareArkService", 1, "sendShareArkToGuild success");
        }
    }

    public final void a(AppInterface app, int mapId, int source, com.tencent.mobileqq.zootopia.api.e<ZootopiaShareArkInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        sv4.a aVar = new sv4.a();
        aVar.f434851a = mapId;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(shareReq)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.share_ark_svr.ShareArkSvr", "GetShareArkInfo", byteArray, emptyMap, new b(callback), source);
    }

    public static /* synthetic */ void b(c cVar, AppInterface appInterface, int i3, int i16, com.tencent.mobileqq.zootopia.api.e eVar, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        cVar.a(appInterface, i3, i16, eVar);
    }

    public final void c(AppInterface app, int mapId, int r152, long guildId, long channelId, int sceneType, String text, String r222, String extInfo, int source, Function2<? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(r222, "gameTeamParams");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (guildId != 0 && channelId > 0) {
            sv4.c cVar = new sv4.c();
            cVar.f434853a = mapId;
            ou4.a aVar = new ou4.a();
            aVar.f424104a = r152;
            aVar.f424105b = guildId;
            cVar.f434854b = aVar;
            cVar.f434855c = channelId;
            cVar.f434856d = sceneType;
            cVar.f434857e = r222;
            cVar.f434858f = text;
            cVar.f434859g = extInfo;
            IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(shareReq)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.share_ark_svr.ShareArkSvr", "SendChannelShareArk", byteArray, emptyMap, new C11647c(callback), source);
            return;
        }
        callback.invoke(-1, "guildId or channelId is null");
    }
}
