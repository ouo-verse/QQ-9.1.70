package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$ActiveReportReq extends MessageMicro<FestivalPack$ActiveReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"act_id", "data", "int_data"}, new Object[]{0, "", 0}, FestivalPack$ActiveReportReq.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public final PBStringField data = PBField.initString("");
    public final PBUInt32Field int_data = PBField.initUInt32(0);
}
