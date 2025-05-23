package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopJoinQunAutoSwitch$CheckGroupsRsp extends MessageMicro<TroopJoinQunAutoSwitch$CheckGroupsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"name_wrong_group", "binded_groups", "source_groups", "binded_master_groups", "binded_sub_groups", "unsafe_groups"}, new Object[]{"", "", "", "", null, ""}, TroopJoinQunAutoSwitch$CheckGroupsRsp.class);
    public final PBRepeatField<String> binded_groups;
    public final PBRepeatField<String> binded_master_groups;
    public final PBRepeatMessageField<TroopJoinQunAutoSwitch$BindedSubGroup> binded_sub_groups;
    public final PBRepeatField<String> name_wrong_group;
    public final PBRepeatField<String> source_groups;
    public final PBRepeatField<String> unsafe_groups;

    public TroopJoinQunAutoSwitch$CheckGroupsRsp() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.name_wrong_group = PBField.initRepeat(pBStringField);
        this.binded_groups = PBField.initRepeat(pBStringField);
        this.source_groups = PBField.initRepeat(pBStringField);
        this.binded_master_groups = PBField.initRepeat(pBStringField);
        this.binded_sub_groups = PBField.initRepeatMessage(TroopJoinQunAutoSwitch$BindedSubGroup.class);
        this.unsafe_groups = PBField.initRepeat(pBStringField);
    }
}
