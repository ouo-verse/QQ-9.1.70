package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupOpenSysMsg$SysMsgBody extends MessageMicro<GroupOpenSysMsg$SysMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58}, new String[]{"group_id", "appid", "sender", QQHealthReportApiImpl.MSG_TYPE_KEY, "content", "rich_msg", "light_app"}, new Object[]{0L, 0L, null, 0, "", null, null}, GroupOpenSysMsg$SysMsgBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public GroupOpenSysMsg$Sender sender = new GroupOpenSysMsg$Sender();
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public GroupOpenSysMsg$RichMsg rich_msg = new MessageMicro<GroupOpenSysMsg$RichMsg>() { // from class: tencent.im.oidb.cmd0x857.GroupOpenSysMsg$RichMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"title", "desc", "brief", "cover", "url", "source"}, new Object[]{"", "", "", "", "", null}, GroupOpenSysMsg$RichMsg.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBStringField brief = PBField.initString("");
        public final PBStringField cover = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public GroupOpenSysMsg$Source source = new GroupOpenSysMsg$Source();
    };
    public GroupOpenSysMsg$LightApp light_app = new GroupOpenSysMsg$LightApp();
}
