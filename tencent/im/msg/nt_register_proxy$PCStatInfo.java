package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class nt_register_proxy$PCStatInfo extends MessageMicro<nt_register_proxy$PCStatInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"support_dataline", "support_print", "support_view_pc_file", "pc_version"}, new Object[]{0, 0, 0, 0}, nt_register_proxy$PCStatInfo.class);
    public final PBInt32Field support_dataline = PBField.initInt32(0);
    public final PBInt32Field support_print = PBField.initInt32(0);
    public final PBInt32Field support_view_pc_file = PBField.initInt32(0);
    public final PBInt32Field pc_version = PBField.initInt32(0);
}
