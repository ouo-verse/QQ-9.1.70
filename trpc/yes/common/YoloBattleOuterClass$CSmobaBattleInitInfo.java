package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$CSmobaBattleInitInfo extends MessageMicro<YoloBattleOuterClass$CSmobaBattleInitInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"flag", "yolo_battle_id", "smoba_schema", "battle_start_tm"}, new Object[]{0, 0L, null, 0L}, YoloBattleOuterClass$CSmobaBattleInitInfo.class);
    public final PBInt32Field flag = PBField.initInt32(0);
    public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
    public YoloBattleSmobaOuterClass$YoloSmobaSchema smoba_schema = new YoloBattleSmobaOuterClass$YoloSmobaSchema();
    public final PBInt64Field battle_start_tm = PBField.initInt64(0);
}
