package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleQsmOuterClass$YoloQSMBattleInfo extends MessageMicro<YoloBattleQsmOuterClass$YoloQSMBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82, 90, 800, 810}, new String[]{"status", "qsm_config", "qsm_schema", "create_info", "last_event_type", "last_event"}, new Object[]{1, null, null, null, 0, null}, YoloBattleQsmOuterClass$YoloQSMBattleInfo.class);
    public final PBEnumField status = PBField.initEnum(1);
    public YoloBattleQsmOuterClass$YoloQSMBattleConfig qsm_config = new YoloBattleQsmOuterClass$YoloQSMBattleConfig();
    public YoloBattleQsmOuterClass$YoloQSMSchema qsm_schema = new YoloBattleQsmOuterClass$YoloQSMSchema();
    public QsmDataOuterClass$QSMRoomCreatedEvent create_info = new QsmDataOuterClass$QSMRoomCreatedEvent();
    public final PBEnumField last_event_type = PBField.initEnum(0);
    public YoloBattleQsmOuterClass$YoloOneQSMBattleEvent last_event = new YoloBattleQsmOuterClass$YoloOneQSMBattleEvent();
}
