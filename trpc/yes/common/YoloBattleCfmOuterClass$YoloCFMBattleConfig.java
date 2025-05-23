package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleCfmOuterClass$YoloCFMBattleConfig extends MessageMicro<YoloBattleCfmOuterClass$YoloCFMBattleConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"play_mode", "map_id", "match_type"}, new Object[]{0, 0, 0}, YoloBattleCfmOuterClass$YoloCFMBattleConfig.class);
    public final PBInt32Field play_mode = PBField.initInt32(0);
    public final PBInt32Field map_id = PBField.initInt32(0);
    public final PBInt32Field match_type = PBField.initInt32(0);
}
