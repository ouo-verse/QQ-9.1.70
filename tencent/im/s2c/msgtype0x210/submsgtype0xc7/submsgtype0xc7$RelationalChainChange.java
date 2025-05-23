package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc7$RelationalChainChange extends MessageMicro<submsgtype0xc7$RelationalChainChange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 162, 320, 800}, new String[]{"uint64_appid", "uint64_src_uin", "uint64_dst_uin", "uint32_change_type", "msg_relational_chain_info_old", "msg_relational_chain_info_new", "msg_to_degrade_info", "rpt_relational_chain_infos", "uint64_trigger_uin", "rpt_uint32_feature_id"}, new Object[]{0L, 0L, 0L, 1, null, null, null, null, 0L, 0}, submsgtype0xc7$RelationalChainChange.class);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBEnumField uint32_change_type = PBField.initEnum(1);
    public submsgtype0xc7$RelationalChainInfo msg_relational_chain_info_old = new submsgtype0xc7$RelationalChainInfo();
    public submsgtype0xc7$RelationalChainInfo msg_relational_chain_info_new = new submsgtype0xc7$RelationalChainInfo();
    public submsgtype0xc7$ToDegradeInfo msg_to_degrade_info = new submsgtype0xc7$ToDegradeInfo();
    public final PBRepeatMessageField<submsgtype0xc7$RelationalChainInfos> rpt_relational_chain_infos = PBField.initRepeatMessage(submsgtype0xc7$RelationalChainInfos.class);
    public final PBUInt64Field uint64_trigger_uin = PBField.initUInt64(0);
    public final PBRepeatField<Integer> rpt_uint32_feature_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
