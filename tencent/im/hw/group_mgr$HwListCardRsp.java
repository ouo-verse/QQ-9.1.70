package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$HwListCardRsp extends MessageMicro<group_mgr$HwListCardRsp> {
    public static final int CARD_INFO_FIELD_NUMBER = 1;
    public static final int LEVEL_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"card_info", ProfileVipReport.LEVEL_MODULE_ID}, new Object[]{null, null}, group_mgr$HwListCardRsp.class);
    public final PBRepeatMessageField<group_mgr$CardInfo> card_info = PBField.initRepeatMessage(group_mgr$CardInfo.class);
    public group_mgr$LevelInfo level_info = new MessageMicro<group_mgr$LevelInfo>() { // from class: tencent.im.hw.group_mgr$LevelInfo
        public static final int LEVELS_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"levels"}, new Object[]{null}, group_mgr$LevelInfo.class);
        public final PBRepeatMessageField<LevelName> levels = PBField.initRepeatMessage(LevelName.class);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class LevelName extends MessageMicro<LevelName> {
            public static final int LEVEL_FIELD_NUMBER = 1;
            public static final int NAME_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"level", "name"}, new Object[]{0, ""}, LevelName.class);
            public final PBUInt32Field level = PBField.initUInt32(0);
            public final PBStringField name = PBField.initString("");
        }
    };
}
