package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$ConvertCouponReq extends MessageMicro<FestivalPack$ConvertCouponReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"fragment_pack_ids", "scene"}, new Object[]{"", 0}, FestivalPack$ConvertCouponReq.class);
    public final PBRepeatField<String> fragment_pack_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field scene = PBField.initUInt32(0);
}
