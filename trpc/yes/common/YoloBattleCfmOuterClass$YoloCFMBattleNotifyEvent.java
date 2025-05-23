package trpc.yes.common;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleCfmOuterClass$YoloCFMBattleNotifyEvent extends MessageMicro<YoloBattleCfmOuterClass$YoloCFMBattleNotifyEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{CGNonAgeReport.EVENT_TYPE, "event_time", "one_event", "cfm_config"}, new Object[]{0, 0, null, null}, YoloBattleCfmOuterClass$YoloCFMBattleNotifyEvent.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBUInt32Field event_time = PBField.initUInt32(0);
    public YoloBattleCfmOuterClass$YoloOneCFMBattleEvent one_event = new YoloBattleCfmOuterClass$YoloOneCFMBattleEvent();
    public YoloBattleCfmOuterClass$YoloCFMBattleConfig cfm_config = new YoloBattleCfmOuterClass$YoloCFMBattleConfig();
}
