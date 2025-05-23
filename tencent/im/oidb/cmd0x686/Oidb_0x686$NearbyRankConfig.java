package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x686$NearbyRankConfig extends MessageMicro<Oidb_0x686$NearbyRankConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_rank_sw", "rpt_msg_title_configs"}, new Object[]{0, null}, Oidb_0x686$NearbyRankConfig.class);
    public final PBUInt32Field uint32_rank_sw = PBField.initUInt32(0);
    public final PBRepeatMessageField<Oidb_0x686$RankTitleConfig> rpt_msg_title_configs = PBField.initRepeatMessage(Oidb_0x686$RankTitleConfig.class);
}
