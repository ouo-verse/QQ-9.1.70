package tu3;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.bc;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qcall.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopgag.data.e;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aj;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nt.adapter.session.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.AVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.pluspanel.processor.util.GroupVideoEntrance;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.util.LogUtil;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J0\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J(\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u001e\u0010\u001e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0003J\u001e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ&\u0010 \u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ@\u0010$\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010#\u001a\u00020\u0017\u00a8\u0006'"}, d2 = {"Ltu3/b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AVRecordElement;", "", "b", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "Lcom/tencent/mobileqq/data/MessageForVideo;", "messageForVideo", "", "k", "avType", "", BaseProfileQZoneComponent.KEY_IS_VIDEO, "g", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, "f", "e", "Lmqq/app/AppRuntime;", "", "subAction", "actionName", h.F, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "type", "c", "l", "d", "content", "msgSelfUin", "fromWhere", "i", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f437488a = new b();

    b() {
    }

    private final int b(AVRecordElement aVRecordElement) {
        return aVRecordElement.type == 1 ? 13 : -1;
    }

    private final void g(QQAppInterface app, Context context, SessionInfo sessionInfo, int avType, boolean isVideo) {
        AVNotifyCenter.i Q;
        QLog.w("GroupVideoResultOnClickProcessor", 1, "qqVideo_group, avType[" + avType + "], isVideo[" + isVideo + "]");
        if (avType == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put("MultiAVType", String.valueOf(avType));
            hashMap.put("from", "itemBuilder");
            GroupVideoEntrance groupVideoEntrance = GroupVideoEntrance.f360542a;
            int i3 = sessionInfo.f179555d;
            String str = sessionInfo.f179557e;
            Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
            groupVideoEntrance.I(app, context, i3, str, hashMap);
            Long relationId = Long.valueOf(sessionInfo.f179557e);
            int i16 = sessionInfo.f179555d;
            if (i16 == 3000) {
                long n3 = app.getAVNotifyCenter().n();
                if (relationId != null && n3 == relationId.longValue()) {
                    return;
                }
                h(app, "Multi_call", "Multi_call_disobj_launch");
                return;
            }
            if (i16 == 1) {
                AVNotifyCenter aVNotifyCenter = app.getAVNotifyCenter();
                Intrinsics.checkNotNullExpressionValue(relationId, "relationId");
                if (aVNotifyCenter.R(1, relationId.longValue())) {
                    return;
                }
                if (avType == 10) {
                    if (app.getAVNotifyCenter().n() == 0 && ((Q = app.getAVNotifyCenter().Q(relationId.longValue(), 10)) == null || Q.f73809c <= 0)) {
                        h(app, "0X8005925", "0X8005925");
                    }
                    h(app, "0X8005DC6", "0X8005DC6");
                    return;
                }
                h(app, "0X80046CB", "0X80046CB");
                return;
            }
            return;
        }
        boolean g16 = cp.g("qqVideoEx", app, sessionInfo.f179557e);
        Bundle bundle = new Bundle();
        bundle.putInt("MultiAVType", avType);
        bundle.putBoolean("enableInvite", g16);
        bundle.putBoolean(BaseProfileQZoneComponent.KEY_IS_VIDEO, isVideo);
        ChatActivityUtils.f0(app, context, sessionInfo.f179555d, sessionInfo.f179557e, true, true, null, bundle);
    }

    private final void h(AppRuntime app, String subAction, String actionName) {
        ReportController.o(app, "CliOper", "", "", subAction, actionName, 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void k(QQAppInterface app, Context context, SessionInfo sessionInfo, MessageForVideo messageForVideo) {
        if (!AVCoreSystemInfo.isSupportSharpAudio() || bc.p0()) {
            return;
        }
        int i3 = messageForVideo.type;
        if (i3 == 13) {
            int i16 = messageForVideo.istroop;
            if (i16 == 1 || i16 == 3000) {
                i(app, context, sessionInfo, messageForVideo.extInt, messageForVideo.isVideo, messageForVideo.selfuin, "AIOQAVCheckPermission");
                return;
            }
            return;
        }
        e(app, sessionInfo, messageForVideo.isVideo, i3);
        if (QLog.isDebugVersion() || QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "[qqVideo_double] content: " + messageForVideo.getDebugInfo());
        }
        if (messageForVideo.isVideo) {
            h(app, "0X8005642", "0X8005642");
        } else {
            h(app, "0X8005243", "0X8005243");
        }
    }

    public final void d(QQAppInterface app, Context context, MessageForVideo messageForVideo, SessionInfo sessionInfo) {
        long j3;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messageForVideo, "messageForVideo");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        l.f179531g = true;
        if (AVCoreSystemInfo.isSupportSharpAudio()) {
            l(app, messageForVideo, sessionInfo);
            if (sessionInfo.f179555d == 1 && messageForVideo.extInt != 10) {
                try {
                    String str = sessionInfo.f179557e;
                    Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
                    j3 = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    j3 = 0;
                }
                long y16 = app.getAVNotifyCenter().y(ba.uinType2AVRelationType(sessionInfo.f179555d), j3);
                Manager manager = app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopGagMgr");
                aj ajVar = (aj) manager;
                boolean e16 = ajVar.e(sessionInfo.f179557e);
                boolean d16 = ajVar.d(sessionInfo.f179557e);
                boolean f16 = ajVar.f(sessionInfo.f179557e);
                e b16 = ajVar.b(sessionInfo.f179557e);
                if (y16 == 0 && ((!f16 && e16) || (!d16 && b16 != null && b16.f300239b > 0))) {
                    QQToast.makeText(app.getApp(), HardCodeUtil.qqStr(R.string.v4t), 0).show(app.getApp().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    return;
                } else {
                    g(app, context, sessionInfo, messageForVideo.extInt, messageForVideo.isVideo);
                    return;
                }
            }
            k(app, context, sessionInfo, messageForVideo);
        }
    }

    private final void e(QQAppInterface app, SessionInfo sessionInfo, boolean isVideo, int closeType) {
        String str;
        String str2;
        QLog.w("ChatItemBuilder", 1, "qqVideoEx, isVideo[" + isVideo + "], closeType[" + closeType + "]");
        f(app, sessionInfo, isVideo, closeType);
        int i3 = sessionInfo.f179555d;
        String str3 = sessionInfo.f179563i;
        if (i3 == 1006) {
            str2 = sessionInfo.f179557e;
            str = null;
        } else {
            str = sessionInfo.f179557e;
            str2 = null;
        }
        if (app.getAVNotifyCenter().g(app.getApp(), isVideo ? 2 : 1, i3, str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("should_believe_only_audio_flag", "true");
        hashMap.put("start_double_rtc_talk_from_source", "2");
        if (((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(str)) {
            hashMap.put("from", "3");
            ChatActivityUtils.c0(app, app.getApp(), i3, str, str3, !isVideo, sessionInfo.f179559f, true, true, null, "from_internal", hashMap);
        } else {
            ChatActivityUtils.j0(app, app.getApp(), i3, str, str3, str2, !isVideo, sessionInfo.f179559f, true, true, null, "from_internal", hashMap);
        }
    }

    public final void c(Context context, AIOMsgItem msgItem, int type) {
        AVRecordElement aVRecordElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(qQAppInterface, msgItem.getMsgRecord());
        MessageForVideo messageForVideo = new MessageForVideo();
        MessageRecord.copyMessageRecordBaseField(messageForVideo, convertToChatMessage);
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = c.c(msgItem.v().chatType);
        if (msgItem.v().chatType != 1 && msgItem.v().chatType != 102) {
            sessionInfo.f179557e = msgItem.v().peerUid;
            sessionInfo.f179559f = msgItem.v().peerUid;
            sessionInfo.f179563i = com.tencent.mobileqq.imcore.proxy.utils.a.b(qQAppInterface, sessionInfo.f179557e, true);
        } else {
            String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(msgItem.v().peerUid);
            sessionInfo.f179557e = uinFromUid;
            sessionInfo.f179563i = com.tencent.mobileqq.imcore.proxy.utils.a.a(qQAppInterface, uinFromUid, true);
        }
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(21);
        if (firstTypeElement != null && (aVRecordElement = firstTypeElement.avRecordElement) != null) {
            com.tencent.qqnt.aio.videochat.a aVar = com.tencent.qqnt.aio.videochat.a.f352344a;
            messageForVideo.isVideo = aVar.e(aVRecordElement.type);
            messageForVideo.type = f437488a.b(aVRecordElement);
            messageForVideo.extInt = (aVar.e(aVRecordElement.type) || aVRecordElement.type == 27) ? 2 : 10;
        }
        messageForVideo.istroop = sessionInfo.f179555d;
        messageForVideo.selfuin = qQAppInterface.getCurrentAccountUin();
        if (AVCoreSystemInfo.isSupportSharpAudio()) {
            d(qQAppInterface, context, messageForVideo, sessionInfo);
            if (messageForVideo.istroop == 1044) {
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X800AD93", "0X800AD93", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(QQAppInterface app, SessionInfo sessionInfo, boolean isVideo, int closeType) {
        String str;
        String str2;
        String str3;
        String str4;
        if (!isVideo) {
            str = "Two_call";
            str2 = "Two_call_launch";
        } else {
            str = "Two_video_call";
            str2 = "Two_video_call_launch";
        }
        String str5 = str;
        String str6 = str2;
        int i3 = sessionInfo.f179555d;
        if (i3 != 0) {
            if (i3 == 1004) {
                str4 = "1";
            } else if (i3 == 1006) {
                str4 = "3";
            } else if (i3 == 1000) {
                str4 = "2";
            } else if (i3 == 1001) {
                str4 = "4";
            }
            str3 = str4;
            ReportController.o(app, "CliOper", "", "", str5, str6, 0, 0, str3, "", "", "");
            if (closeType != 0) {
                ReportController.o(app, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
            } else if (closeType == 2) {
                ReportController.o(app, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
            }
            if (!isVideo) {
                h(app, "0X8005643", "0X8005643");
                return;
            } else {
                h(app, "0X8005244", "0X8005244");
                return;
            }
        }
        str3 = "0";
        ReportController.o(app, "CliOper", "", "", str5, str6, 0, 0, str3, "", "", "");
        if (closeType != 0) {
        }
        if (!isVideo) {
        }
    }

    public final void l(QQAppInterface app, MessageForVideo messageForVideo, SessionInfo sessionInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(messageForVideo, "messageForVideo");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        int i3 = messageForVideo.istroop;
        if (messageForVideo.type == 13) {
            if (i3 != 1) {
                if (i3 == 3000) {
                    h(app, "Multi_call", "Multi_call_disobj");
                }
            } else if (messageForVideo.extInt == 10) {
                h(app, "0X8005924", "0X8005924");
            } else {
                String str = sessionInfo.f179557e;
                int j3 = TroopUtils.j(app, str);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j3);
                ReportController.o(null, "dc00899", "Grp_video", "", UinConfigManager.KEY_ADS, "video", 0, 0, str, sb5.toString(), "0", "");
            }
        }
        int i16 = messageForVideo.type;
        if (i16 == 2 || i16 == 24) {
            ReportController.o(app, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
        }
        if (messageForVideo.type == 0) {
            ReportController.o(app, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
        }
    }

    public final void i(QQAppInterface app, Context content, SessionInfo sessionInfo, int avType, boolean isVideo, String msgSelfUin, String fromWhere) {
        int i3;
        boolean z16;
        int i16;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(fromWhere, "fromWhere");
        long b16 = QQAudioHelper.b();
        int i17 = sessionInfo.f179555d;
        String str = sessionInfo.f179557e;
        long c16 = g.c(str);
        QLog.w("ChatItemBuilder", 1, "showGroupQavActionSheet, avType[" + avType + "], isVideo[" + isVideo + "], msgSelfUin[" + LogUtil.getSafePrintUin(msgSelfUin) + "], uinType[" + i17 + "], groupId[" + str + "], curFriendNick[" + sessionInfo.f179563i + "], troopUin[" + sessionInfo.f179559f + "], fromWhere[" + fromWhere + "], isVideoActionSheetShown[" + bc.p0() + "], seq[" + b16 + "]");
        if (10 == avType) {
            AVNotifyCenter.i Q = app.getAVNotifyCenter().Q(c16, avType);
            if (Q == null || Q.f73809c <= 0) {
                Bundle j3 = cp.j(app, str);
                z16 = j3.getBoolean("forceDisableInviteBox");
                i16 = j3.getInt("errId", R.string.dec);
            } else {
                i16 = 0;
                z16 = false;
            }
            if (z16) {
                String string = content.getResources().getString(i16);
                Intrinsics.checkNotNullExpressionValue(string, "content.resources.getString(errId)");
                DialogUtil.createCustomDialog(content, 230, (String) null, string, R.string.d_2, R.string.idk, new DialogInterface.OnClickListener() { // from class: tu3.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i18) {
                        b.j(dialogInterface, i18);
                    }
                }, (DialogInterface.OnClickListener) null).show();
                return;
            }
        }
        if (app.getAVNotifyCenter().g(content, isVideo ? 2 : 1, sessionInfo.f179555d, sessionInfo.f179557e) || app.getAVNotifyCenter().h(content, sessionInfo.f179555d, sessionInfo.f179557e, isVideo)) {
            return;
        }
        boolean z17 = QQAudioHelper.c(19) == 1;
        if (z17) {
            QQAudioHelper.w(HardCodeUtil.qqStr(R.string.v4u));
        }
        if (!app.getAVNotifyCenter().Y(b16, str) && !z17) {
            AVNotifyCenter.i p16 = app.getAVNotifyCenter().p(g.c(str));
            if (p16 != null && (i3 = p16.f73810d) == avType) {
                VideoStatusTipsBar.n(app, content, i17, str, avType, i3 == 2 && p16.f73812f == 2 && p16.f73813g == 4, fromWhere);
                return;
            } else {
                VideoMsgTools.z(app, content, i17, str, sessionInfo.f179563i, isVideo, fromWhere);
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("MultiAVType", ba.uinType2MultiAVType(i17));
        if (isVideo) {
            bundle.putBoolean(BaseProfileQZoneComponent.KEY_IS_VIDEO, true);
        }
        if (i17 == 1) {
            bundle.putBoolean("enableInvite", cp.g("showGroupQavActionSheet", app, str));
        }
        bundle.putString("Fromwhere", fromWhere);
        ChatActivityUtils.f0(app, content, i17, str, true, true, null, bundle);
    }
}
