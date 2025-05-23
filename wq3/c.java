package wq3;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.dataline.util.j;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.event.AIOMsgEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.aio.title.ai;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleChatGetPMBeginShowMsgRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qcircle.ntchat.QFSAioTopTipMsgIntent$OnGetFollowState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo;
import qqcircle.QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements com.tencent.aio.main.businesshelper.h {
    private AppInterface F;
    com.tencent.qqnt.aio.shortcutbar.i G;
    private IKernelMsgListener H;

    /* renamed from: d, reason: collision with root package name */
    String f446066d;

    /* renamed from: e, reason: collision with root package name */
    int f446067e;

    /* renamed from: f, reason: collision with root package name */
    Long f446068f;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.aio.api.runtime.a f446069h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f446070i;

    /* renamed from: m, reason: collision with root package name */
    private int f446071m;
    private int C = -1;
    private int D = -1;
    private boolean E = uq3.c.P0();
    private com.tencent.mvi.base.route.a I = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            c.this.s(msgIntent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements com.tencent.qqnt.aio.shortcutbar.i {
        b() {
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean a(int i3, boolean z16) {
            return false;
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.i
        public boolean b(int i3, boolean z16) {
            return c.this.r(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: wq3.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C11502c implements IKernelMsgListener {
        C11502c() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            if (i16 == 0 && bArr != null && bArr.length > 0) {
                QQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo qQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo = new QQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo();
                try {
                    qQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e(c.this.getTag(), 1, "onRecvMsgSvrRspTransInfo retCode:" + i16 + ", exception:" + e16.toString());
                }
                int i17 = qQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo.int32_ret_code.get();
                String str2 = qQCirclePrivateMsgAIO$PrivateMsgTransSvrInfo.str_err_msg.get();
                if (QLog.isColorLevel()) {
                    QLog.d(c.this.getTag(), 2, "onRecvMsgSvrRspTransInfo retCode:" + i16 + ", circleRetCode:" + i17 + ", tips:" + str2);
                }
                if (!TextUtils.isEmpty(str2) && c.this.F != null) {
                    QQToast.makeText(c.this.F.getApp(), 2, str2, 0).show();
                    if (QLog.isColorLevel()) {
                        QLog.d(c.this.getTag(), 2, "onRecvMsgSvrRspTransInfo show toast,tips:" + str2);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.d(c.this.getTag(), 1, "onRecvMsgSvrRspTransInfo retCode:" + i16 + ", errorMsg:" + str + ", transSvrInfo is empty!");
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements VSDispatchObserver.OnVSRspCallBack<QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp> {
        d() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp) {
            String traceId;
            boolean z17 = true;
            if (z16 && j3 == 0 && qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp != null) {
                if (qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.followState.has()) {
                    c.this.C = qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.followState.get();
                }
                if (qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.showGuideBar.get()) {
                    c.this.t(qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp);
                    c.this.D = qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.blackState.get();
                }
                if (qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.pmBeginShow.has()) {
                    boolean y16 = c.this.y();
                    boolean v3 = c.this.v();
                    String accountId = RFWApplication.getAccountId();
                    String str2 = "";
                    if (baseRequest == null) {
                        traceId = "";
                    } else {
                        traceId = baseRequest.getTraceId();
                    }
                    String str3 = "| mPeerUin: " + c.this.f446068f + " | accountId: " + accountId;
                    int i3 = RFWLog.USR;
                    Object[] objArr = new Object[1];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[onReceive] mPeerFollowState: ");
                    sb5.append(c.this.C);
                    sb5.append(" | isSingleFollow: ");
                    sb5.append(y16);
                    sb5.append(" | mPeerBlackState: ");
                    sb5.append(c.this.D);
                    sb5.append(" | isBlackState: ");
                    sb5.append(v3);
                    if (RFWLog.isDevelopLevel()) {
                        str2 = str3;
                    }
                    sb5.append(str2);
                    sb5.append(" | traceId: ");
                    sb5.append(traceId);
                    objArr[0] = sb5.toString();
                    RFWLog.d("QPL-QCircleAioDisplayHelper", i3, objArr);
                    String accountId2 = RFWApplication.getAccountId();
                    String valueOf = String.valueOf(c.this.f446068f);
                    String valueOf2 = String.valueOf(c.this.f446066d);
                    if (!y16 && !v3) {
                        z17 = false;
                    }
                    com.tencent.mobileqq.qcircle.api.utils.a.g(accountId2, valueOf, valueOf2, z17);
                    c.this.p(qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.pmBeginShow.get());
                    return;
                }
                QLog.e(c.this.getTag(), 1, "[requestFuelTips] error,miss pmBeginShow data!");
                return;
            }
            QLog.e(c.this.getTag(), 1, "[requestFuelTips] error:" + j3 + "  errorMsg:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements IAddJsonGrayTipMsgCallback {
        e() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
        public void onResult(int i3, long j3) {
            QLog.d(c.this.getTag(), 1, "[addLocalGrayTip] result = " + i3 + ", msgId = " + j3);
        }
    }

    private void A() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(String.valueOf(this.f446068f)).setActionType(45).setSubActionType(3).setThrActionType(1));
    }

    private void B() {
        VSNetworkHelper.getInstance().sendRequest((Context) null, new QCircleChatGetPMBeginShowMsgRequest(String.valueOf(this.f446068f)), new d());
    }

    private void C() {
        com.tencent.aio.api.runtime.a aVar = this.f446069h;
        if (aVar != null && aVar.e() != null) {
            if (this.G == null) {
                this.G = new b();
            }
            this.f446069h.e().h(new ShortCutBarEvent.SetShortcutPanelClickListener(this.G));
            if (!this.f446070i) {
                this.f446069h.e().h(new AIOTitleEvent.UpdateRight1IvEvent(false, true, new ColorDrawable(), 6, null));
            }
            if (this.f446071m == QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE()) {
                this.f446069h.e().h(new AIOTitleEvent.SubTitleResponseEvent(new ai(null, null, null, j.d("\u6765\u81ea\"\u5c0f\u4e16\u754c\""), "5")));
            }
            this.f446069h.e().d(AIOMsgEvent.GetFirstMsgEndEvent.class.getCanonicalName(), this.I);
            return;
        }
        QLog.e(getTag(), 1, "[initAndAddListener] mAioContext == null || mAioContext.getMessenger() == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        if (this.F == null) {
            return;
        }
        QLog.d(getTag(), 1, "[addLocalGrayTip] fullTip = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(this.F, new LocalGrayTip.a(this.f446066d, this.f446067e, 2601L, null, false, false).b(new JSONObject(str)).a(), new e());
        } catch (JSONException e16) {
            QLog.e(getTag(), 1, "[addLocalGrayTip] error ", e16);
        }
        A();
    }

    private boolean q() {
        if (this.C != -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(int i3) {
        if (!this.E) {
            return false;
        }
        if (this.F == null) {
            return true;
        }
        if (!q()) {
            QQToast.makeText(this.F.getApp(), "\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019", 0).show();
            return true;
        }
        if (!x(i3) || (!v() && !y())) {
            return false;
        }
        QQToast.makeText(this.F.getApp(), "\u4e92\u76f8\u5173\u6ce8\u624d\u53ef\u4ee5\u53d1\u56fe\u7247", 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(@NotNull MsgIntent msgIntent) {
        if (msgIntent instanceof AIOMsgEvent.GetFirstMsgEndEvent) {
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp) {
        int i3 = qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.blackState.get();
        if (i3 != 0) {
            QLog.d(getTag(), 1, "[handleAddTopTips] return blackState=", Integer.valueOf(i3));
        } else {
            this.f446069h.e().h(new QFSAioTopTipMsgIntent$OnGetFollowState(this.C));
        }
    }

    private void u() {
        boolean z16;
        AppInterface appInterface;
        com.tencent.aio.api.runtime.a aVar = this.f446069h;
        if (aVar == null) {
            QLog.e(getTag(), 1, "[initData] mAioContext == null");
            return;
        }
        if (aVar.g() == null) {
            QLog.e(getTag(), 1, "[initData] getAioParam == null");
            return;
        }
        AIOParam g16 = this.f446069h.g();
        this.f446066d = g16.r().c().j();
        this.f446067e = g16.r().c().e();
        this.f446068f = Long.valueOf(g16.l().getLong("key_peerUin", 0L));
        this.f446070i = this.f446069h.g().l().getBoolean(HostChatUtils.QCIRCLE_CHAT_HIDE_MENU_KEY(), true);
        this.f446071m = this.f446069h.g().l().getInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE());
        if (this.E && !w()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.E = z16;
        String string = this.f446069h.g().l().getString(HostChatUtils.QCIRCLE_CHAT_GET_UID_ERR_MSG_KEY(), "");
        if (!TextUtils.isEmpty(string) && (appInterface = this.F) != null) {
            QQToast.makeText(appInterface.getApp(), string, 0).show();
        }
        QLog.d(getTag(), 1, "[initData] peerUid = " + this.f446066d + ", chatType = " + this.f446067e + ", mIsHideMenu = " + this.f446070i + ", mPeerUin = " + this.f446068f + ", mLimitSwitch = " + this.E + ", getUidErrMsg = " + string + ", uinType = " + this.f446071m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        int i3 = this.D;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    private boolean w() {
        List<String> chatNoLimitWhiteList = HostChatUtils.getChatNoLimitWhiteList();
        if (chatNoLimitWhiteList != null && !chatNoLimitWhiteList.isEmpty()) {
            return chatNoLimitWhiteList.contains(this.f446068f);
        }
        return false;
    }

    private boolean x(int i3) {
        if (i3 != 1003 && i3 != 1005) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        if (this.C != 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return HostChatUtils.getQCircleHelperId();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "QPL-QCircleAioDisplayHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    public void o() {
        AppInterface appInterface = this.F;
        if (appInterface == null) {
            QLog.e(getTag(), 1, "[addKernelMsgListener] mApp is null");
            return;
        }
        w msgService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e(getTag(), 1, "[addKernelMsgListener] msgService is null");
        } else if (this.H == null) {
            C11502c c11502c = new C11502c();
            this.H = c11502c;
            msgService.addMsgListener(c11502c);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b bVar) {
        this.F = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.f446069h = bVar.a();
        u();
        C();
        o();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.f446069h.e().b(AIOMsgEvent.GetFirstMsgEndEvent.class.getCanonicalName(), this.I);
        z();
        this.F = null;
    }

    public void z() {
        IKernelMsgListener iKernelMsgListener;
        AppInterface appInterface = this.F;
        if (appInterface == null) {
            QLog.e(getTag(), 1, "[removeKernelMsgListener] mApp is null");
            return;
        }
        w msgService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null && (iKernelMsgListener = this.H) != null) {
            msgService.removeMsgListener(iKernelMsgListener);
            this.H = null;
        } else {
            QLog.e(getTag(), 1, "[removeKernelMsgListener] msgService or  mKernelMsgListener is null");
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
    }
}
