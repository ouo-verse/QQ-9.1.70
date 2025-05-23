package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$QueryEvePackReq extends MessageMicro<FestivalPack$QueryEvePackReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"promotion_id", "pack_count"}, new Object[]{0, 0}, FestivalPack$QueryEvePackReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field pack_count = PBField.initUInt32(0);
}
