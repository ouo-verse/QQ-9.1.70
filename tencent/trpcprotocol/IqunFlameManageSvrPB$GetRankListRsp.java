package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class IqunFlameManageSvrPB$GetRankListRsp extends MessageMicro<IqunFlameManageSvrPB$GetRankListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"groups", "cur_group"}, new Object[]{null, null}, IqunFlameManageSvrPB$GetRankListRsp.class);
    public final PBRepeatMessageField<IqunFlameManageSvrPB$GroupItem> groups = PBField.initRepeatMessage(IqunFlameManageSvrPB$GroupItem.class);
    public IqunFlameManageSvrPB$GroupItem cur_group = new MessageMicro<IqunFlameManageSvrPB$GroupItem>() { // from class: tencent.trpcprotocol.IqunFlameManageSvrPB$GroupItem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"group_code", "rank", "nick", "head", "active_days"}, new Object[]{0L, 0, "", "", 0}, IqunFlameManageSvrPB$GroupItem.class);
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt32Field rank = PBField.initUInt32(0);
        public final PBStringField nick = PBField.initString("");
        public final PBStringField head = PBField.initString("");
        public final PBUInt32Field active_days = PBField.initUInt32(0);
    };
}
