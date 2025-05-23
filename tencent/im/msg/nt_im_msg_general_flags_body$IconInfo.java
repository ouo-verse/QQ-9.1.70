package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_general_flags_body$IconInfo extends MessageMicro<nt_im_msg_general_flags_body$IconInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_res_id", "uint32_expired_time", "uint32_permission_switch", "uint32_biz_id"}, new Object[]{0, 0, 0, 0}, nt_im_msg_general_flags_body$IconInfo.class);
    public final PBUInt32Field uint32_res_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_permission_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biz_id = PBField.initUInt32(0);
}
