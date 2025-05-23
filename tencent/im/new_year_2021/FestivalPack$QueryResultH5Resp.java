package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$QueryResultH5Resp extends MessageMicro<FestivalPack$QueryResultH5Resp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24, 32, 40, 64}, new String[]{"problem_succ_num", "money_num", "gift_num", "defeat_ratio"}, new Object[]{0, 0, 0, 0}, FestivalPack$QueryResultH5Resp.class);
    public final PBUInt32Field problem_succ_num = PBField.initUInt32(0);
    public final PBUInt32Field money_num = PBField.initUInt32(0);
    public final PBUInt32Field gift_num = PBField.initUInt32(0);
    public final PBUInt32Field defeat_ratio = PBField.initUInt32(0);
}
