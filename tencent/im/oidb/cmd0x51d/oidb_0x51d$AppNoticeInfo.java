package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51d$AppNoticeInfo extends MessageMicro<oidb_0x51d$AppNoticeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"opt_uint64_appdid", "opt_msg_app_notice"}, new Object[]{0L, null}, oidb_0x51d$AppNoticeInfo.class);
    public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0);
    public oidb_0x51d$NoticeInfo opt_msg_app_notice = new oidb_0x51d$NoticeInfo();
}
