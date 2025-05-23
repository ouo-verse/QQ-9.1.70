package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackReport$PkgReq extends MessageMicro<PackReport$PkgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uin", "promotion_id", "report", "seq"}, new Object[]{0L, 0, null, 0L}, PackReport$PkgReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<PackReport$Report> report = PBField.initRepeatMessage(PackReport$Report.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
}
