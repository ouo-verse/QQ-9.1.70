package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BroadcastMsgCtr$ExtGroupInfo extends MessageMicro<BroadcastMsgCtr$ExtGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext_join_group_info"}, new Object[]{null}, BroadcastMsgCtr$ExtGroupInfo.class);
    public BroadcastMsgCtr$ExtJoinGroupInfo ext_join_group_info = new MessageMicro<BroadcastMsgCtr$ExtJoinGroupInfo>() { // from class: tencent.im.group.broadcast.BroadcastMsgCtr$ExtJoinGroupInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"enmum_join_group_type", "uint64_share_uin"}, new Object[]{1, 0L}, BroadcastMsgCtr$ExtJoinGroupInfo.class);
        public final PBEnumField enmum_join_group_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_share_uin = PBField.initUInt64(0);
    };
}
