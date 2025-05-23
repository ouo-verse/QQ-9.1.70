package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleQsmOuterClass$YoloQSMBattleConfig extends MessageMicro<YoloBattleQsmOuterClass$YoloQSMBattleConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"game_mode", "room_type"}, new Object[]{0, 0}, YoloBattleQsmOuterClass$YoloQSMBattleConfig.class);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBInt32Field room_type = PBField.initInt32(0);
}
