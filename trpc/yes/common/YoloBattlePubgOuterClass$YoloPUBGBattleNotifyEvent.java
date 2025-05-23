package trpc.yes.common;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes30.dex */
public final class YoloBattlePubgOuterClass$YoloPUBGBattleNotifyEvent extends MessageMicro<YoloBattlePubgOuterClass$YoloPUBGBattleNotifyEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{CGNonAgeReport.EVENT_TYPE, "event_time", "one_event", "pubg_config"}, new Object[]{0, 0, null, null}, YoloBattlePubgOuterClass$YoloPUBGBattleNotifyEvent.class);
    public final PBEnumField event_type = PBField.initEnum(0);
    public final PBUInt32Field event_time = PBField.initUInt32(0);
    public YoloBattlePubgOuterClass$YoloOnePUBGBattleEvent one_event = new YoloBattlePubgOuterClass$YoloOnePUBGBattleEvent();
    public YoloBattlePubgOuterClass$YoloPUBGBattleConfig pubg_config = new YoloBattlePubgOuterClass$YoloPUBGBattleConfig();
}
