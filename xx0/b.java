package xx0;

import com.tencent.icgame.game.tim.api.message.MsgStatus;
import com.tencent.icgame.game.utils.k;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0007*\u0001 \b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lxx0/b;", "Lcom/tencent/icgame/game/tim/api/message/c;", "Lxx0/g;", "msgInfo", "", "resend", "", "l", "g", h.F, "k", "Lcom/tencent/icgame/game/tim/api/message/a;", "msg", "a", "b", "", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "chatId", "TAG", "", "Lcom/tencent/icgame/game/tim/api/message/b;", "c", "Ljava/util/List;", "j", "()Ljava/util/List;", "setListeners", "(Ljava/util/List;)V", "listeners", "d", "images", "xx0/b$d", "e", "Lxx0/b$d;", "msgListener", "<init>", "(Ljava/lang/String;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class b implements com.tencent.icgame.game.tim.api.message.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String chatId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.icgame.game.tim.api.message.b> listeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<g> images;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d msgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"xx0/b$a", "Lsx0/a;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements sx0.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f448946b;

        a(g gVar) {
            this.f448946b = gVar;
        }

        @Override // sx0.a
        public void onError(int errorCode, @Nullable String errorMsg) {
            this.f448946b.k(MsgStatus.FAILED);
            List<com.tencent.icgame.game.tim.api.message.b> j3 = b.this.j();
            g gVar = this.f448946b;
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                ((com.tencent.icgame.game.tim.api.message.b) it.next()).f(gVar, errorCode, errorMsg);
            }
        }

        @Override // sx0.a
        public void onSuccess() {
            b.this.h(this.f448946b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"xx0/b$b", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "", "onSuccess", "", "code", "", "desc", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xx0.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C11571b implements V2TIMCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.icgame.game.tim.api.message.a f448947a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f448948b;

        C11571b(com.tencent.icgame.game.tim.api.message.a aVar, b bVar) {
            this.f448947a = aVar;
            this.f448948b = bVar;
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int code, @Nullable String desc) {
            com.tencent.icgame.game.utils.g.h(this.f448948b.TAG, "delete error: " + code + ", " + desc);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            this.f448947a.k(MsgStatus.DELETE);
            List<com.tencent.icgame.game.tim.api.message.b> j3 = this.f448948b.j();
            com.tencent.icgame.game.tim.api.message.a aVar = this.f448947a;
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                ((com.tencent.icgame.game.tim.api.message.b) it.next()).e(aVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"xx0/b$d", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "msg", "", "onRecvNewMessage", "", "msgID", "onRecvMessageRevoked", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d extends V2TIMAdvancedMsgListener {
        d() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
        public void onRecvMessageRevoked(@NotNull String msgID) {
            Intrinsics.checkNotNullParameter(msgID, "msgID");
            Iterator<T> it = b.this.j().iterator();
            while (it.hasNext()) {
                ((com.tencent.icgame.game.tim.api.message.b) it.next()).a(msgID);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
        public void onRecvNewMessage(@NotNull V2TIMMessage msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            com.tencent.icgame.game.utils.g.a(b.this.TAG, "onRecvNewMessage: " + msg2.getGroupID() + ", " + msg2.getSender());
            List<com.tencent.icgame.game.tim.api.message.b> j3 = b.this.j();
            b bVar = b.this;
            for (com.tencent.icgame.game.tim.api.message.b bVar2 : j3) {
                g gVar = new g(msg2);
                if (bVar.k()) {
                    if (gVar.i() && gVar.j() == UStringsKt.toULong(bVar.getChatId())) {
                        bVar2.b(new g(msg2));
                    }
                } else if (!gVar.i() && gVar.c().uid.get() == UStringsKt.toULong(bVar.getChatId())) {
                    bVar2.b(new g(msg2));
                }
            }
        }
    }

    public b(@NotNull String chatId) {
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        this.chatId = chatId;
        this.TAG = "ICGameBaseMsgManager";
        this.listeners = new ArrayList();
        this.images = new ArrayList();
        this.msgListener = new d();
    }

    private final void g(g msgInfo) {
        ((sx0.b) qx0.a.b(sx0.b.class)).Z2(new a(msgInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(g msgInfo) {
        String str;
        V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
        V2TIMMessage v2TIMMessage = msgInfo.getV2TIMMessage();
        String str2 = null;
        if (!k()) {
            str = this.chatId;
        } else {
            str = null;
        }
        if (k()) {
            str2 = this.chatId;
        }
        messageManager.sendMessage(v2TIMMessage, str, str2, 0, false, null, new c(msgInfo, this));
    }

    private final void l(final g msgInfo, final boolean resend) {
        g(msgInfo);
        k.b(new Runnable() { // from class: xx0.a
            @Override // java.lang.Runnable
            public final void run() {
                b.m(g.this, this, resend);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(g msgInfo, b this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(msgInfo, "$msgInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        msgInfo.k(MsgStatus.SENDING);
        for (com.tencent.icgame.game.tim.api.message.b bVar : this$0.listeners) {
            if (z16) {
                bVar.g(msgInfo);
            } else {
                bVar.d(msgInfo);
            }
        }
        com.tencent.icgame.game.utils.g.h(this$0.TAG, "sendMessage " + msgInfo.id() + ", resend=" + z16);
    }

    @Override // com.tencent.icgame.game.tim.api.message.c
    public void a(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        l((g) msg2, true);
    }

    @Override // com.tencent.icgame.game.tim.api.message.c
    public void b(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        V2TIMManager.getMessageManager().deleteMessageFromLocalStorage(((g) msg2).getV2TIMMessage(), new C11571b(msg2, this));
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getChatId() {
        return this.chatId;
    }

    @NotNull
    public final List<com.tencent.icgame.game.tim.api.message.b> j() {
        return this.listeners;
    }

    public abstract boolean k();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"xx0/b$c", "Lcom/tencent/imsdk/v2/V2TIMSendCallback;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "", "progress", "", "onProgress", "code", "", "desc", "onError", "p0", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements V2TIMSendCallback<V2TIMMessage> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f448949a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f448950b;

        c(g gVar, b bVar) {
            this.f448949a = gVar;
            this.f448950b = bVar;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable V2TIMMessage p06) {
            this.f448949a.k(MsgStatus.SUCCESS);
            List<com.tencent.icgame.game.tim.api.message.b> j3 = this.f448950b.j();
            g gVar = this.f448949a;
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                ((com.tencent.icgame.game.tim.api.message.b) it.next()).c(gVar);
            }
            com.tencent.icgame.game.utils.g.h(this.f448950b.TAG, "sendMessage onSuccess: " + this.f448949a.id());
            this.f448950b.images.remove(this.f448949a);
            if (!this.f448950b.images.isEmpty()) {
                b bVar = this.f448950b;
                bVar.h((g) bVar.images.get(0));
                this.f448950b.images.remove(0);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int code, @Nullable String desc) {
            this.f448949a.k(MsgStatus.FAILED);
            List<com.tencent.icgame.game.tim.api.message.b> j3 = this.f448950b.j();
            g gVar = this.f448949a;
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                ((com.tencent.icgame.game.tim.api.message.b) it.next()).f(gVar, code, desc);
            }
            com.tencent.icgame.game.utils.g.d(this.f448950b.TAG, "sendMessage error: " + code + ", " + desc);
            this.f448950b.images.remove(this.f448949a);
            if (!this.f448950b.images.isEmpty()) {
                b bVar = this.f448950b;
                bVar.h((g) bVar.images.get(0));
                this.f448950b.images.remove(0);
            }
            if (code == 10017 || code == 20012) {
                QQToast.makeText(BaseApplication.getContext(), 4, "\u4f60\u5df2\u88ab\u7981\u8a00\uff0c\u6682\u65f6\u65e0\u6cd5\u53d1\u8a00", 0).show();
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMSendCallback
        public void onProgress(int progress) {
        }
    }
}
