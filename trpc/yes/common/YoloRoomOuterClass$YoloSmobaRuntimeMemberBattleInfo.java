package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloSmobaRuntimeMemberBattleInfo extends MessageMicro<YoloRoomOuterClass$YoloSmobaRuntimeMemberBattleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uid", "heroid", "killcnt", "deadcnt", "assistcnt"}, new Object[]{0L, 0, 0, 0, 0}, YoloRoomOuterClass$YoloSmobaRuntimeMemberBattleInfo.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field heroid = PBField.initUInt32(0);
    public final PBUInt32Field killcnt = PBField.initUInt32(0);
    public final PBUInt32Field deadcnt = PBField.initUInt32(0);
    public final PBUInt32Field assistcnt = PBField.initUInt32(0);
}
