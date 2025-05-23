package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51c$ReqBody extends MessageMicro<oidb_0x51c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"opt_uint64_handled_uin", "opt_msg_office_noticevar", "rpt_msg_app_noticevar"}, new Object[]{0L, null, null}, oidb_0x51c$ReqBody.class);
    public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0);
    public oidb_0x51c$NoticeVar opt_msg_office_noticevar = new oidb_0x51c$NoticeVar();
    public final PBRepeatMessageField<oidb_0x51c$AppNoticeVar> rpt_msg_app_noticevar = PBField.initRepeatMessage(oidb_0x51c$AppNoticeVar.class);
}
