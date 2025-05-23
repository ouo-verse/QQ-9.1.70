package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51d$RspBody extends MessageMicro<oidb_0x51d$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"opt_uint32_result", "opt_bytes_errinfo", "opt_msg_office_notice_rsp", "opt_msg_app_notice_rsp", "opt_msg_subitem_notice_rsp"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, null}, oidb_0x51d$RspBody.class);
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    public final PBBytesField opt_bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x51d$GetOfficeNoticeRsp opt_msg_office_notice_rsp = new MessageMicro<oidb_0x51d$GetOfficeNoticeRsp>() { // from class: tencent.im.oidb.cmd0x51d.oidb_0x51d$GetOfficeNoticeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"opt_msg_office_notice"}, new Object[]{null}, oidb_0x51d$GetOfficeNoticeRsp.class);
        public oidb_0x51d$NoticeInfo opt_msg_office_notice = new oidb_0x51d$NoticeInfo();
    };
    public oidb_0x51d$GetAppNoticeRsp opt_msg_app_notice_rsp = new MessageMicro<oidb_0x51d$GetAppNoticeRsp>() { // from class: tencent.im.oidb.cmd0x51d.oidb_0x51d$GetAppNoticeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_app_notice"}, new Object[]{null}, oidb_0x51d$GetAppNoticeRsp.class);
        public final PBRepeatMessageField<oidb_0x51d$AppNoticeInfo> rpt_msg_app_notice = PBField.initRepeatMessage(oidb_0x51d$AppNoticeInfo.class);
    };
    public oidb_0x51d$GetSubItemNoticeRsp opt_msg_subitem_notice_rsp = new MessageMicro<oidb_0x51d$GetSubItemNoticeRsp>() { // from class: tencent.im.oidb.cmd0x51d.oidb_0x51d$GetSubItemNoticeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"opt_uint64_appdid", "rpt_msg_subitem_notice"}, new Object[]{0L, null}, oidb_0x51d$GetSubItemNoticeRsp.class);
        public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0);
        public final PBRepeatMessageField<oidb_0x51d$SubItemNoticeInfo> rpt_msg_subitem_notice = PBField.initRepeatMessage(oidb_0x51d$SubItemNoticeInfo.class);
    };
}
