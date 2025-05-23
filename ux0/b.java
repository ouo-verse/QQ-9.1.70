package ux0;

import android.content.Context;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.icgame.trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignRsp;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.utils.IResultListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\b\b*\u0001C\u0018\u0000 I2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0018\u0010&\u001a\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020 0<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006J"}, d2 = {"Lux0/b;", "Lsx0/b;", "Lcom/tencent/imsdk/v2/V2TIMSDKListener;", "listener", "", "W3", "V3", "d4", "", ICustomDataEditor.STRING_ARRAY_PARAM_4, "Z3", "Y3", "c4", "", "errorCode", "", "errorMessage", "b4", "Ltx0/b;", "U3", "", "yesUid", "Lcom/tencent/icgame/game/tim/api/message/c;", BdhLogUtil.LogTag.Tag_Conn, "groupId", "M", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "S0", "Landroid/content/Context;", "context", "init", "Lsx0/a;", "callback", "Z2", "logout", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/trpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "O", "o2", "a", "Ljava/lang/String;", "imSdkSoPath", "b", "Ltx0/b;", "groupManager", "", "c", "Ljava/util/Map;", "mapC2CMessageManager", "d", "mapGroupMessageManager", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/icgame/game/tim/api/message/d;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "msgListeners", "f", "Z", "isLogining", "", "g", "Ljava/util/List;", "loginCallbacks", tl.h.F, "Lcom/tencent/icgame/trpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "userSign", "ux0/b$g", "i", "Lux0/b$g;", "msgListener", "<init>", "()V", "j", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b implements sx0.b {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f440509k;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private tx0.b groupManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isLogining;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String imSdkSoPath = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, com.tencent.icgame.game.tim.api.message.c> mapC2CMessageManager = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, com.tencent.icgame.game.tim.api.message.c> mapGroupMessageManager = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<com.tencent.icgame.game.tim.api.message.d> msgListeners = new CopyOnWriteArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<sx0.a> loginCallbacks = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TcloudServerOuterClass$GetUserTCloudSignRsp userSign = new TcloudServerOuterClass$GetUserTCloudSignRsp();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private g msgListener = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"ux0/b$b", "Lox0/c;", "Lcom/tencent/icgame/trpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ux0.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C11371b implements ox0.c<TcloudServerOuterClass$GetUserTCloudSignRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> f440519a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f440520b;

        C11371b(IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> iResultListener, b bVar) {
            this.f440519a = iResultListener;
            this.f440520b = bVar;
        }

        @Override // ox0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable TcloudServerOuterClass$GetUserTCloudSignRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> iResultListener = this.f440519a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // ox0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable TcloudServerOuterClass$GetUserTCloudSignRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            if (response != null) {
                this.f440520b.userSign = response;
            }
            IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> iResultListener = this.f440519a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"ux0/b$c", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "", "onSuccess", "", "errorCode", "", "errorMessage", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements V2TIMCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f440521a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f440522b;

        c(String str, b bVar) {
            this.f440521a = str;
            this.f440522b = bVar;
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.icgame.game.utils.g.h("ICGameTimManager", "errorCode = [" + errorCode + "], p1 = [" + errorMessage + "]");
            this.f440522b.b4(errorCode, errorMessage);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            com.tencent.icgame.game.utils.g.h("ICGameTimManager", "login suc " + this.f440521a);
            this.f440522b.c4();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ux0/b$d", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/trpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> {
        d() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable TcloudServerOuterClass$GetUserTCloudSignRsp result) {
            com.tencent.icgame.game.utils.g.h("ICGameTimManager", "internalLogin getUserSig suc");
            if (result != null) {
                b.this.userSign = result;
            }
            b.this.Y3();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.icgame.game.utils.g.h("ICGameTimManager", "internalLogin getUserSig suc fail p0 = [" + errorCode + "], p1 = [" + errorMessage + "]");
            b.this.b4(errorCode, errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"ux0/b$f", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "", "onSuccess", "", "p0", "", "p1", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class f implements V2TIMCallback {
        f() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int p06, @Nullable String p16) {
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "logout error, errorCode[" + p06 + "] errMsg[" + p16 + "]");
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "logout success");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ux0/b$g", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "msg", "", "onRecvNewMessage", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class g extends V2TIMAdvancedMsgListener {
        g() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
        public void onRecvNewMessage(@NotNull V2TIMMessage msg2) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.onRecvNewMessage(msg2);
            String groupID = msg2.getGroupID();
            Intrinsics.checkNotNullExpressionValue(groupID, "msg.groupID");
            isBlank = StringsKt__StringsJVMKt.isBlank(groupID);
            if (!isBlank) {
                String groupID2 = msg2.getGroupID();
                Intrinsics.checkNotNullExpressionValue(groupID2, "msg.groupID");
                if (UStringsKt.toULongOrNull(groupID2) == null) {
                    return;
                }
            }
            Iterator it = b.this.msgListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.icgame.game.tim.api.message.d) it.next()).b(new xx0.g(msg2));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ux0/b$h", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "o", "", "onSuccess", "", "code", "", "desc", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class h implements V2TIMValueCallback<Object> {
        h() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int code, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            com.tencent.icgame.game.utils.g.h("ICGameTimManager", "setBuildInfo code:" + code + " desc:" + desc);
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onSuccess(@Nullable Object o16) {
            com.tencent.icgame.game.utils.g.h("ICGameTimManager", "setBuildInfo success, " + o16);
        }
    }

    private final void V3(V2TIMSDKListener listener) {
        BaseManager.getInstance().setLibraryPath(this.imSdkSoPath);
        d4();
        V2TIMManager.getInstance().initSDK(BaseApplication.getContext(), ServerEnv.a().c(), new V2TIMSDKConfig(), listener);
    }

    private final void W3(final V2TIMSDKListener listener) {
        CharSequence trim;
        if (!BaseManager.getInstance().isInited()) {
            if (f440509k) {
                V3(listener);
                return;
            }
            String soVer = SoLoadManager.getInstance().getSoVer(SoLoadConstants.SONAME_IMSDK);
            if (soVer == null) {
                soVer = "";
            }
            boolean z16 = true;
            com.tencent.icgame.game.utils.g.g("ICGameTimManager", 1, "load ImSDK so, version:" + soVer);
            if (soVer.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                trim = StringsKt__StringsKt.trim((CharSequence) soVer);
                if (vx0.b.a(trim.toString(), "5.7.1451") < 0) {
                    com.tencent.icgame.game.utils.g.d("ICGameTimManager", "soVer:" + soVer + " too old, TARGET_IM_SDK_VERSION:5.7.1451");
                    if (listener != null) {
                        listener.onConnectFailed(-1, "load so failed");
                        return;
                    }
                    return;
                }
            }
            SoLoadManager.getInstance().load(SoLoadConstants.SONAME_IMSDK, new OnLoadListener() { // from class: ux0.a
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    b.X3(b.this, listener, i3, loadExtResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X3(b this$0, V2TIMSDKListener v2TIMSDKListener, int i3, LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.icgame.game.utils.g.g("ICGameTimManager", 1, "load so, code[" + i3 + "], result[" + loadExtResult + "]");
        if (i3 == 0 && loadExtResult.isSucc()) {
            String parent = new File(loadExtResult.getSoLoadPath()).getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "File(result.soLoadPath).parent");
            this$0.imSdkSoPath = parent;
            f440509k = true;
            this$0.V3(v2TIMSDKListener);
            return;
        }
        if (v2TIMSDKListener != null) {
            v2TIMSDKListener.onConnectFailed(i3, "load so failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y3() {
        com.tencent.icgame.game.utils.g.a("ICGameTimManager", "internalDirectLogin");
        String f16 = com.tencent.icgame.game.utils.a.f(this.userSign.current_uid.get());
        if (V2TIMManager.getInstance().getLoginStatus() == 1 && Intrinsics.areEqual(V2TIMManager.getInstance().getLoginUser(), f16)) {
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "internalDirectLogin direct suc");
            c4();
            return;
        }
        String str = this.userSign.im_sign.get();
        com.tencent.icgame.game.utils.g.h("ICGameTimManager", "login yesUid[" + f16 + "], sig[" + str + "]");
        V2TIMManager.getInstance().login(f16, str, new c(f16, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z3() {
        if (!a4()) {
            com.tencent.icgame.game.utils.g.h("ICGameTimManager", "internalLogin getUserSig begin");
            O(new d());
        } else {
            Y3();
        }
    }

    private final boolean a4() {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean isBlank4;
        String str = this.userSign.im_sign.get();
        Intrinsics.checkNotNullExpressionValue(str, "userSign.im_sign.get()");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            String str2 = this.userSign.trtc_sign.get();
            Intrinsics.checkNotNullExpressionValue(str2, "userSign.trtc_sign.get()");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                String str3 = this.userSign.live_trtc_sign.get();
                Intrinsics.checkNotNullExpressionValue(str3, "userSign.live_trtc_sign.get()");
                isBlank3 = StringsKt__StringsJVMKt.isBlank(str3);
                if (!isBlank3) {
                    String str4 = this.userSign.user_id_im_sign.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "userSign.user_id_im_sign.get()");
                    isBlank4 = StringsKt__StringsJVMKt.isBlank(str4);
                    if ((!isBlank4) && (this.userSign.expire_time.get() * 1000) - cy0.c.d() < 3600000) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b4(int errorCode, String errorMessage) {
        this.isLogining = false;
        Iterator<T> it = this.loginCallbacks.iterator();
        while (it.hasNext()) {
            ((sx0.a) it.next()).onError(errorCode, errorMessage);
        }
        this.loginCallbacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c4() {
        this.isLogining = false;
        Iterator<T> it = this.loginCallbacks.iterator();
        while (it.hasNext()) {
            ((sx0.a) it.next()).onSuccess();
        }
        this.loginCallbacks.clear();
    }

    private final void d4() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("buildModel", DeviceInfoMonitor.getModel());
            V2TIMManager.getInstance().callExperimentalAPI("setBuildInfo", jSONObject.toString(), new h());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // sx0.b
    @NotNull
    public com.tencent.icgame.game.tim.api.message.c C(long yesUid) {
        if (this.mapC2CMessageManager.get(Long.valueOf(yesUid)) == null) {
            this.mapC2CMessageManager.put(Long.valueOf(yesUid), new xx0.c(vx0.a.a(yesUid)));
        }
        com.tencent.icgame.game.tim.api.message.c cVar = this.mapC2CMessageManager.get(Long.valueOf(yesUid));
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    @Override // sx0.b
    @NotNull
    public com.tencent.icgame.game.tim.api.message.c M(long groupId) {
        if (this.mapGroupMessageManager.get(Long.valueOf(groupId)) == null) {
            this.mapGroupMessageManager.put(Long.valueOf(groupId), new xx0.d(vx0.a.a(groupId)));
        }
        com.tencent.icgame.game.tim.api.message.c cVar = this.mapGroupMessageManager.get(Long.valueOf(groupId));
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    @Override // sx0.b
    public void O(@Nullable IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> callback) {
        if (a4()) {
            if (callback != null) {
                callback.onSuccess(this.userSign);
                return;
            }
            return;
        }
        ((ox0.b) qx0.a.b(ox0.b.class)).E0(x15.a.INSTANCE.a(), TcloudServerOuterClass$GetUserTCloudSignRsp.class, new C11371b(callback, this));
    }

    @Override // sx0.b
    public void S0(@NotNull String groupId, @NotNull MessageOuterClass$TimMsgBody timMsgBody) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(timMsgBody, "timMsgBody");
        if (UStringsKt.toULongOrNull(groupId) == null) {
            return;
        }
        Iterator<T> it = this.msgListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.icgame.game.tim.api.message.d) it.next()).a(UStringsKt.toULong(groupId), timMsgBody);
        }
    }

    @NotNull
    public tx0.b U3() {
        if (this.groupManager == null) {
            this.groupManager = new wx0.a();
        }
        tx0.b bVar = this.groupManager;
        Intrinsics.checkNotNull(bVar);
        return bVar;
    }

    @Override // sx0.b
    public void Z2(@Nullable sx0.a callback) {
        com.tencent.icgame.game.utils.g.a("ICGameTimManager", "login");
        if (callback != null) {
            this.loginCallbacks.add(callback);
        }
        if (this.isLogining) {
            return;
        }
        this.isLogining = true;
        if (!BaseManager.getInstance().isInited()) {
            W3(new e());
        } else {
            Z3();
        }
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
        U3();
    }

    @Override // sx0.b
    public void logout() {
        this.userSign = new TcloudServerOuterClass$GetUserTCloudSignRsp();
        V2TIMManager.getInstance().logout(new f());
    }

    @Override // mm4.a
    public void o2() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"ux0/b$e", "Lcom/tencent/imsdk/v2/V2TIMSDKListener;", "", "onConnectSuccess", "", "code", "", "error", "onConnectFailed", "onKickedOffline", "Lcom/tencent/imsdk/v2/V2TIMUserFullInfo;", "info", "onSelfInfoUpdated", "onUserSigExpired", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class e extends V2TIMSDKListener {
        e() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onConnectFailed(int code, @Nullable String error) {
            super.onConnectFailed(code, error);
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "onConnectFailed");
            b.this.b4(code, error);
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onConnectSuccess() {
            super.onConnectSuccess();
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "onConnectSuccess");
            b.this.Z3();
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onKickedOffline() {
            super.onKickedOffline();
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "onKickedOffline");
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onSelfInfoUpdated(@Nullable V2TIMUserFullInfo info) {
            super.onSelfInfoUpdated(info);
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "onSelfInfoUpdated");
        }

        @Override // com.tencent.imsdk.v2.V2TIMSDKListener
        public void onUserSigExpired() {
            com.tencent.icgame.game.utils.g.a("ICGameTimManager", "onUserSigExpired");
            b bVar = b.this;
            bVar.O(new a(bVar));
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ux0/b$e$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/trpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes7.dex */
        public static final class a implements IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f440525a;

            a(b bVar) {
                this.f440525a = bVar;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable TcloudServerOuterClass$GetUserTCloudSignRsp result) {
                if (result != null) {
                    this.f440525a.userSign = result;
                }
                this.f440525a.Z2(null);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int errorCode, @Nullable String errorMessage) {
            }
        }
    }
}
