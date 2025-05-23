package z61;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    public static void a(BaseActivity baseActivity, boolean z16) {
        Intent intent;
        if (baseActivity != null && !z16 && (intent = baseActivity.getIntent()) != null && intent.getBooleanExtra("flag_open_up_coming_list", false)) {
            intent.removeExtra("flag_open_up_coming_list");
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).showListFromAddTodo(baseActivity, true);
        }
    }

    private static long b(ColorNote colorNote, int i3) {
        try {
            String[] e16 = e(colorNote);
            if (e16 == null || e16.length <= 0 || i3 >= e16.length) {
                return 0L;
            }
            return Long.valueOf(e16[i3]).longValue();
        } catch (Exception e17) {
            QLog.d("UpComingMsgLogic.", 1, "parseMindTimeFromEntity error!", e17);
            return 0L;
        }
    }

    public static UpComingMsgModel c(ColorNote colorNote) {
        if (colorNote != null && colorNote.getServiceType() == 17235968) {
            String str = new String(colorNote.getReserve());
            UpComingMsgModel upComingMsgModel = new UpComingMsgModel();
            upComingMsgModel.parseFromJson(str);
            return upComingMsgModel;
        }
        return new UpComingMsgModel();
    }

    public static int d(AIOMsgItem aIOMsgItem) {
        if (aIOMsgItem == null) {
            return 7;
        }
        int msgType = aIOMsgItem.getMsgRecord().getMsgType();
        if (com.tencent.mobileqq.aio.utils.d.Z(aIOMsgItem)) {
            if (!aIOMsgItem.getMsgRecord().getEmojiLikesList().isEmpty()) {
                return 12;
            }
            return 1;
        }
        if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
            return 2;
        }
        if (com.tencent.mobileqq.aio.utils.d.u(aIOMsgItem.getMsgRecord())) {
            return g(aIOMsgItem);
        }
        if (msgType == 6) {
            return 3;
        }
        if (com.tencent.mobileqq.aio.utils.d.E(aIOMsgItem)) {
            return 4;
        }
        if (msgType == 3) {
            return h(aIOMsgItem);
        }
        if (aIOMsgItem.getMsgRecord().getMsgType() == 4) {
            return 6;
        }
        if (aIOMsgItem.getMsgRecord().getMsgType() != 8) {
            return 7;
        }
        return 11;
    }

    private static String[] e(ColorNote colorNote) {
        String[] strArr = new String[0];
        if (colorNote != null) {
            String subType = colorNote.getSubType();
            if (!TextUtils.isEmpty(subType)) {
                String[] split = subType.split("_");
                if (split.length == 2) {
                    return split;
                }
                return strArr;
            }
            return strArr;
        }
        return strArr;
    }

    public static String f(QQAppInterface qQAppInterface, AIOMsgItem aIOMsgItem) {
        String description;
        FileElement fileElement;
        if (aIOMsgItem == null) {
            if (qQAppInterface == null) {
                return "";
            }
            return qQAppInterface.getCurrentAccountUin();
        }
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        int msgType = msgRecord.getMsgType();
        if (aIOMsgItem.getDescription().equals("unknown msg")) {
            description = "[\u6d88\u606f]";
        } else {
            description = aIOMsgItem.getDescription();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UpComingMsgLogic.UpComingMsgUtil", 2, "message type = " + msgRecord.getMsgType() + ", default result = " + description);
        }
        if (com.tencent.mobileqq.aio.utils.d.Z(aIOMsgItem)) {
            CharSequence textFromMsgItem = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getTextFromMsgItem(aIOMsgItem);
            if (textFromMsgItem != null) {
                return k(String.valueOf(textFromMsgItem));
            }
            return description;
        }
        if (aIOMsgItem.getViewType() != 5 && aIOMsgItem.getViewType() != 4) {
            if (msgRecord.getMsgType() == 6) {
                return "[\u8bed\u97f3]";
            }
            if (msgType == 3) {
                MsgElement firstTypeElement = aIOMsgItem.getFirstTypeElement(3);
                if (firstTypeElement != null) {
                    fileElement = firstTypeElement.getFileElement();
                } else {
                    fileElement = null;
                }
                if (fileElement == null || fileElement.getFileName().isEmpty()) {
                    return GuildMsgElementApiImpl.DESC_ELEMENT_FILE;
                }
                return GuildMsgElementApiImpl.DESC_ELEMENT_FILE + fileElement.getFileName();
            }
            if (com.tencent.mobileqq.aio.utils.d.d0(aIOMsgItem)) {
                return "[\u89c6\u9891]";
            }
            if (com.tencent.mobileqq.aio.utils.d.H(aIOMsgItem)) {
                return "[\u804a\u5929\u8bb0\u5f55]";
            }
            if (com.tencent.mobileqq.aio.utils.d.u(msgRecord)) {
                return StructMsgForImageShare.BRIEF_PREFIX;
            }
            return description;
        }
        return GuildMsgElementApiImpl.DESC_ELEMENT_PIC;
    }

    private static int g(AIOMsgItem aIOMsgItem) {
        com.tencent.qqnt.msg.data.a parseArkModel;
        int i3 = 6;
        if (aIOMsgItem == null || (parseArkModel = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).parseArkModel(aIOMsgItem)) == null) {
            return 6;
        }
        String d16 = parseArkModel.d();
        String e16 = parseArkModel.e();
        if (TextUtils.isEmpty(d16) || TextUtils.isEmpty(e16)) {
            return 6;
        }
        if ("com.tencent.map".equals(d16)) {
            i3 = 10;
        }
        if ("com.tencent.miniapp_01".equals(d16) || ("com.tencent.structmsg".equals(d16) && "news".equals(e16))) {
            return 9;
        }
        return i3;
    }

    private static int h(AIOMsgItem aIOMsgItem) {
        if (aIOMsgItem.getViewType() == 0) {
            return 2;
        }
        return 5;
    }

    public static long i(ColorNote colorNote) {
        long b16 = b(colorNote, 0);
        if (b16 == 0) {
            return System.currentTimeMillis() + 1000;
        }
        return b16;
    }

    public static String j(long j3) {
        return j3 + "_" + System.currentTimeMillis();
    }

    private static String k(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        return new QQText(str, 5).toPlainText(false);
    }
}
