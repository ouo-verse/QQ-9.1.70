package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51c$AppNoticeVar extends MessageMicro<oidb_0x51c$AppNoticeVar> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"opt_uint64_appdid", "opt_msg_app_noticevar", "rpt_msg_subitem_noticevar"}, new Object[]{0L, null, null}, oidb_0x51c$AppNoticeVar.class);
    public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0);
    public oidb_0x51c$NoticeVar opt_msg_app_noticevar = new oidb_0x51c$NoticeVar();
    public final PBRepeatMessageField<oidb_0x51c$SubItemNoticeVar> rpt_msg_subitem_noticevar = PBField.initRepeatMessage(oidb_0x51c$SubItemNoticeVar.class);
}
