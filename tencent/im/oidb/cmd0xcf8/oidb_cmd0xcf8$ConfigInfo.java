package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcf8$ConfigInfo extends MessageMicro<oidb_cmd0xcf8$ConfigInfo> {
    public static final int LOCAL_EVENT = 3;
    public static final int NEED_UIN = 1;
    public static final int NO_AUTH = 0;
    public static final int PACF_FLOD_IN_ASSISTANT = 5;
    public static final int PACF_MSG_SETTING = 6;
    public static final int PACF_RECV_EMAIL_NOTIF = 2;
    public static final int PACF_RECV_LBS_MSG = 3;
    public static final int PACF_RECV_MSG = 1;
    public static final int PACF_RECV_MSG_NOTIF = 4;
    public static final int RICH_PIC_TEXT = 5;
    public static final int RICH_TEXT = 4;
    public static final int STATE_CHANGE = 2;
    public static final int WEBVIEW = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 56, 64, 74, 80}, new String[]{"type", "title", "content", "event_id", "url", StartupReportKey.AUTH_TYPE, "state", "confirm_flag", "confirm_tips", "state_id"}, new Object[]{1, "", "", 1, "", 0, 0, 0, "", 1}, oidb_cmd0xcf8$ConfigInfo.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBEnumField event_id = PBField.initEnum(1);
    public final PBStringField url = PBField.initString("");
    public final PBEnumField auth_type = PBField.initEnum(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field confirm_flag = PBField.initUInt32(0);
    public final PBStringField confirm_tips = PBField.initString("");
    public final PBEnumField state_id = PBField.initEnum(1);
}
