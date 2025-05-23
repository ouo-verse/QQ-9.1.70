package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$NewYearEvePackReq extends MessageMicro<FestivalPack$NewYearEvePackReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"promotion_id", "action", "condition", "network", "business_id"}, new Object[]{0, 0, 0, 0, 0}, FestivalPack$NewYearEvePackReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBUInt32Field condition = PBField.initUInt32(0);
    public final PBUInt32Field network = PBField.initUInt32(0);
    public final PBUInt32Field business_id = PBField.initUInt32(0);
}
