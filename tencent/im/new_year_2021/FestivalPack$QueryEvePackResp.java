package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$QueryEvePackResp extends MessageMicro<FestivalPack$QueryEvePackResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"pack_count", "pack"}, new Object[]{0, null}, FestivalPack$QueryEvePackResp.class);
    public final PBUInt32Field pack_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<Pack2021$Pack> pack = PBField.initRepeatMessage(Pack2021$Pack.class);
}
