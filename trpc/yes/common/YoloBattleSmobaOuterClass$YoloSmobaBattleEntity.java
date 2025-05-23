package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaBattleEntity extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleEntity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"desk_id", "relay_entity", "desk_seq"}, new Object[]{0, 0, 0}, YoloBattleSmobaOuterClass$YoloSmobaBattleEntity.class);
    public final PBUInt32Field desk_id = PBField.initUInt32(0);
    public final PBUInt32Field relay_entity = PBField.initUInt32(0);
    public final PBUInt32Field desk_seq = PBField.initUInt32(0);
}
