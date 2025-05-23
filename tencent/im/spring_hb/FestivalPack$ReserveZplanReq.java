package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$ReserveZplanReq extends MessageMicro<FestivalPack$ReserveZplanReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"from_id"}, new Object[]{0}, FestivalPack$ReserveZplanReq.class);
    public final PBUInt32Field from_id = PBField.initUInt32(0);
}
