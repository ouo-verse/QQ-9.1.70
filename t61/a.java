package t61;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a8\u0006\u0019"}, d2 = {"Lt61/a;", "", "", "d", "f", "g", h.F, "e", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "k", "l", "", "a", "i", "Landroid/content/Context;", "context", "", "c", "Lcom/tencent/mobileqq/data/MessageForMixedMsg;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f435470a = new a();

    a() {
    }

    @JvmStatic
    public static final int a(@Nullable MessageRecord message) {
        if (message instanceof MessageForFile) {
            return FileManagerUtil.getFileType(((MessageForFile) message).fileName);
        }
        if (message instanceof MessageForTroopFile) {
            return FileManagerUtil.getFileType(((MessageForTroopFile) message).fileName);
        }
        return -1;
    }

    private final String b(MessageForMixedMsg message, Context context) {
        List<MessageRecord> list = message.msgElemList;
        if (list == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (MessageRecord messageRecord : list) {
            if (messageRecord instanceof MessageForText) {
                if (Intrinsics.areEqual(messageRecord.f203106msg, "\n")) {
                    i3++;
                } else {
                    sb5.append(context.getResources().getString(R.string.f223856hc));
                    i17++;
                }
            } else if (messageRecord instanceof MessageForPic) {
                sb5.append(context.getResources().getString(R.string.image));
                i16++;
            }
        }
        if (list.size() - i3 == 2) {
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            return sb6;
        }
        if (list.size() - i3 == 3) {
            if (i16 > 2) {
                String string = context.getResources().getString(R.string.f223846hb);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026safety_msg_fold_much_pic)");
                return string;
            }
            if (i17 == 1 && i16 == 2) {
                return context.getResources().getString(R.string.f223856hc) + context.getResources().getString(R.string.image) + context.getResources().getString(R.string.image);
            }
            if (i17 == 2 && i16 == 1) {
                return context.getResources().getString(R.string.f223856hc) + context.getResources().getString(R.string.image);
            }
        }
        if (i17 == 0) {
            String string2 = context.getResources().getString(R.string.f223846hb);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026safety_msg_fold_much_pic)");
            return string2;
        }
        return context.getResources().getString(R.string.f223856hc) + context.getResources().getString(R.string.f223846hb);
    }

    @JvmStatic
    @NotNull
    public static final String c(@Nullable MessageRecord message, @Nullable Context context) {
        int i3;
        if (message != null && context != null && context.getResources() != null) {
            if (!(message instanceof MessageForText) && (i3 = message.msgtype) != -1000) {
                if (!(message instanceof MessageForPic) && i3 != -2000) {
                    if (message instanceof MessageForMixedMsg) {
                        return f435470a.b((MessageForMixedMsg) message, context);
                    }
                    if (i3 == -1035) {
                        return context.getResources().getString(R.string.f223856hc) + context.getResources().getString(R.string.image);
                    }
                    if (message instanceof MessageForArkApp) {
                        String string = context.getResources().getString(R.string.f223806h8);
                        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026g(R.string.safety_arkapp)");
                        return string;
                    }
                    if (message instanceof MessageForShortVideo) {
                        String string2 = context.getResources().getString(R.string.ic7);
                        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getString(R.string.video)");
                        return string2;
                    }
                    if (!(message instanceof MessageForFile) && !(message instanceof MessageForTroopFile)) {
                        if (l(message)) {
                            String string3 = context.getResources().getString(R.string.f223866hd);
                            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026R.string.safety_multimsg)");
                            return string3;
                        }
                        String string4 = context.getResources().getString(R.string.f223836ha);
                        Intrinsics.checkNotNullExpressionValue(string4, "context.resources.getStr\u2026ring.safety_msg_fold_msg)");
                        return string4;
                    }
                    int a16 = a(message);
                    if (a16 != 0) {
                        if (a16 != 2) {
                            String string5 = context.getResources().getString(R.string.b5h);
                            Intrinsics.checkNotNullExpressionValue(string5, "context.resources.getString(R.string.file)");
                            return string5;
                        }
                        String string6 = context.getResources().getString(R.string.f223826h_);
                        Intrinsics.checkNotNullExpressionValue(string6, "context.resources.getStr\u2026string.safety_file_video)");
                        return string6;
                    }
                    String string7 = context.getResources().getString(R.string.f223816h9);
                    Intrinsics.checkNotNullExpressionValue(string7, "context.resources.getStr\u2026string.safety_file_image)");
                    return string7;
                }
                String string8 = context.getResources().getString(R.string.image);
                Intrinsics.checkNotNullExpressionValue(string8, "context.resources.getString(R.string.image)");
                return string8;
            }
            String string9 = context.getResources().getString(R.string.f223856hc);
            Intrinsics.checkNotNullExpressionValue(string9, "context.resources.getStr\u2026ing.safety_msg_fold_text)");
            return string9;
        }
        return "";
    }

    @JvmStatic
    public static final boolean d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IFe\u2026ava, ProcessConstant.ALL)");
            return ((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("safety_msg_fold");
        }
        return false;
    }

    @JvmStatic
    public static final boolean e() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("safety_msg_fold_forth");
    }

    @JvmStatic
    public static final boolean f() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("safety_msg_fold_secondary", true);
    }

    @JvmStatic
    public static final boolean g() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("safety_msg_fold_tertiary", true);
    }

    @JvmStatic
    public static final boolean h() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("safety_other_evilmsg_switch", true);
    }

    private final boolean i(MessageRecord message) {
        int i3;
        if (message == null || !f()) {
            return false;
        }
        if ((message instanceof MessageForText) || (message instanceof MessageForPic) || (message instanceof MessageForMixedMsg) || (i3 = message.msgtype) == -1035 || i3 == -2000 || i3 == -1000) {
            return true;
        }
        if (!e() || (!(message instanceof MessageForShortVideo) && !(message instanceof MessageForFile) && !(message instanceof MessageForTroopFile) && !l(message))) {
            return false;
        }
        return true;
    }

    private final boolean j(MessageRecord message) {
        int i3;
        if (message == null) {
            return false;
        }
        if ((message instanceof MessageForText) || (message instanceof MessageForPic) || (message instanceof MessageForMixedMsg) || (i3 = message.msgtype) == -1035 || i3 == -2000 || i3 == -1000) {
            return true;
        }
        if (!g() || (!(message instanceof MessageForArkApp) && !(message instanceof MessageForShortVideo) && !(message instanceof MessageForFile) && !(message instanceof MessageForTroopFile) && !l(message))) {
            return false;
        }
        return true;
    }

    private final boolean k() {
        return h();
    }

    @JvmStatic
    public static final boolean l(@Nullable MessageRecord message) {
        AbsStructMsg absStructMsg;
        if (message == null || !(message instanceof MessageForStructing) || (absStructMsg = ((MessageForStructing) message).structingMsg) == null || absStructMsg.mMsgServiceID != 35) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean m(@Nullable MessageRecord message) {
        int i3;
        if (d() && message != null && !message.isSend()) {
            String safetyMsgTypeString = message.getExtInfoFromExtStr("safety_msg_beat_type");
            if (TextUtils.isEmpty(safetyMsgTypeString)) {
                return false;
            }
            try {
                Intrinsics.checkNotNullExpressionValue(safetyMsgTypeString, "safetyMsgTypeString");
                i3 = Integer.parseInt(safetyMsgTypeString);
            } catch (NumberFormatException e16) {
                QLog.d("SafetyMsgUtils", 1, "isSafetyMsgFold: " + e16);
                i3 = 0;
            }
            if (i3 == 0) {
                return false;
            }
            if (i3 == 1 && f435470a.j(message)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SafetyMsgUtils", 2, "isSafetyMsgFold: true (FoldNotSpread) message: " + message.longMsgId);
                }
                return true;
            }
            if (i3 == 2 && f435470a.i(message)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SafetyMsgUtils", 2, "isSafetyMsgFold: true (FoldCanSpread) message: " + message.longMsgId);
                }
                return true;
            }
            if (i3 == 1 && f435470a.k()) {
                return true;
            }
        }
        return false;
    }
}
