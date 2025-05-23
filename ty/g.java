package ty;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCnt;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.i;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J.\u0010\t\u001a\u00020\b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001e\u001a\u00020\b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lty/g;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "Lty/a;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "l", "message", "", DomainData.DOMAIN_NAME, "extendValue", "o", "str", "Lorg/json/JSONObject;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "e", "f", "Lcom/tencent/biz/pubaccount/weishi/push/WSRedDotPushMsg;", "pushMsg", "r", "i", "Lkotlin/Function0;", "listener", "p", "Lty/b;", "j", "b", "Lcom/tencent/biz/pubaccount/weishi/push/WSRedDotPushMsg;", "redDotPushMsg", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f437886a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static WSRedDotPushMsg redDotPushMsg;

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ty.a aVar, int i3, String str, ArrayList arrayList) {
        x.f("WSChatMsgManager", "[getPushMsgById] result:" + i3 + ", errMsg:" + str);
        f437886a.m(arrayList, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ty.a aVar, int i3, String str, ArrayList arrayList) {
        x.f("WSChatMsgManager", "[getPushMsg] result:" + i3 + ", errMsg:" + str);
        f437886a.m(arrayList, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        x.f("WSChatMsgManager", "[getUnreadCntInfo] result:" + i3 + ", errMsg:" + str);
    }

    private final Contact l() {
        return new Contact(103, "u_wyX0FXIedrSFJaraSnfLuQ", "");
    }

    private final String n(MsgRecord message) {
        String str;
        if (message == null) {
            return "";
        }
        try {
            nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = new nt_im_msg_body$GeneralFlags();
            nt_im_msg_body_generalflags.mergeFrom(message.generalFlags);
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.mergeFrom(nt_im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
            str = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8();
        } catch (InvalidProtocolBufferMicroException e16) {
            x.f("WSChatMsgManager", "[parseExtraFromMsgRecord] get json str fail, exception:" + e16.getLocalizedMessage());
            str = null;
        }
        x.f("WSChatMsgManager", "[parseExtraFromMsgRecord] oacMsgExtend json:" + str);
        return o(str);
    }

    private final String o(String extendValue) {
        List<String> split$default;
        boolean startsWith$default;
        List split$default2;
        Object orNull;
        JSONObject s16 = s(extendValue);
        if (s16 == null) {
            return "";
        }
        String triggle = s16.optString("oac_triggle");
        x.f("WSChatMsgManager", "[parseOacMsgExtend] triggle:" + triggle);
        Intrinsics.checkNotNullExpressionValue(triggle, "triggle");
        split$default = StringsKt__StringsKt.split$default((CharSequence) triggle, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        for (String str : split$default) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "busi_id", false, 2, null);
            if (startsWith$default) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                orNull = CollectionsKt___CollectionsKt.getOrNull(split$default2, 1);
                String str2 = (String) orNull;
                if (str2 != null) {
                    String decodeUrl = URLUtil.decodeUrl(str2);
                    Intrinsics.checkNotNullExpressionValue(decodeUrl, "decodeUrl(it)");
                    return decodeUrl;
                }
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0, int i3, String str) {
        x.j("WSChatMsgManager", "[setMsgRead] result:" + i3 + ", errMsg:" + str);
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void f(final ty.a callback) {
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(l(), 0L, 1, true, new IMsgOperateCallback() { // from class: ty.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                g.h(a.this, i3, str, arrayList);
            }
        });
    }

    public final WSRedDotPushMsg i() {
        return redDotPushMsg;
    }

    public final void j(b listener) {
        w msgService;
        Intrinsics.checkNotNullParameter(listener, "listener");
        QQAppInterface t16 = bb.t();
        IKernelService iKernelService = t16 != null ? (IKernelService) t16.getRuntimeService(IKernelService.class, "all") : null;
        if (iKernelService == null || (msgService = iKernelService.getMsgService()) == null) {
            return;
        }
        msgService.addMsgListener(new a(listener, msgService));
        msgService.getContactUnreadCnt(new IOperateCallback() { // from class: ty.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                g.k(i3, str);
            }
        });
    }

    public final void p(final Function0<Unit> listener) {
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(l(), new IOperateCallback() { // from class: ty.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                g.q(Function0.this, i3, str);
            }
        });
    }

    public final void r(WSRedDotPushMsg pushMsg) {
        redDotPushMsg = pushMsg;
    }

    private final void m(ArrayList<MsgRecord> msgList, ty.a callback) {
        WSRedDotPushMsg wSRedDotPushMsg;
        if (msgList == null || msgList.size() <= 0 || msgList.get(0).elements == null || msgList.get(0).elements.size() <= 0) {
            wSRedDotPushMsg = null;
        } else {
            String n3 = n(msgList.get(0));
            x.f("WSChatMsgManager", "[getPushMsg] extraData: " + n3);
            wSRedDotPushMsg = WSRedDotPushMsg.getInstance(n3);
        }
        if (callback != null) {
            callback.a(wSRedDotPushMsg);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject s(String str) {
        boolean z16;
        boolean isBlank;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                try {
                    return new JSONObject(str);
                } catch (JSONException e16) {
                    x.f("WSChatMsgManager", "[string2Json] e:" + e16.getMessage());
                    return null;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void e(RecentContactInfo info, final ty.a callback) {
        if (info == null) {
            x.f("WSChatMsgManager", "[getPushMsgById] info is null!");
            if (callback != null) {
                callback.a(null);
                return;
            }
            return;
        }
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).asyncGetLastMsgRecord(info, new IMsgOperateCallback() { // from class: ty.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                g.g(a.this, i3, str, arrayList);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JX\u0010\t\u001a\u00020\b2N\u0010\u0007\u001aJ\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0018\u00010\u0002j,\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"ty/g$a", "Lcom/tencent/qqnt/msg/i;", "Ljava/util/HashMap;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "Lkotlin/collections/HashMap;", "newUnreadCntInfos", "", "onContactUnreadCntUpdate", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends i {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f437888e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f437889f;

        a(b bVar, w wVar) {
            this.f437888e = bVar;
            this.f437889f = wVar;
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onContactUnreadCntUpdate(HashMap<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntInfos) {
            UnreadCnt unreadCnt;
            HashMap<String, UnreadCntInfo> hashMap;
            UnreadCntInfo unreadCntInfo = (newUnreadCntInfos == null || (hashMap = newUnreadCntInfos.get(103)) == null) ? null : hashMap.get("u_wyX0FXIedrSFJaraSnfLuQ");
            x.f("WSChatMsgManager", "[getUnreadCntInfo] info: " + unreadCntInfo);
            this.f437888e.a((unreadCntInfo == null || (unreadCnt = unreadCntInfo.showUnreadCnt) == null) ? 0 : unreadCnt.cnt);
            this.f437889f.removeMsgListener(this);
        }
    }
}
