package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$GroupRobotChangeNotify extends MessageMicro<TroopTips0x857$GroupRobotChangeNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"group_id", "add_user_uids", "exit_user_uids", "user_change"}, new Object[]{0L, "", "", 0}, TroopTips0x857$GroupRobotChangeNotify.class);
    public final PBRepeatField<String> add_user_uids;
    public final PBRepeatField<String> exit_user_uids;
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field user_change;

    public TroopTips0x857$GroupRobotChangeNotify() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.add_user_uids = PBField.initRepeat(pBStringField);
        this.exit_user_uids = PBField.initRepeat(pBStringField);
        this.user_change = PBField.initUInt32(0);
    }
}
