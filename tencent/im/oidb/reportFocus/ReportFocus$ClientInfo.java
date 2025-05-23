package tencent.im.oidb.reportFocus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportFocus$ClientInfo extends MessageMicro<ReportFocus$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_product_id", "client_plat_id", "client_sub_plat"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, ReportFocus$ClientInfo.class);
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
    public final PBUInt32Field client_plat_id = PBField.initUInt32(0);
    public final PBBytesField client_sub_plat = PBField.initBytes(ByteStringMicro.EMPTY);
}
