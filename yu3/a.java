package yu3;

import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.qqnt.aio.assistedchat.model.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J&\u0010\u0013\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J&\u0010\u0019\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\u001e"}, d2 = {"Lyu3/a;", "Lyu3/c;", "", "chatType", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "flag", "Ltencent/im/oidb/cmd0x587/oidb_0x587$ReqBody;", "reqBody", "", "f", "", "e", "", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", "switchList", "switchValue", "Lmqq/app/Packet;", "packet", "a", "", "uin", "d", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "rsp", "b", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "c", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lyu3/a$a;", "", "", "chatType", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "reqBody", "", "b", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "udc", "Lcom/tencent/mobileqq/pb/PBUInt32Field;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yu3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: yu3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        public /* synthetic */ class C11634a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f451252a;

            static {
                int[] iArr = new int[AssistedChatSwitchType.values().length];
                try {
                    iArr[AssistedChatSwitchType.AUTO_POLISH.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AssistedChatSwitchType.AI_SERVICE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AssistedChatSwitchType.REPLY_SUGGESTION.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f451252a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PBUInt32Field a(int chatType, AssistedChatSwitchType switchType, oidb_0x5eb$UdcUinData udc) {
            Intrinsics.checkNotNullParameter(switchType, "switchType");
            Intrinsics.checkNotNullParameter(udc, "udc");
            int i3 = C11634a.f451252a[switchType.ordinal()];
            if (i3 == 1) {
                if (chatType == 1) {
                    return udc.uint32_assisted_chat_auto_polish_c2c;
                }
                if (chatType == 104) {
                    return udc.uint32_assisted_chat_auto_polish_jieban;
                }
                if (chatType != 119) {
                    return null;
                }
                return udc.uint32_assisted_chat_auto_polish_nearby;
            }
            if (i3 == 2) {
                if (chatType == 1) {
                    return udc.uint32_assisted_chat_auto_topic_c2c;
                }
                if (chatType == 104) {
                    return udc.uint32_assisted_chat_auto_topic_jieban;
                }
                if (chatType != 119) {
                    return null;
                }
                return udc.uint32_assisted_chat_auto_topic_nearby;
            }
            if (i3 == 3) {
                return udc.uint32_assisted_chat_ai_assistant;
            }
            if (i3 != 4) {
                return null;
            }
            if (chatType == 1) {
                return udc.uint32_assisted_chat_reply_suggestion_c2c;
            }
            if (chatType == 104) {
                return udc.uint32_assisted_chat_reply_suggestion_jieban;
            }
            if (chatType != 119) {
                return null;
            }
            return udc.uint32_assisted_chat_reply_suggestion_nearby;
        }

        public final void b(int chatType, AssistedChatSwitchType switchType, oidb_0x5eb$ReqBody reqBody) {
            Intrinsics.checkNotNullParameter(switchType, "switchType");
            Intrinsics.checkNotNullParameter(reqBody, "reqBody");
            int i3 = C11634a.f451252a[switchType.ordinal()];
            if (i3 == 1) {
                if (chatType == 1) {
                    reqBody.uint32_assisted_chat_auto_polish_c2c.set(1);
                    return;
                } else if (chatType == 104) {
                    reqBody.uint32_assisted_chat_auto_polish_jieban.set(1);
                    return;
                } else {
                    if (chatType != 119) {
                        return;
                    }
                    reqBody.uint32_assisted_chat_auto_polish_nearby.set(1);
                    return;
                }
            }
            if (i3 == 2) {
                if (chatType == 1) {
                    reqBody.uint32_assisted_chat_auto_topic_c2c.set(1);
                    return;
                } else if (chatType == 104) {
                    reqBody.uint32_assisted_chat_auto_topic_jieban.set(1);
                    return;
                } else {
                    if (chatType != 119) {
                        return;
                    }
                    reqBody.uint32_assisted_chat_auto_topic_nearby.set(1);
                    return;
                }
            }
            if (i3 == 3) {
                reqBody.uint32_assisted_chat_ai_assistant.set(1);
                return;
            }
            if (i3 != 4) {
                return;
            }
            if (chatType == 1) {
                reqBody.uint32_assisted_chat_reply_suggestion_c2c.set(1);
            } else if (chatType == 104) {
                reqBody.uint32_assisted_chat_reply_suggestion_jieban.set(1);
            } else {
                if (chatType != 119) {
                    return;
                }
                reqBody.uint32_assisted_chat_reply_suggestion_nearby.set(1);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f451253a;

        static {
            int[] iArr = new int[AssistedChatSwitchType.values().length];
            try {
                iArr[AssistedChatSwitchType.AUTO_POLISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AssistedChatSwitchType.AI_SERVICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AssistedChatSwitchType.REPLY_SUGGESTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f451253a = iArr;
        }
    }

    private final void f(int chatType, AssistedChatSwitchType switchType, int flag, oidb_0x587$ReqBody reqBody) {
        int i3 = b.f451253a[switchType.ordinal()];
        if (i3 == 1) {
            if (chatType == 1) {
                reqBody.uint32_assisted_chat_auto_polish_c2c.set(flag);
                return;
            } else if (chatType == 104) {
                reqBody.uint32_assisted_chat_auto_polish_jieban.set(flag);
                return;
            } else {
                if (chatType != 119) {
                    return;
                }
                reqBody.uint32_assisted_chat_auto_polish_nearby.set(flag);
                return;
            }
        }
        if (i3 == 2) {
            if (chatType == 1) {
                reqBody.uint32_assisted_chat_auto_topic_c2c.set(flag);
                return;
            } else if (chatType == 104) {
                reqBody.uint32_assisted_chat_auto_topic_jieban.set(flag);
                return;
            } else {
                if (chatType != 119) {
                    return;
                }
                reqBody.uint32_assisted_chat_auto_topic_nearby.set(flag);
                return;
            }
        }
        if (i3 == 3) {
            reqBody.uint32_assisted_chat_ai_assistant.set(flag);
            return;
        }
        if (i3 != 4) {
            return;
        }
        if (chatType == 1) {
            reqBody.uint32_assisted_chat_reply_suggestion_c2c.set(flag);
        } else if (chatType == 104) {
            reqBody.uint32_assisted_chat_reply_suggestion_jieban.set(flag);
        } else {
            if (chatType != 119) {
                return;
            }
            reqBody.uint32_assisted_chat_reply_suggestion_nearby.set(flag);
        }
    }

    @Override // yu3.c
    public void a(List<AssistedChatSwitch> switchList, int switchValue, Packet packet) {
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        Intrinsics.checkNotNullParameter(packet, "packet");
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(RFWStringsKt.toLongOrDefault$default(currentAccountUin, 0L, 0, 2, null)));
        for (AssistedChatSwitch assistedChatSwitch : switchList) {
            f(assistedChatSwitch.a(), assistedChatSwitch.b(), switchValue, oidb_0x587_reqbody);
        }
        yu3.b bVar = yu3.b.f451254a;
        byte[] byteArray = oidb_0x587_reqbody.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "reqBody.toByteArray()");
        bVar.a(packet, 1415, 74, byteArray);
    }

    @Override // yu3.c
    public boolean b(List<AssistedChatSwitch> switchList, int switchValue, FromServiceMsg rsp) {
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        return rsp.isSuccess();
    }

    @Override // yu3.c
    public List<d> c(String uin, List<AssistedChatSwitch> switchList, FromServiceMsg rsp) {
        Object orNull;
        List<d> emptyList;
        List<d> emptyList2;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
        int b16 = yu3.b.f451254a.b(rsp, oidb_0x5eb_rspbody);
        if (b16 != 0) {
            QLog.w("AssistedChatProfileSwitchReqWrapper", 1, "onReceiveGetResponse parseOIDBRsp " + b16);
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        List<oidb_0x5eb$UdcUinData> list = oidb_0x5eb_rspbody.rpt_msg_uin_data.get();
        Intrinsics.checkNotNullExpressionValue(list, "rspBody.rpt_msg_uin_data.get()");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = (oidb_0x5eb$UdcUinData) orNull;
        if (oidb_0x5eb_udcuindata == null) {
            QLog.w("AssistedChatProfileSwitchReqWrapper", 1, "onReceiveGetResponse parseOIDBRsp rpt_msg_uin_data is null");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (AssistedChatSwitch assistedChatSwitch : switchList) {
            PBUInt32Field a16 = INSTANCE.a(assistedChatSwitch.a(), assistedChatSwitch.b(), oidb_0x5eb_udcuindata);
            if (a16 != null) {
                int i3 = a16.get();
                arrayList.add(new d(assistedChatSwitch, e(assistedChatSwitch.b(), i3), i3));
            }
        }
        return arrayList;
    }

    @Override // yu3.c
    public void d(String uin, List<AssistedChatSwitch> switchList, Packet packet) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(switchList, "switchList");
        Intrinsics.checkNotNullParameter(packet, "packet");
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        if (uin.length() == 0) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            uin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (uin == null) {
                uin = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(uin, "MobileQQ.sMobileQQ.peekA\u2026?.currentAccountUin ?: \"\"");
            }
        }
        oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(RFWStringsKt.toLongOrDefault$default(uin, 0L, 0, 2, null)));
        for (AssistedChatSwitch assistedChatSwitch : switchList) {
            INSTANCE.b(assistedChatSwitch.a(), assistedChatSwitch.b(), oidb_0x5eb_reqbody);
        }
        yu3.b bVar = yu3.b.f451254a;
        byte[] byteArray = oidb_0x5eb_reqbody.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "reqBody.toByteArray()");
        bVar.a(packet, 1515, 22, byteArray);
    }

    private final boolean e(AssistedChatSwitchType switchType, int flag) {
        return (flag == 0 && switchType.getDefValue()) || flag == 1;
    }
}
