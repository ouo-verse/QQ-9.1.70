package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$UpdateProcessResp extends MessageMicro<FestivalPack$UpdateProcessResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"pack_cnt"}, new Object[]{0}, FestivalPack$UpdateProcessResp.class);
    public final PBUInt32Field pack_cnt = PBField.initUInt32(0);
}
