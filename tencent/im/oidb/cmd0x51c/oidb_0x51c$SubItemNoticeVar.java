package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51c$SubItemNoticeVar extends MessageMicro<oidb_0x51c$SubItemNoticeVar> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"opt_uint32_subitem_id", "opt_msg_subitem_noticevar"}, new Object[]{0, null}, oidb_0x51c$SubItemNoticeVar.class);
    public final PBUInt32Field opt_uint32_subitem_id = PBField.initUInt32(0);
    public oidb_0x51c$NoticeVar opt_msg_subitem_noticevar = new oidb_0x51c$NoticeVar();
}
