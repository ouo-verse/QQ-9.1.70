package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopJoinQunAutoSwitch$AddSubGroupsRsp extends MessageMicro<TroopJoinQunAutoSwitch$AddSubGroupsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"master", "sub_groups"}, new Object[]{null, null}, TroopJoinQunAutoSwitch$AddSubGroupsRsp.class);
    public TroopJoinQunAutoSwitch$Group master = new MessageMicro<TroopJoinQunAutoSwitch$Group>() { // from class: tencent.trpcprotocol.TroopJoinQunAutoSwitch$Group
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"id", "name", "member_num", "member_max_num"}, new Object[]{"", "", 0L, 0L}, TroopJoinQunAutoSwitch$Group.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f436070id = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBInt64Field member_num = PBField.initInt64(0);
        public final PBInt64Field member_max_num = PBField.initInt64(0);
    };
    public final PBRepeatMessageField<TroopJoinQunAutoSwitch$Group> sub_groups = PBField.initRepeatMessage(TroopJoinQunAutoSwitch$Group.class);
}
