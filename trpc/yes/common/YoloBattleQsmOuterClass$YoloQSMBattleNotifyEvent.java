package trpc.yes.common;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleQsmOuterClass$YoloQSMBattleNotifyEvent extends MessageMicro<YoloBattleQsmOuterClass$YoloQSMBattleNotifyEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{CGNonAgeReport.EVENT_TYPE, "event_time", "one_event", "qsm_config"}, new Object[]{0, 0, null, null}, YoloBattleQsmOuterClass$YoloQSMBattleNotifyEvent.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBUInt32Field event_time = PBField.initUInt32(0);
    public YoloBattleQsmOuterClass$YoloOneQSMBattleEvent one_event = new YoloBattleQsmOuterClass$YoloOneQSMBattleEvent();
    public YoloBattleQsmOuterClass$YoloQSMBattleConfig qsm_config = new YoloBattleQsmOuterClass$YoloQSMBattleConfig();
}
