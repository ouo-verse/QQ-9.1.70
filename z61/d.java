package z61;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.upcoming.reminder.IAIOUpComingAlarmService;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import z61.f;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements Manager {

    /* renamed from: f, reason: collision with root package name */
    private MsgRecord f452010f;

    /* renamed from: h, reason: collision with root package name */
    private ColorNoteCurd f452011h;

    /* renamed from: i, reason: collision with root package name */
    private z61.c f452012i;

    /* renamed from: m, reason: collision with root package name */
    private IKernelMsgListener f452013m;

    /* renamed from: d, reason: collision with root package name */
    protected ConcurrentHashMap<String, ColorNote> f452008d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f452009e = new ConcurrentHashMap<>();
    private final MqqHandler C = new MqqHandler(ThreadManagerV2.getSubThreadLooper(), new a());
    private ea1.e D = new b();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1001) {
                Object obj = message.obj;
                if (obj instanceof ColorNote) {
                    ColorNote colorNote = (ColorNote) obj;
                    d.this.C.removeMessages(1001, colorNote);
                    d.this.x(colorNote);
                    d.this.s(colorNote);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements ea1.e {
        b() {
        }

        @Override // ea1.e
        public void a(ColorNote colorNote) {
            if (colorNote != null && ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote(colorNote)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note del." + colorNote);
                }
                d.this.p(colorNote, 1002);
            }
        }

        @Override // ea1.e
        public void b(ColorNote colorNote) {
            if (colorNote != null && ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote(colorNote)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "color note add." + colorNote);
                }
                d.this.p(colorNote, 1001);
                ReportController.o(null, "dc00898", "", "", "0X800AE81", "0X800AE81", z61.e.c(colorNote).reportType, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements IKernelMsgListener {
        c() {
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
        public void onMsgInfoListUpdate(ArrayList<MsgRecord> arrayList) {
            if (arrayList.isEmpty()) {
                return;
            }
            MsgRecord msgRecord = arrayList.get(0);
            if (!msgRecord.getElements().isEmpty() && msgRecord.getElements().get(0).getGrayTipElement() != null) {
                d.this.f452010f = msgRecord;
            }
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
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
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

    /* compiled from: P */
    /* renamed from: z61.d$d, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C11656d implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f452017a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f452018b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f452019c;

        C11656d(Context context, List list, String str) {
            this.f452017a = context;
            this.f452018b = list;
            this.f452019c = str;
        }

        @Override // z61.f.b
        public void a(long j3) {
            d.this.w(this.f452017a, this.f452018b, j3, 1, this.f452019c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f452021a;

        e(Context context) {
            this.f452021a = context;
        }

        @Override // com.tencent.mobileqq.colornote.g
        public void onAddColorNote(Bundle bundle, boolean z16) {
            super.onAddColorNote(bundle, z16);
            if (z16) {
                QQToast.makeText(this.f452021a, 2, R.string.f237427h1, 0).show();
            } else {
                QQToast.makeText(this.f452021a, 0, R.string.f237417h0, 0).show();
            }
        }
    }

    public d(QQAppInterface qQAppInterface) {
        ((IColorNoteDataService) qQAppInterface.getRuntimeService(IColorNoteDataService.class)).registerColorNoteListener(this.D);
    }

    private void A(ColorNote colorNote) {
        if (colorNote != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                ((IColorNoteDataService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IColorNoteDataService.class)).setUpcomingColorNoteExtLong(colorNote);
            }
        }
    }

    private void i(ColorNote colorNote) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IAIOUpComingAlarmService) peekAppRuntime.getRuntimeService(IAIOUpComingAlarmService.class, "")).cancelAlarm(colorNote);
        }
    }

    private void j(Context context) {
        if (this.f452011h == null) {
            this.f452011h = new ColorNoteCurd();
            this.f452011h.l(new e(context.getApplicationContext()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object[], java.io.Serializable] */
    private void m(Context context, UpComingMsgModel upComingMsgModel) {
        if (upComingMsgModel.uniseq.size() > 0) {
            Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
            intent.putExtra("chat_subType", 4);
            intent.putExtra("uin", upComingMsgModel.frienduin);
            intent.putExtra("uintype", upComingMsgModel.istroop);
            if (!TextUtils.isEmpty(upComingMsgModel.nickName)) {
                intent.putExtra("uinname", upComingMsgModel.nickName);
            }
            intent.addFlags(268435456);
            intent.putExtra("key_uniseq", (Serializable) upComingMsgModel.uniseq.toArray(new Long[0]));
            context.startActivity(intent);
        }
    }

    private void n(Context context, UpComingMsgModel upComingMsgModel) {
        long longValue = upComingMsgModel.uniseq.get(0).longValue();
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        BaseAIOUtils.m(aliasIntent, new int[]{2});
        aliasIntent.putExtra("uin", upComingMsgModel.frienduin);
        aliasIntent.putExtra("uintype", upComingMsgModel.istroop);
        aliasIntent.putExtra("key_uniseq", longValue);
        aliasIntent.putExtra("troop_uin", upComingMsgModel.troopUin);
        if (!TextUtils.isEmpty(upComingMsgModel.nickName)) {
            aliasIntent.putExtra("uinname", upComingMsgModel.nickName);
        }
        context.startActivity(aliasIntent);
    }

    private void o(Context context, UpComingMsgModel upComingMsgModel) {
        if (QLog.isColorLevel()) {
            QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, "[handleClickFromMulti], model:" + upComingMsgModel);
        }
        int i3 = upComingMsgModel.type;
        if (i3 == 1) {
            n(context, upComingMsgModel);
            ReportController.o(null, "dc00898", "", "", "0X800AE90", "0X800AE90", 1, 0, "", "", "", "");
        } else if (i3 == 2) {
            m(context, upComingMsgModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ColorNote colorNote, int i3) {
        long j3;
        if (colorNote != null) {
            if (i3 != 1001) {
                if (i3 == 1002) {
                    if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_upcoming_alarm_8996", true)) {
                        i(colorNote);
                    } else {
                        this.C.removeMessages(1001, colorNote);
                    }
                    x(colorNote);
                    this.f452009e.remove(colorNote.getSubType());
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long i16 = z61.e.i(colorNote);
            while (q(i16)) {
                i16++;
            }
            this.f452009e.put(colorNote.getSubType(), Long.valueOf(i16));
            boolean isNeedNowNotify = ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isNeedNowNotify(colorNote);
            QLog.d("UpComingMsgLogic.UpComingMsgManager", 1, "currentTime = " + currentTimeMillis + ", mindTime = " + i16 + ", needNowNotify = " + isNeedNowNotify + ", note.ServiceType = " + colorNote.getServiceType());
            if ((((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote(colorNote) && currentTimeMillis < i16) || isNeedNowNotify) {
                Message obtain = Message.obtain();
                obtain.what = i3;
                obtain.obj = colorNote;
                this.f452008d.put(colorNote.getSubType(), colorNote);
                if (currentTimeMillis < i16) {
                    j3 = i16 - currentTimeMillis;
                } else {
                    j3 = 0;
                }
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_upcoming_alarm_8996", true)) {
                    z(i16, colorNote);
                    QLog.i("UpComingMsgLogic.UpComingMsgManager", 1, "setAlarm mindTime is " + i16 + " colorNote subType is " + colorNote.getSubType());
                    return;
                }
                this.C.sendMessageDelayed(obtain, j3);
                QLog.i("UpComingMsgLogic.UpComingMsgManager", 1, "sendUpcomingMessage delayTime is " + j3);
                return;
            }
            QLog.d("UpComingMsgLogic.UpComingMsgManager", 1, "handleListener() CALLED.currentTime higher mindTime.");
        }
    }

    private boolean q(long j3) {
        Iterator<Map.Entry<String, Long>> it = this.f452009e.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().longValue() == j3) {
                return true;
            }
        }
        return false;
    }

    private boolean r() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ColorNote colorNote) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("UpComingMsgLogic.UpComingMsgManager", 1, "[notifyComing]: runtime is " + peekAppRuntime);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (!((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).checkPermission(BaseApplication.getContext())) {
            QLog.e("UpComingMsgLogic.UpComingMsgManager", 1, "permission denied, stop notify: " + colorNote.toString());
            return;
        }
        this.f452009e.remove(colorNote.getSubType());
        if (r()) {
            QLog.d("UpComingMsgLogic.UpComingMsgManager", 1, "[notifyComing] is called. isBackground_Pause = " + qQAppInterface.isBackgroundPause + ", isBackground_Stop = " + qQAppInterface.isBackgroundStop + " colorNote: " + colorNote);
            A(colorNote);
            if (qQAppInterface.isBackgroundPause || qQAppInterface.isBackgroundStop) {
                B(colorNote);
                ReportController.o(null, "dc00898", "", "", "0X800AE83", "0X800AE83", 0, 0, "", "", "", "");
            }
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).notifyUpcoming(qQAppInterface.getApp().getApplicationContext(), colorNote);
        }
        ReportController.o(null, "dc00898", "", "", "0X800AE82", "0X800AE82", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Context context, List<AIOMsgItem> list, long j3, int i3, String str) {
        if (list != null && list.size() > 0) {
            if (this.f452010f != null) {
                ArrayList arrayList = new ArrayList();
                if (1 == i3 && this.f452010f.getMsgSeq() != list.get(0).getMsgRecord().getMsgSeq()) {
                    arrayList.add(list.get(0));
                }
                if (!arrayList.isEmpty()) {
                    g(context, list, j3, i3, str);
                    return;
                } else {
                    QQToast.makeText(context, 1, R.string.yuj, 0).show();
                    return;
                }
            }
            g(context, list, j3, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(ColorNote colorNote) {
        if (this.f452008d.containsKey(colorNote.getSubType())) {
            this.f452008d.remove(colorNote.getSubType());
        }
    }

    private void z(long j3, ColorNote colorNote) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IAIOUpComingAlarmService) peekAppRuntime.getRuntimeService(IAIOUpComingAlarmService.class, "")).setAlarm(j3, colorNote);
        }
    }

    protected void B(ColorNote colorNote) {
        if (BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
            Intent aliasIntent = SplashActivity.getAliasIntent(BaseApplication.getContext());
            aliasIntent.putExtra("KEY_CMD_SHOW_LIST", 1);
            aliasIntent.putExtra("flag_open_up_coming_list", true);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.addFlags(335544320);
            aliasIntent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
            aliasIntent.putExtra(QQNotificationManager.PARAM_NOTIFYID, NotificationUtil.Constants.NOTIFY_ID_UPCOMING_MSG);
            if (QLog.isColorLevel()) {
                QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, "showNotification intent = " + aliasIntent.hashCode());
            }
            PendingIntent activity = PendingIntent.getActivity(BaseApplication.getContext(), 0, aliasIntent, 167772160);
            NotificationCompat.Builder when = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8f).setAutoCancel(true).setOngoing(false).setWhen(System.currentTimeMillis());
            when.setContentText("\u6536\u5230\u5f85\u529e\u63d0\u9192: " + colorNote.getMainTitle()).setContentIntent(activity);
            QQNotificationManager.getInstance().notify("UpComingMsgLogic.UpComingMsgManager", NotificationUtil.Constants.NOTIFY_ID_UPCOMING_MSG, when.build());
        }
    }

    public void g(Context context, List<AIOMsgItem> list, long j3, int i3, String str) {
        j(context);
        this.f452011h.o(0, "update_process_state", false);
        if (!this.f452011h.d()) {
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).showFullDialog(context);
            return;
        }
        if (list != null && list.size() > 0) {
            try {
                ColorNote l3 = l(list, j3, i3, str);
                if (l3 != null) {
                    this.f452011h.a(l3.parseBundle());
                }
            } catch (IllegalAccessException e16) {
                QLog.e("UpComingMsgLogic.UpComingMsgManager", 1, "addColorNote occur error.", e16);
            }
        }
    }

    public void h() {
        if (this.f452013m == null) {
            this.f452013m = new c();
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(this.f452013m);
        }
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("UpComingMsgLogic.UpComingMsgManager", 1, "[doAlarm]: subType is null");
            return;
        }
        if (this.f452008d.containsKey(str)) {
            ColorNote colorNote = this.f452008d.get(str);
            if (colorNote != null) {
                x(colorNote);
                s(colorNote);
                return;
            }
            return;
        }
        QLog.i("UpComingMsgLogic.UpComingMsgManager", 1, "[doAlarm]: not contains " + str);
    }

    ColorNote l(List<AIOMsgItem> list, long j3, int i3, String str) throws IllegalAccessException {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            if (this.f452012i == null) {
                this.f452012i = new z61.c(qQAppInterface);
            }
            return this.f452012i.b(list, j3, 2, str);
        }
        if (this.f452012i == null) {
            this.f452012i = new z61.c(qQAppInterface);
        }
        return this.f452012i.b(list, j3, 1, str);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f452008d.clear();
        this.f452009e.clear();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((IColorNoteDataService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IColorNoteDataService.class)).unregisterColorNoteListener(this.D);
        }
        this.C.removeCallbacksAndMessages(null);
    }

    public void t(Context context, ColorNote colorNote) {
        int i3;
        String str = new String(colorNote.getReserve());
        UpComingMsgModel upComingMsgModel = new UpComingMsgModel();
        upComingMsgModel.parseFromJson(str);
        o(context, upComingMsgModel);
        if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isNeedNowNotify(colorNote)) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AE8F", "0X800AE8F", i3, upComingMsgModel.reportType, "", "", "", "");
    }

    public void u(ColorNote colorNote) {
        if (this.f452008d.containsKey(colorNote.getSubType())) {
            if (QLog.isDevelopLevel()) {
                QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "onColorNoteLoadFromLocal() CALLED.has marked.");
            }
        } else {
            if (QLog.isDevelopLevel()) {
                QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "onColorNoteLoadFromLocal() CALLED.colorNote = " + colorNote);
            }
            p(colorNote, 1001);
        }
    }

    public void v(Context context, AIOMsgItem aIOMsgItem, String str) {
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, aIOMsgItem.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(aIOMsgItem);
        f fVar = new f(context);
        fVar.o(1);
        fVar.p(new C11656d(context, arrayList, str));
        ReportController.o(null, "dc00898", "", "", "0X800AE7D", "0X800AE7D", z61.e.d(aIOMsgItem), 0, "", "", "", "");
    }

    public void y() {
        if (this.f452013m != null) {
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.removeMsgListener(this.f452013m);
            }
            this.f452013m = null;
        }
    }
}
