package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$GetFlameDetailRsp extends MessageMicro<IqunFlameManageSvrPB$GetFlameDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 66, 72}, new String[]{"group_name", "group_icon", "active_days", "active_member", "self_rank", "global_rank", TransferConfig.ExtendParamFloats.KEY_RULE, "members", "member_cnt"}, new Object[]{"", "", 0, 0, 0, 0, null, "", 0}, IqunFlameManageSvrPB$GetFlameDetailRsp.class);
    public final PBStringField group_name = PBField.initString("");
    public final PBStringField group_icon = PBField.initString("");
    public final PBUInt32Field active_days = PBField.initUInt32(0);
    public final PBUInt32Field active_member = PBField.initUInt32(0);
    public final PBUInt32Field self_rank = PBField.initUInt32(0);
    public final PBUInt32Field global_rank = PBField.initUInt32(0);
    public IqunFlameManageSvrPB$Rule rule = new IqunFlameManageSvrPB$Rule();
    public final PBRepeatField<String> members = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field member_cnt = PBField.initUInt32(0);
}
