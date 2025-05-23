package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackReport$Report extends MessageMicro<PackReport$Report> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "elems"}, new Object[]{0L, null}, PackReport$Report.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435963id = PBField.initUInt64(0);
    public final PBRepeatMessageField<PackReport$ReportElem> elems = PBField.initRepeatMessage(PackReport$ReportElem.class);
}
