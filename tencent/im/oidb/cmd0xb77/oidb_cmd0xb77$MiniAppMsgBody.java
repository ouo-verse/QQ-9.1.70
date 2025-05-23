package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$MiniAppMsgBody extends MessageMicro<oidb_cmd0xb77$MiniAppMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 82}, new String[]{"mini_app_appid", AppConstants.Key.THRIPARTY_PULL_MINI_APP_PATH, "web_page_url", AppConstants.Key.THRIPARTY_PULL_MINI_APP_TYPE, "title", "desc", "json_str"}, new Object[]{0L, "", "", 0, "", "", ""}, oidb_cmd0xb77$MiniAppMsgBody.class);
    public final PBUInt64Field mini_app_appid = PBField.initUInt64(0);
    public final PBStringField mini_app_path = PBField.initString("");
    public final PBStringField web_page_url = PBField.initString("");
    public final PBUInt32Field mini_app_type = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField json_str = PBField.initString("");
}
