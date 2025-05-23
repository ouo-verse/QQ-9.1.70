package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$QueryQualificationReq extends MessageMicro<FestivalPack$QueryQualificationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"promotion_id"}, new Object[]{0}, FestivalPack$QueryQualificationReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
}
