package zf4;

import ag4.i;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import fm4.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import trpc.yes.common.RecommendProxyOuterClass$SendIMArkMsgRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCommonConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomEnterAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J&\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\"\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000bJ4\u0010$\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0016J@\u0010'\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0016\u00a8\u0006*"}, d2 = {"Lzf4/c;", "", "", "roomId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "chatId", "Landroid/content/Context;", "context", "", "o", "", "e", "", "d", "(Ljava/lang/Long;)I", "groupId", "userId", "j", "i", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "Lzf4/d;", "tipSelectHelper", "g", "k", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", h.F, "f", "senderUid", "receiverUid", "content", DomainData.DOMAIN_NAME, "selfQQUserId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "alluerInfo", "l", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f452468a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"zf4/c$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$SendIMArkMsgRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<RecommendProxyOuterClass$SendIMArkMsgRsp> {
        a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable RecommendProxyOuterClass$SendIMArkMsgRsp result) {
            com.tencent.timi.game.ui.widget.f.a("\u5df2\u53d1\u9001");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            if (errorMessage == null) {
                errorMessage = "\u53d1\u9001\u5931\u8d25";
            }
            com.tencent.timi.game.ui.widget.f.c(errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"zf4/c$b", "Lag4/i$d;", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "selectedDefaultAccount", "a", "", "errorCode", "", "errorMsg", "e", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements i.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f452469a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f452470b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f452471c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f452472d;

        b(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j16, Context context) {
            this.f452469a = j3;
            this.f452470b = commonOuterClass$QQUserId;
            this.f452471c = j16;
            this.f452472d = context;
        }

        @Override // ag4.i.d
        public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp selectedDefaultAccount) {
            Intrinsics.checkNotNullParameter(selectedDefaultAccount, "selectedDefaultAccount");
            l.i("MessageUtil", "sendProfileMessage bindSucceed ");
            c.f452468a.o(this.f452469a, this.f452470b, this.f452471c, this.f452472d);
        }

        @Override // ag4.i.d
        public void b() {
            l.i("MessageUtil", "sendProfileMessage bindCancel ");
        }

        @Override // ag4.i.c
        public void c() {
            l.i("MessageUtil", "sendProfileMessage onDialogShow ");
        }

        @Override // ag4.i.d
        public void e(int errorCode, @Nullable String errorMsg) {
            l.i("MessageUtil", "sendProfileMessage bindFailed ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"zf4/c$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zf4.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11678c implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f452473a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f452474b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f452475c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f452476d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ zf4.d f452477e;

        C11678c(com.tencent.timi.game.tim.api.message.a aVar, CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, CommonOuterClass$QQUserId commonOuterClass$QQUserId2, zf4.d dVar) {
            this.f452473a = aVar;
            this.f452474b = commonOuterClass$QQUserId;
            this.f452475c = yoloRoomOuterClass$YoloRoomInfo;
            this.f452476d = commonOuterClass$QQUserId2;
            this.f452477e = dVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            c.f452468a.l(result, this.f452473a, this.f452474b, this.f452475c, this.f452476d, this.f452477e);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.e("MessageUtil ", "sendAtMessage onError " + errorCode + "," + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"zf4/c$d", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f452478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f452479b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f452480c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f452481d;

        d(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, CommonOuterClass$QQUserId commonOuterClass$QQUserId2) {
            this.f452478a = j3;
            this.f452479b = commonOuterClass$QQUserId;
            this.f452480c = str;
            this.f452481d = commonOuterClass$QQUserId2;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            String replace$default;
            if (result == null) {
                return;
            }
            com.tencent.timi.game.tim.api.message.c M = ((kn4.b) mm4.b.b(kn4.b.class)).M(this.f452478a);
            String nick = result.i(this.f452479b);
            String f16 = result.f(this.f452479b);
            ArrayList arrayList = new ArrayList();
            MessageOuterClass$AtUser messageOuterClass$AtUser = new MessageOuterClass$AtUser();
            messageOuterClass$AtUser.user_id.set(this.f452479b);
            messageOuterClass$AtUser.nick_name.set(nick);
            messageOuterClass$AtUser.head_url.set(f16);
            arrayList.add(messageOuterClass$AtUser);
            String str = this.f452480c;
            Intrinsics.checkNotNullExpressionValue(nick, "nick");
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "{{nick}}", nick, false, 4, (Object) null);
            String str2 = "@" + nick + " " + replace$default;
            MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg = new MessageOuterClass$AtUserMsg();
            messageOuterClass$AtUserMsg.user_list.set(arrayList);
            messageOuterClass$AtUserMsg.text.set(str2);
            MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
            messageOuterClass$MsgContent.at_user_msg.set(messageOuterClass$AtUserMsg);
            M.h(this.f452481d, str2, messageOuterClass$MsgContent);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.e("MessageUtil", "errorCode: " + errorCode);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"zf4/c$f", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface;", "dialog", "", "which", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f452482d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f452483e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f452484f;

        f(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j16) {
            this.f452482d = j3;
            this.f452483e = commonOuterClass$QQUserId;
            this.f452484f = j16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(@Nullable DialogInterface dialog, int which) {
            c cVar = c.f452468a;
            rm4.a.h(cVar.e(this.f452482d), true);
            cVar.i(this.f452482d, this.f452483e, this.f452484f);
        }
    }

    c() {
    }

    private final int d(Long roomId) {
        long j3;
        g gVar = (g) mm4.b.b(g.class);
        if (roomId != null) {
            j3 = roomId.longValue();
        } else {
            j3 = 0;
        }
        return gVar.K0(j3).o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(long roomId) {
        return "TG_MESSAGE_PROFILE_TIP_SHOWED_" + d(Long.valueOf(roomId));
    }

    private final void g(YoloRoomOuterClass$YoloRoomInfo roomInfo, zf4.d tipSelectHelper) {
        YoloRoomOuterClass$YoloRoomConf Y;
        YoloRoomOuterClass$YoloRoomCommonConf yoloRoomOuterClass$YoloRoomCommonConf;
        PBRepeatField<String> pBRepeatField;
        List<String> list;
        if (roomInfo != null && (Y = ((g) mm4.b.b(g.class)).K0(roomInfo.room_id.get()).Y()) != null && (yoloRoomOuterClass$YoloRoomCommonConf = Y.yolo_room_common_conf) != null && (pBRepeatField = yoloRoomOuterClass$YoloRoomCommonConf.greet_words_list) != null && (list = pBRepeatField.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(list, "get()");
            tipSelectHelper.c(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(long roomId, CommonOuterClass$QQUserId qqUserId, long chatId) {
        j(roomId, chatId, qqUserId);
    }

    private final void j(long roomId, long groupId, CommonOuterClass$QQUserId userId) {
        xf4.a.f447906a.a(((g) mm4.b.b(g.class)).K0(roomId).o1(), 3, groupId, userId, "", new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(long roomId, CommonOuterClass$QQUserId qqUserId, long chatId, Context context) {
        boolean b16 = rm4.a.b(e(roomId), false);
        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = qqUserId.get();
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "qqUserId.get()");
        dVar.c1(commonOuterClass$QQUserId, null);
        if (!b16) {
            new e.a(context).j("\u662f\u5426\u5c06\u4f60\u7684\u4e2a\u4eba\u8d44\u6599\u53ca\u6e38\u620f\u6218\u7ee9\u5206\u4eab\u5230\u5927\u5385").n("\u518d\u8003\u8651\u4e00\u4e0b").m(new e()).p("\u786e\u8ba4").o(new f(roomId, qqUserId, chatId)).c().show();
        } else {
            i(roomId, qqUserId, chatId);
        }
    }

    public final int f(long roomId) {
        ExpandHallLaunchParam expandHallLaunchParam;
        gm4.c K0 = ((g) mm4.b.b(g.class)).K0(roomId);
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            expandHallLaunchParam = I0.O();
        } else {
            expandHallLaunchParam = null;
        }
        boolean z16 = true;
        if (K0.getRoomType() == 1) {
            return 10003;
        }
        if (K0.getRoomType() == 5) {
            if (expandHallLaunchParam == null || expandHallLaunchParam.f376301d != 1) {
                z16 = false;
            }
            if (z16) {
                return 10005;
            }
        }
        return 10004;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r2 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction;
        YoloRoomOuterClass$YoloRoomEnterAction yoloRoomOuterClass$YoloRoomEnterAction;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBUInt64Field pBUInt64Field2;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg = msg2.a().yolo_room_action_msg;
        if (messageOuterClass$YoloRoomActionMsg == null || (yoloRoomOuterClass$YoloRoomAction = messageOuterClass$YoloRoomActionMsg.yolo_room_action) == null || (yoloRoomOuterClass$YoloRoomEnterAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_enter_action) == null || (commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomEnterAction.user_id) == null) {
            return false;
        }
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        if (commonOuterClass$QQUserId.uid.get() != 0) {
            if (E != null && (pBUInt64Field2 = E.uid) != null && commonOuterClass$QQUserId.uid.get() == pBUInt64Field2.get()) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        if (commonOuterClass$QQUserId.yes_uid.get() == 0) {
            return false;
        }
        if (E != null && (pBUInt64Field = E.yes_uid) != null && commonOuterClass$QQUserId.yes_uid.get() == pBUInt64Field.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final void k(@NotNull CommonOuterClass$QQUserId qqUserId, long chatId, @NotNull Context context, long roomId) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof QBaseActivity) {
            ((i) mm4.b.b(i.class)).F3(((g) mm4.b.b(g.class)).K0(roomId).o1(), (Activity) context, Boolean.TRUE, null, new b(roomId, qqUserId, chatId, context));
        }
    }

    public final void l(@Nullable IUserInfo alluerInfo, @Nullable com.tencent.timi.game.tim.api.message.a msg2, @Nullable CommonOuterClass$QQUserId qqUserId, @Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo, @Nullable CommonOuterClass$QQUserId selfQQUserId, @NotNull zf4.d tipSelectHelper) {
        String replace$default;
        Intrinsics.checkNotNullParameter(tipSelectHelper, "tipSelectHelper");
        if (alluerInfo != null && msg2 != null && qqUserId != null && roomInfo != null && selfQQUserId != null) {
            MessageOuterClass$AtUser messageOuterClass$AtUser = new MessageOuterClass$AtUser();
            String nick = alluerInfo.i(qqUserId);
            messageOuterClass$AtUser.user_id.set(qqUserId);
            messageOuterClass$AtUser.nick_name.set(nick);
            messageOuterClass$AtUser.head_url.set(alluerInfo.f(qqUserId));
            ArrayList arrayList = new ArrayList();
            arrayList.add(messageOuterClass$AtUser);
            if (tipSelectHelper.b()) {
                g(roomInfo, tipSelectHelper);
            }
            String a16 = tipSelectHelper.a();
            Intrinsics.checkNotNullExpressionValue(nick, "nick");
            replace$default = StringsKt__StringsJVMKt.replace$default(a16, "{{nick}}", nick, false, 4, (Object) null);
            String str = "@" + nick + " " + replace$default;
            MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg = new MessageOuterClass$AtUserMsg();
            messageOuterClass$AtUserMsg.user_list.set(arrayList);
            messageOuterClass$AtUserMsg.text.set(str);
            MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
            messageOuterClass$MsgContent.at_user_msg.set(messageOuterClass$AtUserMsg);
            ((kn4.b) mm4.b.b(kn4.b.class)).M(msg2.j()).h(selfQQUserId, str, messageOuterClass$MsgContent);
            return;
        }
        l.e("MessageUtil ", "sendAtMessage error " + alluerInfo + "," + msg2 + "," + qqUserId + "," + roomInfo + "," + selfQQUserId);
    }

    public final void m(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable com.tencent.timi.game.tim.api.message.a msg2, @Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo, @Nullable CommonOuterClass$QQUserId selfQQUserId, @NotNull zf4.d tipSelectHelper) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        Intrinsics.checkNotNullParameter(tipSelectHelper, "tipSelectHelper");
        if (msg2 != null && roomInfo != null && selfQQUserId != null) {
            C11678c c11678c = new C11678c(msg2, qqUserId, roomInfo, selfQQUserId, tipSelectHelper);
            bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = qqUserId.get();
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "qqUserId.get()");
            dVar.I3(commonOuterClass$QQUserId, c11678c);
            return;
        }
        l.e("MessageUtil ", "sendAtMessage error " + msg2 + "," + roomInfo + "," + selfQQUserId + "," + qqUserId);
    }

    public final void n(long roomId, @NotNull CommonOuterClass$QQUserId senderUid, @NotNull CommonOuterClass$QQUserId receiverUid, @NotNull String content) {
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        Intrinsics.checkNotNullParameter(receiverUid, "receiverUid");
        Intrinsics.checkNotNullParameter(content, "content");
        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = receiverUid.get();
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "receiverUid.get()");
        dVar.l0(commonOuterClass$QQUserId, new d(roomId, receiverUid, content, senderUid));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"zf4/c$e", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface;", "dialog", "", "which", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(@Nullable DialogInterface dialog, int which) {
        }
    }
}
