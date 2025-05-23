package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackReport$ReportElem extends MessageMicro<PackReport$ReportElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"timestamp", "count"}, new Object[]{0L, 0L}, PackReport$ReportElem.class);
    public final PBUInt64Field timestamp = PBField.initUInt64(0);
    public final PBUInt64Field count = PBField.initUInt64(0);
}
