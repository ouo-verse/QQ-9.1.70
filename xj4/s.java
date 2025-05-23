package xj4;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.userlevel.UserLevelUpgrade;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001\"B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u001b\u001a\u00060\u001aR\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J \u0010\"\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lxj4/s;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lxj4/a;", "Lfp4/c;", "msgInfo", "", "cmd", "", HippyTKDListViewAdapter.X, "Lmt3/e;", "msg", DomainData.DOMAIN_NAME, "Lyq4/a;", "p", "Lsq3/b;", ITVKPlayerEventListener.KEY_USER_INFO, "r", "Lrq3/a;", "broadCastMsg", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "D", "ins", "Lrq3/e;", "msgEle", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$MsgElement;", BdhLogUtil.LogTag.Tag_Conn, "", "roomId", "Lxj4/b;", "receiver", "", "isAnchor", "a", "unregister", "onPush", "d", "Lxj4/b;", "e", "J", "f", "Z", "<init>", "()V", tl.h.F, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class s implements com.tencent.mobileqq.qqlive.sail.room.g, a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b receiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(s this$0, fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgInfo, "$msgInfo");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.K(msgInfo.f400285c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(s this$0, UserLevelUpgrade msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.A(msg2);
        }
    }

    private final LiveMessageData.MsgElement C(LiveMessageData ins, rq3.e msgEle) {
        LiveMessageData.TextElement textElement = new LiveMessageData.TextElement();
        rq3.h hVar = msgEle.f431946b;
        if (hVar != null) {
            byte[] bArr = hVar.f431957a;
            textElement.mText = bArr;
            try {
                Intrinsics.checkNotNullExpressionValue(bArr, "textElem.text");
                Charset forName = Charset.forName("utf-16LE");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"utf-16LE\")");
                String str = new String(bArr, forName);
                textElement.strText = str;
                AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "convertChatMessage", "receive msg, " + str);
            } catch (UnsupportedEncodingException e16) {
                AegisLogger.INSTANCE.e("Chat_Message|MessagePushMgr", "convertChatMessage", "UnsupportedEncoding", e16);
                textElement.strText = "";
            }
        }
        LiveMessageData.ImageElement imageElement = new LiveMessageData.ImageElement();
        rq3.c cVar = msgEle.f431947c;
        if (cVar != null) {
            imageElement.mImageUrl = cVar.f431941a;
        }
        LiveMessageData.MsgElement msgElement = new LiveMessageData.MsgElement();
        msgElement.mElementType = msgEle.f431945a;
        msgElement.mHideLogo = msgEle.f431948d;
        msgElement.mTextMsg = textElement;
        msgElement.mImageMsg = imageElement;
        return msgElement;
    }

    private final LiveMessageData.SpeakerInfo D(rq3.a broadCastMsg) {
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        rq3.i iVar = broadCastMsg.f431934a;
        speakerInfo.mSpeakId = iVar.f431958a;
        speakerInfo.mSpeakerName = iVar.f431959b;
        speakerInfo.mLogo = iVar.f431960c;
        speakerInfo.mQunNick = iVar.f431961d;
        speakerInfo.mBusinessUid = iVar.f431962e;
        speakerInfo.mClientType = broadCastMsg.f431936c;
        return speakerInfo;
    }

    private final LiveMessageData m(rq3.a broadCastMsg) {
        if (broadCastMsg == null) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "convertChatMessage", "invalid msg");
            return null;
        }
        LiveMessageData liveMessageData = new LiveMessageData();
        liveMessageData.mMessageType = 1;
        liveMessageData.mSpeakerInfo = D(broadCastMsg);
        ArrayList<LiveMessageData.MsgElement> arrayList = new ArrayList<>();
        rq3.e[] eVarArr = broadCastMsg.f431935b.f431942a;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "broadCastMsg.msgContent.msgElements");
        for (rq3.e it : eVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(C(liveMessageData, it));
        }
        ArrayList<LiveMessageData.ExtData> arrayList2 = new ArrayList<>();
        rq3.b[] bVarArr = broadCastMsg.f431935b.f431943b;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "broadCastMsg.msgContent.extData");
        for (rq3.b bVar : bVarArr) {
            LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
            extData.mId = bVar.f431939a;
            extData.mValue = bVar.f431940b;
            arrayList2.add(extData);
            if (extData.mId == 232) {
                byte[] bArr = extData.mValue;
                Intrinsics.checkNotNullExpressionValue(bArr, "extData.mValue");
                liveMessageData.mMessageId = new String(bArr, Charsets.UTF_8);
            }
        }
        LiveMessageData.MsgContent msgContent = new LiveMessageData.MsgContent();
        msgContent.mMsgElements = arrayList;
        msgContent.mExtDatas = arrayList2;
        liveMessageData.msgContent = msgContent;
        return liveMessageData;
    }

    private final void n(mt3.e msg2) {
        final GiftMessage from = GiftMessage.from(msg2);
        AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "notifyGiftMsg", "name=" + from.giftName + ", id=" + from.giftID + ", num=" + from.giftNum);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.i
            @Override // java.lang.Runnable
            public final void run() {
                s.o(s.this, from);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(s this$0, GiftMessage giftMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.receiver;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(giftMsg, "giftMsg");
            bVar.onGiftMessageReceive(giftMsg);
        }
    }

    private final void p(yq4.a msg2) {
        final QLBroadCastFreeLove qLBroadCastFreeLove = new QLBroadCastFreeLove();
        qLBroadCastFreeLove.roomId = msg2.f451019a;
        qLBroadCastFreeLove.headImg = msg2.f451022d;
        qLBroadCastFreeLove.roomMsg = msg2.f451023e;
        qLBroadCastFreeLove.userNick = msg2.f451021c;
        qLBroadCastFreeLove.uid = msg2.f451020b;
        qLBroadCastFreeLove.freeLoves = new ArrayList<>();
        String[] strArr = msg2.f451024f;
        Intrinsics.checkNotNullExpressionValue(strArr, "msg.materialId");
        for (String str : strArr) {
            FreeLove freeLove = new FreeLove();
            freeLove.loveType = str;
            freeLove.loveNum = 1;
            qLBroadCastFreeLove.freeLoves.add(freeLove);
        }
        AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "notifyLike", "count=" + qLBroadCastFreeLove.freeLoves.size() + ", nick=" + qLBroadCastFreeLove.userNick);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.r
            @Override // java.lang.Runnable
            public final void run() {
                s.q(s.this, qLBroadCastFreeLove);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(s this$0, QLBroadCastFreeLove freeLoves) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(freeLoves, "$freeLoves");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.x(freeLoves);
        }
    }

    private final void r(sq3.b userInfo) {
        if (userInfo == null) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "notifyUserEnterRoom", "invalid userInfo");
            return;
        }
        if (com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null) == userInfo.f434233a) {
            AegisLogger.INSTANCE.i("Chat_Message|MessagePushMgr", "notifyUserEnterRoom", "drop self enter room msg");
            return;
        }
        final LiveMessageData.SpeakerInfo from = LiveMessageData.SpeakerInfo.from(userInfo);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("Chat_Message|MessagePushMgr", "notifyUserEnterRoom", from.mSpeakerName + " entered room");
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.q
            @Override // java.lang.Runnable
            public final void run() {
                s.s(s.this, from);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(s this$0, LiveMessageData.SpeakerInfo speakerInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.receiver;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(speakerInfo, "speakerInfo");
            bVar.G(speakerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(s this$0, gp4.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.O(it.f403049c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(s this$0, LiveMessageData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.D(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(s this$0, LiveMessageData msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.P(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(s this$0, FollowPushMessage msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.F(msg2);
        }
    }

    private final void x(final fp4.c msgInfo, int cmd) {
        int i3;
        if (cmd != 55) {
            switch (cmd) {
                case 15:
                    yq4.a p16 = com.tencent.mobileqq.qqlive.sail.push.a.p(msgInfo);
                    if (p16 != null) {
                        p(p16);
                        return;
                    }
                    return;
                case 16:
                    mt3.e m3 = com.tencent.mobileqq.qqlive.sail.push.a.m(msgInfo);
                    if (m3 != null) {
                        n(m3);
                        return;
                    }
                    return;
                case 17:
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            s.A(s.this, msgInfo);
                        }
                    });
                    return;
                case 18:
                    xq4.a c16 = com.tencent.mobileqq.qqlive.sail.push.a.c(msgInfo);
                    if (c16 != null) {
                        final AnnouncePushMessage announcePushMessage = new AnnouncePushMessage();
                        announcePushMessage.roomId = c16.f448401a;
                        announcePushMessage.uid = c16.f448402b;
                        String str = c16.f448403c;
                        announcePushMessage.announce = str;
                        announcePushMessage.approved = c16.f448404d;
                        AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "parseExtData", "receive announce msg, " + str);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                s.y(s.this, announcePushMessage);
                            }
                        });
                        return;
                    }
                    return;
                case 19:
                    hr4.f j3 = com.tencent.mobileqq.qqlive.sail.push.a.j(msgInfo);
                    if (j3 != null) {
                        final FollowPushMessage followPushMessage = new FollowPushMessage();
                        String str2 = j3.f406108b;
                        followPushMessage.nick = str2;
                        followPushMessage.icon = j3.f406111e;
                        followPushMessage.uid = j3.f406107a;
                        followPushMessage.toUid = j3.f406109c;
                        if (j3.f406110d == 0) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        followPushMessage.type = i3;
                        AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "parseExtData", "receive follow msg, " + str2 + ", type=" + i3);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                s.z(s.this, followPushMessage);
                            }
                        });
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        sr4.i D = com.tencent.mobileqq.qqlive.sail.push.a.D(msgInfo);
        if (D != null) {
            final UserLevelUpgrade userLevelUpgrade = new UserLevelUpgrade(D.f434414a, D.f434415b, D.f434416c);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.p
                @Override // java.lang.Runnable
                public final void run() {
                    s.B(s.this, userLevelUpgrade);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(s this$0, AnnouncePushMessage msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.Q(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(s this$0, FollowPushMessage msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        b bVar = this$0.receiver;
        if (bVar != null) {
            bVar.J(msg2);
        }
    }

    @Override // xj4.a
    public void a(long roomId, @NotNull b receiver, boolean isAnchor) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        AegisLogger.INSTANCE.i("Chat_Message|MessagePushMgr", "SailMessagePushMgr register");
        this.roomId = roomId;
        this.receiver = receiver;
        this.isAnchor = isAnchor;
        com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null);
        if (z16 != null) {
            z16.p(33, this);
            z16.p(255, this);
            z16.p(234, this);
            z16.p(263, this);
            z16.p(165, this);
            z16.p(200, this);
            z16.p(167, this);
            z16.p(235, this);
            z16.p(239, this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        int i3 = msgInfo.f400284b;
        if (i3 != 33) {
            int i16 = 1;
            if (i3 != 165) {
                if (i3 != 167) {
                    if (i3 != 200) {
                        if (i3 != 239) {
                            if (i3 != 255) {
                                if (i3 != 263 && i3 != 234 && i3 != 235) {
                                    return;
                                }
                            } else {
                                i11.a x16 = com.tencent.mobileqq.qqlive.sail.push.a.x(msgInfo);
                                if (x16 != null) {
                                    byte[] bArr = x16.f407027b;
                                    Intrinsics.checkNotNullExpressionValue(bArr, "it.msg");
                                    Charset forName = Charset.forName("UTF-8");
                                    Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
                                    String str = new String(bArr, forName);
                                    final LiveMessageData liveMessageData = new LiveMessageData();
                                    liveMessageData.mMessageType = 4;
                                    liveMessageData.mRawTipStr = str;
                                    LiveMsgExtInfo liveMsgExtInfo = new LiveMsgExtInfo();
                                    liveMsgExtInfo.msgType = msgInfo.f400287e;
                                    liveMsgExtInfo.msgUid = msgInfo.f400288f;
                                    liveMessageData.mMsgExtInfo = liveMsgExtInfo;
                                    AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "onPush", "receive system notice msg, " + liveMessageData.mRawTipStr);
                                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.j
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            s.v(s.this, liveMessageData);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        } else {
                            final gp4.a g16 = com.tencent.mobileqq.qqlive.sail.push.a.g(msgInfo);
                            if (g16 != null) {
                                AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "onPush", "receive timi push");
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.l
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        s.t(s.this, g16);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    } else {
                        sq3.a C = com.tencent.mobileqq.qqlive.sail.push.a.C(msgInfo);
                        if (C != null && C.f434221c == 1) {
                            r(C.f434219a);
                            return;
                        }
                        return;
                    }
                }
                gp4.a g17 = com.tencent.mobileqq.qqlive.sail.push.a.g(msgInfo);
                if (g17 != null) {
                    x(msgInfo, g17.f403047a);
                    return;
                }
                return;
            }
            qq3.a k3 = com.tencent.mobileqq.qqlive.sail.push.a.k(msgInfo);
            if (k3 != null) {
                final FollowPushMessage followPushMessage = new FollowPushMessage();
                String str2 = k3.f429280c;
                followPushMessage.nick = str2;
                followPushMessage.uid = k3.f429279b;
                if (k3.f429278a == 0) {
                    i16 = 0;
                }
                followPushMessage.type = i16;
                AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "onPush", "receive follow room msg, " + str2 + ", type=" + i16);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.w(s.this, followPushMessage);
                    }
                });
                return;
            }
            return;
        }
        final LiveMessageData m3 = m(com.tencent.mobileqq.qqlive.sail.push.a.d(msgInfo));
        if (m3 == null || m3.mSpeakerInfo.mSpeakId == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xj4.h
            @Override // java.lang.Runnable
            public final void run() {
                s.u(s.this, m3);
            }
        });
    }

    @Override // xj4.a
    public void unregister() {
        AegisLogger.INSTANCE.i("Chat_Message|MessagePushMgr", "SailMessagePushMgr unregister");
        com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
        this.receiver = null;
        this.roomId = 0L;
    }
}
