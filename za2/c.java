package za2;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.utils.ToStringExKt;
import com.tencent.mobileqq.nearbypro.utils.i;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import e33.RspErrorData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 82\u00020\u0001:\u00029:B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0017\u001a\u00020\fJ\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\fJ\u001a\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\u0005J\b\u0010\u001c\u001a\u00020\u0005H\u0014R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020-0#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010%R \u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0015000#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010%R#\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0015000'8\u0006\u00a2\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b4\u0010+\u00a8\u0006;"}, d2 = {"Lza2/c;", "Landroidx/lifecycle/ViewModel;", "", "P1", "areaID", "", "U1", "", "Lcq4/b;", "data", "d2", "([Lcq4/b;)V", "", "roomID", "msgOffset", "W1", "Ldq4/b;", "rsp", "S1", "Lbq4/b;", "msgInfo", "", "T1", "getRoomId", "intervalMillSecond", "Z1", "b2", "X1", "onCleared", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "areaReqHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msgReqHandler", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_areaInfoLiveData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "areaInfoLiveData", "Lza2/c$a;", "E", "roomIdLiveData", "", UserInfo.SEX_FEMALE, "_areaMsgListLiveData", "G", "R1", "areaMsgListLiveData", "<init>", "()V", "H", "a", "b", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<cq4.b> _areaInfoLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<cq4.b> areaInfoLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<AreaInfo> roomIdLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<String>> _areaMsgListLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<String>> areaMsgListLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler areaReqHandler = new Handler(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler msgReqHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lza2/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "areaId", "", "b", "J", "()J", "roomId", "<init>", "(IJ)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: za2.c$a, reason: from toString */
    /* loaded from: classes15.dex */
    public static final /* data */ class AreaInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int areaId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long roomId;

        public AreaInfo() {
            this(0, 0L, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getAreaId() {
            return this.areaId;
        }

        /* renamed from: b, reason: from getter */
        public final long getRoomId() {
            return this.roomId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AreaInfo)) {
                return false;
            }
            AreaInfo areaInfo = (AreaInfo) other;
            if (this.areaId == areaInfo.areaId && this.roomId == areaInfo.roomId) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.areaId * 31) + androidx.fragment.app.a.a(this.roomId);
        }

        @NotNull
        public String toString() {
            return "AreaInfo(areaId=" + this.areaId + ", roomId=" + this.roomId + ")";
        }

        public AreaInfo(int i3, long j3) {
            this.areaId = i3;
            this.roomId = j3;
        }

        public /* synthetic */ AreaInfo(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0L : j3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"za2/c$c", "Le33/a;", "", "data", "", "onReceive", "Le33/c;", "b", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: za2.c$c, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C11667c implements e33.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f452198b;

        C11667c(int i3) {
            this.f452198b = i3;
        }

        @Override // e33.a
        public void b(@NotNull RspErrorData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ga2.a c16 = j.c();
            if (c16.isColorLevel()) {
                c16.e("AreaViewModel", "requestAreaInfo==Error errCode=" + data.getErrCode() + " errMsg=" + data.getErrMsg());
            }
            c.this.Z1(this.f452198b, 30000L);
        }

        @Override // e33.a
        public void onReceive(@Nullable byte[] data) {
            eq4.b rsp = eq4.b.c(data);
            ga2.a c16 = j.c();
            if (c16.isColorLevel()) {
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                c16.e("AreaViewModel", "requestAreaInfo==Rsp " + ToStringExKt.g(rsp));
            }
            c cVar = c.this;
            cq4.b[] bVarArr = rsp.f397039a;
            Intrinsics.checkNotNullExpressionValue(bVarArr, "rsp.simpleRoomInfos");
            cVar.d2(bVarArr);
            c.this.b2(0L, 0L);
            c.this.Z1(this.f452198b, 30000L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"za2/c$d", "Le33/a;", "", "data", "", "onReceive", "Le33/c;", "b", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements e33.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f452200b;

        d(long j3) {
            this.f452200b = j3;
        }

        @Override // e33.a
        public void b(@NotNull RspErrorData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ga2.a c16 = j.c();
            if (c16.isColorLevel()) {
                c16.e("AreaViewModel", "requestAreaMsgList==onError " + ToStringExKt.f(data));
            }
            c.this.b2(this.f452200b, 30000L);
        }

        @Override // e33.a
        public void onReceive(@Nullable byte[] data) {
            dq4.b rsp = dq4.b.c(data);
            ga2.a c16 = j.c();
            if (c16.isColorLevel()) {
                c16.e("AreaViewModel", "requestAreaMsgList==rsp size=" + rsp.f394664c.length);
            }
            c cVar = c.this;
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            cVar.S1(rsp);
            c.this.b2(rsp.f394662a, Math.max(30000L, rsp.f394663b));
        }
    }

    public c() {
        MutableLiveData<cq4.b> mutableLiveData = new MutableLiveData<>();
        this._areaInfoLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.trpcprotocol.lplan.qmeta.common.room.data.nano.SimpleRoomInfo>");
        this.areaInfoLiveData = mutableLiveData;
        this.roomIdLiveData = new MutableLiveData<>();
        MutableLiveData<List<String>> mutableLiveData2 = new MutableLiveData<>();
        this._areaMsgListLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<kotlin.String>>");
        this.areaMsgListLiveData = mutableLiveData2;
    }

    private final int P1() {
        AreaInfo value = this.roomIdLiveData.getValue();
        if (value != null) {
            return value.getAreaId();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(dq4.b rsp) {
        boolean z16;
        List list;
        int collectionSizeOrDefault;
        boolean z17;
        boolean z18;
        bq4.b[] bVarArr = rsp.f394664c;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "rsp.msgInfos");
        if (bVarArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            j.c().d("AreaViewModel", "handleChatMsg msgInfo isEmpty");
            return;
        }
        bq4.b[] bVarArr2 = rsp.f394664c;
        Intrinsics.checkNotNullExpressionValue(bVarArr2, "rsp.msgInfos");
        list = ArraysKt___ArraysKt.toList(bVarArr2);
        ArrayList<bq4.b> arrayList = new ArrayList();
        for (Object obj : list) {
            byte[] bArr = ((bq4.b) obj).f28998c;
            Intrinsics.checkNotNullExpressionValue(bArr, "it.body");
            if (bArr.length == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (bq4.b it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(T1(it));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (((String) obj2).length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList3.add(obj2);
            }
        }
        this._areaMsgListLiveData.postValue(arrayList3);
    }

    private final String T1(bq4.b msgInfo) {
        boolean z16;
        try {
            byte[] bArr = msgInfo.f28997b.f29001b;
            Intrinsics.checkNotNullExpressionValue(bArr, "msgInfo.user.nick");
            String str = new String(bArr, Charsets.UTF_8);
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = String.valueOf(msgInfo.f28997b.f29000a);
            }
            if (str.codePointCount(0, str.length()) > 6) {
                String substring = str.substring(0, str.offsetByCodePoints(0, 6));
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                str = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            return str + MsgSummary.STR_COLON + ya2.b.f449931a.a(msgInfo);
        } catch (Exception e16) {
            j.c().d("AreaViewModel", "processMsgContent error " + e16);
            return String.valueOf(msgInfo.f28997b.f29000a);
        }
    }

    private final void U1(int areaID) {
        Map emptyMap;
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaViewModel", "requestAreaInfo==Real areaID=" + areaID);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        eq4.a aVar = new eq4.a();
        aVar.f397038a = new int[]{areaID};
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] c17 = com.tencent.mobileqq.nearbypro.request.c.c(aVar);
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, appInterface, "trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr", "GetSimpleRoomInfo", c17, emptyMap, new C11667c(areaID), 0, 64, null);
    }

    private final void W1(int areaID, long roomID, long msgOffset) {
        Map emptyMap;
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaViewModel", "requestAreaMsgList==Real areaID=" + areaID + " roomID=" + roomID + " msgOffset=" + msgOffset);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        dq4.a aVar = new dq4.a();
        aVar.f394659a = areaID;
        aVar.f394660b = roomID;
        aVar.f394661c = msgOffset;
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] c17 = com.tencent.mobileqq.nearbypro.request.c.c(aVar);
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, appInterface, "trpc.qmeta.public_chat_read_svr.ChatRead", "PullMsg", c17, emptyMap, new d(msgOffset), 0, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(c this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U1(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(c this$0, int i3, long j3, long j16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W1(i3, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(cq4.b[] data) {
        boolean z16;
        if (data.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this._areaInfoLiveData.postValue(data[0]);
            if (i.f(data[0], this.roomIdLiveData.getValue())) {
                ga2.a c16 = j.c();
                if (c16.isColorLevel()) {
                    cq4.b bVar = data[0];
                    c16.e("AreaViewModel", "updateLiveData areaId=" + bVar.f391668a + " roomId=" + bVar.f391669b);
                }
                cq4.b bVar2 = data[0];
                this.roomIdLiveData = new MutableLiveData<>(new AreaInfo(bVar2.f391668a, bVar2.f391669b));
            }
        }
    }

    @NotNull
    public final LiveData<cq4.b> Q1() {
        return this.areaInfoLiveData;
    }

    @NotNull
    public final LiveData<List<String>> R1() {
        return this.areaMsgListLiveData;
    }

    public final void X1() {
        this.roomIdLiveData = new MutableLiveData<>();
        this.areaReqHandler.removeCallbacksAndMessages(null);
        this.msgReqHandler.removeCallbacksAndMessages(null);
    }

    public final void Z1(final int areaID, long intervalMillSecond) {
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaViewModel", "requestAreaInfo==Start delay=" + intervalMillSecond + " areaID=" + areaID);
        }
        this.areaReqHandler.removeCallbacksAndMessages(null);
        this.areaReqHandler.postDelayed(new Runnable() { // from class: za2.a
            @Override // java.lang.Runnable
            public final void run() {
                c.a2(c.this, areaID);
            }
        }, intervalMillSecond);
    }

    public final void b2(final long msgOffset, long intervalMillSecond) {
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaViewModel", "requestAreaMsgList==Start intervalMillSecond=" + intervalMillSecond);
        }
        this.msgReqHandler.removeCallbacksAndMessages(null);
        final int P1 = P1();
        final long roomId = getRoomId();
        this.msgReqHandler.postDelayed(new Runnable() { // from class: za2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c2(c.this, P1, roomId, msgOffset);
            }
        }, intervalMillSecond);
    }

    public final long getRoomId() {
        AreaInfo value = this.roomIdLiveData.getValue();
        if (value != null) {
            return value.getRoomId();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.areaReqHandler.removeCallbacksAndMessages(null);
        this.msgReqHandler.removeCallbacksAndMessages(null);
    }
}
